package net.fawnoculus.ntm.items.components;

import net.fawnoculus.ntm.entity.ModStatusEffects;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.List;

public class ModConsumableComponents {
    public static final ConsumableComponent RAD_X = ConsumableComponents.food().consumeSeconds(0.8F)
        .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModStatusEffects.RAD_X, 3600, 0, false, false, true)))
        .build();
    public static final ConsumableComponent IPECAC_SYRUP = ConsumableComponents.food().consumeSeconds(0.8F)
        .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100, 255, false, false, true)))
        .build();
    
    public static final ConsumableComponent BASIC_LEAD_APPLE = ConsumableComponents.food()
        .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModStatusEffects.LEAD_POISONING, 300, 2, false, false, true)))
        .build();
    public static final ConsumableComponent GOOD_LEAD_APPLE = ConsumableComponents.food()
        .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModStatusEffects.LEAD_POISONING, 1200, 4, false, false, true)))
        .build();
    public static final ConsumableComponent EPIC_LEAD_APPLE = ConsumableComponents.food()
        .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModStatusEffects.LEAD_POISONING, 1200, 255, false, false, true)))
        .build();
    
    public static final ConsumableComponent BASIC_SCHRABIDIUM_APPLE = ConsumableComponents.food()
        .consumeEffect(new ApplyEffectsConsumeEffect(List.of(
            new StatusEffectInstance(StatusEffects.REGENERATION, 600, 4, false, false, true),
            new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0, false, false, true),
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0, false, false, true)
        )))
        .build();
    public static final ConsumableComponent GOOD_SCHRABIDIUM_APPLE = ConsumableComponents.food()
        .consumeEffect(new ApplyEffectsConsumeEffect(List.of(
            new StatusEffectInstance(StatusEffects.SPEED, 1200, 2, false, false, true),
            new StatusEffectInstance(StatusEffects.HASTE, 1200, 2, false, false, true),
            new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 4, false, false, true),
            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1200, 9, false, false, true),
            new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 4, false, false, true),
            new StatusEffectInstance(StatusEffects.SATURATION, 1200, 9, false, false, true),
            new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1200, 4, false, false, true),
            new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 4, false, false, true),
            new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, 4, false, false, true),
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200, 0, false, false, true)
            )))
        .build();
    public static final ConsumableComponent EPIC_SCHRABIDIUM_APPLE = ConsumableComponents.food()
        .consumeEffect(new ApplyEffectsConsumeEffect(List.of(
            new StatusEffectInstance(StatusEffects.SPEED, StatusEffectInstance.INFINITE, 3, false, false, true),
            new StatusEffectInstance(StatusEffects.HASTE, StatusEffectInstance.INFINITE, 4, false, false, true),
            new StatusEffectInstance(StatusEffects.STRENGTH, StatusEffectInstance.INFINITE, 9, false, false, true),
            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, StatusEffectInstance.INFINITE, 24, false, false, true),
            new StatusEffectInstance(StatusEffects.ABSORPTION, StatusEffectInstance.INFINITE, 14, false, false, true),
            new StatusEffectInstance(StatusEffects.SATURATION, StatusEffectInstance.INFINITE, 99, false, false, true),
            new StatusEffectInstance(StatusEffects.JUMP_BOOST, StatusEffectInstance.INFINITE, 4, false, false, true),
            new StatusEffectInstance(StatusEffects.REGENERATION, StatusEffectInstance.INFINITE, 4, false, false, true),
            new StatusEffectInstance(StatusEffects.RESISTANCE, StatusEffectInstance.INFINITE, 1, false, false, true),
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, StatusEffectInstance.INFINITE, 0, false, false, true)
        )))
        .build();
    public static final ConsumableComponent EUPHEMIUM_APPLE = ConsumableComponents.food()
        .consumeEffect(new ApplyEffectsConsumeEffect(List.of(
            new StatusEffectInstance(StatusEffects.SATURATION, StatusEffectInstance.INFINITE, 122, false, false, true),
            new StatusEffectInstance(StatusEffects.RESISTANCE, StatusEffectInstance.INFINITE, 122, false, false, true),
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, StatusEffectInstance.INFINITE, 0, false, false, true)
        )))
        .build();
}
