package net.fawnoculus.ntm.client.render;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.client.render.hud.*;
import net.minecraft.util.Identifier;

public class NTMHudRender {
	public static final Identifier HUD_WIGGLER = NTM.id("hud_wiggler");
	public static final Identifier TOLL_ABILITY_ID = NTM.id("tool_ability");
	public static final Identifier MESSAGE_SYSTEM_ID = NTM.id("message_system");
	public static final Identifier GEIGER_COUNTER_ID = NTM.id("geiger_counter");
	public static final Identifier BLOCK_HOVER_TOOLTIP_ID = NTM.id("block_hover_tooltip");
	public static final Identifier FLASH_BANG_ID = NTM.id("flash_bang");

	public static void initialize() {
		HudElementRegistry.addFirst(HUD_WIGGLER, HudWigglerRender::renderFlashBang);
		HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, FLASH_BANG_ID, FlashBangRender::flashBang);
		HudElementRegistry.attachElementAfter(VanillaHudElements.CROSSHAIR, TOLL_ABILITY_ID, ToolAbilityRender::drawToolAbility);
		HudElementRegistry.addLast(MESSAGE_SYSTEM_ID, MessageSystemRender::drawMessageSystem);
		HudElementRegistry.addLast(GEIGER_COUNTER_ID, GeigerCounterRender::drawGeigerCounter);
		HudElementRegistry.addLast(BLOCK_HOVER_TOOLTIP_ID, BlockHoverTooltipRender::drawBlockHoverTooltip);
	}
}
