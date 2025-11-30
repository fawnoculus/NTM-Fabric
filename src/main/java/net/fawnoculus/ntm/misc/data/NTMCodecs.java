package net.fawnoculus.ntm.misc.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;

public class NTMCodecs {
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
