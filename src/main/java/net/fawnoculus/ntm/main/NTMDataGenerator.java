package net.fawnoculus.ntm.main;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fawnoculus.ntm.datagen.AdvancementProvider;
import net.fawnoculus.ntm.datagen.EnchantmentProvider;
import net.fawnoculus.ntm.datagen.ModelProvider;
import net.fawnoculus.ntm.datagen.RegistryProvider;
import net.fawnoculus.ntm.datagen.loot.BlockLootProvider;
import net.fawnoculus.ntm.datagen.loot.ChestLootProvider;
import net.fawnoculus.ntm.datagen.loot.EntityLootProvider;
import net.fawnoculus.ntm.datagen.recipes.CraftingRecipeProvider;
import net.fawnoculus.ntm.datagen.recipes.SmeltingRecipeProvider;
import net.fawnoculus.ntm.datagen.tags.BlockTagProvider;
import net.fawnoculus.ntm.datagen.tags.DamageTypeTagProvider;
import net.fawnoculus.ntm.datagen.tags.EntityTypeTagProvider;
import net.fawnoculus.ntm.datagen.tags.ItemTagProvider;
import net.fawnoculus.ntm.world.ModConfiguredFeatures;
import net.fawnoculus.ntm.world.ModPlacedFeatures;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class NTMDataGenerator implements DataGeneratorEntrypoint {
  
  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
    
    pack.addProvider(RegistryProvider::new);
    
    pack.addProvider(ItemTagProvider::new);
    pack.addProvider(BlockTagProvider::new);
    pack.addProvider(EntityTypeTagProvider::new);
    pack.addProvider(DamageTypeTagProvider::new);
    
    pack.addProvider(BlockLootProvider::new);
    pack.addProvider(ChestLootProvider::new);
    pack.addProvider(EntityLootProvider::new);
    
    pack.addProvider(AdvancementProvider::new);
    
    pack.addProvider(CraftingRecipeProvider::new);
    pack.addProvider(SmeltingRecipeProvider::new);
    
    
    pack.addProvider(EnchantmentProvider::new);
    
    pack.addProvider(ModelProvider::new);
  }
  
  @Override
  public void buildRegistry(RegistryBuilder registryBuilder) {
    registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::initialize);
    registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::initialize);
  }
}
