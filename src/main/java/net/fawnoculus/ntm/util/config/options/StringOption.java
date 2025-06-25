package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.ConfigFile;
import org.jetbrains.annotations.Nullable;



public class StringOption extends Option<String> {
  
  public StringOption(ConfigFile parent, String name, String defaultValue, @Nullable String comment) {
    super(parent, name, defaultValue, comment);
  }
  
  @Override
  boolean additionalValidation(String value) {
    return switch (this.ExtraType){
      case ExtraType.BlockOption blockOption -> blockOption.isValid(value);
      case ExtraType.ItemOption itemOption -> itemOption.isValid(value);
      case Option.ExtraType.AllowedValues item -> item.isValid(value);
      case Option.ExtraType.Generic ignored -> true;
      default -> false;
    };
  }
}
