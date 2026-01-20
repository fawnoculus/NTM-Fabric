package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.items.components.NTMConsumableComponents;
import net.fawnoculus.ntm.items.components.NTMFoodComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VeganSchnitzelItem extends Item {
    public VeganSchnitzelItem(Properties settings) {
        super(settings.food(NTMFoodComponents.ALWAYS_EDIBLE, NTMConsumableComponents.VEGAN_SCHNITZEL));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        user.setRemainingFireTicks(1200);
        return super.finishUsingItem(stack, world, user);
    }
}
