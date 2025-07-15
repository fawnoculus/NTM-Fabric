package net.fawnoculus.ntm.items;

import net.fawnoculus.ntm.misc.radiation.HazmatRegistry;
import net.fawnoculus.ntm.misc.radiation.RadiationRegistry;

public class ExtraItemData {
  private static final RadiationRegistry radiationRegistry = RadiationRegistry.getInstance();
  private static final HazmatRegistry hazmatRegistry = HazmatRegistry.getInstance();
  
  public static void initialize(){
    radiationRegistry.register(ModItems.URANIUM_INGOT, 350);
  }
}
