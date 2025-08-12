package net.fawnoculus.ntm.misc.radiation.processor;

import net.minecraft.world.chunk.WorldChunk;

public interface RadiationProcessorHolder {
  RadiationProcessor NTM$getRadiationProcessor();

  static RadiationProcessorHolder from(WorldChunk chunk){
    return (RadiationProcessorHolder) chunk;
  }
}
