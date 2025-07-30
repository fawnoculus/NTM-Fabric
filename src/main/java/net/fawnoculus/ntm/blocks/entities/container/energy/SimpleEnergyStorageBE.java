package net.fawnoculus.ntm.blocks.entities.container.energy;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.blocks.node.type.StorageNode;
import net.fawnoculus.ntm.gui.handlers.EnergyStorageScreenHandler;
import net.fawnoculus.ntm.items.custom.container.energy.EnergyContainingItem;
import net.fawnoculus.ntm.network.custom.BlockPosS2CPayload;
import net.fawnoculus.ntm.util.TextUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class SimpleEnergyStorageBE extends EnergyInventoryBE implements StorageNode, ExtendedScreenHandlerFactory<BlockPosS2CPayload> {
  public static final Text NAME = Text.translatable("container.ntm.energy_storage");
  
  public static final int DISCHARGE_SLOT_INDEX = 0;
  public static final int CHARGE_SLOT_INDEX = 1;
  
  public SimpleEnergyStorageBE(BlockPos pos, BlockState state) {
    super(NTMBlockEntities.SIMPLE_ENERGY_STORAGE_BE, pos, state, 2);
  }
  
  public boolean isPowered = false;
  private StorageMode storageMode = StorageMode.Consume;
  public StorageMode poweredMode = StorageMode.Consume;
  public StorageMode unpoweredMode = StorageMode.Provide;
  
  public long previousEnergy = 0;
  public long[] energyChange = new long[20];
  public int energyChangeIndex = 0;
  
  
  @Override
  public void setStorageMode(@NotNull StorageMode mode) {
    this.changeStorageMode(mode);
    this.storageMode = mode;
  }
  
  @Override
  public StorageMode getStorageMode() {
    return this.storageMode;
  }
  
  public static void tick(World world, BlockPos pos, BlockState state, SimpleEnergyStorageBE entity) {
    entity.processBatteries();
    entity.updateEnergyChange();
    entity.update();
  }
  
  private void processBatteries(){
    ItemStack dischargeStack = getStack(DISCHARGE_SLOT_INDEX);
    if(dischargeStack.getItem() instanceof EnergyContainingItem energyContainingItem){
      energyContainingItem.discharge(dischargeStack, this);
    }
    ItemStack chargeStack = getStack(CHARGE_SLOT_INDEX);
    if(chargeStack.getItem() instanceof EnergyContainingItem energyContainingItem){
      energyContainingItem.charge(chargeStack, this);
    }
  }
  
  private void updateEnergyChange(){
    if(this.energyChangeIndex >= 20 || this.energyChangeIndex < 0){
      this.energyChangeIndex = 0;
    }
    long energyDifference = this.getValue() - this.previousEnergy;
    this.energyChange[this.energyChangeIndex] = energyDifference;
    this.energyChangeIndex++;
    this.previousEnergy = this.getValue();
  }
  
  public void onBlockUpdate(){
    if(this.world != null){
      this.isPowered = this.world.getReceivedRedstonePower(this.pos) > 0;
    }
  }
  
  @Override
  public void setWorld(World world) {
    super.setWorld(world);
    this.onBlockUpdate();
  }
  
  public Text getEnergyPerSec(){
    OptionalDouble optional = Arrays.stream(energyChange).average();
    long energyPerSec = (long) optional.orElse(0);
    if(energyPerSec < 0) {
      return TextUtil.unit(energyPerSec, "generic.ntm.energy_s").formatted(Formatting.RED);
    }
    
    Formatting formatting = Formatting.YELLOW;
    if(energyPerSec > 0) formatting = Formatting.GREEN;
    
    return Text.literal("+").append(TextUtil.unit(energyPerSec, "generic.ntm.energy_s")).formatted(formatting);
  }
  
  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    nbt.putString("powered_mode", this.poweredMode.name());
    nbt.putString("unpowered_mode", this.unpoweredMode.name());
    nbt.putBoolean("is_powered", this.isPowered);
    nbt.putInt("energy_change_index", this.energyChangeIndex);
    nbt.putLongArray("energy_change", energyChange);
    super.writeNbt(nbt, registryLookup);
  }
  
  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    super.readNbt(nbt, registryLookup);
    this.poweredMode = StorageMode.getOrDefault(
        nbt.getString("powered_mode", StorageMode.Consume.name()),
        StorageMode.Consume
    );
    this.unpoweredMode = StorageMode.getOrDefault(
        nbt.getString("unpowered_mode", StorageMode.Provide.name()),
        StorageMode.Provide
    );
    this.isPowered = nbt.getBoolean("is_powered", false);
    this.energyChangeIndex = nbt.getInt("energy_change_index", 0);
    
    Optional<long[]> optional = nbt.getLongArray("energy_change");
    if(optional.isPresent() && optional.get().length == this.energyChange.length){
      this.energyChange = optional.get();
    }
  }
  
  @Override
  public BlockPosS2CPayload getScreenOpeningData(ServerPlayerEntity player) {
    return new BlockPosS2CPayload(this.pos);
  }
  
  @Override
  public Text getDisplayName() {
    return NAME;
  }
  
  @Override
  public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
    return new EnergyStorageScreenHandler(syncId, playerInventory, this);
  }
}
