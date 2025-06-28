package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.blocks.custom.node.network.NodeNetwork;
import net.fawnoculus.ntm.blocks.custom.node.network.NodeNetworkManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.profiler.Profilers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
  
  @Inject(at = @At("TAIL"), method = "tick")
  private void tickNodeNetworks(CallbackInfo ci) {
    Profiler profiler = Profilers.get();
    profiler.push("nodeNetwork");
    for(NodeNetwork<?> network : NodeNetworkManager.getAllNetworks()){
      network.tickNetwork();
    }
    profiler.pop();
  }
}
