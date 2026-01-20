package net.fawnoculus.ntm.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.MinecraftServer;

@FunctionalInterface
public interface ServerStartEvent {
    Event<ServerStartEvent> PRE_START = EventFactory.createArrayBacked(ServerStartEvent.class,
      (listeners) -> (server) -> {
          for (ServerStartEvent event : listeners) {
              event.onStart(server);
          }
      }
    );

    Event<ServerStartEvent> POST_START = EventFactory.createArrayBacked(ServerStartEvent.class,
      (listeners) -> (server) -> {
          for (ServerStartEvent event : listeners) {
              event.onStart(server);
          }
      }
    );


    void onStart(MinecraftServer server);
}
