package net.fawnoculus.ntm.render.hud;

import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.fawnoculus.ntm.api.messages.MessageSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;
import net.minecraft.util.math.ColorHelper;

import java.util.List;

public class MessageSystemRender {
  private static final int backgroundColor = ColorHelper.getArgb(150, 100, 100, 100);
  private static final int marginSide = 10;
  private static final int marginTop = 10;
  private static final int paddingSide = 5;
  private static final int paddingTop = 5;


  public static void drawMessageSystem(DrawContext context, RenderTickCounter ignored) {
    List<AdvancedMessage> messages = MessageSystem.getAllMessages();
    if (messages.isEmpty()) {
      return;
    }

    TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

    int width = 0;
    for (AdvancedMessage message : messages) {
      if (textRenderer.getWidth(message.getText()) > width) {
        width = textRenderer.getWidth(message.getText());
      }
    }
    int height = textRenderer.fontHeight * messages.size();

    context.fill(marginSide, marginTop, marginSide + (paddingSide * 2) + width, marginTop + (paddingTop * 2) + height, backgroundColor);

    for (int i = 0; i < messages.size(); i++) {
      Text text = messages.get(i).getText();
      context.drawText(textRenderer, text, marginSide + paddingSide, marginTop + paddingTop + (textRenderer.fontHeight * i), ColorHelper.getArgb(messages.get(i).getOpacity(), 256, 256, 256), true);
    }
  }
}
