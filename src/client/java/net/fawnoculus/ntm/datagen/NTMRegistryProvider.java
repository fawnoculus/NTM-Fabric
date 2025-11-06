package net.fawnoculus.ntm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fawnoculus.ntm.NTM;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class NTMRegistryProvider extends FabricDynamicRegistryProvider {
	public NTMRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.@NotNull WrapperLookup registries, @NotNull Entries entries) {
		entries.addAll(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE));
		entries.addAll(registries.getOrThrow(RegistryKeys.PLACED_FEATURE));
	}

	@Override
	public String getName() {
		return NTM.MOD_NAME + " Dynamic-Registry Provider";
	}
}
