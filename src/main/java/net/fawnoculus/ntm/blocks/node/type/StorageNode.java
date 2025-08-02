package net.fawnoculus.ntm.blocks.node.type;

import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.blocks.node.NodeWithValue;
import net.fawnoculus.ntm.misc.data.NTMCodecs;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
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
  default void onStorageModeChange(StorageMode newMode){
    if(this.getNetwork() != null){
      this.getNetwork().onStorageModeChange(this, newMode);
    }
  }
  
  default void writeStorageMode(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    nbt.put("storage_mode", StorageMode.CODEC, this.getStorageMode());
  }
  default void readStorageMode(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    this.setStorageMode(
        nbt.get("storage_mode", StorageMode.CODEC).orElse(StorageMode.Consume)
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
  
  enum StorageMode {
    Provide(true, false, "narration.ntm.storage_mode.provide"),
    Consume(false, true, "narration.ntm.storage_mode.consume"),
    Share(true, true, "narration.ntm.storage_mode.share"),
    None(false, false, "narration.ntm.storage_mode.none");
    
    public static final Codec<StorageMode> CODEC = NTMCodecs.getEnumCodec(StorageMode.class);
    
    public final boolean provides;
    public final boolean consumes;
    public final String translationKey;
    
    StorageMode(boolean provides, boolean consumes, String translationKey) {
      this.provides = provides;
      this.consumes = consumes;
      this.translationKey = translationKey;
    }
    
    public StorageMode cycle() {
      return cycle(this);
    }
    
    public static StorageMode cycle(@NotNull StorageMode mode) {
      return switch (mode) {
        case None -> Provide;
        case Provide -> Consume;
        case Consume -> Share;
        case Share -> None;
      };
    }
  }
}
