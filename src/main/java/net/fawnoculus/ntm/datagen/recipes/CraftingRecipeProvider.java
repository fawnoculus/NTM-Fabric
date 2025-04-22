package net.fawnoculus.ntm.datagen.recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class CraftingRecipeProvider extends FabricRecipeProvider{
  public CraftingRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }
  
  @Override
  public String getName() {
    return NTM.MOD_ID + " Shaped Recipes";
  }
  
  @Override
  public RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
    return new RecipeGenerator(registryLookup, exporter) {
      @Override
      public void generate() {
        RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
        
        createShaped(RecipeCategory.TOOLS, ModItems.STEEL_SWORD, 1)
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" B ")
            .input('A', ModItems.STEEL_INGOT)
            .input('B', Items.STICK)
            .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
            .offerTo(exporter);
        createShaped(RecipeCategory.TOOLS, ModItems.STEEL_PICKAXE, 1)
            .pattern("AAA")
            .pattern(" B ")
            .pattern(" B ")
            .input('A', ModItems.STEEL_INGOT)
            .input('B', Items.STICK)
            .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
            .offerTo(exporter);
      }
    };
  }
}
