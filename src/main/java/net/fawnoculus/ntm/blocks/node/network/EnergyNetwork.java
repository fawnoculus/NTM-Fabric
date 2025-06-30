package net.fawnoculus.ntm.blocks.node.network;

import net.fawnoculus.ntm.blocks.node.EnergyNode;

import java.util.UUID;

public class EnergyNetwork extends NodeNetwork<EnergyNode>{
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
