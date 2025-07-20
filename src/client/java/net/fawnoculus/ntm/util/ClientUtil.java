package net.fawnoculus.ntm.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.Window;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.resource.ReloadableResourceManagerImpl;
import net.minecraft.resource.ResourceReloader;

public class ClientUtil {
  public static MinecraftClient getClient(){
    return MinecraftClient.getInstance();
  }
  
  public static ClientPlayerEntity getPlayer(){
    return getClient().player;
  }
  
  public static ClientWorld getWorld(){
    return getClient().world;
  }
  
  public static Window getWindow(){
    return getClient().getWindow();
  }
  
  public static void onResourceReload(ResourceReloader reloader){
    ReloadableResourceManagerImpl resourceManager = (ReloadableResourceManagerImpl) getClient().getResourceManager();
    resourceManager.registerReloader(reloader);
  }
}
