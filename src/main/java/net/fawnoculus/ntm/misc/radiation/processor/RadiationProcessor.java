package net.fawnoculus.ntm.misc.radiation.processor;

import net.fawnoculus.ntm.misc.data.CustomData;
import net.fawnoculus.ntm.misc.radiation.RadiationManager;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;

public abstract class RadiationProcessor {
  public final RadiationManager radiationManager;
  public final ChunkPos POS;
  
  public RadiationProcessor(ChunkPos pos){
    this.POS = pos;
    radiationManager = RadiationManager.getInstance();
  }
  
  public abstract void tick();
  
  public abstract double getPassiveRadiation(Vec3d pos);
  public abstract double getActiveRadiation(Vec3d pos);
  
  public abstract void writeData(CustomData data);
  public abstract void readData(CustomData data);
}
