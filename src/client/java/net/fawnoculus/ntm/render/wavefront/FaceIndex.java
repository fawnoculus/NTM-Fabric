package net.fawnoculus.ntm.render.wavefront;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FaceIndex {
  public final List<Integer> vertexIndexes = new ArrayList<>();
  public final List<Integer> coordinateIndexes = new ArrayList<>();
  public final List<Integer> normalIndexes = new ArrayList<>();

  public FaceIndex(
    @NotNull Collection<Integer> vertexIndices,
    @NotNull Collection<Integer> coordinateIndices,
    @NotNull Collection<Integer> normalIndices
  ) {
    this.vertexIndexes.addAll(vertexIndices);
    this.coordinateIndexes.addAll(coordinateIndices);
    this.normalIndexes.addAll(normalIndices);
  }

  public Polygon toFace(List<GeometryVertex> vertices, List<TextureCoordinate> coordinates, List<VertexNormal> vertexNormals) {
    Polygon polygon = new Polygon();

    for (Integer index : vertexIndexes) {
      if (index < 0) {
        polygon.addVertex(vertices.get(vertices.size() + index));
        continue;
      }
      polygon.addVertex(vertices.get(index));
    }
    for (Integer index : coordinateIndexes) {
      if (index == null) {
        polygon.addCoordinate(new TextureCoordinate(0f, 0f));
        continue;
      }
      if (index < 0) {
        polygon.addCoordinate(coordinates.get(coordinates.size() + index));
        continue;
      }
      polygon.addCoordinate(coordinates.get(index));
    }
    for (Integer index : normalIndexes) {
      if (index == null) {
        polygon.addNormal(null);
        continue;
      }
      if (index < 0) {
        polygon.addNormal(vertexNormals.get(coordinates.size() + index));
        continue;
      }
      polygon.addNormal(vertexNormals.get(index));
    }

    return polygon;
  }
}
