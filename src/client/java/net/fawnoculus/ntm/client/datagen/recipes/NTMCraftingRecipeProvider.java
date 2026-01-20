package net.fawnoculus.ntm.client.datagen.recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.items.NTMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class NTMCraftingRecipeProvider extends FabricRecipeProvider {
    public NTMCraftingRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                makeTools(this, output, NTMItems.STEEL_INGOT, NTMItems.STEEL_SWORD, NTMItems.STEEL_PICKAXE, NTMItems.STEEL_AXE, NTMItems.STEEL_SHOVEL, NTMItems.STEEL_HOE);
                makeTools(this, output, NTMItems.ADVANCED_ALLOY_INGOT, NTMItems.ADVANCED_ALLOY_SWORD, NTMItems.ADVANCED_ALLOY_PICKAXE, NTMItems.ADVANCED_ALLOY_AXE, NTMItems.ADVANCED_ALLOY_SHOVEL, NTMItems.ADVANCED_ALLOY_HOE);
                makeTools(this, output, NTMItems.TITANIUM_INGOT, NTMItems.TITANIUM_SWORD, NTMItems.TITANIUM_PICKAXE, NTMItems.TITANIUM_AXE, NTMItems.TITANIUM_SHOVEL, NTMItems.TITANIUM_HOE);
                makeTools(this, output, NTMItems.DESH_INGOT, NTMItems.DESH_SWORD, NTMItems.DESH_PICKAXE, NTMItems.DESH_AXE, NTMItems.DESH_SHOVEL, NTMItems.DESH_HOE);
                makeTools(this, output, NTMItems.COBALT_INGOT, NTMItems.COBALT_SWORD, NTMItems.COBALT_PICKAXE, NTMItems.COBALT_AXE, NTMItems.COBALT_SHOVEL, NTMItems.COBALT_HOE);
                makeTools(this, output, NTMItems.CMB_STEEL_INGOT, NTMItems.CMB_STEEL_SWORD, NTMItems.CMB_STEEL_PICKAXE, NTMItems.CMB_STEEL_AXE, NTMItems.CMB_STEEL_SHOVEL, NTMItems.CMB_STEEL_HOE);

                make3x3andReverse(this, output, NTMItems.ACTINIUM_227_INGOT, NTMBlocks.ACTINIUM_227_BLOCK);
                make3x3andReverse(this, output, NTMItems.ADVANCED_ALLOY_INGOT, NTMBlocks.ADVANCED_ALLOY_BLOCK);
                make3x3andReverse(this, output, NTMItems.ALUMINIUM_INGOT, NTMBlocks.ALUMINIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.ASBESTOS_SHEET, NTMBlocks.ASBESTOS_BLOCK);
                make3x3andReverse(this, output, NTMItems.AUSTRALIUM_INGOT, NTMBlocks.AUSTRALIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.BAKELITE_BAR, NTMBlocks.BAKELITE_BLOCK);
                make3x3andReverse(this, output, NTMItems.BERYLLIUM_INGOT, NTMBlocks.BERYLLIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.BISMUTH_INGOT, NTMBlocks.BISMUTH_BLOCK);
                make3x3andReverse(this, output, NTMItems.BORON_INGOT, NTMBlocks.BORON_BLOCK);
                make3x3andReverse(this, output, NTMItems.CADMIUM_INGOT, NTMBlocks.CADMIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.CADMIUM_STEEL_INGOT, NTMBlocks.CADMIUM_STEEL_BLOCK);
                make3x3andReverse(this, output, NTMItems.CMB_STEEL_INGOT, NTMBlocks.CMB_STEEL_BLOCK);
                make3x3andReverse(this, output, NTMItems.COAL_COKE, NTMBlocks.COAL_COKE_BLOCK);
                make3x3andReverse(this, output, NTMItems.COBALT_INGOT, NTMBlocks.COBALT_BLOCK);
                make3x3andReverse(this, output, NTMItems.COLTAN, NTMBlocks.COLTAN_BLOCK);
                make3x3andReverse(this, output, NTMItems.DESH_INGOT, NTMBlocks.DESH_BLOCK);
                make3x3andReverse(this, output, NTMItems.DINEUTRONIUM_INGOT, NTMBlocks.DINEUTRONIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.EUPHEMIUM_INGOT, NTMBlocks.EUPHEMIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.FERRIC_SCHARBIDATE_INGOT, NTMBlocks.FERRIC_SCHRABIDATE_BLOCK);
                make3x3andReverse(this, output, NTMItems.FLUORITE, NTMBlocks.FLUORITE_BLOCK);
                make3x3andReverse(this, output, NTMItems.GRAPHITE_INGOT, NTMBlocks.GRAPHITE_BLOCK);
                make3x3andReverse(this, output, NTMItems.HIGH_SPEED_STEEL_INGOT, NTMBlocks.HIGH_SPEED_STEEL_BLOCK);
                make3x3andReverse(this, output, NTMItems.LIGNITE_COKE, NTMBlocks.LIGNITE_COKE_BLOCK);
                make3x3andReverse(this, output, NTMItems.LEAD_INGOT, NTMBlocks.LEAD_BLOCK);
                make3x3andReverse(this, output, NTMItems.LITHIUM_CUBE, NTMBlocks.LITHIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.MAGNETIZED_TUNGSTEN_INGOT, NTMBlocks.MAGNETIZED_TUNGSTEN_BLOCK);
                make3x3andReverse(this, output, NTMItems.MOX_FUEL_INGOT, NTMBlocks.MOX_FUEL_BLOCK);
                make3x3andReverse(this, output, NTMItems.NEPTUNIUM_INGOT, NTMBlocks.NEPTUNIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.NIOBIUM_INGOT, NTMBlocks.NIOBIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.NITER, NTMBlocks.NITER_BLOCK);
                make3x3andReverse(this, output, NTMItems.PETROLEUM_COKE, NTMBlocks.PETROLEUM_COKE_BLOCK);
                make3x3andReverse(this, output, NTMItems.PLUTONIUM_INGOT, NTMBlocks.PLUTONIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.PLUTONIUM_FUEL_INGOT, NTMBlocks.PLUTONIUM_FUEL_BLOCK);
                make3x3andReverse(this, output, NTMItems.REACTOR_GRADE_PLUTONIUM_INGOT, NTMBlocks.REACTOR_GRADE_PLUTONIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.PLUTONIUM_238_INGOT, NTMBlocks.PLUTONIUM_238_BLOCK);
                make3x3andReverse(this, output, NTMItems.PLUTONIUM_239_INGOT, NTMBlocks.PLUTONIUM_239_BLOCK);
                make3x3andReverse(this, output, NTMItems.PLUTONIUM_240_INGOT, NTMBlocks.PLUTONIUM_240_BLOCK);
                make3x3andReverse(this, output, NTMItems.PLUTONIUM_241_INGOT, NTMBlocks.PLUTONIUM_241_BLOCK);
                make3x3andReverse(this, output, NTMItems.POLONIUM_210_INGOT, NTMBlocks.POLONIUM_210_BLOCK);
                make3x3andReverse(this, output, NTMItems.POLYMER_BAR, NTMBlocks.POLYMER_BLOCK);
                make3x3andReverse(this, output, NTMItems.RADIUM_226_INGOT, NTMBlocks.RADIUM_226_BLOCK);
                make3x3andReverse(this, output, NTMItems.RED_COPPER_INGOT, NTMBlocks.RED_COPPER_BLOCK);
                make3x3andReverse(this, output, NTMItems.RED_PHOSPHORUS, NTMBlocks.RED_PHOSPHORUS_BLOCK);
                make3x3andReverse(this, output, NTMItems.RUBBER_BAR, NTMBlocks.RUBBER_BLOCK);
                make3x3andReverse(this, output, NTMItems.SCHRABIDIUM_INGOT, NTMBlocks.SCHRABIDIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.SCHRABIDIUM_FUEL_INGOT, NTMBlocks.SCHRABIDIUM_FUEL_BLOCK);
                make3x3andReverse(this, output, NTMItems.SCHRARANIUM_INGOT, NTMBlocks.SCHRARANIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.SEMTEX_BAR, NTMBlocks.SEMTEX_BLOCK);
                make3x3andReverse(this, output, NTMItems.SOLINIUM_INGOT, NTMBlocks.SOLINIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.STARMETAL_INGOT, NTMBlocks.STARMETAL_BLOCK);
                make3x3andReverse(this, output, NTMItems.STEEL_INGOT, NTMBlocks.STEEL_BLOCK);
                make3x3andReverse(this, output, NTMItems.SULFUR, NTMBlocks.SULFUR_BLOCK);
                make3x3andReverse(this, output, NTMItems.TANTALUM_INGOT, NTMBlocks.TANTALUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.TECHNETIUM_STEEL_INGOT, NTMBlocks.TECHNETIUM_STEEL_BLOCK);
                make3x3andReverse(this, output, NTMItems.THORIUM_232_INGOT, NTMBlocks.THORIUM_232_BLOCK);
                make3x3andReverse(this, output, NTMItems.THORIUM_FUEL_INGOT, NTMBlocks.THORIUM_FUEL_BLOCK);
                make3x3andReverse(this, output, NTMItems.TITANIUM_INGOT, NTMBlocks.TITANIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.TUNGSTEN_INGOT, NTMBlocks.TUNGSTEN_BLOCK);
                make3x3andReverse(this, output, NTMItems.URANIUM_INGOT, NTMBlocks.URANIUM_BLOCK);
                make3x3andReverse(this, output, NTMItems.URANIUM_FUEL_INGOT, NTMBlocks.URANIUM_FUEL_BLOCK);
                make3x3andReverse(this, output, NTMItems.URANIUM_233_INGOT, NTMBlocks.URANIUM_233_BLOCK);
                make3x3andReverse(this, output, NTMItems.URANIUM_235_INGOT, NTMBlocks.URANIUM_235_BLOCK);
                make3x3andReverse(this, output, NTMItems.URANIUM_238_INGOT, NTMBlocks.URANIUM_238_BLOCK);
                make3x3andReverse(this, output, NTMItems.WHITE_PHOSPHORUS_BAR, NTMBlocks.WHITE_PHOSPHORUS_BLOCK);
                make3x3andReverse(this, output, NTMItems.YELLOWCAKE, NTMBlocks.YELLOWCAKE_BLOCK);
                make3x3andReverse(this, output, NTMItems.ZIRCONIUM_CUBE, NTMBlocks.ZIRCONIUM_BLOCK);

                make3x3andReverse(this, output, NTMItems.ACTINIUM_227_NUGGET, NTMItems.ACTINIUM_227_INGOT);
                make3x3andReverse(this, output, NTMItems.AMERICIUM_241_NUGGET, NTMItems.AMERICIUM_241_INGOT);
                make3x3andReverse(this, output, NTMItems.AMERICIUM_242_NUGGET, NTMItems.AMERICIUM_242_INGOT);
                make3x3andReverse(this, output, NTMItems.AMERICIUM_FUEL_NUGGET, NTMItems.AMERICIUM_FUEL_INGOT);
                make3x3andReverse(this, output, NTMItems.REACTOR_GRADE_AMERICIUM_NUGGET, NTMItems.REACTOR_GRADE_AMERICIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.ARSENIC_NUGGET, NTMItems.ARSENIC_INGOT);
                make3x3andReverse(this, output, NTMItems.AUSTRALIUM_NUGGET, NTMItems.AUSTRALIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.BERYLLIUM_NUGGET, NTMItems.BERYLLIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.BISMUTH_NUGGET, NTMItems.BISMUTH_INGOT);
                make3x3andReverse(this, output, NTMItems.COBALT_NUGGET, NTMItems.COBALT_INGOT);
                make3x3andReverse(this, output, NTMItems.COBALT_60_NUGGET, NTMItems.COBALT_60_INGOT);
                make3x3andReverse(this, output, NTMItems.DESH_NUGGET, NTMItems.DESH_INGOT);
                make3x3andReverse(this, output, NTMItems.DINEUTRONIUM_NUGGET, NTMItems.DINEUTRONIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.EUPHEMIUM_NUGGET, NTMItems.EUPHEMIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.GHIORSIUM_336_NUGGET, NTMItems.GHIORSIUM_336_INGOT);
                make3x3andReverse(this, output, NTMItems.GOLD_198_NUGGET, NTMItems.GOLD_198_INGOT);
                make3x3andReverse(this, output, NTMItems.LEAD_NUGGET, NTMItems.LEAD_INGOT);
                make3x3andReverse(this, output, NTMItems.LEAD_209_NUGGET, NTMItems.LEAD_209_INGOT);
                make3x3andReverse(this, output, NTMItems.MOX_FUEL_NUGGET, NTMItems.MOX_FUEL_INGOT);
                make3x3andReverse(this, output, NTMItems.NEPTUNIUM_NUGGET, NTMItems.NEPTUNIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.NEPTUNIUM_FUEL_NUGGET, NTMItems.NEPTUNIUM_FUEL_INGOT);
                make3x3andReverse(this, output, NTMItems.NIOBIUM_NUGGET, NTMItems.NIOBIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.OSMIRIDIUM_NUGGET, NTMItems.OSMIRIDIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.PLUTONIUM_NUGGET, NTMItems.PLUTONIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.PLUTONIUM_FUEL_NUGGET, NTMItems.PLUTONIUM_FUEL_INGOT);
                make3x3andReverse(this, output, NTMItems.REACTOR_GRADE_PLUTONIUM_NUGGET, NTMItems.REACTOR_GRADE_PLUTONIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.PLUTONIUM_238_NUGGET, NTMItems.PLUTONIUM_238_INGOT);
                make3x3andReverse(this, output, NTMItems.PLUTONIUM_239_NUGGET, NTMItems.PLUTONIUM_239_INGOT);
                make3x3andReverse(this, output, NTMItems.PLUTONIUM_240_NUGGET, NTMItems.PLUTONIUM_240_INGOT);
                make3x3andReverse(this, output, NTMItems.PLUTONIUM_241_NUGGET, NTMItems.PLUTONIUM_241_INGOT);
                make3x3andReverse(this, output, NTMItems.POLONIUM_210_NUGGET, NTMItems.POLONIUM_210_INGOT);
                make3x3andReverse(this, output, NTMItems.RADIUM_226_NUGGET, NTMItems.RADIUM_226_INGOT);
                make3x3andReverse(this, output, NTMItems.SCHRABIDIUM_NUGGET, NTMItems.SCHRABIDIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.SCHRABIDIUM_FUEL_NUGGET, NTMItems.SCHRABIDIUM_FUEL_INGOT);
                make3x3andReverse(this, output, NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_NUGGET, NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT);
                make3x3andReverse(this, output, NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_NUGGET, NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT);
                make3x3andReverse(this, output, NTMItems.SILICON_NUGGET, NTMItems.SILICON_BOULE);
                make3x3andReverse(this, output, NTMItems.SOLINIUM_NUGGET, NTMItems.SOLINIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.STRONTIUM_90_NUGGET, NTMItems.STRONTIUM_90_INGOT);
                make3x3andReverse(this, output, NTMItems.TANTALUM_NUGGET, NTMItems.TANTALUM_INGOT);
                make3x3andReverse(this, output, NTMItems.TECHNETIUM_99_NUGGET, NTMItems.TECHNETIUM_99_INGOT);
                make3x3andReverse(this, output, NTMItems.THORIUM_232_NUGGET, NTMItems.THORIUM_232_INGOT);
                make3x3andReverse(this, output, NTMItems.THORIUM_FUEL_NUGGET, NTMItems.THORIUM_FUEL_INGOT);
                make3x3andReverse(this, output, NTMItems.URANIUM_NUGGET, NTMItems.URANIUM_INGOT);
                make3x3andReverse(this, output, NTMItems.URANIUM_FUEL_NUGGET, NTMItems.URANIUM_FUEL_INGOT);
                make3x3andReverse(this, output, NTMItems.URANIUM_233_NUGGET, NTMItems.URANIUM_233_INGOT);
                make3x3andReverse(this, output, NTMItems.URANIUM_235_NUGGET, NTMItems.URANIUM_235_INGOT);
                make3x3andReverse(this, output, NTMItems.URANIUM_238_NUGGET, NTMItems.URANIUM_238_INGOT);
            }
        };
    }

    private void makeTools(
      RecipeProvider generator,
      RecipeOutput exporter,
      ItemLike material,
      ItemLike sword,
      ItemLike pickaxe,
      ItemLike axe,
      ItemLike shovel,
      ItemLike hoe
    ) {
        generator.shaped(RecipeCategory.TOOLS, sword, 1)
          .pattern(" M ")
          .pattern(" M ")
          .pattern(" S ")
          .define('M', material)
          .define('S', Items.STICK)
          .unlockedBy(RecipeProvider.getHasName(material), generator.has(material))
          .save(exporter);
        generator.shaped(RecipeCategory.TOOLS, pickaxe, 1)
          .pattern("MMM")
          .pattern(" S ")
          .pattern(" S ")
          .define('M', material)
          .define('S', Items.STICK)
          .unlockedBy(RecipeProvider.getHasName(material), generator.has(material))
          .save(exporter);
        generator.shaped(RecipeCategory.TOOLS, axe, 1)
          .pattern(" MM")
          .pattern(" SM")
          .pattern(" S ")
          .define('M', material)
          .define('S', Items.STICK)
          .unlockedBy(RecipeProvider.getHasName(material), generator.has(material))
          .save(exporter);
        generator.shaped(RecipeCategory.TOOLS, shovel, 1)
          .pattern(" M ")
          .pattern(" S ")
          .pattern(" S ")
          .define('M', material)
          .define('S', Items.STICK)
          .unlockedBy(RecipeProvider.getHasName(material), generator.has(material))
          .save(exporter);
        generator.shaped(RecipeCategory.TOOLS, hoe, 1)
          .pattern(" MM")
          .pattern(" S ")
          .pattern(" S ")
          .define('M', material)
          .define('S', Items.STICK)
          .unlockedBy(RecipeProvider.getHasName(material), generator.has(material))
          .save(exporter);
    }

    private void make3x3andReverse(
      RecipeProvider generator,
      RecipeOutput exporter,
      ItemLike material,
      ItemLike output
    ) {
        make3x3(generator, exporter, material, output);
        generator.shapeless(RecipeCategory.MISC, material, 9)
          .requires(output)
          .unlockedBy(RecipeProvider.getHasName(output), generator.has(output))
          .save(exporter, material.asItem() + "_from_reverse_3x3");
    }

    private void make3x3(
      RecipeProvider generator,
      RecipeOutput exporter,
      ItemLike material,
      ItemLike output
    ) {
        generator.shaped(RecipeCategory.MISC, output, 1)
          .pattern("MMM")
          .pattern("MMM")
          .pattern("MMM")
          .define('M', material)
          .unlockedBy(RecipeProvider.getHasName(material), generator.has(material))
          .save(exporter, output.asItem() + "_from_3x3");
    }

    @Override
    public String getName() {
        return NTM.MOD_NAME + " Crafting-Recipe Provider";
    }
}
