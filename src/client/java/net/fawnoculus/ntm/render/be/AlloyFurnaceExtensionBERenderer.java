package net.fawnoculus.ntm.render.be;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceExtensionBE;
import net.fawnoculus.ntm.render.ModModels;
import net.fawnoculus.ntm.render.models.Model3D;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class AlloyFurnaceExtensionBERenderer implements BlockEntityRenderer<AlloyFurnaceExtensionBE> {
  public AlloyFurnaceExtensionBERenderer(BlockEntityRendererFactory.Context context) {
  }
  
  public final static Model3D TOP = ModModels.ALLOY_FURNACE_EXTENSION.getOrThrow("Top", "");
  public final static Model3D SIDE = ModModels.ALLOY_FURNACE_EXTENSION.getOrThrow("Side", "");
  public final static Model3D BOTTOM = ModModels.ALLOY_FURNACE_EXTENSION.getOrThrow("Bottom", "");
  
  public final static Identifier TEXTURE_TOP = NTM.id("textures/block/alloy_furnace_top.png");
  public final static Identifier TEXTURE_SIDE = NTM.id("textures/block/alloy_furnace_extension.png");
  public final static Identifier TEXTURE_BOTTOM = NTM.id("textures/block/alloy_furnace_bottom.png");
  
  @Override
  public void render(AlloyFurnaceExtensionBE entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
    matrices.push();
    matrices.translate(0.5, 0, 0.5);
    TOP.draw(matrices.peek(), TEXTURE_TOP);
    SIDE.draw(matrices.peek(), TEXTURE_SIDE);
    BOTTOM.draw(matrices.peek(), TEXTURE_BOTTOM);
    matrices.pop();
  }
}
