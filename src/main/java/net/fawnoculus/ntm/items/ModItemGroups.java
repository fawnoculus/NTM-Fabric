package net.fawnoculus.ntm.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
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
      .icon(() -> new ItemStack(ModBlocks.ALLOY_FURNACE_EXTENSION))
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
      .icon(() -> new ItemStack(ModBlocks.LEAD_ORE))
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
    
    ItemGroupEvents.modifyEntriesEvent(RESOURCES_AND_PARTS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.STEEL_INGOT);
      ItemGroup.add(ModItems.URANIUM_INGOT);
    });
    ItemGroupEvents.modifyEntriesEvent(MACHINE_ITEMS_AND_FUEL_KEY).register(ItemGroup -> {
      ItemGroup.add(ModBlocks.ALLOY_FURNACE);
    });
    ItemGroupEvents.modifyEntriesEvent(TEMPLATES_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.NULL);
    });
    ItemGroupEvents.modifyEntriesEvent(ORES_AND_BLOCKS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModBlocks.URANIUM_ORE);
    });
    ItemGroupEvents.modifyEntriesEvent(MACHINES_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.NULL);
    });
    ItemGroupEvents.modifyEntriesEvent(BOMBS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.NULL);
    });
    ItemGroupEvents.modifyEntriesEvent(MISSILES_AND_SATELLITES_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.NULL);
    });
    ItemGroupEvents.modifyEntriesEvent(WEAPONS_AND_TURRETS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.NULL);
    });
    ItemGroupEvents.modifyEntriesEvent(CONSUMABLES_AND_GEAR_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.NULL);
    });
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ItemGroup -> {
      ItemGroup.add(ModItems.STEEL_SWORD);
      ItemGroup.add(ModItems.TITANIUM_SWORD);
      ItemGroup.add(ModItems.COBALT_SWORD);
      ItemGroup.add(ModItems.DECORATED_COBALT_SWORD);
      ItemGroup.add(ModItems.STARMETAL_SWORD);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_SWORD);
      ItemGroup.add(ModItems.CMB_STEEL_SWORD);
      ItemGroup.add(ModItems.DESH_SWORD);
    });
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ItemGroup -> {
      ItemGroup.add(ModItems.STEEL_SWORD);
      ItemGroup.add(ModItems.STEEL_PICKAXE);
      ItemGroup.add(ModItems.STEEL_AXE);
      ItemGroup.add(ModItems.STEEL_SHOVEL);
      ItemGroup.add(ModItems.STEEL_HOE);
      ItemGroup.add(ModItems.TITANIUM_PICKAXE);
      ItemGroup.add(ModItems.TITANIUM_AXE);
      ItemGroup.add(ModItems.TITANIUM_SHOVEL);
      ItemGroup.add(ModItems.TITANIUM_HOE);
      ItemGroup.add(ModItems.COBALT_PICKAXE);
      ItemGroup.add(ModItems.COBALT_AXE);
      ItemGroup.add(ModItems.COBALT_SHOVEL);
      ItemGroup.add(ModItems.COBALT_HOE);
      ItemGroup.add(ModItems.DECORATED_COBALT_PICKAXE);
      ItemGroup.add(ModItems.DECORATED_COBALT_AXE);
      ItemGroup.add(ModItems.DECORATED_COBALT_SHOVEL);
      ItemGroup.add(ModItems.DECORATED_COBALT_HOE);
      ItemGroup.add(ModItems.STARMETAL_PICKAXE);
      ItemGroup.add(ModItems.STARMETAL_AXE);
      ItemGroup.add(ModItems.STARMETAL_SHOVEL);
      ItemGroup.add(ModItems.STARMETAL_HOE);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_PICKAXE);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_AXE);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_SHOVEL);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_HOE);
      ItemGroup.add(ModItems.CMB_STEEL_PICKAXE);
      ItemGroup.add(ModItems.CMB_STEEL_AXE);
      ItemGroup.add(ModItems.CMB_STEEL_SHOVEL);
      ItemGroup.add(ModItems.CMB_STEEL_HOE);
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
