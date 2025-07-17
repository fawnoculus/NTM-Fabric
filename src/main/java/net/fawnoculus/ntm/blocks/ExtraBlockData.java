package net.fawnoculus.ntm.blocks;

import net.fawnoculus.ntm.misc.radiation.RadiationRegistry;

public class ExtraBlockData {
  private static final RadiationRegistry radiationRegistry = RadiationRegistry.getInstance();
  
  public static void initialize(){
    radiationRegistry.register(ModBlocks.URANIUM_BLOCK, 3500);
  }
}
