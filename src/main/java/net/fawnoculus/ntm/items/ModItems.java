package net.fawnoculus.ntm.items;

import net.fawnoculus.ntm.main.NTM;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static net.fawnoculus.ntm.items.ModToolMaterials.STEEL_TOOL_MATERIAL;

public class ModItems {
  public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings){
    RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NTM.MOD_ID, name));
    Item item = itemFactory.apply(settings.registryKey(itemKey));
    Registry.register(Registries.ITEM, itemKey, item);
    return item;
  }
  
  public static void initialize() {}
  
  public static final Item URANIUM_INGOT = register("uranium_ingot", Item::new, new Item.Settings());
  public static final Item STEEL_INGOT = register("steel_ingot", Item::new, new Item.Settings());
  
  public static final Item STEEL_SWORD = register("steel_sword", Item::new, new Item.Settings().sword(STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item STEEL_PICKAXE = register("steel_pickaxe", Item::new, new Item.Settings().pickaxe(STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item STEEL_AXE = register("steel_axe", Item::new, new Item.Settings().axe(STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item STEEL_SHOVEL = register("steel_shovel", Item::new, new Item.Settings().shovel(STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item STEEL_HOE = register("steel_hoe", Item::new, new Item.Settings().hoe(STEEL_TOOL_MATERIAL, 1f, 1f));
}
