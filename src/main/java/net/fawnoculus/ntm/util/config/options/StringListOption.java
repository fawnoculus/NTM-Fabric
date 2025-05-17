package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.Option;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class StringListOption extends Option<List<String>> {
  public StringListOption(String name, List<String> defaultValue, @Nullable String comment, Function<List<String>, Boolean> validator) {
    super(name, defaultValue, comment, validator);
  }
}
