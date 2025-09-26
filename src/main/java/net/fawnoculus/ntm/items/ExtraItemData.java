package net.fawnoculus.ntm.items;

import net.fawnoculus.ntm.api.radiation.HazmatRegistry;
import net.fawnoculus.ntm.api.radiation.RadiationRegistry;

public class ExtraItemData {
  private static final RadiationRegistry radiationRegistry = RadiationRegistry.getInstance();
  private static final HazmatRegistry hazmatRegistry = HazmatRegistry.getInstance();

  public static void initialize() {
    radiationRegistry.register(NTMItems.URANIUM_INGOT, 350);
  }
}
