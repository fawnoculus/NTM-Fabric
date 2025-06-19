package net.fawnoculus.ntm.gui.handlers;

import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceBE;
import net.fawnoculus.ntm.network.BlockPosPayload;
import net.fawnoculus.ntm.gui.ModScreenHandlerType;
import net.fawnoculus.ntm.gui.slots.ItemFuelSlot;
import net.fawnoculus.ntm.gui.slots.OutputSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;

import java.util.Objects;

public class AlloyFurnaceScreenHandler extends ScreenHandler {
  private final AlloyFurnaceBE blockEntity;
  private final ScreenHandlerContext screenContext;
  
  // Client Constructor
  public AlloyFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, BlockPosPayload payload) {
    this(syncId, playerInventory, (AlloyFurnaceBE) playerInventory.player.getWorld().getBlockEntity(payload.pos()));
  }
  
  public AlloyFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, AlloyFurnaceBE blockEntity) {
    super(ModScreenHandlerType.ALLOY_FURNACE, syncId);
    
    this.blockEntity = blockEntity;
    this.screenContext = ScreenHandlerContext.create(this.blockEntity.getWorld(), this.blockEntity.getPos());
    
    SimpleInventory blockInventory = this.blockEntity.getInventory();
    blockInventory.onOpen(playerInventory.player);
    checkSize(blockInventory, 4);
    
    addPlayerInventory(playerInventory);
    addBlockInventory(blockInventory);
  }
  
  private void addBlockInventory(SimpleInventory inventory) {
    addSlot(new ItemFuelSlot(Objects.requireNonNull(blockEntity.getWorld()).getFuelRegistry(), inventory, AlloyFurnaceBE.FUEL_SLOT_INDEX, 8, 36));
    addSlot(new Slot(inventory, AlloyFurnaceBE.INPUT_TOP_SLOT_INDEX, 80, 18));
    addSlot(new Slot(inventory, AlloyFurnaceBE.INPUT_BOTTOM_SLOT_INDEX, 80, 54));
    addSlot(new OutputSlot(inventory, AlloyFurnaceBE.OUTPUT_SLOT_INDEX, 134, 36));
  }
  
  private void addPlayerInventory(PlayerInventory playerInventory){
    addPartialPlayerInventory(playerInventory);
    addPlayerHotbar(playerInventory);
  }
  private void addPartialPlayerInventory(PlayerInventory playerInventory){
    for (int row = 0; row < 3; row++) {
      for (int colum = 0; colum < 9; colum++) {
        addSlot(new Slot(playerInventory, 9 + (colum + (row * 9)) , 8 + (colum * 18), 84 + (row * 18)));
      }
    }
  }
  private void addPlayerHotbar(PlayerInventory playerInventory){
    for (int colum = 0; colum < 9; colum++) {
      addSlot(new Slot(playerInventory, colum, 8 + (colum * 18), 142));
    }
  }
  
  @Override
  public void onClosed(PlayerEntity player) {
    super.onClosed(player);
    this.blockEntity.getInventory().onClose(player);
  }
  
  @Override
  public ItemStack quickMove(PlayerEntity player, int slotIndex) {
    ItemStack clickedStack = player.getInventory().getStack(slotIndex);
    if (clickedStack.isEmpty()) return ItemStack.EMPTY;
    
    World world = Objects.requireNonNull(blockEntity.getWorld());
    //if(world.getFuelRegistry().isFuel(clickedStack) && blockEntity.getInventory().getStack(ALLOY_FURNACE_BE.FUEL_SLOT_INDEX)
    
    return ItemStack.EMPTY;
    /* TODO: fix this
    ItemStack stack = ItemStack.EMPTY;
    Slot slot = getSlot(slotIndex);
    
    if (slot == null || !slot.hasStack()) {
      return ItemStack.EMPTY;
    }
    
    ItemStack inSlot = slot.getStack();
    stack = inSlot.copy();
    
    if (slotIndex < this.blockEntity.getInventory().size()) {
      if (!insertItem(inSlot, this.blockEntity.getInventory().size(), this.slots.size(), true)) {
        return ItemStack.EMPTY;
      }
    } else if (!insertItem(inSlot, 0, this.blockEntity.getInventory().size(), false)) {
      return ItemStack.EMPTY;
    }
    if (inSlot.isEmpty()) {
      slot.setStack(ItemStack.EMPTY);
    } else {
      slot.markDirty();
    }
    return stack;
    
     */
  }
  
  @Override
  public boolean canUse(PlayerEntity player) {
    return canUse(screenContext, player, ModBlocks.ALLOY_FURNACE);
  }
  
  public AlloyFurnaceBE getBlockEntity(){
    return this.blockEntity;
  }
}
