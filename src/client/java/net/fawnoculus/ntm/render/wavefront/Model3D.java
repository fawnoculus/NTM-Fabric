package net.fawnoculus.ntm.render.wavefront;

import com.mojang.blaze3d.vertex.VertexFormat;
import net.fawnoculus.ntm.render.NTMRenderPipelines;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record Model3D(List<PolygonalFace> FACES) {

  public List<PolygonalFace> getFaces() {
    return this.FACES;
  }

  public void draw(MatrixStack.Entry matrix, int light, Identifier texture) {
    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL);
    NTMRenderPipelines.draw(this.addToBuffer(matrix, light, buffer).end(), texture);
  }

  public BufferBuilder addToBuffer(MatrixStack.Entry matrix, int light, BufferBuilder buffer) {
    for (PolygonalFace face : this.getFaces()) {
      if (face.isInValid()) continue;

      for (int i = 0; i < 3; i++) {
        GeometryVertex vertex = face.vertices.get(i);
        TextureCoordinate coordinate = face.coordinates.get(i);
        VertexNormal normal = face.normals.get(i);
        if (normal != null) {
          buffer.vertex(matrix, vertex.X(), vertex.Y(), vertex.Z())
            .texture(1 - coordinate.getU(), 1 - coordinate.getV())
            .normal(normal.X(), normal.Y(), normal.Z())
            .light(light)
            .color(-1);
        } else {
          buffer.vertex(matrix, vertex.X(), vertex.Y(), vertex.Z())
            .texture(1 - coordinate.getU(), 1 - coordinate.getV())
            .light(light)
            .color(-1);
        }
      }
    }

    return buffer;
  }

  @Override
  public @NotNull String toString() {
    return "Model3D{" +
      "FACES.size()=" + FACES.size() +
      ", FACES=" + FACES +
      '}';
  }
}
