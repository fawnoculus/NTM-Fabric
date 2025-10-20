package net.fawnoculus.ntm.render.wavefront.model;


import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.SimpleModel;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public record WavefrontModelGroup(String name, HashMap<String, WavefrontModelObject> models) implements Model3d {

  public void setTexture(Identifier blockId) {
    for (WavefrontModelObject model3d : models.values()) {
      model3d.setTexture(blockId);
    }
  }

  public void setTexture(SpriteIdentifier spriteIdentifier) {
    for (WavefrontModelObject model3d : models.values()) {
      model3d.setTexture(spriteIdentifier);
    }
  }

  public List<BakedQuad> bake(@NotNull Baker baker, SimpleModel simpleModel, Function<Vector3f, Vector3f> offset) {
    List<BakedQuad> quads = new ArrayList<>();
    for (WavefrontModelObject model3d : models.values()) {
      quads.addAll(model3d.bake(baker, simpleModel, offset));
    }
    return quads;
  }

  public Optional<WavefrontModelObject> get(String objectName) {
    return Optional.ofNullable(models.get(objectName));
  }
}
