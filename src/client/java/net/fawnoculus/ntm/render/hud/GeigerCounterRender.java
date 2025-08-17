package net.fawnoculus.ntm.render.hud;

import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.render.resources.NTMTextures;
import net.fawnoculus.ntm.util.ClientUtil;
import net.fawnoculus.ntm.util.PlayerUtil;
import net.fawnoculus.ntm.api.radiation.ClientRadiationManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;

public class GeigerCounterRender {
  private static final Identifier TEXTURE = NTMTextures.GEIGER_COUNTER_HUD;
  private static final int THRESHOLD_1 =  10_000;
  private static final int THRESHOLD_2 =  50_000;
  private static final int THRESHOLD_3 = 100_000;
  private static final int COLOR = ColorHelper.getArgb(256, 256, 256);

  private static boolean shouldDraw(){
    if(ClientUtil.getClient() == null) return false;
    if(ClientUtil.getPlayer() == null) return false;
    return PlayerUtil.hasItem(ClientUtil.getPlayer(), NTMItems.GEIGER_COUNTER);
  }

  public static void drawGeigerCounter(DrawContext context, RenderTickCounter tickCounter) {
    if(!shouldDraw()) return;

    final int x = 5;
    final int y = context.getScaledWindowHeight() - 20;


    ClientRadiationManager radiationManager = ClientRadiationManager.getInstance();
    final double radPercentage = radiationManager.radiationExposure / 1000000;
    final double incomingMilliRads = radiationManager.totalRadiation;

    context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x, y, 0, 0, 94, 18, 128, 128);
    context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x+1, y+1, 1, 19, (int) (radPercentage*73), 16, 128, 128);

    if(incomingMilliRads >= THRESHOLD_1){
      int u = 0;
      if(incomingMilliRads >= THRESHOLD_2){
        u += 18;
      }
      if(incomingMilliRads >= THRESHOLD_3){
        u += 18;
      }
      context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x+76, y-18, u, 36, 18, 18, 128, 128);
    }
    if(incomingMilliRads > 0){
      String rads = String.valueOf(Math.round(incomingMilliRads / 1000.0));
      if(incomingMilliRads < 1000){
        rads = "<1";
      }

      TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
      Text text = Text.translatable("generic.ntm.radiation.rad_s", rads).formatted(Formatting.RED);
      context.drawText(textRenderer, text, x + 2, y - textRenderer.fontHeight, COLOR, true);
    }
  }
}
