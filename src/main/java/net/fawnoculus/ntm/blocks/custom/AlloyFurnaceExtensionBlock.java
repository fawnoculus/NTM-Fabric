package net.fawnoculus.ntm.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceExtensionBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;


public class AlloyFurnaceExtensionBlock extends Block implements EntityBlock {
    public AlloyFurnaceExtensionBlock(Properties settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AlloyFurnaceExtensionBE(pos, state);
    }

    @Override
    protected MapCodec<AlloyFurnaceExtensionBlock> codec() {
        return simpleCodec(AlloyFurnaceExtensionBlock::new);
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        BlockState bellowState = world.getBlockState(pos.below());
        if (bellowState.getBlock() != NTMBlocks.ALLOY_FURNACE) return;

        bellowState = bellowState.setValue(AlloyFurnaceBlock.EXTENSION, true);
        world.setBlockAndUpdate(pos.below(), bellowState);
    }

    @Override
    public BlockState getAppearance(BlockState state, BlockAndTintGetter renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }

    @Override
    public BlockState playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        BlockState bellowState = world.getBlockState(pos.below());
        if (bellowState.getBlock() != NTMBlocks.ALLOY_FURNACE)
            return super.playerWillDestroy(world, pos, state, player);

        bellowState = bellowState.setValue(AlloyFurnaceBlock.EXTENSION, false);
        world.setBlockAndUpdate(pos.below(), bellowState);
        return super.playerWillDestroy(world, pos, state, player);
    }
}
