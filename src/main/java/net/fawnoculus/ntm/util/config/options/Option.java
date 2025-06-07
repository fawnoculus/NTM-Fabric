package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.ConfigFile;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public abstract class Option<T> {
  public final String NAME;
  public final String COMMENT;
  public final T DEFAULT_VALUE;
  
  private final Function<T, Boolean> VALIDATOR;
  private final ConfigFile PARENT;
  
  public  T value;
  
  /**
   * @param name Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment Optional Comment (use "null" for no Comment)
   * @param validator Function for additional Validation (like: value > 10 && value < 100 or smth.)
   */
  public Option(ConfigFile parent, String name, T defaultValue, @Nullable String comment, Function<T, Boolean> validator) {
    this.PARENT = parent;
    this.NAME = name;
    this.DEFAULT_VALUE = defaultValue;
    this.COMMENT = comment;
    this.VALIDATOR = validator;
    
    if(isInvalidValue(defaultValue)){
      throw new IllegalArgumentException("Default Value is not valid you idiot");
    }
  }
  
  /**
   * @return the current value of the option
   */
  public T getValue() {
    return this.value != null ? this.value : this.DEFAULT_VALUE;
  }
  
  public void setValue(T value) {
    if(isInvalidValue(value)){
      return;
    }
    this.value = value;
  }
  
  public boolean isInvalidValue(T value) {
    assert VALIDATOR != null;
    assert PARENT != null;
    return !VALIDATOR.apply(value) || !PARENT.CONFIG_FILE_TYPE.isValidValue(value);
  }
}
