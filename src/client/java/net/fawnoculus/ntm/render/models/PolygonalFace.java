package net.fawnoculus.ntm.render.models;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PolygonalFace {
  public final List<GeometryVertex> vertices = new ArrayList<>();
  public final List<TextureCoordinate> coordinates = new ArrayList<>();
  public final List<@Nullable VertexNormal> normals = new ArrayList<>();
  
  public void addVertex(@NotNull GeometryVertex vertex){
    this.vertices.add(vertex);
  }
  public void addCoordinate(TextureCoordinate coordinate){
    this.coordinates.add(coordinate);
  }
  public void addNormal(@Nullable VertexNormal normal){
    this.normals.add(normal);
  }
  
  public boolean isInValid(){
    return vertices.size() != 3
        || coordinates.size() != 3
        || normals.size() != 3;
  }
  
  @Override
  public String toString() {
    return "PolygonalFace{" +
        "vertices=" + vertices +
        ", coordinates=" + coordinates +
        ", normals=" + normals +
        '}';
  }
}
