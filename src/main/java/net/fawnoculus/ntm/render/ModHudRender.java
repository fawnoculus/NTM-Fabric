package net.fawnoculus.ntm.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.render.hud.GeigerCounterRender;
import net.fawnoculus.ntm.render.hud.MessageSystemRender;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ModHudRender {
  public static final Identifier MESSAGE_SYSTEM_ID = NTM.id("message_system");
  public static final Identifier GEIGER_COUNTER_ID = NTM.id("geiger_counter");
  
  public static void initialize(){
    HudLayerRegistrationCallback.EVENT.register(layeredDrawer -> layeredDrawer.attachLayerBefore(IdentifiedLayer.HOTBAR_AND_BARS, MESSAGE_SYSTEM_ID, MessageSystemRender::drawMessageSystem));
    HudLayerRegistrationCallback.EVENT.register(layeredDrawer -> layeredDrawer.attachLayerBefore(IdentifiedLayer.HOTBAR_AND_BARS, GEIGER_COUNTER_ID, GeigerCounterRender::drawGeigerCounter));
  }
}
