package net.fawnoculus.ntm.client.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.MinecraftClient;

public interface OnKeyPressedEvent {
    Event<OnKeyPressedEvent> EVENT = EventFactory.createArrayBacked(OnKeyPressedEvent.class,
      (listeners) -> (client, key, scancode, action, modifiers) -> {
          for (OnKeyPressedEvent event : listeners) {
              if (event.onKeyPressed(client, key, scancode, action, modifiers)) {
                  return true;
              }
          }
          return false;
      }
    );

    /**
     * @return if the following actions should be canceled or not
     */
    boolean onKeyPressed(MinecraftClient client, int key, int scancode, int action, int modifiers);
}
