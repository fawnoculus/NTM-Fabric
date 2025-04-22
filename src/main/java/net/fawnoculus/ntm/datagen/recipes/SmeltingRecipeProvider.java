package net.fawnoculus.ntm.datagen.recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.util.ModItemTags;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SmeltingRecipeProvider extends FabricRecipeProvider {
  public SmeltingRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }
  
  @Override
  public String getName() {
    return NTM.MOD_ID + " Smelting Recipes";
  }
  
  @Override
  public RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
    return new RecipeGenerator(registryLookup, exporter) {
      @Override
      public void generate() {
        RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
        offerSmelting(
            itemListofTag(ModItemTags.URANIUM_ORES),
            RecipeCategory.MISC,
            ModItems.URANIUM_INGOT,
            1.0f,
            300,
            "ore_smelting"
        );
      }
    };
  }
  public List<ItemConvertible> itemListofTag(TagKey<Item> tag){
    // TODO: make this actually do what is supposed to!!!!!
    return List.of(ModItems.URANIUM_INGOT);
  }
}
