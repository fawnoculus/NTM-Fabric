package net.fawnoculus.ntm.client.gui.widget;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.node.StorageMode;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.screen.narration.NarrationPart;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class StorageModeWidget extends ClickableWidget {
    private static final Identifier TEXTURE = NTM.id("textures/gui/generic/storage_mode.png");
    private final Supplier<StorageMode> STORAGE_MODE;
    private final Runnable ON_CLICKED;

    public StorageModeWidget(int x, int y, Text message, Supplier<StorageMode> storageMode, Runnable onClicked) {
        super(x, y, 18, 18, message);
        this.STORAGE_MODE = storageMode;
        this.ON_CLICKED = onClicked;
    }

    @Override
    public void onClick(Click click, boolean doubled) {
        super.onClick(click, doubled);
        this.ON_CLICKED.run();
    }

    @Override
    protected void renderWidget(@NotNull DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        context.drawTexture(RenderPipelines.GUI_TEXTURED,
          TEXTURE,
          this.getX(),
          this.getY(),
          this.getU(STORAGE_MODE.get()),
          this.getV(STORAGE_MODE.get()),
          this.width,
          this.height,
          36,
          36
        );
    }

    @Contract(pure = true)
    private float getU(@NotNull StorageMode storageMode) {
        return switch (storageMode) {
            case None, Provide -> 18;
            default -> 0;
        };
    }

    @Contract(pure = true)
    private float getV(@NotNull StorageMode storageMode) {
        return switch (storageMode) {
            case None, Share -> 18;
            default -> 0;
        };
    }

    @Override
    protected void appendClickableNarrations(@NotNull NarrationMessageBuilder builder) {
        builder.put(NarrationPart.HINT, Text.translatable(this.STORAGE_MODE.get().translationKey));
    }
}
