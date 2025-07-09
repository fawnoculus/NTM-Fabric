package net.fawnoculus.ntm.world.radiation.processor;

import net.fawnoculus.ntm.util.data.CustomData;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;

/**
 * A Radiation Processor that does absolutely nothing.
 */
public class EmptyRadiationProcessor extends RadiationProcessor {
  public EmptyRadiationProcessor() {
    super(ChunkPos.ORIGIN);
  }
  
  @Override
  public void tick() {
  }
  
  @Override
  public double getPassiveRadiation(Vec3d pos) {
    return 0;
  }
  
  @Override
  public double getActiveRadiation(Vec3d pos) {
    return 0;
  }
  
  @Override
  public void writeData(CustomData data) {
  }
  
  @Override
  public void readData(CustomData data) {
  }
}
