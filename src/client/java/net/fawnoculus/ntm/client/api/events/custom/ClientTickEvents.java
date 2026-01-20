package net.fawnoculus.ntm.client.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.Minecraft;

/**
 * This Event is called every time the Client draws a new Frame
 */
@FunctionalInterface
public interface ClientTickEvents {
    Event<ClientTickEvents> EVENT = EventFactory.createArrayBacked(ClientTickEvents.class,
      (listeners) -> (client) -> {
          for (ClientTickEvents event : listeners) {
              event.onTick(client);
          }
      }
    );


    void onTick(Minecraft client);
}
