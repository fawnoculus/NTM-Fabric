package net.fawnoculus.ntm.fluid.data.custom;

import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.misc.data.NTMCodecs;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public enum FuelGrade {
  LOW(Text.translatable("fluid_tooltip.ntm.fuel_grade.low").formatted(Formatting.RED)),
  MEDIUM(Text.translatable("fluid_tooltip.ntm.fuel_grade.medium").formatted(Formatting.RED)),
  HIGH(Text.translatable("fluid_tooltip.ntm.fuel_grade.high").formatted(Formatting.RED)),
  AVIATION(Text.translatable("fluid_tooltip.ntm.fuel_grade.aviation").formatted(Formatting.RED)),
  GASEOUS(Text.translatable("fluid_tooltip.ntm.fuel_grade.gaseous").formatted(Formatting.RED));

  public static final Codec<FuelGrade> CODEC = NTMCodecs.getEnumCodec(FuelGrade.class);
  public final Text NAME;

  FuelGrade(Text name){
    this.NAME = name;
  }
}
