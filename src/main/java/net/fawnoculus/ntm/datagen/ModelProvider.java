package net.fawnoculus.ntm.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceBlock;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;

public class ModelProvider extends FabricModelProvider {
  public ModelProvider(FabricDataOutput output) {
    super(output);
  }
  
  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAD_ORE);
//    TODO: Make this shit work
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
    itemModelGenerator.register(ModItems.STEEL_SWORD, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STEEL_PICKAXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STEEL_AXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STEEL_SHOVEL, Models.HANDHELD);
    itemModelGenerator.register(ModItems.STEEL_HOE, Models.HANDHELD);
    
    itemModelGenerator.register(ModItems.NULL, Models.GENERATED);
    itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
    itemModelGenerator.register(ModItems.URANIUM_INGOT, Models.GENERATED);
  }
  
  @Override
  public String getName() {
    return NTM.MOD_ID+" Model Provider";
  }
}