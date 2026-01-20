package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.items.custom.TooltipItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.level.Level;

import java.util.List;

public class DrinkCanItem extends TooltipItem {
    private final List<MobEffectInstance> EFFECTS;

    public DrinkCanItem(Properties settings, List<MobEffectInstance> effects) {
        super(settings.component(DataComponents.CONSUMABLE, Consumables.DEFAULT_DRINK));

        this.EFFECTS = effects;
    }

    public DrinkCanItem(Properties settings, int tooltipCount, List<MobEffectInstance> effects) {
        super(settings.component(DataComponents.CONSUMABLE, Consumables.DEFAULT_DRINK), tooltipCount);

        this.EFFECTS = effects;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (user instanceof Player player && !player.isCreative()) {
            stack.shrink(1);
            player.getInventory().placeItemBackInInventory(new ItemStack(NTMItems.EMPTY_CAN));
            player.getInventory().placeItemBackInInventory(new ItemStack(NTMItems.RING_PULL));
        }

        for (MobEffectInstance effect : EFFECTS) {
            user.addEffect(new MobEffectInstance(effect));
        }

        return super.finishUsingItem(stack, world, user);
    }
}
