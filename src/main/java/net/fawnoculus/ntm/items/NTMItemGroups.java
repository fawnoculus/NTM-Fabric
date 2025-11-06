package net.fawnoculus.ntm.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.minecraft.component.ComponentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;


public class NTMItemGroups {

	public static final RegistryKey<ItemGroup> RESOURCES_AND_PARTS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("resources_and_parts"));
	public static final ItemGroup RESOURCES_AND_PARTS = FabricItemGroup.builder()
	  .icon(() -> new ItemStack(NTMItems.URANIUM_INGOT))
	  .displayName(Text.translatable("itemGroup.ntm.resources_and_parts"))
	  .build();
	public static final RegistryKey<ItemGroup> MACHINE_ITEMS_AND_FUEL_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("machine_items_and_fuel"));
	public static final ItemGroup MACHINE_ITEMS_AND_FUEL = FabricItemGroup.builder()
	  .icon(() -> new ItemStack(NTMItems.PLUTONIUM_238_RTG_PELLET))
	  .displayName(Text.translatable("itemGroup.ntm.machine_items_and_fuel"))
	  .build();
	public static final RegistryKey<ItemGroup> TEMPLATES_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("templates"));
	public static final ItemGroup TEMPLATES = FabricItemGroup.builder()
	  .icon(() -> new ItemStack(NTMItems.NULL))
	  .displayName(Text.translatable("itemGroup.ntm.templates"))
	  .build();
	public static final RegistryKey<ItemGroup> ORES_AND_BLOCKS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("ores_and_blocks"));
	public static final ItemGroup ORES_AND_BLOCKS = FabricItemGroup.builder()
	  .icon(() -> new ItemStack(NTMBlocks.URANIUM_ORE))
	  .displayName(Text.translatable("itemGroup.ntm.ores_and_blocks"))
	  .build();
	public static final RegistryKey<ItemGroup> MACHINES_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("machines"));
	public static final ItemGroup MACHINES = FabricItemGroup.builder()
	  .icon(() -> new ItemStack(NTMBlocks.PWR_CONTROLLER))
	  .displayName(Text.translatable("itemGroup.ntm.machines"))
	  .build();
	public static final RegistryKey<ItemGroup> BOMBS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("bombs"));
	public static final ItemGroup BOMBS = FabricItemGroup.builder()
	  .icon(() -> new ItemStack(NTMItems.NULL))
	  .texture(NTM.id("textures/gui/creative_inventory/tab_nuke.png"))
	  .displayName(Text.translatable("itemGroup.ntm.bombs"))
	  .build();
	public static final RegistryKey<ItemGroup> MISSILES_AND_SATELLITES_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("missiles_and_satellites"));
	public static final ItemGroup MISSILES_AND_SATELLITES = FabricItemGroup.builder()
	  .icon(() -> new ItemStack(NTMItems.NULL))
	  .displayName(Text.translatable("itemGroup.ntm.missiles_and_satellites"))
	  .build();
	public static final RegistryKey<ItemGroup> WEAPONS_AND_TURRETS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("weapons_and_turrets"));
	public static final ItemGroup WEAPONS_AND_TURRETS = FabricItemGroup.builder()
	  .icon(() -> new ItemStack(NTMItems.NULL))
	  .displayName(Text.translatable("itemGroup.ntm.weapons_and_turrets"))
	  .build();
	public static final RegistryKey<ItemGroup> CONSUMABLES_AND_GEAR_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("consumables_and_gear"));
	public static final ItemGroup CONSUMABLES_AND_GEAR = FabricItemGroup.builder()
	  .icon(() -> new ItemStack(NTMItems.BOTTLE_OF_NUKA_COLA))
	  .displayName(Text.translatable("itemGroup.ntm.consumables_and_gear"))
	  .build();
	public static final RegistryKey<ItemGroup> TOOLS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), NTM.id("tools"));
	public static final ItemGroup TOOLS = FabricItemGroup.builder()
	  .icon(() -> new ItemStack(NTMItems.ADVANCED_ALLOY_PICKAXE))
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
			ItemGroup.add(NTMItems.ACTINIUM_227_INGOT);
			ItemGroup.add(NTMItems.ACTINIUM_227_BILLET);
			ItemGroup.add(NTMItems.ACTINIUM_227_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_ACTINIUM_227_POWDER);
			ItemGroup.add(NTMItems.ACTINIUM_227_NUGGET);
			ItemGroup.add(NTMItems.ACTINIUM_227_FRAGMENT);

			ItemGroup.add(NTMItems.ADVANCED_ALLOY_INGOT);
			ItemGroup.add(NTMItems.ADVANCED_ALLOY_POWDER);
			ItemGroup.add(NTMItems.ADVANCED_ALLOY_PLATE);
			ItemGroup.add(NTMItems.CAST_ADVANCED_ALLOY_PLATE);
			ItemGroup.add(NTMItems.ADVANCED_ALLOY_WIRE);
			ItemGroup.add(NTMItems.DENSE_ADVANCED_ALLOY_WIRE);

			ItemGroup.add(NTMItems.ALEXANDRITE);

			ItemGroup.add(NTMItems.ALUMINIUM_INGOT);
			ItemGroup.add(NTMItems.ALUMINIUM_POWDER);
			ItemGroup.add(NTMItems.ALUMINIUM_PLATE);
			ItemGroup.add(NTMItems.CAST_ALUMINIUM_PLATE);
			ItemGroup.add(NTMItems.WELDED_ALUMINIUM_PLATE);
			ItemGroup.add(NTMItems.ALUMINIUM_SHELL);
			ItemGroup.add(NTMItems.ALUMINIUM_PIPE);
			ItemGroup.add(NTMItems.ALUMINIUM_WIRE);
			ItemGroup.add(NTMItems.ALUMINIUM_CRYSTALS);

			ItemGroup.add(NTMItems.AMERICIUM_241_INGOT);
			ItemGroup.add(NTMItems.AMERICIUM_241_BILLET);
			ItemGroup.add(NTMItems.AMERICIUM_241_NUGGET);
			ItemGroup.add(NTMItems.AMERICIUM_242_INGOT);
			ItemGroup.add(NTMItems.AMERICIUM_242_BILLET);
			ItemGroup.add(NTMItems.AMERICIUM_242_NUGGET);
			ItemGroup.add(NTMItems.AMERICIUM_FUEL_INGOT);
			ItemGroup.add(NTMItems.AMERICIUM_FUEL_BILLET);
			ItemGroup.add(NTMItems.AMERICIUM_FUEL_NUGGET);
			ItemGroup.add(NTMItems.REACTOR_GRADE_AMERICIUM_INGOT);
			ItemGroup.add(NTMItems.REACTOR_GRADE_AMERICIUM_BILLET);
			ItemGroup.add(NTMItems.REACTOR_GRADE_AMERICIUM_ZFB_BILLET);
			ItemGroup.add(NTMItems.REACTOR_GRADE_AMERICIUM_NUGGET);

			ItemGroup.add(NTMItems.ARSENIC_INGOT);
			ItemGroup.add(NTMItems.ARSENIC_NUGGET);
			ItemGroup.add(NTMItems.ARSENIC_BRONZE_INGOT);
			ItemGroup.add(NTMItems.CAST_ARSENIC_BRONZE_PLATE);

			ItemGroup.add(NTMItems.ASBESTOS_SHEET);
			ItemGroup.add(NTMItems.ASBESTOS_POWDER);

			ItemGroup.add(NTMItems.ASH);
			ItemGroup.add(NTMItems.WOOD_ASH);
			ItemGroup.add(NTMItems.COAL_ASH);
			ItemGroup.add(NTMItems.FLY_ASH);
			ItemGroup.add(NTMItems.FINE_SOOT);

			ItemGroup.add(NTMItems.AUSTRALIUM_INGOT);
			ItemGroup.add(NTMItems.AUSTRALIUM_BILLET);
			ItemGroup.add(NTMItems.AUSTRALIUM_NUGGET);
			ItemGroup.add(NTMItems.LESSER_AUSTRALIUM_BILLET);
			ItemGroup.add(NTMItems.LESSER_AUSTRALIUM_NUGGET);
			ItemGroup.add(NTMItems.GREATER_AUSTRALIUM_BILLET);
			ItemGroup.add(NTMItems.GREATER_AUSTRALIUM_NUGGET);
			ItemGroup.add(NTMItems.AUSTRALIUM_POWDER);

			ItemGroup.add(NTMItems.BAKELITE_BAR);
			ItemGroup.add(NTMItems.BAKELITE_POWDER);

			ItemGroup.add(NTMItems.BALEFIRE_EGG);
			ItemGroup.add(NTMItems.BALEFIRE_SHARD);
			ItemGroup.add(NTMItems.THERMONUCLEAR_ASHES);

			ItemGroup.add(NTMItems.BERYLLIUM_INGOT);
			ItemGroup.add(NTMItems.BERYLLIUM_BILLET);
			ItemGroup.add(NTMItems.BERYLLIUM_NUGGET);
			ItemGroup.add(NTMItems.BERYLLIUM_POWDER);
			ItemGroup.add(NTMItems.BERYLLIUM_CRYSTALS);

			ItemGroup.add(NTMItems.BISMUTH_INGOT);
			ItemGroup.add(NTMItems.BISMUTH_BILLET);
			ItemGroup.add(NTMItems.BISMUTH_ZFB_BILLET);
			ItemGroup.add(NTMItems.BISMUTH_POWDER);
			ItemGroup.add(NTMItems.BISMUTH_NUGGET);
			ItemGroup.add(NTMItems.BISMUTH_BRONZE_INGOT);
			ItemGroup.add(NTMItems.CAST_BISMUTH_BRONZE_PLATE);

			ItemGroup.add(NTMItems.BORAX_POWDER);

			ItemGroup.add(NTMItems.BORON_INGOT);
			ItemGroup.add(NTMItems.BORON_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_BORON_POWDER);
			ItemGroup.add(NTMItems.BORON_FRAGMENT);

			ItemGroup.add(NTMItems.BROMINE_POWDER);

			ItemGroup.add(NTMItems.BSCCO_INGOT);
			ItemGroup.add(NTMItems.DENSE_BSCCO_WIRE);

			ItemGroup.add(NTMItems.CADMIUM_INGOT);
			ItemGroup.add(NTMItems.CADMIUM_POWDER);

			ItemGroup.add(NTMItems.CAESIUM_POWDER);
			ItemGroup.add(NTMItems.CAESIUM_137_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_CAESIUM_137_POWDER);

			ItemGroup.add(NTMItems.CALCIUM_INGOT);
			ItemGroup.add(NTMItems.CALCIUM_POWDER);

			ItemGroup.add(NTMItems.CADMIUM_STEEL_INGOT);
			ItemGroup.add(NTMItems.CAST_CADMIUM_STEEL_PLATE);
			ItemGroup.add(NTMItems.WELDED_CADMIUM_STEEL_PLATE);

			ItemGroup.add(NTMItems.CEMENT);

			ItemGroup.add(NTMItems.CERIUM_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_CERIUM_POWDER);
			ItemGroup.add(NTMItems.CERIUM_FRAGMENT);

			ItemGroup.add(NTMItems.CHLOROCALCITE);

			ItemGroup.add(NTMItems.CHLOROPHYTE_POWDER);

			ItemGroup.add(NTMItems.CINNABAR);
			ItemGroup.add(NTMItems.CINNABAR_CRYSTALS);

			ItemGroup.add(NTMItems.CMB_STEEL_INGOT);
			ItemGroup.add(NTMItems.CMB_STEEL_POWDER);
			ItemGroup.add(NTMItems.CAST_CMB_STEEL_PLATE);
			ItemGroup.add(NTMItems.WELDED_CMB_STEEL_PLATE);
			ItemGroup.add(NTMItems.CMB_STEEL_PLATE);

			ItemGroup.add(NTMItems.COAL_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_COAL_POWDER);
			ItemGroup.add(NTMItems.CARBON_WIRE);
			ItemGroup.add(NTMItems.COAL_BRIQUETTE);
			ItemGroup.add(NTMItems.COAL_COKE);

			ItemGroup.add(NTMItems.COBALT_INGOT);
			ItemGroup.add(NTMItems.COBALT_BILLET);
			ItemGroup.add(NTMItems.COBALT_POWDER);
			ItemGroup.add(NTMItems.COBALT_NUGGET);
			ItemGroup.add(NTMItems.TINY_PILE_OF_COBALT_POWDER);
			ItemGroup.add(NTMItems.COBALT_60_INGOT);
			ItemGroup.add(NTMItems.COBALT_60_BILLET);
			ItemGroup.add(NTMItems.COBALT_60_POWDER);
			ItemGroup.add(NTMItems.COBALT_60_NUGGET);
			ItemGroup.add(NTMItems.COBALT_FRAGMENT);
			ItemGroup.add(NTMItems.COBALT_CRYSTALS);

			ItemGroup.add(NTMItems.COLTAN);
			ItemGroup.add(NTMItems.CRUSHED_COLTAN);

			ItemGroup.add(NTMItems.COPPER_POWDER);
			ItemGroup.add(NTMItems.COPPER_PLATE);
			ItemGroup.add(NTMItems.CAST_COPPER_PLATE);
			ItemGroup.add(NTMItems.WELDED_COPPER_PLATE);
			ItemGroup.add(NTMItems.COPPER_PIPE);
			ItemGroup.add(NTMItems.COPPER_SHELL);
			ItemGroup.add(NTMItems.COPPER_WIRE);
			ItemGroup.add(NTMItems.DENSE_COPPER_WIRE);
			ItemGroup.add(NTMItems.COPPER_CRYSTALS);

			ItemGroup.add(NTMItems.CRYO_POWDER);

			ItemGroup.add(NTMItems.CRYOLITE_CHUNK);

			ItemGroup.add(NTMItems.DESH_INGOT);
			ItemGroup.add(NTMItems.DESH_BLEND);
			ItemGroup.add(NTMItems.DESHREADY_BLEND);
			ItemGroup.add(NTMItems.DESH_POWDER);
			ItemGroup.add(NTMItems.DESH_NUGGET);
			ItemGroup.add(NTMItems.CAST_DESH_PLATE);

			ItemGroup.add(NTMItems.DIAMOND_POWDER);
			ItemGroup.add(NTMItems.DIAMOND_CRYSTALS);

			ItemGroup.add(NTMItems.DINEUTRONIUM_INGOT);
			ItemGroup.add(NTMItems.DINEUTRONIUM_POWDER);
			ItemGroup.add(NTMItems.DINEUTRONIUM_NUGGET);
			ItemGroup.add(NTMItems.DENSE_DINEUTRONIUM_WIRE);

			ItemGroup.add(NTMItems.ELECTRONIUM_INGOT);

			ItemGroup.add(NTMItems.EMERALD_POWDER);

			ItemGroup.add(NTMItems.ENERGY_POWDER);

			ItemGroup.add(NTMItems.EUPHEMIUM_INGOT);
			ItemGroup.add(NTMItems.EUPHEMIUM_POWDER);
			ItemGroup.add(NTMItems.EUPHEMIUM_NUGGET);

			ItemGroup.add(NTMItems.FERRIC_SCHARBIDATE_INGOT);
			ItemGroup.add(NTMItems.FERRIC_SCHARBIDATE_POWDER);
			ItemGroup.add(NTMItems.CAST_FERRIC_SCHARBIDATE_PLATE);
			ItemGroup.add(NTMItems.DENSE_FERRIC_SCHARBIDATE_WIRE);

			ItemGroup.add(NTMItems.FERROURANIUM_INGOT);
			ItemGroup.add(NTMItems.CAST_FERROURANIUM_PLATE);

			ItemGroup.add(NTMItems.FLASH_GOLD);

			ItemGroup.add(NTMItems.FLASH_LEAD);

			ItemGroup.add(NTMItems.FLUORITE);
			ItemGroup.add(NTMItems.FLUORITE_CRYSTALS);

			ItemGroup.add(NTMItems.FLUX);

			ItemGroup.add(NTMItems.FULLERENE);
			ItemGroup.add(NTMItems.CRYSTALLINE_FULLERENE);

			ItemGroup.add(NTMItems.GHIORSIUM_336_INGOT);
			ItemGroup.add(NTMItems.GHIORSIUM_336_BILLET);
			ItemGroup.add(NTMItems.GHIORSIUM_336_NUGGET);

			ItemGroup.add(NTMItems.GOLD_POWDER);
			ItemGroup.add(NTMItems.GOLD_PLATE);
			ItemGroup.add(NTMItems.CAST_GOLD_PLATE);
			ItemGroup.add(NTMItems.GOLD_WIRE);
			ItemGroup.add(NTMItems.DENSE_GOLD_WIRE);
			ItemGroup.add(NTMItems.GOLD_CRYSTALS);
			ItemGroup.add(NTMItems.GOLD_198_INGOT);
			ItemGroup.add(NTMItems.GOLD_198_BILLET);
			ItemGroup.add(NTMItems.GOLD_198_POWDER);
			ItemGroup.add(NTMItems.GOLD_198_NUGGET);

			ItemGroup.add(NTMItems.GRAPHITE_INGOT);

			ItemGroup.add(NTMItems.GUNMETAL_INGOT);
			ItemGroup.add(NTMItems.GUNMETAL_PLATE);

			ItemGroup.add(NTMItems.HARD_PLASTIC_BAR);

			ItemGroup.add(NTMItems.HIGH_SPEED_STEEL_INGOT);
			ItemGroup.add(NTMItems.HIGH_SPEED_STEEL_POWDER);
			ItemGroup.add(NTMItems.CAST_HIGH_SPEED_STEEL_PLATE);
			ItemGroup.add(NTMItems.HIGH_SPEED_STEEL_PLATE);
			ItemGroup.add(NTMItems.HIGH_SPEED_STEEL_BOLT);
			ItemGroup.add(NTMItems.HIGH_SPEED_STEEL_PIPE);

			ItemGroup.add(NTMItems.IODINE_POWDER);
			ItemGroup.add(NTMItems.IODINE_131_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_IODINE_131_POWDER);

			ItemGroup.add(NTMItems.IRON_POWDER);
			ItemGroup.add(NTMItems.IRON_PLATE);
			ItemGroup.add(NTMItems.CAST_IRON_PLATE);
			ItemGroup.add(NTMItems.WELDED_IRON_PLATE);
			ItemGroup.add(NTMItems.IRON_PIPE);
			ItemGroup.add(NTMItems.IRON_CRYSTALS);

			ItemGroup.add(NTMItems.INDUSTRIAL_FERTILIZER);

			ItemGroup.add(NTMItems.INFERNAL_COAL);

			ItemGroup.add(NTMItems.SEMI_STABLE_LANTHANUM_INGOT);
			ItemGroup.add(NTMItems.LANTHANUM_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_LANTHANUM_POWDER);
			ItemGroup.add(NTMItems.LANTHANUM_FRAGMENT);

			ItemGroup.add(NTMItems.LAPIS_POWDER);
			ItemGroup.add(NTMItems.LAPIS_CRYSTALS);

			ItemGroup.add(NTMItems.LATEX);
			ItemGroup.add(NTMItems.LATEX_BAR);

			ItemGroup.add(NTMItems.LEAD_INGOT);
			ItemGroup.add(NTMItems.LEAD_NUGGET);
			ItemGroup.add(NTMItems.LEAD_209_INGOT);
			ItemGroup.add(NTMItems.LEAD_209_BILLET);
			ItemGroup.add(NTMItems.LEAD_209_NUGGET);
			ItemGroup.add(NTMItems.LEAD_POWDER);
			ItemGroup.add(NTMItems.LEAD_PLATE);
			ItemGroup.add(NTMItems.CAST_LEAD_PLATE);
			ItemGroup.add(NTMItems.LEAD_PIPE);
			ItemGroup.add(NTMItems.LEAD_BOLT);
			ItemGroup.add(NTMItems.LEAD_WIRE);
			ItemGroup.add(NTMItems.LEAD_CRYSTALS);

			ItemGroup.add(NTMItems.LIGNITE);
			ItemGroup.add(NTMItems.LIGNITE_POWDER);
			ItemGroup.add(NTMItems.LIGNITE_COKE);
			ItemGroup.add(NTMItems.LIGNITE_BRIQUETTE);

			ItemGroup.add(NTMItems.LIMESTONE_POWDER);

			ItemGroup.add(NTMItems.LITHIUM_CUBE);
			ItemGroup.add(NTMItems.LITHIUM_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_LITHIUM_POWDER);
			ItemGroup.add(NTMItems.LITHIUM_CRYSTALS);

			ItemGroup.add(NTMItems.MAGNETIZED_TUNGSTEN_INGOT);
			ItemGroup.add(NTMItems.MAGNETIZED_TUNGSTEN_POWDER);
			ItemGroup.add(NTMItems.MAGNETIZED_TUNGSTEN_WIRE);
			ItemGroup.add(NTMItems.DENSE_MAGNETIZED_TUNGSTEN_WIRE);

			ItemGroup.add(NTMItems.METEORITE_INGOT);
			ItemGroup.add(NTMItems.METEORITE_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_METEORITE_POWDER);
			ItemGroup.add(NTMItems.METEORITE_FRAGMENT);

			ItemGroup.add(NTMItems.MOLYSITE);

			ItemGroup.add(NTMItems.MOX_FUEL_INGOT);
			ItemGroup.add(NTMItems.MOX_FUEL_BILLET);
			ItemGroup.add(NTMItems.MOX_FUEL_NUGGET);

			ItemGroup.add(NTMItems.NEODYMIUM_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_NEODYMIUM_POWDER);
			ItemGroup.add(NTMItems.DENSE_NEODYMIUM_WIRE);
			ItemGroup.add(NTMItems.NEODYMIUM_FRAGMENT);

			ItemGroup.add(NTMItems.NEPTUNIUM_INGOT);
			ItemGroup.add(NTMItems.NEPTUNIUM_BILLET);
			ItemGroup.add(NTMItems.NEPTUNIUM_POWDER);
			ItemGroup.add(NTMItems.NEPTUNIUM_NUGGET);
			ItemGroup.add(NTMItems.NEPTUNIUM_FUEL_INGOT);
			ItemGroup.add(NTMItems.NEPTUNIUM_FUEL_BILLET);
			ItemGroup.add(NTMItems.NEPTUNIUM_FUEL_NUGGET);

			ItemGroup.add(NTMItems.NIOBIUM_INGOT);
			ItemGroup.add(NTMItems.NIOBIUM_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_NIOBIUM_POWDER);
			ItemGroup.add(NTMItems.NIOBIUM_NUGGET);
			ItemGroup.add(NTMItems.DENSE_NIOBIUM_WIRE);
			ItemGroup.add(NTMItems.NIOBIUM_FRAGMENT);

			ItemGroup.add(NTMItems.NITAN_BLEND);

			ItemGroup.add(NTMItems.NITER);
			ItemGroup.add(NTMItems.NITER_CRYSTALS);

			ItemGroup.add(NTMItems.NITRA);
			ItemGroup.add(NTMItems.SMALL_PILE_OF_NITRA);

			ItemGroup.add(NTMItems.OSMIRIDIUM_INGOT);
			ItemGroup.add(NTMItems.OSMIRIDIUM_NUGGET);
			ItemGroup.add(NTMItems.IMPURE_OSMIRIDIUM_POWDER);
			ItemGroup.add(NTMItems.CAST_OSMIRIDIUM_PLATE);
			ItemGroup.add(NTMItems.WELDED_OSMIRIDIUM_PLATE);
			ItemGroup.add(NTMItems.OSMIRIDIUM_CRYSTALS);

			ItemGroup.add(NTMItems.PALEOGENITE_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_PALEOGENITE_POWDER);

			ItemGroup.add(NTMItems.RED_PHOSPHORUS);
			ItemGroup.add(NTMItems.WHITE_PHOSPHORUS_BAR);
			ItemGroup.add(NTMItems.PHOSPHORUS_CRYSTALS);

			ItemGroup.add(NTMItems.PETROLEUM_COKE);

			ItemGroup.add(NTMItems.PLUTONIUM_INGOT);
			ItemGroup.add(NTMItems.PLUTONIUM_BILLET);
			ItemGroup.add(NTMItems.PLUTONIUM_NUGGET);
			ItemGroup.add(NTMItems.PLUTONIUM_FUEL_INGOT);
			ItemGroup.add(NTMItems.PLUTONIUM_FUEL_BILLET);
			ItemGroup.add(NTMItems.PLUTONIUM_FUEL_NUGGET);
			ItemGroup.add(NTMItems.REACTOR_GRADE_PLUTONIUM_INGOT);
			ItemGroup.add(NTMItems.REACTOR_GRADE_PLUTONIUM_BILLET);
			ItemGroup.add(NTMItems.REACTOR_GRADE_PLUTONIUM_NUGGET);
			ItemGroup.add(NTMItems.PLUTONIUM_238_INGOT);
			ItemGroup.add(NTMItems.PLUTONIUM_238_BILLET);
			ItemGroup.add(NTMItems.PLUTONIUM_238_BE_BILLET);
			ItemGroup.add(NTMItems.PLUTONIUM_238_NUGGET);
			ItemGroup.add(NTMItems.PLUTONIUM_239_INGOT);
			ItemGroup.add(NTMItems.PLUTONIUM_239_BILLET);
			ItemGroup.add(NTMItems.PLUTONIUM_239_NUGGET);
			ItemGroup.add(NTMItems.PLUTONIUM_240_INGOT);
			ItemGroup.add(NTMItems.PLUTONIUM_240_BILLET);
			ItemGroup.add(NTMItems.PLUTONIUM_240_NUGGET);
			ItemGroup.add(NTMItems.PLUTONIUM_241_INGOT);
			ItemGroup.add(NTMItems.PLUTONIUM_241_BILLET);
			ItemGroup.add(NTMItems.PLUTONIUM_241_ZFB_BILLET);
			ItemGroup.add(NTMItems.PLUTONIUM_241_NUGGET);
			ItemGroup.add(NTMItems.PLUTONIUM_POWDER);
			ItemGroup.add(NTMItems.PLUTONIUM_CRYSTALS);

			ItemGroup.add(NTMItems.POISON_POWDER);

			ItemGroup.add(NTMItems.POLONIUM_210_INGOT);
			ItemGroup.add(NTMItems.POLONIUM_210_BILLET);
			ItemGroup.add(NTMItems.POLONIUM_210_BE_BILLET);
			ItemGroup.add(NTMItems.POLONIUM_210_NUGGET);
			ItemGroup.add(NTMItems.POLONIUM_210_POWDER);

			ItemGroup.add(NTMItems.POLYMER_BAR);
			ItemGroup.add(NTMItems.POLYMER_POWDER);

			ItemGroup.add(NTMItems.PULVERIZED_ENCHANTMENT);

			ItemGroup.add(NTMItems.PVC_BAR);

			ItemGroup.add(NTMItems.QUARTZ_POWDER);

			ItemGroup.add(NTMItems.RADIUM_226_INGOT);
			ItemGroup.add(NTMItems.RADIUM_226_BILLET);
			ItemGroup.add(NTMItems.RADIUM_226_BE_BILLET);
			ItemGroup.add(NTMItems.RADIUM_226_POWDER);
			ItemGroup.add(NTMItems.RADIUM_226_NUGGET);

			ItemGroup.add(NTMItems.RARE_EARTH_ORE_CHUNK);
			ItemGroup.add(NTMItems.RARE_EARTH_CRYSTALS);

			ItemGroup.add(NTMItems.RED_COPPER_INGOT);
			ItemGroup.add(NTMItems.RED_COPPER_POWDER);
			ItemGroup.add(NTMItems.RED_COPPER_WIRE);

			ItemGroup.add(NTMItems.REDSTONE_CRYSTALS);

			ItemGroup.add(NTMItems.RUBBER_BAR);
			ItemGroup.add(NTMItems.RUBBER_PIPE);

			ItemGroup.add(NTMItems.SATURNITE_INGOT);
			ItemGroup.add(NTMItems.SATURNITE_PLATE);
			ItemGroup.add(NTMItems.CAST_SATURNITE_PLATE);
			ItemGroup.add(NTMItems.SATURNITE_SHELL);

			ItemGroup.add(NTMItems.SAWDUST_POWDER);
			ItemGroup.add(NTMItems.SAWDUST_BRIQUETTE);

			ItemGroup.add(NTMItems.SCHRABIDIUM_INGOT);
			ItemGroup.add(NTMItems.SCHRABIDIUM_BILLET);
			ItemGroup.add(NTMItems.SCHRABIDIUM_NUGGET);
			ItemGroup.add(NTMItems.SCHRABIDIUM_FUEL_INGOT);
			ItemGroup.add(NTMItems.SCHRABIDIUM_FUEL_BILLET);
			ItemGroup.add(NTMItems.SCHRABIDIUM_FUEL_NUGGET);
			ItemGroup.add(NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT);
			ItemGroup.add(NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_BILLET);
			ItemGroup.add(NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_NUGGET);
			ItemGroup.add(NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT);
			ItemGroup.add(NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_BILLET);
			ItemGroup.add(NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_NUGGET);
			ItemGroup.add(NTMItems.SCHRABIDIUM_POWDER);
			ItemGroup.add(NTMItems.SCHRABIDIUM_PLATE);
			ItemGroup.add(NTMItems.CAST_SCHRABIDIUM_PLATE);
			ItemGroup.add(NTMItems.SCHRABIDIUM_WIRE);
			ItemGroup.add(NTMItems.DENSE_SCHRABIDIUM_WIRE);
			ItemGroup.add(NTMItems.SCHRABIDIUM_CRYSTALS);

			ItemGroup.add(NTMItems.SCHRARANIUM_INGOT);
			ItemGroup.add(NTMItems.SCHRARANIUM_CRYSTALS);

			ItemGroup.add(NTMItems.SEMTEX_BLEND);
			ItemGroup.add(NTMItems.SEMTEX_BAR);

			ItemGroup.add(NTMItems.SILICON_BOULE);
			ItemGroup.add(NTMItems.SILICON_WAFER);
			ItemGroup.add(NTMItems.PRINTED_SILICON_WAFER);
			ItemGroup.add(NTMItems.SILICON_NUGGET);

			ItemGroup.add(NTMItems.SODIUM_POWDER);

			ItemGroup.add(NTMItems.SOLINIUM_INGOT);
			ItemGroup.add(NTMItems.SOLINIUM_BILLET);
			ItemGroup.add(NTMItems.SOLINIUM_NUGGET);

			ItemGroup.add(NTMItems.SPARK_BLEND);

			ItemGroup.add(NTMItems.STARMETAL_INGOT);
			ItemGroup.add(NTMItems.DENSE_STARMETAL_WIRE);
			ItemGroup.add(NTMItems.STARMETAL_RING);
			ItemGroup.add(NTMItems.STARMETAL_CRYSTALS);

			ItemGroup.add(NTMItems.STRONTIUM_POWDER);
			ItemGroup.add(NTMItems.STRONTIUM_90_INGOT);
			ItemGroup.add(NTMItems.STRONTIUM_90_BILLET);
			ItemGroup.add(NTMItems.STRONTIUM_90_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_STRONTIUM_90_POWDER);
			ItemGroup.add(NTMItems.STRONTIUM_90_NUGGET);

			ItemGroup.add(NTMItems.STEEL_INGOT);
			ItemGroup.add(NTMItems.STEEL_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_STEEL_POWDER);
			ItemGroup.add(NTMItems.STEEL_PLATE);
			ItemGroup.add(NTMItems.CAST_STEEL_PLATE);
			ItemGroup.add(NTMItems.WELDED_STEEL_PLATE);
			ItemGroup.add(NTMItems.STEEL_BOLT);
			ItemGroup.add(NTMItems.STEEL_PIPE);
			ItemGroup.add(NTMItems.STEEL_SHELL);
			ItemGroup.add(NTMItems.STEEL_WIRE);

			ItemGroup.add(NTMItems.SULFUR);
			ItemGroup.add(NTMItems.SULFUR_CRYSTALS);

			ItemGroup.add(NTMItems.PURIFIED_TANTALITE);
			ItemGroup.add(NTMItems.TANTALUM_INGOT);
			ItemGroup.add(NTMItems.TANTALUM_POWDER);
			ItemGroup.add(NTMItems.TANTALUM_NUGGET);
			ItemGroup.add(NTMItems.TANTALUM_POLYCRYSTAL);

			ItemGroup.add(NTMItems.TECHNETIUM_99_INGOT);
			ItemGroup.add(NTMItems.TECHNETIUM_99_BILLET);
			ItemGroup.add(NTMItems.TECHNETIUM_99_NUGGET);

			ItemGroup.add(NTMItems.TECHNETIUM_STEEL_INGOT);
			ItemGroup.add(NTMItems.TECHNETIUM_STEEL_POWDER);
			ItemGroup.add(NTMItems.CAST_TECHNETIUM_STEEL_PLATE);
			ItemGroup.add(NTMItems.WELDED_TECHNETIUM_STEEL_PLATE);

			ItemGroup.add(NTMItems.TEKTITE_POWDER);

			ItemGroup.add(NTMItems.TENNESSINE_POWDER);

			ItemGroup.add(NTMItems.THERMITE);

			ItemGroup.add(NTMItems.THORIUM_232_INGOT);
			ItemGroup.add(NTMItems.THORIUM_FUEL_INGOT);
			ItemGroup.add(NTMItems.THORIUM_232_BILLET);
			ItemGroup.add(NTMItems.THORIUM_FUEL_BILLET);
			ItemGroup.add(NTMItems.THORIUM_232_NUGGET);
			ItemGroup.add(NTMItems.THORIUM_FUEL_NUGGET);
			ItemGroup.add(NTMItems.THORIUM_POWDER);
			ItemGroup.add(NTMItems.THORIUM_CRYSTALS);

			ItemGroup.add(NTMItems.TITANIUM_INGOT);
			ItemGroup.add(NTMItems.TITANIUM_PLATE);
			ItemGroup.add(NTMItems.CAST_TITANIUM_PLATE);
			ItemGroup.add(NTMItems.WELDED_TITANIUM_PLATE);
			ItemGroup.add(NTMItems.TITANIUM_POWDER);
			ItemGroup.add(NTMItems.TITANIUM_SHELL);
			ItemGroup.add(NTMItems.DENSE_TITANIUM_WIRE);
			ItemGroup.add(NTMItems.TITANIUM_CRYSTALS);

			ItemGroup.add(NTMItems.TRIXITE_CRYSTALS);

			ItemGroup.add(NTMItems.TUNGSTEN_INGOT);
			ItemGroup.add(NTMItems.TUNGSTEN_POWDER);
			ItemGroup.add(NTMItems.TUNGSTEN_BOLT);
			ItemGroup.add(NTMItems.TUNGSTEN_WIRE);
			ItemGroup.add(NTMItems.DENSE_TUNGSTEN_WIRE);
			ItemGroup.add(NTMItems.TUNGSTEN_CRYSTALS);

			ItemGroup.add(NTMItems.URANIUM_INGOT);
			ItemGroup.add(NTMItems.URANIUM_BILLET);
			ItemGroup.add(NTMItems.URANIUM_NUGGET);
			ItemGroup.add(NTMItems.URANIUM_FUEL_INGOT);
			ItemGroup.add(NTMItems.URANIUM_FUEL_BILLET);
			ItemGroup.add(NTMItems.URANIUM_FUEL_NUGGET);
			ItemGroup.add(NTMItems.URANIUM_233_INGOT);
			ItemGroup.add(NTMItems.URANIUM_233_BILLET);
			ItemGroup.add(NTMItems.URANIUM_233_NUGGET);
			ItemGroup.add(NTMItems.URANIUM_235_INGOT);
			ItemGroup.add(NTMItems.URANIUM_235_BILLET);
			ItemGroup.add(NTMItems.URANIUM_235_NUGGET);
			ItemGroup.add(NTMItems.URANIUM_238_INGOT);
			ItemGroup.add(NTMItems.URANIUM_238_BILLET);
			ItemGroup.add(NTMItems.URANIUM_238_NUGGET);
			ItemGroup.add(NTMItems.URANIUM_POWDER);
			ItemGroup.add(NTMItems.URANIUM_CRYSTALS);

			ItemGroup.add(NTMItems.VOLCANIC_GEM);

			ItemGroup.add(NTMItems.WEAPON_STEEL_INGOT);
			ItemGroup.add(NTMItems.WEAPON_STEEL_PLATE);
			ItemGroup.add(NTMItems.CAST_WEAPON_STEEL_PLATE);
			ItemGroup.add(NTMItems.WEAPON_STEEL_SHELL);

			ItemGroup.add(NTMItems.XENON_135_POWDER);
			ItemGroup.add(NTMItems.TINY_PILE_OF_XENON_135_POWDER);

			ItemGroup.add(NTMItems.YHARONITE_BILLET);

			ItemGroup.add(NTMItems.YELLOWCAKE);

			ItemGroup.add(NTMItems.ZIRCONIUM_SPLINTER);
			ItemGroup.add(NTMItems.ZIRCONIUM_CUBE);
			ItemGroup.add(NTMItems.ZIRCONIUM_BILLET);
			ItemGroup.add(NTMItems.ZIRCONIUM_POWDER);
			ItemGroup.add(NTMItems.CAST_ZIRCONIUM_PLATE);
			ItemGroup.add(NTMItems.WELDED_ZIRCONIUM_PLATE);
			ItemGroup.add(NTMItems.ZIRCONIUM_WIRE);
		});
		ItemGroupEvents.modifyEntriesEvent(MACHINE_ITEMS_AND_FUEL_KEY).register(ItemGroup -> {
			ItemGroup.add(NTMItems.BATTERY);
			ItemGroup.add(charged(NTMItems.BATTERY, 5_000L));
			ItemGroup.add(NTMItems.REDSTONE_POWER_CELL);
			ItemGroup.add(charged(NTMItems.REDSTONE_POWER_CELL, 15_000L));
			ItemGroup.add(NTMItems.SIXFOLD_REDSTONE_POWER_CELL);
			ItemGroup.add(charged(NTMItems.SIXFOLD_REDSTONE_POWER_CELL, 90_000L));
			ItemGroup.add(NTMItems.TWENTY_FOUR_FOLD_REDSTONE_POWER_CELL);
			ItemGroup.add(charged(NTMItems.TWENTY_FOUR_FOLD_REDSTONE_POWER_CELL, 360_000L));
			ItemGroup.add(NTMItems.ADVANCED_BATTERY);
			ItemGroup.add(charged(NTMItems.ADVANCED_BATTERY, 20_000L));
			ItemGroup.add(NTMItems.ADVANCED_POWER_CELL);
			ItemGroup.add(charged(NTMItems.ADVANCED_POWER_CELL, 60_000L));
			ItemGroup.add(NTMItems.QUADRUPLE_ADVANCED_POWER_CELL);
			ItemGroup.add(charged(NTMItems.QUADRUPLE_ADVANCED_POWER_CELL, 240_000L));
			ItemGroup.add(NTMItems.TWELVEFOLD_ADVANCED_POWER_CELL);
			ItemGroup.add(charged(NTMItems.TWELVEFOLD_ADVANCED_POWER_CELL, 720_000L));
			ItemGroup.add(NTMItems.LITHIUM_ION_BATTERY);
			ItemGroup.add(charged(NTMItems.LITHIUM_ION_BATTERY, 250_000L));
			ItemGroup.add(NTMItems.LITHIUM_ION_POWER_CELL);
			ItemGroup.add(charged(NTMItems.LITHIUM_ION_POWER_CELL, 750_000L));
			ItemGroup.add(NTMItems.TRIPLE_LITHIUM_ION_POWER_CELL);
			ItemGroup.add(charged(NTMItems.TRIPLE_LITHIUM_ION_POWER_CELL, 2_250_000L));
			ItemGroup.add(NTMItems.SIXFOLD_LITHIUM_ION_POWER_CELL);
			ItemGroup.add(charged(NTMItems.SIXFOLD_LITHIUM_ION_POWER_CELL, 4_500_000L));
			ItemGroup.add(NTMItems.SCHRABIDIUM_BATTERY);
			ItemGroup.add(charged(NTMItems.SCHRABIDIUM_BATTERY, 1_000_000L));
			ItemGroup.add(NTMItems.SCHRABIDIUM_POWER_CELL);
			ItemGroup.add(charged(NTMItems.SCHRABIDIUM_POWER_CELL, 3_000_000L));
			ItemGroup.add(NTMItems.DOUBLE_SCHRABIDIUM_POWER_CELL);
			ItemGroup.add(charged(NTMItems.DOUBLE_SCHRABIDIUM_POWER_CELL, 6_000_000L));
			ItemGroup.add(NTMItems.QUADRUPLE_SCHRABIDIUM_POWER_CELL);
			ItemGroup.add(charged(NTMItems.QUADRUPLE_SCHRABIDIUM_POWER_CELL, 12_000_000L));
			ItemGroup.add(NTMItems.SPARK_BATTERY);
			ItemGroup.add(charged(NTMItems.SPARK_BATTERY, 100_000_000L));
			ItemGroup.add(NTMItems.OFF_BRAND_SPARK_BATTERY);
			ItemGroup.add(charged(NTMItems.OFF_BRAND_SPARK_BATTERY, 5_000_000L));
			ItemGroup.add(NTMItems.SPARK_POWER_CELL);
			ItemGroup.add(charged(NTMItems.SPARK_POWER_CELL, 600_000_000L));
			ItemGroup.add(NTMItems.SPARK_ARCANE_CAR_BATTERY);
			ItemGroup.add(charged(NTMItems.SPARK_ARCANE_CAR_BATTERY, 2_500_000_000L));
			ItemGroup.add(NTMItems.SPARK_ARCANE_ENERGY_STORAGE_ARRAY);
			ItemGroup.add(charged(NTMItems.SPARK_ARCANE_ENERGY_STORAGE_ARRAY, 10_000_000_000L));
			ItemGroup.add(NTMItems.SPARK_ARCANE_MASS_ENERGY_VOID);
			ItemGroup.add(charged(NTMItems.SPARK_ARCANE_MASS_ENERGY_VOID, 100_000_000_000L));
			ItemGroup.add(NTMItems.SPARK_ARCANE_DIRAC_SEA);
			ItemGroup.add(charged(NTMItems.SPARK_ARCANE_DIRAC_SEA, 250_000_000_000L));
			ItemGroup.add(NTMItems.SPARK_SOLID_SPACE_TIME_CRYSTAL);
			ItemGroup.add(charged(NTMItems.SPARK_SOLID_SPACE_TIME_CRYSTAL, 1_000_000_000_000L));
			ItemGroup.add(NTMItems.SPARK_LUDICROUS_ENERGY_STORAGE_UNIT);
			ItemGroup.add(charged(NTMItems.SPARK_LUDICROUS_ENERGY_STORAGE_UNIT, 100_000_000_000_000L));
			ItemGroup.add(NTMItems.ELECTRONIUM_CUBE);
			ItemGroup.add(charged(NTMItems.ELECTRONIUM_CUBE, 1_000_000_000_000_000_000L));
			ItemGroup.add(NTMItems.INFINITE_BATTERY);
			ItemGroup.add(NTMItems.POTATO_BATTERY);
			ItemGroup.add(NTMItems.POTATOS);
			ItemGroup.add(NTMItems.SELF_CHARGING_URANIUM_238_BATTERY);
			ItemGroup.add(NTMItems.SELF_CHARGING_TECHNETIUM_99_BATTERY);
			ItemGroup.add(NTMItems.SELF_CHARGING_PLUTONIUM_238_BATTERY);
			ItemGroup.add(NTMItems.SELF_CHARGING_POLONIUM_210_BATTERY);
			ItemGroup.add(NTMItems.SELF_CHARGING_GOLD_198_BATTERY);
			ItemGroup.add(NTMItems.SELF_CHARGING_LEAD_209_BATTERY);
			ItemGroup.add(NTMItems.SELF_CHARGING_AMERICIUM_241_BATTERY);
		});
		ItemGroupEvents.modifyEntriesEvent(TEMPLATES_KEY).register(ItemGroup -> {
			ItemGroup.add(NTMItems.NULL);
			ItemGroup.add(NTMItems.NULL);
		});
		ItemGroupEvents.modifyEntriesEvent(ORES_AND_BLOCKS_KEY).register(ItemGroup -> {
			ItemGroup.add(NTMBlocks.URANIUM_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_URANIUM_ORE);
			ItemGroup.add(NTMBlocks.SCORCHED_URANIUM_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE);
			ItemGroup.add(NTMBlocks.TITANIUM_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_TITANIUM_ORE);
			ItemGroup.add(NTMBlocks.SULFUR_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_SULFUR_ORE);
			ItemGroup.add(NTMBlocks.THORIUM_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_THORIUM_ORE);
			ItemGroup.add(NTMBlocks.NITER_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_NITER_ORE);
			ItemGroup.add(NTMBlocks.TUNGSTEN_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE);
			ItemGroup.add(NTMBlocks.ALUMINIUM_BEARING_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE);
			ItemGroup.add(NTMBlocks.FLUORITE_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_FLUORITE_ORE);
			ItemGroup.add(NTMBlocks.LEAD_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_LEAD_ORE);
			ItemGroup.add(NTMBlocks.SCHRABIDIUM_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE);
			ItemGroup.add(NTMBlocks.BERYLLIUM_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE);
			ItemGroup.add(NTMBlocks.AUSTRALIUM_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE);
			ItemGroup.add(NTMBlocks.RARE_EARTH_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE);
			ItemGroup.add(NTMBlocks.COBALT_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_COBALT_ORE);
			ItemGroup.add(NTMBlocks.CINNEBAR_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_CINNEBAR_ORE);
			ItemGroup.add(NTMBlocks.COLTAN_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_COLTAN_ORE);
			ItemGroup.add(NTMBlocks.LIGNITE_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_LIGNITE_ORE);
			ItemGroup.add(NTMBlocks.ASBESTOS_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_ASBESTOS_ORE);
			ItemGroup.add(NTMBlocks.OIL_DEPOSIT);
			ItemGroup.add(NTMBlocks.DEEPSLATE_OIL_DEPOSIT);
			ItemGroup.add(NTMBlocks.EMPTY_OIL_DEPOSIT);
			ItemGroup.add(NTMBlocks.DEEPSLATE_EMPTY_OIL_DEPOSIT);
			ItemGroup.add(NTMBlocks.ALUMINIUM_ORE_CLUSTER);
			ItemGroup.add(NTMBlocks.DEEPSLATE_ALUMINIUM_ORE_CLUSTER);
			ItemGroup.add(NTMBlocks.COPPER_ORE_CLUSTER);
			ItemGroup.add(NTMBlocks.DEEPSLATE_COPPER_ORE_CLUSTER);
			ItemGroup.add(NTMBlocks.IRON_ORE_CLUSTER);
			ItemGroup.add(NTMBlocks.DEEPSLATE_IRON_ORE_CLUSTER);
			ItemGroup.add(NTMBlocks.TITANIUM_ORE_CLUSTER);
			ItemGroup.add(NTMBlocks.DEEPSLATE_TITANIUM_ORE_CLUSTER);
			ItemGroup.add(NTMBlocks.DEAD_DIRT);
			ItemGroup.add(NTMBlocks.OILY_DIRT);
			ItemGroup.add(NTMBlocks.OILY_SAND);
			ItemGroup.add(NTMBlocks.DEPTH_ROCK);
			ItemGroup.add(NTMBlocks.DEPTH_CINNABAR_ORE);
			ItemGroup.add(NTMBlocks.DEPTH_ZIRCONIUM_ORE);
			ItemGroup.add(NTMBlocks.DEPTH_BORAX_ORE);
			ItemGroup.add(NTMBlocks.DEPTH_IRON_ORE_CLUSTER);
			ItemGroup.add(NTMBlocks.DEPTH_TITANIUM_ORE_CLUSTER);
			ItemGroup.add(NTMBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER);
			ItemGroup.add(NTMBlocks.ALEXANDRITE_ORE);
			ItemGroup.add(NTMBlocks.DEEPSLATE_ALEXANDRITE_ORE);
			ItemGroup.add(NTMBlocks.VOLCANIC_BASALT);
			ItemGroup.add(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT);
			ItemGroup.add(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT);
			ItemGroup.add(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT);
			ItemGroup.add(NTMBlocks.GEM_RICH_VOLCANIC_BASALT);
			ItemGroup.add(NTMBlocks.MOLYSITE_RICH_VOLCANIC_BASALT);
			ItemGroup.add(NTMBlocks.SMOLDERING_NETHERRACK);
			ItemGroup.add(NTMBlocks.NETHER_COAL_ORE);
			ItemGroup.add(NTMBlocks.NETHER_URANIUM_ORE);
			ItemGroup.add(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE);
			ItemGroup.add(NTMBlocks.NETHER_PLUTONIUM_ORE);
			ItemGroup.add(NTMBlocks.NETHER_TUNGSTEN_ORE);
			ItemGroup.add(NTMBlocks.NETHER_SULFUR_ORE);
			ItemGroup.add(NTMBlocks.NETHER_COBALT_ORE);
			ItemGroup.add(NTMBlocks.NETHER_SCHRABIDIUM_ORE);
			ItemGroup.add(NTMBlocks.NETHER_DEPTH_ROCK);
			ItemGroup.add(NTMBlocks.NETHER_DEPTH_NEODYMIUM_ORE);
			ItemGroup.add(NTMBlocks.METEORITE_BLOCK);
			ItemGroup.add(NTMBlocks.BROKEN_METEORITE_BLOCK);
			ItemGroup.add(NTMBlocks.METEORITE_COBBLESTONE);
			ItemGroup.add(NTMBlocks.HOT_METEORITE_COBBLESTONE);
			ItemGroup.add(NTMBlocks.METEORITE_TREASURE_BLOCK);
			ItemGroup.add(NTMBlocks.METEOR_IRON_ORE);
			ItemGroup.add(NTMBlocks.METEOR_COPPER_ORE);
			ItemGroup.add(NTMBlocks.METEOR_ALUMINIUM_ORE);
			ItemGroup.add(NTMBlocks.METEOR_RARE_EARTH_ORE);
			ItemGroup.add(NTMBlocks.METEOR_COBALT_ORE);
			ItemGroup.add(NTMBlocks.GRAPHITIC_SCHIST);
			ItemGroup.add(NTMBlocks.SCHIST_IRON_ORE);
			ItemGroup.add(NTMBlocks.SCHIST_GOLD_ORE);
			ItemGroup.add(NTMBlocks.SCHIST_URANIUM_ORE);
			ItemGroup.add(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE);
			ItemGroup.add(NTMBlocks.SCHIST_COPPER_ORE);
			ItemGroup.add(NTMBlocks.SCHIST_ASBESTOS_ORE);
			ItemGroup.add(NTMBlocks.SCHIST_LITHIUM_ORE);
			ItemGroup.add(NTMBlocks.SCHIST_SCHRABIDIUM_ORE);
			ItemGroup.add(NTMBlocks.SCHIST_RARE_EARTH_ORE);
			ItemGroup.add(NTMBlocks.GAS_SHALE);
			ItemGroup.add(NTMBlocks.BAUXITE);
			ItemGroup.add(NTMBlocks.CHRYSOTILE);
			ItemGroup.add(NTMBlocks.HEMATITE);
			ItemGroup.add(NTMBlocks.LIMESTONE);
			ItemGroup.add(NTMBlocks.MALACHITE);
			ItemGroup.add(NTMBlocks.SULFUROUS_STONE);
			ItemGroup.add(NTMBlocks.TEKTITE);
			ItemGroup.add(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE);
			ItemGroup.add(NTMBlocks.TRIXITE_ORE);
			ItemGroup.add(NTMBlocks.GEOTHERMAL_VENT);
			ItemGroup.add(NTMBlocks.BEDROCK_OIL_DEPOSIT);
			ItemGroup.add(NTMBlocks.BEDROCK_ORE);
			ItemGroup.add(NTMItems.RAW_URANIUM);
			ItemGroup.add(NTMItems.RAW_SCORCHED_URANIUM);
			ItemGroup.add(NTMItems.RAW_PLUTONIUM);
			ItemGroup.add(NTMItems.RAW_THORIUM);
			ItemGroup.add(NTMItems.RAW_TITANIUM);
			ItemGroup.add(NTMItems.RAW_TUNGSTEN);
			ItemGroup.add(NTMItems.RAW_CRYOLITE);
			ItemGroup.add(NTMItems.RAW_BERYLLIUM);
			ItemGroup.add(NTMItems.RAW_LEAD);
			ItemGroup.add(NTMItems.RAW_SCHRABIDIUM);
			ItemGroup.add(NTMItems.RAW_AUSTRALIUM);
			ItemGroup.add(NTMItems.RAW_METEORIC_IRON);
			ItemGroup.add(NTMItems.RAW_METEORIC_COPPER);
			ItemGroup.add(NTMItems.RAW_METEORIC_ALUMINIUM);
			ItemGroup.add(NTMItems.RAW_METEORIC_RARE_EARTH);
			ItemGroup.add(NTMItems.RAW_METEORIC_COBALT);
			ItemGroup.add(NTMItems.RAW_TRIXITE);
			ItemGroup.add(NTMItems.RAW_OSMIRIDIUM_INFUSED_TEKTITE);

			ItemGroup.add(NTMBlocks.ACTINIUM_227_BLOCK);
			ItemGroup.add(NTMBlocks.ADVANCED_ALLOY_BLOCK);
			ItemGroup.add(NTMBlocks.ALUMINIUM_BLOCK);
			ItemGroup.add(NTMBlocks.ASBESTOS_BLOCK);
			ItemGroup.add(NTMBlocks.AUSTRALIUM_BLOCK);
			ItemGroup.add(NTMBlocks.BAKELITE_BLOCK);
			ItemGroup.add(NTMBlocks.BERYLLIUM_BLOCK);
			ItemGroup.add(NTMBlocks.BISMUTH_BLOCK);
			ItemGroup.add(NTMBlocks.BORON_BLOCK);
			ItemGroup.add(NTMBlocks.CADMIUM_BLOCK);
			ItemGroup.add(NTMBlocks.CADMIUM_STEEL_BLOCK);
			ItemGroup.add(NTMBlocks.CMB_STEEL_BLOCK);
			ItemGroup.add(NTMBlocks.COAL_COKE_BLOCK);
			ItemGroup.add(NTMBlocks.COBALT_BLOCK);
			ItemGroup.add(NTMBlocks.COLTAN_BLOCK);
			ItemGroup.add(NTMBlocks.DESH_BLOCK);
			ItemGroup.add(NTMBlocks.DINEUTRONIUM_BLOCK);
			ItemGroup.add(NTMBlocks.EUPHEMIUM_BLOCK);
			ItemGroup.add(NTMBlocks.FERRIC_SCHRABIDATE_BLOCK);
			ItemGroup.add(NTMBlocks.FLUORITE_BLOCK);
			ItemGroup.add(NTMBlocks.GRAPHITE_BLOCK);
			ItemGroup.add(NTMBlocks.HIGH_SPEED_STEEL_BLOCK);
			ItemGroup.add(NTMBlocks.LIGNITE_COKE_BLOCK);
			ItemGroup.add(NTMBlocks.LEAD_BLOCK);
			ItemGroup.add(NTMBlocks.LITHIUM_BLOCK);
			ItemGroup.add(NTMBlocks.MAGNETIZED_TUNGSTEN_BLOCK);
			ItemGroup.add(NTMBlocks.MOX_FUEL_BLOCK);
			ItemGroup.add(NTMBlocks.NEPTUNIUM_BLOCK);
			ItemGroup.add(NTMBlocks.NIOBIUM_BLOCK);
			ItemGroup.add(NTMBlocks.NITER_BLOCK);
			ItemGroup.add(NTMBlocks.PETROLEUM_COKE_BLOCK);
			ItemGroup.add(NTMBlocks.PLUTONIUM_BLOCK);
			ItemGroup.add(NTMBlocks.PLUTONIUM_FUEL_BLOCK);
			ItemGroup.add(NTMBlocks.REACTOR_GRADE_PLUTONIUM_BLOCK);
			ItemGroup.add(NTMBlocks.PLUTONIUM_238_BLOCK);
			ItemGroup.add(NTMBlocks.PLUTONIUM_239_BLOCK);
			ItemGroup.add(NTMBlocks.PLUTONIUM_240_BLOCK);
			ItemGroup.add(NTMBlocks.PLUTONIUM_241_BLOCK);
			ItemGroup.add(NTMBlocks.POLONIUM_210_BLOCK);
			ItemGroup.add(NTMBlocks.POLYMER_BLOCK);
			ItemGroup.add(NTMBlocks.RADIUM_226_BLOCK);
			ItemGroup.add(NTMBlocks.RED_COPPER_BLOCK);
			ItemGroup.add(NTMBlocks.RED_PHOSPHORUS_BLOCK);
			ItemGroup.add(NTMBlocks.RUBBER_BLOCK);
			ItemGroup.add(NTMBlocks.SCHRABIDIUM_BLOCK);
			ItemGroup.add(NTMBlocks.SCHRABIDIUM_FUEL_BLOCK);
			ItemGroup.add(NTMBlocks.SCHRARANIUM_BLOCK);
			ItemGroup.add(NTMBlocks.SEMTEX_BLOCK);
			ItemGroup.add(NTMBlocks.SOLINIUM_BLOCK);
			ItemGroup.add(NTMBlocks.STARMETAL_BLOCK);
			ItemGroup.add(NTMBlocks.STEEL_BLOCK);
			ItemGroup.add(NTMBlocks.SULFUR_BLOCK);
			ItemGroup.add(NTMBlocks.TANTALUM_BLOCK);
			ItemGroup.add(NTMBlocks.TECHNETIUM_STEEL_BLOCK);
			ItemGroup.add(NTMBlocks.THORIUM_232_BLOCK);
			ItemGroup.add(NTMBlocks.THORIUM_FUEL_BLOCK);
			ItemGroup.add(NTMBlocks.TITANIUM_BLOCK);
			ItemGroup.add(NTMBlocks.TUNGSTEN_BLOCK);
			ItemGroup.add(NTMBlocks.URANIUM_BLOCK);
			ItemGroup.add(NTMBlocks.URANIUM_FUEL_BLOCK);
			ItemGroup.add(NTMBlocks.URANIUM_233_BLOCK);
			ItemGroup.add(NTMBlocks.URANIUM_235_BLOCK);
			ItemGroup.add(NTMBlocks.URANIUM_238_BLOCK);
			ItemGroup.add(NTMBlocks.WHITE_PHOSPHORUS_BLOCK);
			ItemGroup.add(NTMBlocks.YELLOWCAKE_BLOCK);
			ItemGroup.add(NTMBlocks.ZIRCONIUM_BLOCK);
		});
		ItemGroupEvents.modifyEntriesEvent(MACHINES_KEY).register(ItemGroup -> {
			ItemGroup.add(NTMBlocks.TEMP_CABLE);
			ItemGroup.add(NTMBlocks.POTATO_BATTERY_BLOCK);
			ItemGroup.add(NTMBlocks.ENERGY_STORAGE_BLOCK);
			ItemGroup.add(NTMBlocks.LITHIUM_ION_ENERGY_STORAGE_BLOCK);
			ItemGroup.add(NTMBlocks.SCHRABIDIUM_ENERGY_STORAGE_BLOCK);
			ItemGroup.add(NTMBlocks.SPARK_ENERGY_STORAGE_BLOCK);
			ItemGroup.add(NTMBlocks.ALLOY_FURNACE);
			ItemGroup.add(NTMBlocks.ALLOY_FURNACE_EXTENSION);
			ItemGroup.add(NTMBlocks.ELECTRIC_FURNACE);
		});
		ItemGroupEvents.modifyEntriesEvent(BOMBS_KEY).register(ItemGroup -> {
			ItemGroup.add(NTMItems.NULL);
			ItemGroup.add(NTMItems.NULL);
		});
		ItemGroupEvents.modifyEntriesEvent(MISSILES_AND_SATELLITES_KEY).register(ItemGroup -> {
			ItemGroup.add(NTMItems.NULL);
			ItemGroup.add(NTMItems.NULL);
		});
		ItemGroupEvents.modifyEntriesEvent(WEAPONS_AND_TURRETS_KEY).register(ItemGroup -> {
			ItemGroup.add(NTMItems.NULL);
			ItemGroup.add(NTMItems.NULL);
		});
		ItemGroupEvents.modifyEntriesEvent(CONSUMABLES_AND_GEAR_KEY).register(ItemGroup -> {
			ItemGroup.add(NTMItems.DOSIMETER);
			ItemGroup.add(NTMItems.GEIGER_COUNTER);

			ItemGroup.add(NTMItems.EMPTY_SYRINGE);
			ItemGroup.add(NTMItems.POISONOUS_INJECTION);
			ItemGroup.add(NTMItems.ANTIDOTE);
			ItemGroup.add(NTMItems.AWESOME);
			ItemGroup.add(NTMItems.METAL_SYRINGE);
			ItemGroup.add(NTMItems.STIMPAK);
			ItemGroup.add(NTMItems.MED_X);
			ItemGroup.add(NTMItems.PSYCHO);
			ItemGroup.add(NTMItems.SUPER_STIMPAK);
			ItemGroup.add(NTMItems.WATERY_TAINT_INJECTION);
			ItemGroup.add(NTMItems.FIRST_AID_KIT);
			ItemGroup.add(NTMItems.IV_BAG);
			ItemGroup.add(NTMItems.BLOOD_BAG);
			ItemGroup.add(NTMItems.EMPTY_EXPERIENCE_BAG);
			ItemGroup.add(NTMItems.EXPERIENCE_BAG);
			ItemGroup.add(NTMItems.RAD_AWAY);
			ItemGroup.add(NTMItems.STRONG_RAD_AWAY);
			ItemGroup.add(NTMItems.ELITE_RAD_AWAY);
			ItemGroup.add(NTMItems.RAD_X);
			ItemGroup.add(NTMItems.IODINE_PILL);

			ItemGroup.add(NTMItems.PLAN_C);

			ItemGroup.add(NTMItems.WAFFLE_OF_MASS_DESTRUCTION);
			ItemGroup.add(NTMItems.VEGAN_SCHNITZEL);
			ItemGroup.add(NTMItems.RADIOACTIVE_COTTON_CANDY);
			ItemGroup.add(NTMItems.BASIC_LEAD_APPLE);
			ItemGroup.add(NTMItems.GOOD_LEAD_APPLE);
			ItemGroup.add(NTMItems.EPIC_LEAD_APPLE);
			ItemGroup.add(NTMItems.BASIC_SCHRABIDIUM_APPLE);
			ItemGroup.add(NTMItems.GOOD_SCHRABIDIUM_APPLE);
			ItemGroup.add(NTMItems.EPIC_SCHRABIDIUM_APPLE);
			ItemGroup.add(NTMItems.EUPHEMIUM_APPLE);
			ItemGroup.add(NTMItems.CHEAP_TEM_FLAKES);
			ItemGroup.add(NTMItems.TEM_FLAKES);
			ItemGroup.add(NTMItems.EXPENSIVE_TEM_FLAKES);
			ItemGroup.add(NTMItems.GLOWING_MUSHROOM_STEW);
			ItemGroup.add(NTMItems.SCRAMBLED_BALEFIRE_EGG);
			ItemGroup.add(NTMItems.SCRAMBLED_BALEFIRE_EGG_AND_HAM);
			ItemGroup.add(NTMItems.LEMON);
			ItemGroup.add(NTMItems.MRE);
			ItemGroup.add(NTMItems.LOOPS);
			ItemGroup.add(NTMItems.IT_BREAKFAST);
			ItemGroup.add(NTMItems.SPONGEBOB_MACARONI);
			ItemGroup.add(NTMItems.FOOD_ITEM);
			ItemGroup.add(NTMItems.TWINKIE);
			ItemGroup.add(NTMItems.TV_STATIC_SANDWICH);
			ItemGroup.add(NTMItems.PUDDING);
			ItemGroup.add(NTMItems.SCRAP_PANCAKE);
			ItemGroup.add(NTMItems.CHICKEN_NUGGET);
			ItemGroup.add(NTMItems.PEAS);
			ItemGroup.add(NTMItems.MARSHMALLOW_ON_A_STICK);
			ItemGroup.add(NTMItems.ROASTED_MARSHMALLOW_ON_A_STICK);
			ItemGroup.add(NTMItems.CHEESE);
			ItemGroup.add(NTMItems.CHEESE_QUESADILLA);
			ItemGroup.add(NTMItems.GLYPHID_MEAT);
			ItemGroup.add(NTMItems.GRILLED_GLYPHID_MEAT);
			ItemGroup.add(NTMItems.GLYPHID_EGG);
			ItemGroup.add(NTMItems.IPECAC_SYRUP);
			ItemGroup.add(NTMItems.PTSD_MEDICATION);
			ItemGroup.add(NTMItems.STYLISH_FLASK);
			ItemGroup.add(NTMItems.ARIZONA_MUCHO_MANGO);
			ItemGroup.add(NTMItems.RADIUM_CHOCOLATE);
			ItemGroup.add(NTMItems.EMPTY_CAN);
			ItemGroup.add(NTMItems.RING_PULL);
			ItemGroup.add(NTMItems.SMART_ENERGY_DRINK);
			ItemGroup.add(NTMItems.CREATURE_ENERGY_DRINK);
			ItemGroup.add(NTMItems.RED_BOMB_ENERGY_DRINK);
			ItemGroup.add(NTMItems.DR_SUGAR_SOFT_DRINK);
			ItemGroup.add(NTMItems.OVERCHARGE_DELIRIUM_XT);
			ItemGroup.add(NTMItems.BLACK_MESA_LUNA_DARK_COLA);
			ItemGroup.add(NTMItems.BEPIS);
			ItemGroup.add(NTMItems.DR_BREENS_PRIVATE_RESERVE);
			ItemGroup.add(NTMItems.MUG_ROOT_BEER);
			ItemGroup.add(NTMItems.COFFEE);
			ItemGroup.add(NTMItems.RADIUM_COFFEE);
			ItemGroup.add(NTMItems.EMPTY_BOTTLE);
			ItemGroup.add(NTMItems.EMPTY_BOMB_BOTTLE);
			ItemGroup.add(NTMItems.NUKA_COLA_BOTTLE_CAP);
			ItemGroup.add(NTMItems.NUKA_COLA_QUANTUM_BOTTLE_CAP);
			ItemGroup.add(NTMItems.S_COLA_BOTTLE_CAP);
			ItemGroup.add(NTMItems.S_COLA_RAD_BOTTLE_CAP);
			ItemGroup.add(NTMItems.KAROL_BOTTLE_CAP);
			ItemGroup.add(NTMItems.FRITZ_COLA_BOTTLE_CAP);
			ItemGroup.add(NTMItems.BOTTLE_OF_NUKA_COLA);
			ItemGroup.add(NTMItems.BOTTLE_OF_NUKA_CHERRY);
			ItemGroup.add(NTMItems.BOTTLE_OF_NUKA_COLA_QUANTUM);
			ItemGroup.add(NTMItems.BOTTLE_OF_S_COLA);
			ItemGroup.add(NTMItems.BOTTLE_OF_S_COLA_RAD);
			ItemGroup.add(NTMItems.BOTTLE_OF_KAROL);
			ItemGroup.add(NTMItems.FIRST_BOTTLE_OF_KAROL);
			ItemGroup.add(NTMItems.BOTTLE_OF_FRITZ_COLA);
			ItemGroup.add(NTMItems.FIRST_BOTTLE_OF_FRITZ_COLA);
			ItemGroup.add(NTMItems.BOTTLE_OPENER);

			ItemGroup.add(NTMItems.CONSTRUCTION_WAND);
			ItemGroup.add(NTMItems.DEBUG_WAND);
			ItemGroup.add(NTMItems.NETWORK_DEBUG_TOOL);
		});
		ItemGroupEvents.modifyEntriesEvent(TOOLS_KEY).register(ItemGroup -> {
			ItemGroup.add(NTMItems.STEEL_SWORD);
			ItemGroup.add(NTMItems.STEEL_SWORD);
			ItemGroup.add(NTMItems.STEEL_PICKAXE);
			ItemGroup.add(NTMItems.STEEL_AXE);
			ItemGroup.add(NTMItems.STEEL_SHOVEL);
			ItemGroup.add(NTMItems.STEEL_HOE);
			ItemGroup.add(NTMItems.TITANIUM_SWORD);
			ItemGroup.add(NTMItems.TITANIUM_PICKAXE);
			ItemGroup.add(NTMItems.TITANIUM_AXE);
			ItemGroup.add(NTMItems.TITANIUM_SHOVEL);
			ItemGroup.add(NTMItems.TITANIUM_HOE);
			ItemGroup.add(NTMItems.ADVANCED_ALLOY_SWORD);
			ItemGroup.add(NTMItems.ADVANCED_ALLOY_PICKAXE);
			ItemGroup.add(NTMItems.ADVANCED_ALLOY_AXE);
			ItemGroup.add(NTMItems.ADVANCED_ALLOY_SHOVEL);
			ItemGroup.add(NTMItems.ADVANCED_ALLOY_HOE);
			ItemGroup.add(NTMItems.CMB_STEEL_SWORD);
			ItemGroup.add(NTMItems.CMB_STEEL_PICKAXE);
			ItemGroup.add(NTMItems.CMB_STEEL_AXE);
			ItemGroup.add(NTMItems.CMB_STEEL_SHOVEL);
			ItemGroup.add(NTMItems.CMB_STEEL_HOE);
			ItemGroup.add(NTMItems.COBALT_SWORD);
			ItemGroup.add(NTMItems.COBALT_PICKAXE);
			ItemGroup.add(NTMItems.COBALT_AXE);
			ItemGroup.add(NTMItems.COBALT_SHOVEL);
			ItemGroup.add(NTMItems.COBALT_HOE);
			ItemGroup.add(NTMItems.DECORATED_COBALT_SWORD);
			ItemGroup.add(NTMItems.DECORATED_COBALT_PICKAXE);
			ItemGroup.add(NTMItems.DECORATED_COBALT_AXE);
			ItemGroup.add(NTMItems.DECORATED_COBALT_SHOVEL);
			ItemGroup.add(NTMItems.DECORATED_COBALT_HOE);
			ItemGroup.add(NTMItems.STARMETAL_SWORD);
			ItemGroup.add(NTMItems.STARMETAL_PICKAXE);
			ItemGroup.add(NTMItems.STARMETAL_AXE);
			ItemGroup.add(NTMItems.STARMETAL_SHOVEL);
			ItemGroup.add(NTMItems.STARMETAL_HOE);
			ItemGroup.add(NTMItems.DESH_SWORD);
			ItemGroup.add(NTMItems.DESH_PICKAXE);
			ItemGroup.add(NTMItems.DESH_AXE);
			ItemGroup.add(NTMItems.DESH_SHOVEL);
			ItemGroup.add(NTMItems.DESH_HOE);
			ItemGroup.add(NTMItems.SCHRABIDIUM_SWORD);
			ItemGroup.add(NTMItems.SCHRABIDIUM_PICKAXE);
			ItemGroup.add(NTMItems.SCHRABIDIUM_AXE);
			ItemGroup.add(NTMItems.SCHRABIDIUM_SHOVEL);
			ItemGroup.add(NTMItems.SCHRABIDIUM_HOE);
			ItemGroup.add(NTMItems.BISMUTH_PICKAXE);
			ItemGroup.add(NTMItems.BISMUTH_AXE);
			ItemGroup.add(NTMItems.MOLTEN_PICKAXE);
			ItemGroup.add(NTMItems.MOLTEN_AXE);
			ItemGroup.add(NTMItems.CHLOROPHYTE_PICKAXE);
			ItemGroup.add(NTMItems.CHLOROPHYTE_AXE);
			ItemGroup.add(NTMItems.MESE_PICKAXE);
			ItemGroup.add(NTMItems.MESE_AXE);
		});
	}

	private static <T extends Item> ItemStack charged(T item, long charge) {
		return component(item, NTMDataComponentTypes.ENERGY_COMPONENT_TYPE, charge);
	}

	private static <T> ItemStack component(ItemConvertible item, ComponentType<T> componentType, T value) {
		ItemStack stack = new ItemStack(item);
		stack.set(componentType, value);
		return stack;
	}
}
