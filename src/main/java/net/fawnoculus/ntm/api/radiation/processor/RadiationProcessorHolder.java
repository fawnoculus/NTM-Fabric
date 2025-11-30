package net.fawnoculus.ntm.api.radiation.processor;

import net.minecraft.world.chunk.WorldChunk;

public interface RadiationProcessorHolder {
    static RadiationProcessorHolder from(WorldChunk chunk) {
        return (RadiationProcessorHolder) chunk;
    }

    RadiationProcessor NTM$getRadiationProcessor();
}
