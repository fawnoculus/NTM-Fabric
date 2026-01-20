package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.entity.NTMDamageTypes;
import net.fawnoculus.ntm.items.custom.TooltipItem;
import net.fawnoculus.ntm.util.EntityUtil;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PlanC extends TooltipItem {
    public PlanC(Properties settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (world instanceof ServerLevel serverWorld) {
            if (!user.hasInfiniteMaterials()) {
                EntityUtil.applyDamage(user, serverWorld, NTMDamageTypes.EUTHANIZED, Float.MAX_VALUE);
            } else {
                EntityUtil.applyDamage(user, serverWorld, NTMDamageTypes.EUTHANIZED, 10);
            }
        }
        return super.finishUsingItem(stack, world, user);
    }
}
