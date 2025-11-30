package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.api.events.custom.PlayerJoinCallback;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ConnectedClientData;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public abstract class PlayerManagerMixin {
    @Inject(method = "onPlayerConnect", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;getGameRules()Lnet/minecraft/world/GameRules;", shift = At.Shift.AFTER))
    private void sendVersionPacket(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData, CallbackInfo ci) {
        PlayerJoinCallback.EARLY.invoker().onJoin(connection, player, clientData);
    }

    @Inject(method = "onPlayerConnect", at = @At("TAIL"))
    private void playerJoinEvent(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData, CallbackInfo ci) {
        PlayerJoinCallback.LATE.invoker().onJoin(connection, player, clientData);
    }
}
