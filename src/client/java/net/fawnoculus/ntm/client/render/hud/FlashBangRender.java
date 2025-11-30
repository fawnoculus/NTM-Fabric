package net.fawnoculus.ntm.client.render.hud;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.math.ColorHelper;

// HELP I CANNOT SEE
// Doesn't actually render flash-bangs, it used for large explosions
public class FlashBangRender {
    private static final int OVERDRAW = 50;
    private static float decay = 0f;
    private static float alpha = 0f;

    public static void addFlash(float newAlpha, float newDecay) {
        alpha = Math.max(newAlpha, alpha);
        decay = Math.max(newDecay, decay);
    }

    public static void flashBang(DrawContext context, RenderTickCounter tickCounter) {
        context.fill(
          -OVERDRAW, -OVERDRAW,
          context.getScaledWindowWidth() + OVERDRAW + OVERDRAW, context.getScaledWindowHeight() + OVERDRAW + OVERDRAW,
          ColorHelper.fromFloats(Math.clamp(alpha, 0f, 1f),
            1f, 1f, 1f
          )
        );

        alpha -= decay * tickCounter.getTickProgress(true);

        if (alpha <= 0) {
            alpha = 0;
            decay = 0;
        }
    }
}
