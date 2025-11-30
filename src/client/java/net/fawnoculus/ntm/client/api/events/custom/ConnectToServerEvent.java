package net.fawnoculus.ntm.client.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;

public interface ConnectToServerEvent {
    Event<ConnectToServerEvent> EVENT = EventFactory.createArrayBacked(ConnectToServerEvent.class,
      (listeners) -> (handler, packet) -> {
          for (ConnectToServerEvent event : listeners) {
              event.onJoin(handler, packet);
          }
      }
    );


    void onJoin(ClientPlayNetworkHandler handler, GameJoinS2CPacket packet);
}
