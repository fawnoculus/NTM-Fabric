package net.fawnoculus.ntm.world.configured;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NTMOreConfiguredFeatures {
	public static final RegistryKey<ConfiguredFeature<?, ?>> URANIUM_ORE_KEY = registryKey("uranium_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> TITANIUM_ORE_KEY = registryKey("titanium_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY = registryKey("sulfur_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> THORIUM_ORE_KEY = registryKey("thorium_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> NITER_ORE_KEY = registryKey("niter_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> TUNGSTEN_ORE_KEY = registryKey("tungsten_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> ALUMINIUM_BEARING_ORE_KEY = registryKey("aluminium_bearing_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> FLUORITE_ORE_KEY = registryKey("fluorite_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> LEAD_ORE_KEY = registryKey("lead_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> SCHRABIDIUM_ORE_KEY = registryKey("schrabidium_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> BERYLLIUM_ORE_KEY = registryKey("beryllium_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> AUSTRALIUM_ORE_KEY = registryKey("australium_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> RARE_EARTH_ORE_KEY = registryKey("rare_earth_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> COBALT_ORE_KEY = registryKey("cobalt_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> CINNEBAR_ORE_KEY = registryKey("cinnebar_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> COLTAN_ORE_KEY = registryKey("coltan_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> LIGNITE_ORE_KEY = registryKey("lignite_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> ASBESTOS_ORE_KEY = registryKey("asbestos_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> ALUMINIUM_ORE_CLUSTER_KEY = registryKey("aluminium_ore_cluster");
	public static final RegistryKey<ConfiguredFeature<?, ?>> COPPER_ORE_CLUSTER_KEY = registryKey("copper_ore_cluster");
	public static final RegistryKey<ConfiguredFeature<?, ?>> IRON_ORE_CLUSTER_KEY = registryKey("iron_ore_cluster");
	public static final RegistryKey<ConfiguredFeature<?, ?>> TITANIUM_ORE_CLUSTER_KEY = registryKey("titanium_ore_cluster");

	public static final RegistryKey<ConfiguredFeature<?, ?>> SMOLDERING_NETHERRACK_KEY = registryKey("smoldering_netherrack");
	public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_COAL_ORE_KEY = registryKey("nether_coal_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_URANIUM_ORE_KEY = registryKey("nether_uranium_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_PLUTONIUM_ORE_KEY = registryKey("nether_plutonium_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TUNGSTEN_ORE_KEY = registryKey("nether_tungsten_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_SULFUR_ORE_KEY = registryKey("nether_sulfur_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_PHOSPHORUS_ORE_KEY = registryKey("nether_phosphorus_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_COBALT_ORE_KEY = registryKey("nether_cobalt_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_SCHRABIDIUM_ORE_KEY = registryKey("nether_schrabidium_ore");

	public static final RegistryKey<ConfiguredFeature<?, ?>> TRIXITE_ORE_KEY = registryKey("trixite_ore");

	public static void initialize(Registerable<ConfiguredFeature<?, ?>> context) {
		final RuleTest StoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
		final RuleTest DeepslateReplaceable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
		final RuleTest NetherrackReplaceable = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
		final RuleTest EndStoneReplaceable = new BlockMatchRuleTest(Blocks.END_STONE);

		// TODO: extract propper counts from original
		List<OreFeatureConfig.Target> uraniumOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.URANIUM_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_URANIUM_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> titaniumOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.TITANIUM_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_TITANIUM_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> sulfurOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.SULFUR_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_SULFUR_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> thoriumOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.THORIUM_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_THORIUM_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> niterOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.NITER_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_NITER_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> tungstenOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.TUNGSTEN_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_TUNGSTEN_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> aluminiumBearingOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.ALUMINIUM_BEARING_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> fluoriteOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.FLUORITE_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_FLUORITE_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> leadOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.LEAD_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_LEAD_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> schrabidiumOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.SCHRABIDIUM_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> berylliumOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.BERYLLIUM_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_BERYLLIUM_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> australiumOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.AUSTRALIUM_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> rareEarthOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.RARE_EARTH_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_RARE_EARTH_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> cobaltOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.COBALT_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_COBALT_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> cinnebarOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.CINNEBAR_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_CINNEBAR_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> coltanOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.COLTAN_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_COLTAN_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> ligniteOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.LIGNITE_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_LIGNITE_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> asbestosOres = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.ASBESTOS_ORE.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_ASBESTOS_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> aluminiumOreClusters = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.ALUMINIUM_ORE_CLUSTER.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_ALUMINIUM_ORE_CLUSTER.getDefaultState())
		);
		List<OreFeatureConfig.Target> copperOreClusters = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.COPPER_ORE_CLUSTER.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_COPPER_ORE_CLUSTER.getDefaultState())
		);
		List<OreFeatureConfig.Target> ironOreClusters = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.IRON_ORE_CLUSTER.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_IRON_ORE_CLUSTER.getDefaultState())
		);
		List<OreFeatureConfig.Target> titaniumOreClusters = List.of(
		  OreFeatureConfig.createTarget(StoneReplaceable, NTMBlocks.TITANIUM_ORE_CLUSTER.getDefaultState()),
		  OreFeatureConfig.createTarget(DeepslateReplaceable, NTMBlocks.DEEPSLATE_TITANIUM_ORE_CLUSTER.getDefaultState())
		);

		List<OreFeatureConfig.Target> smolderingNetherrack = List.of(
		  OreFeatureConfig.createTarget(NetherrackReplaceable, NTMBlocks.SMOLDERING_NETHERRACK.getDefaultState())
		);
		List<OreFeatureConfig.Target> netherCoalOres = List.of(
		  OreFeatureConfig.createTarget(NetherrackReplaceable, NTMBlocks.NETHER_COAL_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> netherUraniumOres = List.of(
		  OreFeatureConfig.createTarget(NetherrackReplaceable, NTMBlocks.NETHER_URANIUM_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> netherPlutoniumOres = List.of(
		  OreFeatureConfig.createTarget(NetherrackReplaceable, NTMBlocks.NETHER_PLUTONIUM_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> netherTungstenOres = List.of(
		  OreFeatureConfig.createTarget(NetherrackReplaceable, NTMBlocks.NETHER_TUNGSTEN_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> netherSulfurOres = List.of(
		  OreFeatureConfig.createTarget(NetherrackReplaceable, NTMBlocks.NETHER_SULFUR_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> netherPhosphorusOres = List.of(
		  OreFeatureConfig.createTarget(NetherrackReplaceable, NTMBlocks.NETHER_PHOSPHORUS_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> netherCobaltOres = List.of(
		  OreFeatureConfig.createTarget(NetherrackReplaceable, NTMBlocks.NETHER_COBALT_ORE.getDefaultState())
		);
		List<OreFeatureConfig.Target> netherSchrabidiumOres = List.of(
		  OreFeatureConfig.createTarget(NetherrackReplaceable, NTMBlocks.NETHER_SCHRABIDIUM_ORE.getDefaultState())
		);

		List<OreFeatureConfig.Target> trixiteOres = List.of(
		  OreFeatureConfig.createTarget(EndStoneReplaceable, NTMBlocks.TRIXITE_ORE.getDefaultState())
		);

		register(context, URANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(uraniumOres, 10));
		register(context, TITANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(titaniumOres, 10));
		register(context, SULFUR_ORE_KEY, Feature.ORE, new OreFeatureConfig(sulfurOres, 10));
		register(context, THORIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(thoriumOres, 10));
		register(context, NITER_ORE_KEY, Feature.ORE, new OreFeatureConfig(niterOres, 10));
		register(context, TUNGSTEN_ORE_KEY, Feature.ORE, new OreFeatureConfig(tungstenOres, 10));
		register(context, ALUMINIUM_BEARING_ORE_KEY, Feature.ORE, new OreFeatureConfig(aluminiumBearingOres, 10));
		register(context, FLUORITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(fluoriteOres, 10));
		register(context, LEAD_ORE_KEY, Feature.ORE, new OreFeatureConfig(leadOres, 10));
		register(context, SCHRABIDIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(schrabidiumOres, 10));
		register(context, BERYLLIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(berylliumOres, 10));
		register(context, AUSTRALIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(australiumOres, 10));
		register(context, RARE_EARTH_ORE_KEY, Feature.ORE, new OreFeatureConfig(rareEarthOres, 10));
		register(context, COBALT_ORE_KEY, Feature.ORE, new OreFeatureConfig(cobaltOres, 10));
		register(context, CINNEBAR_ORE_KEY, Feature.ORE, new OreFeatureConfig(cinnebarOres, 10));
		register(context, COLTAN_ORE_KEY, Feature.ORE, new OreFeatureConfig(coltanOres, 10));
		register(context, LIGNITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(ligniteOres, 10));
		register(context, ASBESTOS_ORE_KEY, Feature.ORE, new OreFeatureConfig(asbestosOres, 10));
		register(context, ALUMINIUM_ORE_CLUSTER_KEY, Feature.ORE, new OreFeatureConfig(aluminiumOreClusters, 10));
		register(context, COPPER_ORE_CLUSTER_KEY, Feature.ORE, new OreFeatureConfig(copperOreClusters, 10));
		register(context, IRON_ORE_CLUSTER_KEY, Feature.ORE, new OreFeatureConfig(ironOreClusters, 10));
		register(context, TITANIUM_ORE_CLUSTER_KEY, Feature.ORE, new OreFeatureConfig(titaniumOreClusters, 10));

		register(context, SMOLDERING_NETHERRACK_KEY, Feature.ORE, new OreFeatureConfig(smolderingNetherrack, 1));
		register(context, NETHER_COAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherCoalOres, 1));
		register(context, NETHER_URANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherUraniumOres, 1));
		register(context, NETHER_PLUTONIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherPlutoniumOres, 1));
		register(context, NETHER_TUNGSTEN_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherTungstenOres, 1));
		register(context, NETHER_SULFUR_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherSulfurOres, 1));
		register(context, NETHER_PHOSPHORUS_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherPhosphorusOres, 1));
		register(context, NETHER_COBALT_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherCobaltOres, 1));
		register(context, NETHER_SCHRABIDIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherSchrabidiumOres, 1));

		register(context, TRIXITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(trixiteOres, 1));
	}


	public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
		return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, NTM.id(name));
	}

	private static <FC extends FeatureConfig, F extends Feature<FC>> void register(@NotNull Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
		context.register(key, new ConfiguredFeature<>(feature, config));
	}
}
