package net.fawnoculus.ntm.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fawnoculus.ntm.world.placed.NTMPOrePlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class NTMOreGeneration {
	public static void initialize() {
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.URANIUM_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.TITANIUM_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.SULFUR_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.THORIUM_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.NITER_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.TUNGSTEN_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.ALUMINIUM_BEARING_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.FLUORITE_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.LEAD_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.SCHRABIDIUM_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.BERYLLIUM_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.AUSTRALIUM_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.RARE_EARTH_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.COBALT_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.CINNEBAR_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.COLTAN_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.LIGNITE_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.ASBESTOS_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.ALUMINIUM_ORE_CLUSTER_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.COPPER_ORE_CLUSTER_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.IRON_ORE_CLUSTER_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.TITANIUM_ORE_CLUSTER_PLACED_KEY);

		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.SMOLDERING_NETHERRACK_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.NETHER_COAL_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.NETHER_URANIUM_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.NETHER_PLUTONIUM_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.NETHER_TUNGSTEN_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.NETHER_SULFUR_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.NETHER_PHOSPHORUS_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.NETHER_COBALT_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.NETHER_SCHRABIDIUM_ORE_PLACED_KEY);

		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, NTMPOrePlacedFeatures.TRIXITE_ORE_PLACED_KEY);
	}
}
