package net.fawnoculus.ntm.world.configured;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NTMOreConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> URANIUM_ORE_KEY = registryKey("uranium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TITANIUM_ORE_KEY = registryKey("titanium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY = registryKey("sulfur_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> THORIUM_ORE_KEY = registryKey("thorium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NITER_ORE_KEY = registryKey("niter_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TUNGSTEN_ORE_KEY = registryKey("tungsten_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALUMINIUM_BEARING_ORE_KEY = registryKey("aluminium_bearing_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLUORITE_ORE_KEY = registryKey("fluorite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAD_ORE_KEY = registryKey("lead_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCHRABIDIUM_ORE_KEY = registryKey("schrabidium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BERYLLIUM_ORE_KEY = registryKey("beryllium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AUSTRALIUM_ORE_KEY = registryKey("australium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RARE_EARTH_ORE_KEY = registryKey("rare_earth_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COBALT_ORE_KEY = registryKey("cobalt_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CINNEBAR_ORE_KEY = registryKey("cinnebar_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COLTAN_ORE_KEY = registryKey("coltan_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGNITE_ORE_KEY = registryKey("lignite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASBESTOS_ORE_KEY = registryKey("asbestos_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALUMINIUM_ORE_CLUSTER_KEY = registryKey("aluminium_ore_cluster");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COPPER_ORE_CLUSTER_KEY = registryKey("copper_ore_cluster");
    public static final ResourceKey<ConfiguredFeature<?, ?>> IRON_ORE_CLUSTER_KEY = registryKey("iron_ore_cluster");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TITANIUM_ORE_CLUSTER_KEY = registryKey("titanium_ore_cluster");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SMOLDERING_NETHERRACK_KEY = registryKey("smoldering_netherrack");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COAL_ORE_KEY = registryKey("nether_coal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_URANIUM_ORE_KEY = registryKey("nether_uranium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_PLUTONIUM_ORE_KEY = registryKey("nether_plutonium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_TUNGSTEN_ORE_KEY = registryKey("nether_tungsten_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SULFUR_ORE_KEY = registryKey("nether_sulfur_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_PHOSPHORUS_ORE_KEY = registryKey("nether_phosphorus_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COBALT_ORE_KEY = registryKey("nether_cobalt_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SCHRABIDIUM_ORE_KEY = registryKey("nether_schrabidium_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TRIXITE_ORE_KEY = registryKey("trixite_ore");

    public static void initialize(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        final RuleTest StoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        final RuleTest DeepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        final RuleTest NetherrackReplaceable = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        final RuleTest EndStoneReplaceable = new BlockMatchTest(Blocks.END_STONE);

        // TODO: extract propper counts from original
        List<OreConfiguration.TargetBlockState> uraniumOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.URANIUM_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_URANIUM_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> titaniumOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.TITANIUM_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_TITANIUM_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> sulfurOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.SULFUR_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_SULFUR_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> thoriumOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.THORIUM_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_THORIUM_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> niterOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.NITER_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_NITER_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> tungstenOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.TUNGSTEN_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_TUNGSTEN_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> aluminiumBearingOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.ALUMINIUM_BEARING_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> fluoriteOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.FLUORITE_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_FLUORITE_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> leadOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.LEAD_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_LEAD_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> schrabidiumOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.SCHRABIDIUM_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> berylliumOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.BERYLLIUM_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_BERYLLIUM_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> australiumOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.AUSTRALIUM_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> rareEarthOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.RARE_EARTH_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_RARE_EARTH_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> cobaltOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.COBALT_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_COBALT_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> cinnebarOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.CINNEBAR_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_CINNEBAR_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> coltanOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.COLTAN_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_COLTAN_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> ligniteOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.LIGNITE_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_LIGNITE_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> asbestosOres = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.ASBESTOS_ORE.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_ASBESTOS_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> aluminiumOreClusters = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.ALUMINIUM_ORE_CLUSTER.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_ALUMINIUM_ORE_CLUSTER.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> copperOreClusters = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.COPPER_ORE_CLUSTER.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_COPPER_ORE_CLUSTER.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> ironOreClusters = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.IRON_ORE_CLUSTER.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_IRON_ORE_CLUSTER.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> titaniumOreClusters = List.of(
          OreConfiguration.target(StoneReplaceable, NTMBlocks.TITANIUM_ORE_CLUSTER.defaultBlockState()),
          OreConfiguration.target(DeepslateReplaceable, NTMBlocks.DEEPSLATE_TITANIUM_ORE_CLUSTER.defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> smolderingNetherrack = List.of(
          OreConfiguration.target(NetherrackReplaceable, NTMBlocks.SMOLDERING_NETHERRACK.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> netherCoalOres = List.of(
          OreConfiguration.target(NetherrackReplaceable, NTMBlocks.NETHER_COAL_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> netherUraniumOres = List.of(
          OreConfiguration.target(NetherrackReplaceable, NTMBlocks.NETHER_URANIUM_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> netherPlutoniumOres = List.of(
          OreConfiguration.target(NetherrackReplaceable, NTMBlocks.NETHER_PLUTONIUM_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> netherTungstenOres = List.of(
          OreConfiguration.target(NetherrackReplaceable, NTMBlocks.NETHER_TUNGSTEN_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> netherSulfurOres = List.of(
          OreConfiguration.target(NetherrackReplaceable, NTMBlocks.NETHER_SULFUR_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> netherPhosphorusOres = List.of(
          OreConfiguration.target(NetherrackReplaceable, NTMBlocks.NETHER_PHOSPHORUS_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> netherCobaltOres = List.of(
          OreConfiguration.target(NetherrackReplaceable, NTMBlocks.NETHER_COBALT_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> netherSchrabidiumOres = List.of(
          OreConfiguration.target(NetherrackReplaceable, NTMBlocks.NETHER_SCHRABIDIUM_ORE.defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> trixiteOres = List.of(
          OreConfiguration.target(EndStoneReplaceable, NTMBlocks.TRIXITE_ORE.defaultBlockState())
        );

        register(context, URANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(uraniumOres, 10));
        register(context, TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(titaniumOres, 10));
        register(context, SULFUR_ORE_KEY, Feature.ORE, new OreConfiguration(sulfurOres, 10));
        register(context, THORIUM_ORE_KEY, Feature.ORE, new OreConfiguration(thoriumOres, 10));
        register(context, NITER_ORE_KEY, Feature.ORE, new OreConfiguration(niterOres, 10));
        register(context, TUNGSTEN_ORE_KEY, Feature.ORE, new OreConfiguration(tungstenOres, 10));
        register(context, ALUMINIUM_BEARING_ORE_KEY, Feature.ORE, new OreConfiguration(aluminiumBearingOres, 10));
        register(context, FLUORITE_ORE_KEY, Feature.ORE, new OreConfiguration(fluoriteOres, 10));
        register(context, LEAD_ORE_KEY, Feature.ORE, new OreConfiguration(leadOres, 10));
        register(context, SCHRABIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(schrabidiumOres, 10));
        register(context, BERYLLIUM_ORE_KEY, Feature.ORE, new OreConfiguration(berylliumOres, 10));
        register(context, AUSTRALIUM_ORE_KEY, Feature.ORE, new OreConfiguration(australiumOres, 10));
        register(context, RARE_EARTH_ORE_KEY, Feature.ORE, new OreConfiguration(rareEarthOres, 10));
        register(context, COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(cobaltOres, 10));
        register(context, CINNEBAR_ORE_KEY, Feature.ORE, new OreConfiguration(cinnebarOres, 10));
        register(context, COLTAN_ORE_KEY, Feature.ORE, new OreConfiguration(coltanOres, 10));
        register(context, LIGNITE_ORE_KEY, Feature.ORE, new OreConfiguration(ligniteOres, 10));
        register(context, ASBESTOS_ORE_KEY, Feature.ORE, new OreConfiguration(asbestosOres, 10));
        register(context, ALUMINIUM_ORE_CLUSTER_KEY, Feature.ORE, new OreConfiguration(aluminiumOreClusters, 10));
        register(context, COPPER_ORE_CLUSTER_KEY, Feature.ORE, new OreConfiguration(copperOreClusters, 10));
        register(context, IRON_ORE_CLUSTER_KEY, Feature.ORE, new OreConfiguration(ironOreClusters, 10));
        register(context, TITANIUM_ORE_CLUSTER_KEY, Feature.ORE, new OreConfiguration(titaniumOreClusters, 10));

        register(context, SMOLDERING_NETHERRACK_KEY, Feature.ORE, new OreConfiguration(smolderingNetherrack, 1));
        register(context, NETHER_COAL_ORE_KEY, Feature.ORE, new OreConfiguration(netherCoalOres, 1));
        register(context, NETHER_URANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherUraniumOres, 1));
        register(context, NETHER_PLUTONIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherPlutoniumOres, 1));
        register(context, NETHER_TUNGSTEN_ORE_KEY, Feature.ORE, new OreConfiguration(netherTungstenOres, 1));
        register(context, NETHER_SULFUR_ORE_KEY, Feature.ORE, new OreConfiguration(netherSulfurOres, 1));
        register(context, NETHER_PHOSPHORUS_ORE_KEY, Feature.ORE, new OreConfiguration(netherPhosphorusOres, 1));
        register(context, NETHER_COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(netherCobaltOres, 1));
        register(context, NETHER_SCHRABIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherSchrabidiumOres, 1));

        register(context, TRIXITE_ORE_KEY, Feature.ORE, new OreConfiguration(trixiteOres, 1));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, NTM.id(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(@NotNull BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
