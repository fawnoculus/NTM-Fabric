package net.fawnoculus.ntm.world.radiation.client;

import net.minecraft.entity.LivingEntity;

public class ClientHazmatRegistry {
  private static final ClientHazmatRegistry INSTANCE = new ClientHazmatRegistry();
  
  public static ClientHazmatRegistry getInstance(){
    return INSTANCE;
  }
  
  public double getResistance(LivingEntity entity){
    return 0;
  }
}
