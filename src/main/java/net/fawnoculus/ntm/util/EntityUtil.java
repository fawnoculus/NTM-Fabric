package net.fawnoculus.ntm.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.Collection;

public class EntityUtil {
  public static void removeNegativeEffects(PlayerEntity player){
    Collection<StatusEffectInstance> effectInstances = player.getStatusEffects();
    for(StatusEffectInstance effectInstance : effectInstances){
      if(!effectInstance.getEffectType().value().isBeneficial()){
        player.removeStatusEffect(effectInstance.getEffectType());
      }
    }
  }
  
  public static DamageSource newGenericDamageSource(World world, RegistryKey<DamageType> damageTypeKey){
    DamageType damageType = world.getRegistryManager()
        .getOrThrow(RegistryKeys.DAMAGE_TYPE)
        .get(damageTypeKey);
    if(damageType == null){
      damageType = world.getRegistryManager()
          .getOrThrow(RegistryKeys.DAMAGE_TYPE)
          .get(DamageTypes.GENERIC);
    }
    RegistryEntry<DamageType> damageTypeEntry = world.getRegistryManager()
        .getOrThrow(RegistryKeys.DAMAGE_TYPE)
        .getEntry(damageType);
    return new DamageSource(damageTypeEntry);
  }
  
  public static void applyDamage(Entity entity, ServerWorld serverWorld, RegistryKey<DamageType> damageTypeKey, float amount){
    entity.damage(serverWorld, newGenericDamageSource(serverWorld, damageTypeKey), amount);
  }
}
