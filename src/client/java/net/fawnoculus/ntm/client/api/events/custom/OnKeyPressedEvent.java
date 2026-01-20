package net.fawnoculus.ntm.client.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.input.KeyEvent;
import org.jetbrains.annotations.NotNull;

public interface OnKeyPressedEvent {
    Event<@NotNull OnKeyPressedEvent> EVENT = EventFactory.createArrayBacked(OnKeyPressedEvent.class,
      (listeners) -> (client, keyInput) -> {
          for (OnKeyPressedEvent event : listeners) {
              if (event.onKeyPressed(client, keyInput)) {
                  return true;
              }
          }
          return false;
      }
    );

    /**
     * @return if the following actions should be canceled or not
     */
    boolean onKeyPressed(Minecraft client, KeyEvent keyInput);
}
