package net.fawnoculus.ntm.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceExtensionBE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class AlloyFurnaceExtensionBlock extends Block implements BlockEntityProvider {
	public AlloyFurnaceExtensionBlock(Settings settings) {
		super(settings);
	}

	@Override
	public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new AlloyFurnaceExtensionBE(pos, state);
	}

	@Override
	protected MapCodec<AlloyFurnaceExtensionBlock> getCodec() {
		return createCodec(AlloyFurnaceExtensionBlock::new);
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		BlockState bellowState = world.getBlockState(pos.down());
		if (bellowState.getBlock() != NTMBlocks.ALLOY_FURNACE) return;

		bellowState = bellowState.with(AlloyFurnaceBlock.EXTENSION, true);
		world.setBlockState(pos.down(), bellowState);
	}

	@Override
	public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
		return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
	}

	@Override
	public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		BlockState bellowState = world.getBlockState(pos.down());
		if (bellowState.getBlock() != NTMBlocks.ALLOY_FURNACE) return super.onBreak(world, pos, state, player);

		bellowState = bellowState.with(AlloyFurnaceBlock.EXTENSION, false);
		world.setBlockState(pos.down(), bellowState);
		return super.onBreak(world, pos, state, player);
	}
}
