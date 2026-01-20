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
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NTMSmeltingRecipeProvider extends FabricRecipeProvider {
    public NTMSmeltingRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                float xp = 1.0f;
                int time = 300;
                ore(this, xp, time, "uranium", NTMItems.URANIUM_INGOT, List.of(NTMItems.RAW_URANIUM, NTMBlocks.URANIUM_ORE, NTMBlocks.DEEPSLATE_URANIUM_ORE, NTMBlocks.NETHER_URANIUM_ORE, NTMBlocks.SCHIST_URANIUM_ORE));
                ore(this, xp, time, "scorched_uranium", NTMItems.URANIUM_INGOT, List.of(NTMItems.RAW_SCORCHED_URANIUM, NTMBlocks.SCORCHED_URANIUM_ORE, NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE, NTMBlocks.SCORCHED_NETHER_URANIUM_ORE, NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE));
                ore(this, xp, time, "australium", NTMItems.AUSTRALIUM_INGOT, List.of(NTMItems.RAW_AUSTRALIUM, NTMBlocks.AUSTRALIUM_ORE, NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE));
                ore(this, xp, time, "lead", NTMItems.LEAD_INGOT, List.of(NTMItems.RAW_LEAD, NTMBlocks.LEAD_ORE, NTMBlocks.DEEPSLATE_LEAD_ORE));
                ore(this, xp, time, "plutonium", NTMItems.PLUTONIUM_INGOT, List.of(NTMItems.RAW_PLUTONIUM, NTMBlocks.NETHER_PLUTONIUM_ORE));
                ore(this, xp, time, "thorium", NTMItems.THORIUM_232_INGOT, List.of(NTMItems.RAW_THORIUM, NTMBlocks.THORIUM_ORE, NTMBlocks.DEEPSLATE_THORIUM_ORE));
            }
        };
    }

    private void ore(RecipeProvider generator, float xp, int time, String group, ItemLike result, List<ItemLike> ores) {
        generator.oreSmelting(
          ores,
          RecipeCategory.MISC,
          result,
          xp,
          time,
          group
        );
        generator.oreBlasting(
          ores,
          RecipeCategory.MISC,
          result,
          xp,
          time / 2,
          group
        );
    }

    @Override
    public String getName() {
        return NTM.MOD_NAME + " Smelting-Recipe Provider";
    }
}
