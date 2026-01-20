package net.fawnoculus.ntm.client.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.input.MouseButtonEvent;
import org.jetbrains.annotations.NotNull;

public interface OnMouseClickEvent {
    Event<@NotNull OnMouseClickEvent> EVENT = EventFactory.createArrayBacked(OnMouseClickEvent.class,
      (listeners) -> (client, click) -> {
          for (OnMouseClickEvent event : listeners) {
              if (event.onClick(client, click)) {
                  return true;
              }
          }
          return false;
      }
    );

    /**
     * @return if the following actions should be canceled or not
     */
    boolean onClick(Minecraft client, MouseButtonEvent click);
}
