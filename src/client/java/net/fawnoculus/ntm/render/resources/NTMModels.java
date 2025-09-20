package net.fawnoculus.ntm.render.resources;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.render.wavefront.ModelHandler;
import net.fawnoculus.ntm.render.wavefront.model.MultiMultiModel3d;
import org.jetbrains.annotations.Contract;

public class NTMModels {
  public static final MultiMultiModel3d ALLOY_FURNACE_EXTENSION = of("alloy_furnace_extension");
  public static final MultiMultiModel3d ZIRNOX = of("zirnox");
  public static final MultiMultiModel3d ZIRNOX_DESTROYED = of("zirnox_destroyed");


  @Contract("_ -> new")
  private static MultiMultiModel3d of(String name) {
    return ModelHandler.ofWavefrontObj(NTM.id("models/obj/" + name + ".obj"));
  }

  public static void initialize() {
    ALLOY_FURNACE_EXTENSION.getOrThrow("Top", "").setTexture(NTM.id("block/alloy_furnace_top"));
    ALLOY_FURNACE_EXTENSION.getOrThrow("Side", "").setTexture(NTM.id("block/alloy_furnace_extension"));
    ALLOY_FURNACE_EXTENSION.getOrThrow("Bottom", "").setTexture(NTM.id("block/alloy_furnace_bottom"));
  }
}
