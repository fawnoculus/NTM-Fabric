package net.fawnoculus.ntm.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class ModPayloads {
  public static void initialize(){
    PayloadTypeRegistry.playS2C().register(AdvancedMessageS2CPayload.ID, AdvancedMessageS2CPayload.PACKET_CODEC);
    PayloadTypeRegistry.playS2C().register(ClearMessagesS2CPayload.ID, ClearMessagesS2CPayload.PACKET_CODEC);
  }
}
