package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.api.radiation.RadiationManager;
import net.fawnoculus.ntm.api.radiation.processor.EmptyRadiationProcessor;
import net.fawnoculus.ntm.api.radiation.processor.RadiationProcessor;
import net.fawnoculus.ntm.api.radiation.processor.RadiationProcessorHolder;
import net.fawnoculus.ntm.api.radiation.processor.RadiationProcessorMultiHolder;
import net.fawnoculus.ntm.misc.data.CustomDataHolder;
import net.fawnoculus.ntm.util.WorldUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.UpgradeData;
import net.minecraft.world.level.levelgen.blending.BlendingData;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.ticks.LevelChunkTicks;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LevelChunk.class)
public abstract class LevelChunkMixin implements RadiationProcessorHolder, CustomDataHolder {
    @Unique
    private RadiationProcessor NTM$radiationProcessor = new EmptyRadiationProcessor();

    @Shadow
    public abstract BlockState getBlockState(BlockPos pos);

    @Shadow
    public abstract Level getLevel();

    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/ChunkPos;Lnet/minecraft/world/level/chunk/UpgradeData;Lnet/minecraft/world/ticks/LevelChunkTicks;Lnet/minecraft/world/ticks/LevelChunkTicks;J[Lnet/minecraft/world/level/chunk/LevelChunkSection;Lnet/minecraft/world/level/chunk/LevelChunk$PostLoadProcessor;Lnet/minecraft/world/level/levelgen/blending/BlendingData;)V")
    private void addRadiationProcessor(
      Level world,
      ChunkPos pos,
      UpgradeData upgradeData,
      LevelChunkTicks<Block> levelChunkTicks,
      LevelChunkTicks<Fluid> levelChunkTicks2,
      long inhabitedTime,
      LevelChunkSection[] sectionArrayInitializer,
      LevelChunk.PostLoadProcessor entityLoader,
      BlendingData blendingData,
      CallbackInfo ci
    ) {
        if (world instanceof ServerLevel serverWorld) {
            this.NTM$radiationProcessor = RadiationManager.makeNewRadiationProcessor(serverWorld, pos);
            this.NTM$radiationProcessor.readData(WorldUtil.getChunkNBT(((ChunkAccess) (Object) this).getPos(), serverWorld));
            RadiationProcessorMultiHolder.from(serverWorld).NTM$addRadiationProcessor(this.NTM$radiationProcessor, pos);
        }
    }

    @Inject(at = @At("HEAD"), method = "setBlockState")
    private void updateChunkRadiation(BlockPos pos, BlockState state, int flags, CallbackInfoReturnable<BlockState> cir) {
        BlockState previous = this.getBlockState(pos);

        this.NTM$getRadiationProcessor().onChangeBlock(state, previous, pos);
    }

    @Override
    public @NotNull CompoundTag NTM$getCustomData() {
        if (this.getLevel() instanceof ServerLevel serverWorld) {
            return WorldUtil.getChunkNBT(((ChunkAccess) (Object) this).getPos(), serverWorld);
        }
        return new CompoundTag();
    }

    @Override
    public void NTM$setCustomData(CompoundTag customData) {
        if (this.getLevel() instanceof ServerLevel serverWorld) {
            WorldUtil.setChunkData(((ChunkAccess) (Object) this).getPos(), serverWorld, customData);
        }
    }

    @Override
    public RadiationProcessor NTM$getRadiationProcessor() {
        return this.NTM$radiationProcessor;
    }
}
