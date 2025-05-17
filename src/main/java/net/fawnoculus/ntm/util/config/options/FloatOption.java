package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.Option;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class FloatOption extends Option<Float> {
  public FloatOption(String name, Float defaultValue, @Nullable String comment, Function<Float, Boolean> validator) {
    super(name, defaultValue, comment, validator);
  }
}
