package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.Option;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class StringOption extends Option<String> {
  public StringOption(String name, String defaultValue, @Nullable String comment, Function<String, Boolean> validator) {
    super(name, defaultValue, comment, validator);
  }
}
