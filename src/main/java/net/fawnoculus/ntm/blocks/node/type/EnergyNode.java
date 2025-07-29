package net.fawnoculus.ntm.blocks.node.type;

import net.fawnoculus.ntm.blocks.node.Node;
import net.fawnoculus.ntm.blocks.node.network.NetworkType;

public interface EnergyNode extends Node {
  @Override
  default NetworkType getNetworkType(){
    return new NetworkType.Energy();
  }
}
