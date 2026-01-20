package net.fawnoculus.ntm.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.MinecraftServer;

@FunctionalInterface
public interface ServerSaveEvent {
    Event<ServerSaveEvent> PRE_SAVE = EventFactory.createArrayBacked(ServerSaveEvent.class,
      (listeners) -> (server, suppressLogs, flush, force) -> {
          for (ServerSaveEvent event : listeners) {
              event.onSave(server, suppressLogs, flush, force);
          }
      }
    );

    Event<ServerSaveEvent> POST_SAVE = EventFactory.createArrayBacked(ServerSaveEvent.class,
      (listeners) -> (server, suppressLogs, flush, force) -> {
          for (ServerSaveEvent event : listeners) {
              event.onSave(server, suppressLogs, flush, force);
          }
      }
    );

    void onSave(MinecraftServer server, boolean suppressLogs, boolean flush, boolean force);
}
