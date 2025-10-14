package net.fawnoculus.ntm.api.events.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;

public interface ConnectToServerCallback {
  Event<ConnectToServerCallback> EVENT = EventFactory.createArrayBacked(ConnectToServerCallback.class,
    (listeners) -> (handler, packet) -> {
      for (ConnectToServerCallback event : listeners) {
        event.onJoin(handler, packet);
      }
    }
  );


  void onJoin(ClientPlayNetworkHandler handler, GameJoinS2CPacket packet);
}
