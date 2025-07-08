package net.fawnoculus.ntm.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fawnoculus.ntm.blocks.ModBlockProperties;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.block.Block;
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
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEKTITE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OSMIRIDIUM_INFUSED_TEKTITE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIXITE_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GEOTHERMAL_VENT);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BEDROCK_OIL_DEPOSIT);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ACTINIUM_227_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADVANCED_ALLOY_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALUMINIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ASBESTOS_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AUSTRALIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BAKELITE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BERYLLIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BORON_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CADMIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CADMIUM_STEEL_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CMB_STEEL_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBALT_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COLTAN_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DESH_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DINEUTRONIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EUPHEMIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FERRIC_SCHRABIDATE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUORITE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAPHITE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HIGH_SPEED_STEEL_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIGNITE_COKE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LITHIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAD_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGNETIZED_TUNGSTEN_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOX_FUEL_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NEPTUNIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NIOBIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NITER_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_PHOSPHORUS_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WHITE_PHOSPHORUS_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLUTONIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REACTOR_GRADE_PLUTONIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLUTONIUM_238_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLUTONIUM_239_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLUTONIUM_240_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLUTONIUM_241_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POLONIUM_210_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POLYMER_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RADIUM_226_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_COPPER_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBBER_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHRABIDIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHRABIDIUM_FUEL_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHRARANIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SEMTEX_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOLINIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STARMETAL_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SULFUR_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TANTALUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TECHNETIUM_STEEL_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THORIUM_232_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THORIUM_FUEL_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUNGSTEN_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_FUEL_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_233_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_235_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_238_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YELLOWCAKE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZIRCONIUM_BLOCK);
    
    registerSimpleHorizontalOrientable(blockStateModelGenerator, ModBlocks.POTATO_BATTERY_BLOCK);
    registerSimpleHorizontalOrientable(blockStateModelGenerator, ModBlocks.ENERGY_STORAGE_BLOCK);
    registerSimpleHorizontalOrientable(blockStateModelGenerator, ModBlocks.LITHIUM_ION_ENERGY_STORAGE_BLOCK);
    registerSimpleHorizontalOrientable(blockStateModelGenerator, ModBlocks.SCHRABIDIUM_ENERGY_STORAGE_BLOCK);
    registerSimpleHorizontalOrientable(blockStateModelGenerator, ModBlocks.SPARK_ENERGY_STORAGE_BLOCK);
    
    
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
    WeightedVariant litAlloyFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(blockStateModelGenerator.createSubModel(ModBlocks.ALLOY_FURNACE, "_lit", Models.ORIENTABLE_WITH_BOTTOM, a -> litAlloyFurnaceTextureMap));
    WeightedVariant tallAlloyFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(blockStateModelGenerator.createSubModel(ModBlocks.ALLOY_FURNACE, "_tall", Models.ORIENTABLE_WITH_BOTTOM, a -> tallAlloyFurnaceTextureMap));
    WeightedVariant litTallAlloyFurnaceweightedVariant = BlockStateModelGenerator.createWeightedVariant(blockStateModelGenerator.createSubModel(ModBlocks.ALLOY_FURNACE, "_lit_tall", Models.ORIENTABLE_WITH_BOTTOM, a -> litTallAlloyFurnaceTextureMap));
    blockStateModelGenerator.blockStateCollector
        .accept(
            VariantsBlockModelDefinitionCreator.of(ModBlocks.ALLOY_FURNACE)
                .with(
                    BlockStateVariantMap.models(Properties.HORIZONTAL_FACING, Properties.LIT, ModBlockProperties.EXTENSION)
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
  
  private void registerSimpleHorizontalOrientable(BlockStateModelGenerator blockStateModelGenerator, Block block){
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
    ItemModelCollector = itemModelGenerator.modelCollector;
    // Basic Items
    itemModelGenerator.register(ModItems.NULL, Models.GENERATED);
    
    // Raw Resources
    itemModelGenerator.register(ModItems.ACTINIUM_227_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.ACTINIUM_227_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.ACTINIUM_227_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_ACTINIUM_227_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.ACTINIUM_227_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.ACTINIUM_227_FRAGMENT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.ADVANCED_ALLOY_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.ADVANCED_ALLOY_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.ADVANCED_ALLOY_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_ADVANCED_ALLOY_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.ADVANCED_ALLOY_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_ADVANCED_ALLOY_WIRE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.ALEXANDRITE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_METEORIC_ALUMINIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.ALUMINIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.ALUMINIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.ALUMINIUM_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_ALUMINIUM_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.WELDED_ALUMINIUM_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.ALUMINIUM_SHELL, Models.GENERATED);
    itemModelGenerator.register(ModItems.ALUMINIUM_PIPE, Models.GENERATED);
    itemModelGenerator.register(ModItems.ALUMINIUM_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.ALUMINIUM_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.AMERICIUM_241_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.AMERICIUM_241_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.AMERICIUM_241_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.AMERICIUM_242_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.AMERICIUM_242_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.AMERICIUM_242_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.AMERICIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.AMERICIUM_FUEL_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.AMERICIUM_FUEL_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.REACTOR_GRADE_AMERICIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.REACTOR_GRADE_AMERICIUM_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.REACTOR_GRADE_AMERICIUM_ZFB_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.REACTOR_GRADE_AMERICIUM_NUGGET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.ARSENIC_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.ARSENIC_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.ARSENIC_BRONZE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_ARSENIC_BRONZE_PLATE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.ASBESTOS_SHEET, Models.GENERATED);
    itemModelGenerator.register(ModItems.ASBESTOS_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.ASTATINE_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.ASTATINE_209_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.ASH, Models.GENERATED);
    itemModelGenerator.register(ModItems.WOOD_ASH, Models.GENERATED);
    itemModelGenerator.register(ModItems.COAL_ASH, Models.GENERATED);
    itemModelGenerator.register(ModItems.FLY_ASH, Models.GENERATED);
    itemModelGenerator.register(ModItems.FINE_SOOT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_AUSTRALIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.AUSTRALIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.AUSTRALIUM_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.AUSTRALIUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.LESSER_AUSTRALIUM_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.LESSER_AUSTRALIUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.GREATER_AUSTRALIUM_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.GREATER_AUSTRALIUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.AUSTRALIUM_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.BAKELITE_BAR, Models.GENERATED);
    itemModelGenerator.register(ModItems.BAKELITE_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.BALEFIRE_EGG, Models.GENERATED);
    itemModelGenerator.register(ModItems.BALEFIRE_SHARD, Models.GENERATED);
    itemModelGenerator.register(ModItems.THERMONUCLEAR_ASHES, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_BERYLLIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.BERYLLIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.BERYLLIUM_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.BERYLLIUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.BERYLLIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.BERYLLIUM_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.BISMUTH_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.BISMUTH_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.BISMUTH_ZFB_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.BISMUTH_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.BISMUTH_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.BISMUTH_BRONZE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_BISMUTH_BRONZE_PLATE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.BORAX_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.BORON_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.BORON_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_BORON_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.BORON_FRAGMENT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.BROMINE_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.BSCCO_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_BSCCO_WIRE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.CADMIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CADMIUM_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.CAESIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAESIUM_137_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_CAESIUM_137_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.CALCIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CALCIUM_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.CADMIUM_STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_CADMIUM_STEEL_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.WELDED_CADMIUM_STEEL_PLATE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.CEMENT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.CERIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_CERIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.CERIUM_FRAGMENT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.CHLOROCALCITE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.CHLOROPHYTE_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.CINNABAR, Models.GENERATED);
    itemModelGenerator.register(ModItems.CINNABAR_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.CMB_STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CMB_STEEL_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_CMB_STEEL_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.WELDED_CMB_STEEL_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CMB_STEEL_PLATE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.COAL_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_COAL_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.CARBON_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.COAL_BRIQUETTE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.COBALT_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.COBALT_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.COBALT_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.COBALT_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_COBALT_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.COBALT_60_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.COBALT_60_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.COBALT_60_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.COBALT_60_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.COBALT_FRAGMENT, Models.GENERATED);
    itemModelGenerator.register(ModItems.COBALT_CRYSTALS, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_METEORIC_COBALT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.COLTAN, Models.GENERATED);
    itemModelGenerator.register(ModItems.CRUSHED_COLTAN, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.COPPER_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.COPPER_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_COPPER_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.WELDED_COPPER_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.COPPER_PIPE, Models.GENERATED);
    itemModelGenerator.register(ModItems.COPPER_SHELL, Models.GENERATED);
    itemModelGenerator.register(ModItems.COPPER_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_COPPER_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.COPPER_CRYSTALS, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_METEORIC_COPPER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.CRYO_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_CRYOLITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CRYOLITE_CHUNK, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.DESH_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.DESH_BLEND, Models.GENERATED);
    itemModelGenerator.register(ModItems.DESHREADY_BLEND, Models.GENERATED);
    itemModelGenerator.register(ModItems.DESH_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.DESH_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_DESH_PLATE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.DIAMOND_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.DIAMOND_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.DINEUTRONIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.DINEUTRONIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.DINEUTRONIUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_DINEUTRONIUM_NUGGET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.ELECTRONIUM_INGOT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.EMERALD_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.ENERGY_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.EUPHEMIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.EUPHEMIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.EUPHEMIUM_NUGGET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.FERRIC_SCHARBIDATE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.FERRIC_SCHARBIDATE_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_FERRIC_SCHARBIDATE_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_FERRIC_SCHARBIDATE_WIRE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.FERROURANIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_FERROURANIUM_PLATE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.FLASH_GOLD, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.FLASH_LEAD, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.FLUORITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.FLUORITE_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.FLUX, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.FULLERENE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CRYSTALLINE_FULLERENE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.GHIORSIUM_336_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.GHIORSIUM_336_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.GHIORSIUM_336_NUGGET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.GOLD_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.GOLD_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_GOLD_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.GOLD_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_GOLD_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.GOLD_CRYSTALS, Models.GENERATED);
    itemModelGenerator.register(ModItems.GOLD_198_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.GOLD_198_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.GOLD_198_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.GOLD_198_NUGGET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.GRAPHITE_INGOT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.GUNMETAL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.GUNMETAL_PLATE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.HARD_PLASTIC_BAR, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.HIGH_SPEED_STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.HIGH_SPEED_STEEL_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_HIGH_SPEED_STEEL_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.HIGH_SPEED_STEEL_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.HIGH_SPEED_STEEL_BOLT, Models.GENERATED);
    itemModelGenerator.register(ModItems.HIGH_SPEED_STEEL_PIPE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.IODINE_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.IODINE_131_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_IODINE_131_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.IRON_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.IRON_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_IRON_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.WELDED_IRON_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.IRON_PIPE, Models.GENERATED);
    itemModelGenerator.register(ModItems.IRON_CRYSTALS, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_METEORIC_IRON, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.INDUSTRIAL_FERTILIZER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.INFERNAL_COAL, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.SEMI_STABLE_LANTHANUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.LANTHANUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_LANTHANUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.LANTHANUM_FRAGMENT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.LAPIS_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.LAPIS_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.LATEX, Models.GENERATED);
    itemModelGenerator.register(ModItems.LATEX_BAR, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_LEAD, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_209_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_209_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_209_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_LEAD_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_PIPE, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_BOLT, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEAD_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.LIGNITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.LIGNITE_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.LIGNITE_COKE, Models.GENERATED);
    itemModelGenerator.register(ModItems.LIGNITE_BRIQUETTE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.LIMESTONE_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.LITHIUM_CUBE, Models.GENERATED);
    itemModelGenerator.register(ModItems.LITHIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_LITHIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.LITHIUM_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.MAGNETIZED_TUNGSTEN_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.MAGNETIZED_TUNGSTEN_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.MAGNETIZED_TUNGSTEN_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_MAGNETIZED_TUNGSTEN_WIRE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.METEORITE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.METEORITE_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_METEORITE_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.METEORITE_FRAGMENT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.MOLYSITE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.MOX_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.MOX_FUEL_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.MOX_FUEL_NUGGET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.NEODYMIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_NEODYMIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_NEODYMIUM_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEODYMIUM_FRAGMENT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.NEPTUNIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPTUNIUM_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPTUNIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPTUNIUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPTUNIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPTUNIUM_FUEL_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPTUNIUM_FUEL_NUGGET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.NIOBIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.NIOBIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_NIOBIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.NIOBIUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_NIOBIUM_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.NIOBIUM_FRAGMENT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.NITAN_BLEND, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.NITER, Models.GENERATED);
    itemModelGenerator.register(ModItems.NITER_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_OSMIRIDIUM_INFUSED_TEKTITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.OSMIRIDIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.OSMIRIDIUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.IMPURE_OSMIRIDIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_OSMIRIDIUM_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.WELDED_OSMIRIDIUM_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.OSMIRIDIUM_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.PALEOGENITE_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_PALEOGENITE_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RED_PHOSPHORUS, Models.GENERATED);
    itemModelGenerator.register(ModItems.WHITE_PHOSPHORUS_BAR, Models.GENERATED);
    itemModelGenerator.register(ModItems.PHOSPHORUS_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_PLUTONIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_FUEL_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_FUEL_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.REACTOR_GRADE_PLUTONIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.REACTOR_GRADE_PLUTONIUM_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.REACTOR_GRADE_PLUTONIUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_238_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_238_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_238_BE_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_238_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_239_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_239_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_239_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_240_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_240_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_240_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_241_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_241_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_241_ZFB_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_241_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.PLUTONIUM_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.POISON_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.POLONIUM_210_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.POLONIUM_210_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.POLONIUM_210_BE_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.POLONIUM_210_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.POLONIUM_210_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.POLYMER_BAR, Models.GENERATED);
    itemModelGenerator.register(ModItems.POLYMER_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.PULVERIZED_ENCHANTMENT, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.PVC_BAR, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.QUARTZ_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RADIUM_226_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.RADIUM_226_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.RADIUM_226_BE_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.RADIUM_226_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.RADIUM_226_NUGGET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RARE_EARTH_ORE_CHUNK, Models.GENERATED);
    itemModelGenerator.register(ModItems.RARE_EARTH_CRYSTALS, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_METEORIC_RARE_EARTH, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RED_COPPER_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.RED_COPPER_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.RED_COPPER_WIRE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.REDSTONE_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RUBBER_BAR, Models.GENERATED);
    itemModelGenerator.register(ModItems.RUBBER_PIPE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.SATURNITE_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.SATURNITE_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_SATURNITE_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.SATURNITE_SHELL, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.SAWDUST_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.SAWDUST_BRIQUETTE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_SCHRABIDIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_FUEL_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_FUEL_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_SCHRABIDIUM_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_SCHRABIDIUM_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.SCHRARANIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCHRARANIUM_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.SEMTEX_BLEND, Models.GENERATED);
    itemModelGenerator.register(ModItems.SEMTEX_BAR, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.SILICON_BOULE, Models.GENERATED);
    itemModelGenerator.register(ModItems.SILICON_WAFER, Models.GENERATED);
    itemModelGenerator.register(ModItems.PRINTED_SILICON_WAFER, Models.GENERATED);
    itemModelGenerator.register(ModItems.SILICON_NUGGET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.SODIUM_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.SOLINIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.SOLINIUM_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.SOLINIUM_NUGGET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.SPARK_BLEND, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.STARMETAL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_STARMETAL_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.STARMETAL_RING, Models.GENERATED);
    itemModelGenerator.register(ModItems.STARMETAL_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.STRONTIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.STRONTIUM_90_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.STRONTIUM_90_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.STRONTIUM_90_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_STRONTIUM_90_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.STRONTIUM_90_NUGGET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.STEEL_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_STEEL_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.STEEL_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_STEEL_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.WELDED_STEEL_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.STEEL_BOLT, Models.GENERATED);
    itemModelGenerator.register(ModItems.STEEL_PIPE, Models.GENERATED);
    itemModelGenerator.register(ModItems.STEEL_SHELL, Models.GENERATED);
    itemModelGenerator.register(ModItems.STEEL_WIRE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.SULFUR, Models.GENERATED);
    itemModelGenerator.register(ModItems.SULFUR_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.PURIFIED_TANTALITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.TANTALUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TANTALUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TANTALUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.TANTALUM_POLYCRYSTAL, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.TECHNETIUM_99_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TECHNETIUM_99_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.TECHNETIUM_99_NUGGET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.TECHNETIUM_STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TECHNETIUM_STEEL_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_TECHNETIUM_STEEL_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.WELDED_TECHNETIUM_STEEL_PLATE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.TEKTITE_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.TENNESSINE_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.THERMITE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_THORIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.THORIUM_232_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.THORIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.THORIUM_232_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.THORIUM_FUEL_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.THORIUM_232_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.THORIUM_FUEL_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.THORIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.THORIUM_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_TITANIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.TITANIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TITANIUM_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_TITANIUM_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.WELDED_TITANIUM_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.TITANIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TITANIUM_SHELL, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_TITANIUM_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.TITANIUM_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_TRIXITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.TRIXITE_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_TUNGSTEN, Models.GENERATED);
    itemModelGenerator.register(ModItems.TUNGSTEN_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TUNGSTEN_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TUNGSTEN_BOLT, Models.GENERATED);
    itemModelGenerator.register(ModItems.TUNGSTEN_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.DENSE_TUNGSTEN_WIRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.TUNGSTEN_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.RAW_URANIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_SCORCHED_URANIUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_FUEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_FUEL_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_FUEL_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_233_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_233_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_233_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_235_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_235_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_235_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_238_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_238_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_238_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_CRYSTALS, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.VOLCANIC_GEM, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.WEAPON_STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.WEAPON_STEEL_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_WEAPON_STEEL_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.WEAPON_STEEL_SHELL, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.XENON_135_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.TINY_PILE_OF_XENON_135_POWDER, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.YHARONITE_BILLET, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.YELLOWCAKE, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.ZIRCONIUM_SPLINTER, Models.GENERATED);
    itemModelGenerator.register(ModItems.ZIRCONIUM_CUBE, Models.GENERATED);
    itemModelGenerator.register(ModItems.ZIRCONIUM_BILLET, Models.GENERATED);
    itemModelGenerator.register(ModItems.ZIRCONIUM_POWDER, Models.GENERATED);
    itemModelGenerator.register(ModItems.CAST_ZIRCONIUM_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.WELDED_ZIRCONIUM_PLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.ZIRCONIUM_WIRE, Models.GENERATED);
    
    // Usable Items
    itemModelGenerator.register(ModItems.DEBUG_WAND, Models.GENERATED);
    itemModelGenerator.register(ModItems.CONSTRUCTION_WAND, Models.GENERATED);
    itemModelGenerator.register(ModItems.NETWORK_DEBUG_TOOL, Models.GENERATED);
    itemModelGenerator.register(ModItems.GEIGER_COUNTER, Models.GENERATED);
    itemModelGenerator.register(ModItems.DOSIMETER, Models.GENERATED);
    
    // Consumables
    itemModelGenerator.register(ModItems.EMPTY_SYRINGE, Models.GENERATED);
    itemModelGenerator.register(ModItems.POISONOUS_INJECTION, Models.GENERATED);
    itemModelGenerator.register(ModItems.ANTIDOTE, Models.GENERATED);
    itemModelGenerator.register(ModItems.AWESOME, Models.GENERATED);
    itemModelGenerator.register(ModItems.METAL_SYRINGE, Models.GENERATED);
    itemModelGenerator.register(ModItems.STIMPAK, Models.GENERATED);
    itemModelGenerator.register(ModItems.MED_X, Models.GENERATED);
    itemModelGenerator.register(ModItems.PSYCHO, Models.GENERATED);
    itemModelGenerator.register(ModItems.SUPER_STIMPAK, Models.GENERATED);
    itemModelGenerator.register(ModItems.WATERY_TAINT_INJECTION, Models.GENERATED);
    itemModelGenerator.register(ModItems.FIRST_AID_KIT, Models.GENERATED);
    itemModelGenerator.register(ModItems.IV_BAG, Models.GENERATED);
    itemModelGenerator.register(ModItems.BLOOD_BAG, Models.GENERATED);
    itemModelGenerator.register(ModItems.EMPTY_EXPERIENCE_BAG, Models.GENERATED);
    itemModelGenerator.register(ModItems.EXPERIENCE_BAG, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAD_AWAY, Models.GENERATED);
    itemModelGenerator.register(ModItems.STRONG_RAD_AWAY, Models.GENERATED);
    itemModelGenerator.register(ModItems.ELITE_RAD_AWAY, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAD_X, Models.GENERATED);
    itemModelGenerator.register(ModItems.IODINE_PILL, Models.GENERATED);
    
    itemModelGenerator.register(ModItems.WAFFLE_OF_MASS_DESTRUCTION, Models.GENERATED);
    itemModelGenerator.register(ModItems.VEGAN_SCHNITZEL, Models.GENERATED);
    itemModelGenerator.register(ModItems.RADIOACTIVE_COTTON_CANDY, Models.GENERATED);
    itemModelGenerator.register(ModItems.BASIC_LEAD_APPLE, Models.GENERATED);
    itemModelGenerator.register(ModItems.GOOD_LEAD_APPLE, Models.GENERATED);
    itemModelGenerator.register(ModItems.EPIC_LEAD_APPLE, Models.GENERATED);
    itemModelGenerator.register(ModItems.BASIC_SCHRABIDIUM_APPLE, Models.GENERATED);
    itemModelGenerator.register(ModItems.GOOD_SCHRABIDIUM_APPLE, Models.GENERATED);
    itemModelGenerator.register(ModItems.EPIC_SCHRABIDIUM_APPLE, Models.GENERATED);
    itemModelGenerator.register(ModItems.EUPHEMIUM_APPLE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CHEAP_TEM_FLAKES, Models.GENERATED);
    itemModelGenerator.register(ModItems.TEM_FLAKES, Models.GENERATED);
    itemModelGenerator.register(ModItems.EXPENSIVE_TEM_FLAKES, Models.GENERATED);
    itemModelGenerator.register(ModItems.GLOWING_MUSHROOM_STEW, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCRAMBLED_BALEFIRE_EGG, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCRAMBLED_BALEFIRE_EGG_AND_HAM, Models.GENERATED);
    itemModelGenerator.register(ModItems.LEMON, Models.GENERATED);
    itemModelGenerator.register(ModItems.MRE, Models.GENERATED);
    itemModelGenerator.register(ModItems.LOOPS, Models.GENERATED);
    itemModelGenerator.register(ModItems.IT_BREAKFAST, Models.GENERATED);
    itemModelGenerator.register(ModItems.SPONGEBOB_MACARONI, Models.GENERATED);
    itemModelGenerator.register(ModItems.FOOD_ITEM, Models.GENERATED);
    itemModelGenerator.register(ModItems.TWINKIE, Models.GENERATED);
    itemModelGenerator.register(ModItems.TV_STATIC_SANDWICH, Models.GENERATED);
    itemModelGenerator.register(ModItems.PUDDING, Models.GENERATED);
    itemModelGenerator.register(ModItems.SCRAP_PANCAKE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CHICKEN_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.PEAS, Models.GENERATED);
    itemModelGenerator.register(ModItems.MARSHMALLOW_ON_A_STICK, Models.GENERATED);
    itemModelGenerator.register(ModItems.ROASTED_MARSHMALLOW_ON_A_STICK, Models.GENERATED);
    itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);
    itemModelGenerator.register(ModItems.CHEESE_QUESADILLA, Models.GENERATED);
    itemModelGenerator.register(ModItems.GLYPHID_MEAT, Models.GENERATED);
    itemModelGenerator.register(ModItems.GRILLED_GLYPHID_MEAT, Models.GENERATED);
    itemModelGenerator.register(ModItems.GLYPHID_EGG, Models.GENERATED);
    itemModelGenerator.register(ModItems.IPECAC_SYRUP, Models.GENERATED);
    itemModelGenerator.register(ModItems.PTSD_MEDICATION, Models.GENERATED);
    itemModelGenerator.register(ModItems.STYLISH_FLASK, Models.GENERATED);
    itemModelGenerator.register(ModItems.ARIZONA_MUCHO_MANGO, Models.GENERATED);
    itemModelGenerator.register(ModItems.RADIUM_CHOCOLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.EMPTY_CAN, Models.GENERATED);
    itemModelGenerator.register(ModItems.RING_PULL, Models.GENERATED);
    itemModelGenerator.register(ModItems.SMART_ENERGY_DRINK, Models.GENERATED);
    itemModelGenerator.register(ModItems.CREATURE_ENERGY_DRINK, Models.GENERATED);
    itemModelGenerator.register(ModItems.RED_BOMB_ENERGY_DRINK, Models.GENERATED);
    itemModelGenerator.register(ModItems.DR_SUGAR_SOFT_DRINK, Models.GENERATED);
    itemModelGenerator.register(ModItems.OVERCHARGE_DELIRIUM_XT, Models.GENERATED);
    itemModelGenerator.register(ModItems.BLACK_MESA_LUNA_DARK_COLA, Models.GENERATED);
    itemModelGenerator.register(ModItems.BEPIS, Models.GENERATED);
    itemModelGenerator.register(ModItems.DR_BREENS_PRIVATE_RESERVE, Models.GENERATED);
    itemModelGenerator.register(ModItems.MUG_ROOT_BEER, Models.GENERATED);
    itemModelGenerator.register(ModItems.COFFEE, Models.GENERATED);
    itemModelGenerator.register(ModItems.RADIUM_COFFEE, Models.GENERATED);
    itemModelGenerator.register(ModItems.BOTTLE_OPENER, Models.GENERATED);
    itemModelGenerator.register(ModItems.EMPTY_BOTTLE, Models.GENERATED);
    itemModelGenerator.register(ModItems.EMPTY_BOMB_BOTTLE, Models.GENERATED);
    itemModelGenerator.register(ModItems.NUKA_COLA_BOTTLE_CAP, Models.GENERATED);
    itemModelGenerator.register(ModItems.NUKA_COLA_QUANTUM_BOTTLE_CAP, Models.GENERATED);
    itemModelGenerator.register(ModItems.S_COLA_BOTTLE_CAP, Models.GENERATED);
    itemModelGenerator.register(ModItems.S_COLA_RAD_BOTTLE_CAP, Models.GENERATED);
    itemModelGenerator.register(ModItems.KAROL_BOTTLE_CAP, Models.GENERATED);
    itemModelGenerator.register(ModItems.FRITZ_COLA_BOTTLE_CAP, Models.GENERATED);
    itemModelGenerator.register(ModItems.BOTTLE_OF_NUKA_COLA, Models.GENERATED);
    itemModelGenerator.register(ModItems.BOTTLE_OF_NUKA_CHERRY, Models.GENERATED);
    itemModelGenerator.register(ModItems.BOTTLE_OF_NUKA_COLA_QUANTUM, Models.GENERATED);
    itemModelGenerator.register(ModItems.BOTTLE_OF_S_COLA, Models.GENERATED);
    itemModelGenerator.register(ModItems.BOTTLE_OF_S_COLA_RAD, Models.GENERATED);
    itemModelGenerator.register(ModItems.BOTTLE_OF_KAROL, Models.GENERATED);
    itemModelGenerator.register(ModItems.FIRST_BOTTLE_OF_KAROL, Models.GENERATED);
    itemModelGenerator.register(ModItems.BOTTLE_OF_FRITZ_COLA, Models.GENERATED);
    itemModelGenerator.register(ModItems.FIRST_BOTTLE_OF_FRITZ_COLA, Models.GENERATED);
    
    // Tools
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
    
    itemModelGenerator.register(ModItems.SCHRABIDIUM_SWORD, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_PICKAXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_AXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_SHOVEL, Models.HANDHELD);
    itemModelGenerator.register(ModItems.SCHRABIDIUM_HOE, Models.HANDHELD);
    
    itemModelGenerator.register(ModItems.BISMUTH_PICKAXE, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.BISMUTH_AXE, HANDHELD_LARGE);
    
    itemModelGenerator.register(ModItems.MOLTEN_PICKAXE, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.MOLTEN_AXE, HANDHELD_LARGE);
    
    itemModelGenerator.register(ModItems.CHLOROPHYTE_PICKAXE, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.CHLOROPHYTE_AXE, HANDHELD_LARGE);
    
    itemModelGenerator.register(ModItems.MESE_PICKAXE, HANDHELD_LARGE);
    itemModelGenerator.register(ModItems.MESE_AXE, HANDHELD_LARGE);
  }
  public static final Model HANDHELD_LARGE = item("handheld_large", TextureKey.LAYER0);
  
  private static Model item(String parent, TextureKey... requiredTextureKeys) {
    return new Model(Optional.of(NTM.id("item/" + parent)), Optional.empty(), requiredTextureKeys);
  }
  @Override
  public String getName() {
    return NTM.MOD_NAME+" Model Provider";
  }
}