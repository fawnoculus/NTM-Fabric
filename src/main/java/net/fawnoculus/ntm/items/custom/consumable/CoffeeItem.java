package net.fawnoculus.ntm.items.custom.consumable;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CoffeeItem extends Item {
	public CoffeeItem(Settings settings) {
		super(settings.component(DataComponentTypes.CONSUMABLE, ConsumableComponents.DRINK));
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		user.heal(10);
		user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200, 2, false, false, true));
		return super.finishUsing(stack, world, user);
	}
}
