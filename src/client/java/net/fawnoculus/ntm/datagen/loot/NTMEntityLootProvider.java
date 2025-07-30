package net.fawnoculus.ntm.datagen.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootTableProvider;
import net.fawnoculus.ntm.NTM;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class NTMEntityLootProvider extends FabricEntityLootTableProvider {
  public NTMEntityLootProvider(FabricDataOutput output, @NotNull CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
    super(output, registryLookup);
  }
  
  @Override
  public void generate() {
  
  }
  
  @Override
  public String getName() {
    return NTM.MOD_NAME + " Entity-Loot Provider";
  }
}
