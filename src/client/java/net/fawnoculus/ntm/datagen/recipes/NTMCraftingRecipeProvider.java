package net.fawnoculus.ntm.datagen.recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.NTM;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class NTMCraftingRecipeProvider extends FabricRecipeProvider {
  public NTMCraftingRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  public RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
    return new RecipeGenerator(registryLookup, exporter) {
      @Override
      public void generate() {
        RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
        makeTools(this, exporter, NTMItems.STEEL_INGOT, NTMItems.STEEL_SWORD, NTMItems.STEEL_PICKAXE, NTMItems.STEEL_AXE, NTMItems.STEEL_SHOVEL, NTMItems.STEEL_HOE);
        makeTools(this, exporter, NTMItems.ADVANCED_ALLOY_INGOT, NTMItems.ADVANCED_ALLOY_SWORD, NTMItems.ADVANCED_ALLOY_PICKAXE, NTMItems.ADVANCED_ALLOY_AXE, NTMItems.ADVANCED_ALLOY_SHOVEL, NTMItems.ADVANCED_ALLOY_HOE);
        makeTools(this, exporter, NTMItems.TITANIUM_INGOT, NTMItems.TITANIUM_SWORD, NTMItems.TITANIUM_PICKAXE, NTMItems.TITANIUM_AXE, NTMItems.TITANIUM_SHOVEL, NTMItems.TITANIUM_HOE);
        makeTools(this, exporter, NTMItems.DESH_INGOT, NTMItems.DESH_SWORD, NTMItems.DESH_PICKAXE, NTMItems.DESH_AXE, NTMItems.DESH_SHOVEL, NTMItems.DESH_HOE);
        makeTools(this, exporter, NTMItems.COBALT_INGOT, NTMItems.COBALT_SWORD, NTMItems.COBALT_PICKAXE, NTMItems.COBALT_AXE, NTMItems.COBALT_SHOVEL, NTMItems.COBALT_HOE);
        makeTools(this, exporter, NTMItems.CMB_STEEL_INGOT, NTMItems.CMB_STEEL_SWORD, NTMItems.CMB_STEEL_PICKAXE, NTMItems.CMB_STEEL_AXE, NTMItems.CMB_STEEL_SHOVEL, NTMItems.CMB_STEEL_HOE);

        make3x3andReverse(this, exporter, NTMItems.ACTINIUM_227_INGOT, NTMBlocks.ACTINIUM_227_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.ADVANCED_ALLOY_INGOT, NTMBlocks.ADVANCED_ALLOY_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.ALUMINIUM_INGOT, NTMBlocks.ALUMINIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.ASBESTOS_SHEET, NTMBlocks.ASBESTOS_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.AUSTRALIUM_INGOT, NTMBlocks.AUSTRALIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.BAKELITE_BAR, NTMBlocks.BAKELITE_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.BERYLLIUM_INGOT, NTMBlocks.BERYLLIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.BISMUTH_INGOT, NTMBlocks.BISMUTH_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.BORON_INGOT, NTMBlocks.BORON_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.CADMIUM_INGOT, NTMBlocks.CADMIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.CADMIUM_STEEL_INGOT, NTMBlocks.CADMIUM_STEEL_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.CMB_STEEL_INGOT, NTMBlocks.CMB_STEEL_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.COAL_COKE, NTMBlocks.COAL_COKE_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.COBALT_INGOT, NTMBlocks.COBALT_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.COLTAN, NTMBlocks.COLTAN_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.DESH_INGOT, NTMBlocks.DESH_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.DINEUTRONIUM_INGOT, NTMBlocks.DINEUTRONIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.EUPHEMIUM_INGOT, NTMBlocks.EUPHEMIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.FERRIC_SCHARBIDATE_INGOT, NTMBlocks.FERRIC_SCHRABIDATE_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.FLUORITE, NTMBlocks.FLUORITE_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.GRAPHITE_INGOT, NTMBlocks.GRAPHITE_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.HIGH_SPEED_STEEL_INGOT, NTMBlocks.HIGH_SPEED_STEEL_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.LIGNITE_COKE, NTMBlocks.LIGNITE_COKE_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.LEAD_INGOT, NTMBlocks.LEAD_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.LITHIUM_CUBE, NTMBlocks.LITHIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.MAGNETIZED_TUNGSTEN_INGOT, NTMBlocks.MAGNETIZED_TUNGSTEN_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.MOX_FUEL_INGOT, NTMBlocks.MOX_FUEL_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.NEPTUNIUM_INGOT, NTMBlocks.NEPTUNIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.NIOBIUM_INGOT, NTMBlocks.NIOBIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.NITER, NTMBlocks.NITER_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.PETROLEUM_COKE, NTMBlocks.PETROLEUM_COKE_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.PLUTONIUM_INGOT, NTMBlocks.PLUTONIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.PLUTONIUM_FUEL_INGOT, NTMBlocks.PLUTONIUM_FUEL_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.REACTOR_GRADE_PLUTONIUM_INGOT, NTMBlocks.REACTOR_GRADE_PLUTONIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.PLUTONIUM_238_INGOT, NTMBlocks.PLUTONIUM_238_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.PLUTONIUM_239_INGOT, NTMBlocks.PLUTONIUM_239_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.PLUTONIUM_240_INGOT, NTMBlocks.PLUTONIUM_240_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.PLUTONIUM_241_INGOT, NTMBlocks.PLUTONIUM_241_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.POLONIUM_210_INGOT, NTMBlocks.POLONIUM_210_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.POLYMER_BAR, NTMBlocks.POLYMER_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.RADIUM_226_INGOT, NTMBlocks.RADIUM_226_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.RED_COPPER_INGOT, NTMBlocks.RED_COPPER_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.RED_PHOSPHORUS, NTMBlocks.RED_PHOSPHORUS_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.RUBBER_BAR, NTMBlocks.RUBBER_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.SCHRABIDIUM_INGOT, NTMBlocks.SCHRABIDIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.SCHRABIDIUM_FUEL_INGOT, NTMBlocks.SCHRABIDIUM_FUEL_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.SCHRARANIUM_INGOT, NTMBlocks.SCHRARANIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.SEMTEX_BAR, NTMBlocks.SEMTEX_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.SOLINIUM_INGOT, NTMBlocks.SOLINIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.STARMETAL_INGOT, NTMBlocks.STARMETAL_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.STEEL_INGOT, NTMBlocks.STEEL_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.SULFUR, NTMBlocks.SULFUR_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.TANTALUM_INGOT, NTMBlocks.TANTALUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.TECHNETIUM_STEEL_INGOT, NTMBlocks.TECHNETIUM_STEEL_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.THORIUM_232_INGOT, NTMBlocks.THORIUM_232_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.THORIUM_FUEL_INGOT, NTMBlocks.THORIUM_FUEL_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.TITANIUM_INGOT, NTMBlocks.TITANIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.TUNGSTEN_INGOT, NTMBlocks.TUNGSTEN_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.URANIUM_INGOT, NTMBlocks.URANIUM_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.URANIUM_FUEL_INGOT, NTMBlocks.URANIUM_FUEL_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.URANIUM_233_INGOT, NTMBlocks.URANIUM_233_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.URANIUM_235_INGOT, NTMBlocks.URANIUM_235_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.URANIUM_238_INGOT, NTMBlocks.URANIUM_238_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.WHITE_PHOSPHORUS_BAR, NTMBlocks.WHITE_PHOSPHORUS_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.YELLOWCAKE, NTMBlocks.YELLOWCAKE_BLOCK);
        make3x3andReverse(this, exporter, NTMItems.ZIRCONIUM_CUBE, NTMBlocks.ZIRCONIUM_BLOCK);

        make3x3andReverse(this, exporter, NTMItems.ACTINIUM_227_NUGGET, NTMItems.ACTINIUM_227_INGOT);
        make3x3andReverse(this, exporter, NTMItems.AMERICIUM_241_NUGGET, NTMItems.AMERICIUM_241_INGOT);
        make3x3andReverse(this, exporter, NTMItems.AMERICIUM_242_NUGGET, NTMItems.AMERICIUM_242_INGOT);
        make3x3andReverse(this, exporter, NTMItems.AMERICIUM_FUEL_NUGGET, NTMItems.AMERICIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, NTMItems.REACTOR_GRADE_AMERICIUM_NUGGET, NTMItems.REACTOR_GRADE_AMERICIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.ARSENIC_NUGGET, NTMItems.ARSENIC_INGOT);
        make3x3andReverse(this, exporter, NTMItems.AUSTRALIUM_NUGGET, NTMItems.AUSTRALIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.BERYLLIUM_NUGGET, NTMItems.BERYLLIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.BISMUTH_NUGGET, NTMItems.BISMUTH_INGOT);
        make3x3andReverse(this, exporter, NTMItems.COBALT_NUGGET, NTMItems.COBALT_INGOT);
        make3x3andReverse(this, exporter, NTMItems.COBALT_60_NUGGET, NTMItems.COBALT_60_INGOT);
        make3x3andReverse(this, exporter, NTMItems.DESH_NUGGET, NTMItems.DESH_INGOT);
        make3x3andReverse(this, exporter, NTMItems.DINEUTRONIUM_NUGGET, NTMItems.DINEUTRONIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.EUPHEMIUM_NUGGET, NTMItems.EUPHEMIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.GHIORSIUM_336_NUGGET, NTMItems.GHIORSIUM_336_INGOT);
        make3x3andReverse(this, exporter, NTMItems.GOLD_198_NUGGET, NTMItems.GOLD_198_INGOT);
        make3x3andReverse(this, exporter, NTMItems.LEAD_NUGGET, NTMItems.LEAD_INGOT);
        make3x3andReverse(this, exporter, NTMItems.LEAD_209_NUGGET, NTMItems.LEAD_209_INGOT);
        make3x3andReverse(this, exporter, NTMItems.MOX_FUEL_NUGGET, NTMItems.MOX_FUEL_INGOT);
        make3x3andReverse(this, exporter, NTMItems.NEPTUNIUM_NUGGET, NTMItems.NEPTUNIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.NEPTUNIUM_FUEL_NUGGET, NTMItems.NEPTUNIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, NTMItems.NIOBIUM_NUGGET, NTMItems.NIOBIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.OSMIRIDIUM_NUGGET, NTMItems.OSMIRIDIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.PLUTONIUM_NUGGET, NTMItems.PLUTONIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.PLUTONIUM_FUEL_NUGGET, NTMItems.PLUTONIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, NTMItems.REACTOR_GRADE_PLUTONIUM_NUGGET, NTMItems.REACTOR_GRADE_PLUTONIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.PLUTONIUM_238_NUGGET, NTMItems.PLUTONIUM_238_INGOT);
        make3x3andReverse(this, exporter, NTMItems.PLUTONIUM_239_NUGGET, NTMItems.PLUTONIUM_239_INGOT);
        make3x3andReverse(this, exporter, NTMItems.PLUTONIUM_240_NUGGET, NTMItems.PLUTONIUM_240_INGOT);
        make3x3andReverse(this, exporter, NTMItems.PLUTONIUM_241_NUGGET, NTMItems.PLUTONIUM_241_INGOT);
        make3x3andReverse(this, exporter, NTMItems.POLONIUM_210_NUGGET, NTMItems.POLONIUM_210_INGOT);
        make3x3andReverse(this, exporter, NTMItems.RADIUM_226_NUGGET, NTMItems.RADIUM_226_INGOT);
        make3x3andReverse(this, exporter, NTMItems.SCHRABIDIUM_NUGGET, NTMItems.SCHRABIDIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.SCHRABIDIUM_FUEL_NUGGET, NTMItems.SCHRABIDIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_NUGGET, NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_NUGGET, NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, NTMItems.SILICON_NUGGET, NTMItems.SILICON_BOULE);
        make3x3andReverse(this, exporter, NTMItems.SOLINIUM_NUGGET, NTMItems.SOLINIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.STRONTIUM_90_NUGGET, NTMItems.STRONTIUM_90_INGOT);
        make3x3andReverse(this, exporter, NTMItems.TANTALUM_NUGGET, NTMItems.TANTALUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.TECHNETIUM_99_NUGGET, NTMItems.TECHNETIUM_99_INGOT);
        make3x3andReverse(this, exporter, NTMItems.THORIUM_232_NUGGET, NTMItems.THORIUM_232_INGOT);
        make3x3andReverse(this, exporter, NTMItems.THORIUM_FUEL_NUGGET, NTMItems.THORIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, NTMItems.URANIUM_NUGGET, NTMItems.URANIUM_INGOT);
        make3x3andReverse(this, exporter, NTMItems.URANIUM_FUEL_NUGGET, NTMItems.URANIUM_FUEL_INGOT);
        make3x3andReverse(this, exporter, NTMItems.URANIUM_233_NUGGET, NTMItems.URANIUM_233_INGOT);
        make3x3andReverse(this, exporter, NTMItems.URANIUM_235_NUGGET, NTMItems.URANIUM_235_INGOT);
        make3x3andReverse(this, exporter, NTMItems.URANIUM_238_NUGGET, NTMItems.URANIUM_238_INGOT);
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
  ) {
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
  ) {
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
  ) {
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
