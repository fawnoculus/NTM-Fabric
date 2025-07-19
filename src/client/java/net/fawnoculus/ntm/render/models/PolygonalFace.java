package net.fawnoculus.ntm.render.models;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PolygonalFace {
  public List<GeometryVertex> vertices = new ArrayList<>();
  public List<TextureCoordinate> coordinates = new ArrayList<>();
  public List<@Nullable VertexNormal> normals = new ArrayList<>();
  
  public void addVertex(@NotNull GeometryVertex vertex){
    this.vertices.add(vertex);
  }
  public void addCoordinate(@NotNull TextureCoordinate coordinate){
    this.coordinates.add(coordinate);
  }
  public void addNormal(@Nullable VertexNormal normal){
    this.normals.add(normal);
  }
  
  public boolean isValid(){
    return vertices.size() == coordinates.size()
        && vertices.size() == normals.size();
  }
}
