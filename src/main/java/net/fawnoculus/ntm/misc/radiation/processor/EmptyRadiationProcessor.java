package net.fawnoculus.ntm.misc.radiation.processor;

import net.fawnoculus.ntm.misc.data.CustomData;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/**
 * A Radiation Processor that does absolutely nothing.
 */
public class EmptyRadiationProcessor implements RadiationProcessor {
  @Override
  public void tick() {}
  
  @Override
  public double getPassiveRadiation(Vec3d pos) {
    return 0;
  }
  
  @Override
  public double getActiveRadiation(Vec3d pos) {
    return 0;
  }
  
  @Override
  public void onChangeBlock(BlockState newState, BlockState previousState, BlockPos pos) {}
  
  @Override
  public void writeData(CustomData data) {}
  
  @Override
  public void readData(CustomData data) {}
}
