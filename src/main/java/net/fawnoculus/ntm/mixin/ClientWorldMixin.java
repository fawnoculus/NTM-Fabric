package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.util.messages.MessageSystem;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class ClientWorldMixin {
  
  @Inject(at = @At("TAIL"), method = "disconnect")
  private void updateMessages(CallbackInfo ci) {
    MessageSystem.removeAllMessages();
  }
}
