package net.fawnoculus.ntm.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.network.custom.AdvancedMessageS2CPayload;
import net.fawnoculus.ntm.network.custom.RadiationInformationS2CPayload;
import net.fawnoculus.ntm.network.custom.RemoveAllMessagesS2CPayload;
import net.fawnoculus.ntm.network.custom.RemoveMessageS2CPayload;
import net.fawnoculus.ntm.util.messages.MessageSystem;
import net.fawnoculus.ntm.world.radiation.ClientRadiationManager;

public class ModClientPayloadHandler {
  public static void initialize() {
    ClientPlayNetworking.registerGlobalReceiver(AdvancedMessageS2CPayload.ID, (payload, context) -> MessageSystem.addMessage(payload.message()));
    ClientPlayNetworking.registerGlobalReceiver(RemoveMessageS2CPayload.ID, (payload, context) -> MessageSystem.removeMessage(payload.identifier()));
    ClientPlayNetworking.registerGlobalReceiver(RemoveAllMessagesS2CPayload.ID, (payload, context) -> MessageSystem.removeAllMessages());
    ClientPlayNetworking.registerGlobalReceiver(RadiationInformationS2CPayload.ID, (payload, context) -> ClientRadiationManager.getInstance().handlePacked(payload));
  }
}
