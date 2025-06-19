package net.fawnoculus.ntm.render.blockentity;

import net.fawnoculus.ntm.blocks.entities.RenderTestBE;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

public class RenderTestRenderer implements BlockEntityRenderer<RenderTestBE> {
  
  public RenderTestRenderer(BlockEntityRendererFactory.Context context) {
    this.textRenderer = context.getTextRenderer();
  }
  
  private final TextRenderer textRenderer;
  private Integer counter;
  private String value = "";
  
  @Override
  public void render(RenderTestBE entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
    matrices.push();
    matrices.translate(0.5, 1, 0.5);
    matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
    matrices.scale(1/18f, 1/18f, 1/18f);
    
    if(counter == null || counter < 1) {
      value = String.valueOf(textRenderer.random.nextInt());
      counter = 120;
    }
    counter--;
    
    String text = String.valueOf(value);
    float width = textRenderer.getWidth(text);

    textRenderer.draw(
        text,
        -width/2, -4f,
        0xffffff,
        false,
        matrices.peek().getPositionMatrix(),
        vertexConsumers,
        TextRenderer.TextLayerType.SEE_THROUGH,
        0,
        light
    );
  }
}
