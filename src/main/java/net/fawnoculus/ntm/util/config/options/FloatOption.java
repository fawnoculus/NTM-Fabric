package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.ConfigFile;
import org.jetbrains.annotations.Nullable;

public class FloatOption extends Option<Float> {
  public FloatOption(ConfigFile parent, String name, Float defaultValue, @Nullable String comment) {
    super(parent, name, defaultValue, comment);
  }

  @Override
  boolean additionalValidation(Float value) {
    return switch (this.ExtraType) {
      case Option.ExtraType.IntRange intRange -> intRange.isValid(value);
      case Option.ExtraType.FloatRange floatRange -> floatRange.isValid(value);
      case Option.ExtraType.Generic ignored -> true;
      default -> false;
    };
  }
}
