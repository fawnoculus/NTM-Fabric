package net.fawnoculus.ntm.render;

import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.render.be.AlloyFurnaceExtensionBERenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ModBlockEntityRender {
  public static void initialize(){
    BlockEntityRendererFactories.register(ModBlockEntities.ALLOY_FURNACE_EXTENSION_BE, AlloyFurnaceExtensionBERenderer::new);
  }
}
