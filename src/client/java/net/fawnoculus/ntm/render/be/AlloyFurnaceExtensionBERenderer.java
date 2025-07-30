package net.fawnoculus.ntm.render.be;

import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceExtensionBE;
import net.fawnoculus.ntm.render.NTMModelRender;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;

public class AlloyFurnaceExtensionBERenderer implements BlockEntityRenderer<AlloyFurnaceExtensionBE> {
  public AlloyFurnaceExtensionBERenderer(BlockEntityRendererFactory.Context context) {
  }
  
  @Override
  public void render(AlloyFurnaceExtensionBE entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
    matrices.push();
    matrices.translate(0.5, 0, 0.5);
    NTMModelRender.AlloyFurnaceExtension.render(matrices, light);
    matrices.pop();
  }
}
