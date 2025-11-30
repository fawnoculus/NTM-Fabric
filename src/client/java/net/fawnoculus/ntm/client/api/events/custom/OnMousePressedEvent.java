package net.fawnoculus.ntm.client.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.MinecraftClient;

public interface OnMousePressedEvent {
    Event<OnMousePressedEvent> EVENT = EventFactory.createArrayBacked(OnMousePressedEvent.class,
      (listeners) -> (client, button, action, mods) -> {
          for (OnMousePressedEvent event : listeners) {
              if (event.onButtonPressed(client, button, action, mods)) {
                  return true;
              }
          }
          return false;
      }
    );

    /**
     * @return if the following actions should be canceled or not
     */
    boolean onButtonPressed(MinecraftClient client, int button, int action, int mods);
}
