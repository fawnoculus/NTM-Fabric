package net.fawnoculus.ntm.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.fawnoculus.ntm.util.messages.AdvancedMessage;
import net.fawnoculus.ntm.util.messages.MessageSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
  
  @Unique
  private long LastNanoTime = System.nanoTime();
  
  @Inject(at = @At("HEAD"), method = "render")
  private void renderAdvancedMessages(CallbackInfo ci) {
    List<AdvancedMessage> messageList = MessageSystem.getAllMessages();
    
    float deltaMillis = (float) ((System.nanoTime() - LastNanoTime) / 1000000);
    
    List<AdvancedMessage> toBeRemovedMessages = new ArrayList<>();
    for(AdvancedMessage message : messageList){
      float millisLeft = message.getMillisLeft();
      if(millisLeft < 0){
        toBeRemovedMessages.add(message);
        continue;
      }
      message.setMillisLeft(millisLeft - deltaMillis);
    }
    for(AdvancedMessage message : toBeRemovedMessages){
      MessageSystem.removeMessage(message.getID());
    }
    
    LastNanoTime = System.nanoTime();
  }
  
  /* I have no idea what i'm doing
  @Inject(at = @At("HEAD"), method = "render")
  private void renderAdvancedModelBlocks(CallbackInfo ci){
    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
    
    buffer.vertex(new Matrix4f(), 20, 20, 5).color(0xFF414141);
    
    buffer.end();
    
    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
  }
   */
}
