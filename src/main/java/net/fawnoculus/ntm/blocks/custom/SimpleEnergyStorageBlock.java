package net.fawnoculus.ntm.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.blocks.entities.SimpleEnergyStorageBE;
import net.fawnoculus.ntm.util.TextUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Consumer;

public class SimpleEnergyStorageBlock extends BlockWithEntity implements HoverTooltipBlock {
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
  
  @Override
  public boolean shouldDisplayTooltip(World world, BlockPos pos, BlockState state) {
    return world.getBlockEntity(pos) instanceof SimpleEnergyStorageBE;
  }
  
  @Override
  public void appendTooltip(World world, BlockPos pos, BlockState state, Consumer<Text> tooltip) {
    SimpleEnergyStorageBE energyStorageBE = (SimpleEnergyStorageBE) world.getBlockEntity(pos);
    assert energyStorageBE != null;
    long value = energyStorageBE.getNodeProperties().getValue();
    Text valueText = TextUtil.unit(value);
    long maxValue = energyStorageBE.getNodeProperties().getMaxValue();
    Text maxValueText = TextUtil.unit(maxValue, "generic.ntm.energy");
    int color = MathHelper.hsvToRgb(Math.max(0.0F, (float) value / (float) maxValue) / 3.0F, 1.0F, 1.0F);
    
    tooltip.accept(this.getName().formatted(Formatting.YELLOW));
    tooltip.accept(Text.translatable("generic.ntm.spaced_amount_stored", valueText, maxValueText).formatted(Formatting.WHITE));
    tooltip.accept(Text.literal(String.format("%1$,3.1f%%", 100.0 * value / maxValue)).withColor(color));
  }
}
