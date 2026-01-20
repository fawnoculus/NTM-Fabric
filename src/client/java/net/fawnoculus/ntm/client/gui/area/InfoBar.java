package net.fawnoculus.ntm.client.gui.area;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

public interface InfoBar extends InfoArea {
    int getU();

    int getV();

    int getTextureHeight();

    int getTextureWidth();

    @Nullable Identifier getTexture();

    double getFillState();

    @Override
    default void render(GuiGraphics context, int mouseX, int mouseY, float deltaTicks) {
        InfoArea.super.render(context, mouseX, mouseY, deltaTicks);
        this.drawBar(context);
    }

    default void drawBar(GuiGraphics context) {
        if (this.getTexture() == null) return;

        int barSize = Mth.ceil(this.getFillState() * this.getHeigh());

        context.blit(RenderPipelines.GUI_TEXTURED, this.getTexture(),
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
