package net.fawnoculus.ntm.util.config.options;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class StringListOption extends Option<List<String>>{
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param validator    Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  StringListOption(String name, List<String> defaultValue, @Nullable String comment, Function<List<String>, Boolean> validator) {
    super(name, defaultValue, comment, validator);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   */
  StringListOption(String name, List<String> defaultValue, @Nullable String comment) {
    this(name, defaultValue, comment, value -> true);
  }
}
