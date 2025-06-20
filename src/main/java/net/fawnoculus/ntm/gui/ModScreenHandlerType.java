package net.fawnoculus.ntm.gui;


import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.network.custom.BlockPosS2CPayload;
import net.fawnoculus.ntm.gui.handlers.AlloyFurnaceScreenHandler;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlerType {
  
  public static final ScreenHandlerType<AlloyFurnaceScreenHandler> ALLOY_FURNACE = register("alloy_furnace", AlloyFurnaceScreenHandler::new, BlockPosS2CPayload.PACKET_CODEC);
  
  
  public static <T extends ScreenHandler, D extends CustomPayload>ExtendedScreenHandlerType<T, D>
  register(String name, ExtendedScreenHandlerType.ExtendedFactory<T, D> screenFactory, PacketCodec<? super RegistryByteBuf, D> packetCodec) {
    return Registry.register(Registries.SCREEN_HANDLER, NTM.id(name), new ExtendedScreenHandlerType<>(screenFactory, packetCodec));
  }
  
  public static void initialize() {}
}
