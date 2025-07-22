package net.fawnoculus.ntm.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.network.custom.*;
import net.fawnoculus.ntm.misc.messages.MessageSystem;
import net.fawnoculus.ntm.misc.radiation.ClientRadiationManager;
import net.fawnoculus.ntm.misc.radiation.ClientRadiationRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

public class ModClientPayloadHandler {
  public static void initialize() {
    ClientPlayNetworking.registerGlobalReceiver(AdvancedMessageS2CPayload.ID, (payload, context) -> MessageSystem.addMessage(payload.message()));
    ClientPlayNetworking.registerGlobalReceiver(RemoveMessageS2CPayload.ID, (payload, context) -> MessageSystem.removeMessage(payload.identifier()));
    ClientPlayNetworking.registerGlobalReceiver(RemoveAllMessagesS2CPayload.ID, (payload, context) -> MessageSystem.removeAllMessages());
    ClientPlayNetworking.registerGlobalReceiver(RadiationInformationS2CPayload.ID, (payload, context) -> ClientRadiationManager.getInstance().handlePacked(payload));
    ClientPlayNetworking.registerGlobalReceiver(RadiationRegistryS2CPayload.ID, (payload, context) -> ClientRadiationRegistry.getInstance().updateFromPacket(payload.serializedRegistry()));
    ClientPlayNetworking.registerGlobalReceiver(NTMVersionS2CPayload.ID, (payload, context) -> ClientReceivedVersionHandler.handlePacket(payload));
    ClientPlayNetworking.registerGlobalReceiver(InventorySyncS2CPayload.ID, ModClientPayloadHandler::handleInventorySync);
  }
  
  private static void handleInventorySync(InventorySyncS2CPayload payload, ClientPlayNetworking.Context context){
    if(context.player() == null) return;
    if(context.player().clientWorld == null) return;
    
    ClientWorld world = context.player().clientWorld;
    BlockEntity be = world.getBlockEntity(payload.pos());
    if(be instanceof Inventory inventory){
      int i = 0;
      for(ItemStack stack : payload.inventory()){
        inventory.setStack(i, stack);
        i++;
      }
      
      world.updateListeners(payload.pos(), be.getCachedState(), be.getCachedState(), Block.NOTIFY_ALL);
    }
  }
}
