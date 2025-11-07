package net.fawnoculus.ntm.client.render.hud;

import net.fawnoculus.ntm.blocks.custom.HoverTooltipBlock;
import net.fawnoculus.ntm.client.util.ClientUtil;
import net.minecraft.block.BlockState;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;

import java.util.List;

public class BlockHoverTooltipRender {
	private static boolean shouldDraw() {
		if (ClientUtil.getClient() == null) return false;
		if (ClientUtil.getPlayer() == null) return false;
		return ClientUtil.getTextRenderer() != null;
	}

	public static void drawBlockHoverTooltip(DrawContext context, RenderTickCounter ignored) {
		if (!shouldDraw()) return;
		ClientWorld world = ClientUtil.getWorld();

		if (!(ClientUtil.getClient().crosshairTarget instanceof BlockHitResult result)) return;
		if (result.getType() == HitResult.Type.MISS) return;

		BlockPos pos = result.getBlockPos();
		BlockState state = world.getBlockState(pos);
		if (!(state.getBlock() instanceof HoverTooltipBlock hoverTooltipBlock)) return;
		if (!hoverTooltipBlock.shouldDisplayTooltip(world, pos, state)) return;

		TextRenderer textRenderer = ClientUtil.getTextRenderer();
		List<Text> tooltip = hoverTooltipBlock.getTooltip(world, pos, state);

		int y = (context.getScaledWindowHeight() / 2) - (textRenderer.fontHeight * tooltip.size() / 2);
		final int x = context.getScaledWindowWidth() / 2 + 7;

		for (Text text : tooltip) {
			context.drawText(textRenderer, text, x, y, ColorHelper.getArgb(256, 256, 256), true);
			y += textRenderer.fontHeight;
		}
	}
}
