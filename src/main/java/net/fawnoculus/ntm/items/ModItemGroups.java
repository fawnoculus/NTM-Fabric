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
      .icon(() -> new ItemStack(ModItems.BOTTLE_OF_NUKA_COLA))
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
      ItemGroup.add(ModItems.ACTINIUM_227_INGOT);
      ItemGroup.add(ModItems.ACTINIUM_227_BILLET);
      ItemGroup.add(ModItems.ACTINIUM_227_POWDER);
      ItemGroup.add(ModItems.TINY_PILE_OF_ACTINIUM_227_POWDER);
      ItemGroup.add(ModItems.ACTINIUM_227_NUGGET);
      ItemGroup.add(ModItems.ACTINIUM_227_FRAGMENT);
      
      ItemGroup.add(ModItems.ADVANCED_ALLOY_INGOT);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_POWDER);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_PLATE);
      ItemGroup.add(ModItems.CAST_ADVANCED_ALLOY_PLATE);
      ItemGroup.add(ModItems.ADVANCED_ALLOY_WIRE);
      ItemGroup.add(ModItems.DENSE_ADVANCED_ALLOY_WIRE);
      
      ItemGroup.add(ModItems.ALEXANDRITE);
      
      ItemGroup.add(ModItems.ALUMINIUM_INGOT);
      ItemGroup.add(ModItems.ALUMINIUM_POWDER);
      ItemGroup.add(ModItems.ALUMINIUM_PLATE);
      ItemGroup.add(ModItems.CAST_ALUMINIUM_PLATE);
      ItemGroup.add(ModItems.WELDED_ALUMINIUM_PLATE);
      ItemGroup.add(ModItems.ALUMINIUM_SHELL);
      ItemGroup.add(ModItems.ALUMINIUM_PIPE);
      ItemGroup.add(ModItems.ALUMINIUM_WIRE);
      ItemGroup.add(ModItems.ALUMINIUM_CRYSTALS);
      
      ItemGroup.add(ModItems.AMERICIUM_241_INGOT);
      ItemGroup.add(ModItems.AMERICIUM_242_INGOT);
      ItemGroup.add(ModItems.AMERICIUM_FUEL_INGOT);
      ItemGroup.add(ModItems.REACTOR_GRADE_AMERICIUM_INGOT);
      
      ItemGroup.add(ModItems.ARSENIC_INGOT);
      ItemGroup.add(ModItems.ARSENIC_NUGGET);
      ItemGroup.add(ModItems.ARSENIC_BRONZE_INGOT);
      ItemGroup.add(ModItems.CAST_ARSENIC_BRONZE_PLATE);
      
      ItemGroup.add(ModItems.ASBESTOS_SHEET);
      
      ItemGroup.add(ModItems.AUSTRALIUM_INGOT);
      ItemGroup.add(ModItems.AUSTRALIUM_BILLET);
      ItemGroup.add(ModItems.LESSER_AUSTRALIUM_BILLET);
      ItemGroup.add(ModItems.GREATER_AUSTRALIUM_BILLET);
      ItemGroup.add(ModItems.AUSTRALIUM_NUGGET);
      ItemGroup.add(ModItems.LESSER_AUSTRALIUM_NUGGET);
      ItemGroup.add(ModItems.GREATER_AUSTRALIUM_NUGGET);
      ItemGroup.add(ModItems.AUSTRALIUM_POWDER);
      
      ItemGroup.add(ModItems.BAKELITE_BAR);
      ItemGroup.add(ModItems.BAKELITE_POWDER);
      
      ItemGroup.add(ModItems.BERYLLIUM_INGOT);
      ItemGroup.add(ModItems.BERYLLIUM_BILLET);
      ItemGroup.add(ModItems.BERYLLIUM_NUGGET);
      ItemGroup.add(ModItems.BERYLLIUM_POWDER);
      ItemGroup.add(ModItems.BERYLLIUM_CRYSTALS);
      
      ItemGroup.add(ModItems.BISMUTH_INGOT);
      ItemGroup.add(ModItems.BISMUTH_BILLET);
      ItemGroup.add(ModItems.BISMUTH_ZFB_BILLET);
      ItemGroup.add(ModItems.BISMUTH_POWDER);
      ItemGroup.add(ModItems.BISMUTH_NUGGET);
      ItemGroup.add(ModItems.BISMUTH_BRONZE_INGOT);
      ItemGroup.add(ModItems.CAST_BISMUTH_BRONZE_PLATE);
      
      ItemGroup.add(ModItems.BORON_INGOT);
      ItemGroup.add(ModItems.BORON_POWDER);
      ItemGroup.add(ModItems.TINY_PILE_OF_BORON_POWDER);
      ItemGroup.add(ModItems.BORON_FRAGMENT);
      
      ItemGroup.add(ModItems.BORAX_INGOT);
      ItemGroup.add(ModItems.BORAX_POWDER);
      
      ItemGroup.add(ModItems.BSCCO_INGOT);
      ItemGroup.add(ModItems.DENSE_BSCCO_WIRE);
      
      ItemGroup.add(ModItems.CADMIUM_INGOT);
      ItemGroup.add(ModItems.CADMIUM_POWDER);
      
      ItemGroup.add(ModItems.CALCIUM_INGOT);
      ItemGroup.add(ModItems.CALCIUM_POWDER);
      
      ItemGroup.add(ModItems.CADMIUM_STEEL_INGOT);
      ItemGroup.add(ModItems.CAST_CADMIUM_STEEL_PLATE);
      ItemGroup.add(ModItems.WELDED_CADMIUM_STEEL_PLATE);
      
      ItemGroup.add(ModItems.CERIUM_POWDER);
      ItemGroup.add(ModItems.TINY_PILE_OF_CERIUM_POWDER);
      ItemGroup.add(ModItems.CERIUM_FRAGMENT);
      
      ItemGroup.add(ModItems.CHLOROCALCITE);
      
      ItemGroup.add(ModItems.CINNABAR);
      ItemGroup.add(ModItems.CINNABAR_CRYSTALS);
      
      ItemGroup.add(ModItems.CMB_STEEL_INGOT);
      ItemGroup.add(ModItems.CMB_STEEL_POWDER);
      ItemGroup.add(ModItems.CAST_CMB_STEEL_PLATE);
      ItemGroup.add(ModItems.WELDED_CMB_STEEL_PLATE);
      ItemGroup.add(ModItems.CMB_STEEL_PLATE);
      
      ItemGroup.add(ModItems.COAL_POWDER);
      ItemGroup.add(ModItems.TINY_PILE_OF_COAL_POWDER);
      ItemGroup.add(ModItems.CARBON_WIRE);
      
      ItemGroup.add(ModItems.COBALT_INGOT);
      ItemGroup.add(ModItems.COBALT_60_INGOT);
      ItemGroup.add(ModItems.COBALT_FRAGMENT);
      ItemGroup.add(ModItems.COBALT_CRYSTALS);
      
      ItemGroup.add(ModItems.COLTAN);
      ItemGroup.add(ModItems.CRUSHED_COLTAN);
      
      ItemGroup.add(ModItems.COPPER_POWDER);
      ItemGroup.add(ModItems.COPPER_PLATE);
      ItemGroup.add(ModItems.CAST_COPPER_PLATE);
      ItemGroup.add(ModItems.WELDED_COPPER_PLATE);
      ItemGroup.add(ModItems.COPPER_PIPE);
      ItemGroup.add(ModItems.COPPER_SHELL);
      ItemGroup.add(ModItems.COPPER_WIRE);
      ItemGroup.add(ModItems.DENSE_COPPER_WIRE);
      ItemGroup.add(ModItems.COPPER_CRYSTALS);
      
      ItemGroup.add(ModItems.CRYOLITE_CHUNK);
      
      ItemGroup.add(ModItems.DESH_INGOT);
      ItemGroup.add(ModItems.DESH_BLEND);
      ItemGroup.add(ModItems.DESHREADY_BLEND);
      ItemGroup.add(ModItems.DESH_POWDER);
      ItemGroup.add(ModItems.DESH_NUGGET);
      ItemGroup.add(ModItems.CAST_DESH_PLATE);
      
      ItemGroup.add(ModItems.DIAMOND_CRYSTALS);
      
      ItemGroup.add(ModItems.DINEUTRONIUM_INGOT);
      ItemGroup.add(ModItems.DINEUTRONIUM_POWDER);
      ItemGroup.add(ModItems.DINEUTRONIUM_NUGGET);
      ItemGroup.add(ModItems.DENSE_DINEUTRONIUM_NUGGET);
      
      ItemGroup.add(ModItems.ELECTRONIUM_INGOT);
      
      ItemGroup.add(ModItems.EUPHEMIUM_INGOT);
      ItemGroup.add(ModItems.EUPHEMIUM_POWDER);
      ItemGroup.add(ModItems.EUPHEMIUM_NUGGET);
      
      ItemGroup.add(ModItems.FERRIC_SCHARBIDATE_INGOT);
      ItemGroup.add(ModItems.FERRIC_SCHARBIDATE_POWDER);
      ItemGroup.add(ModItems.CAST_FERRIC_SCHARBIDATE_PLATE);
      ItemGroup.add(ModItems.DENSE_FERRIC_SCHARBIDATE_WIRE);
      
      ItemGroup.add(ModItems.FERROURANIUM_INGOT);
      ItemGroup.add(ModItems.CAST_FERROURANIUM_PLATE);
      
      ItemGroup.add(ModItems.FLUORITE);
      ItemGroup.add(ModItems.FLUORITE_CRYSTALS);
      
      ItemGroup.add(ModItems.GHIORSIUM_336_INGOT);
      ItemGroup.add(ModItems.GHIORSIUM_336_BILLET);
      ItemGroup.add(ModItems.GHIORSIUM_336_NUGGET);
      
      ItemGroup.add(ModItems.GOLD_POWDER);
      ItemGroup.add(ModItems.GOLD_PLATE);
      ItemGroup.add(ModItems.CAST_GOLD_PLATE);
      ItemGroup.add(ModItems.GOLD_WIRE);
      ItemGroup.add(ModItems.DENSE_GOLD_WIRE);
      ItemGroup.add(ModItems.GOLD_CRYSTALS);
      ItemGroup.add(ModItems.GOLD_198_INGOT);
      ItemGroup.add(ModItems.GOLD_198_BILLET);
      ItemGroup.add(ModItems.GOLD_198_POWDER);
      ItemGroup.add(ModItems.GOLD_198_NUGGET);
      
      ItemGroup.add(ModItems.GRAPHITE_INGOT);
      
      ItemGroup.add(ModItems.GUNMETAL_INGOT);
      ItemGroup.add(ModItems.GUNMETAL_PLATE);
      
      ItemGroup.add(ModItems.HARD_PLASTIC_BAR);
      
      ItemGroup.add(ModItems.HIGH_SPEED_STEEL_INGOT);
      ItemGroup.add(ModItems.HIGH_SPEED_STEEL_POWDER);
      ItemGroup.add(ModItems.CAST_HIGH_SPEED_STEEL_PLATE);
      ItemGroup.add(ModItems.HIGH_SPEED_STEEL_PLATE);
      ItemGroup.add(ModItems.HIGH_SPEED_STEEL_BOLT);
      ItemGroup.add(ModItems.HIGH_SPEED_STEEL_PIPE);
      
      ItemGroup.add(ModItems.IRON_POWDER);
      ItemGroup.add(ModItems.IRON_PLATE);
      ItemGroup.add(ModItems.CAST_IRON_PLATE);
      ItemGroup.add(ModItems.WELDED_IRON_PLATE);
      ItemGroup.add(ModItems.IRON_PIPE);
      ItemGroup.add(ModItems.IRON_CRYSTALS);
      
      ItemGroup.add(ModItems.INFERNAL_COAL);
      
      ItemGroup.add(ModItems.SEMI_STABLE_LANTHANUM_INGOT);
      ItemGroup.add(ModItems.LANTHANUM_FRAGMENT);
      
      ItemGroup.add(ModItems.LAPIS_CRYSTALS);
      
      ItemGroup.add(ModItems.LATEX);
      ItemGroup.add(ModItems.LATEX_BAR);
      
      ItemGroup.add(ModItems.LEAD_INGOT);
      ItemGroup.add(ModItems.LEAD_BILLET);
      ItemGroup.add(ModItems.LEAD_NUGGET);
      ItemGroup.add(ModItems.LEAD_209_INGOT);
      ItemGroup.add(ModItems.LEAD_209_BILLET);
      ItemGroup.add(ModItems.LEAD_209_NUGGET);
      ItemGroup.add(ModItems.LEAD_POWDER);
      ItemGroup.add(ModItems.LEAD_PLATE);
      ItemGroup.add(ModItems.CAST_LEAD_PLATE);
      ItemGroup.add(ModItems.LEAD_PIPE);
      ItemGroup.add(ModItems.LEAD_BOLT);
      ItemGroup.add(ModItems.LEAD_WIRE);
      ItemGroup.add(ModItems.LEAD_CRYSTALS);
      
      ItemGroup.add(ModItems.LIGNITE);
      ItemGroup.add(ModItems.LIGNITE_POWDER);
      ItemGroup.add(ModItems.LIGNITE_COKE);
      ItemGroup.add(ModItems.LIGNITE_BRIQUETTE);
      
      ItemGroup.add(ModItems.LITHIUM_CUBE);
      ItemGroup.add(ModItems.LITHIUM_POWDER);
      ItemGroup.add(ModItems.TINY_PILE_OF_LITHIUM_POWDER);
      ItemGroup.add(ModItems.LITHIUM_CRYSTALS);
      
      ItemGroup.add(ModItems.MAGNETIZED_TUNGSTEN_INGOT);
      ItemGroup.add(ModItems.MAGNETIZED_TUNGSTEN_POWDER);
      ItemGroup.add(ModItems.MAGNETIZED_TUNGSTEN_WIRE);
      ItemGroup.add(ModItems.DENSE_MAGNETIZED_TUNGSTEN_WIRE);
      
      ItemGroup.add(ModItems.METEORITE_INGOT);
      ItemGroup.add(ModItems.METEORITE_POWDER);
      ItemGroup.add(ModItems.TINY_PILE_OF_METEORITE_POWDER);
      ItemGroup.add(ModItems.METEORITE_FRAGMENT);
      
      ItemGroup.add(ModItems.MOLYSITE);
      
      ItemGroup.add(ModItems.MOX_FUEL_INGOT);
      ItemGroup.add(ModItems.MOX_FUEL_BILLET);
      ItemGroup.add(ModItems.MOX_FUEL_NUGGET);
      
      ItemGroup.add(ModItems.NEODYMIUM_INGOT);
      ItemGroup.add(ModItems.NEODYMIUM_POWDER);
      ItemGroup.add(ModItems.TINY_PILE_OF_NEODYMIUM_POWDER);
      ItemGroup.add(ModItems.DENSE_NEODYMIUM_WIRE);
      ItemGroup.add(ModItems.NEODYMIUM_FRAGMENT);
      
      ItemGroup.add(ModItems.NEPTUNIUM_CRYSTALS);
      ItemGroup.add(ModItems.NEPTUNIUM_INGOT);
      ItemGroup.add(ModItems.NEPTUNIUM_FUEL_INGOT);
      ItemGroup.add(ModItems.NEPTUNIUM_BILLET);
      ItemGroup.add(ModItems.NEPTUNIUM_FUEL_BILLET);
      ItemGroup.add(ModItems.NEPTUNIUM_NUGGET);
      ItemGroup.add(ModItems.NEPTUNIUM_FUEL_NUGGET);
      ItemGroup.add(ModItems.NEPTUNIUM_POWDER);
      
      ItemGroup.add(ModItems.NIOBIUM_INGOT);
      ItemGroup.add(ModItems.NIOBIUM_POWDER);
      ItemGroup.add(ModItems.TINY_PILE_OF_NIOBIUM_POWDER);
      ItemGroup.add(ModItems.NIOBIUM_NUGGET);
      ItemGroup.add(ModItems.DENSE_NIOBIUM_WIRE);
      ItemGroup.add(ModItems.NIOBIUM_FRAGMENT);
      
      ItemGroup.add(ModItems.NITER);
      ItemGroup.add(ModItems.NITER_CRYSTALS);
      
      ItemGroup.add(ModItems.OSMIRIDIUM_INGOT);
      ItemGroup.add(ModItems.OSMIRIDIUM_NUGGET);
      ItemGroup.add(ModItems.IMPURE_OSMIRIDIUM_POWDER);
      ItemGroup.add(ModItems.CAST_OSMIRIDIUM_PLATE);
      ItemGroup.add(ModItems.WELDED_OSMIRIDIUM_PLATE);
      ItemGroup.add(ModItems.OSMIRIDIUM_CRYSTALS);
      
      ItemGroup.add(ModItems.RED_PHOSPHORUS);
      ItemGroup.add(ModItems.WHITE_PHOSPHORUS_BAR);
      ItemGroup.add(ModItems.PHOSPHORUS_CRYSTALS);
      
      ItemGroup.add(ModItems.POLONIUM_210_INGOT);
      ItemGroup.add(ModItems.POLONIUM_210_BILLET);
      ItemGroup.add(ModItems.POLONIUM_210_NUGGET);
      ItemGroup.add(ModItems.POLONIUM_210_DUST);
      
      ItemGroup.add(ModItems.POLYMER_BAR);
      ItemGroup.add(ModItems.POLYMER_POWDER);
      
      ItemGroup.add(ModItems.PLUTONIUM_INGOT);
      ItemGroup.add(ModItems.PLUTONIUM_FUEL_INGOT);
      ItemGroup.add(ModItems.REACTOR_GRADE_PLUTONIUM_INGOT);
      ItemGroup.add(ModItems.PLUTONIUM_238_INGOT);
      ItemGroup.add(ModItems.PLUTONIUM_239_INGOT);
      ItemGroup.add(ModItems.PLUTONIUM_240_INGOT);
      ItemGroup.add(ModItems.PLUTONIUM_241_INGOT);
      ItemGroup.add(ModItems.PLUTONIUM_BILLET);
      ItemGroup.add(ModItems.PLUTONIUM_FUEL_BILLET);
      ItemGroup.add(ModItems.REACTOR_GRADE_PLUTONIUM_BILLET);
      ItemGroup.add(ModItems.PLUTONIUM_238_BILLET);
      ItemGroup.add(ModItems.PLUTONIUM_239_BILLET);
      ItemGroup.add(ModItems.PLUTONIUM_240_BILLET);
      ItemGroup.add(ModItems.PLUTONIUM_241_BILLET);
      ItemGroup.add(ModItems.PLUTONIUM_NUGGET);
      ItemGroup.add(ModItems.PLUTONIUM_FUEL_NUGGET);
      ItemGroup.add(ModItems.REACTOR_GRADE_PLUTONIUM_NUGGET);
      ItemGroup.add(ModItems.PLUTONIUM_238_NUGGET);
      ItemGroup.add(ModItems.PLUTONIUM_239_NUGGET);
      ItemGroup.add(ModItems.PLUTONIUM_240_NUGGET);
      ItemGroup.add(ModItems.PLUTONIUM_241_NUGGET);
      ItemGroup.add(ModItems.PLUTONIUM_POWDER);
      ItemGroup.add(ModItems.PLUTONIUM_CRYSTALS);
      
      ItemGroup.add(ModItems.PVC_BAR);
      
      ItemGroup.add(ModItems.RADIUM_226_INGOT);
      ItemGroup.add(ModItems.RADIUM_226_BILLET);
      ItemGroup.add(ModItems.RADIUM_226_POWDER);
      ItemGroup.add(ModItems.RADIUM_226_NUGGET);
      
      ItemGroup.add(ModItems.RARE_EARTH_ORE_CHUNK);
      ItemGroup.add(ModItems.RARE_EARTH_CRYSTALS);
      
      ItemGroup.add(ModItems.RED_COPPER_INGOT);
      ItemGroup.add(ModItems.RED_COPPER_POWDER);
      ItemGroup.add(ModItems.RED_COPPER_WIRE);
      
      ItemGroup.add(ModItems.REDSTONE_CRYSTALS);
      
      ItemGroup.add(ModItems.RUBBER_BAR);
      ItemGroup.add(ModItems.RUBBER_PIPE);
      
      ItemGroup.add(ModItems.SATURNITE_INGOT);
      ItemGroup.add(ModItems.SATURNITE_PLATE);
      ItemGroup.add(ModItems.CAST_SATURNITE_PLATE);
      ItemGroup.add(ModItems.SATURNITE_SHELL);
      
      ItemGroup.add(ModItems.SCHRABIDIUM_INGOT);
      ItemGroup.add(ModItems.SCHRABIDIUM_FUEL_INGOT);
      ItemGroup.add(ModItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT);
      ItemGroup.add(ModItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT);
      ItemGroup.add(ModItems.SCHRABIDIUM_BILLET);
      ItemGroup.add(ModItems.SCHRABIDIUM_FUEL_BILLET);
      ItemGroup.add(ModItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_BILLET);
      ItemGroup.add(ModItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_BILLET);
      ItemGroup.add(ModItems.SCHRABIDIUM_NUGGET);
      ItemGroup.add(ModItems.SCHRABIDIUM_FUEL_NUGGET);
      ItemGroup.add(ModItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_NUGGET);
      ItemGroup.add(ModItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_NUGGET);
      ItemGroup.add(ModItems.SCHRABIDIUM_POWDER);
      ItemGroup.add(ModItems.SCHRABIDIUM_PLATE);
      ItemGroup.add(ModItems.CAST_SCHRABIDIUM_PLATE);
      ItemGroup.add(ModItems.SCHRABIDIUM_WIRE);
      ItemGroup.add(ModItems.DENSE_SCHRABIDIUM_WIRE);
      ItemGroup.add(ModItems.SCHRABIDIUM_CRYSTALS);
      
      ItemGroup.add(ModItems.SCHRARANIUM_INGOT);
      ItemGroup.add(ModItems.SCHRARANIUM_CRYSTALS);
      
      ItemGroup.add(ModItems.SILICON_BOULE);
      ItemGroup.add(ModItems.SILICON_WAFER);
      ItemGroup.add(ModItems.PRINTED_SILICON_WAFER);
      ItemGroup.add(ModItems.SILICON_NUGGET);
      
      ItemGroup.add(ModItems.SOLINIUM_INGOT);
      ItemGroup.add(ModItems.SOLINIUM_BILLET);
      ItemGroup.add(ModItems.SOLINIUM_NUGGET);
      
      ItemGroup.add(ModItems.STARMETAL_INGOT);
      ItemGroup.add(ModItems.DENSE_STARMETAL_WIRE);
      ItemGroup.add(ModItems.STARMETAL_RING);
      ItemGroup.add(ModItems.STARMETAL_CRYSTALS);
      
      ItemGroup.add(ModItems.STRONTIUM_INGOT);
      ItemGroup.add(ModItems.STRONTIUM_POWDER);
      ItemGroup.add(ModItems.STRONTIUM_90_INGOT);
      ItemGroup.add(ModItems.STRONTIUM_90_BILLET);
      ItemGroup.add(ModItems.STRONTIUM_90_POWDER);
      ItemGroup.add(ModItems.TINY_PILE_OF_STRONTIUM_90_POWDER);
      ItemGroup.add(ModItems.STRONTIUM_90_NUGGET);
      
      ItemGroup.add(ModItems.STEEL_INGOT);
      ItemGroup.add(ModItems.STEEL_POWDER);
      ItemGroup.add(ModItems.TINY_PILE_OF_STEEL_POWDER);
      ItemGroup.add(ModItems.STEEL_PLATE);
      ItemGroup.add(ModItems.CAST_STEEL_PLATE);
      ItemGroup.add(ModItems.WELDED_STEEL_PLATE);
      ItemGroup.add(ModItems.STEEL_BOLT);
      ItemGroup.add(ModItems.STEEL_PIPE);
      ItemGroup.add(ModItems.STEEL_SHELL);
      ItemGroup.add(ModItems.STEEL_WIRE);
      
      ItemGroup.add(ModItems.SULFUR);
      ItemGroup.add(ModItems.SULFUR_CRYSTALS);
      
      ItemGroup.add(ModItems.PURIFIED_TANTALITE);
      ItemGroup.add(ModItems.TANTALUM_INGOT);
      ItemGroup.add(ModItems.TANTALUM_POWDER);
      ItemGroup.add(ModItems.TANTALUM_NUGGET);
      ItemGroup.add(ModItems.TANTALUM_POLYCRYSTAL);
      
      ItemGroup.add(ModItems.TECHNETIUM_99_INGOT);
      ItemGroup.add(ModItems.TECHNETIUM_99_BILLET);
      ItemGroup.add(ModItems.TECHNETIUM_99_NUGGET);
      
      ItemGroup.add(ModItems.TECHNETIUM_STEEL_INGOT);
      ItemGroup.add(ModItems.TECHNETIUM_STEEL_POWDER);
      ItemGroup.add(ModItems.CAST_TECHNETIUM_STEEL_PLATE);
      ItemGroup.add(ModItems.WELDED_TECHNETIUM_STEEL_PLATE);
      
      ItemGroup.add(ModItems.THORIUM_232_INGOT);
      ItemGroup.add(ModItems.THORIUM_FUEL_INGOT);
      ItemGroup.add(ModItems.THORIUM_232_BILLET);
      ItemGroup.add(ModItems.THORIUM_FUEL_BILLET);
      ItemGroup.add(ModItems.THORIUM_232_NUGGET);
      ItemGroup.add(ModItems.THORIUM_FUEL_NUGGET);
      ItemGroup.add(ModItems.THORIUM_POWDER);
      ItemGroup.add(ModItems.THORIUM_CRYSTALS);
      
      ItemGroup.add(ModItems.TITANIUM_INGOT);
      ItemGroup.add(ModItems.TITANIUM_PLATE);
      ItemGroup.add(ModItems.CAST_TITANIUM_PLATE);
      ItemGroup.add(ModItems.WELDED_TITANIUM_PLATE);
      ItemGroup.add(ModItems.TITANIUM_BILLET);
      ItemGroup.add(ModItems.TITANIUM_NUGGET);
      ItemGroup.add(ModItems.TITANIUM_POWDER);
      ItemGroup.add(ModItems.TITANIUM_SHELL);
      ItemGroup.add(ModItems.DENSE_TITANIUM_WIRE);
      ItemGroup.add(ModItems.TITANIUM_CRYSTALS);
      
      ItemGroup.add(ModItems.TRIXITE_CRYSTALS);
      
      ItemGroup.add(ModItems.TUNGSTEN_INGOT);
      ItemGroup.add(ModItems.TUNGSTEN_BILLET);
      ItemGroup.add(ModItems.TUNGSTEN_NUGGET);
      ItemGroup.add(ModItems.TUNGSTEN_POWDER);
      ItemGroup.add(ModItems.TUNGSTEN_BOLT);
      ItemGroup.add(ModItems.TUNGSTEN_WIRE);
      ItemGroup.add(ModItems.DENSE_TUNGSTEN_WIRE);
      ItemGroup.add(ModItems.TUNGSTEN_CRYSTALS);
      
      ItemGroup.add(ModItems.URANIUM_INGOT);
      ItemGroup.add(ModItems.URANIUM_FUEL_INGOT);
      ItemGroup.add(ModItems.URANIUM_233_INGOT);
      ItemGroup.add(ModItems.URANIUM_235_INGOT);
      ItemGroup.add(ModItems.URANIUM_238_INGOT);
      ItemGroup.add(ModItems.URANIUM_BILLET);
      ItemGroup.add(ModItems.URANIUM_FUEL_BILLET);
      ItemGroup.add(ModItems.URANIUM_233_BILLET);
      ItemGroup.add(ModItems.URANIUM_235_BILLET);
      ItemGroup.add(ModItems.URANIUM_238_BILLET);
      ItemGroup.add(ModItems.URANIUM_NUGGET);
      ItemGroup.add(ModItems.URANIUM_FUEL_NUGGET);
      ItemGroup.add(ModItems.URANIUM_233_NUGGET);
      ItemGroup.add(ModItems.URANIUM_235_NUGGET);
      ItemGroup.add(ModItems.URANIUM_238_NUGGET);
      ItemGroup.add(ModItems.URANIUM_POWDER);
      ItemGroup.add(ModItems.URANIUM_CRYSTALS);
      
      ItemGroup.add(ModItems.VOLCANIC_GEM);
      
      ItemGroup.add(ModItems.WEAPON_STEEL_INGOT);
      ItemGroup.add(ModItems.WEAPON_STEEL_PLATE);
      ItemGroup.add(ModItems.CAST_WEAPON_STEEL_PLATE);
      ItemGroup.add(ModItems.WEAPON_STEEL_SHELL);
      
      ItemGroup.add(ModItems.ZIRCONIUM_SPLINTER);
      ItemGroup.add(ModItems.ZIRCONIUM_CUBE);
      ItemGroup.add(ModItems.ZIRCONIUM_BILLET);
      ItemGroup.add(ModItems.ZIRCONIUM_POWDER);
      ItemGroup.add(ModItems.CAST_ZIRCONIUM_PLATE);
      ItemGroup.add(ModItems.WELDED_ZIRCONIUM_PLATE);
      ItemGroup.add(ModItems.ZIRCONIUM_WIRE);
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
      ItemGroup.add(ModBlocks.ALUMINIUM_BEARING_ORE);
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
      ItemGroup.add(ModBlocks.TRIXITE_ORE);
      ItemGroup.add(ModBlocks.GEOTHERMAL_VENT);
      ItemGroup.add(ModBlocks.BEDROCK_OIL_DEPOSIT);
      ItemGroup.add(ModBlocks.BEDROCK_ORE);
      ItemGroup.add(ModItems.RAW_URANIUM);
      ItemGroup.add(ModItems.RAW_SCORCHED_URANIUM);
      ItemGroup.add(ModItems.RAW_PLUTONIUM);
      ItemGroup.add(ModItems.RAW_THORIUM);
      ItemGroup.add(ModItems.RAW_TITANIUM);
      ItemGroup.add(ModItems.RAW_TUNGSTEN);
      ItemGroup.add(ModItems.RAW_CRYOLITE);
      ItemGroup.add(ModItems.RAW_BERYLLIUM);
      ItemGroup.add(ModItems.RAW_LEAD);
      ItemGroup.add(ModItems.RAW_SCHRABIDIUM);
      ItemGroup.add(ModItems.RAW_AUSTRALIUM);
      ItemGroup.add(ModItems.RAW_METEORIC_IRON);
      ItemGroup.add(ModItems.RAW_METEORIC_COPPER);
      ItemGroup.add(ModItems.RAW_METEORIC_ALUMINIUM);
      ItemGroup.add(ModItems.RAW_METEORIC_RARE_EARTH);
      ItemGroup.add(ModItems.RAW_METEORIC_COBALT);
      ItemGroup.add(ModItems.RAW_TRIXITE);
      ItemGroup.add(ModItems.RAW_OSMIRIDIUM);
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
      ItemGroup.add(ModItems.EMPTY_BOTTLE);
      ItemGroup.add(ModItems.EMPTY_BOMB_BOTTLE);
      ItemGroup.add(ModItems.NUKA_COLA_BOTTLE_CAP);
      ItemGroup.add(ModItems.NUKA_COLA_QUANTUM_BOTTLE_CAP);
      ItemGroup.add(ModItems.S_COLA_BOTTLE_CAP);
      ItemGroup.add(ModItems.S_COLA_RAD_BOTTLE_CAP);
      ItemGroup.add(ModItems.KAROL_BOTTLE_CAP);
      ItemGroup.add(ModItems.FRITZ_COLA_BOTTLE_CAP);
      ItemGroup.add(ModItems.BOTTLE_OF_NUKA_COLA);
      ItemGroup.add(ModItems.BOTTLE_OF_NUKA_CHERRY);
      ItemGroup.add(ModItems.BOTTLE_OF_NUKA_COLA_QUANTUM);
      ItemGroup.add(ModItems.BOTTLE_OF_S_COLA);
      ItemGroup.add(ModItems.BOTTLE_OF_S_COLA_RAD);
      ItemGroup.add(ModItems.BOTTLE_OF_KAROL);
      ItemGroup.add(ModItems.FIRST_BOTTLE_OF_KAROL);
      ItemGroup.add(ModItems.BOTTLE_OF_FRITZ_COLA);
      ItemGroup.add(ModItems.FIRST_BOTTLE_OF_FRITZ_COLA);
      ItemGroup.add(ModItems.BOTTLE_OPENER);
      ItemGroup.add(ModItems.CONSTRUCTION_WAND);
      ItemGroup.add(ModItems.DEBUG_WAND);
      ItemGroup.add(ModItems.NETWORK_DEBUG_TOOL);
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
      ItemGroup.add(ModItems.DESH_SWORD);
      ItemGroup.add(ModItems.DESH_PICKAXE);
      ItemGroup.add(ModItems.DESH_AXE);
      ItemGroup.add(ModItems.DESH_SHOVEL);
      ItemGroup.add(ModItems.DESH_HOE);
      ItemGroup.add(ModItems.SCHRABIDIUM_SWORD);
      ItemGroup.add(ModItems.SCHRABIDIUM_PICKAXE);
      ItemGroup.add(ModItems.SCHRABIDIUM_AXE);
      ItemGroup.add(ModItems.SCHRABIDIUM_SHOVEL);
      ItemGroup.add(ModItems.SCHRABIDIUM_HOE);
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
