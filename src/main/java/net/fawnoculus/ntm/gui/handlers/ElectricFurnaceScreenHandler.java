package net.fawnoculus.ntm.gui.handlers;

import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.blocks.entities.ElectricFurnaceBE;
import net.fawnoculus.ntm.gui.ModScreenHandlerType;
import net.fawnoculus.ntm.gui.slots.BatterySlot;
import net.fawnoculus.ntm.gui.slots.OutputSlot;
import net.fawnoculus.ntm.gui.slots.UpgradeSlot;
import net.fawnoculus.ntm.network.custom.BlockPosS2CPayload;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.NotNull;

public class ElectricFurnaceScreenHandler extends ScreenHandler {
  private final ElectricFurnaceBE blockEntity;
  private final ScreenHandlerContext screenContext;
  
  // Client Constructor
  public ElectricFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, @NotNull BlockPosS2CPayload payload) {
    this(syncId, playerInventory, (ElectricFurnaceBE) playerInventory.player.getWorld().getBlockEntity(payload.pos()));
  }
  
  // Common Constructor
  public ElectricFurnaceScreenHandler(int syncId, @NotNull PlayerInventory playerInventory, ElectricFurnaceBE blockEntity) {
    super(ModScreenHandlerType.ELECTRIC_FURNACE, syncId);
    
    this.blockEntity = blockEntity;
    this.screenContext = ScreenHandlerContext.create(this.blockEntity.getWorld(), this.blockEntity.getPos());
    
    SimpleInventory blockInventory = this.blockEntity.getInventory();
    blockInventory.onOpen(playerInventory.player);
    checkSize(blockInventory, 4);
    
    addPlayerInventory(playerInventory);
    addBlockInventory(blockInventory);
  }
  
  private void addBlockInventory(SimpleInventory inventory) {
    addSlot(new BatterySlot(inventory, ElectricFurnaceBE.BATTERY_SLOT_INDEX, 56, 53));
    addSlot(new Slot(inventory, ElectricFurnaceBE.INPUT_SLOT_INDEX, 56, 17));
    addSlot(new OutputSlot(inventory, ElectricFurnaceBE.OUTPUT_SLOT_INDEX, 116, 35));
    addSlot(new UpgradeSlot(inventory, ElectricFurnaceBE.UPGRADE_SLOT_INDEX, 147, 34));
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
  public ItemStack quickMove(PlayerEntity player, int slot) {
    // TODO: fix this
    return ItemStack.EMPTY;
  }
  
  @Override
  public boolean canUse(PlayerEntity player) {
    return canUse(screenContext, player, ModBlocks.ALLOY_FURNACE);
  }
  
  public ElectricFurnaceBE getBlockEntity(){
    return this.blockEntity;
  }
}
