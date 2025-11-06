package net.fawnoculus.ntm.mixin.client;

import net.fawnoculus.ntm.api.events.custom.ConnectToServerEvent;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkingHandlerMixin {
	@Inject(at = @At("TAIL"), method = "onGameJoin")
	private void updateVersionReceived(GameJoinS2CPacket packet, CallbackInfo ci) {
		ConnectToServerEvent.EVENT.invoker().onJoin((ClientPlayNetworkHandler) (Object) this, packet);
	}
}
