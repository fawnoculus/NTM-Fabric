package net.fawnoculus.ntm.render.wavefront.model;

import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.SimpleModel;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Model3d {
  List<BakedQuad> bake(@NotNull Baker baker, SimpleModel simpleModel);
}
