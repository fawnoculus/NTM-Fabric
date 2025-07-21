package net.fawnoculus.ntm.render.hud;

import com.mojang.blaze3d.vertex.VertexFormat;
import net.fawnoculus.ntm.render.ModRenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix4f;

public class TestRender {
  private static float totalTickDelta = 0;
  
  public static void drawTest(DrawContext context, RenderTickCounter tickCounter) {
    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
    
    totalTickDelta += tickCounter.getTickProgress(true);
    
    MatrixStack matrices = context.getMatrices();
    matrices.push();
    /*
    float scaleAmount = MathHelper.sin(totalTickDelta / 10F) / 2F + 1.5F;
    matrices.scale(scaleAmount, scaleAmount, 1F);
     */
    float rotationAmount = totalTickDelta / 100F % 180;
    matrices.translate(20f, 20f, 0f);
    matrices.multiply(RotationAxis.POSITIVE_Z.rotation(rotationAmount));
    matrices.translate(-20f, -40f, 0f);
    
    Matrix4f transformationMatrix = matrices.peek().getPositionMatrix();
    matrices.pop();
    
    buffer.vertex(transformationMatrix, 20, 20, 5).color(ColorHelper.getArgb(150, 25, 175));
    buffer.vertex(transformationMatrix, 5, 40, 5).color(ColorHelper.getArgb(100, 25, 175));
    buffer.vertex(transformationMatrix, 35, 40, 5).color(ColorHelper.getArgb(100, 25, 175));
    buffer.vertex(transformationMatrix, 20, 60, 5).color(ColorHelper.getArgb(150, 25, 175));
    
    ModRenderPipelines.drawPositonColor(buffer.end());
  }
}
