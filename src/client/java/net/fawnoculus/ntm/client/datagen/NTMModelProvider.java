package net.fawnoculus.ntm.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceBlock;
import net.fawnoculus.ntm.blocks.custom.ElectricFurnaceBlock;
import net.fawnoculus.ntm.items.NTMItems;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;


public class NTMModelProvider extends FabricModelProvider {
	public NTMModelProvider(FabricDataOutput output) {
		super(output);
	}

	public static final TextureKey BARREL_TEXTURE_KEY = TextureKey.of("barrel");
	public static final TexturedModel.Factory SIMPLE_BARREL = TexturedModel.makeFactory(
	  block -> new TextureMap().put(BARREL_TEXTURE_KEY, TextureMap.getId(block)),
	  new Model(Optional.empty(), Optional.empty(), BARREL_TEXTURE_KEY)
	);

	public static final TextureMap EMPTY_BLOCK_TEXTURE = new TextureMap();
	public static final TexturedModel.Factory EMPTY_BLOCK_MODEL = TexturedModel.makeFactory(block -> EMPTY_BLOCK_TEXTURE, new Model(Optional.of(Identifier.ofVanilla("block/block")), Optional.empty()));


	public static final Model HANDHELD_LARGE = item("handheld_large", TextureKey.LAYER0);

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.URANIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_URANIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCORCHED_URANIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.TITANIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_TITANIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SULFUR_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_SULFUR_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.THORIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_THORIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NITER_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_NITER_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.TUNGSTEN_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.ALUMINIUM_BEARING_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.FLUORITE_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_FLUORITE_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.LEAD_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_LEAD_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCHRABIDIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.BERYLLIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.AUSTRALIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.RARE_EARTH_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.COBALT_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_COBALT_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.CINNEBAR_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_CINNEBAR_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.COLTAN_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_COLTAN_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.LIGNITE_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_LIGNITE_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.ASBESTOS_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_ASBESTOS_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.OIL_DEPOSIT);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_OIL_DEPOSIT);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.EMPTY_OIL_DEPOSIT);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_EMPTY_OIL_DEPOSIT);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.ALUMINIUM_ORE_CLUSTER);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_ALUMINIUM_ORE_CLUSTER);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.COPPER_ORE_CLUSTER);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_COPPER_ORE_CLUSTER);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.IRON_ORE_CLUSTER);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_IRON_ORE_CLUSTER);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.TITANIUM_ORE_CLUSTER);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_TITANIUM_ORE_CLUSTER);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEAD_DIRT);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.OILY_DIRT);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.OILY_SAND);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEPTH_ROCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEPTH_CINNABAR_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEPTH_ZIRCONIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEPTH_BORAX_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEPTH_IRON_ORE_CLUSTER);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEPTH_TITANIUM_ORE_CLUSTER);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.ALEXANDRITE_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DEEPSLATE_ALEXANDRITE_ORE);
		blockStateModelGenerator.registerSingleton(NTMBlocks.VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
		blockStateModelGenerator.registerSingleton(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
		blockStateModelGenerator.registerSingleton(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
		blockStateModelGenerator.registerSingleton(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
		blockStateModelGenerator.registerSingleton(NTMBlocks.GEM_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
		blockStateModelGenerator.registerSingleton(NTMBlocks.MOLYSITE_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SMOLDERING_NETHERRACK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NETHER_COAL_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NETHER_URANIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NETHER_PLUTONIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NETHER_TUNGSTEN_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NETHER_SULFUR_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NETHER_PHOSPHORUS_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NETHER_COBALT_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NETHER_SCHRABIDIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NETHER_DEPTH_ROCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NETHER_DEPTH_NEODYMIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.METEORITE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.BROKEN_METEORITE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.METEORITE_COBBLESTONE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.HOT_METEORITE_COBBLESTONE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.METEORITE_TREASURE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.METEOR_IRON_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.METEOR_COPPER_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.METEOR_ALUMINIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.METEOR_RARE_EARTH_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.METEOR_COBALT_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.GRAPHITIC_SCHIST);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCHIST_IRON_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCHIST_GOLD_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCHIST_URANIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCHIST_COPPER_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCHIST_ASBESTOS_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCHIST_LITHIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCHIST_SCHRABIDIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCHIST_RARE_EARTH_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.GAS_SHALE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.BAUXITE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.CHRYSOTILE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.HEMATITE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.LIMESTONE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.MALACHITE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SULFUROUS_STONE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.TEKTITE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.TRIXITE_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.GEOTHERMAL_VENT);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.BEDROCK_OIL_DEPOSIT);

		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.ACTINIUM_227_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.ADVANCED_ALLOY_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.ALUMINIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.ASBESTOS_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.AUSTRALIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.BAKELITE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.BERYLLIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.BISMUTH_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.BORON_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.CADMIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.CADMIUM_STEEL_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.CMB_STEEL_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.COAL_COKE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.COBALT_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.COLTAN_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DESH_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.DINEUTRONIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.EUPHEMIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.FERRIC_SCHRABIDATE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.FLUORITE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.GRAPHITE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.HIGH_SPEED_STEEL_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.LIGNITE_COKE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.LEAD_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.LITHIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.MAGNETIZED_TUNGSTEN_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.MOX_FUEL_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NEPTUNIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NIOBIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.NITER_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.PETROLEUM_COKE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.PLUTONIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.PLUTONIUM_FUEL_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.REACTOR_GRADE_PLUTONIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.PLUTONIUM_238_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.PLUTONIUM_239_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.PLUTONIUM_240_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.PLUTONIUM_241_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.POLONIUM_210_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.POLYMER_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.RADIUM_226_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.RED_COPPER_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.RED_PHOSPHORUS_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.RUBBER_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCHRABIDIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCHRABIDIUM_FUEL_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SCHRARANIUM_BLOCK);
		blockStateModelGenerator.registerSingleton(NTMBlocks.SEMTEX_BLOCK, TexturedModel.CUBE_TOP);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SOLINIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.STARMETAL_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.STEEL_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.SULFUR_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.TANTALUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.TECHNETIUM_STEEL_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.THORIUM_232_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.THORIUM_FUEL_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.TITANIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.TUNGSTEN_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.URANIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.URANIUM_FUEL_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.URANIUM_233_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.URANIUM_235_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.URANIUM_238_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.WHITE_PHOSPHORUS_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.YELLOWCAKE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(NTMBlocks.ZIRCONIUM_BLOCK);

		blockStateModelGenerator.registerSingleton(NTMBlocks.ALLOY_FURNACE_EXTENSION, EMPTY_BLOCK_MODEL);

    /* FIXME
    blockStateModelGenerator.registerSingleton(NTMBlocks.EXPLOSIVE_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.IMP_RESIDUE_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.KEROSENE_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.LOX_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.RADIOACTIVE_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.VITRIFIED_NUCLEAR_WASTE_DRUM, SIMPLE_BARREL);
    */

    /* FIXME
    blockStateModelGenerator.registerSingleton(NTMBlocks.CORRODED_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.SAFE_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.IRON_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.STEEL_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.TECHNETIUM_STEEL_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.MAGNETIC_BARREL, SIMPLE_BARREL);
   */

		registerSimpleHorizontalOrientable(blockStateModelGenerator, NTMBlocks.POTATO_BATTERY_BLOCK);
		registerSimpleHorizontalOrientable(blockStateModelGenerator, NTMBlocks.ENERGY_STORAGE_BLOCK);
		registerSimpleHorizontalOrientable(blockStateModelGenerator, NTMBlocks.LITHIUM_ION_ENERGY_STORAGE_BLOCK);
		registerSimpleHorizontalOrientable(blockStateModelGenerator, NTMBlocks.SCHRABIDIUM_ENERGY_STORAGE_BLOCK);
		registerSimpleHorizontalOrientable(blockStateModelGenerator, NTMBlocks.SPARK_ENERGY_STORAGE_BLOCK);


		TextureMap alloyFurnaceTextureMap = new TextureMap()
		  .put(TextureKey.TOP, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_top"))
		  .put(TextureKey.SIDE, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_side"))
		  .put(TextureKey.FRONT, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_front"))
		  .put(TextureKey.BOTTOM, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_bottom"));
		TextureMap litAlloyFurnaceTextureMap = new TextureMap()
		  .put(TextureKey.TOP, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_top_lit"))
		  .put(TextureKey.SIDE, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_side"))
		  .put(TextureKey.FRONT, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_front_lit"))
		  .put(TextureKey.BOTTOM, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_bottom"));
		TextureMap tallAlloyFurnaceTextureMap = new TextureMap()
		  .put(TextureKey.TOP, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_top"))
		  .put(TextureKey.SIDE, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_side_tall"))
		  .put(TextureKey.FRONT, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_front_tall"))
		  .put(TextureKey.BOTTOM, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_bottom"));
		TextureMap litTallAlloyFurnaceTextureMap = new TextureMap()
		  .put(TextureKey.TOP, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_top_lit"))
		  .put(TextureKey.SIDE, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_side_tall"))
		  .put(TextureKey.FRONT, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_front_lit_tall"))
		  .put(TextureKey.BOTTOM, TextureMap.getSubId(NTMBlocks.ALLOY_FURNACE, "_bottom"));

		WeightedVariant alloyFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(Models.ORIENTABLE_WITH_BOTTOM.upload(NTMBlocks.ALLOY_FURNACE, "", alloyFurnaceTextureMap, blockStateModelGenerator.modelCollector));
		WeightedVariant litAlloyFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(blockStateModelGenerator.createSubModel(NTMBlocks.ALLOY_FURNACE, "_lit", Models.ORIENTABLE_WITH_BOTTOM, a -> litAlloyFurnaceTextureMap));
		WeightedVariant tallAlloyFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(blockStateModelGenerator.createSubModel(NTMBlocks.ALLOY_FURNACE, "_tall", Models.ORIENTABLE_WITH_BOTTOM, a -> tallAlloyFurnaceTextureMap));
		WeightedVariant litTallAlloyFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(blockStateModelGenerator.createSubModel(NTMBlocks.ALLOY_FURNACE, "_lit_tall", Models.ORIENTABLE_WITH_BOTTOM, a -> litTallAlloyFurnaceTextureMap));
		blockStateModelGenerator.blockStateCollector
		  .accept(
			VariantsBlockModelDefinitionCreator.of(NTMBlocks.ALLOY_FURNACE)
			  .with(
				BlockStateVariantMap.models(AlloyFurnaceBlock.FACING, AlloyFurnaceBlock.LIT, AlloyFurnaceBlock.EXTENSION)
				  .register(Direction.NORTH, false, false, alloyFurnaceweightedVariant)
				  .register(Direction.EAST, false, false, alloyFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_90))
				  .register(Direction.SOUTH, false, false, alloyFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_180))
				  .register(Direction.WEST, false, false, alloyFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_270))
				  .register(Direction.NORTH, true, false, litAlloyFurnaceweightedVariant)
				  .register(Direction.EAST, true, false, litAlloyFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_90))
				  .register(Direction.SOUTH, true, false, litAlloyFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_180))
				  .register(Direction.WEST, true, false, litAlloyFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_270))
				  .register(Direction.NORTH, false, true, tallAlloyFurnaceweightedVariant)
				  .register(Direction.EAST, false, true, tallAlloyFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_90))
				  .register(Direction.SOUTH, false, true, tallAlloyFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_180))
				  .register(Direction.WEST, false, true, tallAlloyFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_270))
				  .register(Direction.NORTH, true, true, litTallAlloyFurnaceweightedVariant)
				  .register(Direction.EAST, true, true, litTallAlloyFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_90))
				  .register(Direction.SOUTH, true, true, litTallAlloyFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_180))
				  .register(Direction.WEST, true, true, litTallAlloyFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_270))
			  )
		  );

		TextureMap electricFurnaceTextureMap = new TextureMap()
		  .put(TextureKey.TOP, TextureMap.getSubId(NTMBlocks.ELECTRIC_FURNACE, "_top"))
		  .put(TextureKey.SIDE, TextureMap.getSubId(NTMBlocks.ELECTRIC_FURNACE, "_side"))
		  .put(TextureKey.FRONT, TextureMap.getSubId(NTMBlocks.ELECTRIC_FURNACE, "_front"))
		  .put(TextureKey.BOTTOM, TextureMap.getSubId(NTMBlocks.ELECTRIC_FURNACE, "_bottom"));
		TextureMap litElectricFurnaceTextureMap = new TextureMap()
		  .put(TextureKey.TOP, TextureMap.getSubId(NTMBlocks.ELECTRIC_FURNACE, "_top"))
		  .put(TextureKey.SIDE, TextureMap.getSubId(NTMBlocks.ELECTRIC_FURNACE, "_side"))
		  .put(TextureKey.FRONT, TextureMap.getSubId(NTMBlocks.ELECTRIC_FURNACE, "_front_lit"))
		  .put(TextureKey.BOTTOM, TextureMap.getSubId(NTMBlocks.ELECTRIC_FURNACE, "_bottom"));
		WeightedVariant electricFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(Models.ORIENTABLE_WITH_BOTTOM.upload(NTMBlocks.ELECTRIC_FURNACE, "", electricFurnaceTextureMap, blockStateModelGenerator.modelCollector));
		WeightedVariant litElectricFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(blockStateModelGenerator.createSubModel(NTMBlocks.ELECTRIC_FURNACE, "_lit", Models.ORIENTABLE_WITH_BOTTOM, a -> litElectricFurnaceTextureMap));
		blockStateModelGenerator.blockStateCollector
		  .accept(
			VariantsBlockModelDefinitionCreator.of(NTMBlocks.ELECTRIC_FURNACE)
			  .with(
				BlockStateVariantMap.models(ElectricFurnaceBlock.FACING, ElectricFurnaceBlock.LIT)
				  .register(Direction.NORTH, false, electricFurnaceweightedVariant)
				  .register(Direction.EAST, false, electricFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_90))
				  .register(Direction.SOUTH, false, electricFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_180))
				  .register(Direction.WEST, false, electricFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_270))
				  .register(Direction.NORTH, true, litElectricFurnaceweightedVariant)
				  .register(Direction.EAST, true, litElectricFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_90))
				  .register(Direction.SOUTH, true, litElectricFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_180))
				  .register(Direction.WEST, true, litElectricFurnaceweightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_270))
			  )
		  );
		registerSimpleHorizontalOrientable(blockStateModelGenerator, NTMBlocks.PWR_CONTROLLER);
	}

	private static void registerSimpleHorizontalOrientable(@NotNull BlockStateModelGenerator blockStateModelGenerator, Block block) {
		WeightedVariant weightedVariant = BlockStateModelGenerator.createWeightedVariant(TexturedModel.ORIENTABLE.upload(block, blockStateModelGenerator.modelCollector));
		blockStateModelGenerator.blockStateCollector
		  .accept(
			VariantsBlockModelDefinitionCreator.of(block)
			  .with(
				BlockStateVariantMap.models(Properties.HORIZONTAL_FACING)
				  .register(Direction.NORTH, weightedVariant)
				  .register(Direction.EAST, weightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_90))
				  .register(Direction.SOUTH, weightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_180))
				  .register(Direction.WEST, weightedVariant.apply(BlockStateModelGenerator.ROTATE_Y_270))
			  )
		  );
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		// Basic Items
		itemModelGenerator.register(NTMItems.NULL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_238_RTG_PELLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TUNGSTEN_REACHER, Models.GENERATED);

		// Raw Resources
		itemModelGenerator.register(NTMItems.ACTINIUM_227_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ACTINIUM_227_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ACTINIUM_227_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_ACTINIUM_227_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ACTINIUM_227_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ACTINIUM_227_FRAGMENT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.ADVANCED_ALLOY_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ADVANCED_ALLOY_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ADVANCED_ALLOY_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_ADVANCED_ALLOY_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ADVANCED_ALLOY_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_ADVANCED_ALLOY_WIRE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.ALEXANDRITE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_METEORIC_ALUMINIUM, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ALUMINIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ALUMINIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ALUMINIUM_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_ALUMINIUM_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WELDED_ALUMINIUM_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ALUMINIUM_SHELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ALUMINIUM_PIPE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ALUMINIUM_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ALUMINIUM_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.AMERICIUM_241_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AMERICIUM_241_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AMERICIUM_241_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AMERICIUM_242_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AMERICIUM_242_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AMERICIUM_242_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AMERICIUM_FUEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AMERICIUM_FUEL_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AMERICIUM_FUEL_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.REACTOR_GRADE_AMERICIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.REACTOR_GRADE_AMERICIUM_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.REACTOR_GRADE_AMERICIUM_ZFB_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.REACTOR_GRADE_AMERICIUM_NUGGET, Models.GENERATED);

		itemModelGenerator.register(NTMItems.ARSENIC_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ARSENIC_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ARSENIC_BRONZE_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_ARSENIC_BRONZE_PLATE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.ASBESTOS_SHEET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ASBESTOS_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.ASTATINE_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ASTATINE_209_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.ASH, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WOOD_ASH, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COAL_ASH, Models.GENERATED);
		itemModelGenerator.register(NTMItems.FLY_ASH, Models.GENERATED);
		itemModelGenerator.register(NTMItems.FINE_SOOT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_AUSTRALIUM, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AUSTRALIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AUSTRALIUM_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AUSTRALIUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LESSER_AUSTRALIUM_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LESSER_AUSTRALIUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GREATER_AUSTRALIUM_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GREATER_AUSTRALIUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AUSTRALIUM_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.BAKELITE_BAR, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BAKELITE_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.BALEFIRE_EGG, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BALEFIRE_SHARD, Models.GENERATED);
		itemModelGenerator.register(NTMItems.THERMONUCLEAR_ASHES, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_BERYLLIUM, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BERYLLIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BERYLLIUM_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BERYLLIUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BERYLLIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BERYLLIUM_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.BISMUTH_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BISMUTH_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BISMUTH_ZFB_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BISMUTH_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BISMUTH_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BISMUTH_BRONZE_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_BISMUTH_BRONZE_PLATE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.BORAX_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.BORON_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BORON_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_BORON_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BORON_FRAGMENT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.BROMINE_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.BSCCO_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_BSCCO_WIRE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.CADMIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CADMIUM_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.CAESIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAESIUM_137_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_CAESIUM_137_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.CALCIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CALCIUM_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.CADMIUM_STEEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_CADMIUM_STEEL_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WELDED_CADMIUM_STEEL_PLATE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.CEMENT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.CERIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_CERIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CERIUM_FRAGMENT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.CHLOROCALCITE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.CHLOROPHYTE_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.CINNABAR, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CINNABAR_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.CMB_STEEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CMB_STEEL_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_CMB_STEEL_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WELDED_CMB_STEEL_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CMB_STEEL_PLATE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.COAL_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_COAL_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CARBON_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COAL_BRIQUETTE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COAL_COKE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.COBALT_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COBALT_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COBALT_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COBALT_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_COBALT_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COBALT_60_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COBALT_60_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COBALT_60_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COBALT_60_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COBALT_FRAGMENT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COBALT_CRYSTALS, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RAW_METEORIC_COBALT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.COLTAN, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CRUSHED_COLTAN, Models.GENERATED);

		itemModelGenerator.register(NTMItems.COPPER_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COPPER_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_COPPER_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WELDED_COPPER_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COPPER_PIPE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COPPER_SHELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COPPER_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_COPPER_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COPPER_CRYSTALS, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RAW_METEORIC_COPPER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.CRYO_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_CRYOLITE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CRYOLITE_CHUNK, Models.GENERATED);

		itemModelGenerator.register(NTMItems.DESH_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DESH_BLEND, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DESHREADY_BLEND, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DESH_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DESH_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_DESH_PLATE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.DIAMOND_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DIAMOND_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.DINEUTRONIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DINEUTRONIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DINEUTRONIUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_DINEUTRONIUM_WIRE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.ELECTRONIUM_INGOT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.EMERALD_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.ENERGY_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.EUPHEMIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.EUPHEMIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.EUPHEMIUM_NUGGET, Models.GENERATED);

		itemModelGenerator.register(NTMItems.FERRIC_SCHARBIDATE_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.FERRIC_SCHARBIDATE_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_FERRIC_SCHARBIDATE_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_FERRIC_SCHARBIDATE_WIRE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.FERROURANIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_FERROURANIUM_PLATE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.FLASH_GOLD, Models.GENERATED);

		itemModelGenerator.register(NTMItems.FLASH_LEAD, Models.GENERATED);

		itemModelGenerator.register(NTMItems.FLUORITE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.FLUORITE_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.FLUX, Models.GENERATED);

		itemModelGenerator.register(NTMItems.FULLERENE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CRYSTALLINE_FULLERENE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.GHIORSIUM_336_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GHIORSIUM_336_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GHIORSIUM_336_NUGGET, Models.GENERATED);

		itemModelGenerator.register(NTMItems.GOLD_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GOLD_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_GOLD_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GOLD_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_GOLD_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GOLD_CRYSTALS, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GOLD_198_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GOLD_198_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GOLD_198_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GOLD_198_NUGGET, Models.GENERATED);

		itemModelGenerator.register(NTMItems.GRAPHITE_INGOT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.GUNMETAL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GUNMETAL_PLATE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.HARD_PLASTIC_BAR, Models.GENERATED);

		itemModelGenerator.register(NTMItems.HIGH_SPEED_STEEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.HIGH_SPEED_STEEL_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_HIGH_SPEED_STEEL_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.HIGH_SPEED_STEEL_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.HIGH_SPEED_STEEL_BOLT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.HIGH_SPEED_STEEL_PIPE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.IODINE_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.IODINE_131_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_IODINE_131_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.IRON_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.IRON_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_IRON_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WELDED_IRON_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.IRON_PIPE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.IRON_CRYSTALS, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RAW_METEORIC_IRON, Models.GENERATED);

		itemModelGenerator.register(NTMItems.INDUSTRIAL_FERTILIZER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.INFERNAL_COAL, Models.GENERATED);

		itemModelGenerator.register(NTMItems.SEMI_STABLE_LANTHANUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LANTHANUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_LANTHANUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LANTHANUM_FRAGMENT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.LAPIS_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LAPIS_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.LATEX, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LATEX_BAR, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_LEAD, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LEAD_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LEAD_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LEAD_209_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LEAD_209_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LEAD_209_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LEAD_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LEAD_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_LEAD_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LEAD_PIPE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LEAD_BOLT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LEAD_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LEAD_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.LIGNITE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LIGNITE_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LIGNITE_COKE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LIGNITE_BRIQUETTE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.LIMESTONE_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.LITHIUM_CUBE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LITHIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_LITHIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LITHIUM_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.MAGNETIZED_TUNGSTEN_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.MAGNETIZED_TUNGSTEN_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.MAGNETIZED_TUNGSTEN_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_MAGNETIZED_TUNGSTEN_WIRE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.METEORITE_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.METEORITE_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_METEORITE_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.METEORITE_FRAGMENT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.MOLYSITE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.MOX_FUEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.MOX_FUEL_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.MOX_FUEL_NUGGET, Models.GENERATED);

		itemModelGenerator.register(NTMItems.NEODYMIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_NEODYMIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_NEODYMIUM_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NEODYMIUM_FRAGMENT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.NEPTUNIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NEPTUNIUM_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NEPTUNIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NEPTUNIUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NEPTUNIUM_FUEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NEPTUNIUM_FUEL_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NEPTUNIUM_FUEL_NUGGET, Models.GENERATED);

		itemModelGenerator.register(NTMItems.NIOBIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NIOBIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_NIOBIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NIOBIUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_NIOBIUM_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NIOBIUM_FRAGMENT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.NITAN_BLEND, Models.GENERATED);

		itemModelGenerator.register(NTMItems.NITER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NITER_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.NITRA, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SMALL_PILE_OF_NITRA, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_OSMIRIDIUM_INFUSED_TEKTITE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.OSMIRIDIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.OSMIRIDIUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.IMPURE_OSMIRIDIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_OSMIRIDIUM_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WELDED_OSMIRIDIUM_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.OSMIRIDIUM_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.PALEOGENITE_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_PALEOGENITE_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RED_PHOSPHORUS, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WHITE_PHOSPHORUS_BAR, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PHOSPHORUS_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.PETROLEUM_COKE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_PLUTONIUM, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_FUEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_FUEL_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_FUEL_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.REACTOR_GRADE_PLUTONIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.REACTOR_GRADE_PLUTONIUM_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.REACTOR_GRADE_PLUTONIUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_238_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_238_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_238_BE_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_238_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_239_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_239_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_239_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_240_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_240_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_240_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_241_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_241_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_241_ZFB_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_241_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PLUTONIUM_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.POISON_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.POLONIUM_210_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.POLONIUM_210_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.POLONIUM_210_BE_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.POLONIUM_210_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.POLONIUM_210_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.POLYMER_BAR, Models.GENERATED);
		itemModelGenerator.register(NTMItems.POLYMER_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.PULVERIZED_ENCHANTMENT, Models.GENERATED);

		itemModelGenerator.register(NTMItems.PVC_BAR, Models.GENERATED);

		itemModelGenerator.register(NTMItems.QUARTZ_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RADIUM_226_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RADIUM_226_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RADIUM_226_BE_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RADIUM_226_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RADIUM_226_NUGGET, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RARE_EARTH_ORE_CHUNK, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RARE_EARTH_CRYSTALS, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RAW_METEORIC_RARE_EARTH, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RED_COPPER_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RED_COPPER_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RED_COPPER_WIRE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.REDSTONE_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RUBBER_BAR, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RUBBER_PIPE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.SATURNITE_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SATURNITE_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_SATURNITE_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SATURNITE_SHELL, Models.GENERATED);

		itemModelGenerator.register(NTMItems.SAWDUST_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SAWDUST_BRIQUETTE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_SCHRABIDIUM, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_FUEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_FUEL_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_FUEL_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_SCHRABIDIUM_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_SCHRABIDIUM_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.SCHRARANIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRARANIUM_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.SEMTEX_BLEND, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SEMTEX_BAR, Models.GENERATED);

		itemModelGenerator.register(NTMItems.SILICON_BOULE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SILICON_WAFER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PRINTED_SILICON_WAFER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SILICON_NUGGET, Models.GENERATED);

		itemModelGenerator.register(NTMItems.SODIUM_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.SOLINIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SOLINIUM_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SOLINIUM_NUGGET, Models.GENERATED);

		itemModelGenerator.register(NTMItems.SPARK_BLEND, Models.GENERATED);

		itemModelGenerator.register(NTMItems.STARMETAL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_STARMETAL_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STARMETAL_RING, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STARMETAL_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.STRONTIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STRONTIUM_90_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STRONTIUM_90_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STRONTIUM_90_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_STRONTIUM_90_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STRONTIUM_90_NUGGET, Models.GENERATED);

		itemModelGenerator.register(NTMItems.STEEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STEEL_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_STEEL_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STEEL_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_STEEL_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WELDED_STEEL_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STEEL_BOLT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STEEL_PIPE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STEEL_SHELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STEEL_WIRE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.SULFUR, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SULFUR_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.PURIFIED_TANTALITE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TANTALUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TANTALUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TANTALUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TANTALUM_POLYCRYSTAL, Models.GENERATED);

		itemModelGenerator.register(NTMItems.TECHNETIUM_99_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TECHNETIUM_99_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TECHNETIUM_99_NUGGET, Models.GENERATED);

		itemModelGenerator.register(NTMItems.TECHNETIUM_STEEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TECHNETIUM_STEEL_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_TECHNETIUM_STEEL_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WELDED_TECHNETIUM_STEEL_PLATE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.TEKTITE_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.TENNESSINE_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.THERMITE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_THORIUM, Models.GENERATED);
		itemModelGenerator.register(NTMItems.THORIUM_232_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.THORIUM_FUEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.THORIUM_232_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.THORIUM_FUEL_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.THORIUM_232_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.THORIUM_FUEL_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.THORIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.THORIUM_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_TITANIUM, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TITANIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TITANIUM_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_TITANIUM_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WELDED_TITANIUM_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TITANIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TITANIUM_SHELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_TITANIUM_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TITANIUM_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_TRIXITE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TRIXITE_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_TUNGSTEN, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TUNGSTEN_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TUNGSTEN_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TUNGSTEN_BOLT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TUNGSTEN_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DENSE_TUNGSTEN_WIRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TUNGSTEN_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.RAW_URANIUM, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RAW_SCORCHED_URANIUM, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_FUEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_FUEL_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_FUEL_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_233_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_233_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_233_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_235_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_235_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_235_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_238_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_238_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_238_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.URANIUM_CRYSTALS, Models.GENERATED);

		itemModelGenerator.register(NTMItems.VOLCANIC_GEM, Models.GENERATED);

		itemModelGenerator.register(NTMItems.WEAPON_STEEL_INGOT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WEAPON_STEEL_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_WEAPON_STEEL_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WEAPON_STEEL_SHELL, Models.GENERATED);

		itemModelGenerator.register(NTMItems.XENON_135_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TINY_PILE_OF_XENON_135_POWDER, Models.GENERATED);

		itemModelGenerator.register(NTMItems.YHARONITE_BILLET, Models.GENERATED);

		itemModelGenerator.register(NTMItems.YELLOWCAKE, Models.GENERATED);

		itemModelGenerator.register(NTMItems.ZIRCONIUM_SPLINTER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ZIRCONIUM_CUBE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ZIRCONIUM_BILLET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ZIRCONIUM_POWDER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CAST_ZIRCONIUM_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WELDED_ZIRCONIUM_PLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ZIRCONIUM_WIRE, Models.GENERATED);

		// Usable Items
		itemModelGenerator.register(NTMItems.DEBUG_WAND, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CONSTRUCTION_WAND, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NETWORK_DEBUG_TOOL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GEIGER_COUNTER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DOSIMETER, Models.GENERATED);

		// Batteries
		itemModelGenerator.register(NTMItems.BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.REDSTONE_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SIXFOLD_REDSTONE_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TWENTY_FOUR_FOLD_REDSTONE_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ADVANCED_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ADVANCED_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.QUADRUPLE_ADVANCED_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TWELVEFOLD_ADVANCED_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LITHIUM_ION_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LITHIUM_ION_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TRIPLE_LITHIUM_ION_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SIXFOLD_LITHIUM_ION_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DOUBLE_SCHRABIDIUM_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.QUADRUPLE_SCHRABIDIUM_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SPARK_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.OFF_BRAND_SPARK_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SPARK_POWER_CELL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SPARK_ARCANE_CAR_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SPARK_ARCANE_ENERGY_STORAGE_ARRAY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SPARK_ARCANE_MASS_ENERGY_VOID, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SPARK_ARCANE_DIRAC_SEA, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SPARK_SOLID_SPACE_TIME_CRYSTAL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SPARK_LUDICROUS_ENERGY_STORAGE_UNIT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ELECTRONIUM_CUBE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.INFINITE_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.POTATO_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.POTATOS, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SELF_CHARGING_URANIUM_238_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SELF_CHARGING_TECHNETIUM_99_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SELF_CHARGING_PLUTONIUM_238_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SELF_CHARGING_POLONIUM_210_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SELF_CHARGING_GOLD_198_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SELF_CHARGING_LEAD_209_BATTERY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SELF_CHARGING_AMERICIUM_241_BATTERY, Models.GENERATED);

		// Consumables
		itemModelGenerator.register(NTMItems.EMPTY_SYRINGE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.POISONOUS_INJECTION, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ANTIDOTE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.AWESOME, Models.GENERATED);
		itemModelGenerator.register(NTMItems.METAL_SYRINGE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STIMPAK, Models.GENERATED);
		itemModelGenerator.register(NTMItems.MED_X, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PSYCHO, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SUPER_STIMPAK, Models.GENERATED);
		itemModelGenerator.register(NTMItems.WATERY_TAINT_INJECTION, Models.GENERATED);
		itemModelGenerator.register(NTMItems.FIRST_AID_KIT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.IV_BAG, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BLOOD_BAG, Models.GENERATED);
		itemModelGenerator.register(NTMItems.EMPTY_EXPERIENCE_BAG, Models.GENERATED);
		itemModelGenerator.register(NTMItems.EXPERIENCE_BAG, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RAD_AWAY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STRONG_RAD_AWAY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ELITE_RAD_AWAY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RAD_X, Models.GENERATED);
		itemModelGenerator.register(NTMItems.IODINE_PILL, Models.GENERATED);

		itemModelGenerator.register(NTMItems.PLAN_C, Models.GENERATED);

		itemModelGenerator.register(NTMItems.WAFFLE_OF_MASS_DESTRUCTION, Models.GENERATED);
		itemModelGenerator.register(NTMItems.VEGAN_SCHNITZEL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RADIOACTIVE_COTTON_CANDY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BASIC_LEAD_APPLE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GOOD_LEAD_APPLE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.EPIC_LEAD_APPLE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BASIC_SCHRABIDIUM_APPLE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GOOD_SCHRABIDIUM_APPLE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.EPIC_SCHRABIDIUM_APPLE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.EUPHEMIUM_APPLE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CHEAP_TEM_FLAKES, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TEM_FLAKES, Models.GENERATED);
		itemModelGenerator.register(NTMItems.EXPENSIVE_TEM_FLAKES, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GLOWING_MUSHROOM_STEW, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCRAMBLED_BALEFIRE_EGG, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCRAMBLED_BALEFIRE_EGG_AND_HAM, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LEMON, Models.GENERATED);
		itemModelGenerator.register(NTMItems.MRE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.LOOPS, Models.GENERATED);
		itemModelGenerator.register(NTMItems.IT_BREAKFAST, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SPONGEBOB_MACARONI, Models.GENERATED);
		itemModelGenerator.register(NTMItems.FOOD_ITEM, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TWINKIE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.TV_STATIC_SANDWICH, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PUDDING, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SCRAP_PANCAKE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CHICKEN_NUGGET, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PEAS, Models.GENERATED);
		itemModelGenerator.register(NTMItems.MARSHMALLOW_ON_A_STICK, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ROASTED_MARSHMALLOW_ON_A_STICK, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CHEESE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CHEESE_QUESADILLA, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GLYPHID_MEAT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GRILLED_GLYPHID_MEAT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.GLYPHID_EGG, Models.GENERATED);
		itemModelGenerator.register(NTMItems.IPECAC_SYRUP, Models.GENERATED);
		itemModelGenerator.register(NTMItems.PTSD_MEDICATION, Models.GENERATED);
		itemModelGenerator.register(NTMItems.STYLISH_FLASK, Models.GENERATED);
		itemModelGenerator.register(NTMItems.ARIZONA_MUCHO_MANGO, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RADIUM_CHOCOLATE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.EMPTY_CAN, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RING_PULL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.SMART_ENERGY_DRINK, Models.GENERATED);
		itemModelGenerator.register(NTMItems.CREATURE_ENERGY_DRINK, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RED_BOMB_ENERGY_DRINK, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DR_SUGAR_SOFT_DRINK, Models.GENERATED);
		itemModelGenerator.register(NTMItems.OVERCHARGE_DELIRIUM_XT, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BLACK_MESA_LUNA_DARK_COLA, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BEPIS, Models.GENERATED);
		itemModelGenerator.register(NTMItems.DR_BREENS_PRIVATE_RESERVE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.MUG_ROOT_BEER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.COFFEE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.RADIUM_COFFEE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BOTTLE_OPENER, Models.GENERATED);
		itemModelGenerator.register(NTMItems.EMPTY_BOTTLE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.EMPTY_BOMB_BOTTLE, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NUKA_COLA_BOTTLE_CAP, Models.GENERATED);
		itemModelGenerator.register(NTMItems.NUKA_COLA_QUANTUM_BOTTLE_CAP, Models.GENERATED);
		itemModelGenerator.register(NTMItems.S_COLA_BOTTLE_CAP, Models.GENERATED);
		itemModelGenerator.register(NTMItems.S_COLA_RAD_BOTTLE_CAP, Models.GENERATED);
		itemModelGenerator.register(NTMItems.KAROL_BOTTLE_CAP, Models.GENERATED);
		itemModelGenerator.register(NTMItems.FRITZ_COLA_BOTTLE_CAP, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BOTTLE_OF_NUKA_COLA, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BOTTLE_OF_NUKA_CHERRY, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BOTTLE_OF_NUKA_COLA_QUANTUM, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BOTTLE_OF_S_COLA, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BOTTLE_OF_S_COLA_RAD, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BOTTLE_OF_KAROL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.FIRST_BOTTLE_OF_KAROL, Models.GENERATED);
		itemModelGenerator.register(NTMItems.BOTTLE_OF_FRITZ_COLA, Models.GENERATED);
		itemModelGenerator.register(NTMItems.FIRST_BOTTLE_OF_FRITZ_COLA, Models.GENERATED);

		// Tools
		itemModelGenerator.register(NTMItems.STEEL_SWORD, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.STEEL_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.STEEL_AXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.STEEL_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.STEEL_HOE, Models.HANDHELD);

		itemModelGenerator.register(NTMItems.TITANIUM_SWORD, HANDHELD_LARGE);
		itemModelGenerator.register(NTMItems.TITANIUM_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.TITANIUM_AXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.TITANIUM_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.TITANIUM_HOE, Models.HANDHELD);

		itemModelGenerator.register(NTMItems.ADVANCED_ALLOY_SWORD, HANDHELD_LARGE);
		itemModelGenerator.register(NTMItems.ADVANCED_ALLOY_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.ADVANCED_ALLOY_AXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.ADVANCED_ALLOY_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.ADVANCED_ALLOY_HOE, Models.HANDHELD);

		itemModelGenerator.register(NTMItems.CMB_STEEL_SWORD, HANDHELD_LARGE);
		itemModelGenerator.register(NTMItems.CMB_STEEL_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.CMB_STEEL_AXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.CMB_STEEL_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.CMB_STEEL_HOE, Models.HANDHELD);

		itemModelGenerator.register(NTMItems.DESH_SWORD, HANDHELD_LARGE);
		itemModelGenerator.register(NTMItems.DESH_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.DESH_AXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.DESH_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.DESH_HOE, Models.HANDHELD);

		itemModelGenerator.register(NTMItems.COBALT_SWORD, HANDHELD_LARGE);
		itemModelGenerator.register(NTMItems.COBALT_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.COBALT_AXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.COBALT_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.COBALT_HOE, Models.HANDHELD);

		itemModelGenerator.register(NTMItems.DECORATED_COBALT_SWORD, HANDHELD_LARGE);
		itemModelGenerator.register(NTMItems.DECORATED_COBALT_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.DECORATED_COBALT_AXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.DECORATED_COBALT_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.DECORATED_COBALT_HOE, Models.HANDHELD);

		itemModelGenerator.register(NTMItems.STARMETAL_SWORD, HANDHELD_LARGE);
		itemModelGenerator.register(NTMItems.STARMETAL_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.STARMETAL_AXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.STARMETAL_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.STARMETAL_HOE, Models.HANDHELD);

		itemModelGenerator.register(NTMItems.SCHRABIDIUM_SWORD, HANDHELD_LARGE);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_AXE, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(NTMItems.SCHRABIDIUM_HOE, Models.HANDHELD);

		itemModelGenerator.register(NTMItems.BISMUTH_PICKAXE, HANDHELD_LARGE);
		itemModelGenerator.register(NTMItems.BISMUTH_AXE, HANDHELD_LARGE);

		itemModelGenerator.register(NTMItems.MOLTEN_PICKAXE, HANDHELD_LARGE);
		itemModelGenerator.register(NTMItems.MOLTEN_AXE, HANDHELD_LARGE);

		itemModelGenerator.register(NTMItems.CHLOROPHYTE_PICKAXE, HANDHELD_LARGE);
		itemModelGenerator.register(NTMItems.CHLOROPHYTE_AXE, HANDHELD_LARGE);

		itemModelGenerator.register(NTMItems.MESE_PICKAXE, HANDHELD_LARGE);
		itemModelGenerator.register(NTMItems.MESE_AXE, HANDHELD_LARGE);
	}

	private static Model item(String parent, TextureKey... requiredTextureKeys) {
		return new Model(Optional.of(NTM.id("item/" + parent)), Optional.empty(), requiredTextureKeys);
	}

	@Override
	public String getName() {
		return NTM.MOD_NAME + " Model Provider";
	}
}
