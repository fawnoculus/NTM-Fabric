package net.fawnoculus.ntm.render.models;

import com.mojang.blaze3d.vertex.VertexFormat;
import net.fawnoculus.ntm.render.ModRendering;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Model3D {
  @Contract(value = " -> new", pure = true)
  public static @NotNull Model3D empty(){
    return new Model3D(List.of());
  }
  
  private final List<PolygonalFace> FACES;
  
  public Model3D(List<PolygonalFace> faces){
    this.FACES = faces;
  }
  
  public List<PolygonalFace> getFaces(){
    return this.FACES;
  }
  
  public void draw(MatrixStack.Entry matrix, Identifier texture){
    ModRendering.drawTexture(this.getAsBuffer(matrix).end(), texture);
  }
  
  private BufferBuilder getAsBuffer(MatrixStack.Entry matrix) {
    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
    return addToBuffer(matrix, buffer);
  }
  
  public BufferBuilder addToBuffer(MatrixStack.Entry matrix, BufferBuilder buffer){
    for (PolygonalFace face : this.getFaces()){
      for(int i = 0; i < face.vertices.size(); i++){
        GeometryVertex vertex = face.vertices.get(i);
        TextureCoordinate coordinate = face.coordinates.get(i);
        VertexNormal normal = face.normals.get(i);
        if(normal != null){
          buffer.vertex(matrix, vertex.X, vertex.Y, vertex.Z)
              .texture(coordinate.getU(), coordinate.getV()).color(-1)
              .normal(matrix, normal.X, normal.Y, normal.Z);
        }else {
          buffer.vertex(matrix, vertex.X, vertex.Y, vertex.Z)
              .texture(coordinate.getU(), coordinate.getV()).color(-1);
        }
      }
    }
    
    return buffer;
  }
  
  public boolean isEmpty(){
    return this.FACES.isEmpty();
  }
}
