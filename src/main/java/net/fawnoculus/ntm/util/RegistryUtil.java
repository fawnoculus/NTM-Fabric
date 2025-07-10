package net.fawnoculus.ntm.util;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class RegistryUtil {
  public static <T> Optional<RegistryEntry<T>> getEntry(@NotNull RegistryKey<T> key) {
    Optional<Registry<T>> optionalRegistry = getRegistry(key.getRegistryRef());
    if(optionalRegistry.isEmpty()){
      return Optional.empty();
    }
    Registry<T> registry = optionalRegistry.get();
    T value = registry.get(key);
    if(value == null
        || (registry.getDefaultEntry().isPresent() && value == registry.getDefaultEntry().get().value())
    ){
      return Optional.empty();
    }
    return Optional.ofNullable(registry.getEntry(value));
  }
  
  @SuppressWarnings("unchecked")
  public static <T> Optional<Registry<T>> getRegistry(@NotNull RegistryKey<Registry<T>> key){
    try{
      return Optional.ofNullable((Registry<T>) Registries.REGISTRIES.get(key.getValue()));
    }catch (Throwable e){
      return Optional.empty();
    }
  }
}
