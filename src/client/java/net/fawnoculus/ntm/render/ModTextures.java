package net.fawnoculus.ntm.render;

import net.fawnoculus.ntm.NTM;
import net.minecraft.util.Identifier;

public class ModTextures {
  public final static Identifier ALLOY_FURNACE_EXTENSION_TOP = of("block/alloy_furnace_top");
  public final static Identifier ALLOY_FURNACE_EXTENSION_SIDE = of("block/alloy_furnace_extension");
  public final static Identifier ALLOY_FURNACE_EXTENSION_BOTTOM = of("block/alloy_furnace_bottom");
  
  private static Identifier of(String name){
    return NTM.id("textures/" + name + ".png");
  }
}
