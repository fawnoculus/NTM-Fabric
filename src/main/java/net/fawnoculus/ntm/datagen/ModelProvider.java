package net.fawnoculus.ntm.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.client.data.*;

import java.util.Optional;


public class ModelProvider extends FabricModelProvider {
  public ModelProvider(FabricDataOutput output) {
    super(output);
  }
  
  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAD_ORE);
//    TODO: Make this shit work
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALLOY_FURNACE);
//    TexturedModel alloyFurnaceIdentifier = TexturedModel.CUBE_ALL.get(ModBlocks.ALLOY_FURNACE);
//    Identifier alloyFurnaceLitIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.ALLOY_FURNACE, "_lit", Models.ORIENTABLE_WITH_BOTTOM, TextureMap::all);
//    Identifier alloyFurnaceLongIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.ALLOY_FURNACE, "_tall", Models.ORIENTABLE_WITH_BOTTOM, TextureMap::all);
//    Identifier alloyFurnaceLongLitIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.ALLOY_FURNACE, "_lit_tall", Models.ORIENTABLE_WITH_BOTTOM, TextureMap::all);
//
//    blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(ModBlocks.ALLOY_FURNACE)
//        .with(BlockStateModelGenerator.createBooleanModelMap(AlloyFurnaceBlock.LIT, alloyFurnaceIdentifier, alloyFurnaceLitIdentifier)));
  }
  
  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {
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