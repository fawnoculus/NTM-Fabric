package net.fawnoculus.ntm.client.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.NTM;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;

import java.util.concurrent.CompletableFuture;

public class NTMEntityTypeTagProvider extends FabricTagProvider<EntityType<?>> {
    public NTMEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.ENTITY_TYPE, registriesFuture);
    }

    private static Identifier id(EntityType<?> entityType) {
        return BuiltInRegistries.ENTITY_TYPE.getKey(entityType);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
    }

    @Override
    public String getName() {
        return NTM.MOD_NAME + " EntityType-Tag Provider";
    }
}
