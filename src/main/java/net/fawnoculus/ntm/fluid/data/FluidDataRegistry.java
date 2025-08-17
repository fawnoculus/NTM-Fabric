package net.fawnoculus.ntm.fluid.data;

import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Optional;

/**
 * All Data of Fluids that doesn't change is stored as FluidData, serialized & send to clients when joining
 */
public class FluidDataRegistry {
  private static final HashMap<Identifier, FluidDataType<?>> DATA_TYPES = new HashMap<>();
  private static final HashMap<Identifier, FluidDataContainer> FLUID_DATA = new HashMap<>();

  public static void registerDataType(FluidDataType<?> type){
    DATA_TYPES.put(type.identifier(), type);
  }

  public static FluidDataType<?> getDataType(@NotNull Identifier id){
    return DATA_TYPES.get(id);
  }

  public static @NotNull FluidDataContainer getOrCreate(Fluid fluid){
    return getOrCreate(Registries.FLUID.getId(fluid));
  }
  public static @NotNull FluidDataContainer getOrCreate(Identifier fluidID){
    return FLUID_DATA.computeIfAbsent(fluidID, k -> new FluidDataContainer());
  }

  /**
   * Encodes all FluidNetworkType Data for Synchronisation with the Client FluidNetworkType Data Registry
   * @return NbtCompound containing all FluidData
   */
  public static @NotNull NbtCompound encodeAllFluidData(){
    NbtCompound registryNBT = new NbtCompound();

    for(Identifier fluidID : FLUID_DATA.keySet()){
      registryNBT.put(fluidID.toString(), FluidDataContainer.encode(getOrCreate(fluidID)));
    }

    return registryNBT;
  }

  public static class FluidDataContainer {
    private final HashMap<Identifier, Object> DATA = new HashMap<>();

    public <T> FluidDataContainer set(@NotNull FluidDataType<T> type, T value){
      DATA.put(type.identifier(), value);
      return this;
    }

    public <T> Optional<T> get(@NotNull FluidDataType<T> type){
      try{
        return Optional.ofNullable(
          cast(DATA.get(type.identifier()))
        );
      }catch (ClassCastException cce){
        return Optional.empty();
      }
    }
    public <T> T getOrDefault(@NotNull FluidDataType<T> type){
      return get(type).orElse(type.defaultValue());
    }

    public static @NotNull NbtCompound encode(@NotNull FluidDataContainer container){
      NbtCompound nbt = new NbtCompound();

      for(Identifier typeID : container.DATA.keySet()) {
        FluidDataType<?> type = FluidDataRegistry.getDataType(typeID);
        Object value = container.DATA.get(typeID);
        try {
          putInNBT(type, nbt, value);
        }catch (ClassCastException | NullPointerException ignored){}
      }

      return nbt;
    }

    private static <T> void putInNBT(@NotNull FluidDataType<T> type, NbtCompound nbt, Object value) throws ClassCastException{
      type.encode(nbt, cast(value));
    }

    @SuppressWarnings("unchecked")
    private static <T> T cast(Object value) throws ClassCastException{
      return (T) value;
    }
  }
}
