package net.fawnoculus.ntm.mixin.client;

import net.fawnoculus.ntm.api.events.custom.ClientTickCallback;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

  @Inject(at = @At("HEAD"), method = "render")
  private void updateAdvancedMessages(CallbackInfo ci) {
    ClientTickCallback.EVENT.invoker().onTick((MinecraftClient) (Object) this);
  }
}
