package net.fawnoculus.ntm.misc.tags;

import net.fawnoculus.ntm.NTM;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class NTMEntityTypeTags {

    private static TagKey<EntityType<?>> of(String name) {
        return of(NTM.id(name));
    }

    private static TagKey<EntityType<?>> of(Identifier identifier) {
        return TagKey.create(Registries.ENTITY_TYPE, identifier);
    }
}
