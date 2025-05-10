package net.fawnoculus.ntm.blocks.entities;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceBlock;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.network.BlockPosPayload;
import net.fawnoculus.ntm.render.screen.AlloyFurnaceScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.FuelRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class AlloyFurnaceBE extends BlockEntity implements ExtendedScreenHandlerFactory {
  public AlloyFurnaceBE(BlockPos pos, BlockState state) {
    super(ModBlockEntities.AlloyFurnaceBE, pos, state);
  }
  
  // max fuel is consistent with original, but translated to burn ticks
  public final int MAX_FUEL = 102400;
  // fuel buffer (aka: vanilla burn ticks)
  public int fuel = 0;
  public final int MAX_PROGESS = 102400;
  public int progress = 0;
  
  private final SimpleInventory inventory = new SimpleInventory(4){
    @Override
    public void markDirty() {
      super.markDirty();
      update();
    }
  };
  
  private final InventoryStorage inventoryStorage = InventoryStorage.of(inventory, null);
  
  public static void tick(World world, BlockPos pos, BlockState state, AlloyFurnaceBE entity) {
    entity.processFuelInput();
    if(!entity.hasValidRecipe()){
      entity.resetProgress();
      entity.update();
      return;
    }
    if (entity.progressFinished()){
      entity.craftOutput();
      entity.resetProgress();
      entity.update();
      return;
    }
    entity.addProgress();
    entity.update();
    
  }
  
  public boolean hasValidRecipe(){
    //TODO: this
    return false;
  }
  
  public float getFuel(){
    return ((float) this.fuel) / ((float) this.MAX_FUEL);
  }
  
  public float getProgress(){
    return ((float) this.progress) / ((float) this.MAX_PROGESS);
  }
  
  private boolean progressFinished(){
    return getProgress() >= 1;
  }
  
  private void craftOutput(){
    //TODO: this
  }
  
  private void addProgress(){
    this.fuel--;
    this.progress++;
    
    if(hasExtention()){
      this.progress++;
    }
    
    assert this.world != null;
    BlockState state = this.world.getBlockState(this.pos).with(AlloyFurnaceBlock.LIT, true);
    this.world.setBlockState(this.pos, state);
  }
  
  private void resetProgress(){
    this.progress = 0;
    
    assert this.world != null;
    BlockState state = this.world.getBlockState(this.pos).with(AlloyFurnaceBlock.LIT, false);
    this.world.setBlockState(this.pos, state);
  }
  
  private void processFuelInput(){
    FuelRegistry fuelRegistry = Objects.requireNonNull(this.getWorld()).getFuelRegistry();
    // TODO: do the rest of this lol
  }
  
  private boolean hasExtention(){
    assert this.world != null;
    return this.world.getBlockState(this.pos).get(AlloyFurnaceBlock.HAS_EXTENTION);
  }
  
  private void update(){
    markDirty();
    if(this.world != null) this.world.updateListeners(this.pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
  }
  
  public SimpleInventory getInventory(){
    return this.inventory;
  }
  
  public InventoryStorage getInventoryStorage(Direction direction){
    return this.inventoryStorage;
  }
  
  @Override
  public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
    return new AlloyFurnaceScreenHandler(syncId, playerInventory, this);
  }
  
  @Override
  public Object getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
    return new BlockPosPayload(this.pos);
  }
  
  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    nbt.putInt("fuel", fuel);
    nbt.putInt("process", progress);
    Inventories.writeNbt(nbt, this.inventory.getHeldStacks(), registryLookup);
    super.writeNbt(nbt, registryLookup);
  }
  
  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    super.readNbt(nbt, registryLookup);
    Inventories.readNbt(nbt, this.inventory.getHeldStacks(), registryLookup);
    
    fuel = nbt.getInt("fuel").orElse(0);
    progress = nbt.getInt("process").orElse(0);
  }
  
  @Override
  public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
    return createNbt(registryLookup);
  }
  
  @Override
  public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
    return BlockEntityUpdateS2CPacket.create(this);
  }
  
  private static final Text DISPLAY_NAME = Text.translatable("container."+ NTM.MOD_ID+".alloy_furnace");
  @Override
  public Text getDisplayName() {
    return DISPLAY_NAME;
  }
}
