package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.Option;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class BooleanOption extends Option<Boolean> {
  public BooleanOption(String name, Boolean defaultValue, @Nullable String comment, Function<Boolean, Boolean> validator) {
    super(name, defaultValue, comment, validator);
  }
}
