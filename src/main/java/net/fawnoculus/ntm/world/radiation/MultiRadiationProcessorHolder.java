package net.fawnoculus.ntm.world.radiation;

import net.fawnoculus.ntm.world.radiation.processor.RadiationProcessor;
import net.minecraft.server.world.ServerWorld;

import java.util.List;

public interface MultiRadiationProcessorHolder {
  List<RadiationProcessor> NTM$getRadiationProcessors();
  void NTM$addRadiationProcessors(RadiationProcessor processor);
  void NTM$removeRadiationProcessors(RadiationProcessor processor);
  
  static MultiRadiationProcessorHolder from(ServerWorld world){
    return (MultiRadiationProcessorHolder) world;
  }
}
