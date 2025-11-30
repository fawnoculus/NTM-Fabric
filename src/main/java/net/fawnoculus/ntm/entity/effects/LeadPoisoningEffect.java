package net.fawnoculus.ntm.entity.effects;

import net.fawnoculus.ntm.entity.NTMDamageTypes;
import net.fawnoculus.ntm.util.EntityUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class LeadPoisoningEffect extends StatusEffect {
    public LeadPoisoningEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 60 == 0 || amplifier >= 255;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        EntityUtil.applyDamage(entity, world, NTMDamageTypes.LEAD_POISONING, amplifier);
        if (amplifier >= 255) {
            EntityUtil.applyDamage(entity, world, NTMDamageTypes.LEAD_POISONING, Integer.MAX_VALUE);
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
