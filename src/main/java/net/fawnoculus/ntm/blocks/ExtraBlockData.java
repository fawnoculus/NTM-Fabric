package net.fawnoculus.ntm.blocks;

import net.fawnoculus.ntm.api.radiation.RadiationRegistry;

public class ExtraBlockData {
	public static void initialize() {
		RadiationRegistry.register(NTMBlocks.URANIUM_BLOCK, 3500);
	}
}
