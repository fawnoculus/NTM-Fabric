package net.fawnoculus.ntm.client.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.entity.NTMDamageTypes;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.DamageTypeTags;

import java.util.concurrent.CompletableFuture;

public class NTMDamageTypeTagProvider extends FabricTagProvider<DamageType> {
	public NTMDamageTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, RegistryKeys.DAMAGE_TYPE, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		getTagBuilder(DamageTypeTags.BYPASSES_ARMOR)
		  .addOptional(NTMDamageTypes.EUTHANIZED.getValue())
		  .addOptional(NTMDamageTypes.BLOOD_LOSS.getValue())
		  .addOptional(NTMDamageTypes.LEAD_POISONING.getValue())
		  .addOptional(NTMDamageTypes.RADIATION.getValue());

		getTagBuilder(DamageTypeTags.BYPASSES_EFFECTS)
		  .addOptional(NTMDamageTypes.EUTHANIZED.getValue())
		  .addOptional(NTMDamageTypes.BLOOD_LOSS.getValue())
		  .addOptional(NTMDamageTypes.RADIATION.getValue());

		getTagBuilder(DamageTypeTags.BYPASSES_ENCHANTMENTS)
		  .addOptional(NTMDamageTypes.EUTHANIZED.getValue())
		  .addOptional(NTMDamageTypes.BLOOD_LOSS.getValue())
		  .addOptional(NTMDamageTypes.LEAD_POISONING.getValue())
		  .addOptional(NTMDamageTypes.RADIATION.getValue());

		getTagBuilder(DamageTypeTags.BYPASSES_RESISTANCE)
		  .addOptional(NTMDamageTypes.EUTHANIZED.getValue())
		  .addOptional(NTMDamageTypes.BLOOD_LOSS.getValue())
		  .addOptional(NTMDamageTypes.LEAD_POISONING.getValue())
		  .addOptional(NTMDamageTypes.RADIATION.getValue());

		getTagBuilder(DamageTypeTags.BYPASSES_INVULNERABILITY)
		  .addOptional(NTMDamageTypes.EUTHANIZED.getValue())
		  .addOptional(NTMDamageTypes.RADIATION.getValue());

		getTagBuilder(DamageTypeTags.BYPASSES_COOLDOWN)
		  .addOptional(NTMDamageTypes.EUTHANIZED.getValue())
		  .addOptional(NTMDamageTypes.BLOOD_LOSS.getValue())
		  .addOptional(NTMDamageTypes.LEAD_POISONING.getValue())
		  .addOptional(NTMDamageTypes.RADIATION.getValue());

		getTagBuilder(DamageTypeTags.NO_KNOCKBACK)
		  .addOptional(NTMDamageTypes.EUTHANIZED.getValue())
		  .addOptional(NTMDamageTypes.BLOOD_LOSS.getValue())
		  .addOptional(NTMDamageTypes.LEAD_POISONING.getValue())
		  .addOptional(NTMDamageTypes.RADIATION.getValue());
	}

	@Override
	public String getName() {
		return NTM.MOD_NAME + " DamageType-Tag Provider";
	}
}
