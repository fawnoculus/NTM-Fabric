package net.fawnoculus.ntm.client.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.entity.NTMDamageTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;

import java.util.concurrent.CompletableFuture;

public class NTMDamageTypeTagProvider extends FabricTagProvider<DamageType> {
    public NTMDamageTypeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.DAMAGE_TYPE, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateRawBuilder(DamageTypeTags.BYPASSES_ARMOR)
          .addOptionalElement(NTMDamageTypes.EUTHANIZED.identifier())
          .addOptionalElement(NTMDamageTypes.BLOOD_LOSS.identifier())
          .addOptionalElement(NTMDamageTypes.LEAD_POISONING.identifier())
          .addOptionalElement(NTMDamageTypes.RADIATION.identifier());

        getOrCreateRawBuilder(DamageTypeTags.BYPASSES_EFFECTS)
          .addOptionalElement(NTMDamageTypes.EUTHANIZED.identifier())
          .addOptionalElement(NTMDamageTypes.BLOOD_LOSS.identifier())
          .addOptionalElement(NTMDamageTypes.RADIATION.identifier());

        getOrCreateRawBuilder(DamageTypeTags.BYPASSES_ENCHANTMENTS)
          .addOptionalElement(NTMDamageTypes.EUTHANIZED.identifier())
          .addOptionalElement(NTMDamageTypes.BLOOD_LOSS.identifier())
          .addOptionalElement(NTMDamageTypes.LEAD_POISONING.identifier())
          .addOptionalElement(NTMDamageTypes.RADIATION.identifier());

        getOrCreateRawBuilder(DamageTypeTags.BYPASSES_RESISTANCE)
          .addOptionalElement(NTMDamageTypes.EUTHANIZED.identifier())
          .addOptionalElement(NTMDamageTypes.BLOOD_LOSS.identifier())
          .addOptionalElement(NTMDamageTypes.LEAD_POISONING.identifier())
          .addOptionalElement(NTMDamageTypes.RADIATION.identifier());

        getOrCreateRawBuilder(DamageTypeTags.BYPASSES_INVULNERABILITY)
          .addOptionalElement(NTMDamageTypes.EUTHANIZED.identifier())
          .addOptionalElement(NTMDamageTypes.RADIATION.identifier());

        getOrCreateRawBuilder(DamageTypeTags.BYPASSES_COOLDOWN)
          .addOptionalElement(NTMDamageTypes.EUTHANIZED.identifier())
          .addOptionalElement(NTMDamageTypes.BLOOD_LOSS.identifier())
          .addOptionalElement(NTMDamageTypes.LEAD_POISONING.identifier())
          .addOptionalElement(NTMDamageTypes.RADIATION.identifier());

        getOrCreateRawBuilder(DamageTypeTags.NO_KNOCKBACK)
          .addOptionalElement(NTMDamageTypes.EUTHANIZED.identifier())
          .addOptionalElement(NTMDamageTypes.BLOOD_LOSS.identifier())
          .addOptionalElement(NTMDamageTypes.LEAD_POISONING.identifier())
          .addOptionalElement(NTMDamageTypes.RADIATION.identifier());
    }

    @Override
    public String getName() {
        return NTM.MOD_NAME + " DamageType-Tag Provider";
    }
}
