package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.util.config.PerWorldConfigFile;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.storage.LevelStorage;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.file.Path;
import java.util.List;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
  @Shadow @Final protected LevelStorage.Session session;
  
  @Inject(at = @At("TAIL"), method = "<init>")
  private void createWorldSpecificConfig(CallbackInfo ci) {
    List<PerWorldConfigFile> perWorldConfigFiles = PerWorldConfigFile.getPerWorldConfigFiles();
    Path worldConfigDir = this.session.getDirectory().path().resolve("data");
    
    for(PerWorldConfigFile configFile : perWorldConfigFiles){
      configFile.setConfigPath(worldConfigDir);
    }
  }
  
  @Inject(at = @At("TAIL"), method = "shutdown")
  private void removeWorldSpecificConfig(CallbackInfo ci) {
    List<PerWorldConfigFile> perWorldConfigFiles = PerWorldConfigFile.getPerWorldConfigFiles();
    
    for(PerWorldConfigFile configFile : perWorldConfigFiles){
      configFile.removeConfigPath();
    }
  }
  
}
