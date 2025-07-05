package net.fawnoculus.ntm.datagen.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ChestLootProvider extends SimpleFabricLootTableProvider {
  public ChestLootProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
    super(output, registryLookup, LootContextTypes.CHEST);
  }
  
  @Override
  public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
  
  }
  
  @Override
  public String getName() {
    return NTM.MOD_NAME + " Chest-Loot Provider";
  }
}
