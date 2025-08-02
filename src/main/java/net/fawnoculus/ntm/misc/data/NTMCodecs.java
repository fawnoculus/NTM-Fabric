package net.fawnoculus.ntm.misc.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.fluid.Fluid;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
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
  public static <T extends Enum<T>> PacketCodec<RegistryByteBuf,T> getThrowingEnumCPacketCodec(Class<T> enumClass) {
    return new PacketCodec<RegistryByteBuf, T>() {
      @Override
      public T decode(RegistryByteBuf buf) {
        return T.valueOf(enumClass, buf.readString());
      }
      
      @Override
      public void encode(RegistryByteBuf buf, T value) {
        buf.writeString(value.name());
      }
    };
  }
  public static <T extends Enum<T>> PacketCodec<RegistryByteBuf,T> getNullableEnumCPacketCodec(Class<T> enumClass) {
    return new PacketCodec<RegistryByteBuf, T>() {
      @Override
      public T decode(RegistryByteBuf buf) {
        try {
          return T.valueOf(enumClass, buf.readString());
        }catch (Throwable throwable){
          return null;
        }
      }
      
      @Override
      public void encode(RegistryByteBuf buf, T value) {
        buf.writeString(value.name());
      }
    };
  }
}
