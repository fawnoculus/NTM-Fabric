package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.misc.data.CustomData;
import net.fawnoculus.ntm.misc.data.CustomDataHolder;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessorHolder;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ProtoChunk;
import net.minecraft.world.chunk.SerializedChunk;
import net.minecraft.world.poi.PointOfInterestStorage;
import net.minecraft.world.storage.StorageKey;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(SerializedChunk.class)
public class SerializedChunkMixin implements CustomDataHolder {
  @Shadow @Final private ChunkPos chunkPos;
  @Unique
  private CustomData customData = new CustomData();
  
  @Inject(method = "fromNbt", at = @At("RETURN"))
  private static void readCustomData(HeightLimitView world, DynamicRegistryManager registryManager, NbtCompound nbt, CallbackInfoReturnable<SerializedChunk> cir){
    Optional<String> string = nbt.getString(CustomData.KEY);
    CustomDataHolder.from(cir.getReturnValue()).NTM$setCustomData(string.map(CustomData::new).orElseGet(CustomData::new));
  }
  
  @Inject(method = "fromChunk", at = @At("RETURN"))
  private static void convertRadiationProcessor(ServerWorld world, Chunk chunk, CallbackInfoReturnable<SerializedChunk> cir){
    CustomData data = CustomDataHolder.from(chunk).NTM$getCustomData();
    RadiationProcessorHolder.from(chunk).NTM$getRadiationProcessor().writeData(data);
    CustomDataHolder.from(cir.getReturnValue()).NTM$setCustomData(data);
  }
  
  @Inject(method = "convert", at = @At("RETURN"))
  private void convertRadiationProcessor(ServerWorld world, PointOfInterestStorage poiStorage, StorageKey key, ChunkPos expectedPos, CallbackInfoReturnable<ProtoChunk> cir){
    RadiationProcessorHolder.from(cir.getReturnValue()).NTM$getRadiationProcessor().readData(this.NTM$getCustomData());
  }
  
  @Inject(method = "serialize", at = @At("RETURN"))
  protected void writeCustomData(CallbackInfoReturnable<NbtCompound> cir){
    cir.getReturnValue().putString(CustomData.KEY, customData.getDataAsString());
  }
  
  @Override
  public @NotNull CustomData NTM$getCustomData() {
    return customData;
  }
  
  @Override
  public void NTM$setCustomData(CustomData customData) {
    this.customData = customData;
  }
}
