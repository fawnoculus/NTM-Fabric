package net.fawnoculus.ntm.misc.radiation.processor;

import net.fawnoculus.ntm.misc.data.CustomData;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public interface RadiationProcessor {
  void tick();
  
  double getPassiveRadiation(Vec3d pos);
  double getActiveRadiation(Vec3d pos);
  default double getPassiveRadiation(Vec3i pos){
    return getPassiveRadiation(new Vec3d(pos));
  }
  default double getActiveRadiation(Vec3i pos){
    return getPassiveRadiation(new Vec3d(pos));
  }
  
  void onChangeBlock(BlockState newState, BlockState previousState, BlockPos pos);
  
  void writeData(CustomData data);
  void readData(CustomData data);
}
