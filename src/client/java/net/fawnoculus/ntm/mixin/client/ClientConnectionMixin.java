package net.fawnoculus.ntm.mixin.client;

import net.fawnoculus.ntm.api.messages.MessageSystem;
import net.fawnoculus.ntm.network.ClientReceivedVersionHandler;
import net.minecraft.network.ClientConnection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public abstract class ClientConnectionMixin {
  @Inject(at = @At("TAIL"), method = "disconnect(Lnet/minecraft/network/DisconnectionInfo;)V")
  private void updateVersionHandler(CallbackInfo ci) {
    ClientReceivedVersionHandler.onDisconnect();
  }

  @Inject(at = @At("TAIL"), method = "disconnect(Lnet/minecraft/network/DisconnectionInfo;)V")
  private void removeMessages(CallbackInfo ci) {
    MessageSystem.removeAllMessages();
  }
}
