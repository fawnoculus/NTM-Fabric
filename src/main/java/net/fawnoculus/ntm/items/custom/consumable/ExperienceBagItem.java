package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.misc.NTMSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ExperienceBagItem extends Item {
    public ExperienceBagItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult use(Level world, Player player, InteractionHand hand) {
        if (world.isClientSide()) {
            return InteractionResult.SUCCESS;
        }
        if (!player.isCreative()) {
            ItemStack stack = player.getItemInHand(hand);
            stack.shrink(1);
        }
        world.playSound(null, BlockPos.containing(player.position()).above(), NTMSounds.IV_BAG_INJECTS, SoundSource.PLAYERS);
        player.getInventory().placeItemBackInInventory(new ItemStack(NTMItems.EMPTY_EXPERIENCE_BAG));
        player.giveExperiencePoints(EmptyExperienceBagItem.XP_PER_BAG);

        return InteractionResult.SUCCESS_SERVER;
    }
}
