package net.fawnoculus.ntm.client.util;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.joml.Vector2fc;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

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

    public static BakedQuad makeQuad(
      Baker.Vec3fInterner interner,
      Vector3fc[] corners,
      Vector2fc[] textureCords,
      int tintIndex,
      Sprite sprite,
      @Nullable Direction direction,
      boolean shade,
      int lightEmission
    ) {
        if (corners.length != 4) {
            if (NTMConfig.DEV_MODE.getValue()) {
                NTM.LOGGER.warn("Tried to bake Quad with invalid amount of Corners");
            }
            return null;
        }

        if (textureCords.length != 4) {
            if (NTMConfig.DEV_MODE.getValue()) {
                NTM.LOGGER.warn("Tried to bake Quad with invalid amount of Texture Coordinates");
            }
            return null;
        }

        return new BakedQuad(
          interner.intern(corners[0]),
          interner.intern(corners[1]),
          interner.intern(corners[2]),
          interner.intern(corners[3]),
          Vector2f.toLong(sprite.getFrameU(textureCords[0].x()), sprite.getFrameV(textureCords[0].y())),
          Vector2f.toLong(sprite.getFrameU(textureCords[1].x()), sprite.getFrameV(textureCords[1].y())),
          Vector2f.toLong(sprite.getFrameU(textureCords[2].x()), sprite.getFrameV(textureCords[2].y())),
          Vector2f.toLong(sprite.getFrameU(textureCords[3].x()), sprite.getFrameV(textureCords[3].y())),
          tintIndex,
          Objects.requireNonNullElse(direction, Direction.UP),
          sprite,
          shade,
          lightEmission
        );
    }
}
