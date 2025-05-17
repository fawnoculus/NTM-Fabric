package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.ConfigFile;
import net.fawnoculus.ntm.util.config.Option;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class DoubleOption extends Option<Double> {
  public DoubleOption(ConfigFile parent, String name, Double defaultValue, @Nullable String comment, Function<Double, Boolean> validator) {
    super(parent, name, defaultValue, comment, validator);
  }
}
