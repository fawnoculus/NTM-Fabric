package net.fawnoculus.ntm.util.config.options;

import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class IntegerOption extends Option<Integer>{
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param validator    Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  IntegerOption(String name, Integer defaultValue, @Nullable String comment, Function<Integer, Boolean> validator) {
    super(name, defaultValue, comment, validator);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param min          Minimum allowed Value
   * @param max          Maximum allowed Value
   */
  IntegerOption(String name, Integer defaultValue, @Nullable String comment, Integer min, Integer max) {
    super(name, defaultValue, comment, value -> value >= min && value <= max);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   */
  IntegerOption(String name, Integer defaultValue, @Nullable String comment) {
    this(name, defaultValue, comment, value -> true);
  }
}
