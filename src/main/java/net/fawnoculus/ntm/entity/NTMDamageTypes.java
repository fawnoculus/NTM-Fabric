package net.fawnoculus.ntm.entity;

import net.fawnoculus.ntm.NTM;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class NTMDamageTypes {
  public static final RegistryKey<DamageType> EUTHANIZED = of("euthanized");
  public static final RegistryKey<DamageType> BLOOD_LOSS = of("blood_loss");
  public static final RegistryKey<DamageType> LEAD_POISONING = of("lead_poisoning");
  public static final RegistryKey<DamageType> RADIATION = of("radiation");
  
  private static RegistryKey<DamageType> of(String name){
    return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, NTM.id(name));
  }
  
  public static void initialize(){}
}
