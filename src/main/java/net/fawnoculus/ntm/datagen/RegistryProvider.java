package net.fawnoculus.ntm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class RegistryProvider extends FabricDynamicRegistryProvider {
  public RegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }
  
  @Override
  protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
    entries.addAll(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE));
    entries.addAll(registries.getOrThrow(RegistryKeys.PLACED_FEATURE));
  }
  
  @Override
  public String getName() {
    return NTM.MOD_NAME + " Dynamic-Registry Provider";
  }
}
