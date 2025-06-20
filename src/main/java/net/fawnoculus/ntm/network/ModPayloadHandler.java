package net.fawnoculus.ntm.network;

import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.util.messages.MessageSystem;

public class ModPayloadHandler {
  public static void initialize() {
    if (NTM.ENVIRONMENT == EnvType.CLIENT) {
      initializeClient();
    }
    if (NTM.ENVIRONMENT == EnvType.SERVER) {
      initializeServer();
    }
  }
  
  private static void initializeServer() {
  }
  
  private static void initializeClient() {
    ClientPlayNetworking.registerGlobalReceiver(AdvancedMessageS2CPayload.ID, (payload, context) -> {
      MessageSystem.addMessage(payload.message());
    });
    ClientPlayNetworking.registerGlobalReceiver(ClearMessagesS2CPayload.ID, (payload, context) -> {
      if(payload.identifier().toString().equals("special:all_messages")){
        MessageSystem.removeAllMessages();
        return;
      }
      MessageSystem.removeMessage(payload.identifier());
    });
  }
}
