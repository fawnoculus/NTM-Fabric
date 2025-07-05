package net.fawnoculus.ntm.network;

import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.network.custom.AdvancedMessageS2CPayload;
import net.fawnoculus.ntm.network.custom.RemoveAllMessagesS2CPayload;
import net.fawnoculus.ntm.network.custom.RemoveMessageS2CPayload;
import net.fawnoculus.ntm.util.messages.MessageSystem;

public class ModPayloadHandler {
  public static void initialize() {
    if (NTM.ENVIRONMENT == EnvType.CLIENT) {
      initializeClient();
    }
    initializeServer();
  }
  
  private static void initializeServer(){}
  
  private static void initializeClient() {
    ClientPlayNetworking.registerGlobalReceiver(AdvancedMessageS2CPayload.ID, (payload, context) -> MessageSystem.addMessage(payload.message()));
    ClientPlayNetworking.registerGlobalReceiver(RemoveMessageS2CPayload.ID, (payload, context) -> MessageSystem.removeMessage(payload.identifier()));
    ClientPlayNetworking.registerGlobalReceiver(RemoveAllMessagesS2CPayload.ID, (payload, context) -> MessageSystem.removeAllMessages());
  }
}
