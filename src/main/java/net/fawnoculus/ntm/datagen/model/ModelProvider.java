package net.fawnoculus.ntm.datagen.model;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fawnoculus.ntm.blocks.ModBlockProperties;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;
import java.util.function.BiConsumer;


public class ModelProvider extends FabricModelProvider {
  public ModelProvider(FabricDataOutput output) {
    super(output);
  }
  
  static BiConsumer<Identifier, ModelSupplier> BlockModelCollector;
  static BiConsumer<Identifier, ModelSupplier> ItemModelCollector;
  
  
  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    BlockModelCollector = blockStateModelGenerator.modelCollector;
    
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCORCHED_URANIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SULFUR_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THORIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NITER_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUNGSTEN_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALUMINIUM_BEARING_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUORITE_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAD_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHRABIDIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BERYLLIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AUSTRALIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RARE_EARTH_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBALT_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CINNEBAR_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COLTAN_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIGNITE_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ASBESTOS_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OIL_DEPOSIT);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EMPTY_OIL_DEPOSIT);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALUMINIUM_ORE_CLUSTER);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COPPER_ORE_CLUSTER);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IRON_ORE_CLUSTER);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_ORE_CLUSTER);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEAD_DIRT);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OILY_DIRT);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OILY_SAND);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEPTH_ROCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEPTH_CINNABAR_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEPTH_ZIRCONIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEPTH_BORAX_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEPTH_IRON_ORE_CLUSTER);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEPTH_TITANIUM_ORE_CLUSTER);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALEXANDRITE_ORE);
    blockStateModelGenerator.registerSingleton(ModBlocks.VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
    blockStateModelGenerator.registerSingleton(ModBlocks.SULFUR_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
    blockStateModelGenerator.registerSingleton(ModBlocks.FLUORITE_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
    blockStateModelGenerator.registerSingleton(ModBlocks.ASBESTOS_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
    blockStateModelGenerator.registerSingleton(ModBlocks.GEM_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
    blockStateModelGenerator.registerSingleton(ModBlocks.MOLYSITE_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SMOLDERING_NETHERRACK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_COAL_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_URANIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCORCHED_NETHER_URANIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_PLUTONIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_TUNGSTEN_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SULFUR_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_PHOSPHORUS_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_COBALT_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SCHRABIDIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_DEPTH_ROCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_DEPTH_NEODYMIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.METEORITE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BROKEN_METEORITE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.METEORITE_COBBLESTONE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HOT_METEORITE_COBBLESTONE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.METEORITE_TREASURE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.METEOR_IRON_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.METEOR_COPPER_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.METEOR_ALUMINIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.METEOR_RARE_EARTH_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.METEOR_COBALT_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAPHITIC_SCHIST);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHIST_IRON_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHIST_GOLD_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHIST_URANIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCORCHED_SCHIST_URANIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHIST_COPPER_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHIST_ASBESTOS_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHIST_LITHIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHIST_SCHRABIDIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHIST_RARE_EARTH_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GAS_SHALE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BAUXITE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHRYSOTILE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HEMATITE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIMESTONE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MALACHITE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SULFUROUS_STONE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEKITE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OSMIRIDIUM_INFUSED_TEKITE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIXITE_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GEOTHERMAL_VENT);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BEDROCK_OIL_DEPOSIT);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BEDROCK_ORE);
    
    TextureMap alloyFurnaceTextureMap = new TextureMap()
        .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_top"))
        .put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_side"))
        .put(TextureKey.FRONT, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_front"))
        .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_bottom"));
    TextureMap litAlloyFurnaceTextureMap = new TextureMap()
        .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_top_lit"))
        .put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_side"))
        .put(TextureKey.FRONT, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_front_lit"))
        .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_bottom"));
    TextureMap tallAlloyFurnaceTextureMap = new TextureMap()
        .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_top"))
        .put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_side_tall"))
        .put(TextureKey.FRONT, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_front_tall"))
        .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_bottom"));
    TextureMap litTallAlloyFurnaceTextureMap = new TextureMap()
        .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_top_lit"))
        .put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_side_tall"))
        .put(TextureKey.FRONT, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_front_lit_tall"))
        .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_bottom"));
    
    WeightedVariant alloyFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(Models.ORIENTABLE_WITH_BOTTOM.upload(ModBlocks.ALLOY_FURNACE, "", alloyFurnaceTextureMap, blockStateModelGenerator.modelCollector));
    WeightedVariant litAlloyFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(blockStateModelGenerator.createSubModel(ModBlocks.ALLOY_FURNACE, "lit", Models.ORIENTABLE_WITH_BOTTOM, a -> litAlloyFurnaceTextureMap));
    WeightedVariant tallAlloyFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(blockStateModelGenerator.createSubModel(ModBlocks.ALLOY_FURNACE, "tall", Models.ORIENTABLE_WITH_BOTTOM, a -> tallAlloyFurnaceTextureMap));
    WeightedVariant litTallAlloyFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(blockStateModelGenerator.createSubModel(ModBlocks.ALLOY_FURNACE, "lit_tall", Models.ORIENTABLE_WITH_BOTTOM, a -> litTallAlloyFurnaceTextureMap));
    blockStateModelGenerator.blockStateCollector
        .accept(
            VariantsBlockModelDefinitionCreator.of(ModBlocks.ALLOY_FURNACE)
                .with(
                    BlockStateVariantMap.models(Properties.HORIZONTAL_FACING, Properties.LIT, ModBlockProperties.EXTENTION)
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
  }
  
  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    ItemModelCollector = itemModelGenerator.modelCollector;
    // BASIC ITEMS
    itemModelGenerator.register(ModItems.NULL, Models.GENERATED);
    itemModelGenerator.register(ModItems.DEBUG_WAND, Models.GENERATED);
    
    // Raw Ores & Ore based Resources
    itemModelGenerator.register(ModItems.RAW_URANIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_SCORCHED_URANIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_PLUTONIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_THORIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_TITANIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_TUNGSTEN, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_CRYOLITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_BERYLLIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_LEAD, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_SCHRABIDIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_AUSTRALIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_COLTAN, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_METEORIC_IRON, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_METEORIC_COPPER, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_METEORIC_ALUMINIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_METEORIC_RARE_EARTH, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_METEORIC_COBALT, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_TRIXITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_OSMIRIDIUM, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.URANIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_233_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_235_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_238_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_238_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_239_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_240_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_241_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.REACTOR_GRADE_PLUTONIUM__INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.THORIUM_232_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.THORIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TITANIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TUNGSTEN_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.MAGNETIZED_TUNGSTEN_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.ALUMINIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.BERYLLIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_209_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.AUSTRALIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.OSMIRIDIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.AMERICIUM_241_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.AMERICIUM_242_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.AMERICIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.REACTOR_GRADE_AMERICIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CURIUM_242_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CURIUM_243_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CURIUM_244_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CURIUM_245_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CURIUM_246_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CURIUM_247_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CURIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.REACTOR_GRADE_CURIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.BERKELIUM_247_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CALIFORNIUM_251_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CALIFORNIUM_252_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.EINSTEINIUM_253_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.EINSTEINIUM_255_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPTUNIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPTUNIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.POLONIUM_210_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TECHNETIUM_99_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.COBALT_60_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.STRONTIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.STRONTIUM_90_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.GOLD_198_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.RADIUM_226_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.NICKEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.RED_COPPER_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.ADVANCED_ALLOY_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.ZINC_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.GALLIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.GALLIUM_ARSENIDE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TECHTACTIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TECHTACTIUM_ARSENIDE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLATINIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.IRIDIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PALLADIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.STAINLESS_STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TECHNETIUM_STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CADMIUM_STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.BISMUTH_BRONZE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.ARSENIC_BRONZE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.BSCCO_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.BISMUTH_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.ARSENIC_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CALCIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CADMIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TANTALUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.NIOBIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.COBALT_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.BORON_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.GRAPHITE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.HIGH_SPEED_STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.VULCANITE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRARANIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.FERRIC_SCHARBIDATE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CMB_STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.SOLINIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.GHIORSIUM_336_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CHINESIUM_989_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.MOX_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.SEMI_STABLE_LANTHANUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.ACTINIUM_227_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.DESH_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.FERROURANIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.STARMETAL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.GUNMETAL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.WEAPON_STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.SATURNITE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.EUPHEMIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.DINEUTRONIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.ELECTRONIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.GWENIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.HAFNIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.DUSTED_STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.HEAVY_CHAINSTEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.METEORITE_INGOT, Models.GENERATED);
    
    // TOOLS & WEAPONS START
    itemModelGenerator.register(ModItems.STEEL_SWORD, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STEEL_PICKAXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STEEL_AXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STEEL_SHOVEL, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STEEL_HOE, Models.HANDHELD);
    
    itemModelGenerator.register(ModItems.TITANIUM_SWORD, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.TITANIUM_PICKAXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.TITANIUM_AXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.TITANIUM_SHOVEL, Models.HANDHELD);
    itemModelGenerator.register(ModItems.TITANIUM_HOE, Models.HANDHELD);
    
    itemModelGenerator.register(ModItems.COBALT_SWORD, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.COBALT_PICKAXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.COBALT_AXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.COBALT_SHOVEL, Models.HANDHELD);
    itemModelGenerator.register(ModItems.COBALT_HOE, Models.HANDHELD);
    
    itemModelGenerator.register(ModItems.DECORATED_COBALT_SWORD, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.DECORATED_COBALT_PICKAXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.DECORATED_COBALT_AXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.DECORATED_COBALT_SHOVEL, Models.HANDHELD);
    itemModelGenerator.register(ModItems.DECORATED_COBALT_HOE, Models.HANDHELD);
    
    itemModelGenerator.register(ModItems.STARMETAL_SWORD, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.STARMETAL_PICKAXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STARMETAL_AXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STARMETAL_SHOVEL, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STARMETAL_HOE, Models.HANDHELD);
    
    itemModelGenerator.register(ModItems.ADVANCED_ALLOY_SWORD, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.ADVANCED_ALLOY_PICKAXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.ADVANCED_ALLOY_AXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.ADVANCED_ALLOY_SHOVEL, Models.HANDHELD);
    itemModelGenerator.register(ModItems.ADVANCED_ALLOY_HOE, Models.HANDHELD);
    
    itemModelGenerator.register(ModItems.CMB_STEEL_SWORD, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.CMB_STEEL_PICKAXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.CMB_STEEL_AXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.CMB_STEEL_SHOVEL, Models.HANDHELD);
    itemModelGenerator.register(ModItems.CMB_STEEL_HOE, Models.HANDHELD);
    
    itemModelGenerator.register(ModItems.DESH_SWORD, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.DESH_PICKAXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.DESH_AXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.DESH_SHOVEL, Models.HANDHELD);
    itemModelGenerator.register(ModItems.DESH_HOE, Models.HANDHELD);
    
    itemModelGenerator.register(ModItems.BISMUTH_PICKAXE, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.BISMUTH_AXE, HANDHELD_LARGE);
    
    itemModelGenerator.register(ModItems.MOLTEN_PICKAXE, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.MOLTEN_AXE, HANDHELD_LARGE);
    
    itemModelGenerator.register(ModItems.CHLOROPHYTE_PICKAXE, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.CHLOROPHYTE_AXE, HANDHELD_LARGE);
    
    itemModelGenerator.register(ModItems.MESE_PICKAXE, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.MESE_AXE, HANDHELD_LARGE);
    // TOOLS & WEAPONS END
  }
  public static final Model HANDHELD_LARGE = item("handheld_large", TextureKey.LAYER0);
  
  private static Model item(String parent, TextureKey... requiredTextureKeys) {
    return new Model(Optional.of(NTM.id("item/" + parent)), Optional.empty(), requiredTextureKeys);
  }
  @Override
  public String getName() {
    return NTM.MOD_ID+" Model Provider";
  }
}