package net.fawnoculus.ntm.misc.tags;

import net.fawnoculus.ntm.main.NTM;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModEntityTypeTags {
  
  private static TagKey<EntityType<?>> createTagKey(String name){
    return TagKey.of(RegistryKeys.ENTITY_TYPE, NTM.id(name));
  }
}
