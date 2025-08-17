package net.fawnoculus.ntm.blocks.custom.container.energy;

import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.blocks.custom.HoverTooltipBlock;
import net.fawnoculus.ntm.blocks.entities.container.energy.SimpleEnergyStorageBE;
import net.fawnoculus.ntm.util.TextUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Consumer;

public class SimpleEnergyStorageBlock extends BlockWithEntity implements HoverTooltipBlock {
  public SimpleEnergyStorageBlock(Settings settings, long MaxEnergy) {
    super(settings);
    setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    this.MAX_ENERGY = MaxEnergy;
  }
  // Extra Constructor for the Codec
  private SimpleEnergyStorageBlock(Settings settings) {
    this(settings, 0);
  }

  public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;
  private final long MAX_ENERGY;

  @Override
  protected MapCodec<? extends BlockWithEntity> getCodec() {
    return createCodec(SimpleEnergyStorageBlock::new);
  }

  @Override
  public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    SimpleEnergyStorageBE energyStorageBE = new SimpleEnergyStorageBE(pos, state);
    energyStorageBE.energy.setMaxValue(this.MAX_ENERGY);
    return energyStorageBE;
  }

  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
    if(world.isClient) return null;
    return validateTicker(type, NTMBlockEntities.SIMPLE_ENERGY_STORAGE_BE, SimpleEnergyStorageBE::tick);
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

  @Override
  protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
    if (!(world.getBlockEntity(pos) instanceof SimpleEnergyStorageBE energyStorageBE)) {
      return ActionResult.FAIL;
    }
    if(world.isClient){
      return ActionResult.SUCCESS;
    }

    player.openHandledScreen(energyStorageBE);

    return ActionResult.SUCCESS_SERVER;
  }

  @Override
  protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
    super.neighborUpdate(state, world, pos, sourceBlock, wireOrientation, notify);

    if(world.getBlockEntity(pos) instanceof SimpleEnergyStorageBE simpleEnergyStorageBE){
      simpleEnergyStorageBE.onBlockUpdate();
    }
  }

  @Override
  public BlockState getPlacementState(ItemPlacementContext context) {
    PlayerEntity player = Objects.requireNonNull(context.getPlayer());
    context.getWorld().getBlockState(context.getBlockPos().up()).getBlock();
    return this.getDefaultState().with(FACING, player.getHorizontalFacing().getOpposite());
  }

  @Override
  public boolean shouldDisplayTooltip(World world, BlockPos pos, BlockState state) {
    return world.getBlockEntity(pos) instanceof SimpleEnergyStorageBE;
  }

  @Override
  public void appendHoverTooltip(World world, BlockPos pos, BlockState state, Consumer<Text> tooltip) {
    SimpleEnergyStorageBE energyStorageBE = (SimpleEnergyStorageBE) world.getBlockEntity(pos);
    assert energyStorageBE != null;
    long value = energyStorageBE.energy.getValue();
    Text valueText = TextUtil.unit(value);
    long maxValue = energyStorageBE.energy.getMaxValue();
    Text maxValueText = TextUtil.unit(maxValue, "generic.ntm.energy");
    int color = MathHelper.hsvToRgb(Math.max(0.0F, (float) value / (float) maxValue) / 3.0F, 1.0F, 1.0F);

    tooltip.accept(this.getName().formatted(Formatting.YELLOW));
    tooltip.accept(Text.translatable("generic.ntm.spaced_amount_stored", valueText, maxValueText).formatted(Formatting.WHITE));
    tooltip.accept(Text.literal(String.format("%1$,3.1f%%", 100.0 * value / maxValue)).withColor(color));
  }
}
