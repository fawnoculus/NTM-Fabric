package net.fawnoculus.ntm.items.components;

import net.fawnoculus.ntm.entity.ModStatusEffects;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModConsumableComponents {
    public static final ConsumableComponent RAD_X = ConsumableComponents.food().consumeSeconds(0.8F)
        .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModStatusEffects.RAD_X, 3600, 0, false, false, true)))
        .build();
    public static final ConsumableComponent IPECAC_SYRUP = ConsumableComponents.food().consumeSeconds(0.8F)
        .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100, 49, false, false, true)))
        .build();
}
