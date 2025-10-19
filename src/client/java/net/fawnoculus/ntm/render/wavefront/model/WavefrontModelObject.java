package net.fawnoculus.ntm.render.wavefront.model;

import net.fawnoculus.ntm.render.wavefront.Polygon;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.SimpleModel;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public record WavefrontModelObject(String name ,List<Polygon> polygons) implements Model3d {
  public void setTexture(Identifier blockId){
    for (Polygon face : polygons) {
      face.setTexture(blockId);
    }
  }

  public void setTexture(SpriteIdentifier spriteIdentifier){
    for (Polygon face : polygons) {
      face.setTexture(spriteIdentifier);
    }
  }

  public @NotNull List<BakedQuad> bake(@NotNull Baker baker, SimpleModel simpleModel) {
    List<BakedQuad> quads = new ArrayList<>();
    for (Polygon face : polygons) {
      quads.add(face.bake(baker, simpleModel));
    }
    return quads;
  }
}
