package net.fawnoculus.ntm.client.api.qmaw;

import net.fawnoculus.ntm.client.NTMClient;
import net.minecraft.client.Minecraft;
import net.minecraft.world.inventory.Slot;
import org.jetbrains.annotations.Nullable;

public class QmawManager {
    public static boolean openQmawPage(Minecraft client, @Nullable Slot hoveredSlot) {
        if (hoveredSlot != null) {
            NTMClient.LOGGER.info("Hovered Item {}", hoveredSlot.getItem().getItem().getName());
        } else {
            NTMClient.LOGGER.info("Hovered Slot == null");
        }

        //TODO this
        return true;
    }
}
