package net.fawnoculus.ntm.fluid.data;

import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.fluid.data.custom.*;
import net.fawnoculus.ntm.fluid.FluidUnit;
import net.fawnoculus.ntm.util.TextUtil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class FluidDataTypes {
  public static final FluidDataType<Double> TEMPERATURE = register("temperature", Codec.DOUBLE, 20.0, Tooltips::temperature);
  public static final FluidDataType<HeatingData> HEATABLE = register("heatable", HeatingData.CODEC, HeatingData.DEFAULT, Tooltips::boilable, true);
  public static final FluidDataType<CoolingData> COOLABLE = register("coolable", CoolingData.CODEC, CoolingData.DEFAULT, Tooltips::coolable, true);
  public static final FluidDataType<Double> PWR_FLUX_MULTIPLIER = register("pwr_flux_multiplier", Codec.DOUBLE, 0.0, Tooltips::pwrFluxMultiplier, true);
  public static final FluidDataType<Double> FLAMMABLE = register("flammable", Codec.DOUBLE, 0.0, Tooltips::flammable);
  public static final FluidDataType<Combustible> COMBUSTIBLE = register("combustible", Combustible.CODEC, Combustible.DEFAULT, Tooltips::combustible);
  public static final FluidDataType<Polluting> POLLUTING = register("polluting", Polluting.CODEC, Polluting.DEFAULT, Tooltips::polluting, true);
  public static final FluidDataType<Boolean> RADIOACTIVE = register("radioactive", Codec.BOOL, false, Tooltips::radioactive);
  public static final FluidDataType<Boolean> TOXIC_FUMES = register("toxic_fumes", Codec.BOOL, false, Tooltips::toxicFumes, true);
  public static final FluidDataType<ToxinData> TOXIN = register("toxin", ToxinData.CODEC, ToxinData.DEFAULT, Tooltips::toxin, true);
  public static final FluidDataType<Boolean> GLYPHID_PHEROMONES = register("glyphid_pheromones", Codec.BOOL, false, Tooltips::glyphidPheromones);
  public static final FluidDataType<Boolean> MODIFIED_PHEROMONES = register("modified_pheromones", Codec.BOOL, false, Tooltips::modifiedPheromones);
  public static final FluidDataType<Boolean> GASEOUS_AT_ROOM_TEMPERATURE = register("gaseous_at_room_temperature", Codec.BOOL, false, Tooltips::gaseousAtRoomTemperature, true);
  public static final FluidDataType<StateOfMatter> STATE_OF_MATTER = register("state_of_matter", StateOfMatter.CODEC, StateOfMatter.LIQUID, Tooltips::stateOfMatter, true);
  public static final FluidDataType<Boolean> IGNORED_BY_SIPHON = register("ignored_by_siphon", Codec.BOOL, false, Tooltips::ignoredBySiphon, true);
  public static final FluidDataType<Boolean> BREATHABLE = register("breathable", Codec.BOOL, false, Tooltips::breathable, true);
  public static final FluidDataType<Boolean> VISCOUS = register("viscous", Codec.BOOL, false, Tooltips::viscous, true);
  public static final FluidDataType<Boolean> DELICIOUS = register("delicious", Codec.BOOL, false, Tooltips::delicious, true);
  public static final FluidDataType<Boolean> ANTIMATTER = register("antimatter", Codec.BOOL, false, Tooltips::antimatter);


  private static <T> @NotNull FluidDataType<T> register(String name, Codec<T> codec, @Nullable T defaultValue, @Nullable FluidDataType.TooltipProvider<T> tooltip){
    return register(name, codec, defaultValue, tooltip, false);
  }
  private static <T> @NotNull FluidDataType<T> register(String name, Codec<T> codec, @Nullable T defaultValue, @Nullable FluidDataType.TooltipProvider<T> tooltip, boolean hasExtraInfo){
    return new FluidDataType<>(NTM.id(name), codec, defaultValue, tooltip, hasExtraInfo).register();
  }

  private static class Tooltips{
    private static void temperature(Double celsius, boolean showExtraInfo, Consumer<Text> tooltip){
      Formatting formatting = Formatting.RED;
      if(celsius < 0){
        formatting = Formatting.BLUE;
      }

      switch (NTMConfig.TempUnit.getValue()){
        case "Celsius" -> tooltip.accept(
          Text.literal(String.format("%,.1f", celsius)).append(Text.translatable("generic.ntm.temp.c")).formatted(formatting)
        );
        case "Fahrenheit" -> tooltip.accept(
          Text.literal(String.format("%,.1f", (celsius * 9 / 5) + 32)).append(Text.translatable("generic.ntm.temp.f")).formatted(formatting)
        );
        case "Kelvin" -> tooltip.accept(
          Text.literal(String.format("%,.1f", celsius - 273.15)).append(Text.translatable("generic.ntm.temp.k")).formatted(formatting)
        );
      }
    }

    // Helper
    private static Text thermalCapacity(Double tuPerDroplet){
      return switch (NTMConfig.FluidUnit.getValue()) {
        case "MilliBuckets" -> Text.translatable("fluid_tooltip.ntm.thermal_capacity", FluidUnit.dropletsToMB(tuPerDroplet), Text.translatable("generic.ntm.fluid.mb")).formatted(Formatting.RED);
        case "Droplets" -> Text.translatable("fluid_tooltip.ntm.thermal_capacity", tuPerDroplet, Text.translatable("generic.ntm.fluid.droplets")).formatted(Formatting.RED);
        default -> Text.empty();
      };
    }

    // Helper
    private static Text efficiency(Double multiplier){
      return Text.translatable("fluid_tooltip.ntm.efficiency", String.format("%1$.0f", multiplier * 100)).formatted(Formatting.AQUA);
    }

    private static void boilable(HeatingData data, boolean showExtraInfo, Consumer<Text> tooltip) {
      if(!showExtraInfo) return;
      tooltip.accept(thermalCapacity(data.tuPerDroplet()));
      if(data.isBoilable()){
        tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.boilable", efficiency(data.boilingMultiplier())).formatted(Formatting.YELLOW)
        );
      }
      if(data.isHeatable()){
        tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.heatable", efficiency(data.heatingMultiplier())).formatted(Formatting.YELLOW)
        );
      }
      if(data.isPwrCoolant()){
        tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.pwr_coolant", efficiency(data.pwrCoolantMultiplier())).formatted(Formatting.YELLOW)
        );
      }
      if(data.isIcfCoolant()){
        tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.icf_coolant", efficiency(data.icfCoolantMultiplier())).formatted(Formatting.YELLOW)
        );
      }
      if(data.isParticleAcceleratorCoolant()){
        tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.particle_accelerator_coolant", efficiency(data.particleAcceleratorCoolantMultiplier())).formatted(Formatting.YELLOW)
        );
      }
    }

    private static void coolable(CoolingData data, boolean showExtraInfo, Consumer<Text> tooltip) {
      if(!showExtraInfo) return;
      tooltip.accept(thermalCapacity(data.tuPerDroplet()));
      if(data.isTurbineable()){
        tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.turbine_steam", efficiency(data.turbineMultiplier())).formatted(Formatting.YELLOW)
        );
      }
      if(data.isCoolable()){
        tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.coolable", efficiency(data.coolingMultiplier())).formatted(Formatting.YELLOW)
        );
      }
    }

    private static void pwrFluxMultiplier(Double multiplier, boolean showExtraInfo, Consumer<Text> tooltip) {
      if(multiplier < 0.001 && multiplier > -0.001) return; // No Multipliers under 1%
      tooltip.accept(Text.translatable("fluid_tooltip.ntm.pwr_flux_multiplier").formatted(Formatting.BLUE));

      if(!showExtraInfo) return;
      if(multiplier < 0){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.pwr_flux_multiplier.val", String.format("%1$.0f", multiplier * 100)).formatted(Formatting.BLUE));
      }else {
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.pwr_flux_multiplier.val", String.format("+%1$.0f", multiplier * 100)).formatted(Formatting.BLUE));
      }
    }

    private static void flammable(Double tuPerDroplet, boolean showExtraInfo, Consumer<Text> tooltip) {
      if (tuPerDroplet <= 0) return;
      tooltip.accept(Text.translatable("fluid_tooltip.ntm.flammable").formatted(Formatting.YELLOW));
      switch (NTMConfig.FluidUnit.getValue()) {
        case "MilliBuckets" -> tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.provides", TextUtil.unit(FluidUnit.dropletsToMB(tuPerDroplet)), Text.translatable("generic.ntm.fluid.mb")).formatted(Formatting.YELLOW)
        );
        case "Droplets" -> tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.provides", TextUtil.unit(tuPerDroplet), Text.translatable("generic.ntm.fluid.droplet")).formatted(Formatting.YELLOW)
        );
      }
    }

    private static void combustible(Combustible data, boolean showExtraInfo, Consumer<Text> tooltip) {
      if (!data.isCombustible()) return;
      tooltip.accept(Text.translatable("fluid_tooltip.ntm.combustible"));
      switch (NTMConfig.FluidUnit.getValue()) {
        case "MilliBuckets" -> tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.provides",
            TextUtil.unit(FluidUnit.dropletsToMB(data.ntePerDroplet()), "generic.ntm.delta_kelvin"),
            Text.translatable("generic.ntm.fluid.mb")
          ).formatted(Formatting.GOLD)
        );
        case "Droplets" -> tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.provides",
            TextUtil.unit(data.ntePerDroplet(), "generic.ntm.delta_kelvin").formatted(Formatting.RED),
            Text.translatable("generic.ntm.fluid.droplets")
          ).formatted(Formatting.GOLD)
        );
      }
      tooltip.accept(Text.translatable("fluid_tooltip.ntm.combustible.fuel_grade", data.fuelGrade().NAME).formatted(Formatting.GOLD));
    }

    private static void polluting(Polluting data, boolean showExtraInfo, Consumer<Text> tooltip) {
      if (!data.isPolluting()) return;
      tooltip.accept(Text.translatable("fluid_tooltip.ntm.polluting"));

      if(!showExtraInfo) return;
      if(!data.whenSpilled().isEmpty()){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.polluting.spilled").formatted(Formatting.GREEN));
        for(PollutionData spilled : data.whenSpilled()){
          tooltip.accept(spilled.getTooltip().formatted(Formatting.GREEN));
        }
      }
      if(!data.whenBurned().isEmpty()){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.polluting.burned").formatted(Formatting.RED));
        for(PollutionData spilled : data.whenBurned()){
          tooltip.accept(spilled.getTooltip().formatted(Formatting.RED));
        }
      }
    }

    private static void radioactive(Boolean isRadioactive, boolean showExtraInfo, Consumer<Text> tooltip){
      if(isRadioactive){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.radioactive").formatted(Formatting.YELLOW));
      }
    }

    private static void toxicFumes(Boolean isModifiedPheromone, boolean showExtraInfo, Consumer<Text> tooltip){
      if(showExtraInfo && isModifiedPheromone){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.toxic_fumes").formatted(Formatting.GREEN));
      }
    }

    private static void toxin(ToxinData data, boolean showExtraInfo, Consumer<Text> tooltip) {
      if (!(showExtraInfo && data.isToxic())) return;
      tooltip.accept(Text.translatable("fluid_tooltip.ntm.toxin").formatted(Formatting.LIGHT_PURPLE));
      tooltip.accept(Text.translatable("fluid_tooltip.ntm.toxin.type", data.type().NAME).formatted(Formatting.YELLOW));
      if(data.damagePerSec() > 0){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.toxin.dps", data.damagePerSec()).formatted(Formatting.YELLOW));
      }
      if(!data.effects().isEmpty()){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.toxin.effects").formatted(Formatting.YELLOW));
      }
      for(StatusEffectInstance effect : data.effects()) {
        tooltip.accept(
          Text.literal(" - ")
            .append(Text.translatable(effect.getTranslationKey()))
            .append(" ")
            .append(Text.translatable("potion.potency." + effect.getAmplifier()))
            .append(String.format(" %1$d:%2$d", (effect.getDuration() / 20) / 60, (effect.getDuration() / 20) % 60))
            .formatted(Formatting.YELLOW)
        );
      }
    }

    private static void glyphidPheromones(Boolean isGlyphidPheromone, boolean showExtraInfo, Consumer<Text> tooltip){
      if(isGlyphidPheromone){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.glyphid_pheromones").formatted(Formatting.AQUA));
      }
    }

    private static void modifiedPheromones(Boolean isModifiedPheromone, boolean showExtraInfo, Consumer<Text> tooltip){
      if(isModifiedPheromone){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.modified_pheromones").formatted(Formatting.BLUE));
      }
    }

    private static void gaseousAtRoomTemperature(Boolean isModifiedPheromone, boolean showExtraInfo, Consumer<Text> tooltip){
      if(showExtraInfo && isModifiedPheromone){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.gaseous_at_room_temperature").formatted(Formatting.BLUE));
      }
    }

    private static void stateOfMatter(StateOfMatter state, boolean showExtraInfo, Consumer<Text> tooltip){
      if(showExtraInfo){
        tooltip.accept(state.TOOLTIP);
      }
    }

    private static void ignoredBySiphon(Boolean isIgnored, boolean showExtraInfo, Consumer<Text> tooltip){
      if(showExtraInfo && isIgnored){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.ignored_by_siphon").formatted(Formatting.BLUE));
      }
    }

    private static void breathable(Boolean isViscous, boolean showExtraInfo, Consumer<Text> tooltip){
      if(showExtraInfo && isViscous){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.breathable").formatted(Formatting.AQUA));
      }
    }

    private static void viscous(Boolean isViscous, boolean showExtraInfo, Consumer<Text> tooltip){
      if(showExtraInfo && isViscous){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.viscous").formatted(Formatting.BLUE));
      }
    }

    private static void delicious(Boolean isDelicious, boolean showExtraInfo, Consumer<Text> tooltip){
      if(showExtraInfo && isDelicious){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.delicious").formatted(Formatting.DARK_GREEN));
      }
    }

    private static void antimatter(Boolean isAntimatter, boolean showExtraInfo, Consumer<Text> tooltip){
      if(isAntimatter){
        tooltip.accept(Text.translatable("fluid_tooltip.ntm.antimatter").formatted(Formatting.DARK_RED));
      }
    }
  }
}
