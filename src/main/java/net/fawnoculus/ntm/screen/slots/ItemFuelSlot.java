package net.fawnoculus.ntm.screen.slots;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.FuelRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

public class ItemFuelSlot  extends Slot {
  FuelRegistry fuelRegistry;
  
  public ItemFuelSlot(FuelRegistry fuelRegistry ,Inventory inventory, int index, int x, int y) {
    super(inventory, index, x, y);
    this.fuelRegistry = fuelRegistry;
  }
  
  @Override
  public boolean canInsert(ItemStack stack) {
    return this.fuelRegistry.isFuel(stack) || isBucket(stack);
  }
  
  @Override
  public int getMaxItemCount(ItemStack stack) {
    return isBucket(stack) ? 1 : super.getMaxItemCount(stack);
  }
  
  public static boolean isBucket(ItemStack stack) {
    return stack.isOf(Items.BUCKET);
  }
}
