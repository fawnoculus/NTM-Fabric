package net.fawnoculus.ntm.render.wavefront.model;


import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.BakedSimpleModel;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

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

  public List<BakedQuad> bake(Baker baker, BakedSimpleModel simpleModel){
    List<BakedQuad> quads = new ArrayList<>();
    for (SingleModel3d model3d : MODELS.values()) {
      quads.addAll(model3d.bake(baker, simpleModel));
    }
    return quads;
  }

  public @Nullable SingleModel3d getNullable(String groupName) {
    if (MODELS.containsKey(groupName)) {
      return MODELS.get(groupName);
    }
    return null;
  }

  public @NotNull SingleModel3d getOrThrow(String groupName) throws NoSuchElementException {
    if (MODELS.containsKey(groupName)) {
      return MODELS.get(groupName);
    }
    throw new NoSuchElementException("Could not get Model3d '" + groupName + "' because it does not exist");
  }
}
