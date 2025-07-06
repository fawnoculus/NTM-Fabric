package net.fawnoculus.ntm.util;

import net.minecraft.entity.player.PlayerEntity;

public class PlayerUtil {
  public static void removeExperience(PlayerEntity player, int xpToRemove){
    player.addExperience(-xpToRemove);
  }
}
