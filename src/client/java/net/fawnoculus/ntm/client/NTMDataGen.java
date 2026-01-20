package net.fawnoculus.ntm.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.client.datagen.NTMAdvancementProvider;
import net.fawnoculus.ntm.client.datagen.NTMEnchantmentProvider;
import net.fawnoculus.ntm.client.datagen.NTMModelProvider;
import net.fawnoculus.ntm.client.datagen.NTMRegistryProvider;
import net.fawnoculus.ntm.client.datagen.loot.NTMBlockLootProvider;
import net.fawnoculus.ntm.client.datagen.loot.NTMChestLootProvider;
import net.fawnoculus.ntm.client.datagen.loot.NTMEntityLootProvider;
import net.fawnoculus.ntm.client.datagen.recipes.NTMCraftingRecipeProvider;
import net.fawnoculus.ntm.client.datagen.recipes.NTMSmeltingRecipeProvider;
import net.fawnoculus.ntm.client.datagen.tags.NTMBlockTagProvider;
import net.fawnoculus.ntm.client.datagen.tags.NTMDamageTypeTagProvider;
import net.fawnoculus.ntm.client.datagen.tags.NTMEntityTypeTagProvider;
import net.fawnoculus.ntm.client.datagen.tags.NTMItemTagProvider;
import net.fawnoculus.ntm.world.NTMConfiguredFeatures;
import net.fawnoculus.ntm.world.NTMPlacedFeatures;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
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
    public void buildRegistry(@NotNull RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, NTMConfiguredFeatures::initialize);
        registryBuilder.add(Registries.PLACED_FEATURE, NTMPlacedFeatures::initialize);
    }

    @Override
    public @Nullable String getEffectiveModId() {
        return NTM.MOD_ID;
    }
}
