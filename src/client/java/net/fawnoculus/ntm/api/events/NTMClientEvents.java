package net.fawnoculus.ntm.api.events;

import net.fabricmc.fabric.api.client.networking.v1.ClientLoginConnectionEvents;
import net.fawnoculus.ntm.api.events.custom.ConnectToServerCallback;
import net.fawnoculus.ntm.api.messages.MessageSystem;
import net.fawnoculus.ntm.network.ClientReceivedVersionHandler;

public class NTMClientEvents {
  public static void initialize() {
    ClientLoginConnectionEvents.DISCONNECT.register(ClientReceivedVersionHandler::onDisconnect);
    ClientLoginConnectionEvents.DISCONNECT.register((handler, client) ->
      MessageSystem.removeAllMessages()
    );
    ConnectToServerCallback.EVENT.register(ClientReceivedVersionHandler::onJoin);
  }
}
