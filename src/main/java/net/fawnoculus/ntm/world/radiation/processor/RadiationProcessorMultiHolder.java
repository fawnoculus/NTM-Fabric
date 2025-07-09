package net.fawnoculus.ntm.world.radiation.processor;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;

import java.util.Collection;

public interface RadiationProcessorMultiHolder {
  Collection<RadiationProcessor> NTM$getRadiationProcessors();
  RadiationProcessor NTM$getRadiationProcessor(ChunkPos chunkPos);
  void NTM$addRadiationProcessors(RadiationProcessor processor, ChunkPos chunkPos);
  void NTM$removeRadiationProcessors(ChunkPos chunkPos);
  void NTM$removeRadiationProcessors(RadiationProcessor processor);
  
  static RadiationProcessorMultiHolder from(ServerWorld world){
    return (RadiationProcessorMultiHolder) world;
  }
}
