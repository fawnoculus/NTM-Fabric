package net.fawnoculus.ntm.entity;

import net.fawnoculus.ntm.entity.effects.RadAwayEffect;
import net.fawnoculus.ntm.entity.effects.RadXEffect;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.ColorHelper;

public class ModStatusEffects {
  public static final RegistryEntry<StatusEffect> RAD_AWAY = Registry.registerReference(Registries.STATUS_EFFECT, NTM.id("rad_away"),
      new RadAwayEffect(StatusEffectCategory.BENEFICIAL, ColorHelper.getArgb(230, 75, 30)));
  public static final RegistryEntry<StatusEffect> RAD_X = Registry.registerReference(Registries.STATUS_EFFECT, NTM.id("rad_x"),
      new RadXEffect(StatusEffectCategory.BENEFICIAL, ColorHelper.getArgb(230, 75, 30)));
  
  public static void initialize(){}
}
