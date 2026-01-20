package net.fawnoculus.ntm.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.MinecraftServer;

@FunctionalInterface
public interface ServerShutdownEvent {
    Event<ServerShutdownEvent> PRE_SHUTDOWN = EventFactory.createArrayBacked(ServerShutdownEvent.class,
      (listeners) -> (server) -> {
          for (ServerShutdownEvent event : listeners) {
              event.onSave(server);
          }
      }
    );

    Event<ServerShutdownEvent> POST_SHUTDOWN = EventFactory.createArrayBacked(ServerShutdownEvent.class,
      (listeners) -> (server) -> {
          for (ServerShutdownEvent event : listeners) {
              event.onSave(server);
          }
      }
    );


    void onSave(MinecraftServer server);
}
