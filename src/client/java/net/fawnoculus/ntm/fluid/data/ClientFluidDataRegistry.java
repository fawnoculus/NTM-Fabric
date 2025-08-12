package net.fawnoculus.ntm.fluid.data;

import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

/**
 * Receives a packed containing an NBT Serialized version on the Servers Fluid Data on Join
 */
public class ClientFluidDataRegistry {
  private static final HashMap<Identifier, ClientFluidDataContainer> CLIENT_FLUID_DATA = new HashMap<>();

  public static @NotNull ClientFluidDataContainer getOrCreate(Fluid fluid){
    return getOrCreate(Registries.FLUID.getId(fluid));
  }

  public static @NotNull ClientFluidDataContainer getOrCreate(Identifier fluidID){
    return CLIENT_FLUID_DATA.computeIfAbsent(fluidID, k -> new ClientFluidDataContainer(new HashMap<>()));
  }

  public static void updateFromPacket(@NotNull NbtCompound registryNBT){
    for(String key : registryNBT.getKeys()){
      try {
        Identifier fluidID = Objects.requireNonNull(Identifier.tryParse(key));
        NbtCompound fluidContainerNBT = registryNBT.getCompoundOrEmpty(key);
        ClientFluidDataContainer container = ClientFluidDataContainer.decode(fluidContainerNBT);
        CLIENT_FLUID_DATA.put(fluidID, container);
      }catch (Throwable ignored){}
    }
  }

  public static class ClientFluidDataContainer {
    public ClientFluidDataContainer(HashMap<Identifier, Object> data){
      this.DATA = data;
    }

    private final HashMap<Identifier, Object> DATA;

    public <T> Optional<T> get(@NotNull FluidDataType<T> type){
      try{
        return Optional.ofNullable(
          cast(DATA.get(type.identifier()))
        );
      }catch (ClassCastException cce){
        return Optional.empty();
      }
    }

    public static @NotNull ClientFluidDataContainer decode(@NotNull NbtCompound nbt){
      final HashMap<Identifier, Object> data = new HashMap<>();

      for(String key : nbt.getKeys()){
        try{
          Identifier typeID = Objects.requireNonNull(Identifier.tryParse(key));
          FluidDataType<?> type = FluidDataRegistry.getDataType(typeID);
          putInContainer(type, data, type.decode(nbt));
        }catch (ClassCastException | NullPointerException ignored){}
      }

      return new ClientFluidDataContainer(data);
    }

    private static <T> void putInContainer(FluidDataType<T> type, @NotNull HashMap<Identifier, Object> data, Object value) throws ClassCastException{
      data.put(type.identifier(), cast(value));
    }

    @SuppressWarnings("unchecked")
    private static <T> T cast(Object value) throws ClassCastException{
      return (T) value;
    }
  }
}
