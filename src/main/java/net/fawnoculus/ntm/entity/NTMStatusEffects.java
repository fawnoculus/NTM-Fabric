package net.fawnoculus.ntm.entity;

import net.fawnoculus.ntm.entity.effects.*;
import net.fawnoculus.ntm.NTM;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.ColorHelper;

public class NTMStatusEffects {
  // TODO
  public static final RegistryEntry<StatusEffect> ASTOLFIZATION = of("astolfization",
    new LeadPoisoningEffect(StatusEffectCategory.HARMFUL, color(55, 55, 60))
  );

  // TODO
  public static final RegistryEntry<StatusEffect> CONTAMINATED = of("contaminated",
    new LeadPoisoningEffect(StatusEffectCategory.HARMFUL, color(55, 55, 60))
  );

  // TODO
  public static final RegistryEntry<StatusEffect> EXPLOSION = of("explosion",
    new LeadPoisoningEffect(StatusEffectCategory.HARMFUL, color(55, 55, 60))
  );

  public static final RegistryEntry<StatusEffect> LEAD_POISONING = of("lead_poisoning",
    new LeadPoisoningEffect(StatusEffectCategory.HARMFUL, color(55, 55, 60))
  );

  public static final RegistryEntry<StatusEffect> PHOSPHORUS_BURNS = of("phosphorus_burns",
    new PhosphorusBurnStatusEffect(StatusEffectCategory.HARMFUL, color(255, 100, 0))
  );

  // TODO
  public static final RegistryEntry<StatusEffect> POTION_SICKNESS = of("potion_sickness",
    new LeadPoisoningEffect(StatusEffectCategory.HARMFUL, color(55, 55, 60))
  );

  public static final RegistryEntry<StatusEffect> RAD_AWAY = of("rad_away",
      new RadAwayEffect(StatusEffectCategory.BENEFICIAL, color(230, 75, 30))
  );

  public static final RegistryEntry<StatusEffect> RAD_X = of("rad_x",
      new GenericStatusEffect(StatusEffectCategory.BENEFICIAL, color(250, 100, 40))
  );

  // TODO
  public static final RegistryEntry<StatusEffect> STABILITY = of("stability",
    new LeadPoisoningEffect(StatusEffectCategory.HARMFUL, color(55, 55, 60))
  );

  public static final RegistryEntry<StatusEffect> TAINT = of("taint",
      new TaintEffect(StatusEffectCategory.BENEFICIAL, color(120, 40, 200))
  );

  public static final RegistryEntry<StatusEffect> TAINTED_HEART = of("tainted_heart",
      new GenericStatusEffect(StatusEffectCategory.BENEFICIAL, color(200, 40, 75))
  );

  private static RegistryEntry<StatusEffect> of(String name, StatusEffect effect){
    return Registry.registerReference(Registries.STATUS_EFFECT, NTM.id(name), effect);
  }

  private static int color(int red, int green, int blue){
    return ColorHelper.getArgb(red, green, blue);
  }

  public static void initialize(){}
}
