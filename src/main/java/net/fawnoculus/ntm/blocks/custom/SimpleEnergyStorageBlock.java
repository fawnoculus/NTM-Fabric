package net.fawnoculus.ntm.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.blocks.entities.SimpleEnergyStorageBE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class SimpleEnergyStorageBlock extends BlockWithEntity {
  public SimpleEnergyStorageBlock(Settings settings) {
    super(settings);
    setDefaultState(this.getDefaultState()
        .with(FACING, Direction.NORTH));
  }
  
  public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;
  private long MaxEnergy = 0;
  
  @Override
  protected MapCodec<? extends BlockWithEntity> getCodec() {
    return createCodec(SimpleEnergyStorageBlock::new);
  }
  
  @Override
  public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    SimpleEnergyStorageBE energyStorageBE = new SimpleEnergyStorageBE(pos, state);
    energyStorageBE.getNodeProperties().setMaxValue(this.MaxEnergy);
    return energyStorageBE;
  }
  
  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }
  
  @Override
  public BlockState getPlacementState(ItemPlacementContext context) {
    PlayerEntity player = Objects.requireNonNull(context.getPlayer());
    context.getWorld().getBlockState(context.getBlockPos().up()).getBlock();
    return this.getDefaultState().with(FACING, player.getHorizontalFacing().getOpposite());
  }
  
  public SimpleEnergyStorageBlock maxEnergy(long energy){
    this.MaxEnergy = energy;
    return this;
  }
}
