package net.fawnoculus.ntm.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlayerUtil {
  public static void removeExperience(@NotNull PlayerEntity player, int xp){
    player.addExperience(-xp);
  }
  public static boolean hasItem(PlayerEntity player, @NotNull ItemConvertible item){
    return hasItem(player, item.asItem());
  }
  public static boolean hasItem(@NotNull PlayerEntity player, Item item){
    for(ItemStack stack : player.getInventory()){
      if(stack.getItem() == item) {
        return true;
      }
    }
    
    return false;
  }
}
