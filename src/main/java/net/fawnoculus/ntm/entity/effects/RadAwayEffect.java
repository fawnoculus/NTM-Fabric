package net.fawnoculus.ntm.entity.effects;

import net.fawnoculus.ntm.api.radiation.RadiationManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class RadAwayEffect extends StatusEffect {
  public RadAwayEffect(StatusEffectCategory category, int color) {
    super(category, color);
  }

  @Override
  public boolean canApplyUpdateEffect(int duration, int amplifier) {
    return true;
  }

  @Override
  public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
    RadiationManager.decreaseRadiationExposure(entity, amplifier * 1_000.0);
    return true;
  }
}
