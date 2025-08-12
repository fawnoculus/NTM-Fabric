package net.fawnoculus.ntm.misc.radiation.processor;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;

import java.util.Collection;

public interface RadiationProcessorMultiHolder {
  Collection<RadiationProcessor> NTM$getRadiationProcessors();
  RadiationProcessor NTM$getRadiationProcessor(ChunkPos chunkPos);
  void NTM$addRadiationProcessor(RadiationProcessor processor, ChunkPos chunkPos);
  void NTM$removeRadiationProcessor(ChunkPos chunkPos);
  void NTM$removeRadiationProcessor(RadiationProcessor processor);

  static RadiationProcessorMultiHolder from(ServerWorld world){
    return (RadiationProcessorMultiHolder) world;
  }
}
