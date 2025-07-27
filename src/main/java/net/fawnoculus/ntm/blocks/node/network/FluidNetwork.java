package net.fawnoculus.ntm.blocks.node.network;

import java.util.UUID;

public class FluidNetwork extends NodeNetwork<NetworkType.Fluid>{
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
  public NetworkType.Fluid getType() {
    return new NetworkType.Fluid();
  }
}
