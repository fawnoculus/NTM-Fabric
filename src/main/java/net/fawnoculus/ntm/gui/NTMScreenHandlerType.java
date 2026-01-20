package net.fawnoculus.ntm.gui;


import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.gui.handlers.AlloyFurnaceScreenHandler;
import net.fawnoculus.ntm.gui.handlers.ElectricFurnaceScreenHandler;
import net.fawnoculus.ntm.gui.handlers.EnergyStorageScreenHandler;
import net.fawnoculus.ntm.network.s2c.BlockPosPayload;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.NotNull;

public class NTMScreenHandlerType {
    public static <T extends AbstractContainerMenu, D extends CustomPacketPayload> ExtendedScreenHandlerType<@NotNull T, @NotNull D>
    register(String name, ExtendedScreenHandlerType.ExtendedFactory<@NotNull T, @NotNull D> screenFactory, StreamCodec<? super RegistryFriendlyByteBuf, D> packetCodec) {
        return Registry.register(BuiltInRegistries.MENU, NTM.id(name), new ExtendedScreenHandlerType<>(screenFactory, packetCodec));
    }

    public static void initialize() {
    }

    public static final MenuType<AlloyFurnaceScreenHandler> ALLOY_FURNACE = register("alloy_furnace", AlloyFurnaceScreenHandler::new, BlockPosPayload.PACKET_CODEC);


    public static final MenuType<ElectricFurnaceScreenHandler> ELECTRIC_FURNACE = register("electric_furnace", ElectricFurnaceScreenHandler::new, BlockPosPayload.PACKET_CODEC);
    public static final MenuType<EnergyStorageScreenHandler> ENERGY_STORAGE = register("energy_storage", EnergyStorageScreenHandler::new, BlockPosPayload.PACKET_CODEC);


}
