package net.fawnoculus.ntm.misc.data;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.SerializedChunk;
import org.jetbrains.annotations.NotNull;

public interface CustomDataHolder {
  @NotNull CustomData NTM$getCustomData();
  void NTM$setCustomData(CustomData customData);
  
  
  
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
