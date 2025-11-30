package net.fawnoculus.ntm.items.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

/**
 * An Interface for Items to respond Clients to sending Interaction Packets
 */
public interface InteractableItem {
    void onInteraction(ServerPlayerEntity source, ItemStack heldStack, Identifier action, NbtCompound extraData);
}
