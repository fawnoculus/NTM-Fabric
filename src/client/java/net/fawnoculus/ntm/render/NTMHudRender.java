package net.fawnoculus.ntm.render;

import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.render.hud.BlockHoverTooltipRender;
import net.fawnoculus.ntm.render.hud.GeigerCounterRender;
import net.fawnoculus.ntm.render.hud.MessageSystemRender;
import net.minecraft.util.Identifier;

public class NTMHudRender {
  public static final Identifier MESSAGE_SYSTEM_ID = NTM.id("message_system");
  public static final Identifier GEIGER_COUNTER_ID = NTM.id("geiger_counter");
  public static final Identifier BLOCK_HOVER_TOOLTIP_ID = NTM.id("block_hover_tooltip");

  public static void initialize() {
    HudLayerRegistrationCallback.EVENT.register(layeredDrawer -> layeredDrawer.attachLayerBefore(IdentifiedLayer.HOTBAR_AND_BARS, MESSAGE_SYSTEM_ID, MessageSystemRender::drawMessageSystem));
    HudLayerRegistrationCallback.EVENT.register(layeredDrawer -> layeredDrawer.attachLayerBefore(IdentifiedLayer.HOTBAR_AND_BARS, GEIGER_COUNTER_ID, GeigerCounterRender::drawGeigerCounter));
    HudLayerRegistrationCallback.EVENT.register(layeredDrawer -> layeredDrawer.attachLayerBefore(IdentifiedLayer.HOTBAR_AND_BARS, BLOCK_HOVER_TOOLTIP_ID, BlockHoverTooltipRender::drawBlockHoverTooltip));
  }
}
