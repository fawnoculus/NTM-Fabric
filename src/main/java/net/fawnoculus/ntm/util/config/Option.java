package net.fawnoculus.ntm.util.config;

import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public abstract class Option<T> {
  public final String NAME;
  public final String COMMENT;
  public final T DEFAULT_VALUE;
  
  private final Function<T, Boolean> VALIDATOR;
  
  public  T value;
  
  /**
   * @param name Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment Optional Comment (use "null" for no Comment)
   * @param validator Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  public Option(String name, T defaultValue, @Nullable String comment, Function<T, Boolean> validator) {
    this.NAME = name;
    this.DEFAULT_VALUE = defaultValue;
    this.COMMENT = comment;
    this.VALIDATOR = validator;
  }
  
  /**
   * @return the current value of the option
   */
  public T getValue() {
    return this.value != null ? this.value : this.DEFAULT_VALUE;
  }
  
  public void setValue(T value) {
    if(!isValidValue(value)){
      return;
    }
  }
  
  public boolean isValidValue(T value) {
    return VALIDATOR.apply(value);
  }
}
