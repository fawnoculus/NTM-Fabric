package net.fawnoculus.ntm.datagen.recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.NTM;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NTMSmeltingRecipeProvider extends FabricRecipeProvider {
  public NTMSmeltingRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }
  
  @Override
  public RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
    return new RecipeGenerator(registryLookup, exporter) {
      @Override
      public void generate() {
        float xp = 1.0f;
        int time = 300;
        makeOreSmelts(this, xp, time, "uranium", NTMItems.URANIUM_INGOT, List.of(NTMItems.RAW_URANIUM, NTMBlocks.URANIUM_ORE, NTMBlocks.NETHER_URANIUM_ORE, NTMBlocks.SCHIST_URANIUM_ORE));
        makeOreSmelts(this, xp, time, "scorched_uranium", NTMItems.URANIUM_INGOT, List.of(NTMItems.RAW_SCORCHED_URANIUM, NTMBlocks.SCORCHED_URANIUM_ORE, NTMBlocks.SCORCHED_NETHER_URANIUM_ORE, NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE));
        makeOreSmelts(this, xp, time, "australium", NTMItems.AUSTRALIUM_INGOT, List.of(NTMItems.RAW_AUSTRALIUM, NTMBlocks.AUSTRALIUM_ORE));
        makeOreSmelts(this, xp, time, "lead", NTMItems.LEAD_INGOT, List.of(NTMItems.RAW_LEAD, NTMBlocks.LEAD_ORE));
        makeOreSmelts(this, xp, time, "plutonium", NTMItems.PLUTONIUM_INGOT, List.of(NTMItems.RAW_PLUTONIUM, NTMBlocks.NETHER_PLUTONIUM_ORE));
        makeOreSmelts(this, xp, time, "thorium", NTMItems.THORIUM_232_INGOT, List.of(NTMItems.RAW_THORIUM, NTMBlocks.THORIUM_ORE));
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
    return NTM.MOD_NAME + " Smelting-Recipe Provider";
  }
}