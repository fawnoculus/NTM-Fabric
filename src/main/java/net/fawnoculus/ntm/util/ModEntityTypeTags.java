package net.fawnoculus.ntm.util;

import net.fawnoculus.ntm.main.NTM;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModEntityTypeTags {
  
  private static TagKey<EntityType<?>> createTagKey(String name){
    return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(NTM.MOD_ID, name));
  }
}
