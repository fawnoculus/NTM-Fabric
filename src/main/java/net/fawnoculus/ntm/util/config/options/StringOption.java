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
      case Option.ExtraType.Block block -> block.isValid(value);
      case Option.ExtraType.Item item -> item.isValid(value);
      case Option.ExtraType.AllowedValues item -> item.isValid(value);
      case Option.ExtraType.Generic ignored -> true;
      default -> false;
    };
  }
}
