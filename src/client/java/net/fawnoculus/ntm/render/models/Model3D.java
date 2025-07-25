package net.fawnoculus.ntm.render.models;

import com.mojang.blaze3d.vertex.VertexFormat;
import net.fawnoculus.ntm.render.ModRenderPipelines;
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
    draw(matrix, 15728880, texture);
  }
  public void draw(MatrixStack.Entry matrix, int light, Identifier texture){
    try{
      ModRenderPipelines.drawTexture(this.getAsBuffer(matrix, light).end(), texture);
    }catch (Throwable throwable){
      ModRenderPipelines.LOGGER.warn("Exception occurred while trying to render: {}\n\tException: {}", this, ExceptionUtil.makePretty(throwable, false));
    }
  }
  
  private BufferBuilder getAsBuffer(MatrixStack.Entry matrix, int light) {
    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL);
    return addToBuffer(matrix, light, buffer);
  }
  
  public BufferBuilder addToBuffer(MatrixStack.Entry matrix, int light, BufferBuilder buffer){
    for (PolygonalFace face : this.getFaces()){
      if(face.isInValid()) continue;
      
      for(int i = 0; i < 3; i++){
        GeometryVertex vertex = face.vertices.get(i);
        TextureCoordinate coordinate = face.coordinates.get(i);
        VertexNormal normal = face.normals.get(i);
        if(normal != null){
          buffer.vertex(matrix, vertex.X, vertex.Y, vertex.Z)
              .texture(1 - coordinate.getU(), 1 - coordinate.getV())
              .normal(normal.X, normal.Y, normal.Z)
              .light(light)
              .color(-1);
        }else {
          buffer.vertex(matrix, vertex.X, vertex.Y, vertex.Z)
              .texture( 1 - coordinate.getU(), 1 - coordinate.getV())
              .light(light)
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
