package net.fawnoculus.ntm.misc.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class NTMCodecs {
  public static final Codec<Fluid> FLUID_CODEC = Identifier.CODEC.comapFlatMap(identifier -> DataResult.success(Registries.FLUID.get(identifier)), Registries.FLUID::getId);
  public static <T extends Enum<T>> Codec<T> getEnumCodec(Class<T> enumClass) {
    return Codec.STRING.comapFlatMap(string -> {
          try {
            return DataResult.success(T.valueOf(enumClass, string));
          } catch (Throwable ignored) {
            return DataResult.error(() -> "Given String is not found in the Enum");
          }
        },
        Enum::name
    );
  }
}
