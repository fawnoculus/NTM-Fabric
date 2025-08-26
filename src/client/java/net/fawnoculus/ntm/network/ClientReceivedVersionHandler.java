package net.fawnoculus.ntm.network;

import net.fabricmc.loader.api.Version;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMClient;
import net.fawnoculus.ntm.network.s2c.NTMVersionPayload;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;

public class ClientReceivedVersionHandler {
  public static boolean hasReceivedVersion = false;

  public static Version serverVersion = null;
  public static final Version clientVersion = NTM.MOD_VERSION;

  public static void handlePacket(NTMVersionPayload payload) {
    hasReceivedVersion = true;
    serverVersion = payload.version();
  }

  public static void onJoin() {
    ClientPlayerEntity player = MinecraftClient.getInstance().player;
    if (player == null) return;
    if (!hasReceivedVersion) {
      player.sendMessage(Text.translatable("message.ntm.version.not_installed1"), false);
      player.sendMessage(Text.translatable("message.ntm.version.not_installed2"), false);
      NTMClient.LOGGER.info("Connected Server does not have {} installed", NTM.MOD_NAME);
      return;
    }
    NTMClient.LOGGER.info("Connected Server does has Version {} have {} installed", serverVersion.getFriendlyString(), NTM.MOD_NAME);
    if (!serverVersion.getFriendlyString().equals(clientVersion.getFriendlyString())) {
      NTMClient.LOGGER.warn("Version Mismatch, Client has Version {} have {} installed", clientVersion.getFriendlyString(), NTM.MOD_NAME);
      player.sendMessage(Text.translatable("message.ntm.version.mismatch1"), false);
      player.sendMessage(Text.translatable("message.ntm.version.mismatch2"), false);
      player.sendMessage(Text.translatable("message.ntm.version.server", serverVersion.getFriendlyString()), false);
      player.sendMessage(Text.translatable("message.ntm.version.client", clientVersion.getFriendlyString()), false);
    }
  }

  public static void onDisconnect() {
    hasReceivedVersion = false;
    serverVersion = null;
  }
}
