package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.entity.ModDamageTypes;
import net.fawnoculus.ntm.items.custom.TooltipItem;
import net.fawnoculus.ntm.util.EntityUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class PlanC extends TooltipItem {
  public PlanC(Settings settings) {
    super(settings);
  }
  
  @Override
  public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
    if(world instanceof ServerWorld serverWorld){
      EntityUtil.applyDamage(user, serverWorld, ModDamageTypes.EUTHANIZED, Float.MAX_VALUE);
    }
    return super.finishUsing(stack, world, user);
  }
}
