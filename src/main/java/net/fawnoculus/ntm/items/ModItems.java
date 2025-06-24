package net.fawnoculus.ntm.items;

import net.fawnoculus.ntm.items.custom.*;
import net.fawnoculus.ntm.items.custom.consumable.*;
import net.fawnoculus.ntm.items.custom.tools.*;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

import java.util.List;
import java.util.function.Function;

public class ModItems {

  // Basic Items
  public static final Item NULL = register("null", Item::new, new Item.Settings());
  public static final Item DEBUG_WAND = register("debug_wand", DebugWandItem::new, new Item.Settings());
  public static final Item CONSTRUCTION_WAND = register("construction_wand", ConstructionWandItem::new, new Item.Settings());
  
  // Basic Resources split by Type sorted Alphabetically because I felt like it
  public static final Item ACTINIUM_227_INGOT = register("actinium_227_ingot", Item::new, new Item.Settings());
  public static final Item ACTINIUM_227_BILLET = register("actinium_227_billet", Item::new, new Item.Settings());
  public static final Item ACTINIUM_227_POWDER = register("actinium_227_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_ACTINIUM_227_POWDER = register("tiny_pile_of_actinium_227_powder", Item::new, new Item.Settings());
  public static final Item ACTINIUM_227_NUGGET = register("actinium_227_nugget", Item::new, new Item.Settings());
  public static final Item ACTINIUM_227_FRAGMENT = register("actinium_227_fragment", Item::new, new Item.Settings());
  
  public static final Item ADVANCED_ALLOY_INGOT = register("advanced_alloy_ingot", Item::new, new Item.Settings());
  public static final Item ADVANCED_ALLOY_POWDER = register("advanced_alloy_powder", Item::new, new Item.Settings());
  public static final Item ADVANCED_ALLOY_PLATE = register("advanced_alloy_plate", Item::new, new Item.Settings());
  public static final Item CAST_ADVANCED_ALLOY_PLATE = register("cast_advanced_alloy_plate", Item::new, new Item.Settings());
  public static final Item ADVANCED_ALLOY_WIRE = register("advanced_alloy_wire", Item::new, new Item.Settings());
  public static final Item DENSE_ADVANCED_ALLOY_WIRE = register("dense_advanced_alloy_wire", Item::new, new Item.Settings());
  
  public static final Item ALEXANDRITE = register("alexandrite", Item::new, new Item.Settings());
  
  public static final Item RAW_METEORIC_ALUMINIUM = register("raw_meteoric_aluminium", Item::new, new Item.Settings());
  public static final Item ALUMINIUM_INGOT = register("aluminium_ingot", Item::new, new Item.Settings());
  public static final Item ALUMINIUM_POWDER = register("aluminium_powder", Item::new, new Item.Settings());
  public static final Item ALUMINIUM_PLATE = register("aluminium_plate", Item::new, new Item.Settings());
  public static final Item CAST_ALUMINIUM_PLATE = register("cast_aluminium_plate", Item::new, new Item.Settings());
  public static final Item WELDED_ALUMINIUM_PLATE = register("welded_aluminium_plate", Item::new, new Item.Settings());
  public static final Item ALUMINIUM_SHELL = register("aluminium_shell", Item::new, new Item.Settings());
  public static final Item ALUMINIUM_PIPE = register("aluminium_pipe", Item::new, new Item.Settings());
  public static final Item ALUMINIUM_WIRE = register("aluminium_wire", Item::new, new Item.Settings());
  public static final Item ALUMINIUM_CRYSTALS = register("aluminium_crystals", Item::new, new Item.Settings());
  
  public static final Item AMERICIUM_241_INGOT = register("americium_241_ingot", Item::new, new Item.Settings());
  public static final Item AMERICIUM_242_INGOT = register("americium_242_ingot", Item::new, new Item.Settings());
  public static final Item AMERICIUM_FUEL_INGOT = register("americium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_AMERICIUM_INGOT = register("reactor_grade_americium_ingot", Item::new, new Item.Settings());
  
  public static final Item ARSENIC_INGOT = register("arsenic_ingot", Item::new, new Item.Settings());
  public static final Item ARSENIC_NUGGET = register("arsenic_nugget", Item::new, new Item.Settings());
  public static final Item ARSENIC_BRONZE_INGOT = register("arsenic_bronze_ingot", Item::new, new Item.Settings());
  public static final Item CAST_ARSENIC_BRONZE_PLATE = register("cast_arsenic_bronze_plate", Item::new, new Item.Settings());
  
  public static final Item ASBESTOS_SHEET = register("asbestos_sheet", Item::new, new Item.Settings());

  public static final Item RAW_AUSTRALIUM = register("raw_australium", Item::new, new Item.Settings());
  public static final Item AUSTRALIUM_INGOT = register("australium_ingot", Item::new, new Item.Settings());
  public static final Item AUSTRALIUM_BILLET = register("australium_billet", Item::new, new Item.Settings());
  public static final Item LESSER_AUSTRALIUM_BILLET = register("lesser_australium_ingot", Item::new, new Item.Settings());
  public static final Item GREATER_AUSTRALIUM_BILLET = register("greater_australium_ingot", Item::new, new Item.Settings());
  public static final Item AUSTRALIUM_NUGGET = register("australium_nugget", Item::new, new Item.Settings());
  public static final Item LESSER_AUSTRALIUM_NUGGET = register("lesser_australium_nugget", Item::new, new Item.Settings());
  public static final Item GREATER_AUSTRALIUM_NUGGET = register("greater_australium_nugget", Item::new, new Item.Settings());
  public static final Item AUSTRALIUM_POWDER = register("australium_powder", Item::new, new Item.Settings());
  
  public static final Item BAKELITE_BAR = register("bakelite_bar", Item::new, new Item.Settings());
  public static final Item BAKELITE_POWDER = register("bakelite_powder", Item::new, new Item.Settings());
  
  public static final Item RAW_BERYLLIUM = register("raw_beryllium", Item::new, new Item.Settings());
  public static final Item BERYLLIUM_INGOT = register("beryllium_ingot", Item::new, new Item.Settings());
  public static final Item BERYLLIUM_BILLET = register("beryllium_billet", Item::new, new Item.Settings());
  public static final Item BERYLLIUM_NUGGET = register("beryllium_nugget", Item::new, new Item.Settings());
  public static final Item BERYLLIUM_POWDER = register("beryllium_powder", Item::new, new Item.Settings());
  public static final Item BERYLLIUM_CRYSTALS = register("beryllium_crystals", Item::new, new Item.Settings());
  
  public static final Item BISMUTH_INGOT = register("bismuth_ingot", Item::new, new Item.Settings());
  public static final Item BISMUTH_BILLET = register("bismuth_billet", Item::new, new Item.Settings());
  public static final Item BISMUTH_ZFB_BILLET = register("bismuth_zfb_ingot", Item::new, new Item.Settings());
  public static final Item BISMUTH_POWDER = register("bismuth_powder", Item::new, new Item.Settings());
  public static final Item BISMUTH_NUGGET = register("bismuth_nugget", Item::new, new Item.Settings());
  public static final Item BISMUTH_BRONZE_INGOT = register("bismuth_bronze_ingot", Item::new, new Item.Settings());
  public static final Item CAST_BISMUTH_BRONZE_PLATE = register("cast_bismuth_bronze_plate", Item::new, new Item.Settings());
  
  public static final Item BORON_INGOT = register("boron_ingot", Item::new, new Item.Settings());
  public static final Item BORON_POWDER = register("boron_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_BORON_POWDER = register("tiny_pile_of_boron_powder", Item::new, new Item.Settings());
  public static final Item BORON_FRAGMENT = register("boron_fragment", Item::new, new Item.Settings());
  
  public static final Item BORAX_INGOT = register("borax_ingot", Item::new, new Item.Settings());
  public static final Item BORAX_POWDER = register("borax_powder", Item::new, new Item.Settings());
  
  public static final Item BSCCO_INGOT = register("bscco_ingot", Item::new, new Item.Settings());
  public static final Item DENSE_BSCCO_WIRE = register("dense_bscco_wire", Item::new, new Item.Settings());
  
  public static final Item CADMIUM_INGOT = register("cadmium_ingot", Item::new, new Item.Settings());
  
  public static final Item CALCIUM_INGOT = register("calcium_ingot", Item::new, new Item.Settings());
  public static final Item CALCIUM_POWDER = register("calcium_powder", Item::new, new Item.Settings());
  
  public static final Item CADMIUM_STEEL_INGOT = register("cadmium_steel_ingot", Item::new, new Item.Settings());
  public static final Item CAST_CADMIUM_STEEL_PLATE = register("cast_cadmium_steel_plate", Item::new, new Item.Settings());
  public static final Item WELDED_CADMIUM_STEEL_PLATE = register("welded_cadmium_steel_plate", Item::new, new Item.Settings());
  
  public static final Item CERIUM_POWDER = register("cerium_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_CERIUM_POWDER = register("tiny_pile_of_cerium_powder", Item::new, new Item.Settings());
  public static final Item CERIUM_FRAGMENT = register("cerium_fragment", Item::new, new Item.Settings());
  
  public static final Item CHLOROCALCITE = register("chlorocalcite", Item::new, new Item.Settings());
  
  public static final Item CINNABAR = register("cinnabar", Item::new, new Item.Settings());
  public static final Item CINNABAR_CRYSTALS = register("cinnabar_crystals", Item::new, new Item.Settings());
  
  public static final Item CMB_STEEL_INGOT = register("cmb_steel_ingot", TooltipItem::new, new Item.Settings());
  public static final Item CMB_STEEL_POWDER = register("cmb_steel_powder", Item::new, new Item.Settings());
  public static final Item CAST_CMB_STEEL_PLATE = register("cast_cmb_steel_plate", Item::new, new Item.Settings());
  public static final Item WELDED_CMB_STEEL_PLATE = register("welded_cmb_steel_plate", Item::new, new Item.Settings());
  public static final Item CMB_STEEL_PLATE = register("cmb_steel_plate", Item::new, new Item.Settings());

  public static final Item COAL_POWDER = register("coal_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_COAL_POWDER = register("tiny_pile_of_coal_powder", Item::new, new Item.Settings());
  public static final Item CARBON_WIRE = register("carbon_wire", Item::new, new Item.Settings());
  
  public static final Item COBALT_INGOT = register("cobalt_ingot", Item::new, new Item.Settings());
  public static final Item COBALT_60_INGOT = register("cobalt_60_ingot", Item::new, new Item.Settings());
  public static final Item COBALT_FRAGMENT = register("cobalt_fragment", Item::new, new Item.Settings());
  public static final Item COBALT_CRYSTALS = register("cobalt_crystals", Item::new, new Item.Settings());
  public static final Item RAW_METEORIC_COBALT = register("raw_meteoric_cobalt", Item::new, new Item.Settings());
  
  public static final Item COLTAN = register("coltan", Item::new, new Item.Settings());
  public static final Item CRUSHED_COLTAN = register("crushed_coltan", Item::new, new Item.Settings()); // Turns into TANTALUM

  public static final Item COPPER_POWDER = register("copper_powder", Item::new, new Item.Settings());
  public static final Item COPPER_PLATE = register("copper_plate", Item::new, new Item.Settings());
  public static final Item CAST_COPPER_PLATE = register("cast_copper_plate", Item::new, new Item.Settings());
  public static final Item WELDED_COPPER_PLATE = register("welded_copper_plate", Item::new, new Item.Settings());
  public static final Item COPPER_PIPE = register("copper_pipe", Item::new, new Item.Settings());
  public static final Item COPPER_SHELL = register("copper_shell", Item::new, new Item.Settings());
  public static final Item COPPER_WIRE = register("copper_wire", Item::new, new Item.Settings());
  public static final Item DENSE_COPPER_WIRE = register("dense_copper_wire", Item::new, new Item.Settings());
  public static final Item COPPER_CRYSTALS = register("copper_crystals", Item::new, new Item.Settings());
  public static final Item RAW_METEORIC_COPPER = register("raw_meteoric_copper", Item::new, new Item.Settings());

  public static final Item RAW_CRYOLITE = register("raw_cryolite", Item::new, new Item.Settings());
  public static final Item CRYOLITE_CHUNK = register("cryolite_chunk", Item::new, new Item.Settings());
  
  public static final Item DESH_INGOT = register("desh_ingot", Item::new, new Item.Settings());
  public static final Item DESH_BLEND = register("desh_blend", Item::new, new Item.Settings());
  public static final Item DESHREADY_BLEND = register("deshready_blend", Item::new, new Item.Settings());
  public static final Item DESH_POWDER = register("desh_powder", Item::new, new Item.Settings());
  public static final Item DESH_NUGGET = register("desh_nugget", Item::new, new Item.Settings());
  public static final Item CAST_DESH_PLATE = register("cast_desh_plate", Item::new, new Item.Settings());
  
  public static final Item DIAMOND_CRYSTALS = register("diamond_crystals", Item::new, new Item.Settings());
  
  public static final Item DINEUTRONIUM_INGOT = register("dineutronium_ingot", Item::new, new Item.Settings());
  public static final Item DINEUTRONIUM_POWDER = register("dineutronium_powder", Item::new, new Item.Settings());
  public static final Item DINEUTRONIUM_NUGGET = register("dineutronium_nugget", Item::new, new Item.Settings());
  public static final Item DENSE_DINEUTRONIUM_NUGGET = register("dense_dineutronium_nugget", Item::new, new Item.Settings());
  
  public static final Item ELECTRONIUM_INGOT = register("electronium_ingot", Item::new, new Item.Settings());
  
  public static final Item EUPHEMIUM_INGOT = register("euphemium_ingot", Item::new, new Item.Settings());
  public static final Item EUPHEMIUM_POWDER = register("euphemium_powder", Item::new, new Item.Settings());
  public static final Item EUPHEMIUM_NUGGET = register("euphemium_nugget", Item::new, new Item.Settings());
  
  public static final Item FERRIC_SCHARBIDATE_INGOT = register("ferric_schrabidate_ingot", Item::new, new Item.Settings());
  public static final Item FERRIC_SCHARBIDATE_POWDER = register("ferric_schrabidate_powder", Item::new, new Item.Settings());
  public static final Item CAST_FERRIC_SCHARBIDATE_PLATE = register("cast_ferric_schrabidate_plate", Item::new, new Item.Settings());
  public static final Item DENSE_FERRIC_SCHARBIDATE_WIRE = register("dense_ferric_schrabidate_wire", Item::new, new Item.Settings());
  
  public static final Item FERROURANIUM_INGOT = register("ferrouranium_ingot", Item::new, new Item.Settings());
  public static final Item CAST_FERROURANIUM_PLATE = register("cast_ferrouranium_plate", Item::new, new Item.Settings());
  
  public static final Item FLUORITE = register("fluorite", Item::new, new Item.Settings());
  public static final Item FLUORITE_CRYSTALS = register("fluorite_crystals", Item::new, new Item.Settings());
  
  public static final Item GHIORSIUM_336_INGOT = register("ghiorsium_336_ingot", Item::new, new Item.Settings());
  public static final Item GHIORSIUM_336_BILLET = register("ghiorsium_336_billet", Item::new, new Item.Settings());
  public static final Item GHIORSIUM_336_NUGGET = register("ghiorsium_336_nugget", Item::new, new Item.Settings());
  
  public static final Item GOLD_POWDER = register("gold_powder", Item::new, new Item.Settings());
  public static final Item GOLD_PLATE = register("gold_plate", Item::new, new Item.Settings());
  public static final Item CAST_GOLD_PLATE = register("cast_gold_plate", Item::new, new Item.Settings());
  public static final Item GOLD_WIRE = register("gold_wire", Item::new, new Item.Settings());
  public static final Item DENSE_GOLD_WIRE = register("dense_gold_wire", Item::new, new Item.Settings());
  public static final Item GOLD_CRYSTALS = register("gold_crystals", Item::new, new Item.Settings());
  public static final Item GOLD_198_INGOT = register("gold_198_ingot", Item::new, new Item.Settings());
  public static final Item GOLD_198_BILLET = register("gold_198_billet", Item::new, new Item.Settings());
  public static final Item GOLD_198_POWDER = register("gold_198_powder", Item::new, new Item.Settings());
  public static final Item GOLD_198_NUGGET = register("gold_198_nugget", Item::new, new Item.Settings());
  
  public static final Item GRAPHITE_INGOT = register("graphite_ingot", Item::new, new Item.Settings());
  
  public static final Item GUNMETAL_INGOT = register("gunmetal_ingot", Item::new, new Item.Settings());
  public static final Item GUNMETAL_PLATE = register("gunmetal_plate", Item::new, new Item.Settings());
  
  public static final Item HARD_PLASTIC_BAR = register("hard_plastic_bar", Item::new, new Item.Settings());
  
  public static final Item HIGH_SPEED_STEEL_INGOT = register("high_speed_steel_ingot", Item::new, new Item.Settings());
  public static final Item HIGH_SPEED_STEEL_POWDER = register("high_speed_steel_powder", Item::new, new Item.Settings());
  public static final Item CAST_HIGH_SPEED_STEEL_PLATE = register("cast_high_speed_steel_plate", Item::new, new Item.Settings());
  public static final Item HIGH_SPEED_STEEL_PLATE = register("high_speed_steel_plate", Item::new, new Item.Settings());
  public static final Item HIGH_SPEED_STEEL_BOLT = register("high_speed_steel_bolt", Item::new, new Item.Settings());
  public static final Item HIGH_SPEED_STEEL_PIPE = register("high_speed_steel_pipe", Item::new, new Item.Settings());
  
  public static final Item IRON_POWDER = register("iron_powder", Item::new, new Item.Settings());
  public static final Item IRON_PLATE = register("iron_plate", Item::new, new Item.Settings());
  public static final Item CAST_IRON_PLATE = register("cast_iron_plate", Item::new, new Item.Settings());
  public static final Item WELDED_IRON_PLATE = register("welded_iron_plate", Item::new, new Item.Settings());
  public static final Item IRON_PIPE = register("iron_pipe", Item::new, new Item.Settings());
  public static final Item IRON_CRYSTALS = register("iron_crystals", Item::new, new Item.Settings());
  public static final Item RAW_METEORIC_IRON = register("raw_meteoric_iron", Item::new, new Item.Settings());
  
  public static final Item INFERNAL_COAL = register("infernal_coal", Item::new, new Item.Settings());
  
  public static final Item SEMI_STABLE_LANTHANUM_INGOT = register("semi_stable_lanthanum_ingot", Item::new, new Item.Settings());
  public static final Item LANTHANUM_FRAGMENT = register("lanthanum_fragment", Item::new, new Item.Settings());
  
  public static final Item LAPIS_CRYSTALS = register("lapis_crystals", Item::new, new Item.Settings());
  
  public static final Item LATEX = register("latex", Item::new, new Item.Settings());
  public static final Item LATEX_BAR = register("latex_bar", Item::new, new Item.Settings());
  
  public static final Item RAW_LEAD = register("raw_lead", Item::new, new Item.Settings());
  public static final Item LEAD_INGOT = register("lead_ingot", Item::new, new Item.Settings());
  public static final Item LEAD_BILLET = register("lead_billet", Item::new, new Item.Settings());
  public static final Item LEAD_NUGGET = register("lead_nugget", Item::new, new Item.Settings());
  public static final Item LEAD_209_INGOT = register("lead_209_ingot", Item::new, new Item.Settings());
  public static final Item LEAD_209_BILLET = register("lead_209_billet", Item::new, new Item.Settings());
  public static final Item LEAD_209_NUGGET = register("lead_209_nugget", Item::new, new Item.Settings());
  public static final Item LEAD_POWDER = register("lead_powder", Item::new, new Item.Settings());
  public static final Item LEAD_PLATE = register("lead_plate", Item::new, new Item.Settings());
  public static final Item CAST_LEAD_PLATE = register("cast_lead_plate", Item::new, new Item.Settings());
  public static final Item LEAD_PIPE = register("lead_pipe", Item::new, new Item.Settings());
  public static final Item LEAD_BOLT = register("lead_bolt", Item::new, new Item.Settings());
  public static final Item LEAD_WIRE = register("lead_wire", Item::new, new Item.Settings());
  public static final Item LEAD_CRYSTALS = register("lead_crystals", Item::new, new Item.Settings());

  public static final Item LIGNITE = register("lignite", Item::new, new Item.Settings());
  public static final Item LIGNITE_POWDER = register("lignite_powder", Item::new, new Item.Settings());
  public static final Item LIGNITE_COKE = register("lignite_coke", Item::new, new Item.Settings());
  public static final Item LIGNITE_BRIQUETTE = register("lignite_briquette", Item::new, new Item.Settings());
  
  public static final Item LITHIUM_CUBE = register("lithium_cube", Item::new, new Item.Settings());
  public static final Item LITHIUM_POWDER = register("lithium_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_LITHIUM_POWDER = register("tiny_pile_of_lithium_powder", Item::new, new Item.Settings());
  public static final Item LITHIUM_CRYSTALS = register("lithium_crystals", Item::new, new Item.Settings());
  
  public static final Item MAGNETIZED_TUNGSTEN_INGOT = register("magnetized_tungsten_ingot", Item::new, new Item.Settings());
  public static final Item MAGNETIZED_TUNGSTEN_POWDER = register("magnetized_tungsten_powder", Item::new, new Item.Settings());
  public static final Item MAGNETIZED_TUNGSTEN_WIRE = register("magnetized_tungsten_wire", Item::new, new Item.Settings());
  public static final Item DENSE_MAGNETIZED_TUNGSTEN_WIRE = register("dense_magnetized_tungsten_wire", Item::new, new Item.Settings());
  
  public static final Item METEORITE_INGOT = register("meteorite_ingot", Item::new, new Item.Settings());
  public static final Item METEORITE_POWDER = register("meteorite_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_METEORITE_POWDER = register("tiny_pile_of_meteorite_powder", Item::new, new Item.Settings());
  public static final Item METEORITE_FRAGMENT = register("meteorite_fragment", Item::new, new Item.Settings());
  
  public static final Item MOLYSITE = register("molysite", Item::new, new Item.Settings());
  
  public static final Item MOX_FUEL_INGOT = register("mox_fuel_ingot", Item::new, new Item.Settings());
  public static final Item MOX_FUEL_BILLET = register("mox_fuel_billet", Item::new, new Item.Settings());
  public static final Item MOX_FUEL_NUGGET = register("mox_fuel_nugget", Item::new, new Item.Settings());
  
  public static final Item NEODYMIUM_INGOT = register("neodymium_ingot", Item::new, new Item.Settings());
  public static final Item NEODYMIUM_POWDER = register("neodymium_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_NEODYMIUM_POWDER = register("tiny_pile_of_neodymium_powder", Item::new, new Item.Settings());
  public static final Item DENSE_NEODYMIUM_WIRE = register("dense_neodymium_wire", Item::new, new Item.Settings());
  public static final Item NEODYMIUM_FRAGMENT = register("neodymium_fragment", Item::new, new Item.Settings());

  public static final Item RAW_NEPTUNIUM = register("raw_neptunium", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_CRYSTALS = register("neptunium_crystals", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_INGOT = register("neptunium_ingot", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_FUEL_INGOT = register("neptunium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_BILLET = register("neptunium_billet", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_FUEL_BILLET = register("neptunium_fuel_billet", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_NUGGET = register("neptunium_nugget", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_FUEL_NUGGET = register("neptunium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_POWDER = register("neptunium_powder", Item::new, new Item.Settings());
  
  public static final Item NIOBIUM_INGOT = register("niobium_ingot", Item::new, new Item.Settings());
  public static final Item NIOBIUM_POWDER = register("niobium_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_NIOBIUM_POWDER = register("tiny_pile_of_niobium_powder", Item::new, new Item.Settings());
  public static final Item NIOBIUM_NUGGET = register("niobium_nugget", Item::new, new Item.Settings());
  public static final Item DENSE_NIOBIUM_WIRE = register("dense_niobium_wire", Item::new, new Item.Settings());
  public static final Item NIOBIUM_FRAGMENT = register("niobium_fragment", Item::new, new Item.Settings());
  
  public static final Item NITER = register("niter", Item::new, new Item.Settings());
  public static final Item NITER_CRYSTALS = register("niter_crystals", Item::new, new Item.Settings());

  public static final Item RAW_OSMIRIDIUM = register("raw_osmiridium", Item::new, new Item.Settings());
  public static final Item OSMIRIDIUM_INGOT = register("osmiridium_ingot", Item::new, new Item.Settings());
  public static final Item OSMIRIDIUM_NUGGET = register("osmiridium_nugget", Item::new, new Item.Settings());
  public static final Item IMPURE_OSMIRIDIUM_POWDER = register("impure_osmiridium_powder", Item::new, new Item.Settings());
  public static final Item CAST_OSMIRIDIUM_PLATE = register("cast_osmiridium_plate", Item::new, new Item.Settings());
  public static final Item WELDED_OSMIRIDIUM_PLATE = register("welded_osmiridium_plate", Item::new, new Item.Settings());
  public static final Item OSMIRIDIUM_CRYSTALS = register("osmiridium_crystals", Item::new, new Item.Settings());
  
  public static final Item RED_PHOSPHORUS = register("red_phosphorus", Item::new, new Item.Settings());
  public static final Item WHITE_PHOSPHORUS_BAR = register("white_phosphorus_bar", Item::new, new Item.Settings());
  public static final Item PHOSPHORUS_CRYSTALS = register("phosphorus_crystals", Item::new, new Item.Settings());
  
  public static final Item POLONIUM_210_INGOT = register("polonium_210_ingot", Item::new, new Item.Settings());
  public static final Item POLONIUM_210_BILLET = register("polonium_210_billet", Item::new, new Item.Settings());
  public static final Item POLONIUM_210_NUGGET = register("polonium_210_nugget", Item::new, new Item.Settings());
  public static final Item POLONIUM_210_DUST = register("polonium_210_dust", Item::new, new Item.Settings());
  
  public static final Item POLYMER_BAR = register("polymer_bar", Item::new, new Item.Settings());
  public static final Item POLYMER_POWDER = register("polymer_powder", Item::new, new Item.Settings());
  
  public static final Item RAW_PLUTONIUM = register("raw_plutonium", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_INGOT = register("plutonium_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_FUEL_INGOT = register("plutonium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_PLUTONIUM_INGOT = register("reactor_grade_plutonium_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_238_INGOT = register("plutonium_238_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_239_INGOT = register("plutonium_239_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_240_INGOT = register("plutonium_240_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_241_INGOT = register("plutonium_241_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_BILLET = register("plutonium_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_FUEL_BILLET = register("plutonium_fuel_billet", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_PLUTONIUM_BILLET = register("reactor_grade_plutonium__billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_238_BILLET = register("plutonium_238_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_239_BILLET = register("plutonium_239_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_240_BILLET = register("plutonium_240_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_241_BILLET = register("plutonium_241_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_NUGGET = register("plutonium_nugget", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_FUEL_NUGGET = register("plutonium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_PLUTONIUM_NUGGET = register("reactor_grade_plutonium_nugget", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_238_NUGGET = register("plutonium_238_nugget", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_239_NUGGET = register("plutonium_239_nugget", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_240_NUGGET = register("plutonium_240_nugget", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_241_NUGGET = register("plutonium_241_nugget", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_POWDER = register("plutonium_powder", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_CRYSTALS = register("plutonium_crystals", Item::new, new Item.Settings());
  
  public static final Item PVC_BAR = register("pvc_bar", Item::new, new Item.Settings());
  
  public static final Item RADIUM_226_INGOT = register("radium_266_ingot", Item::new, new Item.Settings());
  public static final Item RADIUM_226_BILLET = register("radium_266_billet", Item::new, new Item.Settings());
  public static final Item RADIUM_226_POWDER = register("radium_266_powder", Item::new, new Item.Settings());
  public static final Item RADIUM_226_NUGGET = register("radium_266_nugget", Item::new, new Item.Settings());
  
  public static final Item RARE_EARTH_ORE_CHUNK = register("rare_earth_ore_chunk", Item::new, new Item.Settings());
  public static final Item RARE_EARTH_CRYSTALS = register("rare_earth_crystals", Item::new, new Item.Settings());
  public static final Item RAW_METEORIC_RARE_EARTH = register("raw_meteoric_rare_earth", Item::new, new Item.Settings());

  public static final Item RED_COPPER_INGOT = register("red_copper_ingot", Item::new, new Item.Settings());
  public static final Item RED_COPPER_POWDER = register("red_copper_powder", Item::new, new Item.Settings());
  public static final Item RED_COPPER_WIRE = register("red_copper_wire", Item::new, new Item.Settings());
  
  public static final Item REDSTONE_CRYSTALS = register("redstone_crystals", Item::new, new Item.Settings());
  
  public static final Item RUBBER_BAR = register("rubber_bar", Item::new, new Item.Settings());
  public static final Item RUBBER_PIPE = register("rubber_pipe", Item::new, new Item.Settings());
  
  public static final Item SATURNITE_INGOT = register("saturnite_ingot", Item::new, new Item.Settings());
  public static final Item SATURNITE_PLATE = register("saturnite_plate", Item::new, new Item.Settings());
  public static final Item CAST_SATURNITE_PLATE = register("cast_saturnite_plate", Item::new, new Item.Settings());
  public static final Item SATURNITE_SHELL = register("saturnite_shell", Item::new, new Item.Settings());
  
  public static final Item RAW_SCHRABIDIUM = register("raw_schrabidium", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_INGOT = register("schrabidium_ingot", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_FUEL_INGOT = register("schrabidium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT = register("low_enriched_schrabidium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT = register("highly_enriched_schrabidium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_BILLET = register("schrabidium_billet", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_FUEL_BILLET = register("schrabidium_fuel_billet", Item::new, new Item.Settings());
  public static final Item LOW_ENRICHED_SCHRABIDIUM_FUEL_BILLET = register("low_enriched_schrabidium_fuel_billet", Item::new, new Item.Settings());
  public static final Item HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_BILLET = register("highly_enriched_schrabidium_fuel_billet", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_NUGGET = register("schrabidium_nugget", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_FUEL_NUGGET = register("schrabidium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item LOW_ENRICHED_SCHRABIDIUM_FUEL_NUGGET = register("low_enriched_schrabidium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_NUGGET = register("highly_enriched_schrabidium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_POWDER = register("schrabidium_powder", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_PLATE = register("schrabidium_plate", Item::new, new Item.Settings());
  public static final Item CAST_SCHRABIDIUM_PLATE = register("cast_schrabidium_plate", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_WIRE = register("schrabidium_wire", Item::new, new Item.Settings());
  public static final Item DENSE_SCHRABIDIUM_WIRE = register("dense_schrabidium_wire", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_CRYSTALS = register("schrabidium_crystals", Item::new, new Item.Settings());
  
  public static final Item SCHRARANIUM_INGOT = register("schraranium_ingot", Item::new, new Item.Settings());
  public static final Item SCHRARANIUM_CRYSTALS = register("schraranium_crystals", Item::new, new Item.Settings());
  
  public static final Item SILICON_BOULE = register("silicon_boule", Item::new, new Item.Settings());
  public static final Item SILICON_WAFER = register("silicon_wafer", Item::new, new Item.Settings());
  public static final Item PRINTED_SILICON_WAFER = register("printed_silicon_wafer", Item::new, new Item.Settings());
  public static final Item SILICON_NUGGET = register("silicon_nugget", Item::new, new Item.Settings());
  
  public static final Item SOLINIUM_INGOT = register("solinium_ingot", Item::new, new Item.Settings());
  public static final Item SOLINIUM_BILLET = register("solinium_billet", Item::new, new Item.Settings());
  public static final Item SOLINIUM_NUGGET = register("solinium_nugget", Item::new, new Item.Settings());
  
  public static final Item STARMETAL_INGOT = register("starmetal_ingot", Item::new, new Item.Settings());
  public static final Item DENSE_STARMETAL_WIRE = register("dense_starmetal_wire", Item::new, new Item.Settings());
  public static final Item STARMETAL_RING = register("starmetal_ring", Item::new, new Item.Settings());
  public static final Item STARMETAL_CRYSTALS = register("starmetal_crystals", Item::new, new Item.Settings());
  
  public static final Item STRONTIUM_INGOT = register("strontium_ingot", Item::new, new Item.Settings());
  public static final Item STRONTIUM_POWDER = register("strontium_powder", Item::new, new Item.Settings());
  public static final Item STRONTIUM_90_INGOT = register("strontium_90_ingot", Item::new, new Item.Settings());
  public static final Item STRONTIUM_90_BILLET = register("strontium_90_billet", Item::new, new Item.Settings());
  public static final Item STRONTIUM_90_POWDER = register("strontium_90_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_STRONTIUM_90_POWDER = register("tiny_pile_of_strontium_90_powder", Item::new, new Item.Settings());
  public static final Item STRONTIUM_90_NUGGET = register("strontium_90_nugget", Item::new, new Item.Settings());

  public static final Item STEEL_INGOT = register("steel_ingot", Item::new, new Item.Settings());
  public static final Item STEEL_POWDER = register("steel_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_STEEL_POWDER = register("tiny_pile_of_steel_powder", Item::new, new Item.Settings());
  public static final Item STEEL_PLATE = register("steel_plate", Item::new, new Item.Settings());
  public static final Item CAST_STEEL_PLATE = register("cast_steel_plate", Item::new, new Item.Settings());
  public static final Item WELDED_STEEL_PLATE = register("welded_steel_plate", Item::new, new Item.Settings());
  public static final Item STEEL_BOLT = register("steel_bolt", Item::new, new Item.Settings());
  public static final Item STEEL_PIPE = register("steel_pipe", Item::new, new Item.Settings());
  public static final Item STEEL_SHELL = register("steel_shell", Item::new, new Item.Settings());
  public static final Item STEEL_WIRE = register("steel_wire", Item::new, new Item.Settings());
  
  public static final Item SULFUR = register("sulfur", Item::new, new Item.Settings());
  public static final Item SULFUR_CRYSTALS = register("sulfur_crystals", Item::new, new Item.Settings());
  
  public static final Item PURIFIED_TANTALITE = register("purified_tantalite", Item::new, new Item.Settings()); // Comes from Coltan
  public static final Item TANTALUM_INGOT = register("tantalum_ingot", Item::new, new Item.Settings());
  public static final Item TANTALUM_POWDER = register("tantalum_powder", Item::new, new Item.Settings());
  public static final Item TANTALUM_NUGGET = register("tantalum_nugget", Item::new, new Item.Settings());
  public static final Item TANTALUM_POLYCRYSTAL = register("tantalum_polycrystal", Item::new, new Item.Settings());
  
  public static final Item TECHNETIUM_99_INGOT = register("technetium_99_ingot", Item::new, new Item.Settings());
  public static final Item TECHNETIUM_99_BILLET = register("technetium_99_billet", Item::new, new Item.Settings());
  public static final Item TECHNETIUM_99_NUGGET = register("technetium_99_nugget", Item::new, new Item.Settings());
  
  public static final Item TECHNETIUM_STEEL_INGOT = register("technetium_steel_ingot", Item::new, new Item.Settings());
  public static final Item TECHNETIUM_STEEL_POWDER = register("technetium_steel_powder", Item::new, new Item.Settings());
  public static final Item CAST_TECHNETIUM_STEEL_PLATE = register("cast_technetium_steel_plate", Item::new, new Item.Settings());
  public static final Item WELDED_TECHNETIUM_STEEL_PLATE = register("welded_technetium_steel_plate", Item::new, new Item.Settings());

  public static final Item RAW_THORIUM = register("raw_thorium", Item::new, new Item.Settings());
  public static final Item THORIUM_232_INGOT = register("thorium_232_ingot", Item::new, new Item.Settings());
  public static final Item THORIUM_FUEL_INGOT = register("thorium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item THORIUM_232_BILLET = register("thorium_232_billet", Item::new, new Item.Settings());
  public static final Item THORIUM_FUEL_BILLET = register("thorium_fuel_billet", Item::new, new Item.Settings());
  public static final Item THORIUM_232_NUGGET = register("thorium_232_nugget", Item::new, new Item.Settings());
  public static final Item THORIUM_FUEL_NUGGET = register("thorium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item THORIUM_POWDER = register("thorium_powder", Item::new, new Item.Settings());
  public static final Item THORIUM_CRYSTALS = register("thorium_crystals", Item::new, new Item.Settings());

  public static final Item RAW_TITANIUM = register("raw_titanium", Item::new, new Item.Settings());
  public static final Item TITANIUM_INGOT = register("titanium_ingot", Item::new, new Item.Settings());
  public static final Item TITANIUM_PLATE = register("titanium_plate", Item::new, new Item.Settings());
  public static final Item CAST_TITANIUM_PLATE = register("cast_titanium_plate", Item::new, new Item.Settings());
  public static final Item WELDED_TITANIUM_PLATE = register("welded_titanium_plate", Item::new, new Item.Settings());
  public static final Item TITANIUM_BILLET = register("titanium_billet", Item::new, new Item.Settings());
  public static final Item TITANIUM_NUGGET = register("titanium_nugget", Item::new, new Item.Settings());
  public static final Item TITANIUM_POWDER = register("titanium_powder", Item::new, new Item.Settings());
  public static final Item TITANIUM_SHELL = register("titanium_shell", Item::new, new Item.Settings());
  public static final Item DENSE_TITANIUM_WIRE = register("dense_titanium_wire", Item::new, new Item.Settings());
  public static final Item TITANIUM_CRYSTALS = register("titanium_crystals", Item::new, new Item.Settings());

  public static final Item RAW_TRIXITE = register("raw_trixite", Item::new, new Item.Settings());
  public static final Item TRIXITE_CRYSTALS = register("trixite_crystals", Item::new, new Item.Settings());
  
  public static final Item RAW_TUNGSTEN = register("raw_tungsten", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_INGOT = register("tungsten_ingot", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_BILLET = register("tungsten_billet", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_NUGGET = register("tungsten_nugget", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_POWDER = register("tungsten_powder", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_BOLT = register("tungsten_bolt", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_WIRE = register("tungsten_wire", Item::new, new Item.Settings());
  public static final Item DENSE_TUNGSTEN_WIRE = register("dense_tungsten_wire", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_CRYSTALS = register("tungsten_crystals", Item::new, new Item.Settings());
  
  public static final Item RAW_URANIUM = register("raw_uranium", Item::new, new Item.Settings());
  public static final Item RAW_SCORCHED_URANIUM = register("raw_scorched_uranium", Item::new, new Item.Settings());
  public static final Item URANIUM_INGOT = register("uranium_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_FUEL_INGOT = register("uranium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_233_INGOT = register("uranium_233_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_235_INGOT = register("uranium_235_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_238_INGOT = register("uranium_238_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_BILLET = register("uranium_billet", Item::new, new Item.Settings());
  public static final Item URANIUM_FUEL_BILLET = register("uranium_fuel_billet", Item::new, new Item.Settings());
  public static final Item URANIUM_233_BILLET = register("uranium_233_billet", Item::new, new Item.Settings());
  public static final Item URANIUM_235_BILLET = register("uranium_235_billet", Item::new, new Item.Settings());
  public static final Item URANIUM_238_BILLET = register("uranium_238_billet", Item::new, new Item.Settings());
  public static final Item URANIUM_NUGGET = register("uranium_nugget", Item::new, new Item.Settings());
  public static final Item URANIUM_FUEL_NUGGET = register("uranium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item URANIUM_233_NUGGET = register("uranium_233_nugget", Item::new, new Item.Settings());
  public static final Item URANIUM_235_NUGGET = register("uranium_235_nugget", Item::new, new Item.Settings());
  public static final Item URANIUM_238_NUGGET = register("uranium_238_nugget", Item::new, new Item.Settings());
  public static final Item URANIUM_POWDER = register("uranium_powder", Item::new, new Item.Settings());
  public static final Item URANIUM_CRYSTALS = register("uranium_crystals", Item::new, new Item.Settings());
  
  public static final Item VOLCANIC_GEM = register("volcanic_gem", Item::new, new Item.Settings());
  
  public static final Item WEAPON_STEEL_INGOT = register("weapon_steel_ingot", Item::new, new Item.Settings());
  public static final Item WEAPON_STEEL_PLATE = register("weapon_steel_plate", Item::new, new Item.Settings());
  public static final Item CAST_WEAPON_STEEL_PLATE = register("cast_weapon_steel_plate", Item::new, new Item.Settings());
  public static final Item WEAPON_STEEL_SHELL = register("weapon_steel_shell", Item::new, new Item.Settings());
  
  public static final Item ZIRCONIUM_SPLINTER = register("zirconium_splinter", Item::new, new Item.Settings());
  public static final Item ZIRCONIUM_CUBE = register("zirconium_cube", Item::new, new Item.Settings());
  public static final Item ZIRCONIUM_BILLET = register("zirconium_billet", Item::new, new Item.Settings());
  public static final Item ZIRCONIUM_POWDER = register("zirconium_powder", Item::new, new Item.Settings());
  public static final Item CAST_ZIRCONIUM_PLATE = register("cast_zirconium_plate", Item::new, new Item.Settings());
  public static final Item WELDED_ZIRCONIUM_PLATE = register("welded_zirconium_plate", Item::new, new Item.Settings());
  public static final Item ZIRCONIUM_WIRE = register("zirconium_wire", Item::new, new Item.Settings());
  
  // TODO: Heatable/Forgeable Ingots
  // public static final Item DUSTED_STEEL_INGOT = register("dusted_steel_ingot", Item::new, new Item.Settings());
  // public static final Item HEAVY_CHAINSTEEL_INGOT = register("heavy_chainsteel_ingot", Item::new, new Item.Settings());
  // public static final Item FORGED_METEORITE_INGOT = register("forged_meteorite_ingot", Item::new, new Item.Settings());
  
  // Consumables
  public static final Item BOTTLE_OPENER = register("bottle_opener", settings -> new TooltipItem(settings, 2), new Item.Settings());
  public static final Item EMPTY_BOTTLE = register("empty_bottle", Item::new, new Item.Settings());
  public static final Item EMPTY_BOMB_BOTTLE = register("empty_bomb_bottle", Item::new, new Item.Settings());
  public static final Item NUKA_COLA_BOTTLE_CAP = register("nuka_cola_bottle_cap", Item::new, new Item.Settings());
  public static final Item NUKA_COLA_QUANTUM_BOTTLE_CAP = register("nuka_cola_quantum_bottle_cap", Item::new, new Item.Settings());
  public static final Item S_COLA_BOTTLE_CAP = register("s_cola_bottle_cap", Item::new, new Item.Settings());
  public static final Item S_COLA_RAD_BOTTLE_CAP = register("s_cola_rad_bottle_cap", Item::new, new Item.Settings());
  public static final Item KAROL_BOTTLE_CAP = register("karol_bottle_cap", Item::new, new Item.Settings());
  public static final Item FRITZ_COLA_BOTTLE_CAP = register("fritz_cola_bottle_cap", Item::new, new Item.Settings());
  public static final Item BOTTLE_OF_NUKA_COLA = register("bottle_of_nuka_cola", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 1),
          new StatusEffectInstance(StatusEffects.HASTE, 600, 1)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      NUKA_COLA_BOTTLE_CAP
  )));
  public static final Item BOTTLE_OF_NUKA_CHERRY = register("bottle_of_nuka_cherry", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 0),
          new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 2)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      NUKA_COLA_BOTTLE_CAP
  )));
  public static final Item BOTTLE_OF_NUKA_COLA_QUANTUM = register("bottle_of_nuka_cola_quantum", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 1),
          new StatusEffectInstance(StatusEffects.STRENGTH, 600, 1),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 2)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      NUKA_COLA_QUANTUM_BOTTLE_CAP
  )));
  public static final Item BOTTLE_OF_S_COLA = register("bottle_of_s_cola", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 2400, 1),
          new StatusEffectInstance(StatusEffects.HASTE, 2400, 1),
          new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 2),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 2400, 2)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      S_COLA_BOTTLE_CAP
  )));
  public static final Item BOTTLE_OF_S_COLA_RAD = register("bottle_of_s_cola_rad", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 2400, 1),
          new StatusEffectInstance(StatusEffects.HASTE, 2400, 1),
          new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 4),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 2400, 2),
          new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400, 0)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      S_COLA_RAD_BOTTLE_CAP
  )));
  public static final Item BOTTLE_OF_KAROL = register("bottle_of_karol", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 1),
          new StatusEffectInstance(StatusEffects.HASTE, 600, 2),
          new StatusEffectInstance(StatusEffects.STRENGTH, 600, 2)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      KAROL_BOTTLE_CAP
  )));
  public static final Item FIRST_BOTTLE_OF_KAROL = register("first_bottle_of_karol", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 2400, 1),
          new StatusEffectInstance(StatusEffects.HASTE, 2400, 2),
          new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 2)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      KAROL_BOTTLE_CAP
  )));
  public static final Item BOTTLE_OF_FRITZ_COLA = register("bottle_of_fritz_cola", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 1),
          new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 2),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 2)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      FRITZ_COLA_BOTTLE_CAP
  )));
  public static final Item FIRST_BOTTLE_OF_FRITZ_COLA = register("first_bottle_of_fritz_cola", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 2400, 1),
          new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2400, 2),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 2400, 2)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      FRITZ_COLA_BOTTLE_CAP
  )));

  // Tools
  public static final Item STEEL_SWORD = register("steel_sword",new Item.Settings(), settings -> new SpecialSwordItem(settings, ModToolMaterials.STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item STEEL_PICKAXE = register("steel_pickaxe",new Item.Settings(), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item STEEL_AXE = register("steel_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, ModToolMaterials.STEEL_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Decapitator()));
  public static final Item STEEL_SHOVEL = register("steel_shovel",new Item.Settings(), settings -> new SpecialShovelItem(settings, ModToolMaterials.STEEL_TOOL_MATERIAL, 1f, 1f));
  public static final Item STEEL_HOE = register("steel_hoe",new Item.Settings(), settings -> new SpecialHoeItem(settings, ModToolMaterials.STEEL_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item TITANIUM_SWORD = register("titanium_sword",new Item.Settings(), settings -> new SpecialSwordItem(settings, ModToolMaterials.TITANIUM_TOOL_MATERIAL, 1f, 1f));
  public static final Item TITANIUM_PICKAXE = register("titanium_pickaxe",new Item.Settings(), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.TITANIUM_TOOL_MATERIAL, 1f, 1f));
  public static final Item TITANIUM_AXE = register("titanium_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, ModToolMaterials.TITANIUM_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Decapitator()));
  public static final Item TITANIUM_SHOVEL = register("titanium_shovel",new Item.Settings(), settings -> new SpecialShovelItem(settings, ModToolMaterials.TITANIUM_TOOL_MATERIAL, 1f, 1f));
  public static final Item TITANIUM_HOE = register("titanium_hoe",new Item.Settings(), settings -> new SpecialHoeItem(settings, ModToolMaterials.TITANIUM_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item ADVANCED_ALLOY_SWORD = register("advanced_alloy_sword",new Item.Settings(), settings -> new SpecialSwordItem(settings, ModToolMaterials.ADVANCED_ALLOY_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Stunning(2)));
  public static final Item ADVANCED_ALLOY_PICKAXE = register("advanced_alloy_pickaxe",new Item.Settings(), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.ADVANCED_ALLOY_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(3)));
  public static final Item ADVANCED_ALLOY_AXE = register("advanced_alloy_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, ModToolMaterials.ADVANCED_ALLOY_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(3))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item ADVANCED_ALLOY_SHOVEL = register("advanced_alloy_shovel",new Item.Settings(), settings -> new SpecialShovelItem(settings, ModToolMaterials.ADVANCED_ALLOY_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(3)));
  public static final Item ADVANCED_ALLOY_HOE = register("advanced_alloy_hoe",new Item.Settings(), settings -> new SpecialHoeItem(settings, ModToolMaterials.ADVANCED_ALLOY_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item CMB_STEEL_SWORD = register("cmb_steel_sword",new Item.Settings(), settings -> new SpecialSwordItem(settings, ModToolMaterials.CMB_STEEL_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Stunning(2))
      .addModifier(new Modifiers.Vampire(2.0f)));
  public static final Item CMB_STEEL_PICKAXE = register("cmb_steel_pickaxe",new Item.Settings(), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.CMB_STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3)));
  public static final Item CMB_STEEL_AXE = register("cmb_steel_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, ModToolMaterials.CMB_STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item CMB_STEEL_SHOVEL = register("cmb_steel_shovel",new Item.Settings(), settings -> new SpecialShovelItem(settings, ModToolMaterials.CMB_STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3)));
  public static final Item CMB_STEEL_HOE = register("cmb_steel_hoe",new Item.Settings(), settings -> new SpecialHoeItem(settings, ModToolMaterials.CMB_STEEL_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item DESH_SWORD = register("desh_sword",new Item.Settings(), settings -> new SpecialSwordItem(settings, ModToolMaterials.DESH_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Stunning(2))
      .addModifier(new Modifiers.Vampire(2.0f)));
  public static final Item DESH_PICKAXE = register("desh_pickaxe",new Item.Settings(), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.DESH_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(2)));
  public static final Item DESH_AXE = register("desh_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, ModToolMaterials.DESH_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(2))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item DESH_SHOVEL = register("desh_shovel",new Item.Settings(), settings -> new SpecialShovelItem(settings, ModToolMaterials.DESH_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(2)));
  public static final Item DESH_HOE = register("desh_hoe",new Item.Settings(), settings -> new SpecialHoeItem(settings, ModToolMaterials.DESH_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item COBALT_SWORD = register("cobalt_sword",new Item.Settings(), settings -> new SpecialSwordItem(settings, ModToolMaterials.COBALT_TOOL_MATERIAL, 1f, 1f));
  public static final Item COBALT_PICKAXE = register("cobalt_pickaxe",new Item.Settings(), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.COBALT_TOOL_MATERIAL, 1f, 1f));
  public static final Item COBALT_AXE = register("cobalt_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, ModToolMaterials.COBALT_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Decapitator()));
  public static final Item COBALT_SHOVEL = register("cobalt_shovel",new Item.Settings(), settings -> new SpecialShovelItem(settings, ModToolMaterials.COBALT_TOOL_MATERIAL, 1f, 1f));
  public static final Item COBALT_HOE = register("cobalt_hoe",new Item.Settings(), settings -> new SpecialHoeItem(settings, ModToolMaterials.COBALT_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item DECORATED_COBALT_SWORD = register("decorated_cobalt_sword",new Item.Settings(), settings -> new SpecialSwordItem(settings, ModToolMaterials.DECORATED_COBALT_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.LuckOfTheCollector()));
  public static final Item DECORATED_COBALT_PICKAXE = register("decorated_cobalt_pickaxe",new Item.Settings(), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.DECORATED_COBALT_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3))
  );
  public static final Item DECORATED_COBALT_AXE = register("decorated_cobalt_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, ModToolMaterials.DECORATED_COBALT_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item DECORATED_COBALT_SHOVEL = register("decorated_cobalt_shovel",new Item.Settings(), settings -> new SpecialShovelItem(settings, ModToolMaterials.DECORATED_COBALT_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3)));
  public static final Item DECORATED_COBALT_HOE = register("decorated_cobalt_hoe",new Item.Settings(), settings -> new SpecialHoeItem(settings, ModToolMaterials.DECORATED_COBALT_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item STARMETAL_SWORD = register("starmetal_sword",new Item.Settings(), settings -> new SpecialSwordItem(settings, ModToolMaterials.STARMETAL_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.Decapitator())
      .addModifier(new Modifiers.Stunning(3))
      .addModifier(new Modifiers.LuckOfTheCollector()));
  public static final Item STARMETAL_PICKAXE = register("starmetal_pickaxe",new Item.Settings(), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.STARMETAL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(6))
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addModifier(new Modifiers.Stunning(3)));
  public static final Item STARMETAL_AXE = register("starmetal_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, ModToolMaterials.STARMETAL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(6))
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addModifier(new Modifiers.Decapitator())
      .addModifier(new Modifiers.Stunning(3)));
  public static final Item STARMETAL_SHOVEL = register("starmetal_shovel",new Item.Settings(), settings -> new SpecialShovelItem(settings, ModToolMaterials.STARMETAL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(6))
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addModifier(new Modifiers.Stunning(3)));
  public static final Item STARMETAL_HOE = register("starmetal_hoe",new Item.Settings(), settings -> new SpecialHoeItem(settings, ModToolMaterials.STARMETAL_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item SCHRABIDIUM_SWORD = register("schrabidium_sword",new Item.Settings().rarity(Rarity.RARE), settings -> new SpecialSwordItem(settings, ModToolMaterials.SCHRABIDIUM_TOOL_MATERIAL, 1f, 1f)
      .addModifier(new Modifiers.RadioactiveBlade(50f))
      .addModifier(new Modifiers.Vampire(2f)));
  public static final Item SCHRABIDIUM_PICKAXE = register("schrabidium_pickaxe",new Item.Settings().rarity(Rarity.RARE), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.SCHRABIDIUM_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(10))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.AutoShreader())
      .addModifier(new Modifiers.RadioactiveBlade(15f)));
  public static final Item SCHRABIDIUM_AXE = register("schrabidium_axe", new Item.Settings().rarity(Rarity.RARE), settings -> new SpecialAxeItem(settings, ModToolMaterials.SCHRABIDIUM_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(10))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.AutoShreader())
      .addModifier(new Modifiers.RadioactiveBlade(15f))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item SCHRABIDIUM_SHOVEL = register("schrabidium_shovel",new Item.Settings().rarity(Rarity.RARE), settings -> new SpecialShovelItem(settings, ModToolMaterials.SCHRABIDIUM_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(10))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.AutoShreader())
      .addModifier(new Modifiers.RadioactiveBlade(15f)));
  public static final Item SCHRABIDIUM_HOE = register("schrabidium_hoe",new Item.Settings().rarity(Rarity.RARE), settings -> new SpecialHoeItem(settings, ModToolMaterials.SCHRABIDIUM_TOOL_MATERIAL, 1f, 1f));
  
  public static final Item BISMUTH_PICKAXE = register("bismuth_pickaxe",new Item.Settings(), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.BISMUTH_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AutoShreader())
      .addAbility(new Abilities.Fortune(2))
      .addAbility(new Abilities.SilkTouch()));
  public static final Item BISMUTH_AXE = register("bismuth_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, ModToolMaterials.BISMUTH_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AutoShreader())
      .addAbility(new Abilities.Fortune(2))
      .addAbility(new Abilities.SilkTouch())
      .addModifier(new Modifiers.Stunning(10))
      .addModifier(new Modifiers.Decapitator()));
  
  public static final Item MOLTEN_PICKAXE = register("molten_pickaxe",new Item.Settings(), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.MOLTEN_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.Fortune(3))
      .addAbility(new Abilities.SilkTouch())
      .addModifier(new Modifiers.Flaming(5))
      .addModifier(new Modifiers.Vampire(2.0f))
      .addModifier(new Modifiers.Decapitator())
      .addCanBreakDepthRock());
  public static final Item MOLTEN_AXE = register("molten_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, ModToolMaterials.MOLTEN_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.Fortune(3))
      .addAbility(new Abilities.SilkTouch())
      .addModifier(new Modifiers.Flaming(10))
      .addModifier(new Modifiers.Vampire(3.0f))
      .addModifier(new Modifiers.Decapitator()));
  
  public static final Item CHLOROPHYTE_PICKAXE = register("chlorophyte_pickaxe",new Item.Settings(), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.CHLOTOPHYTE_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.Fortune(4))
      .addAbility(new Abilities.AutoCentrifuge())
      .addAbility(new Abilities.MercuryTouch())
      .addModifier(new Modifiers.Stunning(10))
      .addModifier(new Modifiers.Vampire(5.0f))
      .addModifier(new Modifiers.Decapitator())
      .addCanBreakDepthRock());
  public static final Item CHLOROPHYTE_AXE = register("chlorophyte_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, ModToolMaterials.CHLOTOPHYTE_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.Fortune(4))
      .addModifier(new Modifiers.Stunning(10))
      .addModifier(new Modifiers.Vampire(5.0f))
      .addModifier(new Modifiers.Decapitator())
      .addCanBreakDepthRock());
  
  public static final Item MESE_PICKAXE = register("mese_pickaxe",new Item.Settings(), settings -> new SpecialPickaxeItem(settings, ModToolMaterials.MESE_TOOL_MATERIAL, 1f, 1f)
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
      .addCanBreakDepthRock());
  public static final Item MESE_AXE = register("mese_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, ModToolMaterials.MESE_TOOL_MATERIAL, 1f, 1f)
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