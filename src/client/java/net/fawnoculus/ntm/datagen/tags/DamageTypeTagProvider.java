package net.fawnoculus.ntm.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.entity.ModDamageTypes;
import net.fawnoculus.ntm.NTM;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.DamageTypeTags;

import java.util.concurrent.CompletableFuture;

public class DamageTypeTagProvider extends FabricTagProvider<DamageType> {
  public DamageTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, RegistryKeys.DAMAGE_TYPE, registriesFuture);
  }
  
  @Override
  protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
    getOrCreateTagBuilder(DamageTypeTags.BYPASSES_ARMOR)
        .addOptional(ModDamageTypes.EUTHANIZED.getValue())
        .addOptional(ModDamageTypes.BLOOD_LOSS.getValue())
        .addOptional(ModDamageTypes.LEAD_POISONING.getValue())
        .addOptional(ModDamageTypes.RADIATION.getValue())
        .setReplace(false);
    getOrCreateTagBuilder(DamageTypeTags.BYPASSES_EFFECTS)
        .addOptional(ModDamageTypes.EUTHANIZED.getValue())
        .addOptional(ModDamageTypes.BLOOD_LOSS.getValue())
        .addOptional(ModDamageTypes.RADIATION.getValue())
        .setReplace(false);
    getOrCreateTagBuilder(DamageTypeTags.BYPASSES_ENCHANTMENTS)
        .addOptional(ModDamageTypes.EUTHANIZED.getValue())
        .addOptional(ModDamageTypes.BLOOD_LOSS.getValue())
        .addOptional(ModDamageTypes.LEAD_POISONING.getValue())
        .addOptional(ModDamageTypes.RADIATION.getValue())
        .setReplace(false);
    getOrCreateTagBuilder(DamageTypeTags.BYPASSES_RESISTANCE)
        .addOptional(ModDamageTypes.EUTHANIZED.getValue())
        .addOptional(ModDamageTypes.BLOOD_LOSS.getValue())
        .addOptional(ModDamageTypes.LEAD_POISONING.getValue())
        .addOptional(ModDamageTypes.RADIATION.getValue())
        .setReplace(false);
    getOrCreateTagBuilder(DamageTypeTags.BYPASSES_INVULNERABILITY)
        .addOptional(ModDamageTypes.EUTHANIZED.getValue())
        .addOptional(ModDamageTypes.RADIATION.getValue())
        .setReplace(false);
    getOrCreateTagBuilder(DamageTypeTags.BYPASSES_COOLDOWN)
        .addOptional(ModDamageTypes.EUTHANIZED.getValue())
        .addOptional(ModDamageTypes.BLOOD_LOSS.getValue())
        .addOptional(ModDamageTypes.LEAD_POISONING.getValue())
        .addOptional(ModDamageTypes.RADIATION.getValue())
        .setReplace(false);
    getOrCreateTagBuilder(DamageTypeTags.NO_KNOCKBACK)
        .addOptional(ModDamageTypes.EUTHANIZED.getValue())
        .addOptional(ModDamageTypes.BLOOD_LOSS.getValue())
        .addOptional(ModDamageTypes.LEAD_POISONING.getValue())
        .addOptional(ModDamageTypes.RADIATION.getValue())
        .setReplace(false);
  }
  
  @Override
  public String getName() {
    return NTM.MOD_NAME + " DamageType-Tag Provider";
  }
}
