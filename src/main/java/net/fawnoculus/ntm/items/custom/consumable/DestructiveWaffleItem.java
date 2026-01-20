package net.fawnoculus.ntm.items.custom.consumable;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.fawnoculus.ntm.items.components.NTMFoodComponents;
import net.fawnoculus.ntm.network.s2c.AdvancedMessagePayload;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DestructiveWaffleItem extends Item {
    public DestructiveWaffleItem(Properties settings) {
        super(settings.food(NTMFoodComponents.WAFFLE_OF_MASS_DESTRUCTION));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (user instanceof ServerPlayer player) {
            ServerPlayNetworking.send(player, new AdvancedMessagePayload(new AdvancedMessage(
              NTM.id("waffle_of_mass_destruction"),
              Component.literal("Now you would violently Explode, but Nuclear Explosions are not implemented yet").withStyle(ChatFormatting.RED),
              4000.0f)));
        }
        // TODO: this, once we have Nuclear Explosions
        return super.finishUsingItem(stack, world, user);
    }
}
