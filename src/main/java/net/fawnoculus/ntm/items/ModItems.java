package net.fawnoculus.ntm.items;

import net.fawnoculus.ntm.items.custom.tools.*;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

import static net.fawnoculus.ntm.items.ModToolMaterials.STEEL_TOOL_MATERIAL;


public class ModItems {
  // BASIC ITEMS
  public static final Item NULL = register("null", Item::new, new Item.Settings());


  // delete gleich again
  // Raw Ores & Ore based Resources
  public static final Item RAW_URANIUM = register("raw_uranium", Item::new, new Item.Settings());
  public static final Item RAW_SCORCHED_URANIUM = register("raw_scorched_uranium", Item::new, new Item.Settings());
  public static final Item RAW_PLUTONIUM = register("raw_plutonium", Item::new, new Item.Settings());
  public static final Item RAW_THORIUM = register("raw_thorium", Item::new, new Item.Settings());
  public static final Item RAW_TITANIUM = register("raw_titanium", Item::new, new Item.Settings());
  public static final Item RAW_TUNGSTEN = register("raw_tungsten", Item::new, new Item.Settings());
  public static final Item RAW_CRYOLITE = register("raw_cryolite", Item::new, new Item.Settings());
  public static final Item RAW_BERYLLIUM = register("raw_beryllium", Item::new, new Item.Settings());
  public static final Item RAW_LEAD = register("raw_lead", Item::new, new Item.Settings());
  public static final Item RAW_ASBESTOS = register("raw_asbestos", Item::new, new Item.Settings());
  public static final Item RAW_SCHRABIDIUM = register("raw_schrabidium", Item::new, new Item.Settings());
  public static final Item RAW_AUSTRALIUM = register("raw_australium", Item::new, new Item.Settings());
  public static final Item RAW_COLTAN = register("raw_coltan", Item::new, new Item.Settings());
  public static final Item RAW_METEORIC_IRON = register("raw_meteoric_iron", Item::new, new Item.Settings());
  public static final Item RAW_METEORIC_COPPER = register("raw_meteoric_copper", Item::new, new Item.Settings());
  public static final Item RAW_METEORIC_ALUMINIUM = register("raw_meteoric_aluminium", Item::new, new Item.Settings());
  public static final Item RAW_METEORIC_RARE_EARTH = register("raw_meteoric_rare_earth", Item::new, new Item.Settings());
  public static final Item RAW_METEORIC_COBALT = register("raw_meteoric_cobalt", Item::new, new Item.Settings());
  public static final Item RAW_TRIXITE = register("raw_trixite", Item::new, new Item.Settings());
  public static final Item RAW_OSMIRIDIUM = register("raw_osmiridium", Item::new, new Item.Settings());
  
  public static final Item URANIUM_INGOT = register("uranium_ingot", Item::new, new Item.Settings());
  public static final Item STEEL_INGOT = register("steel_ingot", Item::new, new Item.Settings());
  
  // TOOLS & WEAPONS
  public static final Item STEEL_SWORD = register("steel_sword",new Item.Settings(), settings -> new SpecialSword(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item STEEL_PICKAXE = register("steel_pickaxe",new Item.Settings(), settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item STEEL_AXE = register("steel_axe", new Item.Settings(), settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Decapitator()));
  public static final Item STEEL_SHOVEL = register("steel_shovel",new Item.Settings(), settings -> new SpecialShovel(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item STEEL_HOE = register("steel_hoe",new Item.Settings(), settings -> new SpecialHoe(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item TITANIUM_SWORD = register("titanium_sword",new Item.Settings(), settings -> new SpecialSword(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item TITANIUM_PICKAXE = register("titanium_pickaxe",new Item.Settings(), settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item TITANIUM_AXE = register("titanium_axe", new Item.Settings(), settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Decapitator()));
  public static final Item TITANIUM_SHOVEL = register("titanium_shovel",new Item.Settings(), settings -> new SpecialShovel(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item TITANIUM_HOE = register("titanium_hoe",new Item.Settings(), settings -> new SpecialHoe(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item COBALT_SWORD = register("cobalt_sword",new Item.Settings(), settings -> new SpecialSword(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item COBALT_PICKAXE = register("cobalt_pickaxe",new Item.Settings(), settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item COBALT_AXE = register("cobalt_axe", new Item.Settings(), settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Decapitator()));
  public static final Item COBALT_SHOVEL = register("cobalt_shovel",new Item.Settings(), settings -> new SpecialShovel(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item COBALT_HOE = register("cobalt_hoe",new Item.Settings(), settings -> new SpecialHoe(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item DECORATED_COBALT_SWORD = register("decorated_cobalt_sword",new Item.Settings(), settings -> new SpecialSword(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.LuckOfTheCollector()));
  public static final Item DECORATED_COBALT_PICKAXE = register("decorated_cobalt_pickaxe",new Item.Settings(), settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3))
      );
  public static final Item DECORATED_COBALT_AXE = register("decorated_cobalt_axe", new Item.Settings(), settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item DECORATED_COBALT_SHOVEL = register("decorated_cobalt_shovel",new Item.Settings(), settings -> new SpecialShovel(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3)));
  public static final Item DECORATED_COBALT_HOE = register("decorated_cobalt_hoe",new Item.Settings(), settings -> new SpecialHoe(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item STARMETAL_SWORD = register("starmetal_sword",new Item.Settings(), settings -> new SpecialSword(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Decapitator())
      .addModifier(new Modifiers.Stunning(3))
      .addModifier(new Modifiers.LuckOfTheCollector()));
  public static final Item STARMETAL_PICKAXE = register("starmetal_pickaxe",new Item.Settings(), settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(6))
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addModifier(new Modifiers.Stunning(3)));
  public static final Item STARMETAL_AXE = register("starmetal_axe", new Item.Settings(), settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(6))
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addModifier(new Modifiers.Decapitator())
      .addModifier(new Modifiers.Stunning(3)));
  public static final Item STARMETAL_SHOVEL = register("starmetal_shovel",new Item.Settings(), settings -> new SpecialShovel(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(6))
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addModifier(new Modifiers.Stunning(3)));
  public static final Item STARMETAL_HOE = register("starmetal_hoe",new Item.Settings(), settings -> new SpecialHoe(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item ADVANCED_ALLOY_SWORD = register("advanced_alloy_sword",new Item.Settings(), settings -> new SpecialSword(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Stunning(2)));
  public static final Item ADVANCED_ALLOY_PICKAXE = register("advanced_alloy_pickaxe",new Item.Settings(), settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(3)));
  public static final Item ADVANCED_ALLOY_AXE = register("advanced_alloy_axe", new Item.Settings(), settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(3))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item ADVANCED_ALLOY_SHOVEL = register("advanced_alloy_shovel",new Item.Settings(), settings -> new SpecialShovel(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(3)));
  public static final Item ADVANCED_ALLOY_HOE = register("advanced_alloy_hoe",new Item.Settings(), settings -> new SpecialHoe(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item CMB_STEEL_SWORD = register("cmb_steel_sword",new Item.Settings(), settings -> new SpecialSword(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Stunning(2))
      .addModifier(new Modifiers.Vampire(2.0f)));
  public static final Item CMB_STEEL_PICKAXE = register("cmb_steel_pickaxe",new Item.Settings(), settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3)));
  public static final Item CMB_STEEL_AXE = register("cmb_steel_axe", new Item.Settings(), settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item CMB_STEEL_SHOVEL = register("cmb_steel_shovel",new Item.Settings(), settings -> new SpecialShovel(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3)));
  public static final Item CMB_STEEL_HOE = register("cmb_steel_hoe",new Item.Settings(), settings -> new SpecialHoe(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item DESH_SWORD = register("desh_sword",new Item.Settings(), settings -> new SpecialSword(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Stunning(2))
      .addModifier(new Modifiers.Vampire(2.0f)));
  public static final Item DESH_PICKAXE = register("desh_pickaxe",new Item.Settings(), settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(2)));
  public static final Item DESH_AXE = register("desh_axe", new Item.Settings(), settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(2))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item DESH_SHOVEL = register("desh_shovel",new Item.Settings(), settings -> new SpecialShovel(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(2)));
  public static final Item DESH_HOE = register("desh_hoe",new Item.Settings(), settings -> new SpecialHoe(settings, STEEL_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item BISMUTH_PICKAXE = register("bismuth_pickaxe",new Item.Settings(), settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AutoShreader())
      .addAbility(new Abilities.Fortune(2))
      .addAbility(new Abilities.SilkTouch()));
  public static final Item BISMUTH_AXE = register("bismuth_axe", new Item.Settings(), settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AutoShreader())
      .addAbility(new Abilities.Fortune(2))
      .addAbility(new Abilities.SilkTouch())
      .addModifier(new Modifiers.Stunning(10))
      .addModifier(new Modifiers.Decapitator()));
  
  public static final Item MOLTEN_PICKAXE = register("molten_pickaxe",new Item.Settings(), settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.Fortune(3))
      .addAbility(new Abilities.SilkTouch())
      .addModifier(new Modifiers.Flaming(5))
      .addModifier(new Modifiers.Vampire(2.0f))
      .addModifier(new Modifiers.Decapitator())
      .canBreakDepthRock());
  public static final Item MOLTEN_AXE = register("molten_axe", new Item.Settings(), settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.Fortune(3))
      .addAbility(new Abilities.SilkTouch())
      .addModifier(new Modifiers.Flaming(10))
      .addModifier(new Modifiers.Vampire(3.0f))
      .addModifier(new Modifiers.Decapitator()));
  
  public static final Item CHLOROPHYTE_PICKAXE = register("chlorophyte_pickaxe",new Item.Settings(), settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.Fortune(4))
      .addAbility(new Abilities.AutoCentrifuge())
      .addAbility(new Abilities.MercuryTouch())
      .addModifier(new Modifiers.Stunning(10))
      .addModifier(new Modifiers.Vampire(5.0f))
      .addModifier(new Modifiers.Decapitator())
      .canBreakDepthRock());
  public static final Item CHLOROPHYTE_AXE = register("chlorophyte_axe", new Item.Settings(), settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.Fortune(4))
      .addModifier(new Modifiers.Stunning(10))
      .addModifier(new Modifiers.Vampire(5.0f))
      .addModifier(new Modifiers.Decapitator())
      .canBreakDepthRock());
  
  public static final Item MESE_PICKAXE = register("mese_pickaxe",new Item.Settings(), settings -> new SpecialPickaxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(3))
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.AutoCrystallizer())
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(9))
      .addAbility(new Abilities.Explosion(2.5f))
      .addAbility(new Abilities.Explosion(5.0f))
      .addAbility(new Abilities.Explosion(10.0f))
      .addAbility(new Abilities.Explosion(15.0f))
      .addModifier(new Modifiers.Stunning(10))
      .addModifier(new Modifiers.PhosphorusTip(60))
      .addModifier(new Modifiers.Decapitator())
      .canBreakDepthRock());
  public static final Item MESE_AXE = register("mese_axe", new Item.Settings(), settings -> new SpecialAxe(settings, STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(3))
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.AutoCrystallizer())
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(9))
      .addAbility(new Abilities.Explosion(2.5f))
      .addAbility(new Abilities.Explosion(5.0f))
      .addAbility(new Abilities.Explosion(10.0f))
      .addAbility(new Abilities.Explosion(15.0f))
      .addModifier(new Modifiers.Stunning(10))
      .addModifier(new Modifiers.PhosphorusTip(60))
      .addModifier(new Modifiers.Decapitator()));
  
  public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
    RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, NTM.id(name));
    Item item = itemFactory.apply(settings.registryKey(itemKey));
    Registry.register(Registries.ITEM, itemKey, item);
    return item;
  }
  
  public static Item register(String name, Item.Settings settings, Function<Item.Settings, Item> itemFactory) {
    return register(name, itemFactory, settings);
  }
  
  public static void initialize() {}
}