package net.fawnoculus.ntm.client.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.loader.api.Version;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.client.NTMClient;
import net.fawnoculus.ntm.network.s2c.NTMVersionPayload;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientHandshakePacketListenerImpl;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;

public class ClientReceivedVersionHandler {
    public static final Version clientVersion = NTM.MOD_VERSION;
    public static boolean hasReceivedVersion = false;
    public static Version serverVersion = null;

    public static void handlePacket(NTMVersionPayload payload, ClientPlayNetworking.Context ignored) {
        hasReceivedVersion = true;
        serverVersion = payload.version();
    }

    public static void onJoin(ClientPacketListener ignored, ClientboundLoginPacket ignored2) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null) return;
        if (!hasReceivedVersion) {
            player.displayClientMessage(Component.translatable("message.ntm.version.not_installed1"), false);
            player.displayClientMessage(Component.translatable("message.ntm.version.not_installed2"), false);
            NTMClient.LOGGER.info("Connected Server doesn't of {} installed", NTM.MOD_NAME);
            return;
        }
        NTMClient.LOGGER.info("Connected Server has Version {} of {} installed", serverVersion.getFriendlyString(), NTM.MOD_NAME);
        if (!serverVersion.getFriendlyString().equals(clientVersion.getFriendlyString())) {
            NTMClient.LOGGER.warn("Version Mismatch, Client has Version {} of {}", clientVersion.getFriendlyString(), NTM.MOD_NAME);
            player.displayClientMessage(Component.translatable("message.ntm.version.mismatch1"), false);
            player.displayClientMessage(Component.translatable("message.ntm.version.mismatch2"), false);
            player.displayClientMessage(Component.translatable("message.ntm.version.server", serverVersion.getFriendlyString()), false);
            player.displayClientMessage(Component.translatable("message.ntm.version.client", clientVersion.getFriendlyString()), false);
        }
    }

    public static void onDisconnect(ClientHandshakePacketListenerImpl ignored, Minecraft ignored2) {
        hasReceivedVersion = false;
        serverVersion = null;
    }
}
