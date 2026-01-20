package net.fawnoculus.ntm.entity.effects;

import net.fawnoculus.ntm.api.radiation.RadiationManager;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class RadAwayEffect extends MobEffect {
    public RadAwayEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel world, LivingEntity entity, int amplifier) {
        RadiationManager.decreaseRadiationExposure(entity, amplifier * 1_000.0);
        return true;
    }
}
