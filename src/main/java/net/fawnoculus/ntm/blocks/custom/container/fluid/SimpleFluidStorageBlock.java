package net.fawnoculus.ntm.blocks.custom.container.fluid;

import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.blocks.entities.container.fluid.FluidBarrelBE;
import net.fawnoculus.ntm.fluid.stack.FluidUnit;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SimpleFluidStorageBlock extends BlockWithEntity {
  public SimpleFluidStorageBlock(Settings settings, long maxMB) {
    super(settings);

    this.MAX_FLUID = maxMB;
  }
  // Extra Constructor for the Codec
  private SimpleFluidStorageBlock(Settings settings) {
    this(settings, 0);
  }

  private final long MAX_FLUID;

  @Override
  protected MapCodec<? extends BlockWithEntity> getCodec() {
    return createCodec(SimpleFluidStorageBlock::new);
  }

  @Override
  public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    FluidBarrelBE be = new FluidBarrelBE(pos, state);
    be.getFluidStorage().setCapacity(FluidUnit.mbToDroplets(this.MAX_FLUID));
    return be;
  }

  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
    if(world.isClient) return null;
    return validateTicker(type, NTMBlockEntities.SIMPLE_FLUID_STORAGE_BE, FluidBarrelBE::tick);
  }
}
