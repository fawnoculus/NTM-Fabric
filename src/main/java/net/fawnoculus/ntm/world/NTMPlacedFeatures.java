package net.fawnoculus.ntm.world;

import net.fawnoculus.ntm.NTM;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class NTMPlacedFeatures {
  public static void initialize(Registerable<PlacedFeature> context){
    var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
    
  }
  
  
  public static RegistryKey<PlacedFeature> registryKey(String name){
    return RegistryKey.of(RegistryKeys.PLACED_FEATURE, NTM.id(name));
  }
  private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> config, List<PlacementModifier> modifiers){
    context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
  }
  
  private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> config, PlacementModifier... modifiers){
    register(context, key, config, List.of(modifiers));
  }
}
