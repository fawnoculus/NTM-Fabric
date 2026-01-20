package net.fawnoculus.ntm.client.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.client.api.messages.MessageSystem;
import net.fawnoculus.ntm.client.api.radiation.ClientHazmatRegistry;
import net.fawnoculus.ntm.client.api.radiation.ClientRadiationManager;
import net.fawnoculus.ntm.client.api.radiation.ClientRadiationRegistry;
import net.fawnoculus.ntm.client.data.ClientFluidDataRegistry;
import net.fawnoculus.ntm.network.s2c.*;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

public class NTMClientPayloadHandler {
    public static void initialize() {
        ClientPlayNetworking.registerGlobalReceiver(AdvancedMessagePayload.ID, (payload, context) -> MessageSystem.addMessage(payload.message()));
        ClientPlayNetworking.registerGlobalReceiver(RemoveMessagePayload.ID, (payload, context) -> MessageSystem.removeMessage(payload.identifier()));
        ClientPlayNetworking.registerGlobalReceiver(RemoveAllMessagesPayload.ID, (payload, context) -> MessageSystem.removeAllMessages());
        ClientPlayNetworking.registerGlobalReceiver(RadiationInformationPayload.ID, ClientRadiationManager::handlePacket);
        ClientPlayNetworking.registerGlobalReceiver(RadiationRegistryPayload.ID, ClientRadiationRegistry::updateFromPacket);
        ClientPlayNetworking.registerGlobalReceiver(HazmatRegistryPayload.ID, ClientHazmatRegistry::updateFromPacket);
        ClientPlayNetworking.registerGlobalReceiver(FluidDataRegistryPayload.ID, ClientFluidDataRegistry::updateFromPacket);
        ClientPlayNetworking.registerGlobalReceiver(NTMVersionPayload.ID, ClientReceivedVersionHandler::handlePacket);
        ClientPlayNetworking.registerGlobalReceiver(InventorySyncPayload.ID, NTMClientPayloadHandler::handleInventorySync);
    }

    private static void handleInventorySync(InventorySyncPayload payload, @NotNull ClientPlayNetworking.Context context) {
        if (!(context.player().level() instanceof ClientLevel world)) {
            return;
        }

        BlockEntity be = world.getBlockEntity(payload.pos());
        if (be instanceof Container inventory) {
            int i = 0;
            for (ItemStack stack : payload.inventory()) {
                inventory.setItem(i, stack);
                i++;
            }

            world.sendBlockUpdated(payload.pos(), be.getBlockState(), be.getBlockState(), Block.UPDATE_ALL);
        }
    }

}
