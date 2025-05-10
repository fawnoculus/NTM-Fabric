package net.fawnoculus.ntm.render;

import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.render.blockentity.AlloyFurnaceRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ModBlockEntityRenderer {
  public static void initialize(){
    BlockEntityRendererFactories.register(ModBlockEntities.AlloyFurnaceBE, AlloyFurnaceRenderer::new);
  }
}
