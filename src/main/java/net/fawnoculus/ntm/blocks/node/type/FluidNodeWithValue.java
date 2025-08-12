package net.fawnoculus.ntm.blocks.node.type;

import net.fawnoculus.ntm.blocks.node.NodeWithValue;
import net.fawnoculus.ntm.misc.data.NTMCodecs;
import net.fawnoculus.ntm.fluid.stack.FluidContainer;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Range;

public interface FluidNodeWithValue extends FluidNode, NodeWithValue, FluidContainer {
  default Fluid getFluidType(){
    return getFluidStorage().variant.getFluid();
  }
  default void setFluidType(Fluid fluid){
    getFluidStorage().setFluid(fluid);
  }

  @Override
  default long getValue(){
    return this.getFluidStorage().getAmount();
  }
  @Override
  default void setValue(@Range(from = 0, to = Long.MAX_VALUE) long value){
    this.getFluidStorage().setAmount(value);
  }

  @Override
  default long getMaxValue(){
    return this.getFluidStorage().getCapacity();
  }
  @Override
  default void setMaxValue(@Range(from = 0, to = Long.MAX_VALUE) long value){
    this.getFluidStorage().setCapacity(value);
  }

  default void readFluidNodeData(NbtCompound nbt, RegistryWrapper.WrapperLookup registries){
    nbt.get("fluid_type", NTMCodecs.FLUID_CODEC).ifPresent(this::setFluidType);
  }

  default void writeFluidNodeData(NbtCompound nbt, RegistryWrapper.WrapperLookup registries){
    if(this.getFluidType() != null){
      nbt.put("fluid_type", NTMCodecs.FLUID_CODEC, this.getFluidType());
    }
  }

}
