package net.fawnoculus.ntm.main;

import net.fabricmc.api.ClientModInitializer;
import net.fawnoculus.ntm.render.ModBlockEntityRenderer;
import net.fawnoculus.ntm.screen.ModHandledScreens;
import net.fawnoculus.ntm.screen.ModScreenHandlerType;
import net.minecraft.util.Identifier;

public class NTMClient implements ClientModInitializer {
  private static final Identifier EXAMPLE_LAYER = NTM.id("hud-example-layer");
  
  @Override
  public void onInitializeClient() {
    ModBlockEntityRenderer.initialize();
    ModScreenHandlerType.initialize();
    ModHandledScreens.initialize();
//    // Attach our rendering code to before the chat hud layer. Our layer will render right before the chat. The API will take care of z spacing and automatically add 200 after every layer.
//    HudLayerRegistrationCallback.EVENT.register(layeredDrawer -> layeredDrawer.attachLayerBefore(IdentifiedLayer.CHAT, EXAMPLE_LAYER, NTMClient::render));
  }
  
//  private static void render(DrawContext context, RenderTickCounter tickCounter) {
//    int color = 0xFFFF0000; // Red
//    int targetColor = 0xFF00FF00; // Green
//
//    // You can use the Util.getMeasuringTimeMs() function to get the current time in milliseconds.
//    // Divide by 1000 to get ticks.
//    double currentTime = Util.getMeasuringTimeMs() / 1000.0;
//
//    // "lerp" simply means "linear interpolation", which is a fancy way of saying "blend".
//    float lerpedAmount = MathHelper.abs(MathHelper.sin((float) currentTime));
//    int lerpedColor = ColorHelper.lerp(lerpedAmount, color, targetColor);
//
//    // Draw a square with the lerped color.
//    // x1, x2, y1, y2, z, color
//    context.fill(0, 0, 10, 10, 0, lerpedColor);
//  }
}
