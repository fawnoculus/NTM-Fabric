package net.fawnoculus.ntm.blocks.node.network;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.UUID;

public interface NetworkType {
  MutableText getName();
  NodeNetwork makeNewNetwork();
  NodeNetwork getNetwork(UUID uuid);
  boolean sameAs(NetworkType networkType);
  
  class Energy implements NetworkType{
    @Override
    public MutableText getName(){
      return Text.translatable("generic.ntm.network_type.energy");
    }
    
    @Override
    public NodeNetwork makeNewNetwork() {
      return new EnergyNetwork();
    }
    
    @Override
    public NodeNetwork getNetwork(UUID uuid) {
      return NodeNetworkManager.getEnergyNetwork(uuid);
    }
    
    @Override
    public boolean sameAs(NetworkType networkType) {
      return networkType instanceof Energy;
    }
  }
  class Fluid implements NetworkType{
    @Override
    public MutableText getName(){
      return Text.translatable("generic.ntm.network_type.fluid");
    }
    
    @Override
    public NodeNetwork makeNewNetwork() {
      return new FluidNetwork();
    }
    
    @Override
    public NodeNetwork getNetwork(UUID uuid) {
      return NodeNetworkManager.getFluidNetwork(uuid);
    }
    
    @Override
    public boolean sameAs(NetworkType networkType) {
      return networkType instanceof Fluid;
    }
  }
}
