package net.fawnoculus.ntm.render.model3d;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GeometryVertex {
  public final float X;
  public final float Y;
  public final float Z;
  
  public GeometryVertex(@NotNull Float x, @NotNull Float y, @NotNull Float z, @Nullable Float w){
    this(w != null ? x/w : x, w != null ? y/w : y, w != null ? z/w : z);
  }
  public GeometryVertex(@NotNull Float x, @NotNull Float y, @NotNull Float z){
    this.X = x;
    this.Y = y;
    this.Z = z;
  }
}
