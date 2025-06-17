package net.fawnoculus.ntm.util.tags;

import net.fawnoculus.ntm.main.NTM;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModItemTags {
  // Tool Stuff
  public static final TagKey<Item> STEEL_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  public static final TagKey<Item> TITANIUM_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  public static final TagKey<Item> ADVANCED_ALLOY_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  public static final TagKey<Item> CMB_STEEL_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  public static final TagKey<Item> DESH_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  public static final TagKey<Item> COBALT_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  public static final TagKey<Item> DECORATED_COBALT_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  public static final TagKey<Item> STARMETAL_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  public static final TagKey<Item> SCHRABIDIUM_TOOL_MATERIALS = createTagKey("schrabidium_tool_materials");
  public static final TagKey<Item> BISMUTH_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  public static final TagKey<Item> MOLTEN_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  public static final TagKey<Item> CHLOROPHYTE_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  public static final TagKey<Item> MESE_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  
  // Ores
  public static final TagKey<Item> URANIUM_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> SCORCHED_URANIUM_ORES = createTagKey("scorched_uranium_ores");
  public static final TagKey<Item> THORIUM_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> TITANIUM_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> NITER_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> SULFUR_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> TUNGSTEN_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> CRYOLITE_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> FLUORITE_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> BERYLLIUM_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> LEAD_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> LIGNITE_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> ASBESTOS_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> SCHRABIDIUM_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> AUSTRALIUM_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> RARE_EARTH_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> COBALT_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> CINNABAR_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> COLTAN_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> PLUTONIUM_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> PHOSPHORUS_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> TRIXITE_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> OSMIRIDIUM_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> METEORIC_IRON_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> METEORIC_COPPER_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> METEORIC_ALUMINIUM_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> METEORIC_RARE_EARTH_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> METEORIC_COBALT_ORES = createTagKey("uranium_ores");
  
  private static TagKey<Item> createTagKey(String name){
    return TagKey.of(RegistryKeys.ITEM, NTM.id(name));
  }
}
