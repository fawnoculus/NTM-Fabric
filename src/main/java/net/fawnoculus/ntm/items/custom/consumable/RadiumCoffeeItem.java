package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.api.radiation.RadiationManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RadiumCoffeeItem extends CoffeeItem {
    public RadiumCoffeeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient() && !user.isInvulnerable() && !user.isInCreativeMode()) {
            RadiationManager.increaseRadiationExposure(user, 500_000);
        }
        return super.finishUsing(stack, world, user);
    }
}
