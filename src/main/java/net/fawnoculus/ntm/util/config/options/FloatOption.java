package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.ConfigFile;
import net.fawnoculus.ntm.util.config.Option;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class FloatOption extends Option<Float> {
  public FloatOption(ConfigFile parent, String name, Float defaultValue, @Nullable String comment, Function<Float, Boolean> validator) {
    super(parent, name, defaultValue, comment, validator);
  }
}
