package net.fawnoculus.ntm.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;


public class ModItemGroups {
  
  public static final RegistryKey<ItemGroup> RESOURCES_AND_PARTS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("resources_and_parts"));
  public static final ItemGroup RESOURCES_AND_PARTS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.URANIUM_INGOT))
      .displayName(Text.translatable("itemGroup.ntm.resources_and_parts"))
      .build();
  public static final RegistryKey<ItemGroup> MACHINE_ITEMS_AND_FUEL_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("machine_items_and_fuel"));
  public static final ItemGroup MACHINE_ITEMS_AND_FUEL = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModBlocks.ALLOY_FURNACE))
      .displayName(Text.translatable("itemGroup.ntm.machine_items_and_fuel"))
      .build();
  public static final RegistryKey<ItemGroup> TEMPLATES_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("templates"));
  public static final ItemGroup TEMPLATES = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.NULL))
      .displayName(Text.translatable("itemGroup.ntm.templates"))
      .build();
  public static final RegistryKey<ItemGroup> ORES_AND_BLOCKS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("ores_and_blocks"));
  public static final ItemGroup ORES_AND_BLOCKS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModBlocks.URANIUM_ORE))
      .displayName(Text.translatable("itemGroup.ntm.ores_and_blocks"))
      .build();
  public static final RegistryKey<ItemGroup> MACHINES_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("machines"));
  public static final ItemGroup MACHINES = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.NULL))
      .displayName(Text.translatable("itemGroup.ntm.machines"))
      .build();
  public static final RegistryKey<ItemGroup> BOMBS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("bombs"));
  public static final ItemGroup BOMBS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.NULL))
      .displayName(Text.translatable("itemGroup.ntm.bombs"))
      .build();
  public static final RegistryKey<ItemGroup> MISSILES_AND_SATELLITES_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("missiles_and_satellites"));
  public static final ItemGroup MISSILES_AND_SATELLITES = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.NULL))
      .displayName(Text.translatable("itemGroup.ntm.missiles_and_satellites"))
      .build();
  public static final RegistryKey<ItemGroup> WEAPONS_AND_TURRETS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("weapons_and_turrets"));
  public static final ItemGroup WEAPONS_AND_TURRETS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.NULL))
      .displayName(Text.translatable("itemGroup.ntm.weapons_and_turrets"))
      .build();
  public static final RegistryKey<ItemGroup> CONSUMABLES_AND_GEAR_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("consumables_and_gear"));
  public static final ItemGroup CONSUMABLES_AND_GEAR = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.NULL))
      .displayName(Text.translatable("itemGroup.ntm.consumables_and_gear"))
      .build();
  public static final RegistryKey<ItemGroup> TOOLS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("tools"));
  public static final ItemGroup TOOLS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.ADVANCED_ALLOY_PICKAXE))
      .displayName(Text.translatable("itemGroup.ntm.tools"))
      .build();
  
  public static void initialize() {
    Registry.register(Registries.ITEM_GROUP, RESOURCES_AND_PARTS_KEY, RESOURCES_AND_PARTS);
    Registry.register(Registries.ITEM_GROUP, MACHINE_ITEMS_AND_FUEL_KEY, MACHINE_ITEMS_AND_FUEL);
    Registry.register(Registries.ITEM_GROUP, TEMPLATES_KEY, TEMPLATES);
    Registry.register(Registries.ITEM_GROUP, ORES_AND_BLOCKS_KEY, ORES_AND_BLOCKS);
    Registry.register(Registries.ITEM_GROUP, MACHINES_KEY, MACHINES);
    Registry.register(Registries.ITEM_GROUP, BOMBS_KEY, BOMBS);
    Registry.register(Registries.ITEM_GROUP, MISSILES_AND_SATELLITES_KEY, MISSILES_AND_SATELLITES);
    Registry.register(Registries.ITEM_GROUP, WEAPONS_AND_TURRETS_KEY, WEAPONS_AND_TURRETS);
    Registry.register(Registries.ITEM_GROUP, CONSUMABLES_AND_GEAR_KEY, CONSUMABLES_AND_GEAR);
    Registry.register(Registries.ITEM_GROUP, TOOLS_KEY, TOOLS);
    
    ItemGroupEvents.modifyEntriesEvent(RESOURCES_AND_PARTS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.STEEL_INGOT);
      ItemGroup.add(ModItems.URANIUM_INGOT);
    });
    ItemGroupEvents.modifyEntriesEvent(MACHINE_ITEMS_AND_FUEL_KEY).register(ItemGroup -> {
      ItemGroup.add(ModBlocks.ALLOY_FURNACE);
      ItemGroup.add(ModBlocks.ALLOY_FURNACE_EXTENSION);
    });
    ItemGroupEvents.modifyEntriesEvent(TEMPLATES_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.NULL);
      ItemGroup.add(ModItems.NULL);
    });
    ItemGroupEvents.modifyEntriesEvent(ORES_AND_BLOCKS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModBlocks.URANIUM_ORE);
      ItemGroup.add(ModBlocks.SCORCHED_URANIUM_ORE);
      ItemGroup.add(ModBlocks.TITANIUM_ORE);
      ItemGroup.add(ModBlocks.SULFUR_ORE);
      ItemGroup.add(ModBlocks.THORIUM_ORE);
      ItemGroup.add(ModBlocks.NITER_ORE);
      ItemGroup.add(ModBlocks.TUNGSTEN_ORE);
      ItemGroup.add(ModBlocks.ALUMINIUM_ORE);
      ItemGroup.add(ModBlocks.FLUORITE_ORE);
      ItemGroup.add(ModBlocks.LEAD_ORE);
      ItemGroup.add(ModBlocks.SCHRABIDIUM_ORE);
      ItemGroup.add(ModBlocks.BERYLLIUM_ORE);
      ItemGroup.add(ModBlocks.AUSTRALIUM_ORE);
      ItemGroup.add(ModBlocks.RARE_EARTH_ORE);
      ItemGroup.add(ModBlocks.COBALT_ORE);
      ItemGroup.add(ModBlocks.CINNEBAR_ORE);
      ItemGroup.add(ModBlocks.COLTAN_ORE);
      ItemGroup.add(ModBlocks.LIGNITE_ORE);
      ItemGroup.add(ModBlocks.ASBESTOS_ORE);
      ItemGroup.add(ModBlocks.OIL_DEPOSIT);
      ItemGroup.add(ModBlocks.EMPTY_OIL_DEPOSIT);
      ItemGroup.add(ModBlocks.ALUMINIUM_ORE_CLUSTER);
      ItemGroup.add(ModBlocks.COPPER_ORE_CLUSTER);
      ItemGroup.add(ModBlocks.IRON_ORE_CLUSTER);
      ItemGroup.add(ModBlocks.TITANIUM_ORE_CLUSTER);
      ItemGroup.add(ModBlocks.DEAD_DIRT);
      ItemGroup.add(ModBlocks.OILY_DIRT);
      ItemGroup.add(ModBlocks.OILY_SAND);
      ItemGroup.add(ModBlocks.DEPTH_ROCK);
      ItemGroup.add(ModBlocks.DEPTH_CINNABAR_ORE);
      ItemGroup.add(ModBlocks.DEPTH_ZIRCONIUM_ORE);
      ItemGroup.add(ModBlocks.DEPTH_BORAX_ORE);
      ItemGroup.add(ModBlocks.DEPTH_IRON_ORE_CLUSTER);
      ItemGroup.add(ModBlocks.DEPTH_TITANIUM_ORE_CLUSTER);
      ItemGroup.add(ModBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER);
      ItemGroup.add(ModBlocks.ALEXANDRITE_ORE);
      ItemGroup.add(ModBlocks.VOLCANIC_BASALT);
      ItemGroup.add(ModBlocks.SULFUR_RICH_VOLCANIC_BASALT);
      ItemGroup.add(ModBlocks.FLUORITE_RICH_VOLCANIC_BASALT);
      ItemGroup.add(ModBlocks.ASBESTOS_RICH_VOLCANIC_BASALT);
      ItemGroup.add(ModBlocks.GEM_RICH_VOLCANIC_BASALT);
      ItemGroup.add(ModBlocks.MOLYSITE_RICH_VOLCANIC_BASALT);
      ItemGroup.add(ModBlocks.SMOLDERING_NETHERRACK);
      ItemGroup.add(ModBlocks.NETHER_COAL_ORE);
      ItemGroup.add(ModBlocks.NETHER_URANIUM_ORE);
      ItemGroup.add(ModBlocks.SCORCHED_NETHER_URANIUM_ORE);
      ItemGroup.add(ModBlocks.NETHER_PLUTONIUM_ORE);
      ItemGroup.add(ModBlocks.NETHER_TUNGSTEN_ORE);
      ItemGroup.add(ModBlocks.NETHER_SULFUR_ORE);
      ItemGroup.add(ModBlocks.NETHER_COBALT_ORE);
      ItemGroup.add(ModBlocks.NETHER_SCHRABIDIUM_ORE);
      ItemGroup.add(ModBlocks.NETHER_DEPTH_ROCK);
      ItemGroup.add(ModBlocks.NETHER_DEPTH_NEODYMIUM_ORE);
      ItemGroup.add(ModBlocks.METEORITE_BLOCK);
      ItemGroup.add(ModBlocks.BROKEN_METEORITE_BLOCK);
      ItemGroup.add(ModBlocks.METEORITE_COBBLESTONE);
      ItemGroup.add(ModBlocks.HOT_METEORITE_COBBLESTONE);
      ItemGroup.add(ModBlocks.METEORITE_TREASURE_BLOCK);
      ItemGroup.add(ModBlocks.METEOR_IRON_ORE);
      ItemGroup.add(ModBlocks.METEOR_COPPER_ORE);
      ItemGroup.add(ModBlocks.METEOR_ALUMINIUM_ORE);
      ItemGroup.add(ModBlocks.METEOR_RARE_EARTH_ORE);
      ItemGroup.add(ModBlocks.METEOR_COBALT_ORE);
      ItemGroup.add(ModBlocks.GRAPHITIC_SCHIST);
      ItemGroup.add(ModBlocks.SCHIST_IRON_ORE);
      ItemGroup.add(ModBlocks.SCHIST_GOLD_ORE);
      ItemGroup.add(ModBlocks.SCHIST_URANIUM_ORE);
      ItemGroup.add(ModBlocks.SCORCHED_SCHIST_URANIUM_ORE);
      ItemGroup.add(ModBlocks.SCHIST_COPPER_ORE);
      ItemGroup.add(ModBlocks.SCHIST_ASBESTOS_ORE);
      ItemGroup.add(ModBlocks.SCHIST_LITHIUM_ORE);
      ItemGroup.add(ModBlocks.SCHIST_SCHRABIDIUM_ORE);
      ItemGroup.add(ModBlocks.SCHIST_RARE_EARTH_ORE);
      ItemGroup.add(ModBlocks.GAS_SHALE);
      ItemGroup.add(ModBlocks.BAUXITE);
      ItemGroup.add(ModBlocks.CHRYSOTILE);
      ItemGroup.add(ModBlocks.HEMATITE);
      ItemGroup.add(ModBlocks.LIMESTONE);
      ItemGroup.add(ModBlocks.MALACHITE);
      ItemGroup.add(ModBlocks.SULFUROUS_STONE);
      ItemGroup.add(ModBlocks.TEKITE);
      ItemGroup.add(ModBlocks.OSMIRIDIUM_INFUSED_TEKITE);
      ItemGroup.add(ModBlocks.GEOTHERMAL_VENT);
      ItemGroup.add(ModBlocks.BEDROCK_OIL_DEPOSIT);
      ItemGroup.add(ModBlocks.BEDROCK_ORE);
    });
    ItemGroupEvents.modifyEntriesEvent(MACHINES_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.NULL);
      ItemGroup.add(ModItems.NULL);
    });
    ItemGroupEvents.modifyEntriesEvent(BOMBS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.NULL);
      ItemGroup.add(ModItems.NULL);
    });
    ItemGroupEvents.modifyEntriesEvent(MISSILES_AND_SATELLITES_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.NULL);
      ItemGroup.add(ModItems.NULL);
    });
    ItemGroupEvents.modifyEntriesEvent(WEAPONS_AND_TURRETS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.NULL);
      ItemGroup.add(ModItems.NULL);
    });
    ItemGroupEvents.modifyEntriesEvent(CONSUMABLES_AND_GEAR_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.NULL);
      ItemGroup.add(ModItems.NULL);
    });
    ItemGroupEvents.modifyEntriesEvent(TOOLS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.STEEL_SWORD);
      ItemGroup.add(ModItems.STEEL_SWORD);
      ItemGroup.add(ModItems.STEEL_PICKAXE);
      ItemGroup.add(ModItems.STEEL_AXE);
      ItemGroup.add(ModItems.STEEL_SHOVEL);
      ItemGroup.add(ModItems.STEEL_HOE);
      ItemGroup.add(ModItems.TITANIUM_SWORD);
      ItemGroup.add(ModItems.TITANIUM_PICKAXE);
      ItemGroup.add(ModItems.TITANIUM_AXE);
      ItemGroup.add(ModItems.TITANIUM_SHOVEL);
      ItemGroup.add(ModItems.TITANIUM_HOE);
      ItemGroup.add(ModItems.COBALT_SWORD);
      ItemGroup.add(ModItems.COBALT_PICKAXE);
      ItemGroup.add(ModItems.COBALT_AXE);
      ItemGroup.add(ModItems.COBALT_SHOVEL);
      ItemGroup.add(ModItems.COBALT_HOE);
      ItemGroup.add(ModItems.DECORATED_COBALT_SWORD);
      ItemGroup.add(ModItems.DECORATED_COBALT_PICKAXE);
      ItemGroup.add(ModItems.DECORATED_COBALT_AXE);
      ItemGroup.add(ModItems.DECORATED_COBALT_SHOVEL);
      ItemGroup.add(ModItems.DECORATED_COBALT_HOE);
      ItemGroup.add(ModItems.STARMETAL_SWORD);
      ItemGroup.add(ModItems.STARMETAL_PICKAXE);
      ItemGroup.add(ModItems.STARMETAL_AXE);
      ItemGroup.add(ModItems.STARMETAL_SHOVEL);
      ItemGroup.add(ModItems.STARMETAL_HOE);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_SWORD);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_PICKAXE);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_AXE);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_SHOVEL);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_HOE);
      ItemGroup.add(ModItems.CMB_STEEL_SWORD);
      ItemGroup.add(ModItems.CMB_STEEL_PICKAXE);
      ItemGroup.add(ModItems.CMB_STEEL_AXE);
      ItemGroup.add(ModItems.CMB_STEEL_SHOVEL);
      ItemGroup.add(ModItems.CMB_STEEL_HOE);
      ItemGroup.add(ModItems.DESH_SWORD);
      ItemGroup.add(ModItems.DESH_PICKAXE);
      ItemGroup.add(ModItems.DESH_AXE);
      ItemGroup.add(ModItems.DESH_SHOVEL);
      ItemGroup.add(ModItems.DESH_HOE);
      ItemGroup.add(ModItems.BISMUTH_PICKAXE);
      ItemGroup.add(ModItems.BISMUTH_AXE);
      ItemGroup.add(ModItems.MOLTEN_PICKAXE);
      ItemGroup.add(ModItems.MOLTEN_AXE);
      ItemGroup.add(ModItems.CHLOROPHYTE_PICKAXE);
      ItemGroup.add(ModItems.CHLOROPHYTE_AXE);
      ItemGroup.add(ModItems.MESE_PICKAXE);
      ItemGroup.add(ModItems.MESE_AXE);
    });
  }
}
