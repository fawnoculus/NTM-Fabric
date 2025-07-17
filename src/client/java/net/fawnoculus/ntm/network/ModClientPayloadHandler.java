package net.fawnoculus.ntm.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.network.custom.*;
import net.fawnoculus.ntm.misc.messages.MessageSystem;
import net.fawnoculus.ntm.misc.radiation.ClientRadiationManager;
import net.fawnoculus.ntm.misc.radiation.ClientRadiationRegistry;

public class ModClientPayloadHandler {
  public static boolean hasReceivedVersion = false;
  
  public static void initialize() {
    ClientPlayNetworking.registerGlobalReceiver(AdvancedMessageS2CPayload.ID, (payload, context) -> MessageSystem.addMessage(payload.message()));
    ClientPlayNetworking.registerGlobalReceiver(RemoveMessageS2CPayload.ID, (payload, context) -> MessageSystem.removeMessage(payload.identifier()));
    ClientPlayNetworking.registerGlobalReceiver(RemoveAllMessagesS2CPayload.ID, (payload, context) -> MessageSystem.removeAllMessages());
    ClientPlayNetworking.registerGlobalReceiver(RadiationInformationS2CPayload.ID, (payload, context) -> ClientRadiationManager.getInstance().handlePacked(payload));
    ClientPlayNetworking.registerGlobalReceiver(RadiationRegistryS2CPayload.ID, (payload, context) -> ClientRadiationRegistry.getInstance().updateFromPacket(payload.serializedRegistry()));
    ClientPlayNetworking.registerGlobalReceiver(NTMVersionS2CPayload.ID, (payload, context) -> ClientReceivedVersionHandler.handlePacket(payload));
  }
}
