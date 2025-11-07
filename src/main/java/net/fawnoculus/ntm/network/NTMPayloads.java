package net.fawnoculus.ntm.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fawnoculus.ntm.network.c2s.BEInteractionPayload;
import net.fawnoculus.ntm.network.c2s.ItemInteractionPayload;
import net.fawnoculus.ntm.network.c2s.ToolAbilityPresetPayload;
import net.fawnoculus.ntm.network.s2c.*;

public class NTMPayloads {
	public static void initialize() {
		PayloadTypeRegistry.playS2C().register(AdvancedMessagePayload.ID, AdvancedMessagePayload.PACKET_CODEC);
		PayloadTypeRegistry.playS2C().register(NTMExplosionPayload.ID, NTMExplosionPayload.PACKET_CODEC);
		PayloadTypeRegistry.playS2C().register(RemoveMessagePayload.ID, RemoveMessagePayload.PACKET_CODEC);
		PayloadTypeRegistry.playS2C().register(RemoveAllMessagesPayload.ID, RemoveAllMessagesPayload.PACKET_CODEC);
		PayloadTypeRegistry.playS2C().register(RadiationInformationPayload.ID, RadiationInformationPayload.PACKET_CODEC);
		PayloadTypeRegistry.playS2C().register(RadiationRegistryPayload.ID, RadiationRegistryPayload.PACKET_CODEC);
		PayloadTypeRegistry.playS2C().register(HazmatRegistryPayload.ID, HazmatRegistryPayload.PACKET_CODEC);
		PayloadTypeRegistry.playS2C().register(FluidDataRegistryPayload.ID, FluidDataRegistryPayload.PACKET_CODEC);
		PayloadTypeRegistry.playS2C().register(NTMVersionPayload.ID, NTMVersionPayload.PACKET_CODEC);
		PayloadTypeRegistry.playS2C().register(InventorySyncPayload.ID, InventorySyncPayload.PACKET_CODEC);

		PayloadTypeRegistry.playC2S().register(BEInteractionPayload.ID, BEInteractionPayload.PACKET_CODEC);
		PayloadTypeRegistry.playC2S().register(ItemInteractionPayload.ID, ItemInteractionPayload.PACKET_CODEC);
		PayloadTypeRegistry.playC2S().register(ToolAbilityPresetPayload.ID, ToolAbilityPresetPayload.PACKET_CODEC);
	}
}
