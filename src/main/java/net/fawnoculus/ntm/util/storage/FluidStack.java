package net.fawnoculus.ntm.util.storage;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fawnoculus.ntm.util.FluidUtil;
import net.fawnoculus.ntm.util.FluidUtil.Unit;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.RegistryWrapper;

public class FluidStack extends SingleVariantStorage<FluidVariant> {
  public static PacketCodec<RegistryByteBuf, FluidStack> PACKET_CODEC = new PacketCodec<>() {
    @Override
    public FluidStack decode(RegistryByteBuf buf) {
      return new FluidStack()
          .setAmount(buf.readLong())
          .setCapacity(buf.readLong())
          .setFluid(FluidVariant.PACKET_CODEC.decode(buf));
    }
    
    @Override
    public void encode(RegistryByteBuf buf, FluidStack value) {
      buf.writeLong(value.amount);
      buf.writeLong(value.maxDropletsBuckets);
      FluidVariant.PACKET_CODEC.encode(buf, value.variant);
    }
  };
  
  private long maxDropletsBuckets = 0;
  private Runnable onFinalCommit = () -> {};
  
  @Override
  protected FluidVariant getBlankVariant() {
    return FluidVariant.blank();
  }
  
  public Fluid getFluid(){
    return this.variant.getFluid();
  }
  
  public FluidStack setFluid(Fluid fluid){
    return this.setFluid(FluidVariant.of(fluid));
  }
  public FluidStack setFluid(FluidVariant fluid){
    this.variant = fluid;
    return this;
  }
  
  public long getAmount(FluidVariant variant, Unit unit) {
    return FluidUtil.convert(this.maxDropletsBuckets, Unit.DROPLET, unit);
  }
  
  public FluidStack addAmount(long milliBuckets) {
    this.amount += milliBuckets;
    return this;
  }
  public FluidStack addAmount(long amount, Unit unit) {
    return this.addAmount(FluidUtil.convert(amount, unit, Unit.DROPLET));
  }
  public FluidStack setAmount(long milliBuckets) {
    this.amount = milliBuckets;
    return this;
  }
  public FluidStack setAmount(long amount, Unit unit) {
    return this.setCapacity(FluidUtil.convert(amount, unit, Unit.DROPLET));
  }
  
  @Override
  public long getCapacity(FluidVariant variant) {
    return this.maxDropletsBuckets;
  }
  public long getCapacity(Unit unit) {
    return FluidUtil.convert(this.maxDropletsBuckets, Unit.DROPLET, unit);
  }
  
  public FluidStack setCapacity(long maxMilliBuckets) {
    this.maxDropletsBuckets = maxMilliBuckets;
    return this;
  }
  public FluidStack setCapacity(long maxAmount, Unit unit) {
    return this.setCapacity(FluidUtil.convert(maxAmount, unit, Unit.DROPLET));
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
