package net.fawnoculus.ntm.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.MinecraftServer;

import java.util.function.BooleanSupplier;

@FunctionalInterface
public interface ServerTickEvent {
    Event<ServerTickEvent> PRE_TICK = EventFactory.createArrayBacked(ServerTickEvent.class,
      (listeners) -> (server, shouldKeepTicking, tickStartNanoTime) -> {
          for (ServerTickEvent event : listeners) {
              event.onTick(server, shouldKeepTicking, tickStartNanoTime);
          }
      }
    );

    Event<ServerTickEvent> POST_TICK = EventFactory.createArrayBacked(ServerTickEvent.class,
      (listeners) -> (server, shouldKeepTicking, tickStartNanoTime) -> {
          for (ServerTickEvent event : listeners) {
              event.onTick(server, shouldKeepTicking, tickStartNanoTime);
          }
      }
    );


    void onTick(MinecraftServer server, BooleanSupplier shouldKeepTicking, long tickStartNanoTime);
}
