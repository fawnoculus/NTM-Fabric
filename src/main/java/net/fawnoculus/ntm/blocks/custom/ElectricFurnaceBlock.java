package net.fawnoculus.ntm.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.blocks.entities.ElectricFurnaceBE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElectricFurnaceBlock extends BlockWithEntity {
    public static final BooleanProperty LIT = Properties.LIT;
    public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;
    public ElectricFurnaceBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState()
          .with(LIT, false)
          .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(ElectricFurnaceBlock::new);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ElectricFurnaceBE(pos, state);
    }

    @Override
    protected void onStateReplaced(@NotNull BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
        world.updateComparators(pos, this);
        super.onStateReplaced(state, world, pos, moved);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient()) return null;
        return validateTicker(type, NTMBlockEntities.ELECTRIC_FURNACE_BE, ElectricFurnaceBE::tick);
    }

    @Override
    protected ActionResult onUse(BlockState state, @NotNull World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!(world.getBlockEntity(pos) instanceof ElectricFurnaceBE electricFurnaceBE)) {
            return ActionResult.FAIL;
        }
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        player.openHandledScreen(electricFurnaceBE);

        return ActionResult.SUCCESS_SERVER;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        if (context.getPlayer() != null) {
            return this.getDefaultState().with(FACING, context.getPlayer().getHorizontalFacing().getOpposite());
        }
        return this.getDefaultState();
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!world.isClient()) {
            return;
        }

        if (!state.get(LIT)) {
            return;
        }


        double x = pos.getX();
        double y = pos.getY() + 0.1 + random.nextDouble() * 0.4;
        double z = pos.getZ();
        switch (state.get(AlloyFurnaceBlock.FACING)) {
            case Direction.NORTH -> {
                x += 0.3 + random.nextDouble() * 0.4;
                z -= 0.1;
            }
            case Direction.EAST -> {
                x += 1.1;
                z += 0.3 + random.nextDouble() * 0.4;
            }
            case Direction.WEST -> {
                x -= 0.1;
                z += 0.3 + random.nextDouble() * 0.4;
            }
            case Direction.SOUTH -> {
                x += 0.3 + random.nextDouble() * 0.4;
                z += 1.1;
            }
        }
        world.addParticleClient(ParticleTypes.FLAME, x, y, z, 0.0, 0.0, 0.0);
        world.addParticleClient(ParticleTypes.SMOKE, x, y, z, 0.0, 0.0, 0.0);
    }
}
