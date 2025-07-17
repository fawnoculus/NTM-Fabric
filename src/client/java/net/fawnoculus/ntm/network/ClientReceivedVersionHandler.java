package net.fawnoculus.ntm.network;

import net.fabricmc.loader.api.Version;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.network.custom.NTMVersionS2CPayload;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;

public class ClientReceivedVersionHandler {
  public static boolean hasReceivedVersion = false;
  
  public static Version serverVersion = null;
  public static Version clientVersion = NTM.MOD_VERSION;
  
  public static void handlePacket(NTMVersionS2CPayload payload){
    hasReceivedVersion = true;
    serverVersion = payload.version();
  }
  public static void onJoin(){
    ClientPlayerEntity player = MinecraftClient.getInstance().player;
    if(player == null) return;
    if(!hasReceivedVersion){
      player.sendMessage(Text.translatable("message.ntm.version.not_installed1"), false);
      player.sendMessage(Text.translatable("message.ntm.version.not_installed2"), false);
      return;
    }
    if(!serverVersion.getFriendlyString().equals(clientVersion.getFriendlyString())){
      player.sendMessage(Text.translatable("message.ntm.version.mismatch1"), false);
      player.sendMessage(Text.translatable("message.ntm.version.mismatch2"), false);
      player.sendMessage(Text.translatable("message.ntm.version.server", serverVersion.getFriendlyString()), false);
      player.sendMessage(Text.translatable("message.ntm.version.client", clientVersion.getFriendlyString()), false);
    }
  }
  public static void onDisconnect(){
    hasReceivedVersion = false;
    serverVersion = null;
  }
}
