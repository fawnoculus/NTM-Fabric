package net.fawnoculus.ntm.blocks.custom.node.network;

import net.fawnoculus.ntm.blocks.custom.node.EnergyNode;

public class EnergyNetwork extends NodeNetwork<EnergyNode>{
  public EnergyNetwork() {
    super();
    NodeNetworkManager.addEnergyNetwork(this);
  }
  
  @Override
  public EnergyNetwork makeNewNetwork() {
    return new EnergyNetwork();
  }
  
  @Override
  void tickNetwork() {
  }
}
