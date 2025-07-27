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
    for(Model3D model3D : MODELS.values()){
      model3D.draw(matrix, light, texture);
    }
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
