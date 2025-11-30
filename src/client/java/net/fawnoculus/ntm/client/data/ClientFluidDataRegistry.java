package net.fawnoculus.ntm.client.data;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.client.misc.NTMKeybinds;
import net.fawnoculus.ntm.fluid.data.FluidDataRegistry;
import net.fawnoculus.ntm.fluid.data.FluidDataType;
import net.fawnoculus.ntm.network.s2c.FluidDataRegistryPayload;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Receives a packed containing an NBT Serialized version on the Servers FluidNetworkType Data on Join
 */
public class ClientFluidDataRegistry {
    private static final HashMap<Identifier, ClientFluidDataContainer> CLIENT_FLUID_DATA = new HashMap<>();

    public static @NotNull ClientFluidDataContainer getOrCreate(Fluid fluid) {
        return getOrCreate(Registries.FLUID.getId(fluid));
    }

    public static @NotNull ClientFluidDataContainer getOrCreate(Identifier fluidID) {
        return CLIENT_FLUID_DATA.computeIfAbsent(fluidID, k -> new ClientFluidDataContainer(new HashMap<>()));
    }

    public static void updateFromPacket(FluidDataRegistryPayload payload, ClientPlayNetworking.Context ignored) {
        NbtCompound registryNBT = payload.registryNBT();
        for (String key : registryNBT.getKeys()) {
            try {
                Identifier fluidID = Objects.requireNonNull(Identifier.tryParse(key));
                NbtCompound fluidContainerNBT = registryNBT.getCompoundOrEmpty(key);
                ClientFluidDataContainer container = ClientFluidDataContainer.decode(fluidContainerNBT);
                CLIENT_FLUID_DATA.put(fluidID, container);
            } catch (Throwable ignored2) {
            }
        }
    }

    public record ClientFluidDataContainer(HashMap<Identifier, Object> DATA) {
        public static @NotNull ClientFluidDataContainer decode(@NotNull NbtCompound nbt) {
            final HashMap<Identifier, Object> data = new HashMap<>();

            for (String key : nbt.getKeys()) {
                try {
                    Identifier typeID = Objects.requireNonNull(Identifier.tryParse(key));
                    FluidDataType<?> type = FluidDataRegistry.getDataType(typeID);
                    putInContainer(type, data, type.decode(nbt));
                } catch (ClassCastException | NullPointerException ignored) {
                }
            }

            return new ClientFluidDataContainer(data);
        }

        private static <T> void getTooltip(FluidDataType<T> type, Object value, boolean showExtraInfo, Consumer<Text> tooltip) throws ClassCastException {
            type.appendTooltip(cast(value), showExtraInfo, tooltip);
        }

        private static <T> void putInContainer(FluidDataType<T> type, @NotNull HashMap<Identifier, Object> data, Object value) throws ClassCastException {
            data.put(type.identifier(), cast(value));
        }

        @SuppressWarnings("unchecked")
        private static <T> T cast(Object value) throws ClassCastException {
            return (T) value;
        }

        public void appendTooltip(boolean showExtraInfo, Consumer<Text> tooltip) {
            boolean hasExtraInfo = false;

            for (Identifier dataID : DATA.keySet()) {
                try {
                    FluidDataType<?> fluidDataType = FluidDataRegistry.getDataType(dataID);
                    if (fluidDataType.hasExtraInfo()) {
                        hasExtraInfo = true;
                    }
                    getTooltip(fluidDataType, getOrDefault(fluidDataType), showExtraInfo, tooltip);

                } catch (Throwable ignored) {
                }
            }

            if (hasExtraInfo && !showExtraInfo) {
                tooltip.accept(Text.translatable("tooltip.ntm.hold_for_info", NTMKeybinds.DISPLAY_EXTRA_INFO.getBoundKeyLocalizedText()));
            }
        }

        public <T> Optional<T> get(@NotNull FluidDataType<T> type) {
            try {
                return Optional.ofNullable(
                  cast(DATA.get(type.identifier()))
                );
            } catch (ClassCastException cce) {
                return Optional.empty();
            }
        }

        public <T> T getOrDefault(@NotNull FluidDataType<T> type) {
            return get(type).orElse(type.defaultValue());
        }
    }
}
