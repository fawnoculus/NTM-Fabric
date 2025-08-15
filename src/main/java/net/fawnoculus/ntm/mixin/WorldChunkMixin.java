package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.misc.data.CustomDataHolder;
import net.fawnoculus.ntm.misc.radiation.RadiationManager;
import net.fawnoculus.ntm.misc.radiation.processor.EmptyRadiationProcessor;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessor;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessorHolder;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessorMultiHolder;
import net.fawnoculus.ntm.util.WorldUtil;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.chunk.BlendingData;
import net.minecraft.world.tick.ChunkTickScheduler;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldChunk.class)
public abstract class WorldChunkMixin implements RadiationProcessorHolder, CustomDataHolder {
  @Shadow public abstract BlockState getBlockState(BlockPos pos);
  @Shadow public abstract World getWorld();
  @Unique private RadiationProcessor NTM$radiationProcessor = new EmptyRadiationProcessor();

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
  @SuppressWarnings("rawtypes")
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
      this.NTM$radiationProcessor = RadiationManager.getInstance().makeNewRadiationProcessor(serverWorld, pos);
      this.NTM$radiationProcessor.readData(WorldUtil.getChunkNBT(((Chunk) (Object) this).getPos(), serverWorld));
      RadiationProcessorMultiHolder.from(serverWorld).NTM$addRadiationProcessor(this.NTM$radiationProcessor, pos);
    }
  }

  @Inject(at = @At("HEAD"), method = "setBlockState")
  private void updateChunkRadiation(BlockPos pos, BlockState state, int flags, CallbackInfoReturnable<BlockState> cir) {
    BlockState previous = this.getBlockState(pos);

    this.NTM$getRadiationProcessor().onChangeBlock(state, previous, pos);
  }

  @Override
  public @NotNull NbtCompound NTM$getCustomData() {
    if(this.getWorld() instanceof ServerWorld serverWorld){
      return WorldUtil.getChunkNBT(((Chunk) (Object) this).getPos(), serverWorld);
    }
    return new NbtCompound();
  }

  @Override
  public void NTM$setCustomData(NbtCompound customData) {
    if(this.getWorld() instanceof ServerWorld serverWorld){
      WorldUtil.setChunkData(((Chunk) (Object) this).getPos(), serverWorld, customData);
    }
  }

  @Override
  public RadiationProcessor NTM$getRadiationProcessor() {
    return this.NTM$radiationProcessor;
  }
}
