package net.fawnoculus.ntm.render;

import net.fawnoculus.ntm.NTM;
import net.minecraft.util.Identifier;

public class ModTextures {
  public static final Identifier ALLOY_FURNACE_EXTENSION_TOP = of("block/alloy_furnace_top");
  public static final Identifier ALLOY_FURNACE_EXTENSION_SIDE = of("block/alloy_furnace_extension");
  public static final Identifier ALLOY_FURNACE_EXTENSION_BOTTOM = of("block/alloy_furnace_bottom");
  public static final Identifier ALLOY_FURNACE_GUI = NTM.id("textures/gui/container/alloy_furnace.png");
  public static final Identifier ELECTRIC_FURNACE_GUI = NTM.id("textures/gui/container/electric_furnace.png");
  
  private static Identifier of(String name){
    return NTM.id("textures/" + name + ".png");
  }
}
