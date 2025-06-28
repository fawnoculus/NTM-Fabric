package net.fawnoculus.ntm.blocks.custom.node;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public interface NodeProperties {
  void setValue(long value);
  long getValue();
  void setPriority(long value);
  long getPriority();
  void setMaxTransfer(@Range(from = 0, to = Long.MAX_VALUE) long value);
  long getMaxTransfer();
  void setMaxValue(@Range(from = 0, to = Long.MAX_VALUE) long value);
  long getMaxValue();
  void writeNBT(NbtCompound nbt, RegistryWrapper.WrapperLookup registries);
  void readNBT(NbtCompound nbt, RegistryWrapper.WrapperLookup registries);
  void setStorageMode(@NotNull NodeProperties.StorageMode mode);
  @Nullable
  NodeProperties.StorageMode getStorageMode();
  
  default boolean hasAtLeast(long value){
    return this.getValue() >= value;
  }
  
  /**
   * @param value the Value to be Stored
   * @return the amount that could not be stored (aka the remainder)
   */
  default long add(long value){
    long remainingSpace = this.getMaxValue() - this.getValue();
    if(value > remainingSpace){
      this.setValue(this.getMaxValue());
      return value - remainingSpace;
    }
    this.setValue(this.getValue() + value);
    return 0;
  }
  /**
   * @param value the Value to be Removed
   * @return the amount that could not be removed (aka the remainder)
   */
  default long remove(long value){
    long previousValue = this.getValue();
    if(value > previousValue){
      this.setValue(0);
      return value - previousValue;
    }
    this.setValue(previousValue - value);
    return 0;
  }
  
  class Connector implements NodeProperties {
    @Override
    public void setValue(long value) {}
    @Override
    public long getValue() {return 0;}
    @Override
    public void setPriority(long value) {}
    @Override
    public long getPriority() {return 0;}
    @Override
    public void setMaxTransfer(long value) {}
    @Override
    public long getMaxTransfer() {return 0;}
    @Override
    public void setMaxValue(long value) {}
    @Override
    public long getMaxValue() {return 0;}
    @Override
    public void writeNBT(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {}
    @Override
    public void readNBT(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {}
    @Override
    public void setStorageMode(Storge.@NotNull StorageMode mode) {}
    @Override
    public @Nullable NodeProperties.StorageMode getStorageMode() {return null;}
  }
  class Provider implements NodeProperties {
    long value = 0;
    long maxValue = 0;
    long priority = 0;
    long maxTransfer = 0;
    @Override
    public void setValue(long value) {
      this.value = value;
    }
    @Override
    public long getValue() {
      return this.value;
    }
    @Override
    public void setPriority(long value) {
      this.priority = value;
    }
    @Override
    public long getPriority() {
      return this.priority;
    }
    @Override
    public void setMaxTransfer(long value) {
      this.maxTransfer = value;
    }
    @Override
    public long getMaxTransfer() {
      return this.maxTransfer;
    }
    @Override
    public void setMaxValue(long value) {
      this.maxValue = value;
    }
    @Override
    public long getMaxValue() {
      return this.maxValue;
    }
    @Override
    public void writeNBT(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
      nbt.putLong("value", value);
      nbt.putLong("priority", priority);
    }
    @Override
    public void readNBT(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
      this.value = nbt.getLong("value", 0);
      this.priority = nbt.getLong("priority", 0);
    }
    @Override
    public void setStorageMode(Storge.@NotNull StorageMode mode) {}
    @Override
    public @Nullable NodeProperties.StorageMode getStorageMode() {return null;}
  }
  class Consumer implements NodeProperties {
    long value = 0;
    long maxValue = 0;
    long priority = 0;
    long maxTransfer = 0;
    @Override
    public void setValue(long value) {
      this.value = value;
    }
    @Override
    public long getValue() {
      return this.value;
    }
    @Override
    public void setPriority(long value) {
      this.priority = value;
    }
    @Override
    public long getPriority() {
      return this.priority;
    }
    @Override
    public void setMaxTransfer(long value) {
      this.maxTransfer = value;
    }
    @Override
    public long getMaxTransfer() {
      return this.maxTransfer;
    }
    @Override
    public void setMaxValue(long value) {
      this.maxValue = value;
    }
    @Override
    public long getMaxValue() {
      return this.maxValue;
    }
    @Override
    public void writeNBT(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
      nbt.putLong("value", value);
      nbt.putLong("priority", priority);
    }
    @Override
    public void readNBT(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
      this.value = nbt.getLong("value", 0);
      this.priority = nbt.getLong("priority", 0);
    }
    @Override
    public void setStorageMode(Storge.@NotNull StorageMode mode) {}
    @Override
    public @Nullable NodeProperties.StorageMode getStorageMode() {return null;}
  }
  class Storge implements NodeProperties {
    long value = 0;
    long maxValue = 0;
    long priority = 0;
    long maxTransfer = 0;
    StorageMode mode = StorageMode.Consume;
    @Override
    public void setValue(long value) {
      this.value = value;
    }
    @Override
    public long getValue() {
      return this.value;
    }
    @Override
    public void setPriority(long value) {
      this.priority = value;
    }
    @Override
    public long getPriority() {
      return this.priority;
    }
    @Override
    public void setMaxTransfer(long value) {
      this.maxTransfer = value;
    }
    @Override
    public long getMaxTransfer() {
      return this.maxTransfer;
    }
    @Override
    public void setMaxValue(long value) {
      this.maxValue = value;
    }
    @Override
    public long getMaxValue() {
      return this.maxValue;
    }
    @Override
    public void writeNBT(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
      nbt.putLong("value", value);
      nbt.putLong("priority", priority);
      nbt.putString("storageMode", this.mode.name());
    }
    @Override
    public void readNBT(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
      this.value = nbt.getLong("value", 0);
      this.priority = nbt.getLong("priority", 0);
      this.mode = StorageMode.valueOf(nbt.getString("priority", StorageMode.Consume.name()));
    }
    @Override
    public void setStorageMode(Storge.@NotNull StorageMode mode) {
      this.mode = mode;
    }
    @Override
    public @Nullable NodeProperties.StorageMode getStorageMode() {
      return this.mode;
    }
  }
  enum StorageMode{
    Provide,
    Consume,
    Share,
    None
  }
}
