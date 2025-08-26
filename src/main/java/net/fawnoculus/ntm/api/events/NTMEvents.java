package net.fawnoculus.ntm.api.events;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.api.radiation.HazmatRegistry;
import net.fawnoculus.ntm.api.radiation.RadiationRegistry;
import net.fawnoculus.ntm.fluid.data.FluidDataRegistry;
import net.fawnoculus.ntm.api.events.custom.PlayerJoinCallback;
import net.fawnoculus.ntm.network.s2c.FluidDataRegistryPayload;
import net.fawnoculus.ntm.network.s2c.HazmatRegistryPayload;
import net.fawnoculus.ntm.network.s2c.RadiationRegistryPayload;

public class NTMEvents {
  public static void initialize() {
    PlayerJoinCallback.EVENT.register((connection, player, clientData) ->
      ServerPlayNetworking.send(player, new RadiationRegistryPayload(RadiationRegistry.getInstance().serialize()))
    );
    PlayerJoinCallback.EVENT.register((connection, player, clientData) ->
      ServerPlayNetworking.send(player, new HazmatRegistryPayload(HazmatRegistry.getInstance().serialize()))
    );
    PlayerJoinCallback.EVENT.register((connection, player, clientData) ->
      ServerPlayNetworking.send(player, new FluidDataRegistryPayload(FluidDataRegistry.encodeAllFluidData()))
    );
  }
}
