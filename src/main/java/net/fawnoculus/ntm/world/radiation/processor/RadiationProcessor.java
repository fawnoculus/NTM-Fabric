package net.fawnoculus.ntm.world.radiation.processor;

import net.fawnoculus.ntm.util.data.CustomData;
import net.fawnoculus.ntm.world.radiation.ServerRadiationManager;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;

public abstract class RadiationProcessor {
  public final ServerRadiationManager radiationManager;
  public final ChunkPos POS;
  
  public RadiationProcessor(ChunkPos pos){
    this.POS = pos;
    radiationManager = ServerRadiationManager.getInstance();
  }
  
  public abstract void tick();
  
  public abstract double getPassiveRadiation(Vec3d pos);
  public abstract double getActiveRadiation(Vec3d pos);
  
  public abstract void writeData(CustomData data);
  public abstract void readData(CustomData data);
}
