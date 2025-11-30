package net.fawnoculus.ntm.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.network.ConnectedClientData;
import net.minecraft.server.network.ServerPlayerEntity;

@FunctionalInterface
public interface PlayerJoinCallback {
    Event<PlayerJoinCallback> EARLY = EventFactory.createArrayBacked(PlayerJoinCallback.class,
      (listeners) -> (connection, player, clientData) -> {
          for (PlayerJoinCallback event : listeners) {
              event.onJoin(connection, player, clientData);
          }
      }
    );

    Event<PlayerJoinCallback> LATE = EventFactory.createArrayBacked(PlayerJoinCallback.class,
      (listeners) -> (connection, player, clientData) -> {
          for (PlayerJoinCallback event : listeners) {
              event.onJoin(connection, player, clientData);
          }
      }
    );


    void onJoin(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData);
}
