package net.fawnoculus.ntm.render.models;


import com.mojang.blaze3d.vertex.VertexFormat;
import net.fawnoculus.ntm.render.ModRenderPipelines;
import net.fawnoculus.ntm.util.ExceptionUtil;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class GroupedModel3D {
  public final String NAME;
  public final HashMap<String, Model3D> MODELS = new HashMap<>();
  
  public GroupedModel3D(){
    this("Empty");
  }
  public GroupedModel3D(String name){
    this.NAME = name;
  }
  
  public void addModel(String groupName, Model3D model3D){
    MODELS.put(groupName, model3D);
  }
  
  public void drawAll(MatrixStack.Entry matrix, Identifier texture) {
    drawAll(matrix, 15728880 ,texture);
  }
  public void drawAll(MatrixStack.Entry matrix, int light, Identifier texture) {
    try{
      ModRenderPipelines.drawTexture(getAllAsBuffer(matrix, light).end(), texture);
    }catch (Throwable throwable){
      ModRenderPipelines.LOGGER.warn("Exception occurred while trying to render GroupedModel {}\nException:{}", this.NAME, ExceptionUtil.makePretty(throwable, false));
    }
  }
  
  public BufferBuilder getAllAsBuffer(MatrixStack.Entry matrix, int light) {
    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL);
    return addAllToBuffer(matrix, light, buffer);
  }
  
  public BufferBuilder addAllToBuffer(MatrixStack.Entry matrix, int light, BufferBuilder buffer){
      for(Model3D model : MODELS.values()){
        buffer = model.addToBuffer(matrix, light, buffer);
      }
    return buffer;
  }
  
  public @Nullable Model3D getNullable(String groupName){
    if(MODELS.containsKey(groupName)){
      return MODELS.get(groupName);
    }
    return null;
  }
  
  public @NotNull Model3D getOrThrow(String groupName) throws NoSuchElementException{
    if(MODELS.containsKey(groupName)){
      return MODELS.get(groupName);
    }
    throw  new NoSuchElementException("Could not get Model3d '" + groupName + "' because it does not exist");
  }
}
