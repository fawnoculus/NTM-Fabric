package net.fawnoculus.ntm.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;

public class PlayerUtil {
  public static void removeExperience(PlayerEntity player, int xpToRemove){
    player.addExperience(-xpToRemove);
  }
  public static boolean hasItem(PlayerEntity player, ItemConvertible itemConvertible){
    Item item = itemConvertible.asItem();
    boolean hasItem = false;
    
    for(ItemStack stack : player.getInventory()){
      if(stack.getItem() == item) {
        hasItem = true;
        break;
      }
    }
    
    return hasItem;
  }
}
