package net.fawnoculus.ntm.render.wavefront.model;

import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.SimpleModel;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.List;
import java.util.function.Function;

public interface Model3d {
  List<BakedQuad> bake(@NotNull Baker baker, SimpleModel simpleModel, Function<Vector3f, Vector3f> offset);
}
