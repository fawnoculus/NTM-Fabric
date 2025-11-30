package net.fawnoculus.ntm.api;

import net.fawnoculus.ntm.api.events.NTMEvents;
import net.fawnoculus.ntm.api.explosion.NTMExplosionTypes;
import net.fawnoculus.ntm.api.node.network.NetworkTypes;
import net.fawnoculus.ntm.api.node.network.NodeNetworkManager;
import net.fawnoculus.ntm.api.radiation.HazmatRegistry;
import net.fawnoculus.ntm.api.radiation.RadiationRegistry;

public class NTMApi {
    public static void initialize() {
        NTMEvents.initialize();
        RadiationRegistry.initialize();
        HazmatRegistry.initialize();
        NTMExplosionTypes.initialize();

        NodeNetworkManager.registerType(NetworkTypes.ENERGY);
        NodeNetworkManager.registerType(NetworkTypes.FLUID);
    }
}
