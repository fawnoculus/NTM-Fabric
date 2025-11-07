package net.fawnoculus.ntm.client.api;

import net.fawnoculus.ntm.client.api.events.NTMClientEvents;
import net.fawnoculus.ntm.client.api.explosion.NTMExplosionHandlers;

public class NTMClientApi {
	public static void initialize() {
		NTMClientEvents.initialize();
		NTMExplosionHandlers.initialize();
	}
}
