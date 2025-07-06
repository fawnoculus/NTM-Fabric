package net.fawnoculus.ntm.entity;

import net.fawnoculus.ntm.main.NTM;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public interface ModDamageTypes {
  RegistryKey<DamageType> POISON_INJECTION = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, NTM.id("poison_injection"));
  RegistryKey<DamageType> BLOOD_LOSS = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, NTM.id("blood_loss"));
  
  static void initialize(){}
}
