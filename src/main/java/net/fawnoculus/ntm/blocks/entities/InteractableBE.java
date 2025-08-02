package net.fawnoculus.ntm.blocks.entities;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public interface InteractableBE {
  void onInteraction(ServerPlayerEntity source, Identifier action);
}
