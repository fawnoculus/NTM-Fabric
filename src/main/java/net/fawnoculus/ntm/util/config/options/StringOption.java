package net.fawnoculus.ntm.util.config.options;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class StringOption extends Option<String>{
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param validator    Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  StringOption(String name, String defaultValue, @Nullable String comment, Function<String, Boolean> validator) {
    super(name, defaultValue, comment, validator);
  }
  /**
   * @param name          Name of the Option
   * @param defaultValue  the Value that the Option will default to
   * @param comment       Optional Comment (use "null" for no Comment)
   * @param allowedValues All Allowed Values
   */
  StringOption(String name, String defaultValue, @Nullable String comment, String... allowedValues) {
    super(name, defaultValue, comment, value -> List.of(allowedValues).contains(value));
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   */
  StringOption(String name, String defaultValue, @Nullable String comment) {
    this(name, defaultValue, comment, value -> true);
  }
}
