package net.fawnoculus.ntm.render.models;

import com.mojang.blaze3d.vertex.VertexFormat;
import net.fawnoculus.ntm.render.ModRendering;
import net.fawnoculus.ntm.util.ExceptionUtil;
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
    // Empty Models can not be rendered
    // BE CAREFUL
    return new Model3D(List.of());
  }
  
  private List<PolygonalFace> FACES;
  
  public Model3D(List<PolygonalFace> faces){
    this.FACES = faces;
  }
  
  public List<PolygonalFace> getFaces(){
    return this.FACES;
  }
  
  public void replaceFaces(List<PolygonalFace> faces){
    this.FACES = faces;
  }
  
  public void draw(MatrixStack.Entry matrix, Identifier texture){
    try{
      ModRendering.drawTexture(this.getAsBuffer(matrix).end(), texture);
    }catch (Throwable throwable){
      ModRendering.LOGGER.warn("Exception occurred while trying to render: {}\n\tException: {}", this, ExceptionUtil.makePretty(throwable, false));
    }
  }
  
  private BufferBuilder getAsBuffer(MatrixStack.Entry matrix) {
    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_TEXTURE_COLOR);
    return addToBuffer(matrix, buffer);
  }
  
  public BufferBuilder addToBuffer(MatrixStack.Entry matrix, BufferBuilder buffer){
    for (PolygonalFace face : this.getFaces()){
      if(face.isInValid()) continue;
      
      for(int i = 0; i < 3; i++){
        GeometryVertex vertex = face.vertices.get(i);
        TextureCoordinate coordinate = face.coordinates.get(i);
        VertexNormal normal = face.normals.get(i);
        if(normal != null){
          buffer.vertex(matrix, vertex.X, vertex.Y, vertex.Z)
              .texture(-coordinate.getU() + 1, -coordinate.getV() + 1)
              .normal(matrix, normal.X, normal.Y, normal.Z)
              .color(-1);
        }else {
          buffer.vertex(matrix, vertex.X, vertex.Y, vertex.Z)
              .texture(-coordinate.getU() + 1, - coordinate.getV() + 1)
              .color(-1);
        }
      }
    }
    
    return buffer;
  }
  
  public boolean isEmpty(){
    return this.FACES.isEmpty();
  }
  
  @Override
  public String toString() {
    return "Model3D{" +
        "FACES.size()=" + FACES.size() +
        ", FACES=" + FACES +
        '}';
  }
}
