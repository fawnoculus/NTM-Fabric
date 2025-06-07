package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.ConfigFile;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class StringListOption extends ListOption<String> {
  public StringListOption(ConfigFile parent, String name, List<String> defaultValue, @Nullable String comment, Function<List<String>, Boolean> listValidator, Function<String, Boolean> entryValidator) {
    super(parent, name, defaultValue, comment, listValidator, entryValidator);
  }
  public StringListOption(ConfigFile parent, String name, List<String> defaultValue, @Nullable String comment, Type type) {
    super(parent, name, defaultValue, comment, list -> true, type.ENTRY_VALIDATOR);
  }
  
  public enum Type {
    GENERIC(string -> true),
    ITEM(string -> {
      if(Registries.ITEM.getDefaultEntry().isEmpty()) throw new IllegalStateException("WTF why does Registries.ITEM not have a default Value??????");
      return Registries.ITEM.get(Identifier.of(string)) != Registries.ITEM.getDefaultEntry().get().value();
    }),
    BLOCK(string -> {
      if(Registries.BLOCK.getDefaultEntry().isEmpty()) throw new IllegalStateException("WTF why does Registries.BLOCK not have a default Value??????");
      return Registries.BLOCK.get(Identifier.of(string)) != Registries.BLOCK.getDefaultEntry().get().value();
    });
    
    public final Function<String, Boolean> ENTRY_VALIDATOR;
    
    Type(Function<String, Boolean> entryValidator){
      this.ENTRY_VALIDATOR = entryValidator;
    }
  }
}
