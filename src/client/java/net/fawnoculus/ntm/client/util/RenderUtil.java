package net.fawnoculus.ntm.client.util;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.model.geom.builders.UVPair;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import org.joml.Vector2fc;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

public class RenderUtil {
    public static void drawVariableWidthRect(
      GuiGraphics context, Identifier texture,
      int x, int y,
      int u, int v,
      int height, int width,
      int trueWidth,
      int leftWidth, int rightWidth,
      int textureWidth, int textureHeight
    ) {
        // Make sure the width is not some bullshit
        width = Math.max(leftWidth + rightWidth, width);

        context.blit(RenderPipelines.GUI_TEXTURED, texture, x, y, u, v, leftWidth, height, textureWidth, textureHeight);

        context.blit(RenderPipelines.GUI_TEXTURED, texture, x + width - rightWidth, y, trueWidth - rightWidth, v, rightWidth, height, textureWidth, textureHeight);

        int trueMiddleWith = trueWidth - (leftWidth + rightWidth);
        int wantedMiddleWith = width - (leftWidth + rightWidth);
        for (int i = 0; i < wantedMiddleWith; i += trueMiddleWith) {
            context.blit(
              RenderPipelines.GUI_TEXTURED, texture,
              x + leftWidth + i, y,
              u + leftWidth, v,
              Math.min(trueMiddleWith, wantedMiddleWith - i), height,
              textureWidth, textureHeight
            );
        }
    }

    public static BakedQuad makeQuad(
      ModelBaker.PartCache interner,
      Vector3fc[] corners,
      Vector2fc[] textureCords,
      int tintIndex,
      TextureAtlasSprite sprite,
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
          interner.vector(corners[0]),
          interner.vector(corners[1]),
          interner.vector(corners[2]),
          interner.vector(corners[3]),
          UVPair.pack(sprite.getU(textureCords[0].x()), sprite.getV(textureCords[0].y())),
          UVPair.pack(sprite.getU(textureCords[1].x()), sprite.getV(textureCords[1].y())),
          UVPair.pack(sprite.getU(textureCords[2].x()), sprite.getV(textureCords[2].y())),
          UVPair.pack(sprite.getU(textureCords[3].x()), sprite.getV(textureCords[3].y())),
          tintIndex,
          Objects.requireNonNullElse(direction, Direction.UP),
          sprite,
          shade,
          lightEmission
        );
    }
}
