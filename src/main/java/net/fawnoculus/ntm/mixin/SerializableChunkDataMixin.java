package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.api.radiation.processor.RadiationProcessorHolder;
import net.fawnoculus.ntm.api.radiation.processor.RadiationProcessorMultiHolder;
import net.fawnoculus.ntm.util.WorldUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.storage.SerializableChunkData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SerializableChunkData.class)
public class SerializableChunkDataMixin {
    @Inject(at = @At("HEAD"), method = "copyOf")
    private static void saveChunkData(ServerLevel world, ChunkAccess chunk, CallbackInfoReturnable<SerializableChunkData> cir) {
        if (chunk instanceof LevelChunk worldChunk && worldChunk.getLevel() instanceof ServerLevel serverWorld) {

            CompoundTag nbt = WorldUtil.getChunkNBT(chunk.getPos(), serverWorld);
            ((RadiationProcessorHolder) chunk).NTM$getRadiationProcessor().writeData(nbt);
            WorldUtil.setChunkData(chunk.getPos(), serverWorld, nbt);

            RadiationProcessorMultiHolder.from(serverWorld).NTM$removeRadiationProcessor(chunk.getPos());
        }
    }
}
