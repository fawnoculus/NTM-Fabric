package net.fawnoculus.ntm.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.blocks.NTMBlockProperties;
import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceBE;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
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
import org.jetbrains.annotations.Nullable;


public class AlloyFurnaceBlock extends BlockWithEntity {
  public AlloyFurnaceBlock(Settings settings) {
    super(settings);
    setDefaultState(this.getDefaultState()
        .with(LIT, false)
        .with(EXTENSION, false)
        .with(FACING, Direction.NORTH));
  }
  public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;
  public static final BooleanProperty LIT = Properties.LIT;
  public static final BooleanProperty EXTENSION = NTMBlockProperties.EXTENSION;
  
  @Override
  protected MapCodec<? extends BlockWithEntity> getCodec() {
    return createCodec(AlloyFurnaceBlock::new);
  }
  
  @Override
  public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new AlloyFurnaceBE(pos, state);
  }
  
  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
    if(world.isClient) return null;
    return validateTicker(type, NTMBlockEntities.ALLOY_FURNACE_BE, AlloyFurnaceBE::tick);
  }
  
  @Override
  protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
    if (!(world.getBlockEntity(pos) instanceof AlloyFurnaceBE alloyFurnaceBE)) {
      return ActionResult.FAIL;
    }
    if(world.isClient){
      return ActionResult.SUCCESS;
    }
    
    player.openHandledScreen(alloyFurnaceBE);
    
    return ActionResult.SUCCESS_SERVER;
  }
  
  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING);
    builder.add(LIT);
    builder.add(EXTENSION);
  }
  
  @Override
  public BlockState getPlacementState(ItemPlacementContext context) {
    if(context.getPlayer() == null) return this.getDefaultState();
    if(context.getWorld().getBlockState(context.getBlockPos().up()).getBlock() instanceof AlloyFurnaceExtensionBlock){
      return this.getDefaultState()
          .with(FACING, context.getPlayer().getHorizontalFacing().getOpposite())
          .with(EXTENSION, true);
    }
    return this.getDefaultState().with(FACING, context.getPlayer().getHorizontalFacing().getOpposite());
  }
  
  @Override
  public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
    if (!world.isClient()) {
      return;
    }
    
    if (!state.get(LIT)) {
      return;
    }
    
    double y = pos.getY() + 1;
    if (state.get(EXTENSION)) y += 1;
    double x = pos.getX();
    if (x > -1) {
      x += 0.5;
    } else {
      x -= 0.5;
    }
    double z = pos.getZ();
    if (z > -1) {
      z += 0.5;
    } else {
      z -= 0.5;
    }
    world.addParticleClient(ParticleTypes.SMOKE, x, y, z, 0.0, 0.0, 0.0);
    
    x = pos.getX();
    y = pos.getY() + 0.3 + random.nextDouble() * 0.4;
    z = pos.getZ();
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
  }
}
