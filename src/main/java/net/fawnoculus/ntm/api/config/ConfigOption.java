package net.fawnoculus.ntm.api.config;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ConfigOption<T> {
  private final @NotNull String NAME;
  private final @Nullable String COMMENT;
  private final @NotNull Codec<T> CODEC;
  private final @NotNull T DEFAULT_VALUE;
  private @Nullable T currentValue = null;

  public ConfigOption(@NotNull String name, @NotNull Codec<T> codec, @NotNull T defaultValue, @Nullable String comment){
    this.NAME = name;
    this.CODEC = codec;
    this.DEFAULT_VALUE = defaultValue;
    this.COMMENT = comment;
  }

  public String getName(){
    return this.NAME;
  }

  public @NotNull T getDefaultValue(){
    return this.DEFAULT_VALUE;
  }

  public Codec<T> getCodec(){
    return this.CODEC;
  }

  /**
   * @return The value this option is currently set to, or the default one if no value was set
   */
  public @NotNull T getValue(){
    if(currentValue == null) {
      return this.DEFAULT_VALUE;
    }
    return this.currentValue;
  }

  /**
   * @param value the Value the option will be set to
   */
  public void setValue(T value){
    this.currentValue = value;
  }

  public @Nullable String getComment(){
    return this.COMMENT;
  }

  /**
   * @return if the Value was successfully set
   */
  public <U> boolean setValueFrom(U value, DynamicOps<U> ops){
    if(this.CODEC.decode(ops, value) instanceof DataResult.Success<Pair<T, U>> success){
      this.currentValue = success.value().getFirst();
      return true;
    }
    return false;
  }

  public <U> @Nullable U getEncodedValue(DynamicOps<U> ops){
    DataResult<U> result = this.CODEC.encodeStart(ops, this.getValue());
    if(result instanceof DataResult.Success<U> success){
      return success.value();
    }
    return null;
  }
}
