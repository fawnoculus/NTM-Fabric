package net.fawnoculus.ntm.util.tags;

import net.fawnoculus.ntm.main.NTM;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModItemTags {
  // Tool Stuff
  public static final TagKey<Item> STEEL_TOOL_MATERIALS = createTagKey("steel_tool_materials");
  public static final TagKey<Item> TITANIUM_TOOL_MATERIALS = createTagKey("titanium_tool_materials");
  public static final TagKey<Item> ADVANCED_ALLOY_TOOL_MATERIALS = createTagKey("advanced_alloy_tool_materials");
  public static final TagKey<Item> CMB_STEEL_TOOL_MATERIALS = createTagKey("cmb_steel_tool_materials");
  public static final TagKey<Item> DESH_TOOL_MATERIALS = createTagKey("desh_tool_materials");
  public static final TagKey<Item> COBALT_TOOL_MATERIALS = createTagKey("cobalt_tool_materials");
  public static final TagKey<Item> DECORATED_COBALT_TOOL_MATERIALS = createTagKey("decorated_cobalt_tool_materials");
  public static final TagKey<Item> STARMETAL_TOOL_MATERIALS = createTagKey("starmetal_tool_materials");
  public static final TagKey<Item> SCHRABIDIUM_TOOL_MATERIALS = createTagKey("schrabidium_tool_materials");
  public static final TagKey<Item> BISMUTH_TOOL_MATERIALS = createTagKey("bismuth_tool_materials");
  public static final TagKey<Item> MOLTEN_TOOL_MATERIALS = createTagKey("molten_tool_materials");
  public static final TagKey<Item> CHLOROPHYTE_TOOL_MATERIALS = createTagKey("chlorophyte_tool_materials");
  public static final TagKey<Item> MESE_TOOL_MATERIALS = createTagKey("mese_tool_materials");
  
  // Ores
  public static final TagKey<Item> URANIUM_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> SCORCHED_URANIUM_ORES = createTagKey("scorched_uranium_ores");
  public static final TagKey<Item> THORIUM_ORES = createTagKey("thorium_ores");
  public static final TagKey<Item> TITANIUM_ORES = createTagKey("titanium_ores");
  public static final TagKey<Item> NITER_ORES = createTagKey("niter_ores");
  public static final TagKey<Item> SULFUR_ORES = createTagKey("sulfur_ores");
  public static final TagKey<Item> TUNGSTEN_ORES = createTagKey("tungsten_ores");
  public static final TagKey<Item> CRYOLITE_ORES = createTagKey("cryolite_ores");
  public static final TagKey<Item> FLUORITE_ORES = createTagKey("fluorite_ores");
  public static final TagKey<Item> BERYLLIUM_ORES = createTagKey("beryllium_ores");
  public static final TagKey<Item> LEAD_ORES = createTagKey("lead_ores");
  public static final TagKey<Item> LIGNITE_ORES = createTagKey("lignite_ores");
  public static final TagKey<Item> ASBESTOS_ORES = createTagKey("asbestos_ores");
  public static final TagKey<Item> SCHRABIDIUM_ORES = createTagKey("schrabidium_ores");
  public static final TagKey<Item> AUSTRALIUM_ORES = createTagKey("australium_ores");
  public static final TagKey<Item> RARE_EARTH_ORES = createTagKey("rare_earth_ores");
  public static final TagKey<Item> COBALT_ORES = createTagKey("cobalt_ores");
  public static final TagKey<Item> CINNABAR_ORES = createTagKey("cinnabar_ores");
  public static final TagKey<Item> COLTAN_ORES = createTagKey("coltan_ores");
  public static final TagKey<Item> PLUTONIUM_ORES = createTagKey("plutonium_ores");
  public static final TagKey<Item> PHOSPHORUS_ORES = createTagKey("phosphorus_ores");
  public static final TagKey<Item> TRIXITE_ORES = createTagKey("trixite_ores");
  public static final TagKey<Item> OSMIRIDIUM_ORES = createTagKey("osmiridium_ores");
  public static final TagKey<Item> METEORIC_IRON_ORES = createTagKey("meteoric_iron_ores");
  public static final TagKey<Item> METEORIC_COPPER_ORES = createTagKey("meteoric_copper_ores");
  public static final TagKey<Item> METEORIC_ALUMINIUM_ORES = createTagKey("meteoric_aluminium_ores");
  public static final TagKey<Item> METEORIC_RARE_EARTH_ORES = createTagKey("meteoric_rare_earth_ores");
  public static final TagKey<Item> METEORIC_COBALT_ORES = createTagKey("meteoric_cobalt_ores");
  
  private static TagKey<Item> createTagKey(String name){
    return TagKey.of(RegistryKeys.ITEM, NTM.id(name));
  }
}
