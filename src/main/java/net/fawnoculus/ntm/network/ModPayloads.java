package net.fawnoculus.ntm.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fawnoculus.ntm.network.custom.AdvancedMessageS2CPayload;
import net.fawnoculus.ntm.network.custom.RadiationInformationS2CPayload;
import net.fawnoculus.ntm.network.custom.RemoveAllMessagesS2CPayload;
import net.fawnoculus.ntm.network.custom.RemoveMessageS2CPayload;

public class ModPayloads {
  public static void initialize(){
    PayloadTypeRegistry.playS2C().register(AdvancedMessageS2CPayload.ID, AdvancedMessageS2CPayload.PACKET_CODEC);
    PayloadTypeRegistry.playS2C().register(RemoveMessageS2CPayload.ID, RemoveMessageS2CPayload.PACKET_CODEC);
    PayloadTypeRegistry.playS2C().register(RemoveAllMessagesS2CPayload.ID, RemoveAllMessagesS2CPayload.PACKET_CODEC);
    PayloadTypeRegistry.playS2C().register(RadiationInformationS2CPayload.ID, RadiationInformationS2CPayload.PACKET_CODEC);
  }
}
