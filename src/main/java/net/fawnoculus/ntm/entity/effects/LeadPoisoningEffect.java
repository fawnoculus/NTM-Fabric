package net.fawnoculus.ntm.entity.effects;

import net.fawnoculus.ntm.entity.NTMDamageTypes;
import net.fawnoculus.ntm.util.EntityUtil;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class LeadPoisoningEffect extends MobEffect {
    public LeadPoisoningEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 60 == 0 || amplifier >= 255;
    }

    @Override
    public boolean applyEffectTick(ServerLevel world, LivingEntity entity, int amplifier) {
        EntityUtil.applyDamage(entity, world, NTMDamageTypes.LEAD_POISONING, amplifier);
        if (amplifier >= 255) {
            EntityUtil.applyDamage(entity, world, NTMDamageTypes.LEAD_POISONING, Integer.MAX_VALUE);
        }
        return super.applyEffectTick(world, entity, amplifier);
    }
}
