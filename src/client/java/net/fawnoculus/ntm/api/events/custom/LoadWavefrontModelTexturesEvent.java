package net.fawnoculus.ntm.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

@FunctionalInterface
public interface LoadWavefrontModelTexturesEvent {
  Event<LoadWavefrontModelTexturesEvent> EVENT = EventFactory.createArrayBacked(LoadWavefrontModelTexturesEvent.class,
    (listeners) -> () -> {
      for (LoadWavefrontModelTexturesEvent event : listeners) {
        event.loadModelTextures();
      }
    }
  );

  void loadModelTextures();
}
