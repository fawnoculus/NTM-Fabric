package net.fawnoculus.ntm.datagen.model;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;

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
    
    blockStateModelGenerator.registerSingleton(ModBlocks.ALLOY_FURNACE, TexturedModel.ORIENTABLE_WITH_BOTTOM);
    
    /*
    blockStateModelGenerator.blockStateCollector.accept(
        VariantsBlockModelDefinitionCreator.of(ModBlocks.ALLOY_FURNACE)
            .with(
                BlockStateVariantMap.models(AlloyFurnaceBlock.FACING, AlloyFurnaceBlock.LIT, AlloyFurnaceBlock.EXTENSION)
                    .generate(ModelProvider::AlloyFurnace)
            )
    );
    */
  }
  
  /*
  private static final WeightedVariant alloyFurnaceVariant = createWeightedVariant(Models.ORIENTABLE.upload(ModBlocks.ALLOY_FURNACE, new TextureMap()
          .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_top"))
          .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_bottom"))
          .put(TextureKey.FRONT, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_front"))
          .put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_side"))
      , BlockModelCollector));
  
  private static final WeightedVariant alloyFurnaceLitVariant = createWeightedVariant(Models.ORIENTABLE.upload(ModBlocks.ALLOY_FURNACE, new TextureMap()
          .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_top_lit"))
          .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_bottom"))
          .put(TextureKey.FRONT, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_front_lit"))
          .put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_side"))
      , BlockModelCollector));
  
  private static final WeightedVariant alloyFurnaceTallVariant = createWeightedVariant(Models.ORIENTABLE.upload(ModBlocks.ALLOY_FURNACE, new TextureMap()
          .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_top"))
          .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_bottom"))
          .put(TextureKey.FRONT, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_front_tall"))
          .put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_side_tall"))
      , BlockModelCollector));
  
  private static final WeightedVariant alloyFurnaceLitTallVariant = createWeightedVariant(Models.ORIENTABLE.upload(ModBlocks.ALLOY_FURNACE, new TextureMap()
          .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_top_lit"))
          .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_bottom"))
          .put(TextureKey.FRONT, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_front_lit_tall"))
          .put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks.ALLOY_FURNACE, "_side_tall"))
      , BlockModelCollector));
  
  private static WeightedVariant AlloyFurnace(Direction facing, boolean lit, boolean extension) {
    WeightedVariant weightedVariant;
    
    
    if (lit && extension) {
      weightedVariant = alloyFurnaceLitTallVariant;
    } else if (lit) {
      weightedVariant = alloyFurnaceLitVariant;
    } else if (extension) {
      weightedVariant = alloyFurnaceTallVariant;
    } else {
      weightedVariant = alloyFurnaceVariant;
    }
    
    
    switch (facing){
      case EAST -> {
        return weightedVariant.apply(ROTATE_X_90);
      }
      case SOUTH -> {
        return weightedVariant.apply(ROTATE_Y_180);
      }
      case WEST -> {
        return weightedVariant.apply(ROTATE_Y_270);
      }
      default -> {
        return weightedVariant;
      }
    }
  }
   
   */
  
  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    ItemModelCollector = itemModelGenerator.modelCollector;
    // BASIC ITEMS
    itemModelGenerator.register(ModItems.NULL, Models.GENERATED);
    
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
    itemModelGenerator.register(ModItems.RAW_ASBESTOS, Models.GENERATED);
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
    
    itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_INGOT, Models.GENERATED);
    
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