package net.fawnoculus.ntm.api.radiation.processor;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;

import java.util.Collection;

public interface RadiationProcessorMultiHolder {
    static RadiationProcessorMultiHolder from(ServerWorld world) {
        return (RadiationProcessorMultiHolder) world;
    }

    Collection<RadiationProcessor> NTM$getRadiationProcessors();

    RadiationProcessor NTM$getRadiationProcessor(ChunkPos chunkPos);

    void NTM$addRadiationProcessor(RadiationProcessor processor, ChunkPos chunkPos);

    void NTM$removeRadiationProcessor(ChunkPos chunkPos);

    void NTM$removeRadiationProcessor(RadiationProcessor processor);
}
