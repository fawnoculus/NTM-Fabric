package net.fawnoculus.ntm.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.MinecraftClient;

/**
 * This Event is called every time the Client draws a new Frame
 */
@FunctionalInterface
public interface ClientTickCallback {
  Event<ClientTickCallback> EVENT = EventFactory.createArrayBacked(ClientTickCallback.class,
    (listeners) -> (client) -> {
      for (ClientTickCallback event : listeners) {
        event.onTick(client);
      }
    }
  );


  void onTick(MinecraftClient client);
}
