package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.api.node.network.NodeNetworkManager;
import net.fawnoculus.ntm.api.radiation.RadiationManager;
import net.fawnoculus.ntm.api.radiation.processor.RadiationProcessor;
import net.fawnoculus.ntm.api.radiation.processor.RadiationProcessorMultiHolder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.profiling.Profiler;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.entity.EntityTickList;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;
import java.util.HashMap;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin implements RadiationProcessorMultiHolder {
    @Unique
    private final HashMap<ChunkPos, RadiationProcessor> radiationProcessors = new HashMap<>();
    @Shadow
    @Final
    EntityTickList entityTickList;

    @Shadow
    public abstract ServerLevel getLevel();

    @Shadow
    @NotNull
    public abstract MinecraftServer getServer();

    @Inject(at = @At("TAIL"), method = "tick")
    private void tickStuff(CallbackInfo ci) {
        if (this.getServer().tickRateManager().runsNormally()) {
            ProfilerFiller profiler = Profiler.get();

            profiler.push("[NTM] radiationManager");
            RadiationManager.tick(this.getLevel(), this.entityTickList);
            profiler.pop();

            profiler.push("[NTM] nodeNetworks");
            NodeNetworkManager.tickNetworks();
            profiler.pop();
        }
    }

    @Override
    public Collection<RadiationProcessor> NTM$getRadiationProcessors() {
        return radiationProcessors.values();
    }

    @Override
    public RadiationProcessor NTM$getRadiationProcessor(ChunkPos chunkPos) {
        return radiationProcessors.get(chunkPos);
    }

    @Override
    public void NTM$addRadiationProcessor(RadiationProcessor processor, ChunkPos chunkPos) {
        radiationProcessors.put(chunkPos, processor);
    }

    @Override
    public void NTM$removeRadiationProcessor(ChunkPos chunkPos) {
        radiationProcessors.remove(chunkPos);
    }
}
