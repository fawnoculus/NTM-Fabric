package net.fawnoculus.ntm.util.config.options;

import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class DoubleOption extends Option<Double>{
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param validator    Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  DoubleOption(String name, Double defaultValue, @Nullable String comment, Function<Double, Boolean> validator) {
    super(name, defaultValue, comment, validator);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param min          Minimum allowed Value
   * @param max          Maximum allowed Value
   */
  DoubleOption(String name, Double defaultValue, @Nullable String comment, Double min, Double max) {
    super(name, defaultValue, comment, value -> value >= min && value <= max);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   */
  DoubleOption(String name, Double defaultValue, @Nullable String comment) {
    this(name, defaultValue, comment, value -> true);
  }
}
