package net.fawnoculus.ntm.client.mixin;

import net.fawnoculus.ntm.client.api.events.custom.ConnectToServerEvent;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public abstract class ClientPlayNetworkingHandlerMixin {
    @Inject(at = @At("TAIL"), method = "handleLogin")
    private void updateVersionReceived(ClientboundLoginPacket packet, CallbackInfo ci) {
        ConnectToServerEvent.EVENT.invoker().onJoin((ClientPacketListener) (Object) this, packet);
    }
}
