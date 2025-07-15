package net.fawnoculus.ntm.mixin;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.network.custom.RadiationRegistryS2CPayload;
import net.fawnoculus.ntm.misc.radiation.RadiationRegistry;
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
  @Inject(method = "onPlayerConnect", at = @At("TAIL"))
  private void convertRadiationProcessor(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData, CallbackInfo ci){
    ServerPlayNetworking.send(player, new RadiationRegistryS2CPayload(RadiationRegistry.getInstance().serialize()));
  }
}
