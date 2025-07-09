package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.blocks.node.network.NodeNetworkManager;
import net.fawnoculus.ntm.world.radiation.processor.RadiationProcessor;
import net.fawnoculus.ntm.world.radiation.MultiRadiationProcessorHolder;
import net.fawnoculus.ntm.world.radiation.ServerRadiationManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.profiler.Profilers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin implements MultiRadiationProcessorHolder {
  @Shadow public abstract ServerWorld toServerWorld();
  @Unique private final List<RadiationProcessor> radiationProcessors = new ArrayList<>();
  
  @Inject(at = @At("TAIL"), method = "tick")
  private void tickNodeNetworks(CallbackInfo ci) {
    Profiler profiler = Profilers.get();
    
    profiler.push("nodeNetworks");
    NodeNetworkManager.tickNetworks();
    profiler.pop();
  }
  
  @Inject(at = @At("TAIL"), method = "tick")
  private void tickRadiationManager(CallbackInfo ci) {
    Profiler profiler = Profilers.get();
    
    profiler.push("radiationManager");
    ServerRadiationManager.getInstance().tick(this.toServerWorld());
    profiler.pop();
  }
  
  public List<RadiationProcessor> NTM$getRadiationProcessors(){
    return radiationProcessors;
  }
  public void NTM$addRadiationProcessors(RadiationProcessor processor){
    radiationProcessors.add(processor);
  }
  public void NTM$removeRadiationProcessors(RadiationProcessor processor){
    radiationProcessors.remove(processor);
  }
}
