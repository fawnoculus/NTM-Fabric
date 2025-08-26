package net.fawnoculus.ntm.gui.area;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public interface InfoBar extends InfoArea {
  int getU();

  int getV();

  int getTextureHeight();

  int getTextureWidth();

  @Nullable Identifier getTexture();

  @Range(from = 0, to = 1)
  double getFillState();

  @Override
  default void draw(DrawContext context, int mouseX, int mouseY) {
    InfoArea.super.draw(context, mouseX, mouseY);
    this.drawBar(context);
  }

  default void drawBar(DrawContext context) {
    if (this.getTexture() == null) return;

    int barSize = MathHelper.ceil(this.getFillState() * this.getHeigh());

    context.drawTexture(RenderLayer::getGuiTextured, this.getTexture(),
      this.getX() + this.getOffsetX(),
      this.getY() + this.getOffsetY() + this.getHeigh() - barSize,
      this.getU(),
      this.getV() + this.getHeigh() - barSize,
      this.getWidth(),
      barSize,
      this.getTextureWidth(),
      this.getTextureHeight()
    );
  }
}
