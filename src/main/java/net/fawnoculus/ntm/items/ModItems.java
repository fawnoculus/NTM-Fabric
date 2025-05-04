package net.fawnoculus.ntm.items;

import net.fawnoculus.ntm.items.custom.tools.*;
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
  public static void initialize() {}
  
  public static final Item STEEL_SWORD = register("steel_sword",settings -> new SpecialSword(settings, STEEL_TOOL_MATERIAL, 1f, 1f), new Item.Settings());
  public static final Item STEEL_PICKAXE = register("steel_pickaxe",settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
          .addAbility(new Abilities.AoE(2))
          .addAbility(new Abilities.VeinMiner(3))
          .addAbility(new Abilities.AutoSmelt())
          .addAbility(new Abilities.Fortune(2))
          .addAbility(new Abilities.SilkTouch())
          .addAbility(new Abilities.Explosion(3))
          .addAbility(new Abilities.MercuryTouch())
      , new Item.Settings());
  public static final Item STEEL_AXE = register("steel_axe", settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f), new Item.Settings());
  public static final Item STEEL_SHOVEL = register("steel_shovel",settings -> new SpecialShovel(settings, STEEL_TOOL_MATERIAL, 1f, 1f), new Item.Settings());
  public static final Item STEEL_HOE = register("steel_hoe",settings -> new SpecialHoe(settings, STEEL_TOOL_MATERIAL, 1f, 1f), new Item.Settings());
  
  public static final Item NULL = register("null", Item::new, new Item.Settings());
  public static final Item URANIUM_INGOT = register("uranium_ingot", Item::new, new Item.Settings());
  public static final Item STEEL_INGOT = register("steel_ingot", Item::new, new Item.Settings());
  
  
  
  
  public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings){
    RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NTM.MOD_ID, name));
    Item item = itemFactory.apply(settings.registryKey(itemKey));
    Registry.register(Registries.ITEM, itemKey, item);
    return item;
  }public static Item register(String name, Item.Settings settings, Function<Item.Settings, Item> itemFactory){
    return register(name, itemFactory, settings);
  }
}
