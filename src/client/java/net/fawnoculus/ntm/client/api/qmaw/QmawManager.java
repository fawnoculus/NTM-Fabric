package net.fawnoculus.ntm.client.api.qmaw;

import net.fawnoculus.ntm.client.NTMClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public class QmawManager {
    public static boolean openQmawPage(MinecraftClient client, @Nullable Slot hoveredSlot) {
        if (hoveredSlot != null) {
            NTMClient.LOGGER.info("Hovered Item {}", hoveredSlot.getStack().getItem().getName());
        } else {
            NTMClient.LOGGER.info("Hovered Slot == null");
        }

        //TODO this
        return true;
    }
}
