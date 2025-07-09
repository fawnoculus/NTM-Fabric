package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.util.data.CustomData;
import net.fawnoculus.ntm.util.data.CustomDataHolder;
import net.fawnoculus.ntm.world.radiation.MultiRadiationProcessorHolder;
import net.fawnoculus.ntm.world.radiation.RadiationProcessorHolder;
import net.fawnoculus.ntm.world.radiation.ServerRadiationManager;
import net.fawnoculus.ntm.world.radiation.processor.EmptyRadiationProcessor;
import net.fawnoculus.ntm.world.radiation.processor.RadiationProcessor;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.UpgradeData;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.gen.chunk.BlendingData;
import net.minecraft.world.tick.ChunkTickScheduler;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
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
      MultiRadiationProcessorHolder.from(serverWorld).NTM$addRadiationProcessors(this.radiationProcessor, pos);
    }
  }
}
