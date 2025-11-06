package net.fawnoculus.ntm.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.NTM;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class NTMEntityTypeTagProvider extends FabricTagProvider<EntityType<?>> {
	public NTMEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, RegistryKeys.ENTITY_TYPE, registriesFuture);
	}


	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
	}

	private static Identifier id(EntityType<?> entityType) {
		return Registries.ENTITY_TYPE.getId(entityType);
	}

	@Override
	public String getName() {
		return NTM.MOD_NAME + " EntityType-Tag Provider";
	}
}
