package net.fawnoculus.ntm.blocks.node.type;

import net.fawnoculus.ntm.blocks.node.NodeWithValue;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

public interface StorageNode extends NodeWithValue {
  @Override
  default MutableText getNodeType(){
    return Text.translatable("generic.ntm.node_type.storage");
  }
  void setStorageMode(@NotNull StorageMode mode);
  StorageMode getStorageMode();
  
  /**
   * Called before a nodes Storage Mode is changed to update the networks ticking cache
   */
  default void changeStorageMode(StorageMode newMode){
    if(this.getNetwork() != null){
      this.getNetwork().onStorageModeChange(this, newMode);
    }
  }
  
  @Override
  default void writeNodeData(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    nbt.getString("storage_mode", this.getStorageMode().name());
    NodeWithValue.super.writeNodeData(nbt, registries);
  }
  
  @Override
  default void readNodeData(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    NodeWithValue.super.readNodeData(nbt, registries);
    this.setStorageMode(
        StorageMode.getOrDefault(
            nbt.getString("powered_mode", StorageMode.Consume.name()),
            StorageMode.Consume
        )
    );
  }
  
  @Override
  default boolean provides(){
    return this.getStorageMode().provides;
  }
  
  @Override
  default boolean consumes(){
    return this.getStorageMode().consumes;
  }
  
  enum StorageMode{
    Provide(true, false),
    Consume(false, true),
    Share(true, true),
    None(false, false);
    
    public final boolean provides;
    public final boolean consumes;
    
    StorageMode(boolean provides, boolean consumes){
      this.provides = provides;
      this.consumes = consumes;
    }
    
    public static StorageMode getOrDefault(String name, StorageMode fallback){
      try{
        return valueOf(name);
      }catch (IllegalArgumentException ignored){
        return fallback;
      }
    }
  }
}
