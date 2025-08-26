package net.fawnoculus.ntm.misc.stack;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;

public class FluidStack extends SingleVariantStorage<FluidVariant> {
  private long maxDroplets = 0;
  private Runnable onFinalCommit = () -> {
  };

  @Override
  protected FluidVariant getBlankVariant() {
    return FluidVariant.blank();
  }

  public Fluid getFluid() {
    return this.variant.getFluid();
  }

  public FluidStack setFluid(Fluid fluid) {
    return this.setFluid(FluidVariant.of(fluid));
  }

  public FluidStack setFluid(FluidVariant fluid) {
    this.variant = fluid;
    return this;
  }

  public FluidStack addAmount(long droplets) {
    this.amount += droplets;
    return this;
  }

  public FluidStack setAmount(long droplets) {
    this.amount = droplets;
    return this;
  }

  @Override
  public long getCapacity(FluidVariant variant) {
    return this.maxDroplets;
  }

  public FluidStack setCapacity(long droplets) {
    this.maxDroplets = droplets;
    return this;
  }

  public FluidStack onFinalCommit(Runnable runnable) {
    this.onFinalCommit = runnable;
    return this;
  }

  @Override
  protected void onFinalCommit() {
    super.onFinalCommit();
    this.onFinalCommit.run();
  }

  public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapperLookup) {
    SingleVariantStorage.readNbt(this, FluidVariant.CODEC, FluidVariant::blank, nbt, wrapperLookup);
  }

  public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapperLookup) {
    SingleVariantStorage.writeNbt(this, FluidVariant.CODEC, nbt, wrapperLookup);
  }
}
