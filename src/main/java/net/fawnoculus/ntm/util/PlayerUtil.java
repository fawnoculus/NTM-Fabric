package net.fawnoculus.ntm.util;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.Collection;

public class PlayerUtil {
  public static void removeNegativeEffects(PlayerEntity player){
    Collection<StatusEffectInstance> effectInstances = player.getStatusEffects();
    for(StatusEffectInstance effectInstance : effectInstances){
      if(!effectInstance.getEffectType().value().isBeneficial()){
        player.removeStatusEffect(effectInstance.getEffectType());
      }
    }
  }
  public static void addEffectDuration(PlayerEntity player, RegistryEntry<StatusEffect> effect, int ticksToAdd){
    Collection<StatusEffectInstance> effectInstances = player.getStatusEffects();
    boolean hasEffect = false;
    for(StatusEffectInstance effectInstance : effectInstances){
      if(effectInstance.getEffectType() == effect){
        player.removeStatusEffect(effectInstance.getEffectType());
        player.addStatusEffect(new StatusEffectInstance(
            effect,
            effectInstance.getDuration() + ticksToAdd,
            effectInstance.getAmplifier(),
            effectInstance.isAmbient(),
            effectInstance.shouldShowParticles(),
            effectInstance.shouldShowIcon())
        );
        hasEffect = true;
      }
    }
    
    if(!hasEffect){
      player.addStatusEffect(new StatusEffectInstance(effect, ticksToAdd, 0, false, false, true));
    }
  }
  public static void removeExperience(PlayerEntity player, int xpToRemove){
    player.addExperience(-xpToRemove);
  }
}
