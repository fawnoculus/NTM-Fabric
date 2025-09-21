package net.fawnoculus.ntm.render.wavefront.model;


import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.SimpleModel;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MultiModel3D implements Model3d {
  public final String NAME;
  public final HashMap<String, SingleModel3d> MODELS = new HashMap<>();

  public MultiModel3D(String name) {
    this.NAME = name;
  }

  public void addModel(String groupName, SingleModel3d singleModel3d) {
    MODELS.put(groupName, singleModel3d);
  }

  public void setTexture(Identifier blockId){
    for (SingleModel3d model3d : MODELS.values()) {
      model3d.setTexture(blockId);
    }
  }

  public void setTexture(SpriteIdentifier spriteIdentifier){
    for (SingleModel3d model3d : MODELS.values()) {
      model3d.setTexture(spriteIdentifier);
    }
  }

  public List<BakedQuad> bake(@NotNull Baker baker, SimpleModel simpleModel){
    List<BakedQuad> quads = new ArrayList<>();
    for (SingleModel3d model3d : MODELS.values()) {
      quads.addAll(model3d.bake(baker, simpleModel));
    }
    return quads;
  }

  public Optional<SingleModel3d> get(String objectName) {
    if (MODELS.containsKey(objectName)) {
      return Optional.of(MODELS.get(objectName));
    }
    return Optional.empty();
  }

  public @NotNull SingleModel3d getOrThrow(String groupName) throws NoSuchElementException {
    return get(groupName).orElseThrow();
  }
}
