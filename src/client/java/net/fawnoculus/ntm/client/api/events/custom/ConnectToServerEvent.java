package net.fawnoculus.ntm.client.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;

public interface ConnectToServerEvent {
    Event<ConnectToServerEvent> EVENT = EventFactory.createArrayBacked(ConnectToServerEvent.class,
      (listeners) -> (handler, packet) -> {
          for (ConnectToServerEvent event : listeners) {
              event.onJoin(handler, packet);
          }
      }
    );


    void onJoin(ClientPacketListener handler, ClientboundLoginPacket packet);
}
