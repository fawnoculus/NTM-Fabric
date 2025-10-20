package net.fawnoculus.ntm.render.wavefront.model;

import net.fawnoculus.ntm.render.wavefront.Polygon;
import net.fawnoculus.ntm.render.wavefront.Polygon.GeometryVertex;
import net.fawnoculus.ntm.render.wavefront.Polygon.TextureCoordinate;
import net.fawnoculus.ntm.render.wavefront.Polygon.VertexNormal;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.SimpleModel;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public record WavefrontModel(String name, HashMap<String, WavefrontModelGroup> models) implements Model3d {
  public static final WavefrontModel EMPTY = new WavefrontModel("Empty", new HashMap<>());

  public static Builder builder(String name){
    return new Builder(name);
  }

  public void setTexture(Identifier blockId){
    for (WavefrontModelGroup wavefrontModelGroup : models.values()) {
      wavefrontModelGroup.setTexture(blockId);
    }
  }

  public void setTexture(SpriteIdentifier spriteIdentifier){
    for (WavefrontModelGroup wavefrontModelGroup : models.values()) {
      wavefrontModelGroup.setTexture(spriteIdentifier);
    }
  }


  public List<BakedQuad> bake(@NotNull Baker baker, SimpleModel simpleModel, Function<Vector3f, Vector3f> offset){
    List<BakedQuad> quads = new ArrayList<>();
    for (WavefrontModelGroup wavefrontModelGroup : models.values()) {
      quads.addAll(wavefrontModelGroup.bake(baker, simpleModel, offset));
    }
    return quads;
  }

  public Optional<WavefrontModelGroup> get(String groupName) {
    return Optional.ofNullable(models.get(groupName));
  }

  public Optional<WavefrontModelObject> get(String groupName, String objectName) {
    Optional<WavefrontModelGroup> group = this.get(groupName);
    return group.flatMap(wavefrontModelGroup -> wavefrontModelGroup.get(objectName));
  }

  public static class Builder {
    private final String NAME;
    private final List<GeometryVertex> geometryVertices = new ArrayList<>();
    private final List<TextureCoordinate> textureCoordinates = new ArrayList<>();
    private final List<VertexNormal> vertexNormals = new ArrayList<>();
    private final HashMap<String, HashMap<String, List<Polygon.Indexed>>> groupedFaces = new HashMap<>();
    private List<Polygon.Indexed> faceIndices = new ArrayList<>();
    private String group = "";
    private String object = "";

    public Builder(String name){
      this.NAME = name;
    }

    public void addGeometryVertex(GeometryVertex geometryVertex){
      this.geometryVertices.add(geometryVertex);
    }

    public void addTextureCord(TextureCoordinate textureCoordinate){
      this.textureCoordinates.add(textureCoordinate);
    }

    public void addVertexNormal(VertexNormal vertexNormal){
      this.vertexNormals.add(vertexNormal);
    }

    public void addIndexedFace(Polygon.Indexed indexedFace){
      this.faceIndices.add(indexedFace);
    }

    public void setGroup(String group) {
      this.resetLocation();

      this.group = group;
      this.faceIndices = this.groupedFaces
        .getOrDefault(group, new HashMap<>())
        .getOrDefault(this.object, new ArrayList<>());
    }

    public void setObject(String object) {
      this.resetLocation();

      this.object = object;
      this.faceIndices = this.groupedFaces
        .getOrDefault(this.group, new HashMap<>())
        .getOrDefault(object, new ArrayList<>());
    }

    private void resetLocation(){
      HashMap<String, List<Polygon.Indexed>> groupMap = this.groupedFaces.getOrDefault(this.group, new HashMap<>());
      groupMap.put(this.object, this.faceIndices);
      this.groupedFaces.put(this.group, groupMap);

      this.faceIndices = new ArrayList<>();
    }

    public WavefrontModel build() {
      this.resetLocation();

      HashMap<String, WavefrontModelGroup> groups = new HashMap<>();
      for(String group : this.groupedFaces.keySet()){
        HashMap<String, WavefrontModelObject> objects = new HashMap<>();
        HashMap<String, List<Polygon.Indexed>> objectMap = this.groupedFaces.get(group);

        for (String object : objectMap.keySet()){
          List<Polygon.Indexed> indexedPolygons = objectMap.get(object);
          objects.put(object, new WavefrontModelObject(object, indexedPolygons.stream()
            .map(indexed -> indexed.toPolygon(this.geometryVertices, this.textureCoordinates, this.vertexNormals))
            .toList()
          ));
        }

        groups.put(group, new WavefrontModelGroup(group, objects));
      }


      return new WavefrontModel(this.NAME, groups);
    }
  }
}
