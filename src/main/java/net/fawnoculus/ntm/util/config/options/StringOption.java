package net.fawnoculus.ntm.util.config.options;

import net.fawnoculus.ntm.util.config.ConfigFile;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;



public class StringOption extends Option<String> {
  public final Type TYPE;
  
  public StringOption(ConfigFile parent, String name, String defaultValue, @Nullable String comment, Function<String, Boolean> validator) {
    super(parent, name, defaultValue, comment, validator);
    this.TYPE = Type.GENERIC;
  }
  
  public StringOption(ConfigFile parent, String name, String defaultValue, @Nullable String comment, Type type) {
    super(parent, name, defaultValue, comment, type.VALIDATOR);
    this.TYPE = type;
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
    
    public final Function<String, Boolean> VALIDATOR;
    
    Type(Function<String, Boolean> validator){
      this.VALIDATOR = validator;
    }
  }
}
