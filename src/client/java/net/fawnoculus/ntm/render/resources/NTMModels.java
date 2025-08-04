package net.fawnoculus.ntm.render.resources;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.render.wavefront.ModelHandler;
import net.fawnoculus.ntm.render.wavefront.MultiModel3D;
import org.jetbrains.annotations.Contract;

public class NTMModels {
  public static final MultiModel3D ALLOY_FURNACE_EXTENSION = of("alloy_furnace_extension");
  public static final MultiModel3D ZIRNOX = of("zirnox");
  public static final MultiModel3D ZIRNOX_DESTROYED = of("zirnox_destroyed");


  @Contract("_ -> new")
  private static MultiModel3D of(String name){
    return ModelHandler.ofWavefrontObj(NTM.id("models/obj/" + name + ".obj"));
  }
}
