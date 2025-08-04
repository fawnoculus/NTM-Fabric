package net.fawnoculus.ntm.render.wavefront;

import org.jetbrains.annotations.NotNull;

public class VertexNormal {
  public final float X;
  public final float Y;
  public final float Z;

  public VertexNormal(@NotNull Float x, @NotNull Float y, @NotNull Float z){
    this.X = x;
    this.Y = y;
    this.Z = z;
  }
}
