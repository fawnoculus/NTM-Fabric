package net.fawnoculus.ntm.mixin;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.fluid.data.FluidDataRegistry;
import net.fawnoculus.ntm.api.radiation.HazmatRegistry;
import net.fawnoculus.ntm.network.s2c.FluidDataRegistryPayload;
import net.fawnoculus.ntm.network.s2c.HazmatRegistryPayload;
import net.fawnoculus.ntm.network.s2c.NTMVersionPayload;
import net.fawnoculus.ntm.network.s2c.RadiationRegistryPayload;
import net.fawnoculus.ntm.api.radiation.RadiationRegistry;
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
  private void sendVersionPacket(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData, CallbackInfo ci){
    ServerPlayNetworking.send(player, new NTMVersionPayload(NTM.MOD_VERSION));
  }
  @Inject(method = "onPlayerConnect", at = @At("TAIL"))
  private void sendRadiationRegistry(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData, CallbackInfo ci){
    ServerPlayNetworking.send(player, new RadiationRegistryPayload(RadiationRegistry.getInstance().serialize()));
  }
  @Inject(method = "onPlayerConnect", at = @At("TAIL"))
  private void sendHazmatRegistry(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData, CallbackInfo ci){
    ServerPlayNetworking.send(player, new HazmatRegistryPayload(HazmatRegistry.getInstance().serialize()));
  }
  @Inject(method = "onPlayerConnect", at = @At("TAIL"))
  private void sendFluidDataRegistry(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData, CallbackInfo ci){
    ServerPlayNetworking.send(player, new FluidDataRegistryPayload(FluidDataRegistry.encodeAllFluidData()));
  }
}
