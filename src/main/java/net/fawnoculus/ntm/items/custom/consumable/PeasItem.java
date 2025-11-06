package net.fawnoculus.ntm.items.custom.consumable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class PeasItem extends Item {
	public PeasItem(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
		// TODO: this, once we have "Quackatos"
		return super.useOnEntity(stack, user, entity, hand);
	}
}
