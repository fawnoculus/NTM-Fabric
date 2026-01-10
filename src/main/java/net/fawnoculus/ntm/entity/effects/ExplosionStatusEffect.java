package net.fawnoculus.ntm.entity.effects;

import net.fawnoculus.ntm.util.EntityUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.explosion.AdvancedExplosionBehavior;
import net.minecraft.world.explosion.ExplosionBehavior;

import java.util.Optional;

public class ExplosionStatusEffect extends StatusEffect {
    public ExplosionStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration == 1;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        // TODO: better explosion
        ExplosionBehavior explosionBehavior = new AdvancedExplosionBehavior(true, true, Optional.empty(), Optional.empty());
        world.createExplosion(
          null,
          EntityUtil.newDamageSource(world, DamageTypes.EXPLOSION),
          explosionBehavior,
          entity.getX(), entity.getY(), entity.getZ(),
          amplifier, false,
          World.ExplosionSourceType.MOB
        );


        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
