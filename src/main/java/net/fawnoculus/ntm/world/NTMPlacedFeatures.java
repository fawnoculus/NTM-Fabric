package net.fawnoculus.ntm.world;

import net.fawnoculus.ntm.world.placed.NTMPOrePlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.jetbrains.annotations.NotNull;

public class NTMPlacedFeatures {
  public static void initialize(@NotNull Registerable<PlacedFeature> context){
    NTMPOrePlacedFeatures.initialize(context);
  }
}
