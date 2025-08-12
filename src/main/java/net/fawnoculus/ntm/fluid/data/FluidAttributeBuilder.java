package net.fawnoculus.ntm.fluid.data;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributeHandler;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.minecraft.fluid.Fluid;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FluidAttributeBuilder {
  public static FluidAttributeBuilder create(){
    return new FluidAttributeBuilder();
  }

  private @Nullable Function<FluidVariant, Text> name = null;
  private @Nullable Function<FluidVariant, Optional<SoundEvent>> fillSound = null;
  private @Nullable Function<FluidVariant, Optional<SoundEvent>> emptySound = null;
  private @Nullable Function<FluidVariant, Integer> luminance = null;
  private @Nullable Function<FluidVariant, Integer> temperature = null;
  private @Nullable BiFunction<FluidVariant, @Nullable World, Integer> viscosity = null;
  private @Nullable Function<FluidVariant, Boolean> isLighterThanAir = null;

  public FluidAttributeBuilder name(@Nullable Function<FluidVariant, Text> name) {
    this.name = name;
    return this;
  }
  public FluidAttributeBuilder name(@NotNull Text name) {
    this.name = (fluidVariant) -> name;
    return this;
  }

  public FluidAttributeBuilder fillSound(@Nullable Function<FluidVariant, Optional<SoundEvent>> fillSound) {
    this.fillSound = fillSound;
    return this;
  }
  public FluidAttributeBuilder fillSound(@Nullable SoundEvent fillSound) {
    this.fillSound = (fluidVariant) -> Optional.ofNullable(fillSound);
    return this;
  }

  public FluidAttributeBuilder emptySound(@Nullable Function<FluidVariant, Optional<SoundEvent>> emptySound) {
    this.emptySound = emptySound;
    return this;
  }
  public FluidAttributeBuilder emptySound(@Nullable SoundEvent emptySound) {
    this.emptySound = (fluidVariant) -> Optional.ofNullable(emptySound);
    return this;
  }

  public FluidAttributeBuilder luminance(@Nullable Function<FluidVariant, Integer> luminance) {
    this.luminance = luminance;
    return this;
  }
  public FluidAttributeBuilder luminance(@NotNull Integer luminance) {
    this.luminance = (fluidVariant) -> luminance;
    return this;
  }

  public FluidAttributeBuilder temperature(@Nullable Function<FluidVariant, Integer> temperature) {
    this.temperature = temperature;
    return this;
  }
  public FluidAttributeBuilder temperature(@NotNull Integer kelvin) {
    this.temperature = (fluidVariant) -> kelvin;
    return this;
  }
  public FluidAttributeBuilder temperatureCelsius(@NotNull Integer celsius) {
    this.temperature = (fluidVariant) -> (int) (celsius - 273.15);
    return this;
  }
  public FluidAttributeBuilder temperatureFahrenheit(@NotNull Integer fahrenheit) {
    return this.temperatureCelsius((int) ((fahrenheit - 32.0) / 1.8));
  }

  public FluidAttributeBuilder viscosity(@Nullable BiFunction<FluidVariant, @Nullable World, Integer> viscosity) {
    this.viscosity = viscosity;
    return this;
  }
  public FluidAttributeBuilder viscosity(@NotNull Integer viscosity) {
    this.viscosity = (fluidVariant, world) -> viscosity;
    return this;
  }

  public FluidAttributeBuilder isLighterThanAir(@Nullable Function<FluidVariant, Boolean> isLighterThanAir) {
    this.isLighterThanAir = isLighterThanAir;
    return this;
  }
  public FluidAttributeBuilder isLighterThanAir(@NotNull Boolean isLighterThanAir) {
    this.isLighterThanAir = (fluidVariant) -> isLighterThanAir;
    return this;
  }

  public FluidVariantAttributeHandler build() {
    return new FluidVariantAttributeHandler() {
      @Override
      public Text getName(FluidVariant fluidVariant) {
        if (name == null) {
          return FluidVariantAttributeHandler.super.getName(fluidVariant);
        }
        return name.apply(fluidVariant);
      }

      @Override
      public Optional<SoundEvent> getFillSound(FluidVariant variant) {
        if (fillSound == null) {
          return FluidVariantAttributeHandler.super.getFillSound(variant);
        }
        return fillSound.apply(variant);
      }

      @Override
      public Optional<SoundEvent> getEmptySound(FluidVariant variant) {
        if (emptySound == null) {
          return FluidVariantAttributeHandler.super.getEmptySound(variant);
        }
        return emptySound.apply(variant);
      }

      @Override
      public int getLuminance(FluidVariant variant) {
        if (luminance == null) {
          return FluidVariantAttributeHandler.super.getLuminance(variant);
        }
        return luminance.apply(variant);
      }

      @Override
      public int getTemperature(FluidVariant variant) {
        if (temperature == null) {
          return FluidVariantAttributeHandler.super.getTemperature(variant);
        }
        return temperature.apply(variant);
      }

      @Override
      public int getViscosity(FluidVariant variant, @Nullable World world) {
        if (viscosity == null) {
          return FluidVariantAttributeHandler.super.getViscosity(variant, world);
        }
        return viscosity.apply(variant, world);
      }

      @Override
      public boolean isLighterThanAir(FluidVariant variant) {
        if (isLighterThanAir == null) {
          return FluidVariantAttributeHandler.super.isLighterThanAir(variant);
        }
        return isLighterThanAir.apply(variant);
      }
    };
  }

  public void register(Fluid fluid){
    FluidVariantAttributes.register(fluid, this.build());
  }
}
