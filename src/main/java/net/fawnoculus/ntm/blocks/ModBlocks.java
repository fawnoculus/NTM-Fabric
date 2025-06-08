package net.fawnoculus.ntm.blocks;

import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceBlock;
import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceExtensionBlock;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

public class ModBlocks {
  private static final AbstractBlock.Settings STONE_SETTINGS = AbstractBlock.Settings.create()
      .sounds(BlockSoundGroup.STONE)
      .mapColor(MapColor.GRAY)
      .requiresTool()
      .strength(2f, 2f);
  private static final AbstractBlock.Settings DEPTH_STONE_SETTINGS = AbstractBlock.Settings.create()
      .sounds(BlockSoundGroup.STONE)
      .mapColor(MapColor.GRAY)
      .strength(Float.MAX_VALUE, 3600000.0f); // Making it unbreakable is a temporary solution!
  private static final AbstractBlock.Settings DIRT_SETTINGS = AbstractBlock.Settings.create()
      .sounds(BlockSoundGroup.GRAVEL)
      .mapColor(MapColor.DIRT_BROWN);
  private static final AbstractBlock.Settings SAND_SETTINGS = AbstractBlock.Settings.create()
      .sounds(BlockSoundGroup.SAND)
      .mapColor(MapColor.PALE_YELLOW)
      .instrument(NoteBlockInstrument.SNARE);
		
  
  public static final Block URANIUM_ORE = register("uranium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block SCORCHED_URANIUM_ORE = register("scorched_uranium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block TITANIUM_ORE = register("titanium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block SULFUR_ORE = register("sulfur_ore", Block::new, STONE_SETTINGS, true);
  public static final Block THORIUM_ORE = register("thorium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block NITER_ORE = register("niter_ore", Block::new, STONE_SETTINGS, true);
  public static final Block TUNGSTEN_ORE = register("tungsten_ore", Block::new, STONE_SETTINGS, true);
  public static final Block ALUMINIUM_ORE = register("aluminium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block FLUORITE_ORE = register("fluorite_ore", Block::new, STONE_SETTINGS, true);
  public static final Block LEAD_ORE = register("lead_ore", Block::new, STONE_SETTINGS, true);
  public static final Block SCHRABIDIUM_ORE = register("schrabidium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block BERYLLIUM_ORE = register("beryllium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block AUSTRALIUM_ORE = register("australium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block RARE_EARTH_ORE = register("rare_earth_ore", Block::new, STONE_SETTINGS, true);
  public static final Block COBALT_ORE = register("cobalt_ore", Block::new, STONE_SETTINGS, true);
  public static final Block CINNEBAR_ORE = register("cinnebar_ore", Block::new, STONE_SETTINGS, true);
  public static final Block COLTAN_ORE = register("coltan_ore", Block::new, STONE_SETTINGS, true);
  public static final Block LIGNITE_ORE = register("lignite_ore", Block::new, STONE_SETTINGS, true);
  public static final Block ASBESTOS_ORE = register("asbestos_ore", Block::new, STONE_SETTINGS, true);
  public static final Block OIL_DEPOSIT = register("oil_deposit", Block::new, STONE_SETTINGS, true);
  public static final Block EMPTY_OIL_DEPOSIT = register("empty_oil_deposit", Block::new, STONE_SETTINGS, true);
  public static final Block ALUMINIUM_ORE_CLUSTER = register("aluminium_ore_cluster", Block::new, STONE_SETTINGS, true);
  public static final Block COPPER_ORE_CLUSTER = register("copper_ore_cluster", Block::new, STONE_SETTINGS, true);
  public static final Block IRON_ORE_CLUSTER = register("iron_ore_cluster", Block::new, STONE_SETTINGS, true);
  public static final Block TITANIUM_ORE_CLUSTER = register("titanium_ore_cluster", Block::new, STONE_SETTINGS, true);
  
  public static final Block DEAD_DIRT = register("dead_dirt", Block::new, DIRT_SETTINGS.hardness(2f), true);
  public static final Block OILY_DIRT = register("oily_dirt", Block::new, DIRT_SETTINGS.hardness(2f), true);
  public static final Block OILY_SAND = register("oily_sand", Block::new, SAND_SETTINGS.hardness(2f), true);
  
  public static final Block DEPTH_ROCK = register("depth_rock", Block::new, DEPTH_STONE_SETTINGS, true);
  public static final Block DEPTH_CINNABAR_ORE = register("depth_cinnabar_ore", Block::new, DEPTH_STONE_SETTINGS, true);
  public static final Block DEPTH_ZIRCONIUM_ORE = register("depth_zirconium", Block::new, DEPTH_STONE_SETTINGS, true);
  public static final Block DEPTH_BORAX_ORE = register("depth_borax_ore", Block::new, DEPTH_STONE_SETTINGS, true);
  public static final Block DEPTH_IRON_ORE_CLUSTER = register("depth_iron_ore_cluster", Block::new, DEPTH_STONE_SETTINGS, true);
  public static final Block DEPTH_TITANIUM_ORE_CLUSTER = register("depth_titanium_ore_cluster", Block::new, DEPTH_STONE_SETTINGS, true);
  public static final Block DEPTH_TUNGSTEN_ORE_CLUSTER = register("depth_tungsten_ore_cluster", Block::new, DEPTH_STONE_SETTINGS, true);
  public static final Block ALEXANDRITE_ORE = register("alexandrite_ore", Block::new, DEPTH_STONE_SETTINGS, true);
  
  public static final Block VOLCANIC_BASALT = register("volcanic_basalt", Block::new, STONE_SETTINGS, true);
  public static final Block SULFUR_RICH_VOLCANIC_BASALT = register("sulfur_rich_volcanic_basalt", Block::new, STONE_SETTINGS, true);
  public static final Block FLUORITE_RICH_VOLCANIC_BASALT = register("fluorite_rich_volcanic_basalt", Block::new, STONE_SETTINGS, true);
  public static final Block ASBESTOS_RICH_VOLCANIC_BASALT = register("asbestos_rich_volcanic_basalt", Block::new, STONE_SETTINGS, true);
  public static final Block GEM_RICH_VOLCANIC_BASALT = register("gem_rich_volcanic_basalt", Block::new, STONE_SETTINGS, true);
  public static final Block MOLYSITE_RICH_VOLCANIC_BASALT = register("molysite_rich_volcanic_basalt", Block::new, STONE_SETTINGS, true);
  
  public static final Block SMOLDERING_NETHERRACK = register("smoldering_netherrack", Block::new, STONE_SETTINGS, true);
  public static final Block NETHER_COAL_ORE = register("nether_coal_ore", Block::new, STONE_SETTINGS, true);
  public static final Block NETHER_URANIUM_ORE = register("nether_uranium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block SCORCHED_NETHER_URANIUM_ORE = register("scorched_nether_uranium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block NETHER_PLUTONIUM_ORE = register("nether_plutonium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block NETHER_TUNGSTEN_ORE = register("nether_tungsten_ore", Block::new, STONE_SETTINGS, true);
  public static final Block NETHER_SULFUR_ORE = register("nether_sulfur_ore", Block::new, STONE_SETTINGS, true);
  public static final Block NETHER_PHOSPHORUS_ORE = register("nether_phosphorus_ore", Block::new, STONE_SETTINGS, true);
  public static final Block NETHER_COBALT_ORE = register("nether_cobalt_ore", Block::new, STONE_SETTINGS, true);
  public static final Block NETHER_SCHRABIDIUM_ORE = register("nether_schrabidium_ore", Block::new, STONE_SETTINGS, true);
  
  public static final Block NETHER_DEPTH_ROCK = register("nether_depth_rock", Block::new, DEPTH_STONE_SETTINGS, true);
  public static final Block NETHER_DEPTH_NEODYMIUM_ORE = register("nether_depth_neodymium_ore", Block::new, DEPTH_STONE_SETTINGS, true);
  
  public static final Block METEORITE_BLOCK = register("meteorite_block", Block::new, STONE_SETTINGS, true);
  public static final Block BROKEN_METEORITE_BLOCK = register("broken_meteorite_block", Block::new, STONE_SETTINGS, true);
  public static final Block METEORITE_COBBLESTONE = register("meteorite_cobblestone", Block::new, STONE_SETTINGS, true);
  public static final Block HOT_METEORITE_COBBLESTONE = register("hot_meteorite_cobblestone", Block::new, STONE_SETTINGS, true);
  public static final Block METEORITE_TREASURE_BLOCK = register("meteorite_treasure_block", Block::new, STONE_SETTINGS, true);
  public static final Block METEOR_IRON_ORE = register("meteor_iron_ore", Block::new, STONE_SETTINGS, true);
  public static final Block METEOR_COPPER_ORE = register("meteor_copper_ore", Block::new, STONE_SETTINGS, true);
  public static final Block METEOR_ALUMINIUM_ORE = register("meteor_aluminium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block METEOR_RARE_EARTH_ORE = register("meteor_rare_earth_ore", Block::new, STONE_SETTINGS, true);
  public static final Block METEOR_COBALT_ORE = register("meteor_cobalt_ore", Block::new, STONE_SETTINGS, true);
  
  public static final Block GRAPHITIC_SCHIST = register("graphitic_schist", Block::new, STONE_SETTINGS, true);
  public static final Block SCHIST_IRON_ORE = register("schist_iron_ore", Block::new, STONE_SETTINGS, true);
  public static final Block SCHIST_GOLD_ORE = register("schist_gold_ore", Block::new, STONE_SETTINGS, true);
  public static final Block SCHIST_URANIUM_ORE = register("schist_uranium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block SCORCHED_SCHIST_URANIUM_ORE = register("scorched_schist_uranium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block SCHIST_COPPER_ORE = register("schist_copper_ore", Block::new, STONE_SETTINGS, true);
  public static final Block SCHIST_ASBESTOS_ORE = register("schist_asbestos_ore", Block::new, STONE_SETTINGS, true);
  public static final Block SCHIST_LITHIUM_ORE = register("schist_lithium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block SCHIST_SCHRABIDIUM_ORE = register("schist_schrabidium_ore", Block::new, STONE_SETTINGS, true);
  public static final Block SCHIST_RARE_EARTH_ORE = register("schist_rare_earth_ore", Block::new, STONE_SETTINGS, true);
  public static final Block GAS_SHALE = register("gas_shale", Block::new, STONE_SETTINGS, true);
  
  public static final Block BAUXITE = register("bauxite", Block::new, STONE_SETTINGS, true);
  public static final Block CHRYSOTILE = register("chrysotile", Block::new, STONE_SETTINGS, true);
  public static final Block HEMATITE = register("hematite", Block::new, STONE_SETTINGS, true);
  public static final Block LIMESTONE = register("limestone", Block::new, STONE_SETTINGS, true);
  public static final Block MALACHITE = register("malachite", Block::new, STONE_SETTINGS, true);
  public static final Block SULFUROUS_STONE = register("sulfurous_stone", Block::new, STONE_SETTINGS, true);
  
  public static final Block TEKITE = register("tekite", Block::new, STONE_SETTINGS, true);
  public static final Block OSMIRIDIUM_INFUSED_TEKITE = register("osmiridium_infused_tekite", Block::new, STONE_SETTINGS, true);
  public static final Block TRIXITE_ORE = register("trixite_ore", Block::new, STONE_SETTINGS, true);
  
  public static final Block GEOTHERMAL_VENT = register("geothermal_vent", Block::new, STONE_SETTINGS, true);
  public static final Block BEDROCK_OIL_DEPOSIT = register("bedrock_oil_deposit", Block::new, STONE_SETTINGS, true);
  public static final Block BEDROCK_ORE = register("bedrock_ore", Block::new, STONE_SETTINGS, true);
  
  
  public static final Block ALLOY_FURNACE = register("alloy_furnace", AlloyFurnaceBlock::new, AbstractBlock.Settings.create()
          .strength(1.5F, 6.0F)
          .sounds(BlockSoundGroup.STONE)
          .mapColor(MapColor.TERRACOTTA_ORANGE)
          .requiresTool()
  , true);
  public static final Block ALLOY_FURNACE_EXTENSION = register("alloy_furnace_extension", AlloyFurnaceExtensionBlock::new, AbstractBlock.Settings.create(), true);
  
  
  
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
