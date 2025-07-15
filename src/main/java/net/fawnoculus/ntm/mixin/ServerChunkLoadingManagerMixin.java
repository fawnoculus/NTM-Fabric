package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessorMultiHolder;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.server.world.ServerChunkLoadingManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerChunkLoadingManager.class)
public class ServerChunkLoadingManagerMixin {
  
  @Inject(method = "tryUnloadChunk", at = @At("HEAD"))
  private void removeRadiationProcessor(long pos, ChunkHolder chunk, CallbackInfo ci){
    if(chunk.getWorldChunk() != null  && chunk.getWorldChunk().getWorld() instanceof ServerWorld world){
      RadiationProcessorMultiHolder.from(world).NTM$removeRadiationProcessors(
          new ChunkPos(pos)
      );
    }
  }
}
