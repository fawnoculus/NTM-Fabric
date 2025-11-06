package net.fawnoculus.ntm.world.placed;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.world.configured.NTMOreConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

public class NTMPOrePlacedFeatures {
	public static final RegistryKey<PlacedFeature> URANIUM_ORE_PLACED_KEY = registryKey("uranium_ore_placed");
	public static final RegistryKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY = registryKey("titanium_ore_placed");
	public static final RegistryKey<PlacedFeature> SULFUR_ORE_PLACED_KEY = registryKey("sulfur_ore_placed");
	public static final RegistryKey<PlacedFeature> THORIUM_ORE_PLACED_KEY = registryKey("thorium_ore_placed");
	public static final RegistryKey<PlacedFeature> NITER_ORE_PLACED_KEY = registryKey("niter_ore_placed");
	public static final RegistryKey<PlacedFeature> TUNGSTEN_ORE_PLACED_KEY = registryKey("tungsten_ore_placed");
	public static final RegistryKey<PlacedFeature> ALUMINIUM_BEARING_ORE_PLACED_KEY = registryKey("aluminium_bearing_ore_placed");
	public static final RegistryKey<PlacedFeature> FLUORITE_ORE_PLACED_KEY = registryKey("fluorite_ore_placed");
	public static final RegistryKey<PlacedFeature> LEAD_ORE_PLACED_KEY = registryKey("lead_ore_placed");
	public static final RegistryKey<PlacedFeature> SCHRABIDIUM_ORE_PLACED_KEY = registryKey("schrabidium_ore_placed");
	public static final RegistryKey<PlacedFeature> BERYLLIUM_ORE_PLACED_KEY = registryKey("beryllium_ore_placed");
	public static final RegistryKey<PlacedFeature> AUSTRALIUM_ORE_PLACED_KEY = registryKey("australium_ore_placed");
	public static final RegistryKey<PlacedFeature> RARE_EARTH_ORE_PLACED_KEY = registryKey("rare_earth_ore_placed");
	public static final RegistryKey<PlacedFeature> COBALT_ORE_PLACED_KEY = registryKey("cobalt_ore_placed");
	public static final RegistryKey<PlacedFeature> CINNEBAR_ORE_PLACED_KEY = registryKey("cinnebar_ore_placed");
	public static final RegistryKey<PlacedFeature> COLTAN_ORE_PLACED_KEY = registryKey("coltan_ore_placed");
	public static final RegistryKey<PlacedFeature> LIGNITE_ORE_PLACED_KEY = registryKey("lignite_ore_placed");
	public static final RegistryKey<PlacedFeature> ASBESTOS_ORE_PLACED_KEY = registryKey("asbestos_ore_placed");
	public static final RegistryKey<PlacedFeature> ALUMINIUM_ORE_CLUSTER_PLACED_KEY = registryKey("aluminium_ore_cluster_placed");
	public static final RegistryKey<PlacedFeature> COPPER_ORE_CLUSTER_PLACED_KEY = registryKey("copper_ore_cluster_placed");
	public static final RegistryKey<PlacedFeature> IRON_ORE_CLUSTER_PLACED_KEY = registryKey("iron_ore_cluster_placed");
	public static final RegistryKey<PlacedFeature> TITANIUM_ORE_CLUSTER_PLACED_KEY = registryKey("titanium_ore_cluster_placed");

	public static final RegistryKey<PlacedFeature> SMOLDERING_NETHERRACK_PLACED_KEY = registryKey("smoldering_netherrack_placed");
	public static final RegistryKey<PlacedFeature> NETHER_COAL_ORE_PLACED_KEY = registryKey("nether_coal_ore_placed");
	public static final RegistryKey<PlacedFeature> NETHER_URANIUM_ORE_PLACED_KEY = registryKey("nether_uranium_ore_placed");
	public static final RegistryKey<PlacedFeature> NETHER_PLUTONIUM_ORE_PLACED_KEY = registryKey("nether_plutonium_ore_placed");
	public static final RegistryKey<PlacedFeature> NETHER_TUNGSTEN_ORE_PLACED_KEY = registryKey("nether_tungsten_ore_placed");
	public static final RegistryKey<PlacedFeature> NETHER_SULFUR_ORE_PLACED_KEY = registryKey("nether_sulfur_ore_placed");
	public static final RegistryKey<PlacedFeature> NETHER_PHOSPHORUS_ORE_PLACED_KEY = registryKey("nether_phosphorus_ore_placed");
	public static final RegistryKey<PlacedFeature> NETHER_COBALT_ORE_PLACED_KEY = registryKey("nether_cobalt_ore_placed");
	public static final RegistryKey<PlacedFeature> NETHER_SCHRABIDIUM_ORE_PLACED_KEY = registryKey("nether_schrabidium_ore_placed");

	public static final RegistryKey<PlacedFeature> TRIXITE_ORE_PLACED_KEY = registryKey("trixite_ore_placed");


	public static void initialize(@NotNull Registerable<PlacedFeature> context) {
		var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

		// TODO: extract propper counts from original
		register(context, URANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.URANIUM_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TITANIUM_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, SULFUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.SULFUR_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, THORIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.THORIUM_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, NITER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.NITER_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, TUNGSTEN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TUNGSTEN_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, ALUMINIUM_BEARING_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.ALUMINIUM_BEARING_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, FLUORITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.FLUORITE_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, LEAD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.LEAD_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, SCHRABIDIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.SCHRABIDIUM_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, BERYLLIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.BERYLLIUM_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, AUSTRALIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.AUSTRALIUM_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, RARE_EARTH_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.RARE_EARTH_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, COBALT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.COBALT_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, CINNEBAR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.CINNEBAR_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, COLTAN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.COLTAN_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, LIGNITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.LIGNITE_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, ASBESTOS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.ASBESTOS_ORE_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, ALUMINIUM_ORE_CLUSTER_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.ALUMINIUM_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, COPPER_ORE_CLUSTER_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.COPPER_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, IRON_ORE_CLUSTER_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.IRON_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, TITANIUM_ORE_CLUSTER_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TITANIUM_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);

		register(context, SMOLDERING_NETHERRACK_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TITANIUM_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, NETHER_COAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TITANIUM_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, NETHER_URANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TITANIUM_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, NETHER_PLUTONIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TITANIUM_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, NETHER_TUNGSTEN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TITANIUM_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, NETHER_SULFUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TITANIUM_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, NETHER_PHOSPHORUS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TITANIUM_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, NETHER_COBALT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TITANIUM_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
		register(context, NETHER_SCHRABIDIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TITANIUM_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);

		register(context, TRIXITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(NTMOreConfiguredFeatures.TITANIUM_ORE_CLUSTER_KEY),
		  modifiersWithCount(14,
			HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))

		  )
		);
	}


	public static RegistryKey<PlacedFeature> registryKey(String name) {
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, NTM.id(name));
	}

	private static void register(@NotNull Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> config, List<PlacementModifier> modifiers) {
		context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
	}

	private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> config, PlacementModifier... modifiers) {
		register(context, key, config, List.of(modifiers));
	}

	// Methods below are directly from OrePlacedFeatures, just with some Annotations
	@Contract("_, _ -> new")
	public static @NotNull @Unmodifiable List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
		return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
	}

	@Contract("_, _ -> new") // Technically it's not exactly veins per Chunk, but it's pretty close
	public static @NotNull @Unmodifiable List<PlacementModifier> modifiersWithCount(int veinsPerChunk, PlacementModifier heightModifier) {
		return modifiers(CountPlacementModifier.of(veinsPerChunk), heightModifier);
	}

	@Contract("_, _ -> new")
	public static @NotNull @Unmodifiable List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
		return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
	}
}
