package net.fawnoculus.ntm.entity;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.entity.effects.*;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.ARGB;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class NTMStatusEffects {
    // TODO
    public static final Holder<MobEffect> ASTOLFIZATION = of("astolfization",
      new LeadPoisoningEffect(MobEffectCategory.HARMFUL, color(55, 55, 60))
    );

    // TODO
    public static final Holder<MobEffect> CONTAMINATED = of("contaminated",
      new GenericStatusEffect(MobEffectCategory.HARMFUL, color(55, 55, 60))
    );

    public static final Holder<MobEffect> EXPLOSION = of("explosion",
      new ExplosionStatusEffect(MobEffectCategory.HARMFUL, color(55, 55, 60))
    );

    public static final Holder<MobEffect> LEAD_POISONING = of("lead_poisoning",
      new LeadPoisoningEffect(MobEffectCategory.HARMFUL, color(55, 55, 60))
    );

    public static final Holder<MobEffect> PHOSPHORUS_BURNS = of("phosphorus_burns",
      new PhosphorusBurnStatusEffect(MobEffectCategory.HARMFUL, color(255, 100, 0))
    );

    // TODO
    public static final Holder<MobEffect> POTION_SICKNESS = of("potion_sickness",
      new GenericStatusEffect(MobEffectCategory.HARMFUL, color(55, 55, 60))
    );

    public static final Holder<MobEffect> RAD_AWAY = of("rad_away",
      new RadAwayEffect(MobEffectCategory.BENEFICIAL, color(230, 75, 30))
    );

    public static final Holder<MobEffect> RAD_X = of("rad_x",
      new GenericStatusEffect(MobEffectCategory.BENEFICIAL, color(250, 100, 40))
    );

    // TODO
    public static final Holder<MobEffect> STABILITY = of("stability",
      new GenericStatusEffect(MobEffectCategory.BENEFICIAL, color(55, 55, 60))
    );

    public static final Holder<MobEffect> TAINT = of("taint",
      new TaintEffect(MobEffectCategory.BENEFICIAL, color(120, 40, 200))
    );

    public static final Holder<MobEffect> TAINTED_HEART = of("tainted_heart",
      new GenericStatusEffect(MobEffectCategory.BENEFICIAL, color(200, 40, 75))
    );

    private static Holder<MobEffect> of(String name, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, NTM.id(name), effect);
    }

    private static int color(int red, int green, int blue) {
        return ARGB.color(red, green, blue);
    }

    public static void initialize() {
    }
}
