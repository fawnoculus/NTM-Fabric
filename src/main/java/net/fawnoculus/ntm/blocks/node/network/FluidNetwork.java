package net.fawnoculus.ntm.blocks.node.network;

import net.fawnoculus.ntm.blocks.node.FluidNode;

import java.util.UUID;

public class FluidNetwork extends NodeNetwork<FluidNode>{
  public FluidNetwork() {
    super();
    NodeNetworkManager.addFluidNetwork(this);
  }
  public FluidNetwork(UUID uuid) {
    super(uuid);
    NodeNetworkManager.addFluidNetwork(this);
  }
  
  @Override
  public FluidNetwork makeNewNetwork() {
    return new FluidNetwork();
  }
  
  @Override
  public void tickNetwork() {
    //TODO: this
  }
}
