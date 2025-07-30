package net.fawnoculus.ntm.blocks.node.type;

import net.fawnoculus.ntm.blocks.node.Node;
import net.fawnoculus.ntm.blocks.node.network.NetworkType;
import net.fawnoculus.ntm.misc.data.NTMCodecs;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

public interface FluidNode extends Node {
  Fluid getFluidType();
  void setFluidType(Fluid fluid);
  
  @Override
  default NetworkType getNetworkType(){
    return new NetworkType.Fluid();
  }
  
  @Override
  default boolean canConnectTo(@Nullable Node node) {
    if(node instanceof FluidNode fluidNode){
      if(fluidNode.getFluidType() != this.getFluidType()) return false;
    }
    return Node.super.canConnectTo(node);
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
