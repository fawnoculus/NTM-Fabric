package net.fawnoculus.ntm.misc.radiation;

import net.minecraft.entity.LivingEntity;

public class HazmatRegistry {
  private static final HazmatRegistry INSTANCE = new HazmatRegistry();
  
  public static HazmatRegistry getInstance(){
    return INSTANCE;
  }
  
  public double getResistance(LivingEntity entity){
    return 0;
  }
}
