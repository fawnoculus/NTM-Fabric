package net.fawnoculus.ntm.blocks.node.network;

import net.fawnoculus.ntm.blocks.node.FluidNode;

public class FluidNetwork extends NodeNetwork<FluidNode>{
  public FluidNetwork() {
    super();
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
