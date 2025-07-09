package net.fawnoculus.ntm.world.radiation;

import net.fawnoculus.ntm.world.radiation.processor.RadiationProcessor;
import net.minecraft.world.chunk.Chunk;

public interface RadiationProcessorHolder {
  RadiationProcessor NTM$getRadiationProcessor();
  
  static RadiationProcessorHolder from(Chunk chunk){
    return (RadiationProcessorHolder) chunk;
  }
}
