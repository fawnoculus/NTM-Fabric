package net.fawnoculus.ntm.fluid.data.custom;

import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.misc.data.NTMCodecs;
import net.minecraft.text.Text;

public enum ToxinType {
	AIRBORNE_PARTICLES(Text.translatable("fluid_tooltip.ntm.toxin_type.airborne_particles")),
	PARTICULATES(Text.translatable("fluid_tooltip.ntm.toxin_type.particulates")),
	CHEMICAL_GAS(Text.translatable("fluid_tooltip.ntm.toxin_type.chemical_gas")),
	CORROSIVE_FUMES(Text.translatable("fluid_tooltip.ntm.toxin_type.corrosive_fumes")),
	AEROSOLS(Text.translatable("fluid_tooltip.ntm.toxin_type.aerosols")),
	CARBON_MONOXIDE(Text.translatable("fluid_tooltip.ntm.toxin_type.carbon_monoxide"));

	public static final Codec<ToxinType> CODEC = NTMCodecs.getEnumCodec(ToxinType.class);
	public final Text NAME;

	ToxinType(Text name) {
		this.NAME = name;
	}
}
