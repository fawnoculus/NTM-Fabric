package net.fawnoculus.ntm.misc.radiation.processor;

import net.minecraft.world.chunk.Chunk;

public interface RadiationProcessorHolder {
  RadiationProcessor NTM$getRadiationProcessor();
  
  static RadiationProcessorHolder from(Chunk chunk){
    return (RadiationProcessorHolder) chunk;
  }
}
