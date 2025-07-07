package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.items.components.ModConsumableComponents;
import net.fawnoculus.ntm.items.components.ModFoodComponents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class VeganSchnitzelItem extends Item {
  public VeganSchnitzelItem(Settings settings) {
    super(settings.food(ModFoodComponents.ALWAYS_EDIBLE, ModConsumableComponents.VEGAN_SCHNITZEL));
  }
  
  @Override
  public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
    user.setFireTicks(1200);
    return super.finishUsing(stack, world, user);
  }
}
