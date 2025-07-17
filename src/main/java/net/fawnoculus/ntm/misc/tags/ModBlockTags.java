package net.fawnoculus.ntm.misc.tags;

import net.fawnoculus.ntm.NTM;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
  public static final TagKey<Block> DEPTH_ROCK = of("depth_rock");
  
  // Tool stuff
  public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = of("incorrect_for_steel_tool");
  public static final TagKey<Block> INCORRECT_FOR_TITANIUM_TOOL = of("incorrect_for_titanium_tool");
  public static final TagKey<Block> INCORRECT_FOR_ADVANCED_ALLOY_TOOL = of("incorrect_for_advanced_alloy_tool");
  public static final TagKey<Block> INCORRECT_FOR_CMB_STEEL_TOOL = of("incorrect_for_cmb_steel_tool");
  public static final TagKey<Block> INCORRECT_FOR_DESH_TOOL = of("incorrect_for_desh_tool");
  public static final TagKey<Block> INCORRECT_FOR_COBALT_TOOL = of("incorrect_for_cobalt_tool");
  public static final TagKey<Block> INCORRECT_FOR_DECORATED_COBALT_TOOL = of("incorrect_for_decorated_cobalt_tool");
  public static final TagKey<Block> INCORRECT_FOR_STARMETAL_TOOL = of("incorrect_for_starmetal_tool");
  public static final TagKey<Block> INCORRECT_FOR_SCHRABIDIUM_TOOL = of("incorrect_for_schrabidium_tool");
  public static final TagKey<Block> INCORRECT_FOR_BISMUTH_TOOL = of("incorrect_for_bismuth_tool");
  public static final TagKey<Block> INCORRECT_FOR_MOLTEN_TOOL = of("incorrect_for_molten_tool");
  public static final TagKey<Block> INCORRECT_FOR_CHLOROPHYTE_TOOL = of("incorrect_for_chlorophyte_tool");
  public static final TagKey<Block> INCORRECT_FOR_MESE_TOOL = of("incorrect_for_mese_tool");
  
  public static final TagKey<Block> NEEDS_NETHERRITE_TOOL = of("needs_netherrite_tool");
  public static final TagKey<Block> NEEDS_SCHRABIDIUM_TOOL = of("needs_schrabidium_tool");
  public static final TagKey<Block> NEEDS_BISMUTH_TOOL = of("needs_bismuth_tool");
  public static final TagKey<Block> NEEDS_MESE_TOOL = of("needs_mese_tool");
  
  public static final TagKey<Block> BIG_AXE_MINEABLE = of(Identifier.ofVanilla("mineable/big_axe"));
  public static final TagKey<Block> BIG_PICKAXE_MINEABLE = of(Identifier.ofVanilla("mineable/big_pickaxe"));
  
  private static TagKey<Block> of(String name){
    return of(NTM.id(name));
  }
  private static TagKey<Block> of(Identifier identifier){
    return TagKey.of(RegistryKeys.BLOCK, identifier);
  }
}
