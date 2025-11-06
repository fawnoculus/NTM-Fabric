package net.fawnoculus.ntm.api.multiblock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;

public class MultiBlockItem extends BlockItem {
	public MultiBlockItem(Block block, Settings settings) {
		super(block, settings);

		if (block instanceof MultiBlockOrigin origin) {
			this.MULTI_BLOCK = origin.getMultiBlock();
		} else {
			throw new IllegalArgumentException("Block must be a multi Block Origin");
		}
	}

	public MultiBlockItem(Block block, Settings settings, MultiBlock multiBlock) {
		super(block, settings);

		this.MULTI_BLOCK = multiBlock;
	}

	private final MultiBlock MULTI_BLOCK;

	@Override
	protected boolean canPlace(ItemPlacementContext context, BlockState state) {
		return super.canPlace(context, state)
		  && MULTI_BLOCK.canPlaceAt(context.getWorld(), context.getBlockPos(), context.getHorizontalPlayerFacing());
	}

	@Override
	protected boolean place(ItemPlacementContext context, BlockState state) {
		MULTI_BLOCK.placeAt(context.getWorld(), context.getBlockPos(), context.getHorizontalPlayerFacing());
		return super.place(context, state);
	}
}
