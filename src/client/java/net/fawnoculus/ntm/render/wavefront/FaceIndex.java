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

  public PolygonalFace toFace(List<GeometryVertex> vertices, List<TextureCoordinate> coordinates, List<VertexNormal> vertexNormals) {
    PolygonalFace polygonalFace = new PolygonalFace();

    for (Integer index : vertexIndexes) {
      if (index < 0) {
        polygonalFace.addVertex(vertices.get(vertices.size() + index));
        continue;
      }
      polygonalFace.addVertex(vertices.get(index));
    }
    for (Integer index : coordinateIndexes) {
      if (index == null) {
        polygonalFace.addCoordinate(new TextureCoordinate(0f, 0f));
        continue;
      }
      if (index < 0) {
        polygonalFace.addCoordinate(coordinates.get(coordinates.size() + index));
        continue;
      }
      polygonalFace.addCoordinate(coordinates.get(index));
    }
    for (Integer index : normalIndexes) {
      if (index == null) {
        polygonalFace.addNormal(null);
        continue;
      }
      if (index < 0) {
        polygonalFace.addNormal(vertexNormals.get(coordinates.size() + index));
        continue;
      }
      polygonalFace.addNormal(vertexNormals.get(index));
    }

    return polygonalFace;
  }
}
