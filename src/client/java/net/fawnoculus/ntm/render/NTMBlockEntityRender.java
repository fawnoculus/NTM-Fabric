package net.fawnoculus.ntm.render;

import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.render.be.AlloyFurnaceExtensionBERenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class NTMBlockEntityRender {
  public static void initialize() {
    BlockEntityRendererFactories.register(NTMBlockEntities.ALLOY_FURNACE_EXTENSION_BE, AlloyFurnaceExtensionBERenderer::new);
  }
}
