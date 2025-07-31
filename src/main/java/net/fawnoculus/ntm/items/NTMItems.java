package net.fawnoculus.ntm.items;

import net.fawnoculus.ntm.entity.NTMDamageTypes;
import net.fawnoculus.ntm.entity.NTMStatusEffects;
import net.fawnoculus.ntm.items.components.NTMConsumableComponents;
import net.fawnoculus.ntm.items.components.NTMFoodComponents;
import net.fawnoculus.ntm.items.custom.*;
import net.fawnoculus.ntm.items.custom.consumable.*;
import net.fawnoculus.ntm.items.custom.container.energy.*;
import net.fawnoculus.ntm.items.custom.tools.*;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.misc.NTMSounds;
import net.fawnoculus.ntm.util.EntityUtil;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;

public class NTMItems {
  // Basic Items
  public static final Item NULL = register("null", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_238_RTG_PELLET = register("plutonium_238_rtg_pellet", Item::new, new Item.Settings()); // This is only here for the ItemGroup Icon, it will be fully added Later
  public static final Item TUNGSTEN_REACHER = register("tungsten_reacher", Item::new, new Item.Settings());
  
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
  public static final Item AMERICIUM_241_BILLET = register("americium_241_billet", Item::new, new Item.Settings());
  public static final Item AMERICIUM_241_NUGGET = register("americium_241_nugget", Item::new, new Item.Settings());
  public static final Item AMERICIUM_242_INGOT = register("americium_242_ingot", Item::new, new Item.Settings());
  public static final Item AMERICIUM_242_BILLET = register("americium_242_billet", Item::new, new Item.Settings());
  public static final Item AMERICIUM_242_NUGGET = register("americium_242_nugget", Item::new, new Item.Settings());
  public static final Item AMERICIUM_FUEL_INGOT = register("americium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item AMERICIUM_FUEL_BILLET = register("americium_fuel_billet", Item::new, new Item.Settings());
  public static final Item AMERICIUM_FUEL_NUGGET = register("americium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_AMERICIUM_INGOT = register("reactor_grade_americium_ingot", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_AMERICIUM_BILLET = register("reactor_grade_americium_billet", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_AMERICIUM_ZFB_BILLET = register("reactor_grade_americium_zfb_billet", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_AMERICIUM_NUGGET = register("reactor_grade_americium_nugget", Item::new, new Item.Settings());
  
  public static final Item ARSENIC_INGOT = register("arsenic_ingot", Item::new, new Item.Settings());
  public static final Item ARSENIC_NUGGET = register("arsenic_nugget", Item::new, new Item.Settings());
  public static final Item ARSENIC_BRONZE_INGOT = register("arsenic_bronze_ingot", Item::new, new Item.Settings());
  public static final Item CAST_ARSENIC_BRONZE_PLATE = register("cast_arsenic_bronze_plate", Item::new, new Item.Settings());
  
  public static final Item ASBESTOS_SHEET = register("asbestos_sheet", TooltipItem::new, new Item.Settings());
  public static final Item ASBESTOS_POWDER = register("asbestos_powder", TooltipItem::new, new Item.Settings());
  
  public static final Item ASTATINE_POWDER = register("astatine_powder", Item::new, new Item.Settings());
  public static final Item ASTATINE_209_POWDER = register("astatine_209_powder", Item::new, new Item.Settings());
  
  public static final Item ASH = register("ash", Item::new, new Item.Settings());
  public static final Item WOOD_ASH = register("wood_ash", Item::new, new Item.Settings());
  public static final Item COAL_ASH = register("coal_ash", Item::new, new Item.Settings());
  public static final Item FLY_ASH = register("fly_ash", Item::new, new Item.Settings());
  public static final Item FINE_SOOT = register("fine_soot", Item::new, new Item.Settings());
  
  public static final Item RAW_AUSTRALIUM = register("raw_australium", Item::new, new Item.Settings());
  public static final Item AUSTRALIUM_INGOT = register("australium_ingot", Item::new, new Item.Settings());
  public static final Item AUSTRALIUM_BILLET = register("australium_billet", Item::new, new Item.Settings());
  public static final Item AUSTRALIUM_NUGGET = register("australium_nugget", Item::new, new Item.Settings());
  public static final Item LESSER_AUSTRALIUM_BILLET = register("lesser_australium_billet", Item::new, new Item.Settings());
  public static final Item LESSER_AUSTRALIUM_NUGGET = register("lesser_australium_nugget", Item::new, new Item.Settings());
  public static final Item GREATER_AUSTRALIUM_BILLET = register("greater_australium_billet", Item::new, new Item.Settings());
  public static final Item GREATER_AUSTRALIUM_NUGGET = register("greater_australium_nugget", Item::new, new Item.Settings());
  public static final Item AUSTRALIUM_POWDER = register("australium_powder", Item::new, new Item.Settings());
  
  public static final Item BAKELITE_BAR = register("bakelite_bar", Item::new, new Item.Settings());
  public static final Item BAKELITE_POWDER = register("bakelite_powder", Item::new, new Item.Settings());
  
  public static final Item BALEFIRE_EGG = register("balefire_egg", Item::new, new Item.Settings());
  public static final Item BALEFIRE_SHARD = register("balefire_shard", Item::new, new Item.Settings());
  public static final Item THERMONUCLEAR_ASHES = register("thermonuclear_ashes", Item::new, new Item.Settings());
  
  public static final Item RAW_BERYLLIUM = register("raw_beryllium", Item::new, new Item.Settings());
  public static final Item BERYLLIUM_INGOT = register("beryllium_ingot", Item::new, new Item.Settings());
  public static final Item BERYLLIUM_BILLET = register("beryllium_billet", Item::new, new Item.Settings());
  public static final Item BERYLLIUM_NUGGET = register("beryllium_nugget", Item::new, new Item.Settings());
  public static final Item BERYLLIUM_POWDER = register("beryllium_powder", Item::new, new Item.Settings());
  public static final Item BERYLLIUM_CRYSTALS = register("beryllium_crystals", Item::new, new Item.Settings());
  
  public static final Item BISMUTH_INGOT = register("bismuth_ingot", Item::new, new Item.Settings());
  public static final Item BISMUTH_BILLET = register("bismuth_billet", Item::new, new Item.Settings());
  public static final Item BISMUTH_ZFB_BILLET = register("bismuth_zfb_billet", Item::new, new Item.Settings());
  public static final Item BISMUTH_POWDER = register("bismuth_powder", Item::new, new Item.Settings());
  public static final Item BISMUTH_NUGGET = register("bismuth_nugget", Item::new, new Item.Settings());
  
  public static final Item BISMUTH_BRONZE_INGOT = register("bismuth_bronze_ingot", Item::new, new Item.Settings());
  public static final Item CAST_BISMUTH_BRONZE_PLATE = register("cast_bismuth_bronze_plate", Item::new, new Item.Settings());
  
  public static final Item BORAX_POWDER = register("borax_powder", Item::new, new Item.Settings());
  
  public static final Item BORON_INGOT = register("boron_ingot", Item::new, new Item.Settings());
  public static final Item BORON_POWDER = register("boron_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_BORON_POWDER = register("tiny_pile_of_boron_powder", Item::new, new Item.Settings());
  public static final Item BORON_FRAGMENT = register("boron_fragment", Item::new, new Item.Settings());
  
  public static final Item BROMINE_POWDER = register("bromine_powder", Item::new, new Item.Settings());
  
  public static final Item BSCCO_INGOT = register("bscco_ingot", Item::new, new Item.Settings());
  public static final Item DENSE_BSCCO_WIRE = register("dense_bscco_wire", Item::new, new Item.Settings());
  
  public static final Item CADMIUM_INGOT = register("cadmium_ingot", Item::new, new Item.Settings());
  public static final Item CADMIUM_POWDER = register("cadmium_powder", Item::new, new Item.Settings());
  
  public static final Item CAESIUM_POWDER = register("caesium_powder", Item::new, new Item.Settings());
  public static final Item CAESIUM_137_POWDER = register("caesium_137_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_CAESIUM_137_POWDER = register("tiny_pile_of_caesium_137_powder", Item::new, new Item.Settings());
  
  public static final Item CALCIUM_INGOT = register("calcium_ingot", Item::new, new Item.Settings());
  public static final Item CALCIUM_POWDER = register("calcium_powder", Item::new, new Item.Settings());
  
  public static final Item CADMIUM_STEEL_INGOT = register("cadmium_steel_ingot", Item::new, new Item.Settings());
  public static final Item CAST_CADMIUM_STEEL_PLATE = register("cast_cadmium_steel_plate", Item::new, new Item.Settings());
  public static final Item WELDED_CADMIUM_STEEL_PLATE = register("welded_cadmium_steel_plate", Item::new, new Item.Settings());
  
  public static final Item CEMENT = register("cement", Item::new, new Item.Settings());
  
  public static final Item CERIUM_POWDER = register("cerium_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_CERIUM_POWDER = register("tiny_pile_of_cerium_powder", Item::new, new Item.Settings());
  public static final Item CERIUM_FRAGMENT = register("cerium_fragment", Item::new, new Item.Settings());
  
  public static final Item CHLOROCALCITE = register("chlorocalcite", Item::new, new Item.Settings());
  
  public static final Item CHLOROPHYTE_POWDER = register("chlorophyte_powder", Item::new, new Item.Settings());
  
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
  public static final Item COAL_BRIQUETTE = register("coal_briquette", Item::new, new Item.Settings());
  public static final Item COAL_COKE = register("coal_coke", Item::new, new Item.Settings());
  
  public static final Item COBALT_INGOT = register("cobalt_ingot", Item::new, new Item.Settings());
  public static final Item COBALT_BILLET = register("cobalt_billet", Item::new, new Item.Settings());
  public static final Item COBALT_POWDER = register("cobalt_powder", Item::new, new Item.Settings());
  public static final Item COBALT_NUGGET = register("cobalt_nugget", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_COBALT_POWDER = register("tiny_pile_of_cobalt_powder", Item::new, new Item.Settings());
  public static final Item COBALT_60_INGOT = register("cobalt_60_ingot", Item::new, new Item.Settings());
  public static final Item COBALT_60_BILLET = register("cobalt_60_billet", Item::new, new Item.Settings());
  public static final Item COBALT_60_POWDER = register("cobalt_60_powder", Item::new, new Item.Settings());
  public static final Item COBALT_60_NUGGET = register("cobalt_60_nugget", Item::new, new Item.Settings());
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
  
  public static final Item CRYO_POWDER = register("cryo_powder", Item::new, new Item.Settings());
  
  public static final Item RAW_CRYOLITE = register("raw_cryolite", Item::new, new Item.Settings());
  public static final Item CRYOLITE_CHUNK = register("cryolite_chunk", Item::new, new Item.Settings());
  
  public static final Item DESH_INGOT = register("desh_ingot", Item::new, new Item.Settings());
  public static final Item DESH_BLEND = register("desh_blend", Item::new, new Item.Settings());
  public static final Item DESHREADY_BLEND = register("deshready_blend", Item::new, new Item.Settings());
  public static final Item DESH_POWDER = register("desh_powder", Item::new, new Item.Settings());
  public static final Item DESH_NUGGET = register("desh_nugget", Item::new, new Item.Settings());
  public static final Item CAST_DESH_PLATE = register("cast_desh_plate", Item::new, new Item.Settings());
  
  public static final Item DIAMOND_POWDER = register("diamond_powder", Item::new, new Item.Settings());
  public static final Item DIAMOND_CRYSTALS = register("diamond_crystals", Item::new, new Item.Settings());
  
  public static final Item DINEUTRONIUM_INGOT = register("dineutronium_ingot", Item::new, new Item.Settings());
  public static final Item DINEUTRONIUM_POWDER = register("dineutronium_powder", Item::new, new Item.Settings());
  public static final Item DINEUTRONIUM_NUGGET = register("dineutronium_nugget", Item::new, new Item.Settings());
  public static final Item DENSE_DINEUTRONIUM_WIRE = register("dense_dineutronium_wire", Item::new, new Item.Settings());
  
  public static final Item ELECTRONIUM_INGOT = register("electronium_ingot", Item::new, new Item.Settings());
  
  public static final Item EMERALD_POWDER = register("emerald_powder", Item::new, new Item.Settings());
  
  public static final Item ENERGY_POWDER = register("energy_powder", Item::new, new Item.Settings());
  
  public static final Item EUPHEMIUM_INGOT = register("euphemium_ingot", Item::new, new Item.Settings());
  public static final Item EUPHEMIUM_POWDER = register("euphemium_powder", Item::new, new Item.Settings());
  public static final Item EUPHEMIUM_NUGGET = register("euphemium_nugget", Item::new, new Item.Settings());
  
  public static final Item FERRIC_SCHARBIDATE_INGOT = register("ferric_schrabidate_ingot", Item::new, new Item.Settings());
  public static final Item FERRIC_SCHARBIDATE_POWDER = register("ferric_schrabidate_powder", Item::new, new Item.Settings());
  public static final Item CAST_FERRIC_SCHARBIDATE_PLATE = register("cast_ferric_schrabidate_plate", Item::new, new Item.Settings());
  public static final Item DENSE_FERRIC_SCHARBIDATE_WIRE = register("dense_ferric_schrabidate_wire", Item::new, new Item.Settings());
  
  public static final Item FERROURANIUM_INGOT = register("ferrouranium_ingot", Item::new, new Item.Settings());
  public static final Item CAST_FERROURANIUM_PLATE = register("cast_ferrouranium_plate", Item::new, new Item.Settings());
  
  public static final Item FLASH_GOLD = register("flash_gold", Item::new, new Item.Settings());
  
  public static final Item FLASH_LEAD = register("flash_lead", Item::new, new Item.Settings());
  
  public static final Item FLUORITE = register("fluorite", Item::new, new Item.Settings());
  public static final Item FLUORITE_CRYSTALS = register("fluorite_crystals", Item::new, new Item.Settings());
  
  public static final Item FLUX = register("flux", Item::new, new Item.Settings());
  
  public static final Item FULLERENE = register("fullerene", Item::new, new Item.Settings());
  public static final Item CRYSTALLINE_FULLERENE = register("crystalline_fullerene", Item::new, new Item.Settings());
  
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
  
  public static final Item IODINE_POWDER = register("iodine_powder", Item::new, new Item.Settings());
  public static final Item IODINE_131_POWDER = register("iodine_131_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_IODINE_131_POWDER = register("tiny_pile_of_iodine_131_powder", Item::new, new Item.Settings());
  
  public static final Item IRON_POWDER = register("iron_powder", Item::new, new Item.Settings());
  public static final Item IRON_PLATE = register("iron_plate", Item::new, new Item.Settings());
  public static final Item CAST_IRON_PLATE = register("cast_iron_plate", Item::new, new Item.Settings());
  public static final Item WELDED_IRON_PLATE = register("welded_iron_plate", Item::new, new Item.Settings());
  public static final Item IRON_PIPE = register("iron_pipe", Item::new, new Item.Settings());
  public static final Item IRON_CRYSTALS = register("iron_crystals", Item::new, new Item.Settings());
  public static final Item RAW_METEORIC_IRON = register("raw_meteoric_iron", Item::new, new Item.Settings());
  
  public static final Item INDUSTRIAL_FERTILIZER = register("industrial_fertilizer", Item::new, new Item.Settings());
  
  public static final Item INFERNAL_COAL = register("infernal_coal", Item::new, new Item.Settings());
  
  public static final Item SEMI_STABLE_LANTHANUM_INGOT = register("semi_stable_lanthanum_ingot", Item::new, new Item.Settings());
  public static final Item LANTHANUM_POWDER = register("lanthanum_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_LANTHANUM_POWDER = register("tiny_pile_of_lanthanum_powder", Item::new, new Item.Settings());
  public static final Item LANTHANUM_FRAGMENT = register("lanthanum_fragment", Item::new, new Item.Settings());
  
  public static final Item LAPIS_POWDER = register("lapis_powder", Item::new, new Item.Settings());
  public static final Item LAPIS_CRYSTALS = register("lapis_crystals", Item::new, new Item.Settings());
  
  public static final Item LATEX = register("latex", Item::new, new Item.Settings());
  public static final Item LATEX_BAR = register("latex_bar", Item::new, new Item.Settings());
  
  public static final Item RAW_LEAD = register("raw_lead", Item::new, new Item.Settings());
  public static final Item LEAD_INGOT = register("lead_ingot", Item::new, new Item.Settings());
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
  
  public static final Item LIMESTONE_POWDER = register("limestone_powder", Item::new, new Item.Settings());
  
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
  
  public static final Item NEODYMIUM_POWDER = register("neodymium_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_NEODYMIUM_POWDER = register("tiny_pile_of_neodymium_powder", Item::new, new Item.Settings());
  public static final Item DENSE_NEODYMIUM_WIRE = register("dense_neodymium_wire", Item::new, new Item.Settings());
  public static final Item NEODYMIUM_FRAGMENT = register("neodymium_fragment", Item::new, new Item.Settings());
  
  public static final Item NEPTUNIUM_INGOT = register("neptunium_ingot", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_POWDER = register("neptunium_powder", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_BILLET = register("neptunium_billet", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_NUGGET = register("neptunium_nugget", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_FUEL_INGOT = register("neptunium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_FUEL_BILLET = register("neptunium_fuel_billet", Item::new, new Item.Settings());
  public static final Item NEPTUNIUM_FUEL_NUGGET = register("neptunium_fuel_nugget", Item::new, new Item.Settings());
  
  public static final Item NIOBIUM_INGOT = register("niobium_ingot", Item::new, new Item.Settings());
  public static final Item NIOBIUM_POWDER = register("niobium_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_NIOBIUM_POWDER = register("tiny_pile_of_niobium_powder", Item::new, new Item.Settings());
  public static final Item NIOBIUM_NUGGET = register("niobium_nugget", Item::new, new Item.Settings());
  public static final Item DENSE_NIOBIUM_WIRE = register("dense_niobium_wire", Item::new, new Item.Settings());
  public static final Item NIOBIUM_FRAGMENT = register("niobium_fragment", Item::new, new Item.Settings());
  
  public static final Item NITAN_BLEND = register("nitan_blend", Item::new, new Item.Settings());
  
  public static final Item NITER = register("niter", Item::new, new Item.Settings());
  public static final Item NITER_CRYSTALS = register("niter_crystals", Item::new, new Item.Settings());
  
  public static final Item RAW_OSMIRIDIUM_INFUSED_TEKTITE = register("raw_osmiridium_infused_tektite", Item::new, new Item.Settings());
  public static final Item OSMIRIDIUM_INGOT = register("osmiridium_ingot", Item::new, new Item.Settings());
  public static final Item OSMIRIDIUM_NUGGET = register("osmiridium_nugget", Item::new, new Item.Settings());
  public static final Item IMPURE_OSMIRIDIUM_POWDER = register("impure_osmiridium_powder", Item::new, new Item.Settings());
  public static final Item CAST_OSMIRIDIUM_PLATE = register("cast_osmiridium_plate", Item::new, new Item.Settings());
  public static final Item WELDED_OSMIRIDIUM_PLATE = register("welded_osmiridium_plate", Item::new, new Item.Settings());
  public static final Item OSMIRIDIUM_CRYSTALS = register("osmiridium_crystals", Item::new, new Item.Settings());
  
  public static final Item PALEOGENITE_POWDER = register("paleogenite_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_PALEOGENITE_POWDER = register("tiny_pile_of_paleogenite_powder", Item::new, new Item.Settings());
  
  public static final Item RED_PHOSPHORUS = register("red_phosphorus", settings -> new TooltipItem(settings, 2), new Item.Settings());
  public static final Item WHITE_PHOSPHORUS_BAR = register("white_phosphorus_bar", Item::new, new Item.Settings());
  public static final Item PHOSPHORUS_CRYSTALS = register("phosphorus_crystals", Item::new, new Item.Settings());
  
  public static final Item PETROLEUM_COKE = register("petroleum_coke", Item::new, new Item.Settings());
  
  public static final Item RAW_PLUTONIUM = register("raw_plutonium", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_INGOT = register("plutonium_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_BILLET = register("plutonium_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_NUGGET = register("plutonium_nugget", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_FUEL_INGOT = register("plutonium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_FUEL_BILLET = register("plutonium_fuel_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_FUEL_NUGGET = register("plutonium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_PLUTONIUM_INGOT = register("reactor_grade_plutonium_ingot", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_PLUTONIUM_BILLET = register("reactor_grade_plutonium__billet", Item::new, new Item.Settings());
  public static final Item REACTOR_GRADE_PLUTONIUM_NUGGET = register("reactor_grade_plutonium_nugget", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_238_INGOT = register("plutonium_238_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_238_BILLET = register("plutonium_238_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_238_BE_BILLET = register("plutonium_238_be_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_238_NUGGET = register("plutonium_238_nugget", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_239_INGOT = register("plutonium_239_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_239_BILLET = register("plutonium_239_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_239_NUGGET = register("plutonium_239_nugget", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_240_INGOT = register("plutonium_240_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_240_BILLET = register("plutonium_240_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_240_NUGGET = register("plutonium_240_nugget", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_241_INGOT = register("plutonium_241_ingot", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_241_BILLET = register("plutonium_241_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_241_ZFB_BILLET = register("plutonium_241_zfb_billet", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_241_NUGGET = register("plutonium_241_nugget", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_POWDER = register("plutonium_powder", Item::new, new Item.Settings());
  public static final Item PLUTONIUM_CRYSTALS = register("plutonium_crystals", Item::new, new Item.Settings());
  
  public static final Item POISON_POWDER = register("poison_powder", settings -> new TooltipItem(settings, 2), new Item.Settings());
  
  public static final Item POLONIUM_210_INGOT = register("polonium_210_ingot", Item::new, new Item.Settings());
  public static final Item POLONIUM_210_BILLET = register("polonium_210_billet", Item::new, new Item.Settings());
  public static final Item POLONIUM_210_BE_BILLET = register("polonium_210_be_billet", Item::new, new Item.Settings());
  public static final Item POLONIUM_210_NUGGET = register("polonium_210_nugget", Item::new, new Item.Settings());
  public static final Item POLONIUM_210_POWDER = register("polonium_210_powder", Item::new, new Item.Settings());
  
  public static final Item POLYMER_BAR = register("polymer_bar", Item::new, new Item.Settings());
  public static final Item POLYMER_POWDER = register("polymer_powder", Item::new, new Item.Settings());
  
  public static final Item PULVERIZED_ENCHANTMENT = register("pulverized_enchantment", Item::new, new Item.Settings());
  
  public static final Item PVC_BAR = register("pvc_bar", Item::new, new Item.Settings());
  
  public static final Item QUARTZ_POWDER = register("quartz_powder", Item::new, new Item.Settings());
  
  public static final Item RADIUM_226_INGOT = register("radium_266_ingot", Item::new, new Item.Settings());
  public static final Item RADIUM_226_BILLET = register("radium_266_billet", Item::new, new Item.Settings());
  public static final Item RADIUM_226_BE_BILLET = register("radium_266_be_billet", Item::new, new Item.Settings());
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
  
  public static final Item SAWDUST_POWDER = register("sawdust_powder", Item::new, new Item.Settings());
  public static final Item SAWDUST_BRIQUETTE = register("sawdust_briquette", Item::new, new Item.Settings());
  
  public static final Item RAW_SCHRABIDIUM = register("raw_schrabidium", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_INGOT = register("schrabidium_ingot", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_BILLET = register("schrabidium_billet", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_NUGGET = register("schrabidium_nugget", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_FUEL_INGOT = register("schrabidium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_FUEL_BILLET = register("schrabidium_fuel_billet", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_FUEL_NUGGET = register("schrabidium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT = register("low_enriched_schrabidium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item LOW_ENRICHED_SCHRABIDIUM_FUEL_BILLET = register("low_enriched_schrabidium_fuel_billet", Item::new, new Item.Settings());
  public static final Item LOW_ENRICHED_SCHRABIDIUM_FUEL_NUGGET = register("low_enriched_schrabidium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT = register("highly_enriched_schrabidium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_BILLET = register("highly_enriched_schrabidium_fuel_billet", Item::new, new Item.Settings());
  public static final Item HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_NUGGET = register("highly_enriched_schrabidium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_POWDER = register("schrabidium_powder", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_PLATE = register("schrabidium_plate", Item::new, new Item.Settings());
  public static final Item CAST_SCHRABIDIUM_PLATE = register("cast_schrabidium_plate", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_WIRE = register("schrabidium_wire", Item::new, new Item.Settings());
  public static final Item DENSE_SCHRABIDIUM_WIRE = register("dense_schrabidium_wire", Item::new, new Item.Settings());
  public static final Item SCHRABIDIUM_CRYSTALS = register("schrabidium_crystals", Item::new, new Item.Settings());
  
  public static final Item SCHRARANIUM_INGOT = register("schraranium_ingot", Item::new, new Item.Settings());
  public static final Item SCHRARANIUM_CRYSTALS = register("schraranium_crystals", Item::new, new Item.Settings());
  
  public static final Item SEMTEX_BLEND = register("semtex_blend", Item::new, new Item.Settings());
  public static final Item SEMTEX_BAR = register("semtex_bar", settings -> new TooltipItem(settings, 3), new Item.Settings());
  
  public static final Item SILICON_BOULE = register("silicon_boule", Item::new, new Item.Settings());
  public static final Item SILICON_WAFER = register("silicon_wafer", Item::new, new Item.Settings());
  public static final Item PRINTED_SILICON_WAFER = register("printed_silicon_wafer", Item::new, new Item.Settings());
  public static final Item SILICON_NUGGET = register("silicon_nugget", Item::new, new Item.Settings());
  
  public static final Item SODIUM_POWDER = register("sodium_powder", Item::new, new Item.Settings());
  
  public static final Item SOLINIUM_INGOT = register("solinium_ingot", Item::new, new Item.Settings());
  public static final Item SOLINIUM_BILLET = register("solinium_billet", Item::new, new Item.Settings());
  public static final Item SOLINIUM_NUGGET = register("solinium_nugget", Item::new, new Item.Settings());
  
  public static final Item SPARK_BLEND = register("spark_blend", Item::new, new Item.Settings());
  
  public static final Item STARMETAL_INGOT = register("starmetal_ingot", Item::new, new Item.Settings());
  public static final Item DENSE_STARMETAL_WIRE = register("dense_starmetal_wire", Item::new, new Item.Settings());
  public static final Item STARMETAL_RING = register("starmetal_ring", Item::new, new Item.Settings());
  public static final Item STARMETAL_CRYSTALS = register("starmetal_crystals", Item::new, new Item.Settings());
  
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
  
  public static final Item TEKTITE_POWDER = register("tektite_powder", Item::new, new Item.Settings());
  
  public static final Item TENNESSINE_POWDER = register("tennessine_powder", Item::new, new Item.Settings());
  
  public static final Item THERMITE = register("thermite", Item::new, new Item.Settings());
  
  public static final Item RAW_THORIUM = register("raw_thorium", Item::new, new Item.Settings());
  public static final Item THORIUM_232_INGOT = register("thorium_232_ingot", Item::new, new Item.Settings());
  public static final Item THORIUM_232_BILLET = register("thorium_232_billet", Item::new, new Item.Settings());
  public static final Item THORIUM_232_NUGGET = register("thorium_232_nugget", Item::new, new Item.Settings());
  public static final Item THORIUM_FUEL_INGOT = register("thorium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item THORIUM_FUEL_BILLET = register("thorium_fuel_billet", Item::new, new Item.Settings());
  public static final Item THORIUM_FUEL_NUGGET = register("thorium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item THORIUM_POWDER = register("thorium_powder", Item::new, new Item.Settings());
  public static final Item THORIUM_CRYSTALS = register("thorium_crystals", Item::new, new Item.Settings());
  
  public static final Item RAW_TITANIUM = register("raw_titanium", Item::new, new Item.Settings());
  public static final Item TITANIUM_INGOT = register("titanium_ingot", Item::new, new Item.Settings());
  public static final Item TITANIUM_PLATE = register("titanium_plate", Item::new, new Item.Settings());
  public static final Item CAST_TITANIUM_PLATE = register("cast_titanium_plate", Item::new, new Item.Settings());
  public static final Item WELDED_TITANIUM_PLATE = register("welded_titanium_plate", Item::new, new Item.Settings());
  public static final Item TITANIUM_POWDER = register("titanium_powder", Item::new, new Item.Settings());
  public static final Item TITANIUM_SHELL = register("titanium_shell", Item::new, new Item.Settings());
  public static final Item DENSE_TITANIUM_WIRE = register("dense_titanium_wire", Item::new, new Item.Settings());
  public static final Item TITANIUM_CRYSTALS = register("titanium_crystals", Item::new, new Item.Settings());
  
  public static final Item RAW_TRIXITE = register("raw_trixite", Item::new, new Item.Settings());
  public static final Item TRIXITE_CRYSTALS = register("trixite_crystals", Item::new, new Item.Settings());
  
  public static final Item RAW_TUNGSTEN = register("raw_tungsten", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_INGOT = register("tungsten_ingot", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_POWDER = register("tungsten_powder", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_BOLT = register("tungsten_bolt", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_WIRE = register("tungsten_wire", Item::new, new Item.Settings());
  public static final Item DENSE_TUNGSTEN_WIRE = register("dense_tungsten_wire", Item::new, new Item.Settings());
  public static final Item TUNGSTEN_CRYSTALS = register("tungsten_crystals", Item::new, new Item.Settings());
  
  public static final Item RAW_URANIUM = register("raw_uranium", Item::new, new Item.Settings());
  public static final Item RAW_SCORCHED_URANIUM = register("raw_scorched_uranium", Item::new, new Item.Settings());
  public static final Item URANIUM_INGOT = register("uranium_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_BILLET = register("uranium_billet", Item::new, new Item.Settings());
  public static final Item URANIUM_NUGGET = register("uranium_nugget", Item::new, new Item.Settings());
  public static final Item URANIUM_FUEL_INGOT = register("uranium_fuel_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_FUEL_BILLET = register("uranium_fuel_billet", Item::new, new Item.Settings());
  public static final Item URANIUM_FUEL_NUGGET = register("uranium_fuel_nugget", Item::new, new Item.Settings());
  public static final Item URANIUM_233_INGOT = register("uranium_233_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_233_BILLET = register("uranium_233_billet", Item::new, new Item.Settings());
  public static final Item URANIUM_233_NUGGET = register("uranium_233_nugget", Item::new, new Item.Settings());
  public static final Item URANIUM_235_INGOT = register("uranium_235_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_235_BILLET = register("uranium_235_billet", Item::new, new Item.Settings());
  public static final Item URANIUM_235_NUGGET = register("uranium_235_nugget", Item::new, new Item.Settings());
  public static final Item URANIUM_238_INGOT = register("uranium_238_ingot", Item::new, new Item.Settings());
  public static final Item URANIUM_238_BILLET = register("uranium_238_billet", Item::new, new Item.Settings());
  public static final Item URANIUM_238_NUGGET = register("uranium_238_nugget", Item::new, new Item.Settings());
  public static final Item URANIUM_POWDER = register("uranium_powder", Item::new, new Item.Settings());
  public static final Item URANIUM_CRYSTALS = register("uranium_crystals", Item::new, new Item.Settings());
  
  public static final Item VOLCANIC_GEM = register("volcanic_gem", Item::new, new Item.Settings());
  
  public static final Item WEAPON_STEEL_INGOT = register("weapon_steel_ingot", Item::new, new Item.Settings());
  public static final Item WEAPON_STEEL_PLATE = register("weapon_steel_plate", Item::new, new Item.Settings());
  public static final Item CAST_WEAPON_STEEL_PLATE = register("cast_weapon_steel_plate", Item::new, new Item.Settings());
  public static final Item WEAPON_STEEL_SHELL = register("weapon_steel_shell", Item::new, new Item.Settings());
  
  public static final Item XENON_135_POWDER = register("xenon_135_powder", Item::new, new Item.Settings());
  public static final Item TINY_PILE_OF_XENON_135_POWDER = register("tiny_pile_of_xenon_135_powder", Item::new, new Item.Settings());
  
  public static final Item YHARONITE_BILLET = register("yharonite_billet", Item::new, new Item.Settings());
  
  public static final Item YELLOWCAKE = register("yellowcake", Item::new, new Item.Settings());
  
  public static final Item ZIRCONIUM_SPLINTER = register("zirconium_splinter", Item::new, new Item.Settings());
  public static final Item ZIRCONIUM_CUBE = register("zirconium_cube", Item::new, new Item.Settings());
  public static final Item ZIRCONIUM_BILLET = register("zirconium_billet", Item::new, new Item.Settings());
  public static final Item ZIRCONIUM_POWDER = register("zirconium_powder", Item::new, new Item.Settings());
  public static final Item CAST_ZIRCONIUM_PLATE = register("cast_zirconium_plate", Item::new, new Item.Settings());
  public static final Item WELDED_ZIRCONIUM_PLATE = register("welded_zirconium_plate", Item::new, new Item.Settings());
  public static final Item ZIRCONIUM_WIRE = register("zirconium_wire", Item::new, new Item.Settings());
  
  // TODO: Heatable/Forgeable Ingots
  // public static final ItemOption DUSTED_STEEL_INGOT = register("dusted_steel_ingot", ItemOption::new, new ItemOption.Settings());
  // public static final ItemOption HEAVY_CHAINSTEEL_INGOT = register("heavy_chainsteel_ingot", ItemOption::new, new ItemOption.Settings());
  // public static final ItemOption FORGED_METEORITE_INGOT = register("forged_meteorite_ingot", ItemOption::new, new ItemOption.Settings());
  
  
  // Usable Items
  public static final Item DEBUG_WAND = register("debug_wand", DebugWandItem::new, new Item.Settings());
  public static final Item CONSTRUCTION_WAND = register("construction_wand", ConstructionWandItem::new, new Item.Settings());
  public static final Item NETWORK_DEBUG_TOOL = register("network_debug_tool", NetworkDebuggingToolItem::new, new Item.Settings());
  public static final Item GEIGER_COUNTER = register("geiger_counter", GeigerCounterItem::new, new Item.Settings());
  public static final Item DOSIMETER = register("dosimeter", DosimeterItem::new, new Item.Settings());
  
  // Batteries
  public static final Item BATTERY = register("battery",
      settings -> new SimpleBatteryItem(settings, 5_000L, 100L), new Item.Settings());
  public static final Item REDSTONE_POWER_CELL = register("redstone_power_cell",
      settings -> new SimpleBatteryItem(settings, 15_000L, 100L), new Item.Settings());
  public static final Item SIXFOLD_REDSTONE_POWER_CELL = register("sixfold_redstone_power_cell",
      settings -> new SimpleBatteryItem(settings, 90_000L, 100L), new Item.Settings());
  public static final Item TWENTY_FOUR_FOLD_REDSTONE_POWER_CELL = register("twenty_four_fold_redstone_power_cell",
      settings -> new SimpleBatteryItem(settings, 360_000L, 100L), new Item.Settings());
  public static final Item ADVANCED_BATTERY = register("advanced_battery",
      settings -> new SimpleBatteryItem(settings, 20_000L, 500L), new Item.Settings());
  public static final Item ADVANCED_POWER_CELL = register("advanced_power_cell",
      settings -> new SimpleBatteryItem(settings, 60_000L, 500L), new Item.Settings());
  public static final Item QUADRUPLE_ADVANCED_POWER_CELL = register("quadruple_advanced_power_cell",
      settings -> new SimpleBatteryItem(settings, 240_000L, 500L), new Item.Settings());
  public static final Item TWELVEFOLD_ADVANCED_POWER_CELL = register("twelvefold_advanced_power_cell",
      settings -> new SimpleBatteryItem(settings, 720_000L, 500L), new Item.Settings());
  public static final Item LITHIUM_ION_BATTERY = register("lithium_ion_battery",
      settings -> new SimpleBatteryItem(settings, 250_000L, 1_000L), new Item.Settings());
  public static final Item LITHIUM_ION_POWER_CELL = register("lithium_ion_power_cell",
      settings -> new SimpleBatteryItem(settings, 750_000L, 1_000L), new Item.Settings());
  // Triple TRIPLE_LITHIUM_ION_POWER_CELL has one extra comma digit because its max energy would be rounded otherwise, that's why it has an extra class
  public static final Item TRIPLE_LITHIUM_ION_POWER_CELL = register("triple_lithium_ion_power_cell", TripleLithiumIonBatteryItem::new, new Item.Settings());
  public static final Item SIXFOLD_LITHIUM_ION_POWER_CELL = register("sixfold_lithium_ion_power_cell",
      settings -> new SimpleBatteryItem(settings, 4_500_000L, 1_000L), new Item.Settings());
  public static final Item SCHRABIDIUM_BATTERY = register("schrabidium_battery",
      settings -> new SimpleBatteryItem(settings, 1_000_000L, 5_000L), new Item.Settings());
  public static final Item SCHRABIDIUM_POWER_CELL = register("schrabidium_power_cell",
      settings -> new SimpleBatteryItem(settings, 3_000_000L, 5_000L), new Item.Settings());
  public static final Item DOUBLE_SCHRABIDIUM_POWER_CELL = register("double_schrabidium_power_cell",
      settings -> new SimpleBatteryItem(settings, 6_000_000L, 5_000L), new Item.Settings());
  public static final Item QUADRUPLE_SCHRABIDIUM_POWER_CELL = register("quadruple_schrabidium_power_cell",
      settings -> new SimpleBatteryItem(settings, 12_000_000L, 5_000L), new Item.Settings());
  public static final Item SPARK_BATTERY = register("spark_battery",
      settings -> new SimpleBatteryItem(settings, 100_000_000L, 2_000_000L), new Item.Settings());
  public static final Item OFF_BRAND_SPARK_BATTERY = register("off_brand_spark_battery",
      settings -> new SimpleBatteryItem(settings, 5_000_000L, 40_000L, 200_000L), new Item.Settings());
  public static final Item SPARK_POWER_CELL = register("spark_power_cell",
      settings -> new SimpleBatteryItem(settings, 600_000_000L, 2_000_000L), new Item.Settings());
  public static final Item SPARK_ARCANE_CAR_BATTERY = register("spark_arcane_car_battery",
      settings -> new SimpleBatteryItem(settings, 2_500_000_000L, 2_000_000L), new Item.Settings());
  public static final Item SPARK_ARCANE_ENERGY_STORAGE_ARRAY = register("spark_arcane_energy_storage_array",
      settings -> new SimpleBatteryItem(settings, 10_000_000_000L, 2_000_000L), new Item.Settings());
  public static final Item SPARK_ARCANE_MASS_ENERGY_VOID = register("spark_arcane_mass_energy_void",
      settings -> new SimpleBatteryItem(settings, 100_000_000_000L, 20_000_000L), new Item.Settings());
  public static final Item SPARK_ARCANE_DIRAC_SEA = register("spark_arcane_dirac_sea",
      settings -> new SimpleBatteryItem(settings, 250_000_000_000L, 20_000_000L), new Item.Settings());
  public static final Item SPARK_SOLID_SPACE_TIME_CRYSTAL = register("spark_solid_space_time_crystal",
      settings -> new SimpleBatteryItem(settings, 1_000_000_000_000L, 200_000_000L), new Item.Settings());
  public static final Item SPARK_LUDICROUS_ENERGY_STORAGE_UNIT = register("spark_ludicrous_energy_storage_unit",
      settings -> new SimpleBatteryItem(settings, 100_000_000_000_000L, 200_000_000L), new Item.Settings());
  public static final Item ELECTRONIUM_CUBE = register("electronium_cube",
      settings -> new SimpleBatteryItem(settings, 1_000_000_000_000_000_000L, 1_000_000_000_000_000L), new Item.Settings());
  public static final Item INFINITE_BATTERY = register("infinite_battery", InfiniteBatteryItem::new, new Item.Settings());
  public static final Item POTATO_BATTERY = register("potato_battery", settings -> new SimpleBatteryItem(settings, 1_000L, 0L, 100L),
      new Item.Settings().component(NTMDataComponentTypes.ENERGY_COMPONENT_TYPE, 1_000L));
  public static final Item POTATOS = register("potatos", settings -> new PotatOSItem(settings, 500_000L, 0L, 100L),
      new Item.Settings().component(NTMDataComponentTypes.ENERGY_COMPONENT_TYPE, 500_000L));
  public static final Item SELF_CHARGING_URANIUM_238_BATTERY = register("self_charging_uranium_238_battery", settings -> new SelfChargingBatteryItem(settings, 5L), new Item.Settings());
  public static final Item SELF_CHARGING_TECHNETIUM_99_BATTERY = register("self_charging_technetium_99_battery", settings -> new SelfChargingBatteryItem(settings, 25L), new Item.Settings());
  public static final Item SELF_CHARGING_PLUTONIUM_238_BATTERY = register("self_charging_plutonium_238_battery", settings -> new SelfChargingBatteryItem(settings, 100L), new Item.Settings());
  public static final Item SELF_CHARGING_POLONIUM_210_BATTERY = register("self_charging_polonium_210_battery", settings -> new SelfChargingBatteryItem(settings, 500L), new Item.Settings());
  public static final Item SELF_CHARGING_GOLD_198_BATTERY = register("self_charging_gold_198_battery", settings -> new SelfChargingBatteryItem(settings, 2_500L), new Item.Settings());
  public static final Item SELF_CHARGING_LEAD_209_BATTERY = register("self_charging_lead_209_battery", settings -> new SelfChargingBatteryItem(settings, 5_000L), new Item.Settings());
  public static final Item SELF_CHARGING_AMERICIUM_241_BATTERY = register("self_charging_americium_241_battery", settings -> new SelfChargingBatteryItem(settings, 10_000L), new Item.Settings());
  
  // Consumables
  public static final Item EMPTY_SYRINGE = register("empty_syringe", Item::new, new Item.Settings());
  public static final Item POISONOUS_INJECTION = register("poisonous_injection", settings ->
      new InjectionItem(settings, NTMSounds.SYRINGE_INJECTS, EMPTY_SYRINGE,
          (serverWorld, entity) -> {
            if (!entity.isInCreativeMode()){
              EntityUtil.applyDamage(entity, serverWorld, NTMDamageTypes.EUTHANIZED, 30f);
            }else {
              EntityUtil.applyDamage(entity, serverWorld, NTMDamageTypes.EUTHANIZED, 2f);
            }}
      ), new Item.Settings()
  );
  public static final Item ANTIDOTE = register("antidote", settings ->
      new InjectionItem(settings, NTMSounds.SYRINGE_INJECTS, EMPTY_SYRINGE,
          (serverWorld, entity) -> entity.clearStatusEffects()
      ), new Item.Settings()
  );
  public static final Item AWESOME = register("awesome", settings ->
      new InjectionItem(settings, NTMSounds.SYRINGE_INJECTS, EMPTY_SYRINGE,
          (serverWorld, entity) -> {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 150, 4, false, false, true));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 700, 6, false, false, true));
            entity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.RAD_X, 700, 9, false, false, true));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 700, 9, false, false, true));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 700, 24, false, false, true));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 700, 9, false, false, true));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 700, 4, false, false, true));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 700, 9, false, false, true));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 700, 9, false, false, true));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 700, 9, false, false, true));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 700, 0, false, false, true));
          }), new Item.Settings().rarity(Rarity.UNCOMMON).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
  );
  public static final Item METAL_SYRINGE = register("metal_syringe", Item::new, new Item.Settings());
  public static final Item STIMPAK = register("stimpak", settings -> new InjectionWithTooltipItem(settings, NTMSounds.SYRINGE_INJECTS, METAL_SYRINGE,
          (serverWorld, entity) -> entity.heal(5F)
      ), new Item.Settings()
  );
  public static final Item MED_X = register("med_x", settings -> new InjectionWithTooltipItem(settings, NTMSounds.SYRINGE_INJECTS, METAL_SYRINGE,
          (serverWorld, entity) -> entity.addStatusEffect(
              new StatusEffectInstance(StatusEffects.RESISTANCE, 4800, 2, false, false, true)
          )
      ), new Item.Settings()
  );
  public static final Item PSYCHO = register("psycho", settings -> new InjectionWithTooltipItem(settings, 2, NTMSounds.SYRINGE_INJECTS, METAL_SYRINGE,
      (serverWorld, entity) -> {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2400, 0, false, false, true));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 0, false, false, true));
      }), new Item.Settings()
  );
  public static final Item SUPER_STIMPAK = register("super_stimpak", settings -> new InjectionWithTooltipItem(settings, 2, NTMSounds.SYRINGE_INJECTS, METAL_SYRINGE,
      (serverWorld, entity) -> {
        entity.heal(50F);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 0, false, false, true));
      }), new Item.Settings()
  );
  public static final Item FIRST_AID_KIT = register("first_aid_kit", settings -> new InjectionWithTooltipItem(settings, 2, null, Items.AIR,
      (serverWorld, entity) -> {
        entity.setHealth(entity.getMaxHealth());
        EntityUtil.removeNegativeEffects(entity);
      }), new Item.Settings()
  );
  
  public static final Item IV_BAG = register("iv_bag", IvBagItem::new, new Item.Settings());
  public static final Item BLOOD_BAG = register("blood_bag", settings -> new InjectionItem(settings, NTMSounds.IV_BAG_INJECTS, IV_BAG,
          (serverWorld, entity) -> entity.heal(5F)
      ), new Item.Settings()
  );
  public static final Item EMPTY_EXPERIENCE_BAG = register("empty_experience_bag", EmptyExperienceBagItem::new, new Item.Settings());
  public static final Item EXPERIENCE_BAG = register("experience_bag", ExperienceBagItem::new, new Item.Settings());
  public static final Item RAD_AWAY = register("rad_away", settings -> new InjectionItem(settings, NTMSounds.IV_BAG_INJECTS, IV_BAG,
          (serverWorld, entity) -> EntityUtil.addEffectDuration(entity, NTMStatusEffects.RAD_AWAY, 140)
      ), new Item.Settings()
  );
  public static final Item STRONG_RAD_AWAY = register("strong_rad_away", settings -> new InjectionItem(settings, NTMSounds.IV_BAG_INJECTS, IV_BAG,
          (serverWorld, entity) -> EntityUtil.addEffectDuration(entity, NTMStatusEffects.RAD_AWAY, 350)
      ), new Item.Settings()
  );
  public static final Item ELITE_RAD_AWAY = register("elite_rad_away", settings -> new InjectionItem(settings, NTMSounds.IV_BAG_INJECTS, IV_BAG,
          (serverWorld, entity) -> EntityUtil.addEffectDuration(entity, NTMStatusEffects.RAD_AWAY, 500)
      ), new Item.Settings()
  );
  public static final Item RAD_X = register("rad_x", TooltipItem::new, new Item.Settings()
      .food(NTMFoodComponents.ALWAYS_EDIBLE, NTMConsumableComponents.RAD_X)
  );
  public static final Item IODINE_PILL = register("iodine_pill", TooltipItem::new, new Item.Settings()
      .food(NTMFoodComponents.ALWAYS_EDIBLE, NTMConsumableComponents.IODINE_PILL)
  );
  public static final Item PLAN_C = register("plan_c", PlanC::new, new Item.Settings()
      .food(NTMFoodComponents.ALWAYS_EDIBLE)
  );
  public static final Item EMPTY_CAN = register("empty_can", Item::new, new Item.Settings());
  public static final Item RING_PULL = register("ring_pull", Item::new, new Item.Settings());
  public static final Item SMART_ENERGY_DRINK = register("smart_energy_drink", settings -> new DrinkCanItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.STRENGTH, 600, 0, false, false, true),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 3, false, false, true)
      )), new Item.Settings());
  public static final Item CREATURE_ENERGY_DRINK = register("creature_energy_drink", settings -> new DrinkCanItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 0, false, false, true),
          new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 3, false, false, true)
      )), new Item.Settings());
  public static final Item RED_BOMB_ENERGY_DRINK = register("red_bomb_energy_drink", settings -> new DrinkCanItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 0, false, false, true),
          new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 2, false, false, true),
          new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 1, false, false, true)
      )), new Item.Settings());
  public static final Item DR_SUGAR_SOFT_DRINK = register("dr_sugar_soft_drink", settings -> new DrinkCanItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 0, false, false, true),
          new StatusEffectInstance(StatusEffects.HASTE, 600, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 2, false, false, true)
      )), new Item.Settings());
  public static final Item OVERCHARGE_DELIRIUM_XT = register("overcharge_delirium_xt", settings -> new DrinkCanItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.STRENGTH, 600, 0, false, false, true),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 2, false, false, true)
      )), new Item.Settings());
  public static final Item BLACK_MESA_LUNA_DARK_COLA = register("black_mesa_luna_dark_cola", settings -> new DrinkCanItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.STRENGTH, 600, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.REGENERATION, 600, 2, false, false, true),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 2, false, false, true)
      )), new Item.Settings());
  public static final Item BEPIS = register("bepis", settings -> new DrinkCanItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 3, false, false, true),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 3, false, false, true)
      )), new Item.Settings());
  public static final Item DR_BREENS_PRIVATE_RESERVE = register("dr_breens_private_reserve", settings -> new DrinkCanItem(settings, 2,
      List.of(
          new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0, false, false, true)
      )), new Item.Settings());
  public static final Item MUG_ROOT_BEER = register("mug_root_beer", settings -> new DrinkCanItem(settings, 0,
      List.of(
          new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 2, false, false, true),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 3600, 2, false, false, true)
      )), new Item.Settings());
  
  public static final Item WAFFLE_OF_MASS_DESTRUCTION = register("waffle_of_mass_destruction", DestructiveWaffleItem::new, new Item.Settings());
  public static final Item VEGAN_SCHNITZEL = register("vegan_schnitzel", VeganSchnitzelItem::new, new Item.Settings());
  public static final Item RADIOACTIVE_COTTON_CANDY = register("radioactive_cotton_candy", Item::new, new Item.Settings()
      .food(NTMFoodComponents.RADIOACTIVE_COTTON_CANDY, NTMConsumableComponents.RADIOACTIVE_COTTON_CANDY));
  
  public static final Item BASIC_LEAD_APPLE = register("basic_lead_apple", Item::new, new Item.Settings()
      .food(NTMFoodComponents.LEAD_APPLE, NTMConsumableComponents.BASIC_LEAD_APPLE).rarity(Rarity.UNCOMMON));
  public static final Item GOOD_LEAD_APPLE = register("good_lead_apple", Item::new, new Item.Settings()
      .food(NTMFoodComponents.LEAD_APPLE, NTMConsumableComponents.GOOD_LEAD_APPLE).rarity(Rarity.RARE));
  public static final Item EPIC_LEAD_APPLE = register("epic_lead_apple", Item::new, new Item.Settings()
      .food(NTMFoodComponents.LEAD_APPLE, NTMConsumableComponents.EPIC_LEAD_APPLE).rarity(Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true));
  
  public static final Item BASIC_SCHRABIDIUM_APPLE = register("basic_schrabidium_apple", Item::new, new Item.Settings()
      .food(NTMFoodComponents.SCHRABIDIUM_APPLE, NTMConsumableComponents.BASIC_SCHRABIDIUM_APPLE).rarity(Rarity.UNCOMMON));
  public static final Item GOOD_SCHRABIDIUM_APPLE = register("good_schrabidium_apple", Item::new, new Item.Settings()
      .food(NTMFoodComponents.SCHRABIDIUM_APPLE, NTMConsumableComponents.GOOD_SCHRABIDIUM_APPLE).rarity(Rarity.RARE));
  public static final Item EPIC_SCHRABIDIUM_APPLE = register("epic_schrabidium_apple", Item::new, new Item.Settings()
      .food(NTMFoodComponents.SCHRABIDIUM_APPLE, NTMConsumableComponents.EPIC_SCHRABIDIUM_APPLE).rarity(Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true));
  
  public static final Item EUPHEMIUM_APPLE = register("euphemium_apple", Item::new, new Item.Settings()
      .food(NTMFoodComponents.SCHRABIDIUM_APPLE, NTMConsumableComponents.EUPHEMIUM_APPLE).rarity(Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true));
  
  public static final Item CHEAP_TEM_FLAKES = register("cheap_tem_flakes", TemFlakesItem::new, new Item.Settings());
  public static final Item TEM_FLAKES = register("tem_flakes", TemFlakesItem::new, new Item.Settings());
  public static final Item EXPENSIVE_TEM_FLAKES = register("expensive_tem_flakes", TemFlakesItem::new, new Item.Settings());
  
  public static final Item GLOWING_MUSHROOM_STEW = register("glowing_mushroom_stew", Item::new, new Item.Settings()
      .food(NTMFoodComponents.GLOWING_MUSHROOM_STEW).useRemainder(Items.BOWL));
  public static final Item SCRAMBLED_BALEFIRE_EGG = register("scrambled_balefire_egg", Item::new, new Item.Settings()
      .food(NTMFoodComponents.GLOWING_MUSHROOM_STEW).useRemainder(Items.BOWL));
  public static final Item SCRAMBLED_BALEFIRE_EGG_AND_HAM = register("scrambled_balefire_egg_and_ham", Item::new, new Item.Settings()
      .food(NTMFoodComponents.GLOWING_MUSHROOM_STEW).useRemainder(Items.BOWL));
  public static final Item LEMON = register("lemon", TooltipItem::new, new Item.Settings()
      .food(NTMFoodComponents.LEMON));
  public static final Item MRE = register("mre", Item::new, new Item.Settings()
      .food(NTMFoodComponents.MRE));
  public static final Item LOOPS = register("loops", TooltipItem::new, new Item.Settings()
      .food(NTMFoodComponents.LOOPS));
  public static final Item IT_BREAKFAST = register("it_breakfast", TooltipItem::new, new Item.Settings()
      .food(NTMFoodComponents.IT_BREAKFAST).useRemainder(Items.BOWL));
  public static final Item SPONGEBOB_MACARONI = register("spongebob_macaroni", Item::new, new Item.Settings()
      .food(NTMFoodComponents.SPONGEBOB_MACARONI));
  public static final Item FOOD_ITEM = register("food_item", Item::new, new Item.Settings()
      .food(NTMFoodComponents.FOOD_ITEM));
  public static final Item TWINKIE = register("twinkie", TooltipItem::new, new Item.Settings()
      .food(NTMFoodComponents.TWINKIE));
  public static final Item TV_STATIC_SANDWICH = register("tv_static_sandwich", Item::new, new Item.Settings()
      .food(NTMFoodComponents.TV_STATIC_SANDWICH));
  public static final Item PUDDING = register("pudding", settings -> new TooltipItem(settings, 3), new Item.Settings()
      .food(NTMFoodComponents.PUDDING));
  public static final Item SCRAP_PANCAKE = register("scrap_pancake", ScrapPancakeItem::new, new Item.Settings());
  public static final Item CHICKEN_NUGGET = register("chicken_nugget", Item::new, new Item.Settings()
      .food(NTMFoodComponents.CHICKEN_NUGGET));
  public static final Item PEAS = register("peas", PeasItem::new, new Item.Settings());
  public static final Item MARSHMALLOW_ON_A_STICK = register("marshmallow_on_a_stick", Item::new, new Item.Settings()
      .food(NTMFoodComponents.MARSHMALLOW_ON_A_STICK));
  public static final Item ROASTED_MARSHMALLOW_ON_A_STICK = register("roasted_marshmallow_on_a_stick", Item::new, new Item.Settings()
      .food(NTMFoodComponents.ROASTED_MARSHMALLOW_ON_A_STICK));
  public static final Item CHEESE = register("cheese", Item::new, new Item.Settings()
      .food(NTMFoodComponents.CHEESE));
  public static final Item CHEESE_QUESADILLA = register("cheese_quesadilla", TooltipItem::new, new Item.Settings()
      .food(NTMFoodComponents.CHEESE_QUESADILLA));
  public static final Item GLYPHID_MEAT = register("glyphid_meat", Item::new, new Item.Settings()
      .food(NTMFoodComponents.GLYPHID_MEAT));
  public static final Item GRILLED_GLYPHID_MEAT = register("grilled_glyphid_meat", Item::new, new Item.Settings()
      .food(NTMFoodComponents.GRILLED_GLYPHID_MEAT));
  public static final Item GLYPHID_EGG = register("glyphid_egg", Item::new, new Item.Settings());
  public static final Item IPECAC_SYRUP = register("ipecac_syrup", settings -> new TooltipItem(settings, 2), new Item.Settings()
      .food(NTMFoodComponents.ALWAYS_EDIBLE, NTMConsumableComponents.IPECAC_SYRUP)
  );
  public static final Item PTSD_MEDICATION = register("ptsd_medication", settings -> new TooltipItem(settings, 2), new Item.Settings()
      .food(NTMFoodComponents.ALWAYS_EDIBLE, NTMConsumableComponents.IPECAC_SYRUP)
  );
  public static final Item STYLISH_FLASK = register("stylish_flask", StylishFlaskItem::new, new Item.Settings());
  public static final Item ARIZONA_MUCHO_MANGO = register("arizona_mucho_mango", TooltipItem::new, new Item.Settings()
      .food(NTMFoodComponents.ARIZONA_MUCHO_MANGO, NTMConsumableComponents.ARIZONA_MUCHO_MANGO));
  public static final Item RADIUM_CHOCOLATE = register("radium_chocolate", TooltipItem::new, new Item.Settings()
      .food(NTMFoodComponents.RADIUM_CHOCOLATE, NTMConsumableComponents.RADIUM_CHOCOLATE));
  public static final Item COFFEE = register("coffee", CoffeeItem::new, new Item.Settings());
  public static final Item RADIUM_COFFEE = register("radium_coffee", RadiumCoffeeItem::new, new Item.Settings());
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
          new StatusEffectInstance(StatusEffects.SPEED, 600, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.HASTE, 600, 1, false, false, true)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      NUKA_COLA_BOTTLE_CAP
  )));
  public static final Item BOTTLE_OF_NUKA_CHERRY = register("bottle_of_nuka_cherry", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 0, false, false, true),
          new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 2, false, false, true)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      NUKA_COLA_BOTTLE_CAP
  )));
  public static final Item BOTTLE_OF_NUKA_COLA_QUANTUM = register("bottle_of_nuka_cola_quantum", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.STRENGTH, 600, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 2, false, false, true)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      NUKA_COLA_QUANTUM_BOTTLE_CAP
  )));
  public static final Item BOTTLE_OF_S_COLA = register("bottle_of_s_cola", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 2400, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.HASTE, 2400, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 2, false, false, true),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 2400, 2, false, false, true)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      S_COLA_BOTTLE_CAP
  )));
  public static final Item BOTTLE_OF_S_COLA_RAD = register("bottle_of_s_cola_rad", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 2400, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.HASTE, 2400, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 4, false, false, true),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 2400, 2, false, false, true),
          new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400, 0, false, false, true)
      ), List.of(
      EMPTY_BOMB_BOTTLE,
      S_COLA_RAD_BOTTLE_CAP
  )));
  public static final Item BOTTLE_OF_KAROL = register("bottle_of_karol", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.HASTE, 600, 2, false, false, true),
          new StatusEffectInstance(StatusEffects.STRENGTH, 600, 2, false, false, true)
      ), List.of(
      EMPTY_BOTTLE,
      KAROL_BOTTLE_CAP
  )));
  public static final Item FIRST_BOTTLE_OF_KAROL = register("first_bottle_of_karol", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 2400, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.HASTE, 2400, 2, false, false, true),
          new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 2, false, false, true)
      ), List.of(
      EMPTY_BOTTLE,
      KAROL_BOTTLE_CAP
  )));
  public static final Item BOTTLE_OF_FRITZ_COLA = register("bottle_of_fritz_cola", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 600, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 2, false, false, true),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 2, false, false, true)
      ), List.of(
      EMPTY_BOTTLE,
      FRITZ_COLA_BOTTLE_CAP
  )));
  public static final Item FIRST_BOTTLE_OF_FRITZ_COLA = register("first_bottle_of_fritz_cola", new Item.Settings(), settings -> new BottleItem(settings,
      List.of(
          new StatusEffectInstance(StatusEffects.SPEED, 2400, 1, false, false, true),
          new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2400, 2, false, false, true),
          new StatusEffectInstance(StatusEffects.RESISTANCE, 2400, 2, false, false, true)
      ), List.of(
      EMPTY_BOTTLE,
      FRITZ_COLA_BOTTLE_CAP
  )));
  public static final Item WATERY_TAINT_INJECTION = register("watery_taint_injection", settings -> new InjectionWithTooltipItem(settings, 3, NTMSounds.SYRINGE_INJECTS,
      List.of(METAL_SYRINGE, EMPTY_BOTTLE),
      (serverWorld, entity) -> {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 0, false, false, true));
        entity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.TAINT, 1200, 0, false, false, true));
      }), new Item.Settings()
  );
  
  // Tools
  public static final Item STEEL_SWORD = register("steel_sword", new Item.Settings(), settings -> new SpecialSwordItem(settings, NTMToolMaterials.STEEL_TOOL_MATERIAL, 3.5f, 1f));
  public static final Item STEEL_PICKAXE = register("steel_pickaxe", new Item.Settings(), settings -> new SpecialPickaxeItem(settings, NTMToolMaterials.STEEL_TOOL_MATERIAL, 1.5f, 1f));
  public static final Item STEEL_AXE = register("steel_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, NTMToolMaterials.STEEL_TOOL_MATERIAL, 2.5f, 1f)
      .addModifier(new Modifiers.Decapitator()));
  public static final Item STEEL_SHOVEL = register("steel_shovel", new Item.Settings(), settings -> new SpecialShovelItem(settings, NTMToolMaterials.STEEL_TOOL_MATERIAL, 0.5f, 1f));
  public static final Item STEEL_HOE = register("steel_hoe", new Item.Settings(), settings -> new SpecialHoeItem(settings, NTMToolMaterials.STEEL_TOOL_MATERIAL, 0f, 1f));
  
  public static final Item TITANIUM_SWORD = register("titanium_sword", new Item.Settings(), settings -> new SpecialSwordItem(settings, NTMToolMaterials.TITANIUM_TOOL_MATERIAL, 3.5f, 1f));
  public static final Item TITANIUM_PICKAXE = register("titanium_pickaxe", new Item.Settings(), settings -> new SpecialPickaxeItem(settings, NTMToolMaterials.TITANIUM_TOOL_MATERIAL, 1.5f, 1f));
  public static final Item TITANIUM_AXE = register("titanium_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, NTMToolMaterials.TITANIUM_TOOL_MATERIAL, 2.5f, 1f)
      .addModifier(new Modifiers.Decapitator()));
  public static final Item TITANIUM_SHOVEL = register("titanium_shovel", new Item.Settings(), settings -> new SpecialShovelItem(settings, NTMToolMaterials.TITANIUM_TOOL_MATERIAL, 0.5f, 1f));
  public static final Item TITANIUM_HOE = register("titanium_hoe", new Item.Settings(), settings -> new SpecialHoeItem(settings, NTMToolMaterials.TITANIUM_TOOL_MATERIAL, 0f, 1f));
  
  public static final Item ADVANCED_ALLOY_SWORD = register("advanced_alloy_sword", new Item.Settings(), settings -> new SpecialSwordItem(settings, NTMToolMaterials.ADVANCED_ALLOY_TOOL_MATERIAL, 5f, 1f)
      .addModifier(new Modifiers.Stunning(2)));
  public static final Item ADVANCED_ALLOY_PICKAXE = register("advanced_alloy_pickaxe", new Item.Settings(), settings -> new SpecialPickaxeItem(settings, NTMToolMaterials.ADVANCED_ALLOY_TOOL_MATERIAL, 2f, 1f)
      .addAbility(new Abilities.VeinMiner(3)));
  public static final Item ADVANCED_ALLOY_AXE = register("advanced_alloy_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, NTMToolMaterials.ADVANCED_ALLOY_TOOL_MATERIAL, 4f, 1f)
      .addAbility(new Abilities.VeinMiner(3))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item ADVANCED_ALLOY_SHOVEL = register("advanced_alloy_shovel", new Item.Settings(), settings -> new SpecialShovelItem(settings, NTMToolMaterials.ADVANCED_ALLOY_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(3)));
  public static final Item ADVANCED_ALLOY_HOE = register("advanced_alloy_hoe", new Item.Settings(), settings -> new SpecialHoeItem(settings, NTMToolMaterials.ADVANCED_ALLOY_TOOL_MATERIAL, 0f, 1f));
  
  public static final Item CMB_STEEL_SWORD = register("cmb_steel_sword", new Item.Settings(), settings -> new SpecialSwordItem(settings, NTMToolMaterials.CMB_STEEL_TOOL_MATERIAL, 28f, 1f)
      .addModifier(new Modifiers.Stunning(2))
      .addModifier(new Modifiers.Vampire(2.0f)));
  public static final Item CMB_STEEL_PICKAXE = register("cmb_steel_pickaxe", new Item.Settings(), settings -> new SpecialPickaxeItem(settings, NTMToolMaterials.CMB_STEEL_TOOL_MATERIAL, 3f, 1f)
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3)));
  public static final Item CMB_STEEL_AXE = register("cmb_steel_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, NTMToolMaterials.CMB_STEEL_TOOL_MATERIAL, 23f, 1f)
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item CMB_STEEL_SHOVEL = register("cmb_steel_shovel", new Item.Settings(), settings -> new SpecialShovelItem(settings, NTMToolMaterials.CMB_STEEL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3)));
  public static final Item CMB_STEEL_HOE = register("cmb_steel_hoe", new Item.Settings(), settings -> new SpecialHoeItem(settings, NTMToolMaterials.CMB_STEEL_TOOL_MATERIAL, 0f, 1f));
  
  public static final Item COBALT_SWORD = register("cobalt_sword", new Item.Settings(), settings -> new SpecialSwordItem(settings, NTMToolMaterials.COBALT_TOOL_MATERIAL, 11.5f, 1f));
  public static final Item COBALT_PICKAXE = register("cobalt_pickaxe", new Item.Settings(), settings -> new SpecialPickaxeItem(settings, NTMToolMaterials.COBALT_TOOL_MATERIAL, 1.5f, 1f));
  public static final Item COBALT_AXE = register("cobalt_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, NTMToolMaterials.COBALT_TOOL_MATERIAL, 4.5f, 1f)
      .addModifier(new Modifiers.Decapitator()));
  public static final Item COBALT_SHOVEL = register("cobalt_shovel", new Item.Settings(), settings -> new SpecialShovelItem(settings, NTMToolMaterials.COBALT_TOOL_MATERIAL, 1f, 1f));
  public static final Item COBALT_HOE = register("cobalt_hoe", new Item.Settings(), settings -> new SpecialHoeItem(settings, NTMToolMaterials.COBALT_TOOL_MATERIAL, 0f, 1f));
  
  public static final Item DECORATED_COBALT_SWORD = register("decorated_cobalt_sword", new Item.Settings(), settings -> new SpecialSwordItem(settings, NTMToolMaterials.DECORATED_COBALT_TOOL_MATERIAL, 11f, 1f)
      .addModifier(new Modifiers.LuckOfTheCollector()));
  public static final Item DECORATED_COBALT_PICKAXE = register("decorated_cobalt_pickaxe", new Item.Settings(), settings -> new SpecialPickaxeItem(settings, NTMToolMaterials.DECORATED_COBALT_TOOL_MATERIAL, 2f, 1f)
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3))
  );
  public static final Item DECORATED_COBALT_AXE = register("decorated_cobalt_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, NTMToolMaterials.DECORATED_COBALT_TOOL_MATERIAL, 4f, 1f)
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item DECORATED_COBALT_SHOVEL = register("decorated_cobalt_shovel", new Item.Settings(), settings -> new SpecialShovelItem(settings, NTMToolMaterials.DECORATED_COBALT_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(3)));
  public static final Item DECORATED_COBALT_HOE = register("decorated_cobalt_hoe", new Item.Settings(), settings -> new SpecialHoeItem(settings, NTMToolMaterials.DECORATED_COBALT_TOOL_MATERIAL, 0f, 1f));
  
  public static final Item STARMETAL_SWORD = register("starmetal_sword", new Item.Settings(), settings -> new SpecialSwordItem(settings, NTMToolMaterials.STARMETAL_TOOL_MATERIAL, 19f, 1f)
      .addModifier(new Modifiers.Decapitator())
      .addModifier(new Modifiers.Stunning(3))
      .addModifier(new Modifiers.LuckOfTheCollector()));
  public static final Item STARMETAL_PICKAXE = register("starmetal_pickaxe", new Item.Settings(), settings -> new SpecialPickaxeItem(settings, NTMToolMaterials.STARMETAL_TOOL_MATERIAL, 2f, 1f)
      .addAbility(new Abilities.VeinMiner(6))
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addModifier(new Modifiers.Stunning(3)));
  public static final Item STARMETAL_AXE = register("starmetal_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, NTMToolMaterials.STARMETAL_TOOL_MATERIAL, 6f, 1f)
      .addAbility(new Abilities.VeinMiner(6))
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addModifier(new Modifiers.Decapitator())
      .addModifier(new Modifiers.Stunning(3)));
  public static final Item STARMETAL_SHOVEL = register("starmetal_shovel", new Item.Settings(), settings -> new SpecialShovelItem(settings, NTMToolMaterials.STARMETAL_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.VeinMiner(6))
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addModifier(new Modifiers.Stunning(3)));
  public static final Item STARMETAL_HOE = register("starmetal_hoe", new Item.Settings(), settings -> new SpecialHoeItem(settings, NTMToolMaterials.STARMETAL_TOOL_MATERIAL, 0f, 1f));
  
  public static final Item DESH_SWORD = register("desh_sword", new Item.Settings(), settings -> new SpecialSwordItem(settings, NTMToolMaterials.DESH_TOOL_MATERIAL, 9.5f, 1f)
      .addModifier(new Modifiers.Stunning(2))
      .addModifier(new Modifiers.Vampire(2.0f)));
  public static final Item DESH_PICKAXE = register("desh_pickaxe", new Item.Settings(), settings -> new SpecialPickaxeItem(settings, NTMToolMaterials.DESH_TOOL_MATERIAL, 2f, 1f)
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(2)));
  public static final Item DESH_AXE = register("desh_axe", new Item.Settings(), settings -> new SpecialAxeItem(settings, NTMToolMaterials.DESH_TOOL_MATERIAL, 4.5f, 1f)
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(2))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item DESH_SHOVEL = register("desh_shovel", new Item.Settings(), settings -> new SpecialShovelItem(settings, NTMToolMaterials.DESH_TOOL_MATERIAL, 1f, 1f)
      .addAbility(new Abilities.AoE(1))
      .addAbility(new Abilities.VeinMiner(5))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(2)));
  public static final Item DESH_HOE = register("desh_hoe", new Item.Settings(), settings -> new SpecialHoeItem(settings, NTMToolMaterials.DESH_TOOL_MATERIAL, 0f, 1f));
  
  public static final Item SCHRABIDIUM_SWORD = register("schrabidium_sword", new Item.Settings().rarity(Rarity.RARE), settings -> new SpecialSwordItem(settings, NTMToolMaterials.SCHRABIDIUM_TOOL_MATERIAL, 65f, 1f)
      .addModifier(new Modifiers.RadioactiveBlade(50f))
      .addModifier(new Modifiers.Vampire(2f)));
  public static final Item SCHRABIDIUM_PICKAXE = register("schrabidium_pickaxe", new Item.Settings().rarity(Rarity.RARE), settings -> new SpecialPickaxeItem(settings, NTMToolMaterials.SCHRABIDIUM_TOOL_MATERIAL, 20f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(10))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.AutoShreader())
      .addModifier(new Modifiers.RadioactiveBlade(15f)));
  public static final Item SCHRABIDIUM_AXE = register("schrabidium_axe", new Item.Settings().rarity(Rarity.RARE), settings -> new SpecialAxeItem(settings, NTMToolMaterials.SCHRABIDIUM_TOOL_MATERIAL, 15f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(10))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.AutoShreader())
      .addModifier(new Modifiers.RadioactiveBlade(15f))
      .addModifier(new Modifiers.Decapitator()));
  public static final Item SCHRABIDIUM_SHOVEL = register("schrabidium_shovel", new Item.Settings().rarity(Rarity.RARE), settings -> new SpecialShovelItem(settings, NTMToolMaterials.SCHRABIDIUM_TOOL_MATERIAL, 5f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(10))
      .addAbility(new Abilities.SilkTouch())
      .addAbility(new Abilities.Fortune(5))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.AutoShreader())
      .addModifier(new Modifiers.RadioactiveBlade(15f)));
  public static final Item SCHRABIDIUM_HOE = register("schrabidium_hoe", new Item.Settings().rarity(Rarity.RARE), settings -> new SpecialHoeItem(settings, NTMToolMaterials.SCHRABIDIUM_TOOL_MATERIAL, 0f, 1f));
  
  public static final Item BISMUTH_PICKAXE = register("bismuth_pickaxe", new Item.Settings(), settings -> new SpecialBigPickaxeItem(settings, NTMToolMaterials.BISMUTH_TOOL_MATERIAL, 0f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AutoShreader())
      .addAbility(new Abilities.Fortune(2))
      .addAbility(new Abilities.SilkTouch()));
  public static final Item BISMUTH_AXE = register("bismuth_axe", new Item.Settings(), settings -> new SpecialBigAxeItem(settings, NTMToolMaterials.BISMUTH_TOOL_MATERIAL, 10f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AutoShreader())
      .addAbility(new Abilities.Fortune(2))
      .addAbility(new Abilities.SilkTouch())
      .addModifier(new Modifiers.Stunning(10))
      .addModifier(new Modifiers.Decapitator()));
  
  public static final Item MOLTEN_PICKAXE = register("molten_pickaxe", new Item.Settings(), settings -> new SpecialBigPickaxeItem(settings, NTMToolMaterials.MOLTEN_TOOL_MATERIAL, 0f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.Fortune(3))
      .addAbility(new Abilities.SilkTouch())
      .addModifier(new Modifiers.Flaming(5))
      .addModifier(new Modifiers.Vampire(2.0f))
      .addModifier(new Modifiers.Decapitator())
      .addCanBreakDepthRock());
  public static final Item MOLTEN_AXE = register("molten_axe", new Item.Settings(), settings -> new SpecialBigAxeItem(settings, NTMToolMaterials.MOLTEN_TOOL_MATERIAL, 10f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.AutoSmelt())
      .addAbility(new Abilities.Fortune(3))
      .addAbility(new Abilities.SilkTouch())
      .addModifier(new Modifiers.Flaming(10))
      .addModifier(new Modifiers.Vampire(3.0f))
      .addModifier(new Modifiers.Decapitator()));
  
  public static final Item CHLOROPHYTE_PICKAXE = register("chlorophyte_pickaxe", new Item.Settings(), settings -> new SpecialBigPickaxeItem(settings, NTMToolMaterials.CHLOTOPHYTE_TOOL_MATERIAL, 0f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.Fortune(4))
      .addAbility(new Abilities.AutoCentrifuge())
      .addAbility(new Abilities.MercuryTouch())
      .addModifier(new Modifiers.Stunning(10))
      .addModifier(new Modifiers.Vampire(5.0f))
      .addModifier(new Modifiers.Decapitator())
      .addCanBreakDepthRock());
  public static final Item CHLOROPHYTE_AXE = register("chlorophyte_axe", new Item.Settings(), settings -> new SpecialBigAxeItem(settings, NTMToolMaterials.CHLOTOPHYTE_TOOL_MATERIAL, 30f, 1f)
      .addAbility(new Abilities.AoE(2))
      .addAbility(new Abilities.VeinMiner(4))
      .addAbility(new Abilities.Fortune(4))
      .addModifier(new Modifiers.Stunning(10))
      .addModifier(new Modifiers.Vampire(5.0f))
      .addModifier(new Modifiers.Decapitator())
      .addCanBreakDepthRock());
  
  public static final Item MESE_PICKAXE = register("mese_pickaxe", new Item.Settings(), settings -> new SpecialBigPickaxeItem(settings, NTMToolMaterials.MESE_TOOL_MATERIAL, 0f, 1f)
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
  public static final Item MESE_AXE = register("mese_axe", new Item.Settings(), settings -> new SpecialBigAxeItem(settings, NTMToolMaterials.MESE_TOOL_MATERIAL, 40f, 1f)
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
  
  public static Item register(@NotNull String name, @NotNull Function<Item.Settings, Item> itemFactory, @NotNull Item.Settings settings) {
    RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, NTM.id(name));
    Item item = itemFactory.apply(settings.registryKey(itemKey));
    Registry.register(Registries.ITEM, itemKey, item);
    return item;
  }
  
  public static Item register(String name, Item.Settings settings, Function<Item.Settings, Item> itemFactory) {
    return register(name, itemFactory, settings);
  }
  
  public static void initialize() {
  }
}