package net.fawnoculus.ntm.util;

import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

public class RenderUtil {
	public static void drawVariableWidthRect(
	  DrawContext context, Identifier texture,
	  int x, int y,
	  int u, int v,
	  int height, int width,
	  int trueWidth,
	  int leftWidth, int rightWidth,
	  int textureWidth, int textureHeight
	) {
		// Make sure the width is not some bullshit
		width = Math.max(leftWidth + rightWidth, width);

		context.drawTexture(RenderPipelines.GUI_TEXTURED, texture, x, y, u, v, leftWidth, height, textureWidth, textureHeight);

		context.drawTexture(RenderPipelines.GUI_TEXTURED, texture, x + width - rightWidth, y, trueWidth - rightWidth, v, rightWidth, height, textureWidth, textureHeight);

		int trueMiddleWith = trueWidth - (leftWidth + rightWidth);
		int wantedMiddleWith = width - (leftWidth + rightWidth);
		for (int i = 0; i < wantedMiddleWith; i += trueMiddleWith) {
			context.drawTexture(
			  RenderPipelines.GUI_TEXTURED, texture,
			  x + leftWidth + i, y,
			  u + leftWidth, v,
			  Math.min(trueMiddleWith, wantedMiddleWith - i), height,
			  textureWidth, textureHeight
			);
		}
	}
}
