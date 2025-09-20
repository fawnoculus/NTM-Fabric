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

public class MultiMultiModel3d implements Model3d {
  public final String NAME;
  public final HashMap<String, MultiModel3D> MODELS = new HashMap<>();

  public MultiMultiModel3d() {
    this("Empty");
  }

  public MultiMultiModel3d(String name) {
    this.NAME = name;
  }

  public void addModel(String objectName, String groupName, SingleModel3d singleModel3d) {
    if (!MODELS.containsKey(objectName)) {
      MODELS.put(objectName, new MultiModel3D(this.NAME + "#" + objectName));
    }

    MODELS.get(objectName).addModel(groupName, singleModel3d);
  }

  public void setTexture(Identifier blockId){
    for (MultiModel3D multiModel3D : MODELS.values()) {
      multiModel3D.setTexture(blockId);
    }
  }

  public void setTexture(SpriteIdentifier spriteIdentifier){
    for (MultiModel3D multiModel3D : MODELS.values()) {
      multiModel3D.setTexture(spriteIdentifier);
    }
  }


  public List<BakedQuad> bake(Baker baker, BakedSimpleModel simpleModel){
    List<BakedQuad> quads = new ArrayList<>();
    for (MultiModel3D multiModel3D : MODELS.values()) {
      quads.addAll(multiModel3D.bake(baker, simpleModel));
    }
    return quads;
  }

  public @Nullable MultiModel3D getNullable(String objectName) {
    return MODELS.get(objectName);
  }

  public @Nullable SingleModel3d getNullable(String objectName, String groupName) {
    MultiModel3D groupedModel = getNullable(objectName);
    if (groupedModel != null) {
      return groupedModel.getNullable(groupName);
    }
    return null;
  }

  public @NotNull MultiModel3D getOrThrow(String objectName) throws NoSuchElementException {
    if (MODELS.containsKey(objectName)) {
      return MODELS.get(objectName);
    }
    throw new NoSuchElementException("Could not get MultiModel3D '" + objectName + "' because it does not exist");
  }

  public @NotNull SingleModel3d getOrThrow(String objectName, String groupName) throws NoSuchElementException {
    return getOrThrow(objectName).getOrThrow(groupName);
  }
}
