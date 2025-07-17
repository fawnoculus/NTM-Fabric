package net.fawnoculus.ntm.misc.tags;

import net.fawnoculus.ntm.NTM;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModEntityTypeTags {
  
  private static TagKey<EntityType<?>> of(String name){
    return of(NTM.id(name));
  }
  private static TagKey<EntityType<?>> of(Identifier identifier){
    return TagKey.of(RegistryKeys.ENTITY_TYPE, identifier);
  }
}
