package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.api.events.custom.ServerSaveEvent;
import net.fawnoculus.ntm.api.events.custom.ServerShutdownEvent;
import net.fawnoculus.ntm.api.events.custom.ServerStartEvent;
import net.fawnoculus.ntm.api.events.custom.ServerTickEvent;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    @Unique
    long NTM$tickStartNano = Long.MIN_VALUE;

    @Inject(method = "<init>", at = @At(value = "CTOR_HEAD"))
    private void preServerStart(CallbackInfo ci) {
        ServerStartEvent.PRE_START.invoker().onStart((MinecraftServer) (Object) this);
    }

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    private void postStart(CallbackInfo ci) {
        ServerStartEvent.POST_START.invoker().onStart((MinecraftServer) (Object) this);
    }

    @Inject(at = @At("HEAD"), method = "tickChildren")
    private void preTick(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        NTM$tickStartNano = System.nanoTime();
        ServerTickEvent.PRE_TICK.invoker().onTick((MinecraftServer) (Object) this, shouldKeepTicking, NTM$tickStartNano);
    }

    @Inject(at = @At("TAIL"), method = "tickChildren")
    private void postTick(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        if (NTM$tickStartNano == Long.MIN_VALUE) {
            return;
        }

        ServerTickEvent.POST_TICK.invoker().onTick((MinecraftServer) (Object) this, shouldKeepTicking, NTM$tickStartNano);
    }

    @Inject(at = @At("HEAD"), method = "stopServer")
    private void preShutdown(CallbackInfo ci) {
        ServerShutdownEvent.PRE_SHUTDOWN.invoker().onSave((MinecraftServer) (Object) this);
    }

    @Inject(at = @At("TAIL"), method = "stopServer")
    private void postShutdown(CallbackInfo ci) {
        ServerShutdownEvent.POST_SHUTDOWN.invoker().onSave((MinecraftServer) (Object) this);
    }

    @Inject(at = @At("HEAD"), method = "saveAllChunks")
    private void preSave(boolean suppressLogs, boolean flush, boolean force, CallbackInfoReturnable<Boolean> cir) {
        ServerSaveEvent.PRE_SAVE.invoker().onSave((MinecraftServer) (Object) this, suppressLogs, flush, force);
    }

    @Inject(at = @At("TAIL"), method = "saveAllChunks")
    private void postSave(boolean suppressLogs, boolean flush, boolean force, CallbackInfoReturnable<Boolean> cir) {
        ServerSaveEvent.POST_SAVE.invoker().onSave((MinecraftServer) (Object) this, suppressLogs, flush, force);
    }
}
