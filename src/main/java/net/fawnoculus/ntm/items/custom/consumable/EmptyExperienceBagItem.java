package net.fawnoculus.ntm.items.custom.consumable;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.misc.NTMSounds;
import net.fawnoculus.ntm.network.s2c.AdvancedMessagePayload;
import net.fawnoculus.ntm.util.PlayerUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EmptyExperienceBagItem extends Item {
    public static final int XP_PER_BAG = 500;

    public EmptyExperienceBagItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        if (player.totalExperience < XP_PER_BAG) {
            if (!world.isClient()) {
                ServerPlayNetworking.send((ServerPlayerEntity) player, new AdvancedMessagePayload(new AdvancedMessage(
                  NTM.id("empty_xp_bag"),
                  Text.translatable("message.ntm.not_enough_xp").formatted(Formatting.RED),
                  1000.0f)));
            }
            return ActionResult.FAIL;
        }
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }
        if (!player.isCreative()) {
            ItemStack stack = player.getStackInHand(hand);
            stack.decrement(1);
        }
        world.playSound(null, BlockPos.ofFloored(player.getPos()).up(), NTMSounds.IV_BAG_INJECTS, SoundCategory.PLAYERS);
        PlayerUtil.removeExperience(player, XP_PER_BAG);
        player.getInventory().offerOrDrop(new ItemStack(NTMItems.EXPERIENCE_BAG));

        return ActionResult.SUCCESS_SERVER;
    }
}
