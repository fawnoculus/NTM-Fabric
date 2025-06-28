package net.fawnoculus.ntm.render;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;

public class ModWorldRender {
  public static void initialize(){
    WorldRenderEvents.AFTER_TRANSLUCENT.register(ModWorldRender::renderAdvancedModelBlocks);
  }
  
  public static void renderAdvancedModelBlocks(WorldRenderContext context){
  }
}
