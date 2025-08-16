package net.fawnoculus.ntm.fluid.data.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.fluid.stack.FluidUnit;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

// FIXME (once there is an Atmosphere &/or Pollution System)
public record PollutionData(String name, Double amount){
  public static final Codec<PollutionData> CODEC = RecordCodecBuilder.create(
    instance -> instance.group(
      Codec.STRING.fieldOf("name").forGetter(PollutionData::name),
      Codec.DOUBLE.fieldOf("amount").forGetter(PollutionData::amount)
    ).apply(instance, PollutionData::new)
  );

  public String getFluidName(){
    // TODO: make Pollution a Thing
    return this.name;
  }

  public @NotNull MutableText getTooltip(){
    return switch (NTMConfig.FluidUnit.getValue()) {
      case "MilliBuckets" -> Text.translatable("fluid_tooltip.ntm.polluting.val", this.getFluidName(), this.amount() / FluidUnit.MILLI_BUCKET.DROPLETS)
        .append(Text.translatable("generic.ntm.fluid.mb"));
      case "Droplets" -> Text.translatable("fluid_tooltip.ntm.polluting.val", this.getFluidName(), this.amount())
        .append(Text.translatable("generic.ntm.fluid.droplets"));
      default -> Text.empty();
    };
  }
}
