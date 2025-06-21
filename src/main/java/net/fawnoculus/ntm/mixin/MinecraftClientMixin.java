package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.util.messages.AdvancedMessage;
import net.fawnoculus.ntm.util.messages.MessageSystem;
import net.minecraft.client.MinecraftClient;
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
  private void clearAllMessages(CallbackInfo ci) {
    List<AdvancedMessage> messageList = MessageSystem.getAllMessages();
    
    float deltaTick = (float) ((System.nanoTime() - LastNanoTime) / 50000000.0);
    
    List<AdvancedMessage> toBeRemovedMessages = new ArrayList<>();
    for(AdvancedMessage message : messageList){
      float ticksLeft = message.getTicksLeft();
      if(ticksLeft < 0){
        toBeRemovedMessages.add(message);
        continue;
      }
      message.setTicksLeft(ticksLeft - deltaTick);
    }
    for(AdvancedMessage message : toBeRemovedMessages){
      MessageSystem.removeMessage(message.getID());
    }
    
    LastNanoTime = System.nanoTime();
  }
}
