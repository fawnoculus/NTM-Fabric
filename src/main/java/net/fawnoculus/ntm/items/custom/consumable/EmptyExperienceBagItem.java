package net.fawnoculus.ntm.items.custom.consumable;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.misc.NTMSounds;
import net.fawnoculus.ntm.network.s2c.AdvancedMessagePayload;
import net.fawnoculus.ntm.util.PlayerUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EmptyExperienceBagItem extends Item {
    public static final int XP_PER_BAG = 500;

    public EmptyExperienceBagItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult use(Level world, Player player, InteractionHand hand) {
        if (player.totalExperience < XP_PER_BAG) {
            if (!world.isClientSide()) {
                ServerPlayNetworking.send((ServerPlayer) player, new AdvancedMessagePayload(new AdvancedMessage(
                  NTM.id("empty_xp_bag"),
                  Component.translatable("message.ntm.not_enough_xp").withStyle(ChatFormatting.RED),
                  1000.0f)));
            }
            return InteractionResult.FAIL;
        }
        if (world.isClientSide()) {
            return InteractionResult.SUCCESS;
        }
        if (!player.isCreative()) {
            ItemStack stack = player.getItemInHand(hand);
            stack.shrink(1);
        }
        world.playSound(null, BlockPos.containing(player.position()).above(), NTMSounds.IV_BAG_INJECTS, SoundSource.PLAYERS);
        PlayerUtil.removeExperience(player, XP_PER_BAG);
        player.getInventory().placeItemBackInInventory(new ItemStack(NTMItems.EXPERIENCE_BAG));

        return InteractionResult.SUCCESS_SERVER;
    }
}
