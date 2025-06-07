package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.ConfigFile;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class ListOption<T> extends Option<List<T>> {
  private final Function<T, Boolean> ENTRY_VALIDATOR;
  private final Function<List<T>, Boolean> LIST_VALIDATOR;
  
  
  /**
   * @param name Name of the Option
   * @param defaultValue the Value that the Option will default to
   * @param comment Optional Comment (use "null" for no Comment)
   * @param listValidator Function for additional Validation of the List (like: list.size() < 100)
   * @param entryValidator Function for additional Validation of all Values (like: String.endsWith("abc"))
   */
  public ListOption(ConfigFile parent, String name, List<T> defaultValue, @Nullable String comment, Function<List<T>, Boolean> listValidator, Function<T, Boolean> entryValidator) {
    super(parent, name, new ArrayList<>(defaultValue), comment, null);
    this.ENTRY_VALIDATOR = entryValidator;
    this.LIST_VALIDATOR = listValidator;
    
    if(isInvalidValue(defaultValue)){
      throw new IllegalArgumentException("Default Value is not valid you idiot");
    }
  }
  
  @Override
  public boolean isInvalidValue(List<T> listValue) {
    // fix super constructor
    if(this.LIST_VALIDATOR == null) return false;
    
    for(T entry: listValue){
      if(!IsEntryValid(entry)) return true;
    }
    return !this.LIST_VALIDATOR.apply(listValue);
  }
  
  public boolean IsEntryValid(T entry){
    return ENTRY_VALIDATOR.apply(entry);
  }
}
