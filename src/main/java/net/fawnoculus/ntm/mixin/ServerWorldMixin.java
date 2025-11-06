package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.api.node.network.NodeNetworkManager;
import net.fawnoculus.ntm.api.radiation.RadiationManager;
import net.fawnoculus.ntm.api.radiation.processor.RadiationProcessor;
import net.fawnoculus.ntm.api.radiation.processor.RadiationProcessorMultiHolder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.profiler.Profilers;
import net.minecraft.world.EntityList;
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

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin implements RadiationProcessorMultiHolder {
	@Shadow
	public abstract ServerWorld toServerWorld();

	@Shadow
	@Final
	EntityList entityList;

	@Shadow
	@NotNull
	public abstract MinecraftServer getServer();

	@Unique
	private final HashMap<ChunkPos, RadiationProcessor> radiationProcessors = new HashMap<>();
	@Unique
	private final HashMap<RadiationProcessor, ChunkPos> ChunkPositions = new HashMap<>();

	@Inject(at = @At("TAIL"), method = "tick")
	private void tickStuff(CallbackInfo ci) {
		if (this.getServer().getTickManager().shouldTick()) {
			Profiler profiler = Profilers.get();

			profiler.push("[NTM] radiationManager");
			RadiationManager.tick(this.toServerWorld(), this.entityList);
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
		ChunkPositions.put(processor, chunkPos);
	}

	@Override
	public void NTM$removeRadiationProcessor(ChunkPos chunkPos) {
		RadiationProcessor processor = radiationProcessors.get(chunkPos);
		ChunkPositions.remove(processor);
		radiationProcessors.remove(chunkPos);
	}

	@Override
	public void NTM$removeRadiationProcessor(RadiationProcessor processor) {
		ChunkPos chunkPos = ChunkPositions.get(processor);
		ChunkPositions.remove(processor);
		radiationProcessors.remove(chunkPos);
	}
}
