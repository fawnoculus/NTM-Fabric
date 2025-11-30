package net.fawnoculus.ntm.client.mixin;

import net.fawnoculus.ntm.client.api.events.custom.OnMousePressedEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public abstract class MouseMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/InactivityFpsLimiter;onInput()V"), method = "onMouseButton", cancellable = true)
    private void onKeyPressed(long window, int button, int action, int mods, CallbackInfo ci) {
        boolean isCanceled = OnMousePressedEvent.EVENT.invoker().onButtonPressed(this.client, button, action, mods);
        if (isCanceled) {
            ci.cancel();
        }
    }
}
