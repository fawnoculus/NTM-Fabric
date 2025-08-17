package net.fawnoculus.ntm.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.fluid.data.ClientFluidDataRegistry;
import net.fawnoculus.ntm.api.messages.MessageSystem;
import net.fawnoculus.ntm.api.radiation.ClientHazmatRegistry;
import net.fawnoculus.ntm.api.radiation.ClientRadiationManager;
import net.fawnoculus.ntm.api.radiation.ClientRadiationRegistry;
import net.fawnoculus.ntm.network.s2c.*;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class NTMClientPayloadHandler {
  public static void initialize() {
    ClientPlayNetworking.registerGlobalReceiver(AdvancedMessagePayload.ID, (payload, context) -> MessageSystem.addMessage(payload.message()));
    ClientPlayNetworking.registerGlobalReceiver(RemoveMessagePayload.ID, (payload, context) -> MessageSystem.removeMessage(payload.identifier()));
    ClientPlayNetworking.registerGlobalReceiver(RemoveAllMessagesPayload.ID, (payload, context) -> MessageSystem.removeAllMessages());
    ClientPlayNetworking.registerGlobalReceiver(RadiationInformationPayload.ID, (payload, context) -> ClientRadiationManager.getInstance().handlePacked(payload));
    ClientPlayNetworking.registerGlobalReceiver(RadiationRegistryPayload.ID, (payload, context) -> ClientRadiationRegistry.getInstance().updateFromPacket(payload.serializedRegistry()));
    ClientPlayNetworking.registerGlobalReceiver(HazmatRegistryPayload.ID, (payload, context) -> ClientHazmatRegistry.getInstance().updateFromPacket(payload.serializedRegistry()));
    ClientPlayNetworking.registerGlobalReceiver(FluidDataRegistryPayload.ID, (payload, context) -> ClientFluidDataRegistry.updateFromPacket(payload.registryNBT()));
    ClientPlayNetworking.registerGlobalReceiver(NTMVersionPayload.ID, (payload, context) -> ClientReceivedVersionHandler.handlePacket(payload));
    ClientPlayNetworking.registerGlobalReceiver(InventorySyncPayload.ID, NTMClientPayloadHandler::handleInventorySync);
  }

  private static void handleInventorySync(InventorySyncPayload payload, @NotNull ClientPlayNetworking.Context context){
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
