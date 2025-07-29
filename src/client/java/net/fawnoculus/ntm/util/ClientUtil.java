package net.fawnoculus.ntm.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.Window;
import net.minecraft.client.world.ClientWorld;

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
  
  public static TextRenderer getTextRenderer(){
    return getClient().textRenderer;
  }
}
