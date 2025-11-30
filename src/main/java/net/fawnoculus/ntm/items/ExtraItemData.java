package net.fawnoculus.ntm.items;

import net.fawnoculus.ntm.api.radiation.RadiationRegistry;

public class ExtraItemData {
    public static void initialize() {
        RadiationRegistry.register(NTMItems.URANIUM_INGOT, 350);
    }
}
