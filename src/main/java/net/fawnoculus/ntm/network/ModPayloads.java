package net.fawnoculus.ntm.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fawnoculus.ntm.network.custom.AdvancedMessageS2CPayload;
import net.fawnoculus.ntm.network.custom.ClearMessagesS2CPayload;

public class ModPayloads {
  public static void initialize(){
    PayloadTypeRegistry.playS2C().register(AdvancedMessageS2CPayload.ID, AdvancedMessageS2CPayload.PACKET_CODEC);
    PayloadTypeRegistry.playS2C().register(ClearMessagesS2CPayload.ID, ClearMessagesS2CPayload.PACKET_CODEC);
  }
}
