package net.fawnoculus.ntm.misc.tags;

import net.fawnoculus.ntm.main.NTM;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModBlockTags {
  // Tool stuff
  public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = createTagKey("incorrect_for_steel_tool");
  public static final TagKey<Block> INCORRECT_FOR_TITANIUM_TOOL = createTagKey("incorrect_for_titanium_tool");
  public static final TagKey<Block> INCORRECT_FOR_ADVANCED_ALLOY_TOOL = createTagKey("incorrect_for_advanced_alloy_tool");
  public static final TagKey<Block> INCORRECT_FOR_CMB_STEEL_TOOL = createTagKey("incorrect_for_cmb_steel_tool");
  public static final TagKey<Block> INCORRECT_FOR_DESH_TOOL = createTagKey("incorrect_for_desh_tool");
  public static final TagKey<Block> INCORRECT_FOR_COBALT_TOOL = createTagKey("incorrect_for_cobalt_tool");
  public static final TagKey<Block> INCORRECT_FOR_DECORATED_COBALT_TOOL = createTagKey("incorrect_for_decorated_cobalt_tool");
  public static final TagKey<Block> INCORRECT_FOR_STARMETAL_TOOL = createTagKey("incorrect_for_starmetal_tool");
  public static final TagKey<Block> INCORRECT_FOR_SCHRABIDIUM_TOOL = createTagKey("incorrect_for_schrabidium_tool");
  public static final TagKey<Block> INCORRECT_FOR_BISMUTH_TOOL = createTagKey("incorrect_for_bismuth_tool");
  public static final TagKey<Block> INCORRECT_FOR_MOLTEN_TOOL = createTagKey("incorrect_for_molten_tool");
  public static final TagKey<Block> INCORRECT_FOR_CHLOROPHYTE_TOOL = createTagKey("incorrect_for_chlorophyte_tool");
  public static final TagKey<Block> INCORRECT_FOR_MESE_TOOL = createTagKey("incorrect_for_mese_tool");
  
  public static final TagKey<Block> NEEDS_NETHERRITE_TOOL = createTagKey("needs_netherrite_tool");
  public static final TagKey<Block> NEEDS_SCHRABIDIUM_TOOL = createTagKey("needs_schrabidium_tool");
  public static final TagKey<Block> NEEDS_BISMUTH_TOOL = createTagKey("needs_bismuth_tool");
  public static final TagKey<Block> NEEDS_MESE_TOOL = createTagKey("needs_mese_tool");
  
  public static final TagKey<Block> DEPTH_ROCK = createTagKey("depth_rock");
  
  private static TagKey<Block> createTagKey(String name){
    return TagKey.of(RegistryKeys.BLOCK, NTM.id(name));
  }
}
