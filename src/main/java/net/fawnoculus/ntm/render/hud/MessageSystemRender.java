package net.fawnoculus.ntm.render.hud;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fawnoculus.ntm.misc.messages.AdvancedMessage;
import net.fawnoculus.ntm.misc.messages.MessageSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;
import net.minecraft.util.math.ColorHelper;

import java.util.List;

@Environment(EnvType.CLIENT)
public class MessageSystemRender {
  public static void drawMessageSystem(DrawContext context, RenderTickCounter tickCounter) {
    List<AdvancedMessage> messages = MessageSystem.getAllMessages();
    if(messages.isEmpty()) {
      return;
    }
    int backgroundColor = ColorHelper.getArgb(150, 100, 100, 100);
    int marginSide = 10;
    int marginTop = 10;
    int paddingSide = 5;
    int paddingTop = 5;
    
    TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
    
    int width = 0;
    for(AdvancedMessage message : messages){
      if(textRenderer.getWidth(message.getText()) > width){
        width = textRenderer.getWidth(message.getText());
      }
    }
    int height = textRenderer.fontHeight * messages.size();
    
    context.fill(marginSide, marginTop, marginSide + (paddingSide*2) + width, marginTop + (paddingTop*2) + height, 0, backgroundColor);
    
    for(int i = 0; i < messages.size(); i++){
      Text text = messages.get(i).getText();
      context.drawText(textRenderer, text, marginSide + paddingSide, marginTop + paddingTop + (textRenderer.fontHeight * i), ColorHelper.getArgb(messages.get(i).getOpacity(), 256, 256, 256) , true);
    }
  }
}
