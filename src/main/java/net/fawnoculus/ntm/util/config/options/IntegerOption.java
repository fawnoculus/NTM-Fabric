package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.ConfigFile;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class IntegerOption extends Option<Integer> {
  public IntegerOption(ConfigFile parent, String name, Integer defaultValue, @Nullable String comment, Function<Integer, Boolean> validator) {
    super(parent, name, defaultValue, comment, validator);
  }
}
