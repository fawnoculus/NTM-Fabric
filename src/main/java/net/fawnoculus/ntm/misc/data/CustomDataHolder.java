package net.fawnoculus.ntm.misc.data;

import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.SerializedChunk;
import org.jetbrains.annotations.NotNull;

public interface CustomDataHolder {
  String  KEY = "ntm.custom_data";
  
  @NotNull NbtCompound NTM$getCustomData();
  void NTM$setCustomData(NbtCompound customData);
  
  
  
  static CustomDataHolder from(SerializedChunk serializedChunk){
    return (CustomDataHolder) (Object) serializedChunk;
  }
  static CustomDataHolder from(Chunk chunk){
    return (CustomDataHolder) chunk;
  }
  static CustomDataHolder from(LivingEntity entity){
    return (CustomDataHolder) entity;
  }
}
