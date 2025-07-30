package net.fawnoculus.ntm.blocks.entities;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.network.custom.InventorySyncS2CPayload;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class AbstractInventoryBE extends BlockEntity implements Inventory {
  private final SimpleInventory inventory;
  
  public AbstractInventoryBE(BlockEntityType<?> type, BlockPos pos, BlockState state, int inventorySlots) {
    super(type, pos, state);
    
    AbstractInventoryBE be = this;
    this.inventory = new SimpleInventory(inventorySlots){
      @Override
      public void markDirty() {
        super.markDirty();
        be.markDirty();
      }
    };
  }
  
  public static void sendSyncInventoryPacket(World world, BlockPos pos, SimpleInventory inventory){
    if(!(world instanceof ServerWorld serverWorld)) return;
    InventorySyncS2CPayload payload = new InventorySyncS2CPayload(pos, inventory);
    
    int viewDistance = serverWorld.getServer().getPlayerManager().getViewDistance();
    for(ServerPlayerEntity player : PlayerLookup.around(serverWorld, pos, viewDistance)){
      ServerPlayNetworking.send(player, payload);
    }
  }
  
  public SimpleInventory getInventory(){
    return this.inventory;
  }
  
  public boolean canInsertIntoSlot(int slotIndex, ItemStack stack){
    ItemStack switchStack = this.getInventory().getStack(slotIndex);
    if(switchStack.isEmpty()) return true;
    
    if(switchStack.getItem() == stack.getItem()){
      return switchStack.getCount() + stack.getCount() <= switchStack.getMaxCount();
    }
    
    return false;
  }
  
  @Override
  public int size() {
    return this.getInventory().size();
  }
  
  @Override
  public boolean isEmpty() {
    return this.getInventory().isEmpty();
  }
  
  @Override
  public ItemStack getStack(int slot) {
    return this.getInventory().getStack(slot);
  }
  
  @Override
  public ItemStack removeStack(int slot, int amount) {
    return this.getInventory().removeStack(slot, amount);
  }
  
  @Override
  public ItemStack removeStack(int slot) {
    return this.getInventory().removeStack(slot);
  }
  
  @Override
  public void setStack(int slot, ItemStack stack) {
    this.getInventory().setStack(slot, stack);
  }
  
  @Override
  public boolean canPlayerUse(PlayerEntity player) {
    return this.getInventory().canPlayerUse(player);
  }
  
  @Override
  public void clear() {
    inventory.clear();
  }
  
  @Override
  public void markDirty() {
    super.markDirty();
    if(this.world != null) this.world.updateListeners(this.pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
    if(this.world != null && !this.world.isClient()){
      sendSyncInventoryPacket(this.world, this.pos, this.getInventory());
    }
  }
  
  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    Inventories.writeNbt(nbt, this.getInventory().getHeldStacks(), registryLookup);
    super.writeNbt(nbt, registryLookup);
  }
  
  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    super.readNbt(nbt, registryLookup);
    Inventories.readNbt(nbt, this.getInventory().getHeldStacks(), registryLookup);
  }
  
  @Override
  public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
    return createNbt(registryLookup);
  }
}
