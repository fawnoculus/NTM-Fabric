package net.fawnoculus.ntm.entity;

import net.fawnoculus.ntm.entity.effects.LeadPoisoningEffect;
import net.fawnoculus.ntm.entity.effects.RadAwayEffect;
import net.fawnoculus.ntm.entity.effects.RadXEffect;
import net.fawnoculus.ntm.entity.effects.TaintEffect;
import net.fawnoculus.ntm.NTM;
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
  
  public static final RegistryEntry<StatusEffect> TAINT = Registry.registerReference(Registries.STATUS_EFFECT, NTM.id("taint"),
      new TaintEffect(StatusEffectCategory.BENEFICIAL, ColorHelper.getArgb(120, 40, 200)));
  
  public static final RegistryEntry<StatusEffect> LEAD_POISONING = Registry.registerReference(Registries.STATUS_EFFECT, NTM.id("lead_poisoning"),
      new LeadPoisoningEffect(StatusEffectCategory.HARMFUL, ColorHelper.getArgb(55, 55, 60)));
  
  public static void initialize(){}
}
