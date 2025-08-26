package net.fawnoculus.ntm.gui.handlers;

import net.fawnoculus.ntm.blocks.entities.container.energy.SimpleEnergyStorageBE;
import net.fawnoculus.ntm.gui.NTMScreenHandlerType;
import net.fawnoculus.ntm.gui.slots.BatterySlot;
import net.fawnoculus.ntm.network.s2c.BlockPosPayload;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.NotNull;

public class EnergyStorageScreenHandler extends ScreenHandler {
  private final SimpleEnergyStorageBE blockEntity;
  private final ScreenHandlerContext screenContext;

  // Client Constructor
  public EnergyStorageScreenHandler(int syncId, PlayerInventory playerInventory, @NotNull BlockPosPayload payload) {
    this(syncId, playerInventory, (SimpleEnergyStorageBE) playerInventory.player.getWorld().getBlockEntity(payload.pos()));
  }

  // Common Constructor
  public EnergyStorageScreenHandler(int syncId, @NotNull PlayerInventory playerInventory, SimpleEnergyStorageBE blockEntity) {
    super(NTMScreenHandlerType.ENERGY_STORAGE, syncId);

    this.blockEntity = blockEntity;
    this.screenContext = ScreenHandlerContext.create(this.blockEntity.getWorld(), this.blockEntity.getPos());

    SimpleInventory blockInventory = this.blockEntity.getInventory();
    blockInventory.onOpen(playerInventory.player);
    checkSize(blockInventory, 2);

    addPlayerInventory(playerInventory);
    addBlockInventory(blockInventory);
  }

  private void addBlockInventory(SimpleInventory inventory) {
    addSlot(new BatterySlot(inventory, SimpleEnergyStorageBE.DISCHARGE_SLOT_INDEX, 26, 17));
    addSlot(new BatterySlot(inventory, SimpleEnergyStorageBE.CHARGE_SLOT_INDEX, 26, 53));
  }

  private void addPlayerInventory(PlayerInventory playerInventory) {
    addPartialPlayerInventory(playerInventory);
    addPlayerHotbar(playerInventory);
  }

  private void addPartialPlayerInventory(PlayerInventory playerInventory) {
    for (int row = 0; row < 3; row++) {
      for (int colum = 0; colum < 9; colum++) {
        addSlot(new Slot(playerInventory, 9 + (colum + (row * 9)), 8 + (colum * 18), 84 + (row * 18)));
      }
    }
  }

  private void addPlayerHotbar(PlayerInventory playerInventory) {
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
  public ItemStack quickMove(PlayerEntity player, int slot) {
    // TODO: fix this
    return ItemStack.EMPTY;
  }

  @Override
  public boolean canUse(PlayerEntity player) {
    return screenContext.get((world, pos) -> player.canInteractWithBlockAt(pos, 4.0), true);
  }

  public SimpleEnergyStorageBE getBlockEntity() {
    return this.blockEntity;
  }
}
