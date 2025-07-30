package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.misc.data.CustomDataHolder;
import net.fawnoculus.ntm.misc.radiation.processor.EmptyRadiationProcessor;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessor;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessorHolder;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Chunk.class)
public class ChunkMixin implements RadiationProcessorHolder, CustomDataHolder {
  @Shadow @Final protected ChunkPos pos;
  @Unique protected RadiationProcessor NTM$radiationProcessor = new EmptyRadiationProcessor(); // RadiationProcessors are set in WorldChunk
  @Unique protected NbtCompound NTM$customData = new NbtCompound();
  
  @Override
  public RadiationProcessor NTM$getRadiationProcessor() {
    return NTM$radiationProcessor;
  }
  
  @Override
  public @NotNull NbtCompound NTM$getCustomData() {
    return NTM$customData;
  }
  
  @Override
  public void NTM$setCustomData(NbtCompound customData) {
    this.NTM$customData = customData;
  }
}
