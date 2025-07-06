package net.fawnoculus.ntm.blocks.node.network;

import java.util.UUID;

public class EnergyNetwork extends NodeNetwork<NetworkType.Energy>{
  public EnergyNetwork() {
    super();
    NodeNetworkManager.addEnergyNetwork(this);
  }
  public EnergyNetwork(UUID uuid) {
    super(uuid);
    NodeNetworkManager.addEnergyNetwork(this);
  }
  
  @Override
  public EnergyNetwork makeNewNetwork() {
    return new EnergyNetwork();
  }
  
  @Override
  public void tickNetwork() {
    //TODO: this
  }
}
