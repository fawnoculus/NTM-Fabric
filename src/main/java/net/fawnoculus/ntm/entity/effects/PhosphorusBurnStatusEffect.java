package net.fawnoculus.ntm.entity.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class PhosphorusBurnStatusEffect  extends StatusEffect {
  public PhosphorusBurnStatusEffect(StatusEffectCategory category, int color) {
    super(category, color);
  }

  @Override
  public boolean canApplyUpdateEffect(int duration, int amplifier) {
    return duration % 10 == 0 && duration > 0;
  }

  @Override
  public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
    entity.setFireTicks(20);
    return true;
  }
}
