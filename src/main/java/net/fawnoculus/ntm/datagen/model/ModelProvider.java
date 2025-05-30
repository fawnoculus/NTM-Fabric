package net.fawnoculus.ntm.datagen.model;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceBlock;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;
import java.util.function.BiConsumer;

import static net.minecraft.client.data.BlockStateModelGenerator.*;


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
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAD_ORE);
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
    // BASIC ITEMS START
    itemModelGenerator.register(ModItems.NULL, Models.GENERATED);
    itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_INGOT, Models.GENERATED);
    // BASIC ITEMS END
    
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