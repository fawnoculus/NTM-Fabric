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
  public static final Item URANIUM_233_INGOT = register("uranium_233_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_235_INGOT = register("uranium_235_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_238_INGOT = register("uranium_238_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_FUEL_INGOT = register("uranium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_INGOT = register("plutonium_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_238_INGOT = register("plutonium_238_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_239_INGOT = register("plutonium_239_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_240_INGOT = register("plutonium_240_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_241_INGOT = register("plutonium_241_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_FUEL_INGOT = register("plutonium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_PLUTONIUM__INGOT = register("reactor_grade_plutonium_ingot", Item::new, new Item.Settings());
  public static final Item THORIUM_232_INGOT = register("thorium_232_ingot", Item::new, new Item.Settings());
  public static final Item THORIUM_FUEL_INGOT = register("thorium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item TITANIUM_INGOT = register("titanium_ingot", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_INGOT = register("tungsten_ingot", Item::new, new Item.Settings());
  public static final Item MAGNETIZED_TUNGSTEN_INGOT = register("magnetized_tungsten_ingot", Item::new, new Item.Settings());
  public static final Item ALUMINIUM_INGOT = register("aluminium_ingot", Item::new, new Item.Settings());
  public static final Item BERYLLIUM_INGOT = register("beryllium_ingot", Item::new, new Item.Settings());
  public static final Item LEAD_INGOT = register("lead_ingot", Item::new, new Item.Settings());
  public static final Item LEAD_209_INGOT = register("lead_209_ingot", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_INGOT = register("schrabidium_ingot", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_FUEL_INGOT = register("schrabidium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT = register("low_enriched_schrabidium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT = register("highly_enriched_schrabidium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item AUSTRALIUM_INGOT = register("australium_ingot", Item::new, new Item.Settings());
  public static final Item OSMIRIDIUM_INGOT = register("osmiridium_ingot", Item::new, new Item.Settings());
  public static final Item AMERICIUM_241_INGOT = register("americium_241_ingot", Item::new, new Item.Settings());
  public static final Item AMERICIUM_242_INGOT = register("americium_242_ingot", Item::new, new Item.Settings());
  public static final Item AMERICIUM_FUEL_INGOT = register("americium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_AMERICIUM_INGOT = register("reactor_grade_americium_ingot", Item::new, new Item.Settings());
  public static final Item CURIUM_242_INGOT = register("curium_242_ingot", Item::new, new Item.Settings());
  public static final Item CURIUM_243_INGOT = register("curium_243_ingot", Item::new, new Item.Settings());
  public static final Item CURIUM_244_INGOT = register("curium_244_ingot", Item::new, new Item.Settings());
  public static final Item CURIUM_245_INGOT = register("curium_245_ingot", Item::new, new Item.Settings());
  public static final Item CURIUM_246_INGOT = register("curium_246_ingot", Item::new, new Item.Settings());
  public static final Item CURIUM_247_INGOT = register("curium_247_ingot", Item::new, new Item.Settings());
  public static final Item CURIUM_FUEL_INGOT = register("curium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_CURIUM_INGOT = register("reactor_grade_curium_ingot", Item::new, new Item.Settings());
  public static final Item BERKELIUM_247_INGOT = register("berkelium_247_ingot", Item::new, new Item.Settings());
  public static final Item CALIFORNIUM_251_INGOT = register("californium_251_ingot", Item::new, new Item.Settings());
  public static final Item CALIFORNIUM_252_INGOT = register("californium_252_ingot", Item::new, new Item.Settings());
  public static final Item EINSTEINIUM_253_INGOT = register("einsteinium_253_ingot", Item::new, new Item.Settings());
  public static final Item EINSTEINIUM_255_INGOT = register("einsteinium_255_ingot", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_INGOT = register("neptunium_ingot", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_FUEL_INGOT = register("neptunium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item POLONIUM_210_INGOT = register("polonium_210_ingot", Item::new, new Item.Settings());
  public static final Item TECHNETIUM_99_INGOT = register("technetium_99_ingot", Item::new, new Item.Settings());
  public static final Item TECHNETIUM_STEEL_INGOT = register("technetium_steel_ingot", Item::new, new Item.Settings());
  public static final Item COBALT_INGOT = register("cobalt_ingot", Item::new, new Item.Settings());
  public static final Item COBALT_60_INGOT = register("cobalt_60_ingot", Item::new, new Item.Settings());
  public static final Item STRONTIUM_INGOT = register("strontium_ingot", Item::new, new Item.Settings());
  public static final Item STRONTIUM_90_INGOT = register("strontium_90_ingot", Item::new, new Item.Settings());
  public static final Item GOLD_198_INGOT = register("gold_198_ingot", Item::new, new Item.Settings());
  public static final Item RADIUM_226_INGOT = register("radium_266_ingot", Item::new, new Item.Settings());
  public static final Item NICKEL_INGOT = register("nickel_ingot", Item::new, new Item.Settings());
  public static final Item RED_COPPER_INGOT = register("red_copper_ingot", Item::new, new Item.Settings()); // => Minecraft Grade Copper
  public static final Item ADVANCED_ALLOY_INGOT = register("advanced_alloy_ingot", Item::new, new Item.Settings());
  public static final Item ZINC_INGOT = register("zinc_ingot", Item::new, new Item.Settings());
  public static final Item GALLIUM_INGOT = register("gallium_ingot", Item::new, new Item.Settings());
  public static final Item GALLIUM_ARSENIDE_INGOT = register("gallium_arsenide_ingot", Item::new, new Item.Settings());
  public static final Item TECHTACTIUM_INGOT = register("techtactium_ingot", Item::new, new Item.Settings());
  public static final Item TECHTACTIUM_ARSENIDE_INGOT = register("techtactium_arsenide_ingot", Item::new, new Item.Settings());
  public static final Item PLATINIUM_INGOT = register("platinium_ingot", Item::new, new Item.Settings());
  public static final Item IRIDIUM_INGOT = register("iridium_ingot", Item::new, new Item.Settings());
  public static final Item PALLADIUM_INGOT = register("palladium_ingot", Item::new, new Item.Settings());
  public static final Item STEEL_INGOT = register("steel_ingot", Item::new, new Item.Settings());
  public static final Item STAINLESS_STEEL_INGOT = register("stainless_steel_ingot", Item::new, new Item.Settings());
  public static final Item BSCCO_INGOT = register("bscco_ingot", Item::new, new Item.Settings());
  public static final Item BISMUTH_INGOT = register("bismuth_ingot", Item::new, new Item.Settings());
  public static final Item BISMUTH_BRONZE_INGOT = register("bismuth_bronze_ingot", Item::new, new Item.Settings());
  public static final Item ARSENIC_INGOT = register("arsenic_ingot", Item::new, new Item.Settings());
  public static final Item ARSENIC_BRONZE_INGOT = register("arsenic_bronze_ingot", Item::new, new Item.Settings());
  public static final Item CALCIUM_INGOT = register("calcium_ingot", Item::new, new Item.Settings());
  public static final Item CADMIUM_INGOT = register("cadmium_ingot", Item::new, new Item.Settings());
  public static final Item CADMIUM_STEEL_INGOT = register("cadmium_steel_ingot", Item::new, new Item.Settings());
  public static final Item TANTALUM_INGOT = register("tantalum_ingot", Item::new, new Item.Settings()); // AKA TANALIUM
  public static final Item NIOBIUM_INGOT = register("niobium_ingot", Item::new, new Item.Settings());
  public static final Item BORON_INGOT = register("boron_ingot", Item::new, new Item.Settings());
  public static final Item GRAPHITE_INGOT = register("graphite_ingot", Item::new, new Item.Settings());
  public static final Item HIGH_SPEED_STEEL_INGOT = register("high_speed_steel_ingot", Item::new, new Item.Settings());
  public static final Item VULCANITE_INGOT = register("vulcanite_ingot", Item::new, new Item.Settings());
  public static final Item SCHRARANIUM_INGOT = register("schraranium_ingot", Item::new, new Item.Settings());
  public static final Item FERRIC_SCHARBIDATE_INGOT = register("ferric_schrabidate_ingot", Item::new, new Item.Settings());
  public static final Item CMB_STEEL_INGOT = register("cmb_steel_ingot", Item::new, new Item.Settings());
  public static final Item SOLINIUM_INGOT = register("solinium_ingot", Item::new, new Item.Settings());
  public static final Item GHIORSIUM_336_INGOT = register("ghiorsium_336_ingot", Item::new, new Item.Settings());
  public static final Item CHINESIUM_989_INGOT = register("chinesium_989_ingot", Item::new, new Item.Settings());
  public static final Item MOX_FUEL_INGOT = register("mox_fuel_ingot", Item::new, new Item.Settings());
  public static final Item SEMI_STABLE_LANTHANUM_INGOT = register("semi_stable_lanthanum_ingot", Item::new, new Item.Settings());
  public static final Item ACTINIUM_227_INGOT = register("actinium_227_ingot", Item::new, new Item.Settings());
  public static final Item DESH_INGOT = register("desh_ingot", Item::new, new Item.Settings());
  public static final Item FERROURANIUM_INGOT = register("ferrouranium_ingot", Item::new, new Item.Settings());
  public static final Item STARMETAL_INGOT = register("starmetal_ingot", Item::new, new Item.Settings());
  public static final Item GUNMETAL_INGOT = register("gunmetal_ingot", Item::new, new Item.Settings());
  public static final Item WEAPON_STEEL_INGOT = register("weapon_steel_ingot", Item::new, new Item.Settings());
  public static final Item SATURNITE_INGOT = register("saturnite_ingot", Item::new, new Item.Settings());
  public static final Item EUPHEMIUM_INGOT = register("euphemium_ingot", Item::new, new Item.Settings());
  public static final Item DINEUTRONIUM_INGOT = register("dineutronium_ingot", Item::new, new Item.Settings());
  public static final Item ELECTRONIUM_INGOT = register("electronium_ingot", Item::new, new Item.Settings());
  public static final Item GWENIUM_INGOT = register("gwenium_ingot", Item::new, new Item.Settings());
  public static final Item HAFNIUM_INGOT = register("hafnium_ingot", Item::new, new Item.Settings());
  public static final Item DUSTED_STEEL_INGOT = register("dusted_steel_ingot", Item::new, new Item.Settings());
  public static final Item HEAVY_CHAINSTEEL_INGOT = register("heavy_chainsteel_ingot", Item::new, new Item.Settings());
  public static final Item METEORITE_INGOT = register("meteorite_ingot", Item::new, new Item.Settings());


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