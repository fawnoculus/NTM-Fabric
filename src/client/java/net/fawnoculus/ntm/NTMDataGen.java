package net.fawnoculus.ntm;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fawnoculus.ntm.datagen.NTMAdvancementProvider;
import net.fawnoculus.ntm.datagen.NTMEnchantmentProvider;
import net.fawnoculus.ntm.datagen.NTMModelProvider;
import net.fawnoculus.ntm.datagen.NTMRegistryProvider;
import net.fawnoculus.ntm.datagen.loot.NTMBlockLootProvider;
import net.fawnoculus.ntm.datagen.loot.NTMChestLootProvider;
import net.fawnoculus.ntm.datagen.loot.NTMEntityLootProvider;
import net.fawnoculus.ntm.datagen.recipes.NTMCraftingRecipeProvider;
import net.fawnoculus.ntm.datagen.recipes.NTMSmeltingRecipeProvider;
import net.fawnoculus.ntm.datagen.tags.NTMBlockTagProvider;
import net.fawnoculus.ntm.datagen.tags.NTMDamageTypeTagProvider;
import net.fawnoculus.ntm.datagen.tags.NTMEntityTypeTagProvider;
import net.fawnoculus.ntm.datagen.tags.NTMItemTagProvider;
import net.fawnoculus.ntm.world.NTMConfiguredFeatures;
import net.fawnoculus.ntm.world.NTMPlacedFeatures;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NTMDataGen implements DataGeneratorEntrypoint {
  @Override
  public void onInitializeDataGenerator(@NotNull FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

    pack.addProvider(NTMRegistryProvider::new);

    pack.addProvider(NTMItemTagProvider::new);
    pack.addProvider(NTMBlockTagProvider::new);
    pack.addProvider(NTMEntityTypeTagProvider::new);
    pack.addProvider(NTMDamageTypeTagProvider::new);

    pack.addProvider(NTMBlockLootProvider::new);
    pack.addProvider(NTMChestLootProvider::new);
    pack.addProvider(NTMEntityLootProvider::new);

    pack.addProvider(NTMAdvancementProvider::new);

    pack.addProvider(NTMCraftingRecipeProvider::new);
    pack.addProvider(NTMSmeltingRecipeProvider::new);

    pack.addProvider(NTMEnchantmentProvider::new);

    pack.addProvider(NTMModelProvider::new);
  }

  @Override
  public void buildRegistry(@NotNull RegistryBuilder registryBuilder) {
    registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, NTMConfiguredFeatures::initialize);
    registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, NTMPlacedFeatures::initialize);
  }

  @Override
  public @Nullable String getEffectiveModId() {
    return NTM.MOD_ID;
  }
}
