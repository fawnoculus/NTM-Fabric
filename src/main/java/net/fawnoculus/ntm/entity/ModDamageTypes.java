package net.fawnoculus.ntm.entity;

import net.fawnoculus.ntm.NTM;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public interface ModDamageTypes {
  RegistryKey<DamageType> EUTHANIZED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, NTM.id("euthanized"));
  RegistryKey<DamageType> BLOOD_LOSS = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, NTM.id("blood_loss"));
  RegistryKey<DamageType> LEAD_POISONING = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, NTM.id("lead_poisoning"));
  RegistryKey<DamageType> RADIATION = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, NTM.id("radiation"));
  
  static void initialize(){}
}
