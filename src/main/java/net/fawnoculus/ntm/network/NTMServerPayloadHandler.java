package net.fawnoculus.ntm.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.fawnoculus.ntm.api.tool.SpecialTool;
import net.fawnoculus.ntm.blocks.entities.InteractableBE;
import net.fawnoculus.ntm.items.custom.InteractableItem;
import net.fawnoculus.ntm.network.c2s.BEInteractionPayload;
import net.fawnoculus.ntm.network.c2s.ItemInteractionPayload;
import net.fawnoculus.ntm.network.c2s.ToolAbilityPresetPayload;
import net.fawnoculus.ntm.network.s2c.AdvancedMessagePayload;
import net.fawnoculus.ntm.util.WorldUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class NTMServerPayloadHandler {
  public static void initialize() {
    ServerPlayNetworking.registerGlobalReceiver(BEInteractionPayload.ID, NTMServerPayloadHandler::handleBEInteractionPayload);
    ServerPlayNetworking.registerGlobalReceiver(ItemInteractionPayload.ID, NTMServerPayloadHandler::handleItemInteractionPayload);
    ServerPlayNetworking.registerGlobalReceiver(ToolAbilityPresetPayload.ID, NTMServerPayloadHandler::handleToolAbilityPresetPayload);
  }

  private static void handleBEInteractionPayload(BEInteractionPayload payload, ServerPlayNetworking.Context context){
    ServerPlayerEntity player = context.player();

    if(player.getEyePos().distanceTo(WorldUtil.getVec3d(payload.pos())) > player.getBlockInteractionRange() + 1){
      if(NTMConfig.DevMode.getValue()){
        NTM.LOGGER.warn("Player '{}' tried to use action '{}' on BE at '{}' but was to far away", player.getName().getLiteralString(), payload.action().toString(), payload.pos().toShortString());
      }
      return;
    }

    ServerWorld world = player.getWorld();
    if(world.getBlockEntity(payload.pos()) instanceof InteractableBE interactableBE){
      interactableBE.onInteraction(player, payload.action(), payload.extraData());
    }
  }

  private static void handleItemInteractionPayload(ItemInteractionPayload payload, ServerPlayNetworking.Context context){
    ServerPlayerEntity player = context.player();

    if(player.getMainHandStack().getItem() instanceof InteractableItem interactableItem){
      interactableItem.onInteraction(player, player.getMainHandStack(), payload.action(), payload.extraData());
    }
  }

  private static void handleToolAbilityPresetPayload(ToolAbilityPresetPayload payload, ServerPlayNetworking.Context context){
    ServerPlayerEntity player = context.player();
    ItemStack stack = player.getMainHandStack();

    if(stack.getItem() instanceof SpecialTool specialTool
      && specialTool.abilityHandler().verifyPresets(payload.stackData().presets())
      && payload.stackData().isValid()
    ){
      specialTool.abilityHandler().setStackData(stack, payload.stackData());

      context.responseSender().sendPacket(
        new AdvancedMessagePayload(
          new AdvancedMessage(SpecialTool.ADVANCED_MESSAGE_ID, specialTool.abilityHandler().changeMessage(stack), 1000f)
        )
      );
    }
  }
}
