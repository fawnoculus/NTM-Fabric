package net.fawnoculus.ntm.gui.slots;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.FuelRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

public class ItemFuelSlot extends Slot {
	final FuelRegistry FUEL_REGISTRY;

	public ItemFuelSlot(FuelRegistry fuelRegistry, Inventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
		this.FUEL_REGISTRY = fuelRegistry;
	}

	@Override
	public boolean canInsert(ItemStack stack) {
		return this.FUEL_REGISTRY.isFuel(stack) || isBucket(stack);
	}

	@Override
	public int getMaxItemCount(ItemStack stack) {
		return isBucket(stack) ? 1 : super.getMaxItemCount(stack);
	}

	public static boolean isBucket(ItemStack stack) {
		return stack.isOf(Items.BUCKET);
	}
}
