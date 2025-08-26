package net.fawnoculus.ntm.render.wavefront;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public record TextureCoordinate(@Range(from = 0, to = 1) float U, @Nullable @Range(from = 0, to = 1) Float V) {

  public float getU() {
    return this.U;
  }

  public float getV() {
    if (this.V == null) return 0f;
    return this.V;
  }
}
