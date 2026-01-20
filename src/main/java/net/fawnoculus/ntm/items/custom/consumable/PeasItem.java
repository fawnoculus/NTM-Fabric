package net.fawnoculus.ntm.items.custom.consumable;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class PeasItem extends Item {
    public PeasItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player user, LivingEntity entity, InteractionHand hand) {
        // TODO: this, once we have "Quackatos"
        return super.interactLivingEntity(stack, user, entity, hand);
    }
}
