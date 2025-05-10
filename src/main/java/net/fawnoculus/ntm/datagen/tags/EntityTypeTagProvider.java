package net.fawnoculus.ntm.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EntityTypeTagProvider extends FabricTagProvider<EntityType<?>> {
  public EntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, RegistryKeys.ENTITY_TYPE, registriesFuture);
  }
  
  
  @Override
  protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {}
  
  @Override
  public String getName() {
    return NTM.MOD_ID + " EntityType-Tag Provider";
  }
}
