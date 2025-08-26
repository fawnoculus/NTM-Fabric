package net.fawnoculus.ntm.render.wavefront;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record GeometryVertex(float X, float Y, float Z) {
  public GeometryVertex(@NotNull Float x, @NotNull Float y, @NotNull Float z, @Nullable Float w) {
    this(w != null ? x / w : x, w != null ? y / w : y, w != null ? z / w : z);
  }
}
