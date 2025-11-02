package net.fawnoculus.ntm.render;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.render.wavefront.WavefrontModelLoader;
import net.fawnoculus.ntm.render.wavefront.model.WavefrontModel;
import org.jetbrains.annotations.Contract;

public class WavefrontModels {
  public static WavefrontModel ALLOY_FURNACE_EXTENSION;
  public static WavefrontModel ZIRNOX;
  public static WavefrontModel ZIRNOX_DESTROYED;

  public static void loadModels() {
    ALLOY_FURNACE_EXTENSION = of("alloy_furnace_extension");
    ZIRNOX = of("zirnox");
    ZIRNOX_DESTROYED = of("zirnox_destroyed");
  }

  public static void loadModelTextures() {
    ALLOY_FURNACE_EXTENSION.get("", "Top")
      .ifPresent(model -> model.setTexture(NTM.id("block/alloy_furnace_top")));
    ALLOY_FURNACE_EXTENSION.get("", "Side")
      .ifPresent(model -> model.setTexture(NTM.id("block/alloy_furnace_extension")));
    ALLOY_FURNACE_EXTENSION.get("", "Bottom")
      .ifPresent(model -> model.setTexture(NTM.id("block/alloy_furnace_bottom")));
    ZIRNOX.setTexture(NTM.id("block/models/zirnox"));
    ZIRNOX_DESTROYED.setTexture(NTM.id("block/models/zirnox_destroyed"));
  }

  @Contract("_ -> new")
  private static WavefrontModel of(String name) {
    return WavefrontModelLoader.ofWavefrontObj(NTM.id("models/obj/" + name + ".obj"));
  }
}
