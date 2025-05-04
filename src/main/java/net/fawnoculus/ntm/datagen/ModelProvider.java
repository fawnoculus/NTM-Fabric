package net.fawnoculus.ntm.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.items.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModelProvider extends FabricModelProvider {
  public ModelProvider(FabricDataOutput output) {
    super(output);
  }
  
  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAD_ORE);
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
}
