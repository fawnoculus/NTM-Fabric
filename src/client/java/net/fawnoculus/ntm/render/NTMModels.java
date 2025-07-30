package net.fawnoculus.ntm.render;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.render.model3d.ModelHandler;
import net.fawnoculus.ntm.render.model3d.MultiModel3D;

public class NTMModels {
  public static final MultiModel3D ALLOY_FURNACE_EXTENSION = of("block/alloy_furnace_extension");
  
  
  private static MultiModel3D of(String name){
    return ModelHandler.ofWavefrontObj(NTM.id("models/obj/" + name + ".obj"));
  }
}
