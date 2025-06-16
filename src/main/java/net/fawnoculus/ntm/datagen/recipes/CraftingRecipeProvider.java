package net.fawnoculus.ntm.datagen.recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
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
  public RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
    return new RecipeGenerator(registryLookup, exporter) {
      @Override
      public void generate() {
        RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
        makeTools(this, exporter, ModItems.STEEL_INGOT, ModItems.STEEL_SWORD, ModItems.STEEL_PICKAXE, ModItems.STEEL_AXE, ModItems.STEEL_SHOVEL, ModItems.STEEL_HOE);
        makeTools(this, exporter, ModItems.ADVANCED_ALLOY_INGOT, ModItems.ADVANCED_ALLOY_SWORD, ModItems.ADVANCED_ALLOY_PICKAXE, ModItems.ADVANCED_ALLOY_AXE, ModItems.ADVANCED_ALLOY_SHOVEL, ModItems.ADVANCED_ALLOY_HOE);
        makeTools(this, exporter, ModItems.TITANIUM_INGOT, ModItems.TITANIUM_SWORD, ModItems.TITANIUM_PICKAXE, ModItems.TITANIUM_AXE, ModItems.TITANIUM_SHOVEL, ModItems.TITANIUM_HOE);
        makeTools(this, exporter, ModItems.DESH_INGOT, ModItems.DESH_SWORD, ModItems.DESH_PICKAXE, ModItems.DESH_AXE, ModItems.DESH_SHOVEL, ModItems.DESH_HOE);
        makeTools(this, exporter, ModItems.COBALT_INGOT, ModItems.COBALT_SWORD, ModItems.COBALT_PICKAXE, ModItems.COBALT_AXE, ModItems.COBALT_SHOVEL, ModItems.COBALT_HOE);
        makeTools(this, exporter, ModItems.CMB_STEEL_INGOT, ModItems.CMB_STEEL_SWORD, ModItems.CMB_STEEL_PICKAXE, ModItems.CMB_STEEL_AXE, ModItems.CMB_STEEL_SHOVEL, ModItems.CMB_STEEL_HOE);
      }
    };
  }
  
  private void makeTools(
      RecipeGenerator generator,
      RecipeExporter exporter,
      ItemConvertible material,
      ItemConvertible sword,
      ItemConvertible pickaxe,
      ItemConvertible axe,
      ItemConvertible shovel,
      ItemConvertible hoe
  ){
    generator.createShaped(RecipeCategory.TOOLS, sword, 1)
        .pattern(" M ")
        .pattern(" M ")
        .pattern(" S ")
        .input('M', material)
        .input('S', Items.STICK)
        .criterion(RecipeGenerator.hasItem(material), generator.conditionsFromItem(material))
        .offerTo(exporter);
    generator.createShaped(RecipeCategory.TOOLS, pickaxe, 1)
        .pattern("MMM")
        .pattern(" S ")
        .pattern(" S ")
        .input('M', material)
        .input('S', Items.STICK)
        .criterion(RecipeGenerator.hasItem(material), generator.conditionsFromItem(material))
        .offerTo(exporter);
    generator.createShaped(RecipeCategory.TOOLS, axe, 1)
        .pattern(" MM")
        .pattern(" SM")
        .pattern(" S ")
        .input('M', material)
        .input('S', Items.STICK)
        .criterion(RecipeGenerator.hasItem(material), generator.conditionsFromItem(material))
        .offerTo(exporter);
    generator.createShaped(RecipeCategory.TOOLS, shovel, 1)
        .pattern(" M ")
        .pattern(" S ")
        .pattern(" S ")
        .input('M', material)
        .input('S', Items.STICK)
        .criterion(RecipeGenerator.hasItem(material), generator.conditionsFromItem(material))
        .offerTo(exporter);
    generator.createShaped(RecipeCategory.TOOLS, hoe, 1)
        .pattern(" MM")
        .pattern(" S ")
        .pattern(" S ")
        .input('M', material)
        .input('S', Items.STICK)
        .criterion(RecipeGenerator.hasItem(material), generator.conditionsFromItem(material))
        .offerTo(exporter);
  }
  
  @Override
  public String getName() {
    return NTM.MOD_ID + " Crafting-Recipe Provider";
  }
}
