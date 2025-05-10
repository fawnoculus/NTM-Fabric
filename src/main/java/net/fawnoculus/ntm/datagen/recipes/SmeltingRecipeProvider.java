package net.fawnoculus.ntm.datagen.recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SmeltingRecipeProvider extends FabricRecipeProvider {
  public SmeltingRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }
  
  private static final List<ItemConvertible> URANIUM_ORES = List.of();
  
  
  @Override
  public RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
    return new RecipeGenerator(registryLookup, exporter) {
      @Override
      public void generate() {
        offerSmelting(
            URANIUM_ORES,
            RecipeCategory.MISC,
            ModItems.URANIUM_INGOT,
            1.0f,
            300,
            "uranium"
        );
        offerBlasting(
            URANIUM_ORES,
            RecipeCategory.MISC,
            ModItems.URANIUM_INGOT,
            0.5f,
            500,
            "uranium"
        );
      }
    };
  }
  
  @Override
  public String getName() {
    return NTM.MOD_ID + " Smelting-Recipe Provider";
  }
}