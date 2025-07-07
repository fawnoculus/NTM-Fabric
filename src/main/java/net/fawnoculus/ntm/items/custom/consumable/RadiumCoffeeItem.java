package net.fawnoculus.ntm.items.custom.consumable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RadiumCoffeeItem extends CoffeeItem{
  public RadiumCoffeeItem(Settings settings) {
    super(settings);
  }
  
  @Override
  public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
    // TODO: this, once we have Radiation (gives 500 RAD)
    return super.finishUsing(stack, world, user);
  }
}
