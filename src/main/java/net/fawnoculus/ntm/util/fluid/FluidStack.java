package net.fawnoculus.ntm.util.fluid;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
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
  
  public long getAmount(FluidVariant variant, FluidUnit unit) {
    return FluidUnit.convert(this.maxDropletsBuckets, FluidUnit.DROPLET, unit);
  }
  
  public FluidStack addAmount(long milliBuckets) {
    this.amount += milliBuckets;
    return this;
  }
  public FluidStack addAmount(long amount, FluidUnit unit) {
    return this.addAmount(FluidUnit.convert(amount, unit, FluidUnit.DROPLET));
  }
  public FluidStack setAmount(long milliBuckets) {
    this.amount = milliBuckets;
    return this;
  }
  public FluidStack setAmount(long amount, FluidUnit unit) {
    return this.setCapacity(FluidUnit.convert(amount, unit, FluidUnit.DROPLET));
  }
  
  @Override
  public long getCapacity(FluidVariant variant) {
    return this.maxDropletsBuckets;
  }
  public long getCapacity(FluidUnit unit) {
    return FluidUnit.convert(this.maxDropletsBuckets, FluidUnit.DROPLET, unit);
  }
  
  public FluidStack setCapacity(long maxMilliBuckets) {
    this.maxDropletsBuckets = maxMilliBuckets;
    return this;
  }
  public FluidStack setCapacity(long maxAmount, FluidUnit unit) {
    return this.setCapacity(FluidUnit.convert(maxAmount, unit, FluidUnit.DROPLET));
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
