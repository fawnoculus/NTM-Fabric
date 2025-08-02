package net.fawnoculus.ntm.gui.area;

import net.fawnoculus.ntm.util.ClientUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface InfoArea {
  int getX();
  int getY();
  int getWidth();
  int getHeigh();
  int getOffsetX();
  int getOffsetY();
  
  void appendTooltip(Consumer<Text> tooltip);
  Identifier getTexture();
  @Range(from = 0, to = 1) double getFillState();
  
  default List<Text> getTooltip(){
    List<Text> tooltip = new ArrayList<>();
    this.appendTooltip(tooltip::add);
    return tooltip;
  }
  
  default int getRelativeMouseX(int mouseX){
    return mouseX - this.getOffsetX();
  }
  default int getRelativeMouseY(int mouseY){
    return mouseY - this.getOffsetY();
  }
  
  default boolean isInBounds(int mouseX, int mouseY){
    return this.getRelativeMouseX(mouseX) > this.getX()
        && this.getRelativeMouseX(mouseX) < this.getX() + this.getWidth()
        && this.getRelativeMouseY(mouseY) > this.getY()
        && this.getRelativeMouseY(mouseY) < this.getY() + this.getHeigh();
  }
  
  default void draw(DrawContext context, int mouseX, int mouseY){
    this.drawTooltip(context, mouseX, mouseY);
  }
  
  default void drawTooltip(DrawContext context, int mouseX, int mouseY){
    if(!isInBounds(mouseX, mouseY)) return;
    context.drawTooltip(ClientUtil.getTextRenderer(), this.getTooltip(), mouseX, mouseY);
  }
}
