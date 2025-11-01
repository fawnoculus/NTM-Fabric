package net.fawnoculus.ntm.render;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.render.hud.BlockHoverTooltipRender;
import net.fawnoculus.ntm.render.hud.GeigerCounterRender;
import net.fawnoculus.ntm.render.hud.MessageSystemRender;
import net.fawnoculus.ntm.render.hud.ToolAbilityRender;
import net.minecraft.util.Identifier;

public class NTMHudRender {
  public static final Identifier TOLL_ABILITY_ID = NTM.id("tool_ability");
  public static final Identifier MESSAGE_SYSTEM_ID = NTM.id("message_system");
  public static final Identifier GEIGER_COUNTER_ID = NTM.id("geiger_counter");
  public static final Identifier BLOCK_HOVER_TOOLTIP_ID = NTM.id("block_hover_tooltip");

  public static void initialize() {
    HudElementRegistry.attachElementAfter(VanillaHudElements.CROSSHAIR, TOLL_ABILITY_ID, ToolAbilityRender::drawToolAbility);
    HudElementRegistry.addLast(MESSAGE_SYSTEM_ID, MessageSystemRender::drawMessageSystem);
    HudElementRegistry.addLast(GEIGER_COUNTER_ID, GeigerCounterRender::drawGeigerCounter);
    HudElementRegistry.addLast(BLOCK_HOVER_TOOLTIP_ID, BlockHoverTooltipRender::drawBlockHoverTooltip);
  }
}
