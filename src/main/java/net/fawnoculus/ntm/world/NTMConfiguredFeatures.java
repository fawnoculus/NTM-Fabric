package net.fawnoculus.ntm.world;

import net.fawnoculus.ntm.world.configured.NTMOreConfiguredFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class NTMConfiguredFeatures {
    public static void initialize(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        NTMOreConfiguredFeatures.initialize(context);
    }
}
