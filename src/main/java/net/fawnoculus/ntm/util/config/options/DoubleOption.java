package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.Option;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class DoubleOption extends Option<Double> {
  public DoubleOption(String name, Double defaultValue, @Nullable String comment, Function<Double, Boolean> validator) {
    super(name, defaultValue, comment, validator);
  }
}
