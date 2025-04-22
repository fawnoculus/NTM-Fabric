package net.fawnoculus.ntm.main;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fawnoculus.ntm.datagen.AdvancementProvider;
import net.fawnoculus.ntm.datagen.ModelProvider;
import net.fawnoculus.ntm.datagen.loot.BlockLootProvider;
import net.fawnoculus.ntm.datagen.loot.ChestLootProvider;
import net.fawnoculus.ntm.datagen.loot.EntityLootProvider;
import net.fawnoculus.ntm.datagen.recipes.CraftingRecipeProvider;
import net.fawnoculus.ntm.datagen.recipes.SmeltingRecipeProvider;
import net.fawnoculus.ntm.datagen.tags.BlockTagProvider;
import net.fawnoculus.ntm.datagen.tags.EntityTypeTagProvider;
import net.fawnoculus.ntm.datagen.tags.ItemTagProvider;

public class NTMDataGenerator implements DataGeneratorEntrypoint {
  
  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
    
    pack.addProvider(ItemTagProvider::new);
    pack.addProvider(BlockTagProvider::new);
    pack.addProvider(EntityTypeTagProvider::new);
    
    pack.addProvider(BlockLootProvider::new);
    pack.addProvider(ChestLootProvider::new);
    pack.addProvider(EntityLootProvider::new);
    
    pack.addProvider(AdvancementProvider::new);
    
    pack.addProvider(ModelProvider::new);
    
    pack.addProvider(CraftingRecipeProvider::new);
    pack.addProvider(SmeltingRecipeProvider::new);
  }
}
