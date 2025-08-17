package net.fawnoculus.ntm.misc.stack;

import net.fawnoculus.ntm.api.node.Node;
import net.fawnoculus.ntm.api.node.NodeValueContainer;
import net.fawnoculus.ntm.api.node.StorageMode;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.Range;

public class EnergyStack implements NodeValueContainer {
  public EnergyStack(Node parent){
    this.PARENT = parent;
  }

  private final Node PARENT;
  private long value = 0;
  private long maxValue = 0;
  private long priority = 0;
  private boolean consumes = false;
  private boolean provides = false;
  private Runnable onChange = () -> {};

  @Override
  public EnergyStack setValue(@Range(from = 0, to = Long.MAX_VALUE) long value) {
    this.value = value;
    onChange.run();
    return this;
  }

  @Override
  public long getValue() {
    return this.value;
  }

  @Override
  public EnergyStack setMaxValue(@Range(from = 0, to = Long.MAX_VALUE) long value) {
    this.maxValue = value;
    onChange.run();
    return this;
  }

  @Override
  public long getMaxValue() {
    return this.maxValue;
  }

  @Override
  public EnergyStack setPriority(long value) {
    this.priority = value;
    onChange.run();
    return this;
  }

  @Override
  public long getPriority() {
    return this.priority;
  }

  public EnergyStack setProvides(boolean provides) {
    this.onUpdateProvides(this.provides, provides);
    this.provides = provides;
    onChange.run();
    return this;
  }

  @Override
  public boolean provides() {
    return false;
  }

  public EnergyStack setConsumes(boolean consumes) {
    this.onUpdateConsumes(this.consumes, consumes);
    this.consumes = consumes;
    onChange.run();
    return this;
  }

  @Override
  public boolean consumes() {
    return this.consumes;
  }

  @Override
  public Node getParent() {
    return this.PARENT;
  }

  public EnergyStack onChange(Runnable runnable){
    this.onChange = runnable;
    return this;
  }

  public void writeNBT(NbtCompound nbt){
    this.value = nbt.getLong("energy_stack.stored_energy", 0);
    this.priority = nbt.getLong("energy_stack.priority", 0);
  }

  public void readNBT(NbtCompound nbt){
    nbt.putLong("energy_stack.stored_energy", this.value);
    nbt.putLong("energy_stack.priority", this.priority);
  }

  public static class Storage extends EnergyStack {
    public Storage(Node parent) {
      super(parent);
    }

    private StorageMode mode = StorageMode.Consume;

    public StorageMode getStorageMode(){
      return this.mode;
    }

    public void setStorageMode(StorageMode mode){
      this.setConsumes(mode.consumes);
      this.setProvides(mode.provides);

      this.mode = mode;
    }

    @Override
    public Storage setValue(@Range(from = 0, to = Long.MAX_VALUE) long value) {
      super.setValue(value);
      return this;
    }

    @Override
    public Storage setMaxValue(@Range(from = 0, to = Long.MAX_VALUE) long value) {
      super.setMaxValue(value);
      return this;
    }

    @Override
    public Storage setPriority(long value) {
      super.setPriority(value);
      return this;
    }

    @Override
    public Storage setConsumes(boolean consumes) {
      super.setConsumes(consumes);
      return this;
    }

    @Override
    public Storage setProvides(boolean provides) {
      super.setProvides(provides);
      return this;
    }

    @Override
    public Storage onChange(Runnable runnable) {
      super.onChange(runnable);
      return this;
    }

    @Override
    public void readNBT(NbtCompound nbt) {
      super.readNBT(nbt);
      this.mode = nbt.get("energy_stack.storage_mode", StorageMode.CODEC).orElse(StorageMode.Consume);
    }

    @Override
    public void writeNBT(NbtCompound nbt) {
      super.writeNBT(nbt);
      nbt.put("energy_stack.storage_mode", StorageMode.CODEC, this.mode);
    }
  }
}
