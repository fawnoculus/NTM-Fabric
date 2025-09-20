package net.fawnoculus.ntm.render.wavefront;

import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.BakedSimpleModel;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.texture.MissingSprite;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;


public class Polygon {
  public final List<GeometryVertex> vertices = new ArrayList<>();
  public final List<TextureCoordinate> coordinates = new ArrayList<>();
  public final List<@Nullable VertexNormal> normals = new ArrayList<>();
  @SuppressWarnings("deprecation")
  private SpriteIdentifier texture = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, MissingSprite.getMissingSpriteId());

  public void addVertex(@NotNull GeometryVertex vertex) {
    this.vertices.add(vertex);
  }

  public void addCoordinate(TextureCoordinate coordinate) {
    this.coordinates.add(coordinate);
  }

  public void addNormal(@Nullable VertexNormal normal) {
    this.normals.add(normal);
  }

  @SuppressWarnings("deprecation")
  public void setTexture(Identifier blockId){
    this.texture = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, blockId);
  }

  public void setTexture(SpriteIdentifier spriteIdentifier){
    this.texture = spriteIdentifier;
  }

  public boolean isInValid() {
    return vertices.size() != 3
      || coordinates.size() != 3
      || normals.size() != 3;
  }

  @Override
  public String toString() {
    return "Polygon{" +
      "vertices=" + vertices +
      ", coordinates=" + coordinates +
      ", normals=" + normals +
      ", texture=" + texture +
      '}';
  }

  // Yes we are turning a triangle into a quad
  // Yes I also hate it
  public BakedQuad bake(Baker baker, BakedSimpleModel simpleModel) {
    Sprite sprite = baker.getSpriteGetter().get(texture, simpleModel);

    int[] vertexData = new int[32];

    for (int i = 0; i < 3; i++){
      TextureCoordinate coordinate = coordinates.get(i);
      packVertexData(vertexData, i, vertices.get(i).toVec3f(), sprite, coordinate.getU(), coordinate.getV());
    }

    // Set the fourth Quad Corner to the first polygon corner to make a triangle out of a square
    TextureCoordinate coordinate = coordinates.getFirst();
    packVertexData(vertexData, 3, vertices.getFirst().toVec3f(), sprite, coordinate.getU(), coordinate.getV());

    return new BakedQuad(vertexData, -1, Direction.DOWN, sprite, false, 0);
  }

  private static void packVertexData(int[] vertices, int cornerIndex, Vector3f pos, Sprite sprite, float u, float v) {
    int i = cornerIndex * 8;
    vertices[i] = Float.floatToRawIntBits(pos.x());
    vertices[i + 1] = Float.floatToRawIntBits(pos.y());
    vertices[i + 2] = Float.floatToRawIntBits(pos.z());
    vertices[i + 3] = -1;
    vertices[i + 4] = Float.floatToRawIntBits(sprite.getFrameU(u));
    vertices[i + 4 + 1] = Float.floatToRawIntBits(sprite.getFrameV(v));
  }
}
