package net.fawnoculus.ntm.blocks.node;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Range;

public interface NodeWithValue extends Node {
  void setValue(@Range(from = 0, to = Long.MAX_VALUE) long value);
  long getValue();
  void setMaxValue(@Range(from = 0, to = Long.MAX_VALUE) long value);
  long getMaxValue();
  void setPriority(long value);
  long getPriority();
  
  /**
   * Called before a nodes priority is changed to update the networks ticking cache
   */
  default void changePriority(long newPriority){
    if(this.getNetwork() != null){
      this.getNetwork().onPriorityChange(this, newPriority);
    }
  }
  
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
  
  @Override
  default void readNodeData(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    Node.super.readNodeData(nbt, registries);
    this.setValue(nbt.getLong("value", 0));
    this.setPriority(nbt.getLong("priority_value", 0));
  }
  
  @Override
  default void writeNodeData(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    nbt.putLong("value", this.getValue());
    nbt.putLong("priority_value", this.getPriority());
    Node.super.writeNodeData(nbt, registries);
  }
  
  boolean consumes();
  boolean provides();
}
