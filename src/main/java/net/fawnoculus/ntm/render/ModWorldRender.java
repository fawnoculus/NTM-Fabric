package net.fawnoculus.ntm.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;

@Environment(EnvType.CLIENT)
public class ModWorldRender {
  public static void initialize(){
    WorldRenderEvents.AFTER_TRANSLUCENT.register(ModWorldRender::renderAdvancedModelBlocks);
  }
  
  public static void renderAdvancedModelBlocks(WorldRenderContext context){
  }
}
