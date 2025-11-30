package net.fawnoculus.ntm.client.gui.area;

import net.fawnoculus.ntm.client.util.ClientUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface InfoArea extends Drawable {
    int getX();

    int getY();

    int getWidth();

    int getHeigh();

    int getOffsetX();

    int getOffsetY();

    void appendTooltip(Consumer<Text> tooltip);

    Identifier getTexture();

    @Range(from = 0, to = 1)
    double getFillState();

    default List<Text> getTooltip() {
        List<Text> tooltip = new ArrayList<>();
        this.appendTooltip(tooltip::add);
        return tooltip;
    }

    default int getRelativeMouseX(int mouseX) {
        return mouseX - this.getOffsetX();
    }

    default int getRelativeMouseY(int mouseY) {
        return mouseY - this.getOffsetY();
    }

    default boolean isInBounds(int mouseX, int mouseY) {
        return this.getRelativeMouseX(mouseX) > this.getX()
          && this.getRelativeMouseX(mouseX) < this.getX() + this.getWidth()
          && this.getRelativeMouseY(mouseY) > this.getY()
          && this.getRelativeMouseY(mouseY) < this.getY() + this.getHeigh();
    }

    default void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        this.drawTooltip(context, mouseX, mouseY);
    }

    default void drawTooltip(DrawContext context, int mouseX, int mouseY) {
        if (!isInBounds(mouseX, mouseY)) return;
        context.drawTooltip(ClientUtil.getTextRenderer(), this.getTooltip(), mouseX, mouseY);
    }
}
