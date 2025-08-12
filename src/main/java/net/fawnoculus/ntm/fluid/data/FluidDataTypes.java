package net.fawnoculus.ntm.fluid.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.fluid.stack.FluidUnit;
import net.fawnoculus.ntm.misc.data.NTMCodecs;
import net.fawnoculus.ntm.util.TextUtil;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class FluidDataTypes {
  public static final FluidDataType<Double> TEMPERATURE = register("temperature", Codec.DOUBLE, 20.0, Tooltips::temperature);
  public static final FluidDataType<Long> FLAMMABLE = register("flammable", Codec.LONG, 0L, Tooltips::flammable);
  public static final FluidDataType<Combustible> COMBUSTIBLE = register("combustible", Combustible.CODEC, Combustible.DEFAULT, Tooltips::combustible);
  public static final FluidDataType<Polluting> POLLUTING = register("polluting", Polluting.CODEC, Polluting.DEFAULT, Tooltips::polluting);
  public static final FluidDataType<Boolean> RADIOACTIVE = register("radioactive", Codec.BOOL, false, Tooltips::radioactive);
  public static final FluidDataType<Boolean> TOXIC_FUMES = register("toxic_fumes", Codec.BOOL, false, Tooltips::toxicFumes);
  public static final FluidDataType<ToxinData> TOXIN = register("toxin", ToxinData.CODEC, ToxinData.DEFAULT, Tooltips::toxin);
  public static final FluidDataType<Boolean> GLYPHID_PHEROMONES = register("glyphid_pheromones", Codec.BOOL, false, Tooltips::glyphidPheromones);
  public static final FluidDataType<Boolean> MODIFIED_PHEROMONES = register("modified_pheromones", Codec.BOOL, false, Tooltips::modifiedPheromones);
  public static final FluidDataType<StateOfMatter> STATE_OF_MATTER = register("state_of_matter", StateOfMatter.CODEC, StateOfMatter.LIQUID, Tooltips::stateOfMatter);
  public static final FluidDataType<Boolean> BREATHABLE = register("breathable", Codec.BOOL, false, Tooltips::breathable);
  public static final FluidDataType<Boolean> VISCOUS = register("viscous", Codec.BOOL, false, Tooltips::viscous);
  public static final FluidDataType<Boolean> DELICIOUS = register("delicious", Codec.BOOL, false, Tooltips::delicious);
  public static final FluidDataType<Boolean> ANTIMATTER = register("antimatter", Codec.BOOL, false, Tooltips::antimatter);


  private static <T> @NotNull FluidDataType<T> register(String name, Codec<T> codec, @Nullable T defaultValue, @Nullable FluidDataType.TooltipProvider<T> tooltip){
    return new FluidDataType<>(NTM.id(name), codec, defaultValue, tooltip).register();
  }

  private static class Tooltips{
    private static void temperature(Double celsius, boolean showExtraInfo, Consumer<Text> tooltip){
      switch (NTMConfig.TempUnit.getValue()){
        case "Celsius" -> tooltip.accept(
          Text.literal(String.format("%,.0f", celsius)).append(Text.translatable("generic.ntm.temp.c")).formatted(Formatting.RED)
        );
        case "Fahrenheit" -> tooltip.accept(
          Text.literal(String.format("%,.0f", (celsius * 9 / 5) + 32)).append(Text.translatable("generic.ntm.temp.f")).formatted(Formatting.RED)
        );
        case "Kelvin" -> tooltip.accept(
          Text.literal(String.format("%,.0f", celsius - 273.15)).append(Text.translatable("generic.ntm.temp.k")).formatted(Formatting.RED)
        );
      }
    }

    private static void flammable(Long TuPerDroplet, boolean showExtraInfo, Consumer<Text> tooltip) {
      if (TuPerDroplet <= 0) return;
      tooltip.accept(Text.translatable("fluid_tooltip.ntm.flammable").formatted(Formatting.YELLOW));
      switch (NTMConfig.FluidUnit.getValue()) {
        case "MilliBuckets" -> tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.provides", FluidUnit.dropletsToMB(TuPerDroplet), Text.translatable("generic.ntm.fluid.mb")).formatted(Formatting.YELLOW)
        );
        case "Droplets" -> tooltip.accept(
          Text.translatable("fluid_tooltip.ntm.provides", TuPerDroplet, Text.translatable("generic.ntm.fluid.droplets")).formatted(Formatting.YELLOW)
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

    private static void stateOfMatter(StateOfMatter state, boolean showExtraInfo, Consumer<Text> tooltip){
      if(showExtraInfo){
        tooltip.accept(state.TOOLTIP);
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

  public record Combustible(@NotNull Boolean isCombustible, @NotNull Long ntePerDroplet, @NotNull FuelGrade fuelGrade) {
    public static final Combustible DEFAULT = new Combustible(false, 0L, FuelGrade.LOW);
    public static final Codec<Combustible> CODEC = RecordCodecBuilder.create(
      instance -> instance.group(
          Codec.BOOL.fieldOf("is_combustible").forGetter(Combustible::isCombustible),
          Codec.LONG.fieldOf("nte_per_droplet").forGetter(Combustible::ntePerDroplet),
          FuelGrade.CODEC.fieldOf("fuel_grade").forGetter(Combustible::fuelGrade)
        ).apply(instance, Combustible::new)
    );
  }

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

  public record Polluting(@NotNull Boolean isPolluting, @NotNull List<PollutionData> whenSpilled, @NotNull List<PollutionData> whenBurned){
    public static final Polluting DEFAULT = new Polluting(false, List.of(), List.of());
    public static final Codec<Polluting> CODEC = RecordCodecBuilder.create(
      instance -> instance.group(
        Codec.BOOL.fieldOf("is_polluting").forGetter(Polluting::isPolluting),
        Codec.list(PollutionData.CODEC).fieldOf("when_spilled").forGetter(Polluting::whenSpilled),
        Codec.list(PollutionData.CODEC).fieldOf("when_burned").forGetter(Polluting::whenBurned)
      ).apply(instance, Polluting::new)
    );

  }

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

  public record ToxinData(@NotNull Boolean isToxic, ToxinType type, float damagePerSec,  @NotNull Optional<Identifier> damageID, @NotNull List<StatusEffectInstance> effects){
    public static final ToxinData DEFAULT = new ToxinData(false, ToxinType.CHEMICAL_GAS,0, Optional.empty(), List.of());
    public static final Codec<ToxinData> CODEC = RecordCodecBuilder.create(
      instance -> instance.group(
        Codec.BOOL.fieldOf("is_toxic").forGetter(ToxinData::isToxic),
        ToxinType.CODEC.fieldOf("type").forGetter(ToxinData::type),
        Codec.FLOAT.fieldOf("dps").forGetter(ToxinData::damagePerSec),
        Codec.optionalField("damageID", Identifier.CODEC, false).forGetter(ToxinData::damageID),
        Codec.list(StatusEffectInstance.CODEC).fieldOf("effects").forGetter(ToxinData::effects)
      ).apply(instance, ToxinData::new)
    );

    public ToxinData(@NotNull Boolean isToxic, ToxinType type, float damagePerSec, Identifier damageID, @NotNull List<StatusEffectInstance> effects){
      this(isToxic, type, damagePerSec, Optional.ofNullable(damageID), effects);
    }

    public RegistryKey<DamageType> getDamageType(){
      return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, this.damageID().orElse(DamageTypes.GENERIC.getValue()));
    }
  }

  public enum ToxinType {
    AIRBORNE_PARTICLES(Text.translatable("fluid_tooltip.ntm.toxin_type.airborne_particles")),
    PARTICULATES(Text.translatable("fluid_tooltip.ntm.toxin_type.particulates")),
    CHEMICAL_GAS(Text.translatable("fluid_tooltip.ntm.toxin_type.chemical_gas")),
    CORROSIVE_FUMES(Text.translatable("fluid_tooltip.ntm.toxin_type.corrosive_fumes")),
    AEROSOLS(Text.translatable("fluid_tooltip.ntm.toxin_type.aerosols")),
    CARBON_MONOXIDE(Text.translatable("fluid_tooltip.ntm.toxin_type.carbon_monoxide"));

    public static final Codec<ToxinType> CODEC = NTMCodecs.getEnumCodec(ToxinType.class);
    public final Text NAME;

    ToxinType(Text name){
      this.NAME = name;
    }
  }

  public enum StateOfMatter{
    SOLID(Text.translatable("fluid_tooltip.ntm.state.solid").formatted(Formatting.BLUE)),
    LIQUID(Text.translatable("fluid_tooltip.ntm.state.liquid").formatted(Formatting.BLUE)),
    GASEOUS(Text.translatable("fluid_tooltip.ntm.state.gaseous").formatted(Formatting.BLUE)),
    PLASMA(Text.translatable("fluid_tooltip.ntm.state.plasma").formatted(Formatting.LIGHT_PURPLE));

    public static final Codec<StateOfMatter> CODEC = NTMCodecs.getEnumCodec(StateOfMatter.class);
    public final Text TOOLTIP;

    StateOfMatter(Text tooltip){
      this.TOOLTIP = tooltip;
    }
  }
}
