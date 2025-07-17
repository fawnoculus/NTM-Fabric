package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.misc.data.CustomData;
import net.fawnoculus.ntm.misc.data.CustomDataHolder;
import net.fawnoculus.ntm.misc.radiation.processor.EmptyRadiationProcessor;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessor;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessorHolder;
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
  @Unique protected RadiationProcessor radiationProcessor = new EmptyRadiationProcessor(); // RadiationProcessors are set in WorldChunk
  @Unique protected CustomData customData = new CustomData();
  
  @Override
  public RadiationProcessor NTM$getRadiationProcessor() {
    return radiationProcessor;
  }
  
  @Override
  public @NotNull CustomData NTM$getCustomData() {
    return customData;
  }
  
  @Override
  public void NTM$setCustomData(CustomData customData) {
    this.customData = customData;
  }
}
