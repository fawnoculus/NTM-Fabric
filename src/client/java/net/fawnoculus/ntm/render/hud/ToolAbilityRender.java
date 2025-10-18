package net.fawnoculus.ntm.render.hud;

import net.fawnoculus.ntm.items.custom.tools.AbilityHandler;
import net.fawnoculus.ntm.items.custom.tools.SpecialTool;
import net.fawnoculus.ntm.util.ClientUtil;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ToolAbilityRender {
  private static final int TEXTURE_WIDTH = 16;
  private static final int TEXTURE_HEIGHT = 16;
  private static final int WIDTH = 16;
  private static final int HEIGHT = 16;
  private static final int X_CROSSHAIR_OFFSET = 10;
  private static final int Y_CROSSHAIR_OFFSET = 10;

  private static boolean shouldDraw() {
    return ClientUtil.getClient() != null && ClientUtil.getPlayer() != null;
  }

  public static void drawToolAbility(DrawContext context, RenderTickCounter ignored) {
    if (!shouldDraw()) return;
    ItemStack stack = ClientUtil.getPlayer().getMainHandStack();
    if(!(stack.getItem() instanceof SpecialTool specialTool)) return;

    AbilityHandler.Preset preset = specialTool.getAbilities().getCurrentPreset(stack);

    int centerX = context.getScaledWindowWidth() / 2;
    int centerY = context.getScaledWindowHeight() / 2;

    Identifier top = preset.topAbility().getCrosshairExtension();
    if(top != null){
      context.drawTexture(
        RenderPipelines.CROSSHAIR, top,
        centerX - WIDTH - X_CROSSHAIR_OFFSET,
        centerY + Y_CROSSHAIR_OFFSET,
        0, 0,
        WIDTH, HEIGHT,
        TEXTURE_WIDTH, TEXTURE_HEIGHT
      );
    }

    Identifier bottom = preset.bottomAbility().getCrosshairExtension();
    if(bottom != null){
      context.drawTexture(
        RenderPipelines.CROSSHAIR, bottom,
        centerX + X_CROSSHAIR_OFFSET,
        centerY + Y_CROSSHAIR_OFFSET,
        0, 0,
        WIDTH, HEIGHT,
        TEXTURE_WIDTH, TEXTURE_HEIGHT
      );
    }
  }
}
