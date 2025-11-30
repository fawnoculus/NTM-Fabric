package net.fawnoculus.ntm.gui.slots;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class UpgradeSlot extends Slot {
    public UpgradeSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        // TODO: Upgraded people, upgrades!
        return false;
    }
}
