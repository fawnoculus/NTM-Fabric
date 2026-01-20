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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class NTMServerPayloadHandler {
    public static void initialize() {
        ServerPlayNetworking.registerGlobalReceiver(BEInteractionPayload.ID, NTMServerPayloadHandler::handleBEInteractionPayload);
        ServerPlayNetworking.registerGlobalReceiver(ItemInteractionPayload.ID, NTMServerPayloadHandler::handleItemInteractionPayload);
        ServerPlayNetworking.registerGlobalReceiver(ToolAbilityPresetPayload.ID, NTMServerPayloadHandler::handleToolAbilityPresetPayload);
    }

    private static void handleBEInteractionPayload(BEInteractionPayload payload, ServerPlayNetworking.Context context) {
        ServerPlayer player = context.player();

        if (player.getEyePosition().distanceTo(WorldUtil.getVec3d(payload.pos())) > player.blockInteractionRange() + 1) {
            if (NTMConfig.DEV_MODE.getValue()) {
                NTM.LOGGER.warn("Player '{}' tried to use action '{}' on BE at '{}' but was to far away", player.getName().tryCollapseToString(), payload.action().toString(), payload.pos().toShortString());
            }
            return;
        }

        ServerLevel world = player.level();
        if (world.getBlockEntity(payload.pos()) instanceof InteractableBE interactableBE) {
            interactableBE.onInteraction(player, payload.action(), payload.extraData());
        }
    }

    private static void handleItemInteractionPayload(ItemInteractionPayload payload, ServerPlayNetworking.Context context) {
        ServerPlayer player = context.player();

        if (player.getMainHandItem().getItem() instanceof InteractableItem interactableItem) {
            interactableItem.onInteraction(player, player.getMainHandItem(), payload.action(), payload.extraData());
        }
    }

    private static void handleToolAbilityPresetPayload(ToolAbilityPresetPayload payload, ServerPlayNetworking.Context context) {
        ServerPlayer player = context.player();
        ItemStack stack = player.getMainHandItem();

        if (stack.getItem() instanceof SpecialTool specialTool
          && specialTool.abilityHandler().verifyPresets(payload.stackData().presets())
          && payload.stackData().isValid()
        ) {
            specialTool.abilityHandler().setStackData(stack, payload.stackData());

            context.responseSender().sendPacket(
              new AdvancedMessagePayload(
                new AdvancedMessage(SpecialTool.ADVANCED_MESSAGE_ID, specialTool.abilityHandler().changeMessage(stack), 1000f)
              )
            );
        }
    }
}
