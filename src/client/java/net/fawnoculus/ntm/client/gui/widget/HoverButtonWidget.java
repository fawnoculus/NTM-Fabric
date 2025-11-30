package net.fawnoculus.ntm.client.gui.widget;

import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class HoverButtonWidget extends ClickableWidget {
    private final Identifier TEXTURE;
    private final int U;
    private final int V;
    private final int TEXTURE_WIDTH;
    private final int TEXTURE_HEIGHT;
    private final Runnable ON_CLICKED;

    public HoverButtonWidget(
      int x, int y,
      int width, int height,
      Text message, Identifier texture,
      int u, int v,
      int textureWidth, int textureHeight,
      Runnable onClicked
    ) {
        super(x, y, width, height, message);
        this.TEXTURE = texture;
        this.U = u;
        this.V = v;
        this.TEXTURE_WIDTH = textureWidth;
        this.TEXTURE_HEIGHT = textureHeight;
        this.ON_CLICKED = onClicked;
    }

    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        if (this.isHovered()) {
            context.drawTexture(
              RenderPipelines.GUI_TEXTURED, TEXTURE,
              this.getX(), this.getY(),
              this.U, this.V,
              this.width, this.height,
              TEXTURE_WIDTH, TEXTURE_HEIGHT
            );
        }
    }

    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {
    }

    @Override
    public void playDownSound(SoundManager soundManager) {
        soundManager.play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 0.5F));
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        ON_CLICKED.run();
    }
}
