package net.fawnoculus.ntm.render;

import net.fawnoculus.ntm.NTM;
import net.minecraft.util.Identifier;

public class NTMTextures {
  public static final Identifier ALLOY_FURNACE_EXTENSION_TOP = of("block/alloy_furnace_top");
  public static final Identifier ALLOY_FURNACE_EXTENSION_SIDE = of("block/alloy_furnace_extension");
  public static final Identifier ALLOY_FURNACE_EXTENSION_BOTTOM = of("block/alloy_furnace_bottom");
  
  public static final Identifier GEIGER_COUNTER_HUD = of("gui/hud/geiger_counter");
  public static final Identifier SHIELD_INFUSION_HUD = of("gui/hud/shield_infusion");
  public static final Identifier ALLOY_FURNACE_GUI = of("gui/machine/alloy_furnace");
  public static final Identifier ELECTRIC_FURNACE_GUI = of("gui/machine/electric_furnace");
  public static final Identifier ENERGY_STORAGE_GUI = of("gui/storage/energy_storage");
  
  public static final Identifier GENERIC_ENERGY_BAR = of("gui/generic/energy_bar");
  public static final Identifier GENERIC_STORAGE_MODE = of("gui/generic/storage_mode");
  
  private static Identifier of(String name){
    return NTM.id("textures/" + name + ".png");
  }
}
