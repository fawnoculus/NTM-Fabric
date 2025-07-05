package net.fawnoculus.ntm.entity.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class RadXEffect extends StatusEffect {
  public RadXEffect(StatusEffectCategory category, int color) {
    super(category, color);
  }
  
  @Override
  public boolean canApplyUpdateEffect(int duration, int amplifier) {
    return true;
  }
  
  @Override
  public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
    // TODO: this, once we have Radiation
    return super.applyUpdateEffect(world, entity, amplifier);
  }
}
