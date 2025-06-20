package net.fawnoculus.ntm.datagen.recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fawnoculus.ntm.blocks.ModBlocks;
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
  
  @Override
  public RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
    return new RecipeGenerator(registryLookup, exporter) {
      @Override
      public void generate() {
        float xp = 1.0f;
        int time = 300;
        makeOreSmelts(this, xp, time, "uranium", ModItems.URANIUM_INGOT, List.of(ModItems.RAW_URANIUM, ModBlocks.URANIUM_ORE, ModBlocks.NETHER_URANIUM_ORE, ModBlocks.SCHIST_URANIUM_ORE));
        makeOreSmelts(this, xp, time, "scorched_uranium", ModItems.URANIUM_INGOT, List.of(ModItems.RAW_SCORCHED_URANIUM, ModBlocks.SCORCHED_URANIUM_ORE, ModBlocks.SCORCHED_NETHER_URANIUM_ORE, ModBlocks.SCORCHED_SCHIST_URANIUM_ORE));
        makeOreSmelts(this, xp, time, "australium", ModItems.AUSTRALIUM_INGOT, List.of(ModItems.RAW_AUSTRALIUM, ModBlocks.AUSTRALIUM_ORE));
        makeOreSmelts(this, xp, time, "lead", ModItems.LEAD_INGOT, List.of(ModItems.RAW_LEAD, ModBlocks.LEAD_ORE));
        makeOreSmelts(this, xp, time, "plutonium", ModItems.PLUTONIUM_INGOT, List.of(ModItems.RAW_PLUTONIUM, ModBlocks.NETHER_PLUTONIUM_ORE));
        makeOreSmelts(this, xp, time, "thorium", ModItems.THORIUM_232_INGOT, List.of(ModItems.RAW_THORIUM, ModBlocks.THORIUM_ORE));
      }
    };
  }
  
  private void makeOreSmelts(RecipeGenerator generator, float xp, int time, String group ,ItemConvertible result, List<ItemConvertible> ores){
    generator.offerSmelting(
        ores,
        RecipeCategory.MISC,
        result,
        xp,
        time,
        group
    );
    generator.offerBlasting(
        ores,
        RecipeCategory.MISC,
        result,
        xp,
        time/2,
        group
    );
  }
  
  @Override
  public String getName() {
    return NTM.MOD_ID + " Smelting-Recipe Provider";
  }
}