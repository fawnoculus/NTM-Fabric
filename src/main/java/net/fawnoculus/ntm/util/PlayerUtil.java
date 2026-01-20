package net.fawnoculus.ntm.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public class PlayerUtil {
    public static void removeExperience(@NotNull Player player, int xp) {
        player.giveExperiencePoints(-xp);
    }

    public static boolean hasItem(Player player, @NotNull ItemLike item) {
        return hasItem(player.getInventory(), item.asItem());
    }

    public static boolean hasItem(@NotNull Player player, Item item) {
        return hasItem(player.getInventory(), item);
    }

    public static boolean hasItem(Iterable<ItemStack> stacks, ItemLike item) {
        return hasItem(stacks, item.asItem());
    }

    public static boolean hasItem(Iterable<ItemStack> stacks, Item item) {
        for (ItemStack stack : stacks) {
            if (stack.getItem() == item) {
                return true;
            }
        }

        return false;
    }
}
