package net.fawnoculus.ntm.items.custom.consumable;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.fawnoculus.ntm.items.components.NTMFoodComponents;
import net.fawnoculus.ntm.network.s2c.AdvancedMessagePayload;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ScrapPancakeItem extends Item {
    public ScrapPancakeItem(Properties settings) {
        super(settings.food(NTMFoodComponents.SCRAP_PANCAKE));
    }

    @Override
    public InteractionResult use(Level world, Player player, InteractionHand hand) {
        // TODO: this, once we have lunar cybernetic armor
        ServerPlayNetworking.send((ServerPlayer) player, new AdvancedMessagePayload(new AdvancedMessage(
          NTM.id("scrap_pancake"),
          Component.translatable("message.ntm.teeth_to_soft").withStyle(ChatFormatting.YELLOW),
          1000.0f)));
        return InteractionResult.FAIL;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        // TODO: this, once we have lunar cybernetic armor
        return super.finishUsingItem(stack, world, user);
    }
}
