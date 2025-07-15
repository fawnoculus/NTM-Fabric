package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.misc.data.CustomDataHolder;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessorMultiHolder;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.ProtoChunk;
import net.minecraft.world.chunk.UpgradeData;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.gen.chunk.BlendingData;
import net.minecraft.world.tick.ChunkTickScheduler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldChunk.class)
public class WorldChunkMixin extends ChunkMixin {
  @Inject(at = @At("TAIL"), method = "<init>(" +
      "Lnet/minecraft/world/World;" +
      "Lnet/minecraft/util/math/ChunkPos;" +
      "Lnet/minecraft/world/chunk/UpgradeData;" +
      "Lnet/minecraft/world/tick/ChunkTickScheduler;" +
      "Lnet/minecraft/world/tick/ChunkTickScheduler;" +
      "J[Lnet/minecraft/world/chunk/ChunkSection;" +
      "Lnet/minecraft/world/chunk/WorldChunk$EntityLoader;" +
      "Lnet/minecraft/world/gen/chunk/BlendingData;)V"
  )
  private void addRadiationProcessor(
      World world,
      ChunkPos pos,
      UpgradeData upgradeData,
      ChunkTickScheduler blockTickScheduler,
      ChunkTickScheduler fluidTickScheduler,
      long inhabitedTime,
      ChunkSection[] sectionArrayInitializer,
      WorldChunk.EntityLoader entityLoader,
      BlendingData blendingData,
      CallbackInfo ci
  ) {
    if(world instanceof ServerWorld serverWorld){
      RadiationProcessorMultiHolder.from(serverWorld).NTM$addRadiationProcessors(this.radiationProcessor, pos);
    }
  }
  
  @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/world/chunk/ProtoChunk;Lnet/minecraft/world/chunk/WorldChunk$EntityLoader;)V")
  private void getCustomData(ServerWorld world, ProtoChunk protoChunk, WorldChunk.EntityLoader entityLoader, CallbackInfo ci) {
    this.NTM$setCustomData(CustomDataHolder.from(protoChunk).NTM$getCustomData());
  }
}
