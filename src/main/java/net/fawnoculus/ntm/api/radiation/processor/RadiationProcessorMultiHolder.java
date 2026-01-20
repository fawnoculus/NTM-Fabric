package net.fawnoculus.ntm.api.radiation.processor;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;

import java.util.Collection;

public interface RadiationProcessorMultiHolder {
    static RadiationProcessorMultiHolder from(ServerLevel world) {
        return (RadiationProcessorMultiHolder) world;
    }

    Collection<RadiationProcessor> NTM$getRadiationProcessors();

    RadiationProcessor NTM$getRadiationProcessor(ChunkPos chunkPos);

    void NTM$addRadiationProcessor(RadiationProcessor processor, ChunkPos chunkPos);

    void NTM$removeRadiationProcessor(ChunkPos chunkPos);
}
