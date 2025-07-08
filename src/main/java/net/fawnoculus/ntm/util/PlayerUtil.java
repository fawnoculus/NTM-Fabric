package net.fawnoculus.ntm.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;

public class PlayerUtil {
  public static void removeExperience(PlayerEntity player, int xp){
    player.addExperience(-xp);
  }
  public static boolean hasItem(PlayerEntity player, ItemConvertible item){
    return hasItem(player, item.asItem());
  }
  public static boolean hasItem(PlayerEntity player, Item item){
    for(ItemStack stack : player.getInventory()){
      if(stack.getItem() == item) {
        return true;
      }
    }
    
    return false;
  }
}
