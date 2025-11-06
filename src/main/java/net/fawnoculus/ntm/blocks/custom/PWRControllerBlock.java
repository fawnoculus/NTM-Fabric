package net.fawnoculus.ntm.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class PWRControllerBlock extends BlockWithEntity {
	public PWRControllerBlock(Settings settings) {
		super(settings);
		setDefaultState(this.getDefaultState()
		  .with(FACING, Direction.NORTH));
	}
	// TODO: this
	// this is currently only here as the icon for the Machine Tab

	public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;

	@Override
	protected MapCodec<? extends BlockWithEntity> getCodec() {
		return createCodec(PWRControllerBlock::new);
	}

	@Override
	public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return null;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		if (context.getPlayer() != null) {
			return this.getDefaultState().with(FACING, context.getPlayer().getHorizontalFacing().getOpposite());
		}
		return this.getDefaultState();
	}
}
