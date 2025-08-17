package net.fawnoculus.ntm.blocks;

import net.fawnoculus.ntm.blocks.custom.*;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.custom.container.energy.SimpleEnergyStorageBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class NTMBlocks {
  // Block Settings
  private static final AbstractBlock.Settings STONE_ORE_SETTINGS = AbstractBlock.Settings.create()
    .sounds(BlockSoundGroup.STONE)
    .mapColor(MapColor.GRAY)
    .requiresTool()
    .strength(2f, 2f);
  private static final AbstractBlock.Settings SCHIST_ORE_SETTINGS = AbstractBlock.Settings.create()
    .sounds(BlockSoundGroup.STONE)
    .mapColor(MapColor.LIGHT_BLUE_GRAY)
    .requiresTool()
    .strength(2f, 2f);
  private static final AbstractBlock.Settings DEEPSLATE_ORE_SETTINGS = AbstractBlock.Settings.create()
    .sounds(BlockSoundGroup.DEEPSLATE)
    .mapColor(MapColor.DEEPSLATE_GRAY)
    .requiresTool()
    .strength(2f, 2f);
  private static final AbstractBlock.Settings VOLCANIC_BASALT_SETTINGS = AbstractBlock.Settings.create()
    .sounds(BlockSoundGroup.BASALT)
    .mapColor(MapColor.BLACK)
    .requiresTool()
    .strength(2f, 2f);
  private static final AbstractBlock.Settings NETHER_ORE_SETTINGS = AbstractBlock.Settings.create()
    .sounds(BlockSoundGroup.NETHER_ORE)
    .mapColor(MapColor.RED)
    .requiresTool()
    .strength(2f, 2f);
  private static final AbstractBlock.Settings GLOWING_NETHER_ORE_SETTINGS = AbstractBlock.Settings.create()
    .sounds(BlockSoundGroup.NETHER_ORE)
    .mapColor(MapColor.RED)
    .luminance(ignored -> 15)
    .requiresTool()
    .strength(2f, 2f);
  private static final AbstractBlock.Settings METEOR_STONE_SETTINGS = AbstractBlock.Settings.create()
    .sounds(BlockSoundGroup.STONE)
    .mapColor(MapColor.BLACK)
    .requiresTool()
    .strength(2f, 2f);
  private static final AbstractBlock.Settings DEPTH_STONE_SETTINGS = AbstractBlock.Settings.create()
    .sounds(BlockSoundGroup.STONE)
    .mapColor(MapColor.GRAY)
    .strength(Float.MAX_VALUE, 3600000.0f);
  private static final AbstractBlock.Settings DIRT_SETTINGS = AbstractBlock.Settings.create()
    .sounds(BlockSoundGroup.GRAVEL)
    .mapColor(MapColor.DIRT_BROWN);
  private static final AbstractBlock.Settings SAND_SETTINGS = AbstractBlock.Settings.create()
    .sounds(BlockSoundGroup.SAND)
    .mapColor(MapColor.PALE_YELLOW)
    .instrument(NoteBlockInstrument.SNARE);
  private static final AbstractBlock.Settings MACHINE_SETTINGS = AbstractBlock.Settings.create()
    .sounds(BlockSoundGroup.STONE)
    .mapColor(MapColor.GRAY)
    .strength(2f, 6.0f);
  private static AbstractBlock.Settings advancedModel(AbstractBlock.@NotNull Settings settings){
    return settings.nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never);
  }

  // Ore Blocks
  public static final Block URANIUM_ORE = register("uranium_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_URANIUM_ORE = register("deepslate_uranium_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block SCORCHED_URANIUM_ORE = register("scorched_uranium_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_SCORCHED_URANIUM_ORE = register("deepslate_scorched_uranium_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block TITANIUM_ORE = register("titanium_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_TITANIUM_ORE = register("deepslate_titanium_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block SULFUR_ORE = register("sulfur_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_SULFUR_ORE = register("deepslate_sulfur_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block THORIUM_ORE = register("thorium_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_THORIUM_ORE = register("deepslate_thorium_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block NITER_ORE = register("niter_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_NITER_ORE = register("deepslate_niter_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block TUNGSTEN_ORE = register("tungsten_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_TUNGSTEN_ORE = register("deepslate_tungsten_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block ALUMINIUM_BEARING_ORE = register("aluminium_bearing_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_ALUMINIUM_BEARING_ORE = register("deepslate_aluminium_bearing_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block FLUORITE_ORE = register("fluorite_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_FLUORITE_ORE = register("deepslate_fluorite_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block LEAD_ORE = register("lead_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_LEAD_ORE = register("deepslate_lead_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block SCHRABIDIUM_ORE = register("schrabidium_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_SCHRABIDIUM_ORE = register("deepslate_schrabidium_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block BERYLLIUM_ORE = register("beryllium_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_BERYLLIUM_ORE = register("deepslate_beryllium_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block AUSTRALIUM_ORE = register("australium_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_AUSTRALIUM_ORE = register("deepslate_australium_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block RARE_EARTH_ORE = register("rare_earth_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_RARE_EARTH_ORE = register("deepslate_rare_earth_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block COBALT_ORE = register("cobalt_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_COBALT_ORE = register("deepslate_cobalt_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block CINNEBAR_ORE = register("cinnebar_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_CINNEBAR_ORE = register("deepslate_cinnebar_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block COLTAN_ORE = register("coltan_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_COLTAN_ORE = register("deepslate_coltan_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block LIGNITE_ORE = register("lignite_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_LIGNITE_ORE = register("deepslate_lignite_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block ASBESTOS_ORE = register("asbestos_ore", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_ASBESTOS_ORE = register("deepslate_asbestos_ore", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block OIL_DEPOSIT = register("oil_deposit", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_OIL_DEPOSIT = register("deepslate_oil_deposit", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block EMPTY_OIL_DEPOSIT = register("empty_oil_deposit", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_EMPTY_OIL_DEPOSIT = register("deepslate_empty_oil_deposit", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block ALUMINIUM_ORE_CLUSTER = register("aluminium_ore_cluster", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_ALUMINIUM_ORE_CLUSTER = register("deepslate_aluminium_ore_cluster", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block COPPER_ORE_CLUSTER = register("copper_ore_cluster", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_COPPER_ORE_CLUSTER = register("deepslate_copper_ore_cluster", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block IRON_ORE_CLUSTER = register("iron_ore_cluster", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_IRON_ORE_CLUSTER = register("deepslate_iron_ore_cluster", Block::new, DEEPSLATE_ORE_SETTINGS);
  public static final Block TITANIUM_ORE_CLUSTER = register("titanium_ore_cluster", Block::new, STONE_ORE_SETTINGS);
  public static final Block DEEPSLATE_TITANIUM_ORE_CLUSTER = register("deepslate_titanium_ore_cluster", Block::new, DEEPSLATE_ORE_SETTINGS);

  public static final Block DEAD_DIRT = register("dead_dirt", Block::new, DIRT_SETTINGS.hardness(2f));
  public static final Block OILY_DIRT = register("oily_dirt", Block::new, DIRT_SETTINGS.hardness(2f));
  public static final Block OILY_SAND = register("oily_sand", Block::new, SAND_SETTINGS.hardness(2f));

  public static final Block DEPTH_ROCK = register("depth_rock", Block::new, DEPTH_STONE_SETTINGS);
  public static final Block DEPTH_CINNABAR_ORE = register("depth_cinnabar_ore", Block::new, DEPTH_STONE_SETTINGS);
  public static final Block DEPTH_ZIRCONIUM_ORE = register("depth_zirconium", Block::new, DEPTH_STONE_SETTINGS);
  public static final Block DEPTH_BORAX_ORE = register("depth_borax_ore", Block::new, DEPTH_STONE_SETTINGS);
  public static final Block DEPTH_IRON_ORE_CLUSTER = register("depth_iron_ore_cluster", Block::new, DEPTH_STONE_SETTINGS);
  public static final Block DEPTH_TITANIUM_ORE_CLUSTER = register("depth_titanium_ore_cluster", Block::new, DEPTH_STONE_SETTINGS);
  public static final Block DEPTH_TUNGSTEN_ORE_CLUSTER = register("depth_tungsten_ore_cluster", Block::new, DEPTH_STONE_SETTINGS);
  public static final Block ALEXANDRITE_ORE = register("alexandrite_ore", Block::new, DEPTH_STONE_SETTINGS);
  public static final Block DEEPSLATE_ALEXANDRITE_ORE = register("deepslate_alexandrite_ore", Block::new, DEPTH_STONE_SETTINGS);

  public static final Block VOLCANIC_BASALT = register("volcanic_basalt", Block::new, VOLCANIC_BASALT_SETTINGS);
  public static final Block SULFUR_RICH_VOLCANIC_BASALT = register("sulfur_rich_volcanic_basalt", Block::new, VOLCANIC_BASALT_SETTINGS);
  public static final Block FLUORITE_RICH_VOLCANIC_BASALT = register("fluorite_rich_volcanic_basalt", Block::new, VOLCANIC_BASALT_SETTINGS);
  public static final Block ASBESTOS_RICH_VOLCANIC_BASALT = register("asbestos_rich_volcanic_basalt", Block::new, VOLCANIC_BASALT_SETTINGS);
  public static final Block GEM_RICH_VOLCANIC_BASALT = register("gem_rich_volcanic_basalt", Block::new, VOLCANIC_BASALT_SETTINGS);
  public static final Block MOLYSITE_RICH_VOLCANIC_BASALT = register("molysite_rich_volcanic_basalt", Block::new, VOLCANIC_BASALT_SETTINGS);

  public static final Block SMOLDERING_NETHERRACK = register("smoldering_netherrack", Block::new, GLOWING_NETHER_ORE_SETTINGS);
  public static final Block NETHER_COAL_ORE = register("nether_coal_ore", Block::new, GLOWING_NETHER_ORE_SETTINGS);
  public static final Block NETHER_URANIUM_ORE = register("nether_uranium_ore", Block::new, NETHER_ORE_SETTINGS);
  public static final Block SCORCHED_NETHER_URANIUM_ORE = register("scorched_nether_uranium_ore", Block::new, NETHER_ORE_SETTINGS);
  public static final Block NETHER_PLUTONIUM_ORE = register("nether_plutonium_ore", Block::new, NETHER_ORE_SETTINGS);
  public static final Block NETHER_TUNGSTEN_ORE = register("nether_tungsten_ore", Block::new, NETHER_ORE_SETTINGS);
  public static final Block NETHER_SULFUR_ORE = register("nether_sulfur_ore", Block::new, NETHER_ORE_SETTINGS);
  public static final Block NETHER_PHOSPHORUS_ORE = register("nether_phosphorus_ore", Block::new, NETHER_ORE_SETTINGS);
  public static final Block NETHER_COBALT_ORE = register("nether_cobalt_ore", Block::new, NETHER_ORE_SETTINGS);
  public static final Block NETHER_SCHRABIDIUM_ORE = register("nether_schrabidium_ore", Block::new, NETHER_ORE_SETTINGS);

  public static final Block NETHER_DEPTH_ROCK = register("nether_depth_rock", Block::new, DEPTH_STONE_SETTINGS);
  public static final Block NETHER_DEPTH_NEODYMIUM_ORE = register("nether_depth_neodymium_ore", Block::new, DEPTH_STONE_SETTINGS);

  public static final Block METEORITE_BLOCK = register("meteorite_block", Block::new, METEOR_STONE_SETTINGS);
  public static final Block BROKEN_METEORITE_BLOCK = register("broken_meteorite_block", Block::new, METEOR_STONE_SETTINGS);
  public static final Block METEORITE_COBBLESTONE = register("meteorite_cobblestone", Block::new, METEOR_STONE_SETTINGS);
  public static final Block HOT_METEORITE_COBBLESTONE = register("hot_meteorite_cobblestone", Block::new, METEOR_STONE_SETTINGS);
  public static final Block METEORITE_TREASURE_BLOCK = register("meteorite_treasure_block", Block::new, METEOR_STONE_SETTINGS);
  public static final Block METEOR_IRON_ORE = register("meteor_iron_ore", Block::new, METEOR_STONE_SETTINGS);
  public static final Block METEOR_COPPER_ORE = register("meteor_copper_ore", Block::new, METEOR_STONE_SETTINGS);
  public static final Block METEOR_ALUMINIUM_ORE = register("meteor_aluminium_ore", Block::new, METEOR_STONE_SETTINGS);
  public static final Block METEOR_RARE_EARTH_ORE = register("meteor_rare_earth_ore", Block::new, METEOR_STONE_SETTINGS);
  public static final Block METEOR_COBALT_ORE = register("meteor_cobalt_ore", Block::new, METEOR_STONE_SETTINGS);

  public static final Block GRAPHITIC_SCHIST = register("graphitic_schist", Block::new, SCHIST_ORE_SETTINGS);
  public static final Block SCHIST_IRON_ORE = register("schist_iron_ore", Block::new, SCHIST_ORE_SETTINGS);
  public static final Block SCHIST_GOLD_ORE = register("schist_gold_ore", Block::new, SCHIST_ORE_SETTINGS);
  public static final Block SCHIST_URANIUM_ORE = register("schist_uranium_ore", Block::new, SCHIST_ORE_SETTINGS);
  public static final Block SCORCHED_SCHIST_URANIUM_ORE = register("scorched_schist_uranium_ore", Block::new, SCHIST_ORE_SETTINGS);
  public static final Block SCHIST_COPPER_ORE = register("schist_copper_ore", Block::new, SCHIST_ORE_SETTINGS);
  public static final Block SCHIST_ASBESTOS_ORE = register("schist_asbestos_ore", Block::new, SCHIST_ORE_SETTINGS);
  public static final Block SCHIST_LITHIUM_ORE = register("schist_lithium_ore", Block::new, SCHIST_ORE_SETTINGS);
  public static final Block SCHIST_SCHRABIDIUM_ORE = register("schist_schrabidium_ore", Block::new, SCHIST_ORE_SETTINGS);
  public static final Block SCHIST_RARE_EARTH_ORE = register("schist_rare_earth_ore", Block::new, SCHIST_ORE_SETTINGS);
  public static final Block GAS_SHALE = register("gas_shale", Block::new, SCHIST_ORE_SETTINGS);

  public static final Block BAUXITE = register("bauxite", Block::new, STONE_ORE_SETTINGS);
  public static final Block CHRYSOTILE = register("chrysotile", Block::new, STONE_ORE_SETTINGS);
  public static final Block HEMATITE = register("hematite", Block::new, STONE_ORE_SETTINGS);
  public static final Block LIMESTONE = register("limestone", Block::new, STONE_ORE_SETTINGS);
  public static final Block MALACHITE = register("malachite", Block::new, STONE_ORE_SETTINGS);
  public static final Block SULFUROUS_STONE = register("sulfurous_stone", Block::new, STONE_ORE_SETTINGS);

  public static final Block TEKTITE = register("tektite", Block::new, STONE_ORE_SETTINGS);
  public static final Block OSMIRIDIUM_INFUSED_TEKTITE = register("osmiridium_infused_tektite", Block::new, STONE_ORE_SETTINGS);
  public static final Block TRIXITE_ORE = register("trixite_ore", Block::new, STONE_ORE_SETTINGS);

  public static final Block GEOTHERMAL_VENT = register("geothermal_vent", Block::new, AbstractBlock.Settings.copy(Blocks.BEDROCK));
  public static final Block BEDROCK_OIL_DEPOSIT = register("bedrock_oil_deposit", Block::new, AbstractBlock.Settings.copy(Blocks.BEDROCK));
  public static final Block BEDROCK_ORE = register("bedrock_ore", Block::new, AbstractBlock.Settings.copy(Blocks.BEDROCK));

  // Resource Blocks
  public static final Block ACTINIUM_227_BLOCK = register("actinium_227_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block ADVANCED_ALLOY_BLOCK = register("advanced_alloy_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block ALUMINIUM_BLOCK = register("aluminium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block ASBESTOS_BLOCK = register("asbestos_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block AUSTRALIUM_BLOCK = register("australium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block BAKELITE_BLOCK = register("bakelite_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block BERYLLIUM_BLOCK = register("beryllium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block BISMUTH_BLOCK = register("bismuth_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block BORON_BLOCK = register("boron_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block CADMIUM_BLOCK = register("cadmium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block CADMIUM_STEEL_BLOCK = register("cadmium_steel_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block CMB_STEEL_BLOCK = register("cmb_steel_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block COAL_COKE_BLOCK = register("coal_coke_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block COBALT_BLOCK = register("cobalt_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block COLTAN_BLOCK = register("coltan_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block DESH_BLOCK = register("desh_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block DINEUTRONIUM_BLOCK = register("dineutronium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block EUPHEMIUM_BLOCK = register("euphemium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block FERRIC_SCHRABIDATE_BLOCK = register("ferric_schrabidate_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block FLUORITE_BLOCK = register("fluorite_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block GRAPHITE_BLOCK = register("graphite_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block HIGH_SPEED_STEEL_BLOCK = register("high_speed_steel_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block LIGNITE_COKE_BLOCK = register("lignite_coke_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block LEAD_BLOCK = register("lead_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block LITHIUM_BLOCK = register("lithium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block MAGNETIZED_TUNGSTEN_BLOCK = register("magnetized_tungsten_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block MOX_FUEL_BLOCK = register("mox_fuel_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block NEPTUNIUM_BLOCK = register("neptunium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block NIOBIUM_BLOCK = register("niobium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block NITER_BLOCK = register("niter_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block PETROLEUM_COKE_BLOCK = register("petroleum_coke_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block PLUTONIUM_BLOCK = register("plutonium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block PLUTONIUM_FUEL_BLOCK = register("plutonium_fuel_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block REACTOR_GRADE_PLUTONIUM_BLOCK = register("reactor_grade_plutonium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block PLUTONIUM_238_BLOCK = register("plutonium_238_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block PLUTONIUM_239_BLOCK = register("plutonium_239_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block PLUTONIUM_240_BLOCK = register("plutonium_240_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block PLUTONIUM_241_BLOCK = register("plutonium_241_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block POLONIUM_210_BLOCK = register("polonium_210_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block POLYMER_BLOCK = register("polymer_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block RADIUM_226_BLOCK = register("radium_266_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block RED_COPPER_BLOCK = register("red_copper_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block RED_PHOSPHORUS_BLOCK = register("red_phosphorus_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block RUBBER_BLOCK = register("rubber_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block SCHRABIDIUM_BLOCK = register("schrabidium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block SCHRABIDIUM_FUEL_BLOCK = register("schrabidium_fuel_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block SCHRARANIUM_BLOCK = register("schraranium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block SEMTEX_BLOCK = register("semtex_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block SOLINIUM_BLOCK = register("solinium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block STARMETAL_BLOCK = register("starmetal_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block STEEL_BLOCK = register("steel_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block SULFUR_BLOCK = register("sulfur_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block TANTALUM_BLOCK = register("tantalum_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block TECHNETIUM_STEEL_BLOCK = register("technetium_steel_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block THORIUM_232_BLOCK = register("thorium_232_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block THORIUM_FUEL_BLOCK = register("thorium_fuel_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block TITANIUM_BLOCK = register("titanium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block TUNGSTEN_BLOCK = register("tungsten_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block URANIUM_BLOCK = register("uranium_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block URANIUM_FUEL_BLOCK = register("uranium_fuel_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block URANIUM_233_BLOCK = register("uranium_233_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block URANIUM_235_BLOCK = register("uranium_235_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block URANIUM_238_BLOCK = register("uranium_238_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block WHITE_PHOSPHORUS_BLOCK = register("white_phosphorus_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block YELLOWCAKE_BLOCK = register("yellowcake_block", Block::new, STONE_ORE_SETTINGS);
  public static final Block ZIRCONIUM_BLOCK = register("zirconium_block", Block::new, STONE_ORE_SETTINGS);





  public static final Block ALLOY_FURNACE = register("alloy_furnace", AlloyFurnaceBlock::new, AbstractBlock.Settings.create()
    .sounds(BlockSoundGroup.STONE)
    .strength(2f, 6.0f)
    .mapColor(MapColor.TERRACOTTA_ORANGE)
  );
  public static final Block ALLOY_FURNACE_EXTENSION = register("alloy_furnace_extension", AlloyFurnaceExtensionBlock::new, advancedModel(AbstractBlock.Settings.create())
    .strength(1.5F, 6.0F)
    .sounds(BlockSoundGroup.STONE)
    .mapColor(MapColor.TERRACOTTA_ORANGE)
  );
  public static final Block ELECTRIC_FURNACE = register("electric_furnace", ElectricFurnaceBlock::new, MACHINE_SETTINGS);
  public static final Block PWR_CONTROLLER = register("pwr_controller", PWRControllerBlock::new, MACHINE_SETTINGS);

  // Energy Stuff
  public static final Block TEMP_CABLE = register("temp_cable", TempCableBlock::new, AbstractBlock.Settings.create());
  public static final Block POTATO_BATTERY_BLOCK = register("potato_battery_block", settings -> new SimpleEnergyStorageBlock(settings, 10_000L), AbstractBlock.Settings.create());
  public static final Block ENERGY_STORAGE_BLOCK = register("energy_storage_block", settings -> new SimpleEnergyStorageBlock(settings, 1_000_000L), AbstractBlock.Settings.create());
  public static final Block LITHIUM_ION_ENERGY_STORAGE_BLOCK = register("lithium_ion_energy_storage_block", settings -> new SimpleEnergyStorageBlock(settings, 50_000_000L), AbstractBlock.Settings.create());
  public static final Block SCHRABIDIUM_ENERGY_STORAGE_BLOCK = register("schrabidium_energy_storage_block", settings -> new SimpleEnergyStorageBlock(settings, 25_000_000_000L), AbstractBlock.Settings.create());
  public static final Block SPARK_ENERGY_STORAGE_BLOCK = register("spark_energy_storage_block", settings -> new SimpleEnergyStorageBlock(settings, 1_000_000_000_000L), AbstractBlock.Settings.create());

  // FluidNetworkType Stuff
  /* FIXME
  public static final Block SAFE_BARREL = register("safe_barrel", settings -> new SimpleFluidStorageBlock(settings, 12_000), AbstractBlock.Settings.create());
  public static final Block SAFE_BARREL = register("safe_barrel", settings -> new SimpleFluidStorageBlock(settings, 12_000), AbstractBlock.Settings.create());
  public static final Block SAFE_BARREL = register("safe_barrel", settings -> new SimpleFluidStorageBlock(settings, 12_000), AbstractBlock.Settings.create());
  public static final Block SAFE_BARREL = register("safe_barrel", settings -> new SimpleFluidStorageBlock(settings, 12_000), AbstractBlock.Settings.create());
  public static final Block SAFE_BARREL = register("safe_barrel", settings -> new SimpleFluidStorageBlock(settings, 12_000), AbstractBlock.Settings.create());
  public static final Block SAFE_BARREL = register("safe_barrel", settings -> new SimpleFluidStorageBlock(settings, 12_000), AbstractBlock.Settings.create());
   */

  private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings){
    return register(name, blockFactory, settings, true);
  }
  private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean registerItem){
    RegistryKey<Block> blockKey = keyOfBlock(name);
    Block block = blockFactory.apply(settings.registryKey(blockKey));

    if (registerItem) {
      RegistryKey<Item> itemKey = keyOfItem(name);
      BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
      Registry.register(Registries.ITEM, itemKey, blockItem);
    }

    return Registry.register(Registries.BLOCK, blockKey, block);
  }
  private static RegistryKey<Block> keyOfBlock(String name){
    return RegistryKey.of(RegistryKeys.BLOCK, NTM.id(name));
  }
  private static RegistryKey<Item> keyOfItem(String name) {
    return RegistryKey.of(RegistryKeys.ITEM, NTM.id(name));
  }

  public static void initialize() {}
}
