package net.fawnoculus.ntm.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;


public class NTMItemGroups {

    public static final ResourceKey<CreativeModeTab> RESOURCES_AND_PARTS_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), NTM.id("resources_and_parts"));
    public static final CreativeModeTab RESOURCES_AND_PARTS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(NTMItems.URANIUM_INGOT))
      .title(Component.translatable("itemGroup.ntm.resources_and_parts"))
      .build();
    public static final ResourceKey<CreativeModeTab> MACHINE_ITEMS_AND_FUEL_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), NTM.id("machine_items_and_fuel"));
    public static final CreativeModeTab MACHINE_ITEMS_AND_FUEL = FabricItemGroup.builder()
      .icon(() -> new ItemStack(NTMItems.PLUTONIUM_238_RTG_PELLET))
      .title(Component.translatable("itemGroup.ntm.machine_items_and_fuel"))
      .build();
    public static final ResourceKey<CreativeModeTab> TEMPLATES_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), NTM.id("templates"));
    public static final CreativeModeTab TEMPLATES = FabricItemGroup.builder()
      .icon(() -> new ItemStack(NTMItems.NULL))
      .title(Component.translatable("itemGroup.ntm.templates"))
      .build();
    public static final ResourceKey<CreativeModeTab> ORES_AND_BLOCKS_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), NTM.id("ores_and_blocks"));
    public static final CreativeModeTab ORES_AND_BLOCKS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(NTMBlocks.URANIUM_ORE))
      .title(Component.translatable("itemGroup.ntm.ores_and_blocks"))
      .build();
    public static final ResourceKey<CreativeModeTab> MACHINES_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), NTM.id("machines"));
    public static final CreativeModeTab MACHINES = FabricItemGroup.builder()
      .icon(() -> new ItemStack(NTMBlocks.PWR_CONTROLLER))
      .title(Component.translatable("itemGroup.ntm.machines"))
      .build();
    public static final ResourceKey<CreativeModeTab> BOMBS_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), NTM.id("bombs"));
    public static final CreativeModeTab BOMBS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(NTMItems.NULL))
      .backgroundTexture(NTM.id("textures/gui/creative_inventory/tab_nuke.png"))
      .title(Component.translatable("itemGroup.ntm.bombs"))
      .build();
    public static final ResourceKey<CreativeModeTab> MISSILES_AND_SATELLITES_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), NTM.id("missiles_and_satellites"));
    public static final CreativeModeTab MISSILES_AND_SATELLITES = FabricItemGroup.builder()
      .icon(() -> new ItemStack(NTMItems.NULL))
      .title(Component.translatable("itemGroup.ntm.missiles_and_satellites"))
      .build();
    public static final ResourceKey<CreativeModeTab> WEAPONS_AND_TURRETS_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), NTM.id("weapons_and_turrets"));
    public static final CreativeModeTab WEAPONS_AND_TURRETS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(NTMItems.NULL))
      .title(Component.translatable("itemGroup.ntm.weapons_and_turrets"))
      .build();
    public static final ResourceKey<CreativeModeTab> CONSUMABLES_AND_GEAR_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), NTM.id("consumables_and_gear"));
    public static final CreativeModeTab CONSUMABLES_AND_GEAR = FabricItemGroup.builder()
      .icon(() -> new ItemStack(NTMItems.BOTTLE_OF_NUKA_COLA))
      .title(Component.translatable("itemGroup.ntm.consumables_and_gear"))
      .build();
    public static final ResourceKey<CreativeModeTab> TOOLS_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), NTM.id("tools"));
    public static final CreativeModeTab TOOLS = FabricItemGroup.builder()
      .icon(() -> new ItemStack(NTMItems.ADVANCED_ALLOY_PICKAXE))
      .title(Component.translatable("itemGroup.ntm.tools"))
      .build();

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, RESOURCES_AND_PARTS_KEY, RESOURCES_AND_PARTS);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MACHINE_ITEMS_AND_FUEL_KEY, MACHINE_ITEMS_AND_FUEL);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TEMPLATES_KEY, TEMPLATES);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ORES_AND_BLOCKS_KEY, ORES_AND_BLOCKS);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MACHINES_KEY, MACHINES);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BOMBS_KEY, BOMBS);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MISSILES_AND_SATELLITES_KEY, MISSILES_AND_SATELLITES);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, WEAPONS_AND_TURRETS_KEY, WEAPONS_AND_TURRETS);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CONSUMABLES_AND_GEAR_KEY, CONSUMABLES_AND_GEAR);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TOOLS_KEY, TOOLS);

        ItemGroupEvents.modifyEntriesEvent(RESOURCES_AND_PARTS_KEY).register(ItemGroup -> {
            ItemGroup.accept(NTMItems.ACTINIUM_227_INGOT);
            ItemGroup.accept(NTMItems.ACTINIUM_227_BILLET);
            ItemGroup.accept(NTMItems.ACTINIUM_227_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_ACTINIUM_227_POWDER);
            ItemGroup.accept(NTMItems.ACTINIUM_227_NUGGET);
            ItemGroup.accept(NTMItems.ACTINIUM_227_FRAGMENT);

            ItemGroup.accept(NTMItems.ADVANCED_ALLOY_INGOT);
            ItemGroup.accept(NTMItems.ADVANCED_ALLOY_POWDER);
            ItemGroup.accept(NTMItems.ADVANCED_ALLOY_PLATE);
            ItemGroup.accept(NTMItems.CAST_ADVANCED_ALLOY_PLATE);
            ItemGroup.accept(NTMItems.ADVANCED_ALLOY_WIRE);
            ItemGroup.accept(NTMItems.DENSE_ADVANCED_ALLOY_WIRE);

            ItemGroup.accept(NTMItems.ALEXANDRITE);

            ItemGroup.accept(NTMItems.ALUMINIUM_INGOT);
            ItemGroup.accept(NTMItems.ALUMINIUM_POWDER);
            ItemGroup.accept(NTMItems.ALUMINIUM_PLATE);
            ItemGroup.accept(NTMItems.CAST_ALUMINIUM_PLATE);
            ItemGroup.accept(NTMItems.WELDED_ALUMINIUM_PLATE);
            ItemGroup.accept(NTMItems.ALUMINIUM_SHELL);
            ItemGroup.accept(NTMItems.ALUMINIUM_PIPE);
            ItemGroup.accept(NTMItems.ALUMINIUM_WIRE);
            ItemGroup.accept(NTMItems.ALUMINIUM_CRYSTALS);

            ItemGroup.accept(NTMItems.AMERICIUM_241_INGOT);
            ItemGroup.accept(NTMItems.AMERICIUM_241_BILLET);
            ItemGroup.accept(NTMItems.AMERICIUM_241_NUGGET);
            ItemGroup.accept(NTMItems.AMERICIUM_242_INGOT);
            ItemGroup.accept(NTMItems.AMERICIUM_242_BILLET);
            ItemGroup.accept(NTMItems.AMERICIUM_242_NUGGET);
            ItemGroup.accept(NTMItems.AMERICIUM_FUEL_INGOT);
            ItemGroup.accept(NTMItems.AMERICIUM_FUEL_BILLET);
            ItemGroup.accept(NTMItems.AMERICIUM_FUEL_NUGGET);
            ItemGroup.accept(NTMItems.REACTOR_GRADE_AMERICIUM_INGOT);
            ItemGroup.accept(NTMItems.REACTOR_GRADE_AMERICIUM_BILLET);
            ItemGroup.accept(NTMItems.REACTOR_GRADE_AMERICIUM_ZFB_BILLET);
            ItemGroup.accept(NTMItems.REACTOR_GRADE_AMERICIUM_NUGGET);

            ItemGroup.accept(NTMItems.ARSENIC_INGOT);
            ItemGroup.accept(NTMItems.ARSENIC_NUGGET);
            ItemGroup.accept(NTMItems.ARSENIC_BRONZE_INGOT);
            ItemGroup.accept(NTMItems.CAST_ARSENIC_BRONZE_PLATE);

            ItemGroup.accept(NTMItems.ASBESTOS_SHEET);
            ItemGroup.accept(NTMItems.ASBESTOS_POWDER);

            ItemGroup.accept(NTMItems.ASH);
            ItemGroup.accept(NTMItems.WOOD_ASH);
            ItemGroup.accept(NTMItems.COAL_ASH);
            ItemGroup.accept(NTMItems.FLY_ASH);
            ItemGroup.accept(NTMItems.FINE_SOOT);

            ItemGroup.accept(NTMItems.AUSTRALIUM_INGOT);
            ItemGroup.accept(NTMItems.AUSTRALIUM_BILLET);
            ItemGroup.accept(NTMItems.AUSTRALIUM_NUGGET);
            ItemGroup.accept(NTMItems.LESSER_AUSTRALIUM_BILLET);
            ItemGroup.accept(NTMItems.LESSER_AUSTRALIUM_NUGGET);
            ItemGroup.accept(NTMItems.GREATER_AUSTRALIUM_BILLET);
            ItemGroup.accept(NTMItems.GREATER_AUSTRALIUM_NUGGET);
            ItemGroup.accept(NTMItems.AUSTRALIUM_POWDER);

            ItemGroup.accept(NTMItems.BAKELITE_BAR);
            ItemGroup.accept(NTMItems.BAKELITE_POWDER);

            ItemGroup.accept(NTMItems.BALEFIRE_EGG);
            ItemGroup.accept(NTMItems.BALEFIRE_SHARD);
            ItemGroup.accept(NTMItems.THERMONUCLEAR_ASHES);

            ItemGroup.accept(NTMItems.BERYLLIUM_INGOT);
            ItemGroup.accept(NTMItems.BERYLLIUM_BILLET);
            ItemGroup.accept(NTMItems.BERYLLIUM_NUGGET);
            ItemGroup.accept(NTMItems.BERYLLIUM_POWDER);
            ItemGroup.accept(NTMItems.BERYLLIUM_CRYSTALS);

            ItemGroup.accept(NTMItems.BISMUTH_INGOT);
            ItemGroup.accept(NTMItems.BISMUTH_BILLET);
            ItemGroup.accept(NTMItems.BISMUTH_ZFB_BILLET);
            ItemGroup.accept(NTMItems.BISMUTH_POWDER);
            ItemGroup.accept(NTMItems.BISMUTH_NUGGET);
            ItemGroup.accept(NTMItems.BISMUTH_BRONZE_INGOT);
            ItemGroup.accept(NTMItems.CAST_BISMUTH_BRONZE_PLATE);

            ItemGroup.accept(NTMItems.BORAX_POWDER);

            ItemGroup.accept(NTMItems.BORON_INGOT);
            ItemGroup.accept(NTMItems.BORON_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_BORON_POWDER);
            ItemGroup.accept(NTMItems.BORON_FRAGMENT);

            ItemGroup.accept(NTMItems.BROMINE_POWDER);

            ItemGroup.accept(NTMItems.BSCCO_INGOT);
            ItemGroup.accept(NTMItems.DENSE_BSCCO_WIRE);

            ItemGroup.accept(NTMItems.CADMIUM_INGOT);
            ItemGroup.accept(NTMItems.CADMIUM_POWDER);

            ItemGroup.accept(NTMItems.CAESIUM_POWDER);
            ItemGroup.accept(NTMItems.CAESIUM_137_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_CAESIUM_137_POWDER);

            ItemGroup.accept(NTMItems.CALCIUM_INGOT);
            ItemGroup.accept(NTMItems.CALCIUM_POWDER);

            ItemGroup.accept(NTMItems.CADMIUM_STEEL_INGOT);
            ItemGroup.accept(NTMItems.CAST_CADMIUM_STEEL_PLATE);
            ItemGroup.accept(NTMItems.WELDED_CADMIUM_STEEL_PLATE);

            ItemGroup.accept(NTMItems.CEMENT);

            ItemGroup.accept(NTMItems.CERIUM_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_CERIUM_POWDER);
            ItemGroup.accept(NTMItems.CERIUM_FRAGMENT);

            ItemGroup.accept(NTMItems.CHLOROCALCITE);

            ItemGroup.accept(NTMItems.CHLOROPHYTE_POWDER);

            ItemGroup.accept(NTMItems.CINNABAR);
            ItemGroup.accept(NTMItems.CINNABAR_CRYSTALS);

            ItemGroup.accept(NTMItems.CMB_STEEL_INGOT);
            ItemGroup.accept(NTMItems.CMB_STEEL_POWDER);
            ItemGroup.accept(NTMItems.CAST_CMB_STEEL_PLATE);
            ItemGroup.accept(NTMItems.WELDED_CMB_STEEL_PLATE);
            ItemGroup.accept(NTMItems.CMB_STEEL_PLATE);

            ItemGroup.accept(NTMItems.COAL_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_COAL_POWDER);
            ItemGroup.accept(NTMItems.CARBON_WIRE);
            ItemGroup.accept(NTMItems.COAL_BRIQUETTE);
            ItemGroup.accept(NTMItems.COAL_COKE);

            ItemGroup.accept(NTMItems.COBALT_INGOT);
            ItemGroup.accept(NTMItems.COBALT_BILLET);
            ItemGroup.accept(NTMItems.COBALT_POWDER);
            ItemGroup.accept(NTMItems.COBALT_NUGGET);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_COBALT_POWDER);
            ItemGroup.accept(NTMItems.COBALT_60_INGOT);
            ItemGroup.accept(NTMItems.COBALT_60_BILLET);
            ItemGroup.accept(NTMItems.COBALT_60_POWDER);
            ItemGroup.accept(NTMItems.COBALT_60_NUGGET);
            ItemGroup.accept(NTMItems.COBALT_FRAGMENT);
            ItemGroup.accept(NTMItems.COBALT_CRYSTALS);

            ItemGroup.accept(NTMItems.COLTAN);
            ItemGroup.accept(NTMItems.CRUSHED_COLTAN);

            ItemGroup.accept(NTMItems.COPPER_POWDER);
            ItemGroup.accept(NTMItems.COPPER_PLATE);
            ItemGroup.accept(NTMItems.CAST_COPPER_PLATE);
            ItemGroup.accept(NTMItems.WELDED_COPPER_PLATE);
            ItemGroup.accept(NTMItems.COPPER_PIPE);
            ItemGroup.accept(NTMItems.COPPER_SHELL);
            ItemGroup.accept(NTMItems.COPPER_WIRE);
            ItemGroup.accept(NTMItems.DENSE_COPPER_WIRE);
            ItemGroup.accept(NTMItems.COPPER_CRYSTALS);

            ItemGroup.accept(NTMItems.CRYO_POWDER);

            ItemGroup.accept(NTMItems.CRYOLITE_CHUNK);

            ItemGroup.accept(NTMItems.DESH_INGOT);
            ItemGroup.accept(NTMItems.DESH_BLEND);
            ItemGroup.accept(NTMItems.DESHREADY_BLEND);
            ItemGroup.accept(NTMItems.DESH_POWDER);
            ItemGroup.accept(NTMItems.DESH_NUGGET);
            ItemGroup.accept(NTMItems.CAST_DESH_PLATE);

            ItemGroup.accept(NTMItems.DIAMOND_POWDER);
            ItemGroup.accept(NTMItems.DIAMOND_CRYSTALS);

            ItemGroup.accept(NTMItems.DINEUTRONIUM_INGOT);
            ItemGroup.accept(NTMItems.DINEUTRONIUM_POWDER);
            ItemGroup.accept(NTMItems.DINEUTRONIUM_NUGGET);
            ItemGroup.accept(NTMItems.DENSE_DINEUTRONIUM_WIRE);

            ItemGroup.accept(NTMItems.ELECTRONIUM_INGOT);

            ItemGroup.accept(NTMItems.EMERALD_POWDER);

            ItemGroup.accept(NTMItems.ENERGY_POWDER);

            ItemGroup.accept(NTMItems.EUPHEMIUM_INGOT);
            ItemGroup.accept(NTMItems.EUPHEMIUM_POWDER);
            ItemGroup.accept(NTMItems.EUPHEMIUM_NUGGET);

            ItemGroup.accept(NTMItems.FERRIC_SCHARBIDATE_INGOT);
            ItemGroup.accept(NTMItems.FERRIC_SCHARBIDATE_POWDER);
            ItemGroup.accept(NTMItems.CAST_FERRIC_SCHARBIDATE_PLATE);
            ItemGroup.accept(NTMItems.DENSE_FERRIC_SCHARBIDATE_WIRE);

            ItemGroup.accept(NTMItems.FERROURANIUM_INGOT);
            ItemGroup.accept(NTMItems.CAST_FERROURANIUM_PLATE);

            ItemGroup.accept(NTMItems.FLASH_GOLD);

            ItemGroup.accept(NTMItems.FLASH_LEAD);

            ItemGroup.accept(NTMItems.FLUORITE);
            ItemGroup.accept(NTMItems.FLUORITE_CRYSTALS);

            ItemGroup.accept(NTMItems.FLUX);

            ItemGroup.accept(NTMItems.FULLERENE);
            ItemGroup.accept(NTMItems.CRYSTALLINE_FULLERENE);

            ItemGroup.accept(NTMItems.GHIORSIUM_336_INGOT);
            ItemGroup.accept(NTMItems.GHIORSIUM_336_BILLET);
            ItemGroup.accept(NTMItems.GHIORSIUM_336_NUGGET);

            ItemGroup.accept(NTMItems.GOLD_POWDER);
            ItemGroup.accept(NTMItems.GOLD_PLATE);
            ItemGroup.accept(NTMItems.CAST_GOLD_PLATE);
            ItemGroup.accept(NTMItems.GOLD_WIRE);
            ItemGroup.accept(NTMItems.DENSE_GOLD_WIRE);
            ItemGroup.accept(NTMItems.GOLD_CRYSTALS);
            ItemGroup.accept(NTMItems.GOLD_198_INGOT);
            ItemGroup.accept(NTMItems.GOLD_198_BILLET);
            ItemGroup.accept(NTMItems.GOLD_198_POWDER);
            ItemGroup.accept(NTMItems.GOLD_198_NUGGET);

            ItemGroup.accept(NTMItems.GRAPHITE_INGOT);

            ItemGroup.accept(NTMItems.GUNMETAL_INGOT);
            ItemGroup.accept(NTMItems.GUNMETAL_PLATE);

            ItemGroup.accept(NTMItems.HARD_PLASTIC_BAR);

            ItemGroup.accept(NTMItems.HIGH_SPEED_STEEL_INGOT);
            ItemGroup.accept(NTMItems.HIGH_SPEED_STEEL_POWDER);
            ItemGroup.accept(NTMItems.CAST_HIGH_SPEED_STEEL_PLATE);
            ItemGroup.accept(NTMItems.HIGH_SPEED_STEEL_PLATE);
            ItemGroup.accept(NTMItems.HIGH_SPEED_STEEL_BOLT);
            ItemGroup.accept(NTMItems.HIGH_SPEED_STEEL_PIPE);

            ItemGroup.accept(NTMItems.IODINE_POWDER);
            ItemGroup.accept(NTMItems.IODINE_131_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_IODINE_131_POWDER);

            ItemGroup.accept(NTMItems.IRON_POWDER);
            ItemGroup.accept(NTMItems.IRON_PLATE);
            ItemGroup.accept(NTMItems.CAST_IRON_PLATE);
            ItemGroup.accept(NTMItems.WELDED_IRON_PLATE);
            ItemGroup.accept(NTMItems.IRON_PIPE);
            ItemGroup.accept(NTMItems.IRON_CRYSTALS);

            ItemGroup.accept(NTMItems.INDUSTRIAL_FERTILIZER);

            ItemGroup.accept(NTMItems.INFERNAL_COAL);

            ItemGroup.accept(NTMItems.SEMI_STABLE_LANTHANUM_INGOT);
            ItemGroup.accept(NTMItems.LANTHANUM_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_LANTHANUM_POWDER);
            ItemGroup.accept(NTMItems.LANTHANUM_FRAGMENT);

            ItemGroup.accept(NTMItems.LAPIS_POWDER);
            ItemGroup.accept(NTMItems.LAPIS_CRYSTALS);

            ItemGroup.accept(NTMItems.LATEX);
            ItemGroup.accept(NTMItems.LATEX_BAR);

            ItemGroup.accept(NTMItems.LEAD_INGOT);
            ItemGroup.accept(NTMItems.LEAD_NUGGET);
            ItemGroup.accept(NTMItems.LEAD_209_INGOT);
            ItemGroup.accept(NTMItems.LEAD_209_BILLET);
            ItemGroup.accept(NTMItems.LEAD_209_NUGGET);
            ItemGroup.accept(NTMItems.LEAD_POWDER);
            ItemGroup.accept(NTMItems.LEAD_PLATE);
            ItemGroup.accept(NTMItems.CAST_LEAD_PLATE);
            ItemGroup.accept(NTMItems.LEAD_PIPE);
            ItemGroup.accept(NTMItems.LEAD_BOLT);
            ItemGroup.accept(NTMItems.LEAD_WIRE);
            ItemGroup.accept(NTMItems.LEAD_CRYSTALS);

            ItemGroup.accept(NTMItems.LIGNITE);
            ItemGroup.accept(NTMItems.LIGNITE_POWDER);
            ItemGroup.accept(NTMItems.LIGNITE_COKE);
            ItemGroup.accept(NTMItems.LIGNITE_BRIQUETTE);

            ItemGroup.accept(NTMItems.LIMESTONE_POWDER);

            ItemGroup.accept(NTMItems.LITHIUM_CUBE);
            ItemGroup.accept(NTMItems.LITHIUM_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_LITHIUM_POWDER);
            ItemGroup.accept(NTMItems.LITHIUM_CRYSTALS);

            ItemGroup.accept(NTMItems.MAGNETIZED_TUNGSTEN_INGOT);
            ItemGroup.accept(NTMItems.MAGNETIZED_TUNGSTEN_POWDER);
            ItemGroup.accept(NTMItems.MAGNETIZED_TUNGSTEN_WIRE);
            ItemGroup.accept(NTMItems.DENSE_MAGNETIZED_TUNGSTEN_WIRE);

            ItemGroup.accept(NTMItems.METEORITE_INGOT);
            ItemGroup.accept(NTMItems.METEORITE_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_METEORITE_POWDER);
            ItemGroup.accept(NTMItems.METEORITE_FRAGMENT);

            ItemGroup.accept(NTMItems.MOLYSITE);

            ItemGroup.accept(NTMItems.MOX_FUEL_INGOT);
            ItemGroup.accept(NTMItems.MOX_FUEL_BILLET);
            ItemGroup.accept(NTMItems.MOX_FUEL_NUGGET);

            ItemGroup.accept(NTMItems.NEODYMIUM_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_NEODYMIUM_POWDER);
            ItemGroup.accept(NTMItems.DENSE_NEODYMIUM_WIRE);
            ItemGroup.accept(NTMItems.NEODYMIUM_FRAGMENT);

            ItemGroup.accept(NTMItems.NEPTUNIUM_INGOT);
            ItemGroup.accept(NTMItems.NEPTUNIUM_BILLET);
            ItemGroup.accept(NTMItems.NEPTUNIUM_POWDER);
            ItemGroup.accept(NTMItems.NEPTUNIUM_NUGGET);
            ItemGroup.accept(NTMItems.NEPTUNIUM_FUEL_INGOT);
            ItemGroup.accept(NTMItems.NEPTUNIUM_FUEL_BILLET);
            ItemGroup.accept(NTMItems.NEPTUNIUM_FUEL_NUGGET);

            ItemGroup.accept(NTMItems.NIOBIUM_INGOT);
            ItemGroup.accept(NTMItems.NIOBIUM_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_NIOBIUM_POWDER);
            ItemGroup.accept(NTMItems.NIOBIUM_NUGGET);
            ItemGroup.accept(NTMItems.DENSE_NIOBIUM_WIRE);
            ItemGroup.accept(NTMItems.NIOBIUM_FRAGMENT);

            ItemGroup.accept(NTMItems.NITAN_BLEND);

            ItemGroup.accept(NTMItems.NITER);
            ItemGroup.accept(NTMItems.NITER_CRYSTALS);

            ItemGroup.accept(NTMItems.NITRA);
            ItemGroup.accept(NTMItems.SMALL_PILE_OF_NITRA);

            ItemGroup.accept(NTMItems.OSMIRIDIUM_INGOT);
            ItemGroup.accept(NTMItems.OSMIRIDIUM_NUGGET);
            ItemGroup.accept(NTMItems.IMPURE_OSMIRIDIUM_POWDER);
            ItemGroup.accept(NTMItems.CAST_OSMIRIDIUM_PLATE);
            ItemGroup.accept(NTMItems.WELDED_OSMIRIDIUM_PLATE);
            ItemGroup.accept(NTMItems.OSMIRIDIUM_CRYSTALS);

            ItemGroup.accept(NTMItems.PALEOGENITE_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_PALEOGENITE_POWDER);

            ItemGroup.accept(NTMItems.RED_PHOSPHORUS);
            ItemGroup.accept(NTMItems.WHITE_PHOSPHORUS_BAR);
            ItemGroup.accept(NTMItems.PHOSPHORUS_CRYSTALS);

            ItemGroup.accept(NTMItems.PETROLEUM_COKE);

            ItemGroup.accept(NTMItems.PLUTONIUM_INGOT);
            ItemGroup.accept(NTMItems.PLUTONIUM_BILLET);
            ItemGroup.accept(NTMItems.PLUTONIUM_NUGGET);
            ItemGroup.accept(NTMItems.PLUTONIUM_FUEL_INGOT);
            ItemGroup.accept(NTMItems.PLUTONIUM_FUEL_BILLET);
            ItemGroup.accept(NTMItems.PLUTONIUM_FUEL_NUGGET);
            ItemGroup.accept(NTMItems.REACTOR_GRADE_PLUTONIUM_INGOT);
            ItemGroup.accept(NTMItems.REACTOR_GRADE_PLUTONIUM_BILLET);
            ItemGroup.accept(NTMItems.REACTOR_GRADE_PLUTONIUM_NUGGET);
            ItemGroup.accept(NTMItems.PLUTONIUM_238_INGOT);
            ItemGroup.accept(NTMItems.PLUTONIUM_238_BILLET);
            ItemGroup.accept(NTMItems.PLUTONIUM_238_BE_BILLET);
            ItemGroup.accept(NTMItems.PLUTONIUM_238_NUGGET);
            ItemGroup.accept(NTMItems.PLUTONIUM_239_INGOT);
            ItemGroup.accept(NTMItems.PLUTONIUM_239_BILLET);
            ItemGroup.accept(NTMItems.PLUTONIUM_239_NUGGET);
            ItemGroup.accept(NTMItems.PLUTONIUM_240_INGOT);
            ItemGroup.accept(NTMItems.PLUTONIUM_240_BILLET);
            ItemGroup.accept(NTMItems.PLUTONIUM_240_NUGGET);
            ItemGroup.accept(NTMItems.PLUTONIUM_241_INGOT);
            ItemGroup.accept(NTMItems.PLUTONIUM_241_BILLET);
            ItemGroup.accept(NTMItems.PLUTONIUM_241_ZFB_BILLET);
            ItemGroup.accept(NTMItems.PLUTONIUM_241_NUGGET);
            ItemGroup.accept(NTMItems.PLUTONIUM_POWDER);
            ItemGroup.accept(NTMItems.PLUTONIUM_CRYSTALS);

            ItemGroup.accept(NTMItems.POISON_POWDER);

            ItemGroup.accept(NTMItems.POLONIUM_210_INGOT);
            ItemGroup.accept(NTMItems.POLONIUM_210_BILLET);
            ItemGroup.accept(NTMItems.POLONIUM_210_BE_BILLET);
            ItemGroup.accept(NTMItems.POLONIUM_210_NUGGET);
            ItemGroup.accept(NTMItems.POLONIUM_210_POWDER);

            ItemGroup.accept(NTMItems.POLYMER_BAR);
            ItemGroup.accept(NTMItems.POLYMER_POWDER);

            ItemGroup.accept(NTMItems.PULVERIZED_ENCHANTMENT);

            ItemGroup.accept(NTMItems.PVC_BAR);

            ItemGroup.accept(NTMItems.QUARTZ_POWDER);

            ItemGroup.accept(NTMItems.RADIUM_226_INGOT);
            ItemGroup.accept(NTMItems.RADIUM_226_BILLET);
            ItemGroup.accept(NTMItems.RADIUM_226_BE_BILLET);
            ItemGroup.accept(NTMItems.RADIUM_226_POWDER);
            ItemGroup.accept(NTMItems.RADIUM_226_NUGGET);

            ItemGroup.accept(NTMItems.RARE_EARTH_ORE_CHUNK);
            ItemGroup.accept(NTMItems.RARE_EARTH_CRYSTALS);

            ItemGroup.accept(NTMItems.RED_COPPER_INGOT);
            ItemGroup.accept(NTMItems.RED_COPPER_POWDER);
            ItemGroup.accept(NTMItems.RED_COPPER_WIRE);

            ItemGroup.accept(NTMItems.REDSTONE_CRYSTALS);

            ItemGroup.accept(NTMItems.RUBBER_BAR);
            ItemGroup.accept(NTMItems.RUBBER_PIPE);

            ItemGroup.accept(NTMItems.SATURNITE_INGOT);
            ItemGroup.accept(NTMItems.SATURNITE_PLATE);
            ItemGroup.accept(NTMItems.CAST_SATURNITE_PLATE);
            ItemGroup.accept(NTMItems.SATURNITE_SHELL);

            ItemGroup.accept(NTMItems.SAWDUST_POWDER);
            ItemGroup.accept(NTMItems.SAWDUST_BRIQUETTE);

            ItemGroup.accept(NTMItems.SCHRABIDIUM_INGOT);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_BILLET);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_NUGGET);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_FUEL_INGOT);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_FUEL_BILLET);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_FUEL_NUGGET);
            ItemGroup.accept(NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT);
            ItemGroup.accept(NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_BILLET);
            ItemGroup.accept(NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_NUGGET);
            ItemGroup.accept(NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT);
            ItemGroup.accept(NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_BILLET);
            ItemGroup.accept(NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_NUGGET);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_POWDER);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_PLATE);
            ItemGroup.accept(NTMItems.CAST_SCHRABIDIUM_PLATE);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_WIRE);
            ItemGroup.accept(NTMItems.DENSE_SCHRABIDIUM_WIRE);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_CRYSTALS);

            ItemGroup.accept(NTMItems.SCHRARANIUM_INGOT);
            ItemGroup.accept(NTMItems.SCHRARANIUM_CRYSTALS);

            ItemGroup.accept(NTMItems.SEMTEX_BLEND);
            ItemGroup.accept(NTMItems.SEMTEX_BAR);

            ItemGroup.accept(NTMItems.SILICON_BOULE);
            ItemGroup.accept(NTMItems.SILICON_WAFER);
            ItemGroup.accept(NTMItems.PRINTED_SILICON_WAFER);
            ItemGroup.accept(NTMItems.SILICON_NUGGET);

            ItemGroup.accept(NTMItems.SODIUM_POWDER);

            ItemGroup.accept(NTMItems.SOLINIUM_INGOT);
            ItemGroup.accept(NTMItems.SOLINIUM_BILLET);
            ItemGroup.accept(NTMItems.SOLINIUM_NUGGET);

            ItemGroup.accept(NTMItems.SPARK_BLEND);

            ItemGroup.accept(NTMItems.STARMETAL_INGOT);
            ItemGroup.accept(NTMItems.DENSE_STARMETAL_WIRE);
            ItemGroup.accept(NTMItems.STARMETAL_RING);
            ItemGroup.accept(NTMItems.STARMETAL_CRYSTALS);

            ItemGroup.accept(NTMItems.STRONTIUM_POWDER);
            ItemGroup.accept(NTMItems.STRONTIUM_90_INGOT);
            ItemGroup.accept(NTMItems.STRONTIUM_90_BILLET);
            ItemGroup.accept(NTMItems.STRONTIUM_90_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_STRONTIUM_90_POWDER);
            ItemGroup.accept(NTMItems.STRONTIUM_90_NUGGET);

            ItemGroup.accept(NTMItems.STEEL_INGOT);
            ItemGroup.accept(NTMItems.STEEL_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_STEEL_POWDER);
            ItemGroup.accept(NTMItems.STEEL_PLATE);
            ItemGroup.accept(NTMItems.CAST_STEEL_PLATE);
            ItemGroup.accept(NTMItems.WELDED_STEEL_PLATE);
            ItemGroup.accept(NTMItems.STEEL_BOLT);
            ItemGroup.accept(NTMItems.STEEL_PIPE);
            ItemGroup.accept(NTMItems.STEEL_SHELL);
            ItemGroup.accept(NTMItems.STEEL_WIRE);

            ItemGroup.accept(NTMItems.SULFUR);
            ItemGroup.accept(NTMItems.SULFUR_CRYSTALS);

            ItemGroup.accept(NTMItems.PURIFIED_TANTALITE);
            ItemGroup.accept(NTMItems.TANTALUM_INGOT);
            ItemGroup.accept(NTMItems.TANTALUM_POWDER);
            ItemGroup.accept(NTMItems.TANTALUM_NUGGET);
            ItemGroup.accept(NTMItems.TANTALUM_POLYCRYSTAL);

            ItemGroup.accept(NTMItems.TECHNETIUM_99_INGOT);
            ItemGroup.accept(NTMItems.TECHNETIUM_99_BILLET);
            ItemGroup.accept(NTMItems.TECHNETIUM_99_NUGGET);

            ItemGroup.accept(NTMItems.TECHNETIUM_STEEL_INGOT);
            ItemGroup.accept(NTMItems.TECHNETIUM_STEEL_POWDER);
            ItemGroup.accept(NTMItems.CAST_TECHNETIUM_STEEL_PLATE);
            ItemGroup.accept(NTMItems.WELDED_TECHNETIUM_STEEL_PLATE);

            ItemGroup.accept(NTMItems.TEKTITE_POWDER);

            ItemGroup.accept(NTMItems.TENNESSINE_POWDER);

            ItemGroup.accept(NTMItems.THERMITE);

            ItemGroup.accept(NTMItems.THORIUM_232_INGOT);
            ItemGroup.accept(NTMItems.THORIUM_FUEL_INGOT);
            ItemGroup.accept(NTMItems.THORIUM_232_BILLET);
            ItemGroup.accept(NTMItems.THORIUM_FUEL_BILLET);
            ItemGroup.accept(NTMItems.THORIUM_232_NUGGET);
            ItemGroup.accept(NTMItems.THORIUM_FUEL_NUGGET);
            ItemGroup.accept(NTMItems.THORIUM_POWDER);
            ItemGroup.accept(NTMItems.THORIUM_CRYSTALS);

            ItemGroup.accept(NTMItems.TITANIUM_INGOT);
            ItemGroup.accept(NTMItems.TITANIUM_PLATE);
            ItemGroup.accept(NTMItems.CAST_TITANIUM_PLATE);
            ItemGroup.accept(NTMItems.WELDED_TITANIUM_PLATE);
            ItemGroup.accept(NTMItems.TITANIUM_POWDER);
            ItemGroup.accept(NTMItems.TITANIUM_SHELL);
            ItemGroup.accept(NTMItems.DENSE_TITANIUM_WIRE);
            ItemGroup.accept(NTMItems.TITANIUM_CRYSTALS);

            ItemGroup.accept(NTMItems.TRIXITE_CRYSTALS);

            ItemGroup.accept(NTMItems.TUNGSTEN_INGOT);
            ItemGroup.accept(NTMItems.TUNGSTEN_POWDER);
            ItemGroup.accept(NTMItems.TUNGSTEN_BOLT);
            ItemGroup.accept(NTMItems.TUNGSTEN_WIRE);
            ItemGroup.accept(NTMItems.DENSE_TUNGSTEN_WIRE);
            ItemGroup.accept(NTMItems.TUNGSTEN_CRYSTALS);

            ItemGroup.accept(NTMItems.URANIUM_INGOT);
            ItemGroup.accept(NTMItems.URANIUM_BILLET);
            ItemGroup.accept(NTMItems.URANIUM_NUGGET);
            ItemGroup.accept(NTMItems.URANIUM_FUEL_INGOT);
            ItemGroup.accept(NTMItems.URANIUM_FUEL_BILLET);
            ItemGroup.accept(NTMItems.URANIUM_FUEL_NUGGET);
            ItemGroup.accept(NTMItems.URANIUM_233_INGOT);
            ItemGroup.accept(NTMItems.URANIUM_233_BILLET);
            ItemGroup.accept(NTMItems.URANIUM_233_NUGGET);
            ItemGroup.accept(NTMItems.URANIUM_235_INGOT);
            ItemGroup.accept(NTMItems.URANIUM_235_BILLET);
            ItemGroup.accept(NTMItems.URANIUM_235_NUGGET);
            ItemGroup.accept(NTMItems.URANIUM_238_INGOT);
            ItemGroup.accept(NTMItems.URANIUM_238_BILLET);
            ItemGroup.accept(NTMItems.URANIUM_238_NUGGET);
            ItemGroup.accept(NTMItems.URANIUM_POWDER);
            ItemGroup.accept(NTMItems.URANIUM_CRYSTALS);

            ItemGroup.accept(NTMItems.VOLCANIC_GEM);

            ItemGroup.accept(NTMItems.WEAPON_STEEL_INGOT);
            ItemGroup.accept(NTMItems.WEAPON_STEEL_PLATE);
            ItemGroup.accept(NTMItems.CAST_WEAPON_STEEL_PLATE);
            ItemGroup.accept(NTMItems.WEAPON_STEEL_SHELL);

            ItemGroup.accept(NTMItems.XENON_135_POWDER);
            ItemGroup.accept(NTMItems.TINY_PILE_OF_XENON_135_POWDER);

            ItemGroup.accept(NTMItems.YHARONITE_BILLET);

            ItemGroup.accept(NTMItems.YELLOWCAKE);

            ItemGroup.accept(NTMItems.ZIRCONIUM_SPLINTER);
            ItemGroup.accept(NTMItems.ZIRCONIUM_CUBE);
            ItemGroup.accept(NTMItems.ZIRCONIUM_BILLET);
            ItemGroup.accept(NTMItems.ZIRCONIUM_POWDER);
            ItemGroup.accept(NTMItems.CAST_ZIRCONIUM_PLATE);
            ItemGroup.accept(NTMItems.WELDED_ZIRCONIUM_PLATE);
            ItemGroup.accept(NTMItems.ZIRCONIUM_WIRE);
        });
        ItemGroupEvents.modifyEntriesEvent(MACHINE_ITEMS_AND_FUEL_KEY).register(ItemGroup -> {
            ItemGroup.accept(NTMItems.BATTERY);
            ItemGroup.accept(charged(NTMItems.BATTERY, 5_000L));
            ItemGroup.accept(NTMItems.REDSTONE_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.REDSTONE_POWER_CELL, 15_000L));
            ItemGroup.accept(NTMItems.SIXFOLD_REDSTONE_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.SIXFOLD_REDSTONE_POWER_CELL, 90_000L));
            ItemGroup.accept(NTMItems.TWENTY_FOUR_FOLD_REDSTONE_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.TWENTY_FOUR_FOLD_REDSTONE_POWER_CELL, 360_000L));
            ItemGroup.accept(NTMItems.ADVANCED_BATTERY);
            ItemGroup.accept(charged(NTMItems.ADVANCED_BATTERY, 20_000L));
            ItemGroup.accept(NTMItems.ADVANCED_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.ADVANCED_POWER_CELL, 60_000L));
            ItemGroup.accept(NTMItems.QUADRUPLE_ADVANCED_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.QUADRUPLE_ADVANCED_POWER_CELL, 240_000L));
            ItemGroup.accept(NTMItems.TWELVEFOLD_ADVANCED_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.TWELVEFOLD_ADVANCED_POWER_CELL, 720_000L));
            ItemGroup.accept(NTMItems.LITHIUM_ION_BATTERY);
            ItemGroup.accept(charged(NTMItems.LITHIUM_ION_BATTERY, 250_000L));
            ItemGroup.accept(NTMItems.LITHIUM_ION_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.LITHIUM_ION_POWER_CELL, 750_000L));
            ItemGroup.accept(NTMItems.TRIPLE_LITHIUM_ION_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.TRIPLE_LITHIUM_ION_POWER_CELL, 2_250_000L));
            ItemGroup.accept(NTMItems.SIXFOLD_LITHIUM_ION_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.SIXFOLD_LITHIUM_ION_POWER_CELL, 4_500_000L));
            ItemGroup.accept(NTMItems.SCHRABIDIUM_BATTERY);
            ItemGroup.accept(charged(NTMItems.SCHRABIDIUM_BATTERY, 1_000_000L));
            ItemGroup.accept(NTMItems.SCHRABIDIUM_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.SCHRABIDIUM_POWER_CELL, 3_000_000L));
            ItemGroup.accept(NTMItems.DOUBLE_SCHRABIDIUM_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.DOUBLE_SCHRABIDIUM_POWER_CELL, 6_000_000L));
            ItemGroup.accept(NTMItems.QUADRUPLE_SCHRABIDIUM_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.QUADRUPLE_SCHRABIDIUM_POWER_CELL, 12_000_000L));
            ItemGroup.accept(NTMItems.SPARK_BATTERY);
            ItemGroup.accept(charged(NTMItems.SPARK_BATTERY, 100_000_000L));
            ItemGroup.accept(NTMItems.OFF_BRAND_SPARK_BATTERY);
            ItemGroup.accept(charged(NTMItems.OFF_BRAND_SPARK_BATTERY, 5_000_000L));
            ItemGroup.accept(NTMItems.SPARK_POWER_CELL);
            ItemGroup.accept(charged(NTMItems.SPARK_POWER_CELL, 600_000_000L));
            ItemGroup.accept(NTMItems.SPARK_ARCANE_CAR_BATTERY);
            ItemGroup.accept(charged(NTMItems.SPARK_ARCANE_CAR_BATTERY, 2_500_000_000L));
            ItemGroup.accept(NTMItems.SPARK_ARCANE_ENERGY_STORAGE_ARRAY);
            ItemGroup.accept(charged(NTMItems.SPARK_ARCANE_ENERGY_STORAGE_ARRAY, 10_000_000_000L));
            ItemGroup.accept(NTMItems.SPARK_ARCANE_MASS_ENERGY_VOID);
            ItemGroup.accept(charged(NTMItems.SPARK_ARCANE_MASS_ENERGY_VOID, 100_000_000_000L));
            ItemGroup.accept(NTMItems.SPARK_ARCANE_DIRAC_SEA);
            ItemGroup.accept(charged(NTMItems.SPARK_ARCANE_DIRAC_SEA, 250_000_000_000L));
            ItemGroup.accept(NTMItems.SPARK_SOLID_SPACE_TIME_CRYSTAL);
            ItemGroup.accept(charged(NTMItems.SPARK_SOLID_SPACE_TIME_CRYSTAL, 1_000_000_000_000L));
            ItemGroup.accept(NTMItems.SPARK_LUDICROUS_ENERGY_STORAGE_UNIT);
            ItemGroup.accept(charged(NTMItems.SPARK_LUDICROUS_ENERGY_STORAGE_UNIT, 100_000_000_000_000L));
            ItemGroup.accept(NTMItems.ELECTRONIUM_CUBE);
            ItemGroup.accept(charged(NTMItems.ELECTRONIUM_CUBE, 1_000_000_000_000_000_000L));
            ItemGroup.accept(NTMItems.INFINITE_BATTERY);
            ItemGroup.accept(NTMItems.POTATO_BATTERY);
            ItemGroup.accept(NTMItems.POTATOS);
            ItemGroup.accept(NTMItems.SELF_CHARGING_URANIUM_238_BATTERY);
            ItemGroup.accept(NTMItems.SELF_CHARGING_TECHNETIUM_99_BATTERY);
            ItemGroup.accept(NTMItems.SELF_CHARGING_PLUTONIUM_238_BATTERY);
            ItemGroup.accept(NTMItems.SELF_CHARGING_POLONIUM_210_BATTERY);
            ItemGroup.accept(NTMItems.SELF_CHARGING_GOLD_198_BATTERY);
            ItemGroup.accept(NTMItems.SELF_CHARGING_LEAD_209_BATTERY);
            ItemGroup.accept(NTMItems.SELF_CHARGING_AMERICIUM_241_BATTERY);
        });
        ItemGroupEvents.modifyEntriesEvent(TEMPLATES_KEY).register(ItemGroup -> {
            ItemGroup.accept(NTMItems.NULL);
            ItemGroup.accept(NTMItems.NULL);
        });
        ItemGroupEvents.modifyEntriesEvent(ORES_AND_BLOCKS_KEY).register(ItemGroup -> {
            ItemGroup.accept(NTMBlocks.URANIUM_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_URANIUM_ORE);
            ItemGroup.accept(NTMBlocks.SCORCHED_URANIUM_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE);
            ItemGroup.accept(NTMBlocks.TITANIUM_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_TITANIUM_ORE);
            ItemGroup.accept(NTMBlocks.SULFUR_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_SULFUR_ORE);
            ItemGroup.accept(NTMBlocks.THORIUM_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_THORIUM_ORE);
            ItemGroup.accept(NTMBlocks.NITER_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_NITER_ORE);
            ItemGroup.accept(NTMBlocks.TUNGSTEN_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE);
            ItemGroup.accept(NTMBlocks.ALUMINIUM_BEARING_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE);
            ItemGroup.accept(NTMBlocks.FLUORITE_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_FLUORITE_ORE);
            ItemGroup.accept(NTMBlocks.LEAD_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_LEAD_ORE);
            ItemGroup.accept(NTMBlocks.SCHRABIDIUM_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE);
            ItemGroup.accept(NTMBlocks.BERYLLIUM_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE);
            ItemGroup.accept(NTMBlocks.AUSTRALIUM_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE);
            ItemGroup.accept(NTMBlocks.RARE_EARTH_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE);
            ItemGroup.accept(NTMBlocks.COBALT_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_COBALT_ORE);
            ItemGroup.accept(NTMBlocks.CINNEBAR_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_CINNEBAR_ORE);
            ItemGroup.accept(NTMBlocks.COLTAN_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_COLTAN_ORE);
            ItemGroup.accept(NTMBlocks.LIGNITE_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_LIGNITE_ORE);
            ItemGroup.accept(NTMBlocks.ASBESTOS_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_ASBESTOS_ORE);
            ItemGroup.accept(NTMBlocks.OIL_DEPOSIT);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_OIL_DEPOSIT);
            ItemGroup.accept(NTMBlocks.EMPTY_OIL_DEPOSIT);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_EMPTY_OIL_DEPOSIT);
            ItemGroup.accept(NTMBlocks.ALUMINIUM_ORE_CLUSTER);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_ALUMINIUM_ORE_CLUSTER);
            ItemGroup.accept(NTMBlocks.COPPER_ORE_CLUSTER);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_COPPER_ORE_CLUSTER);
            ItemGroup.accept(NTMBlocks.IRON_ORE_CLUSTER);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_IRON_ORE_CLUSTER);
            ItemGroup.accept(NTMBlocks.TITANIUM_ORE_CLUSTER);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_TITANIUM_ORE_CLUSTER);
            ItemGroup.accept(NTMBlocks.DEAD_DIRT);
            ItemGroup.accept(NTMBlocks.OILY_DIRT);
            ItemGroup.accept(NTMBlocks.OILY_SAND);
            ItemGroup.accept(NTMBlocks.DEPTH_ROCK);
            ItemGroup.accept(NTMBlocks.DEPTH_CINNABAR_ORE);
            ItemGroup.accept(NTMBlocks.DEPTH_ZIRCONIUM_ORE);
            ItemGroup.accept(NTMBlocks.DEPTH_BORAX_ORE);
            ItemGroup.accept(NTMBlocks.DEPTH_IRON_ORE_CLUSTER);
            ItemGroup.accept(NTMBlocks.DEPTH_TITANIUM_ORE_CLUSTER);
            ItemGroup.accept(NTMBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER);
            ItemGroup.accept(NTMBlocks.ALEXANDRITE_ORE);
            ItemGroup.accept(NTMBlocks.DEEPSLATE_ALEXANDRITE_ORE);
            ItemGroup.accept(NTMBlocks.VOLCANIC_BASALT);
            ItemGroup.accept(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT);
            ItemGroup.accept(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT);
            ItemGroup.accept(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT);
            ItemGroup.accept(NTMBlocks.GEM_RICH_VOLCANIC_BASALT);
            ItemGroup.accept(NTMBlocks.MOLYSITE_RICH_VOLCANIC_BASALT);
            ItemGroup.accept(NTMBlocks.SMOLDERING_NETHERRACK);
            ItemGroup.accept(NTMBlocks.NETHER_COAL_ORE);
            ItemGroup.accept(NTMBlocks.NETHER_URANIUM_ORE);
            ItemGroup.accept(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE);
            ItemGroup.accept(NTMBlocks.NETHER_PLUTONIUM_ORE);
            ItemGroup.accept(NTMBlocks.NETHER_TUNGSTEN_ORE);
            ItemGroup.accept(NTMBlocks.NETHER_SULFUR_ORE);
            ItemGroup.accept(NTMBlocks.NETHER_COBALT_ORE);
            ItemGroup.accept(NTMBlocks.NETHER_SCHRABIDIUM_ORE);
            ItemGroup.accept(NTMBlocks.NETHER_DEPTH_ROCK);
            ItemGroup.accept(NTMBlocks.NETHER_DEPTH_NEODYMIUM_ORE);
            ItemGroup.accept(NTMBlocks.METEORITE_BLOCK);
            ItemGroup.accept(NTMBlocks.BROKEN_METEORITE_BLOCK);
            ItemGroup.accept(NTMBlocks.METEORITE_COBBLESTONE);
            ItemGroup.accept(NTMBlocks.HOT_METEORITE_COBBLESTONE);
            ItemGroup.accept(NTMBlocks.METEORITE_TREASURE_BLOCK);
            ItemGroup.accept(NTMBlocks.METEOR_IRON_ORE);
            ItemGroup.accept(NTMBlocks.METEOR_COPPER_ORE);
            ItemGroup.accept(NTMBlocks.METEOR_ALUMINIUM_ORE);
            ItemGroup.accept(NTMBlocks.METEOR_RARE_EARTH_ORE);
            ItemGroup.accept(NTMBlocks.METEOR_COBALT_ORE);
            ItemGroup.accept(NTMBlocks.GRAPHITIC_SCHIST);
            ItemGroup.accept(NTMBlocks.SCHIST_IRON_ORE);
            ItemGroup.accept(NTMBlocks.SCHIST_GOLD_ORE);
            ItemGroup.accept(NTMBlocks.SCHIST_URANIUM_ORE);
            ItemGroup.accept(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE);
            ItemGroup.accept(NTMBlocks.SCHIST_COPPER_ORE);
            ItemGroup.accept(NTMBlocks.SCHIST_ASBESTOS_ORE);
            ItemGroup.accept(NTMBlocks.SCHIST_LITHIUM_ORE);
            ItemGroup.accept(NTMBlocks.SCHIST_SCHRABIDIUM_ORE);
            ItemGroup.accept(NTMBlocks.SCHIST_RARE_EARTH_ORE);
            ItemGroup.accept(NTMBlocks.GAS_SHALE);
            ItemGroup.accept(NTMBlocks.BAUXITE);
            ItemGroup.accept(NTMBlocks.CHRYSOTILE);
            ItemGroup.accept(NTMBlocks.HEMATITE);
            ItemGroup.accept(NTMBlocks.LIMESTONE);
            ItemGroup.accept(NTMBlocks.MALACHITE);
            ItemGroup.accept(NTMBlocks.SULFUROUS_STONE);
            ItemGroup.accept(NTMBlocks.TEKTITE);
            ItemGroup.accept(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE);
            ItemGroup.accept(NTMBlocks.TRIXITE_ORE);
            ItemGroup.accept(NTMBlocks.GEOTHERMAL_VENT);
            ItemGroup.accept(NTMBlocks.BEDROCK_OIL_DEPOSIT);
            ItemGroup.accept(NTMBlocks.BEDROCK_ORE);
            ItemGroup.accept(NTMItems.RAW_URANIUM);
            ItemGroup.accept(NTMItems.RAW_SCORCHED_URANIUM);
            ItemGroup.accept(NTMItems.RAW_PLUTONIUM);
            ItemGroup.accept(NTMItems.RAW_THORIUM);
            ItemGroup.accept(NTMItems.RAW_TITANIUM);
            ItemGroup.accept(NTMItems.RAW_TUNGSTEN);
            ItemGroup.accept(NTMItems.RAW_CRYOLITE);
            ItemGroup.accept(NTMItems.RAW_BERYLLIUM);
            ItemGroup.accept(NTMItems.RAW_LEAD);
            ItemGroup.accept(NTMItems.RAW_SCHRABIDIUM);
            ItemGroup.accept(NTMItems.RAW_AUSTRALIUM);
            ItemGroup.accept(NTMItems.RAW_METEORIC_IRON);
            ItemGroup.accept(NTMItems.RAW_METEORIC_COPPER);
            ItemGroup.accept(NTMItems.RAW_METEORIC_ALUMINIUM);
            ItemGroup.accept(NTMItems.RAW_METEORIC_RARE_EARTH);
            ItemGroup.accept(NTMItems.RAW_METEORIC_COBALT);
            ItemGroup.accept(NTMItems.RAW_TRIXITE);
            ItemGroup.accept(NTMItems.RAW_OSMIRIDIUM_INFUSED_TEKTITE);

            ItemGroup.accept(NTMBlocks.ACTINIUM_227_BLOCK);
            ItemGroup.accept(NTMBlocks.ADVANCED_ALLOY_BLOCK);
            ItemGroup.accept(NTMBlocks.ALUMINIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.ASBESTOS_BLOCK);
            ItemGroup.accept(NTMBlocks.AUSTRALIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.BAKELITE_BLOCK);
            ItemGroup.accept(NTMBlocks.BERYLLIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.BISMUTH_BLOCK);
            ItemGroup.accept(NTMBlocks.BORON_BLOCK);
            ItemGroup.accept(NTMBlocks.CADMIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.CADMIUM_STEEL_BLOCK);
            ItemGroup.accept(NTMBlocks.CMB_STEEL_BLOCK);
            ItemGroup.accept(NTMBlocks.COAL_COKE_BLOCK);
            ItemGroup.accept(NTMBlocks.COBALT_BLOCK);
            ItemGroup.accept(NTMBlocks.COLTAN_BLOCK);
            ItemGroup.accept(NTMBlocks.DESH_BLOCK);
            ItemGroup.accept(NTMBlocks.DINEUTRONIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.EUPHEMIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.FERRIC_SCHRABIDATE_BLOCK);
            ItemGroup.accept(NTMBlocks.FLUORITE_BLOCK);
            ItemGroup.accept(NTMBlocks.GRAPHITE_BLOCK);
            ItemGroup.accept(NTMBlocks.HIGH_SPEED_STEEL_BLOCK);
            ItemGroup.accept(NTMBlocks.LIGNITE_COKE_BLOCK);
            ItemGroup.accept(NTMBlocks.LEAD_BLOCK);
            ItemGroup.accept(NTMBlocks.LITHIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.MAGNETIZED_TUNGSTEN_BLOCK);
            ItemGroup.accept(NTMBlocks.MOX_FUEL_BLOCK);
            ItemGroup.accept(NTMBlocks.NEPTUNIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.NIOBIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.NITER_BLOCK);
            ItemGroup.accept(NTMBlocks.PETROLEUM_COKE_BLOCK);
            ItemGroup.accept(NTMBlocks.PLUTONIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.PLUTONIUM_FUEL_BLOCK);
            ItemGroup.accept(NTMBlocks.REACTOR_GRADE_PLUTONIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.PLUTONIUM_238_BLOCK);
            ItemGroup.accept(NTMBlocks.PLUTONIUM_239_BLOCK);
            ItemGroup.accept(NTMBlocks.PLUTONIUM_240_BLOCK);
            ItemGroup.accept(NTMBlocks.PLUTONIUM_241_BLOCK);
            ItemGroup.accept(NTMBlocks.POLONIUM_210_BLOCK);
            ItemGroup.accept(NTMBlocks.POLYMER_BLOCK);
            ItemGroup.accept(NTMBlocks.RADIUM_226_BLOCK);
            ItemGroup.accept(NTMBlocks.RED_COPPER_BLOCK);
            ItemGroup.accept(NTMBlocks.RED_PHOSPHORUS_BLOCK);
            ItemGroup.accept(NTMBlocks.RUBBER_BLOCK);
            ItemGroup.accept(NTMBlocks.SCHRABIDIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.SCHRABIDIUM_FUEL_BLOCK);
            ItemGroup.accept(NTMBlocks.SCHRARANIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.SEMTEX_BLOCK);
            ItemGroup.accept(NTMBlocks.SOLINIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.STARMETAL_BLOCK);
            ItemGroup.accept(NTMBlocks.STEEL_BLOCK);
            ItemGroup.accept(NTMBlocks.SULFUR_BLOCK);
            ItemGroup.accept(NTMBlocks.TANTALUM_BLOCK);
            ItemGroup.accept(NTMBlocks.TECHNETIUM_STEEL_BLOCK);
            ItemGroup.accept(NTMBlocks.THORIUM_232_BLOCK);
            ItemGroup.accept(NTMBlocks.THORIUM_FUEL_BLOCK);
            ItemGroup.accept(NTMBlocks.TITANIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.TUNGSTEN_BLOCK);
            ItemGroup.accept(NTMBlocks.URANIUM_BLOCK);
            ItemGroup.accept(NTMBlocks.URANIUM_FUEL_BLOCK);
            ItemGroup.accept(NTMBlocks.URANIUM_233_BLOCK);
            ItemGroup.accept(NTMBlocks.URANIUM_235_BLOCK);
            ItemGroup.accept(NTMBlocks.URANIUM_238_BLOCK);
            ItemGroup.accept(NTMBlocks.WHITE_PHOSPHORUS_BLOCK);
            ItemGroup.accept(NTMBlocks.YELLOWCAKE_BLOCK);
            ItemGroup.accept(NTMBlocks.ZIRCONIUM_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(MACHINES_KEY).register(ItemGroup -> {
            ItemGroup.accept(NTMBlocks.TEMP_CABLE);
            ItemGroup.accept(NTMBlocks.POTATO_BATTERY_BLOCK);
            ItemGroup.accept(NTMBlocks.ENERGY_STORAGE_BLOCK);
            ItemGroup.accept(NTMBlocks.LITHIUM_ION_ENERGY_STORAGE_BLOCK);
            ItemGroup.accept(NTMBlocks.SCHRABIDIUM_ENERGY_STORAGE_BLOCK);
            ItemGroup.accept(NTMBlocks.SPARK_ENERGY_STORAGE_BLOCK);
            ItemGroup.accept(NTMBlocks.ALLOY_FURNACE);
            ItemGroup.accept(NTMBlocks.ALLOY_FURNACE_EXTENSION);
            ItemGroup.accept(NTMBlocks.ELECTRIC_FURNACE);
        });
        ItemGroupEvents.modifyEntriesEvent(BOMBS_KEY).register(ItemGroup -> {
            ItemGroup.accept(NTMItems.NULL);
            ItemGroup.accept(NTMItems.NULL);
        });
        ItemGroupEvents.modifyEntriesEvent(MISSILES_AND_SATELLITES_KEY).register(ItemGroup -> {
            ItemGroup.accept(NTMItems.NULL);
            ItemGroup.accept(NTMItems.NULL);
        });
        ItemGroupEvents.modifyEntriesEvent(WEAPONS_AND_TURRETS_KEY).register(ItemGroup -> {
            ItemGroup.accept(NTMItems.NULL);
            ItemGroup.accept(NTMItems.NULL);
        });
        ItemGroupEvents.modifyEntriesEvent(CONSUMABLES_AND_GEAR_KEY).register(ItemGroup -> {
            ItemGroup.accept(NTMItems.DOSIMETER);
            ItemGroup.accept(NTMItems.GEIGER_COUNTER);

            ItemGroup.accept(NTMItems.EMPTY_SYRINGE);
            ItemGroup.accept(NTMItems.POISONOUS_INJECTION);
            ItemGroup.accept(NTMItems.ANTIDOTE);
            ItemGroup.accept(NTMItems.AWESOME);
            ItemGroup.accept(NTMItems.METAL_SYRINGE);
            ItemGroup.accept(NTMItems.STIMPAK);
            ItemGroup.accept(NTMItems.MED_X);
            ItemGroup.accept(NTMItems.PSYCHO);
            ItemGroup.accept(NTMItems.SUPER_STIMPAK);
            ItemGroup.accept(NTMItems.WATERY_TAINT_INJECTION);
            ItemGroup.accept(NTMItems.FIRST_AID_KIT);
            ItemGroup.accept(NTMItems.IV_BAG);
            ItemGroup.accept(NTMItems.BLOOD_BAG);
            ItemGroup.accept(NTMItems.EMPTY_EXPERIENCE_BAG);
            ItemGroup.accept(NTMItems.EXPERIENCE_BAG);
            ItemGroup.accept(NTMItems.RAD_AWAY);
            ItemGroup.accept(NTMItems.STRONG_RAD_AWAY);
            ItemGroup.accept(NTMItems.ELITE_RAD_AWAY);
            ItemGroup.accept(NTMItems.RAD_X);
            ItemGroup.accept(NTMItems.IODINE_PILL);

            ItemGroup.accept(NTMItems.PLAN_C);

            ItemGroup.accept(NTMItems.WAFFLE_OF_MASS_DESTRUCTION);
            ItemGroup.accept(NTMItems.VEGAN_SCHNITZEL);
            ItemGroup.accept(NTMItems.RADIOACTIVE_COTTON_CANDY);
            ItemGroup.accept(NTMItems.BASIC_LEAD_APPLE);
            ItemGroup.accept(NTMItems.GOOD_LEAD_APPLE);
            ItemGroup.accept(NTMItems.EPIC_LEAD_APPLE);
            ItemGroup.accept(NTMItems.BASIC_SCHRABIDIUM_APPLE);
            ItemGroup.accept(NTMItems.GOOD_SCHRABIDIUM_APPLE);
            ItemGroup.accept(NTMItems.EPIC_SCHRABIDIUM_APPLE);
            ItemGroup.accept(NTMItems.EUPHEMIUM_APPLE);
            ItemGroup.accept(NTMItems.CHEAP_TEM_FLAKES);
            ItemGroup.accept(NTMItems.TEM_FLAKES);
            ItemGroup.accept(NTMItems.EXPENSIVE_TEM_FLAKES);
            ItemGroup.accept(NTMItems.GLOWING_MUSHROOM_STEW);
            ItemGroup.accept(NTMItems.SCRAMBLED_BALEFIRE_EGG);
            ItemGroup.accept(NTMItems.SCRAMBLED_BALEFIRE_EGG_AND_HAM);
            ItemGroup.accept(NTMItems.LEMON);
            ItemGroup.accept(NTMItems.MRE);
            ItemGroup.accept(NTMItems.LOOPS);
            ItemGroup.accept(NTMItems.IT_BREAKFAST);
            ItemGroup.accept(NTMItems.SPONGEBOB_MACARONI);
            ItemGroup.accept(NTMItems.FOOD_ITEM);
            ItemGroup.accept(NTMItems.TWINKIE);
            ItemGroup.accept(NTMItems.TV_STATIC_SANDWICH);
            ItemGroup.accept(NTMItems.PUDDING);
            ItemGroup.accept(NTMItems.SCRAP_PANCAKE);
            ItemGroup.accept(NTMItems.CHICKEN_NUGGET);
            ItemGroup.accept(NTMItems.PEAS);
            ItemGroup.accept(NTMItems.MARSHMALLOW_ON_A_STICK);
            ItemGroup.accept(NTMItems.ROASTED_MARSHMALLOW_ON_A_STICK);
            ItemGroup.accept(NTMItems.CHEESE);
            ItemGroup.accept(NTMItems.CHEESE_QUESADILLA);
            ItemGroup.accept(NTMItems.GLYPHID_MEAT);
            ItemGroup.accept(NTMItems.GRILLED_GLYPHID_MEAT);
            ItemGroup.accept(NTMItems.GLYPHID_EGG);
            ItemGroup.accept(NTMItems.IPECAC_SYRUP);
            ItemGroup.accept(NTMItems.PTSD_MEDICATION);
            ItemGroup.accept(NTMItems.STYLISH_FLASK);
            ItemGroup.accept(NTMItems.ARIZONA_MUCHO_MANGO);
            ItemGroup.accept(NTMItems.RADIUM_CHOCOLATE);
            ItemGroup.accept(NTMItems.EMPTY_CAN);
            ItemGroup.accept(NTMItems.RING_PULL);
            ItemGroup.accept(NTMItems.SMART_ENERGY_DRINK);
            ItemGroup.accept(NTMItems.CREATURE_ENERGY_DRINK);
            ItemGroup.accept(NTMItems.RED_BOMB_ENERGY_DRINK);
            ItemGroup.accept(NTMItems.DR_SUGAR_SOFT_DRINK);
            ItemGroup.accept(NTMItems.OVERCHARGE_DELIRIUM_XT);
            ItemGroup.accept(NTMItems.BLACK_MESA_LUNA_DARK_COLA);
            ItemGroup.accept(NTMItems.BEPIS);
            ItemGroup.accept(NTMItems.DR_BREENS_PRIVATE_RESERVE);
            ItemGroup.accept(NTMItems.MUG_ROOT_BEER);
            ItemGroup.accept(NTMItems.COFFEE);
            ItemGroup.accept(NTMItems.RADIUM_COFFEE);
            ItemGroup.accept(NTMItems.EMPTY_BOTTLE);
            ItemGroup.accept(NTMItems.EMPTY_BOMB_BOTTLE);
            ItemGroup.accept(NTMItems.NUKA_COLA_BOTTLE_CAP);
            ItemGroup.accept(NTMItems.NUKA_COLA_QUANTUM_BOTTLE_CAP);
            ItemGroup.accept(NTMItems.S_COLA_BOTTLE_CAP);
            ItemGroup.accept(NTMItems.S_COLA_RAD_BOTTLE_CAP);
            ItemGroup.accept(NTMItems.KAROL_BOTTLE_CAP);
            ItemGroup.accept(NTMItems.FRITZ_COLA_BOTTLE_CAP);
            ItemGroup.accept(NTMItems.BOTTLE_OF_NUKA_COLA);
            ItemGroup.accept(NTMItems.BOTTLE_OF_NUKA_CHERRY);
            ItemGroup.accept(NTMItems.BOTTLE_OF_NUKA_COLA_QUANTUM);
            ItemGroup.accept(NTMItems.BOTTLE_OF_S_COLA);
            ItemGroup.accept(NTMItems.BOTTLE_OF_S_COLA_RAD);
            ItemGroup.accept(NTMItems.BOTTLE_OF_KAROL);
            ItemGroup.accept(NTMItems.FIRST_BOTTLE_OF_KAROL);
            ItemGroup.accept(NTMItems.BOTTLE_OF_FRITZ_COLA);
            ItemGroup.accept(NTMItems.FIRST_BOTTLE_OF_FRITZ_COLA);
            ItemGroup.accept(NTMItems.BOTTLE_OPENER);

            ItemGroup.accept(NTMItems.CONSTRUCTION_WAND);
            ItemGroup.accept(NTMItems.DEBUG_WAND);
            ItemGroup.accept(NTMItems.NETWORK_DEBUG_TOOL);
        });
        ItemGroupEvents.modifyEntriesEvent(TOOLS_KEY).register(ItemGroup -> {
            ItemGroup.accept(NTMItems.STEEL_SWORD);
            ItemGroup.accept(NTMItems.STEEL_SWORD);
            ItemGroup.accept(NTMItems.STEEL_PICKAXE);
            ItemGroup.accept(NTMItems.STEEL_AXE);
            ItemGroup.accept(NTMItems.STEEL_SHOVEL);
            ItemGroup.accept(NTMItems.STEEL_HOE);
            ItemGroup.accept(NTMItems.TITANIUM_SWORD);
            ItemGroup.accept(NTMItems.TITANIUM_PICKAXE);
            ItemGroup.accept(NTMItems.TITANIUM_AXE);
            ItemGroup.accept(NTMItems.TITANIUM_SHOVEL);
            ItemGroup.accept(NTMItems.TITANIUM_HOE);
            ItemGroup.accept(NTMItems.ADVANCED_ALLOY_SWORD);
            ItemGroup.accept(NTMItems.ADVANCED_ALLOY_PICKAXE);
            ItemGroup.accept(NTMItems.ADVANCED_ALLOY_AXE);
            ItemGroup.accept(NTMItems.ADVANCED_ALLOY_SHOVEL);
            ItemGroup.accept(NTMItems.ADVANCED_ALLOY_HOE);
            ItemGroup.accept(NTMItems.CMB_STEEL_SWORD);
            ItemGroup.accept(NTMItems.CMB_STEEL_PICKAXE);
            ItemGroup.accept(NTMItems.CMB_STEEL_AXE);
            ItemGroup.accept(NTMItems.CMB_STEEL_SHOVEL);
            ItemGroup.accept(NTMItems.CMB_STEEL_HOE);
            ItemGroup.accept(NTMItems.COBALT_SWORD);
            ItemGroup.accept(NTMItems.COBALT_PICKAXE);
            ItemGroup.accept(NTMItems.COBALT_AXE);
            ItemGroup.accept(NTMItems.COBALT_SHOVEL);
            ItemGroup.accept(NTMItems.COBALT_HOE);
            ItemGroup.accept(NTMItems.DECORATED_COBALT_SWORD);
            ItemGroup.accept(NTMItems.DECORATED_COBALT_PICKAXE);
            ItemGroup.accept(NTMItems.DECORATED_COBALT_AXE);
            ItemGroup.accept(NTMItems.DECORATED_COBALT_SHOVEL);
            ItemGroup.accept(NTMItems.DECORATED_COBALT_HOE);
            ItemGroup.accept(NTMItems.STARMETAL_SWORD);
            ItemGroup.accept(NTMItems.STARMETAL_PICKAXE);
            ItemGroup.accept(NTMItems.STARMETAL_AXE);
            ItemGroup.accept(NTMItems.STARMETAL_SHOVEL);
            ItemGroup.accept(NTMItems.STARMETAL_HOE);
            ItemGroup.accept(NTMItems.DESH_SWORD);
            ItemGroup.accept(NTMItems.DESH_PICKAXE);
            ItemGroup.accept(NTMItems.DESH_AXE);
            ItemGroup.accept(NTMItems.DESH_SHOVEL);
            ItemGroup.accept(NTMItems.DESH_HOE);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_SWORD);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_PICKAXE);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_AXE);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_SHOVEL);
            ItemGroup.accept(NTMItems.SCHRABIDIUM_HOE);
            ItemGroup.accept(NTMItems.BISMUTH_PICKAXE);
            ItemGroup.accept(NTMItems.BISMUTH_AXE);
            ItemGroup.accept(NTMItems.MOLTEN_PICKAXE);
            ItemGroup.accept(NTMItems.MOLTEN_AXE);
            ItemGroup.accept(NTMItems.CHLOROPHYTE_PICKAXE);
            ItemGroup.accept(NTMItems.CHLOROPHYTE_AXE);
            ItemGroup.accept(NTMItems.MESE_PICKAXE);
            ItemGroup.accept(NTMItems.MESE_AXE);
        });
    }

    private static <T extends Item> ItemStack charged(T item, long charge) {
        return component(item, NTMDataComponentTypes.ENERGY_COMPONENT_TYPE, charge);
    }

    private static <T> ItemStack component(ItemLike item, DataComponentType<T> componentType, T value) {
        ItemStack stack = new ItemStack(item);
        stack.set(componentType, value);
        return stack;
    }
}
