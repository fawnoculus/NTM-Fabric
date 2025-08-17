package net.fawnoculus.ntm.api;

import net.fawnoculus.ntm.api.node.network.NodeNetworkManager;
import net.fawnoculus.ntm.api.node.network.type.EnergyNetworkType;
import net.fawnoculus.ntm.api.node.network.type.FluidNetworkType;

public class NTMApi {
  public static void initialize(){
    NodeNetworkManager.registerType(EnergyNetworkType.get());
    NodeNetworkManager.registerType(FluidNetworkType.get());
  }
}
