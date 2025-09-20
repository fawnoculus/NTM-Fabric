package net.fawnoculus.ntm.render.wavefront.model;

import com.mojang.blaze3d.vertex.VertexFormat;
import net.fawnoculus.ntm.render.NTMRenderPipelines;
import net.fawnoculus.ntm.render.wavefront.GeometryVertex;
import net.fawnoculus.ntm.render.wavefront.Polygon;
import net.fawnoculus.ntm.render.wavefront.TextureCoordinate;
import net.fawnoculus.ntm.render.wavefront.VertexNormal;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.BakedSimpleModel;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public record SingleModel3d(List<Polygon> FACES) implements Model3d {

  public List<Polygon> getFaces() {
    return this.FACES;
  }

  public void draw(MatrixStack.Entry matrix, int light, Identifier texture) {
    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL);
    NTMRenderPipelines.draw(this.addToBuffer(matrix, light, buffer).end(), texture);
  }

  public BufferBuilder addToBuffer(MatrixStack.Entry matrix, int light, BufferBuilder buffer) {
    for (Polygon face : this.getFaces()) {
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

  public void setTexture(Identifier blockId){
    for (Polygon face : FACES) {
      face.setTexture(blockId);
    }
  }

  public void setTexture(SpriteIdentifier spriteIdentifier){
    for (Polygon face : FACES) {
      face.setTexture(spriteIdentifier);
    }
  }

  public List<BakedQuad> bake(Baker baker, BakedSimpleModel simpleModel) {
    List<BakedQuad> quads = new ArrayList<>();
    for (Polygon face : FACES) {
      quads.add(face.bake(baker, simpleModel));
    }
    return quads;
  }

  @Override
  public @NotNull String toString() {
    return "SingleModel3d{" +
      "FACES.size()=" + FACES.size() +
      ", FACES=" + FACES +
      '}';
  }
}
