package net.fawnoculus.ntm.world;

import net.fawnoculus.ntm.world.configured.NTMOreConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class NTMConfiguredFeatures {
	public static void initialize(Registerable<ConfiguredFeature<?, ?>> context) {
		NTMOreConfiguredFeatures.initialize(context);
	}
}
