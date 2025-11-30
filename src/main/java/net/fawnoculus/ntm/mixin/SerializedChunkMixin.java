package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.api.radiation.processor.RadiationProcessorHolder;
import net.fawnoculus.ntm.api.radiation.processor.RadiationProcessorMultiHolder;
import net.fawnoculus.ntm.util.WorldUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.SerializedChunk;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SerializedChunk.class)
public class SerializedChunkMixin {
    @Inject(at = @At("HEAD"), method = "fromChunk")
    private static void saveChunkData(ServerWorld world, Chunk chunk, CallbackInfoReturnable<SerializedChunk> cir) {
        if (chunk instanceof WorldChunk worldChunk && worldChunk.getWorld() instanceof ServerWorld serverWorld) {

            NbtCompound nbt = WorldUtil.getChunkNBT(chunk.getPos(), serverWorld);
            ((RadiationProcessorHolder) chunk).NTM$getRadiationProcessor().writeData(nbt);
            WorldUtil.setChunkData(chunk.getPos(), serverWorld, nbt);

            RadiationProcessorMultiHolder.from(serverWorld).NTM$removeRadiationProcessor(chunk.getPos());
        }
    }
}
