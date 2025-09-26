package net.fawnoculus.ntm.blocks;

import net.fawnoculus.ntm.api.radiation.RadiationRegistry;

public class ExtraBlockData {
  private static final RadiationRegistry radiationRegistry = RadiationRegistry.getInstance();

  public static void initialize() {
    radiationRegistry.register(NTMBlocks.URANIUM_BLOCK, 3500);
  }
}
