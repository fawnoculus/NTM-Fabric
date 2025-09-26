package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.entity.NTMDamageTypes;
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
    if (world instanceof ServerWorld serverWorld) {
      if (!user.isInCreativeMode()) {
        EntityUtil.applyDamage(user, serverWorld, NTMDamageTypes.EUTHANIZED, Float.MAX_VALUE);
      } else {
        EntityUtil.applyDamage(user, serverWorld, NTMDamageTypes.EUTHANIZED, 10);
      }
    }
    return super.finishUsing(stack, world, user);
  }
}
