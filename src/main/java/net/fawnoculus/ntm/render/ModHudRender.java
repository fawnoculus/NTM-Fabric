package net.fawnoculus.ntm.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.util.messages.AdvancedMessage;
import net.fawnoculus.ntm.util.messages.MessageSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;

import java.util.List;

@Environment(EnvType.CLIENT)
public class ModHudRender {
  public static final Identifier MESSAGE_SYSTEM_ID = NTM.id("message_system");
  
  public static void initialize(){
    HudLayerRegistrationCallback.EVENT.register(MESSAGE_SYSTEM_ID, layeredDrawer -> layeredDrawer.attachLayerBefore(IdentifiedLayer.HOTBAR_AND_BARS, MESSAGE_SYSTEM_ID, ModHudRender::drawMessageSystem));
  }
  
  private static void drawMessageSystem(DrawContext context, RenderTickCounter tickCounter) {
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
