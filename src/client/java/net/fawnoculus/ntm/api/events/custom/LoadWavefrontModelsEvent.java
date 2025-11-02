package net.fawnoculus.ntm.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

@FunctionalInterface
public interface LoadWavefrontModelsEvent {
  Event<LoadWavefrontModelsEvent> EVENT = EventFactory.createArrayBacked(LoadWavefrontModelsEvent.class,
    (listeners) -> () -> {
      for (LoadWavefrontModelsEvent event : listeners) {
        event.loadModels();
      }
    }
  );

  void loadModels();
}
