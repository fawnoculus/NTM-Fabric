package net.fawnoculus.ntm.render.models;


import com.mojang.blaze3d.vertex.VertexFormat;
import net.fawnoculus.ntm.render.ModRendering;
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

public class MultiModel3D {
  public final String NAME;
  public final HashMap<String, GroupedModel3D> MODELS = new HashMap<>();
  
  public MultiModel3D(){
    this("Empty");
  }
  public MultiModel3D(String name){
    this.NAME = name;
  }
  
  public void addModel(String objectName, String groupName, Model3D model3D){
    if(!MODELS.containsKey(objectName)){
      MODELS.put(objectName, new GroupedModel3D(this.NAME+"#"+objectName));
    }
    
    MODELS.get(objectName).addModel(groupName, model3D);
  }
  
  public void drawAll(MatrixStack.Entry matrix, Identifier texture) {
    try{
      ModRendering.drawTexture(getAllAsBuffer(matrix).end(), texture);
    }catch (Throwable throwable){
      ModRendering.LOGGER.warn("Exception occurred while trying to render MultiModel {}\nException:{}", this.NAME, ExceptionUtil.makePretty(throwable, false));
    }
  }
  
  public BufferBuilder getAllAsBuffer(MatrixStack.Entry matrix) {
    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_TEXTURE_COLOR);
    return addAllToBuffer(matrix, buffer);
  }
  
  public BufferBuilder addAllToBuffer(MatrixStack.Entry matrix, BufferBuilder buffer){
    for(GroupedModel3D groupedModel : MODELS.values()){
      buffer = groupedModel.addAllToBuffer(matrix, buffer);
    }
    return buffer;
  }
  
  public @Nullable GroupedModel3D getNullable(String objectName){
    return MODELS.get(objectName);
  }
  public @Nullable Model3D getNullable(String objectName, String groupName){
    GroupedModel3D groupedModel = getNullable(objectName);
    if(groupedModel != null){
      return groupedModel.getNullable(groupName);
    }
    return null;
  }
  
  public @NotNull GroupedModel3D getOrThrow(String objectName) throws NoSuchElementException {
    if(MODELS.containsKey(objectName)){
      return MODELS.get(objectName);
    }
    throw new NoSuchElementException("Could not get GroupedModel3D '" + objectName + "' because it does not exist");
  }
  public @Nullable Model3D getOrThrow(String objectName, String groupName) throws NoSuchElementException {
    return getOrThrow(objectName).getOrThrow(groupName);
  }
}
