package net.fawnoculus.ntm.world;

import net.fawnoculus.ntm.world.placed.NTMPOrePlacedFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

public class NTMPlacedFeatures {
    public static void initialize(@NotNull BootstrapContext<PlacedFeature> context) {
        NTMPOrePlacedFeatures.initialize(context);
    }
}
