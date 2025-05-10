package net.fawnoculus.ntm.util.tags;

import net.fawnoculus.ntm.main.NTM;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModItemTags {
  // Tool Materials
  public static final TagKey<Item> STEEL_TOOL_MATERIALS = createTagKey("steel_tool_material");
  
  // Ore Items
  public static final TagKey<Item> QUARTZ_ORES = createTagKey("quartz_ores");
  public static final TagKey<Item> URANIUM_ORES = createTagKey("uranium_ores");
  public static final TagKey<Item> PLUTONIUM_ORES = createTagKey("plutonium_ores");
  public static final TagKey<Item> THORIUM_ORES = createTagKey("thorium_ores");
  public static final TagKey<Item> MORKITE_ORES = createTagKey("morkite_ores");
  public static final TagKey<Item> TITANIUM_ORES = createTagKey("titanium_ores");
  public static final TagKey<Item> SULFUR_ORES = createTagKey("sulfur_ores");
  public static final TagKey<Item> GLOWSTONE_ORES = createTagKey("glowstone_ores");
  public static final TagKey<Item> NITER_ORES = createTagKey("nitter_ores");
  public static final TagKey<Item> NICKEL_ORES = createTagKey("nickel_ores");
  public static final TagKey<Item> ZINC_ORES = createTagKey("zinc_ores");
  public static final TagKey<Item> TUNGSTEN_ORES = createTagKey("tungsten_ores");
  public static final TagKey<Item> ALUMINIUM_ORES = createTagKey("aluminium_ores");
  public static final TagKey<Item> FLUORITE_ORES = createTagKey("fluorite_ores");
  public static final TagKey<Item> BERYLLIUM_ORES = createTagKey("beryllium_ores");
  public static final TagKey<Item> LEAD_ORES = createTagKey("lead_ores");
  public static final TagKey<Item> LIGNITE_ORES = createTagKey("lignite_ores");
  public static final TagKey<Item> ASBESTOS_ORES = createTagKey("asbestos_ores");
  public static final TagKey<Item> SCHRABIDIUM_ORES = createTagKey("schrabidium_ores");
  public static final TagKey<Item> LITHIUM_ORES = createTagKey("lithium_ores");
  public static final TagKey<Item> NIOBIUM_ORES = createTagKey("niobium_ores");
  public static final TagKey<Item> CADMIUM_ORES = createTagKey("cadmium_ores");
  public static final TagKey<Item> PALLADIUM_ORES = createTagKey("palladium_ores");
  public static final TagKey<Item> IODINE_ORES = createTagKey("iodine_ores");
  public static final TagKey<Item> ARSENIC_ORES = createTagKey("arsenic_ores");
  public static final TagKey<Item> SILICON_ORES = createTagKey("silicon_ores");
  public static final TagKey<Item> PHOSPHORUS_ORES = createTagKey("phosphorus_ores");
  public static final TagKey<Item> AUSTRALIAN_ORES = createTagKey("australian_ores");
  public static final TagKey<Item> COBALT_ORES = createTagKey("cobalt_ores");
  public static final TagKey<Item> CINNABAR_ORES = createTagKey("cinnabar_ores");
  public static final TagKey<Item> COLTAN_ORES = createTagKey("coltan_ores");
  public static final TagKey<Item> LANTHANIUM_ORES = createTagKey("lanthanium_ores");
  
  private static TagKey<Item> createTagKey(String name){
    return TagKey.of(RegistryKeys.ITEM, NTM.id(name));
  }
}
