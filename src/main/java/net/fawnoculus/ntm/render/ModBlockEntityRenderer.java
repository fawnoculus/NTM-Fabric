package net.fawnoculus.ntm.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.render.blockentity.RenderTestRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

@Environment(EnvType.CLIENT)
public class ModBlockEntityRenderer {
  public static void initialize(){
    BlockEntityRendererFactories.register(ModBlockEntities.RENDER_TEST_BE, RenderTestRenderer::new);
  }
}
