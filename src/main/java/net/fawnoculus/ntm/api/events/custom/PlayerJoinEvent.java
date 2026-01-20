package net.fawnoculus.ntm.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.network.Connection;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;

@FunctionalInterface
public interface PlayerJoinEvent {
    Event<PlayerJoinEvent> PRE_JOIN = EventFactory.createArrayBacked(PlayerJoinEvent.class,
      (listeners) -> (connection, player, clientData) -> {
          for (PlayerJoinEvent event : listeners) {
              event.onJoin(connection, player, clientData);
          }
      }
    );

    Event<PlayerJoinEvent> POST_JOIN = EventFactory.createArrayBacked(PlayerJoinEvent.class,
      (listeners) -> (connection, player, clientData) -> {
          for (PlayerJoinEvent event : listeners) {
              event.onJoin(connection, player, clientData);
          }
      }
    );


    void onJoin(Connection connection, ServerPlayer player, CommonListenerCookie clientData);
}
