package net.fawnoculus.ntm.blocks.entities;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

/**
 * An Interface for Block Entities to respond Clients to sending Interaction Packets
 */
public interface InteractableBE {
  void onInteraction(ServerPlayerEntity source, Identifier action);
}
