package net.fawnoculus.ntm.render.be;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceExtensionBE;
import net.fawnoculus.ntm.render.models.Model3D;
import net.fawnoculus.ntm.render.models.ModelHandler;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class AlloyFurnaceExtensionBERenderer implements BlockEntityRenderer<AlloyFurnaceExtensionBE> {
  public AlloyFurnaceExtensionBERenderer(BlockEntityRendererFactory.Context context) {
  }
  
  public static Model3D MODEL = ModelHandler.ofWavefrontObj(NTM.id("models/obj/block/alloy_furnace_extension.obj"));
  public static Identifier TEXTURE = NTM.id("textures/obj/block/alloy_furnace_extension.png");
  
  @Override
  public void render(AlloyFurnaceExtensionBE entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
    matrices.push();
    matrices.translate(0.5, 0, 0.5);
    MODEL.draw(matrices.peek(), TEXTURE);
    matrices.pop();
  }
}
