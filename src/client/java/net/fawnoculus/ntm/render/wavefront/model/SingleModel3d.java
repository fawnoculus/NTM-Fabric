package net.fawnoculus.ntm.render.wavefront.model;

import net.fawnoculus.ntm.render.wavefront.Polygon;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.BakedSimpleModel;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public record SingleModel3d(List<Polygon> FACES) implements Model3d {

  public List<Polygon> getFaces() {
    return this.FACES;
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
