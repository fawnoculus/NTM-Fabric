package net.fawnoculus.ntm.gui.widget;

import net.fawnoculus.ntm.blocks.node.type.StorageNode;
import net.fawnoculus.ntm.render.resources.NTMTextures;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.screen.narration.NarrationPart;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class StorageModeWidget extends ClickableWidget {
  public StorageModeWidget(int x, int y, Text message, Supplier<StorageNode.StorageMode> storageMode, Runnable onClicked) {
    super(x, y, 18, 18, message);
    this.STORAGE_MODE = storageMode;
    this.ON_CLICKED = onClicked;
  }

  private final Supplier<StorageNode.StorageMode> STORAGE_MODE;
  private final Runnable ON_CLICKED;

  @Override
  public void onClick(double mouseX, double mouseY) {
    super.onClick(mouseX, mouseY);
    this.ON_CLICKED.run();
  }

  @Override
  protected void renderWidget(@NotNull DrawContext context, int mouseX, int mouseY, float deltaTicks) {
    context.drawTexture(RenderLayer::getGuiTextured,
        NTMTextures.GENERIC_STORAGE_MODE,
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
  private float getU(StorageNode.@NotNull StorageMode storageMode){
    return switch (storageMode){
      case None, Provide -> 18;
      default -> 0;
    };
  }
  @Contract(pure = true)
  private float getV(StorageNode.@NotNull StorageMode storageMode){
    return switch (storageMode){
      case None, Share -> 18;
      default -> 0;
    };
  }

  @Override
  protected void appendClickableNarrations(@NotNull NarrationMessageBuilder builder) {
    builder.put(NarrationPart.HINT, Text.translatable(this.STORAGE_MODE.get().translationKey));
  }
}
