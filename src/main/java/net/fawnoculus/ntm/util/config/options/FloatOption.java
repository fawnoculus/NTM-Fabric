package net.fawnoculus.ntm.util.config.options;

import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class FloatOption extends Option<Float>{
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param validator    Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  FloatOption(String name, Float defaultValue, @Nullable String comment, Function<Float, Boolean> validator) {
    super(name, defaultValue, comment, validator);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   * @param min          Minimum allowed Value
   * @param max          Maximum allowed Value
   */
  FloatOption(String name, Float defaultValue, @Nullable String comment, Float min, Float max) {
    super(name, defaultValue, comment, value -> value >= min && value <= max);
  }
  /**
   * @param name         Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment      Optional Comment (use "null" for no Comment)
   */
  FloatOption(String name, Float defaultValue, @Nullable String comment) {
    this(name, defaultValue, comment, value -> true);
  }
}
