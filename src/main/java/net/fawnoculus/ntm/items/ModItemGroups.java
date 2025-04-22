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
import net.minecraft.util.Identifier;


public class ModItemGroups {
  
  public static final RegistryKey<ItemGroup> RESOURCES_AND_PARTS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(NTM.MOD_ID, "resources_and_parts"));
  public static final ItemGroup RESOURCES_AND_PARTS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.URANIUM_INGOT))
      .displayName(Text.translatable("itemGroup.ntm.resources_and_parts"))
      .build();
  public static final RegistryKey<ItemGroup> MACHINE_ITEMS_AND_FUEL_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(NTM.MOD_ID, "machine_items_and_fuel"));
  public static final ItemGroup MACHINE_ITEMS_AND_FUEL = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.URANIUM_INGOT))
      .displayName(Text.translatable("itemGroup.ntm.machine_items_and_fuel"))
      .build();
  public static final RegistryKey<ItemGroup> TEMPLATES_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(NTM.MOD_ID, "templates"));
  public static final ItemGroup TEMPLATES = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.URANIUM_INGOT))
      .displayName(Text.translatable("itemGroup.ntm.templates"))
      .build();
  public static final RegistryKey<ItemGroup> ORES_AND_BLOCKS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(NTM.MOD_ID, "ores_and_blocks"));
  public static final ItemGroup ORES_AND_BLOCKS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModBlocks.URANIUM_ORE))
      .displayName(Text.translatable("itemGroup.ntm.ores_and_blocks"))
      .build();
  public static final RegistryKey<ItemGroup> MACHINES_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(NTM.MOD_ID, "machines"));
  public static final ItemGroup MACHINES = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.URANIUM_INGOT))
      .displayName(Text.translatable("itemGroup.ntm.machines"))
      .build();
  public static final RegistryKey<ItemGroup> BOMBS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(NTM.MOD_ID, "bombs"));
  public static final ItemGroup BOMBS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.URANIUM_INGOT))
      .displayName(Text.translatable("itemGroup.ntm.bombs"))
      .build();
  public static final RegistryKey<ItemGroup> MISSILES_AND_SATELLITES_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(NTM.MOD_ID, "missiles_and_satellites"));
  public static final ItemGroup MISSILES_AND_SATELLITES = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.URANIUM_INGOT))
      .displayName(Text.translatable("itemGroup.ntm.missiles_and_satellites"))
      .build();
  public static final RegistryKey<ItemGroup> WEAPONS_AND_TURRETS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(NTM.MOD_ID, "weapons_and_turrets"));
  public static final ItemGroup WEAPONS_AND_TURRETS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.URANIUM_INGOT))
      .displayName(Text.translatable("itemGroup.ntm.weapons_and_turrets"))
      .build();
  public static final RegistryKey<ItemGroup> CONSUMABLES_AND_GEAR_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(NTM.MOD_ID, "consumables_and_gear"));
  public static final ItemGroup CONSUMABLES_AND_GEAR = FabricItemGroup.builder()
      .icon(() -> new ItemStack(ModItems.URANIUM_INGOT))
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
      ItemGroup.add(ModItems.URANIUM_INGOT);
      ItemGroup.add(ModItems.STEEL_INGOT);
    });
    ItemGroupEvents.modifyEntriesEvent(MACHINE_ITEMS_AND_FUEL_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.URANIUM_INGOT);
      ItemGroup.add(ModItems.STEEL_INGOT);
    });
    ItemGroupEvents.modifyEntriesEvent(ORES_AND_BLOCKS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModBlocks.URANIUM_ORE);
    });
    ItemGroupEvents.modifyEntriesEvent(TEMPLATES_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.URANIUM_INGOT);
      ItemGroup.add(ModItems.STEEL_INGOT);
    });
    ItemGroupEvents.modifyEntriesEvent(MACHINES_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.URANIUM_INGOT);
      ItemGroup.add(ModItems.STEEL_INGOT);
    });
    ItemGroupEvents.modifyEntriesEvent(BOMBS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.URANIUM_INGOT);
      ItemGroup.add(ModItems.STEEL_INGOT);
    });
    ItemGroupEvents.modifyEntriesEvent(MISSILES_AND_SATELLITES_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.URANIUM_INGOT);
      ItemGroup.add(ModItems.STEEL_INGOT);
    });
    ItemGroupEvents.modifyEntriesEvent(WEAPONS_AND_TURRETS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.URANIUM_INGOT);
      ItemGroup.add(ModItems.STEEL_INGOT);
    });
    ItemGroupEvents.modifyEntriesEvent(CONSUMABLES_AND_GEAR_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.STEEL_SWORD);
      ItemGroup.add(ModItems.STEEL_PICKAXE);
      ItemGroup.add(ModItems.STEEL_AXE);
      ItemGroup.add(ModItems.STEEL_SHOVEL);
      ItemGroup.add(ModItems.STEEL_HOE);
    });
    ItemGroupEvents.modifyEntriesEvent(RESOURCES_AND_PARTS_KEY).register(ItemGroup -> {
      ItemGroup.add(ModItems.URANIUM_INGOT);
      ItemGroup.add(ModItems.STEEL_INGOT);
    });
  }
}
