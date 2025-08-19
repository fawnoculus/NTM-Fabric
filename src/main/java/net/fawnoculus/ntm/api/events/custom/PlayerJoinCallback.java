package net.fawnoculus.ntm.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.network.ConnectedClientData;
import net.minecraft.server.network.ServerPlayerEntity;

@FunctionalInterface
public interface PlayerJoinCallback {
  Event<PlayerJoinCallback> EVENT = EventFactory.createArrayBacked(PlayerJoinCallback.class,
    (listeners) -> (player, connection, clientData) -> {
      for (PlayerJoinCallback event : listeners) {
        event.onJoin(player, connection, clientData);
      }
    }
  );


  void onJoin(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData);
}
