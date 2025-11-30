package net.fawnoculus.ntm.client.render.hud;

import net.fawnoculus.ntm.api.tool.AbilityHandler;
import net.fawnoculus.ntm.api.tool.SpecialTool;
import net.fawnoculus.ntm.client.NTMClientConfig;
import net.fawnoculus.ntm.client.util.ClientUtil;
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

    private static boolean shouldDraw() {
        return ClientUtil.getClient() != null && ClientUtil.getPlayer() != null;
    }

    public static void drawToolAbility(DrawContext context, RenderTickCounter ignored) {
        if (!shouldDraw()) return;
        ItemStack stack = ClientUtil.getPlayer().getMainHandStack();
        if (!(stack.getItem() instanceof SpecialTool specialTool)) return;

        final int xOffset = NTMClientConfig.TOOL_ABILITY_DISPLAY_X_OFFSET.getValue();
        final int yOffset = NTMClientConfig.TOOL_ABILITY_DISPLAY_Y_OFFSET.getValue();

        AbilityHandler.Preset preset = specialTool.abilityHandler().getCurrentPreset(stack);

        int centerX = context.getScaledWindowWidth() / 2;
        int centerY = context.getScaledWindowHeight() / 2;

        Identifier top = preset.topAbility().getCrosshairExtension();
        if (top != null) {
            context.drawTexture(
              RenderPipelines.CROSSHAIR, top,
              centerX - WIDTH - xOffset,
              centerY + yOffset,
              0, 0,
              WIDTH, HEIGHT,
              TEXTURE_WIDTH, TEXTURE_HEIGHT
            );
        }

        Identifier bottom = preset.bottomAbility().getCrosshairExtension();
        if (bottom != null) {
            context.drawTexture(
              RenderPipelines.CROSSHAIR, bottom,
              centerX + xOffset,
              centerY + yOffset,
              0, 0,
              WIDTH, HEIGHT,
              TEXTURE_WIDTH, TEXTURE_HEIGHT
            );
        }
    }
}
