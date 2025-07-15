package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.misc.data.CustomData;
import net.fawnoculus.ntm.misc.data.CustomDataHolder;
import net.fawnoculus.ntm.misc.radiation.RadiationManager;
import net.fawnoculus.ntm.misc.radiation.processor.EmptyRadiationProcessor;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessor;
import net.fawnoculus.ntm.misc.radiation.processor.RadiationProcessorHolder;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.UpgradeData;
import net.minecraft.world.gen.chunk.BlendingData;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Chunk.class)
public class ChunkMixin implements RadiationProcessorHolder, CustomDataHolder {
  @Shadow @Final protected ChunkPos pos;
  @Unique protected RadiationProcessor radiationProcessor = new EmptyRadiationProcessor();
  @Unique protected CustomData customData = new CustomData();
  
  @Inject(at = @At("TAIL"), method = "<init>")
  private void addRadiationProcessor(ChunkPos pos, UpgradeData upgradeData, HeightLimitView heightLimitView, Registry biomeRegistry, long inhabitedTime, ChunkSection[] sectionArray, BlendingData blendingData, CallbackInfo ci) {
    this.radiationProcessor = RadiationManager.getInstance().makeNewRadiationProcessor(pos);
  }
  
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
