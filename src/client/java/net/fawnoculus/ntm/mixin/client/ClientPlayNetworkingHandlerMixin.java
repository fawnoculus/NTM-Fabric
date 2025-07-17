package net.fawnoculus.ntm.mixin.client;

import net.fawnoculus.ntm.network.ClientReceivedVersionHandler;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkingHandlerMixin {
  @Inject(at = @At("TAIL"), method = "onGameJoin")
  private void updateVersionReceived(CallbackInfo ci) {
    ClientReceivedVersionHandler.onJoin();
  }
}
