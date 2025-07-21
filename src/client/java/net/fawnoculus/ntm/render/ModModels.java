package net.fawnoculus.ntm.render;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.render.models.ModelHandler;
import net.fawnoculus.ntm.render.models.MultiModel3D;

public class ModModels {
  public static final MultiModel3D ALLOY_FURNACE_EXTENSION = register("block/alloy_furnace_extension");
  
  
  private static MultiModel3D register(String name){
    return ModelHandler.ofWavefrontObj(NTM.id("models/obj/" + name + ".obj"));
  }
}
