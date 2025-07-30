package net.fawnoculus.ntm.render.model3d;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public class TextureCoordinate {
  @Range(from = 0, to = 1)
  public final float U;
  @Nullable @Range(from = 0, to = 1)
  public final Float V;
  @Nullable @Range(from = 0, to = 1)
  public final Float W;
  
  public TextureCoordinate(
      @NotNull @Range(from = 0, to = 1) Float u,
      @Nullable @Range(from = 0, to = 1) Float v,
      @Nullable @Range(from = 0, to = 1) Float w
  ){
    this.U = u;
    this.V = v;
    this.W = w;
  }
  
  public float getU() {
    return this.U;
  }
  
  public float getV() {
    if(this.V == null) return 0f;
    return this.V;
  }
  public float getW() {
    if(this.W == null) return 0f;
    return this.W;
  }
}
