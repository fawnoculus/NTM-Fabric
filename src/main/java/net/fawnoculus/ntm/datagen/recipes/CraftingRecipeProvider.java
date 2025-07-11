package net.fawnoculus.ntm.datagen.recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fawnoculus.ntm.blocks.ModBlocks;
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
        
        make3x3andReverse(this, exporter, ModItems.ACTINIUM_227_INGOT, ModBlocks.ACTINIUM_227_BLOCK);
        make3x3andReverse(this, exporter, ModItems.ADVANCED_ALLOY_INGOT, ModBlocks.ADVANCED_ALLOY_BLOCK);
        make3x3andReverse(this, exporter, ModItems.ALUMINIUM_INGOT, ModBlocks.ALUMINIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.ASBESTOS_SHEET, ModBlocks.ASBESTOS_BLOCK);
        make3x3andReverse(this, exporter, ModItems.AUSTRALIUM_INGOT, ModBlocks.AUSTRALIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.BAKELITE_BAR, ModBlocks.BAKELITE_BLOCK);
        make3x3andReverse(this, exporter, ModItems.BERYLLIUM_INGOT, ModBlocks.BERYLLIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.BISMUTH_INGOT, ModBlocks.BISMUTH_BLOCK);
        make3x3andReverse(this, exporter, ModItems.BORON_INGOT, ModBlocks.BORON_BLOCK);
        make3x3andReverse(this, exporter, ModItems.CADMIUM_INGOT, ModBlocks.CADMIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.CADMIUM_STEEL_INGOT, ModBlocks.CADMIUM_STEEL_BLOCK);
        make3x3andReverse(this, exporter, ModItems.CMB_STEEL_INGOT, ModBlocks.CMB_STEEL_BLOCK);
        make3x3andReverse(this, exporter, ModItems.COAL_COKE, ModBlocks.COAL_COKE_BLOCK);
        make3x3andReverse(this, exporter, ModItems.COBALT_INGOT, ModBlocks.COBALT_BLOCK);
        make3x3andReverse(this, exporter, ModItems.COLTAN, ModBlocks.COLTAN_BLOCK);
        make3x3andReverse(this, exporter, ModItems.DESH_INGOT, ModBlocks.DESH_BLOCK);
        make3x3andReverse(this, exporter, ModItems.DINEUTRONIUM_INGOT, ModBlocks.DINEUTRONIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.EUPHEMIUM_INGOT, ModBlocks.EUPHEMIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.FERRIC_SCHARBIDATE_INGOT, ModBlocks.FERRIC_SCHRABIDATE_BLOCK);
        make3x3andReverse(this, exporter, ModItems.FLUORITE, ModBlocks.FLUORITE_BLOCK);
        make3x3andReverse(this, exporter, ModItems.GRAPHITE_INGOT, ModBlocks.GRAPHITE_BLOCK);
        make3x3andReverse(this, exporter, ModItems.HIGH_SPEED_STEEL_INGOT, ModBlocks.HIGH_SPEED_STEEL_BLOCK);
        make3x3andReverse(this, exporter, ModItems.LIGNITE_COKE, ModBlocks.LIGNITE_COKE_BLOCK);
        make3x3andReverse(this, exporter, ModItems.LEAD_INGOT, ModBlocks.LEAD_BLOCK);
        make3x3andReverse(this, exporter, ModItems.LITHIUM_CUBE, ModBlocks.LITHIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.MAGNETIZED_TUNGSTEN_INGOT, ModBlocks.MAGNETIZED_TUNGSTEN_BLOCK);
        make3x3andReverse(this, exporter, ModItems.MOX_FUEL_INGOT, ModBlocks.MOX_FUEL_BLOCK);
        make3x3andReverse(this, exporter, ModItems.NEPTUNIUM_INGOT, ModBlocks.NEPTUNIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.NIOBIUM_INGOT, ModBlocks.NIOBIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.NITER, ModBlocks.NITER_BLOCK);
        make3x3andReverse(this, exporter, ModItems.PETROLEUM_COKE, ModBlocks.PETROLEUM_COKE_BLOCK);
        make3x3andReverse(this, exporter, ModItems.PLUTONIUM_INGOT, ModBlocks.PLUTONIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.PLUTONIUM_FUEL_INGOT, ModBlocks.PLUTONIUM_FUEL_BLOCK);
        make3x3andReverse(this, exporter, ModItems.REACTOR_GRADE_PLUTONIUM_INGOT, ModBlocks.REACTOR_GRADE_PLUTONIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.PLUTONIUM_238_INGOT, ModBlocks.PLUTONIUM_238_BLOCK);
        make3x3andReverse(this, exporter, ModItems.PLUTONIUM_239_INGOT, ModBlocks.PLUTONIUM_239_BLOCK);
        make3x3andReverse(this, exporter, ModItems.PLUTONIUM_240_INGOT, ModBlocks.PLUTONIUM_240_BLOCK);
        make3x3andReverse(this, exporter, ModItems.PLUTONIUM_241_INGOT, ModBlocks.PLUTONIUM_241_BLOCK);
        make3x3andReverse(this, exporter, ModItems.POLONIUM_210_INGOT, ModBlocks.POLONIUM_210_BLOCK);
        make3x3andReverse(this, exporter, ModItems.POLYMER_BAR, ModBlocks.POLYMER_BLOCK);
        make3x3andReverse(this, exporter, ModItems.RADIUM_226_INGOT, ModBlocks.RADIUM_226_BLOCK);
        make3x3andReverse(this, exporter, ModItems.RED_COPPER_INGOT, ModBlocks.RED_COPPER_BLOCK);
        make3x3andReverse(this, exporter, ModItems.RED_PHOSPHORUS, ModBlocks.RED_PHOSPHORUS_BLOCK);
        make3x3andReverse(this, exporter, ModItems.RUBBER_BAR, ModBlocks.RUBBER_BLOCK);
        make3x3andReverse(this, exporter, ModItems.SCHRABIDIUM_INGOT, ModBlocks.SCHRABIDIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.SCHRABIDIUM_FUEL_INGOT, ModBlocks.SCHRABIDIUM_FUEL_BLOCK);
        make3x3andReverse(this, exporter, ModItems.SCHRARANIUM_INGOT, ModBlocks.SCHRARANIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.SEMTEX_BAR, ModBlocks.SEMTEX_BLOCK);
        make3x3andReverse(this, exporter, ModItems.SOLINIUM_INGOT, ModBlocks.SOLINIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.STARMETAL_INGOT, ModBlocks.STARMETAL_BLOCK);
        make3x3andReverse(this, exporter, ModItems.STEEL_INGOT, ModBlocks.STEEL_BLOCK);
        make3x3andReverse(this, exporter, ModItems.SULFUR, ModBlocks.SULFUR_BLOCK);
        make3x3andReverse(this, exporter, ModItems.TANTALUM_INGOT, ModBlocks.TANTALUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.TECHNETIUM_STEEL_INGOT, ModBlocks.TECHNETIUM_STEEL_BLOCK);
        make3x3andReverse(this, exporter, ModItems.THORIUM_232_INGOT, ModBlocks.THORIUM_232_BLOCK);
        make3x3andReverse(this, exporter, ModItems.THORIUM_FUEL_INGOT, ModBlocks.THORIUM_FUEL_BLOCK);
        make3x3andReverse(this, exporter, ModItems.TITANIUM_INGOT, ModBlocks.TITANIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.TUNGSTEN_INGOT, ModBlocks.TUNGSTEN_BLOCK);
        make3x3andReverse(this, exporter, ModItems.URANIUM_INGOT, ModBlocks.URANIUM_BLOCK);
        make3x3andReverse(this, exporter, ModItems.URANIUM_FUEL_INGOT, ModBlocks.URANIUM_FUEL_BLOCK);
        make3x3andReverse(this, exporter, ModItems.URANIUM_233_INGOT, ModBlocks.URANIUM_233_BLOCK);
        make3x3andReverse(this, exporter, ModItems.URANIUM_235_INGOT, ModBlocks.URANIUM_235_BLOCK);
        make3x3andReverse(this, exporter, ModItems.URANIUM_238_INGOT, ModBlocks.URANIUM_238_BLOCK);
        make3x3andReverse(this, exporter, ModItems.WHITE_PHOSPHORUS_BAR, ModBlocks.WHITE_PHOSPHORUS_BLOCK);
        make3x3andReverse(this, exporter, ModItems.YELLOWCAKE, ModBlocks.YELLOWCAKE_BLOCK);
        make3x3andReverse(this, exporter, ModItems.ZIRCONIUM_CUBE, ModBlocks.ZIRCONIUM_BLOCK);
        
        make3x3andReverse(this, exporter, ModItems.ACTINIUM_227_NUGGET, ModItems.ACTINIUM_227_INGOT);
        make3x3andReverse(this, exporter, ModItems.AMERICIUM_241_NUGGET, ModItems.AMERICIUM_241_INGOT);
        make3x3andReverse(this, exporter, ModItems.AMERICIUM_242_NUGGET, ModItems.AMERICIUM_242_INGOT);
        make3x3andReverse(this, exporter, ModItems.AMERICIUM_FUEL_NUGGET, ModItems.AMERICIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, ModItems.REACTOR_GRADE_AMERICIUM_NUGGET, ModItems.REACTOR_GRADE_AMERICIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.ARSENIC_NUGGET, ModItems.ARSENIC_INGOT);
        make3x3andReverse(this, exporter, ModItems.AUSTRALIUM_NUGGET, ModItems.AUSTRALIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.BERYLLIUM_NUGGET, ModItems.BERYLLIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.BISMUTH_NUGGET, ModItems.BISMUTH_INGOT);
        make3x3andReverse(this, exporter, ModItems.COBALT_NUGGET, ModItems.COBALT_INGOT);
        make3x3andReverse(this, exporter, ModItems.COBALT_60_NUGGET, ModItems.COBALT_60_INGOT);
        make3x3andReverse(this, exporter, ModItems.DESH_NUGGET, ModItems.DESH_INGOT);
        make3x3andReverse(this, exporter, ModItems.DINEUTRONIUM_NUGGET, ModItems.DINEUTRONIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.EUPHEMIUM_NUGGET, ModItems.EUPHEMIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.GHIORSIUM_336_NUGGET, ModItems.GHIORSIUM_336_INGOT);
        make3x3andReverse(this, exporter, ModItems.GOLD_198_NUGGET, ModItems.GOLD_198_INGOT);
        make3x3andReverse(this, exporter, ModItems.LEAD_NUGGET, ModItems.LEAD_INGOT);
        make3x3andReverse(this, exporter, ModItems.LEAD_209_NUGGET, ModItems.LEAD_209_INGOT);
        make3x3andReverse(this, exporter, ModItems.MOX_FUEL_NUGGET, ModItems.MOX_FUEL_INGOT);
        make3x3andReverse(this, exporter, ModItems.NEPTUNIUM_NUGGET, ModItems.NEPTUNIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.NEPTUNIUM_FUEL_NUGGET, ModItems.NEPTUNIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, ModItems.NIOBIUM_NUGGET, ModItems.NIOBIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.OSMIRIDIUM_NUGGET, ModItems.OSMIRIDIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.PLUTONIUM_NUGGET, ModItems.PLUTONIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.PLUTONIUM_FUEL_NUGGET, ModItems.PLUTONIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, ModItems.REACTOR_GRADE_PLUTONIUM_NUGGET, ModItems.REACTOR_GRADE_PLUTONIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.PLUTONIUM_238_NUGGET, ModItems.PLUTONIUM_238_INGOT);
        make3x3andReverse(this, exporter, ModItems.PLUTONIUM_239_NUGGET, ModItems.PLUTONIUM_239_INGOT);
        make3x3andReverse(this, exporter, ModItems.PLUTONIUM_240_NUGGET, ModItems.PLUTONIUM_240_INGOT);
        make3x3andReverse(this, exporter, ModItems.PLUTONIUM_241_NUGGET, ModItems.PLUTONIUM_241_INGOT);
        make3x3andReverse(this, exporter, ModItems.POLONIUM_210_NUGGET, ModItems.POLONIUM_210_INGOT);
        make3x3andReverse(this, exporter, ModItems.RADIUM_226_NUGGET, ModItems.RADIUM_226_INGOT);
        make3x3andReverse(this, exporter, ModItems.SCHRABIDIUM_NUGGET, ModItems.SCHRABIDIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.SCHRABIDIUM_FUEL_NUGGET, ModItems.SCHRABIDIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, ModItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_NUGGET, ModItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, ModItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_NUGGET, ModItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, ModItems.SILICON_NUGGET, ModItems.SILICON_BOULE);
        make3x3andReverse(this, exporter, ModItems.SOLINIUM_NUGGET, ModItems.SOLINIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.STRONTIUM_90_NUGGET, ModItems.STRONTIUM_90_INGOT);
        make3x3andReverse(this, exporter, ModItems.TANTALUM_NUGGET, ModItems.TANTALUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.TECHNETIUM_99_NUGGET, ModItems.TECHNETIUM_99_INGOT);
        make3x3andReverse(this, exporter, ModItems.THORIUM_232_NUGGET, ModItems.THORIUM_232_INGOT);
        make3x3andReverse(this, exporter, ModItems.THORIUM_FUEL_NUGGET, ModItems.THORIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, ModItems.URANIUM_NUGGET, ModItems.URANIUM_INGOT);
        make3x3andReverse(this, exporter, ModItems.URANIUM_FUEL_NUGGET, ModItems.URANIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, ModItems.URANIUM_233_NUGGET, ModItems.URANIUM_233_INGOT);
        make3x3andReverse(this, exporter, ModItems.URANIUM_235_NUGGET, ModItems.URANIUM_235_INGOT);
        make3x3andReverse(this, exporter, ModItems.URANIUM_238_NUGGET, ModItems.URANIUM_238_INGOT);
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
  private void make3x3andReverse(
      RecipeGenerator generator,
      RecipeExporter exporter,
      ItemConvertible material,
      ItemConvertible output
  ){
    make3x3(generator, exporter, material, output);
    generator.createShapeless(RecipeCategory.MISC, material, 9)
        .input(output)
        .criterion(RecipeGenerator.hasItem(output), generator.conditionsFromItem(output))
        .offerTo(exporter, material.asItem().toString() + "_from_reverse_3x3");
  }
  private void make3x3(
      RecipeGenerator generator,
      RecipeExporter exporter,
      ItemConvertible material,
      ItemConvertible output
  ){
    generator.createShaped(RecipeCategory.MISC, output, 1)
        .pattern("MMM")
        .pattern("MMM")
        .pattern("MMM")
        .input('M', material)
        .criterion(RecipeGenerator.hasItem(material), generator.conditionsFromItem(material))
        .offerTo(exporter, output.asItem().toString() + "_from_3x3");
  }
  
  @Override
  public String getName() {
    return NTM.MOD_NAME + " Crafting-Recipe Provider";
  }
}
