package net.fawnoculus.ntm.api;

import net.fawnoculus.ntm.api.events.NTMEvents;
import net.fawnoculus.ntm.api.node.network.NodeNetworkManager;
import net.fawnoculus.ntm.api.node.network.type.EnergyNetworkType;
import net.fawnoculus.ntm.api.node.network.type.FluidNetworkType;
import net.fawnoculus.ntm.api.radiation.HazmatRegistry;
import net.fawnoculus.ntm.api.radiation.RadiationRegistry;

public class NTMApi {
  public static void initialize() {
    NTMEvents.initialize();
    RadiationRegistry.initialize();
    HazmatRegistry.initialize();

    NodeNetworkManager.registerType(EnergyNetworkType.get());
    NodeNetworkManager.registerType(FluidNetworkType.get());
  }
}
