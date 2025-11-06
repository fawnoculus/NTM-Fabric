package net.fawnoculus.ntm.api.events;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.events.custom.PlayerJoinCallback;
import net.fawnoculus.ntm.api.radiation.HazmatRegistry;
import net.fawnoculus.ntm.api.radiation.RadiationRegistry;
import net.fawnoculus.ntm.fluid.data.FluidDataRegistry;
import net.fawnoculus.ntm.network.s2c.FluidDataRegistryPayload;
import net.fawnoculus.ntm.network.s2c.HazmatRegistryPayload;
import net.fawnoculus.ntm.network.s2c.NTMVersionPayload;
import net.fawnoculus.ntm.network.s2c.RadiationRegistryPayload;

public class NTMEvents {
	public static void initialize() {
		PlayerJoinCallback.EARLY.register((connection, player, clientData) ->
		  ServerPlayNetworking.send(player, new NTMVersionPayload(NTM.MOD_VERSION))
		);
		PlayerJoinCallback.LATE.register((connection, player, clientData) ->
		  ServerPlayNetworking.send(player, new RadiationRegistryPayload(RadiationRegistry.serialize()))
		);
		PlayerJoinCallback.LATE.register((connection, player, clientData) ->
		  ServerPlayNetworking.send(player, new HazmatRegistryPayload(HazmatRegistry.serialize()))
		);
		PlayerJoinCallback.LATE.register((connection, player, clientData) ->
		  ServerPlayNetworking.send(player, new FluidDataRegistryPayload(FluidDataRegistry.encodeAllFluidData()))
		);
	}
}
