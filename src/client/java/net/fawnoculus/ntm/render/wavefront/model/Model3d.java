package net.fawnoculus.ntm.render.wavefront.model;

import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.BakedSimpleModel;
import net.minecraft.client.render.model.Baker;

import java.util.List;

public interface Model3d {
  List<BakedQuad> bake(Baker baker, BakedSimpleModel simpleModel);
}
