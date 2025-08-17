package net.fawnoculus.ntm.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.blocks.entities.InteractableBE;
import net.fawnoculus.ntm.items.custom.InteractableItem;
import net.fawnoculus.ntm.network.c2s.BEInteractionPayload;
import net.fawnoculus.ntm.network.c2s.ItemInteractionPayload;
import net.fawnoculus.ntm.util.WorldUtil;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.NotNull;

public class NTMServerPayloadHandler {
  public static void initialize() {
    ServerPlayNetworking.registerGlobalReceiver(BEInteractionPayload.ID, NTMServerPayloadHandler::handleBEInteractionPayload);
    ServerPlayNetworking.registerGlobalReceiver(ItemInteractionPayload.ID, NTMServerPayloadHandler::handleItemInteractionPayload);
  }

  private static void handleBEInteractionPayload(@NotNull BEInteractionPayload payload, @NotNull ServerPlayNetworking.Context context){
    ServerPlayerEntity player = context.player();

    if(player.getEyePos().distanceTo(WorldUtil.getVec3d(payload.pos())) > player.getBlockInteractionRange() + 1){
      if(NTMConfig.DevMode.getValue()){
        NTM.LOGGER.warn("Player '{}' tried to use action '{}' on BE at '{}' but was to far away", player.getName().getLiteralString(), payload.action().toString(), payload.pos().toShortString());
      }
      return;
    }

    ServerWorld world = player.getServerWorld();
    if(world.getBlockEntity(payload.pos()) instanceof InteractableBE interactableBE){
      interactableBE.onInteraction(player, payload.action());
    }
  }

  private static void handleItemInteractionPayload(@NotNull ItemInteractionPayload payload, @NotNull ServerPlayNetworking.Context context){
    ServerPlayerEntity player = context.player();

    if(player.getMainHandStack().getItem() instanceof InteractableItem interactableItem){
      interactableItem.onInteraction(player, player.getMainHandStack(), payload.action(), payload.extraData());
    }
  }
}
