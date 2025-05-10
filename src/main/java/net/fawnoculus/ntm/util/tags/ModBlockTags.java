package net.fawnoculus.ntm.util.tags;

import net.fawnoculus.ntm.main.NTM;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModBlockTags {
  // Ores
  public static final TagKey<Block> QUARTZ_ORES = createTagKey("quartz_ores");
  public static final TagKey<Block> URANIUM_ORES = createTagKey("uranium_ores");
  public static final TagKey<Block> PLUTONIUM_ORES = createTagKey("plutonium_ores");
  public static final TagKey<Block> THORIUM_ORES = createTagKey("thorium_ores");
  public static final TagKey<Block> MORKITE_ORES = createTagKey("morkite_ores");
  public static final TagKey<Block> TITANIUM_ORES = createTagKey("titanium_ores");
  public static final TagKey<Block> SULFUR_ORES = createTagKey("sulfur_ores");
  public static final TagKey<Block> GLOWSTONE_ORES = createTagKey("glowstone_ores");
  public static final TagKey<Block> NITER_ORES = createTagKey("nitter_ores");
  public static final TagKey<Block> NICKEL_ORES = createTagKey("nickel_ores");
  public static final TagKey<Block> ZINC_ORES = createTagKey("zinc_ores");
  public static final TagKey<Block> TUNGSTEN_ORES = createTagKey("tungsten_ores");
  public static final TagKey<Block> ALUMINIUM_ORES = createTagKey("aluminium_ores");
  public static final TagKey<Block> FLUORITE_ORES = createTagKey("fluorite_ores");
  public static final TagKey<Block> BERYLLIUM_ORES = createTagKey("beryllium_ores");
  public static final TagKey<Block> LEAD_ORES = createTagKey("lead_ores");
  public static final TagKey<Block> LIGNITE_ORES = createTagKey("lignite_ores");
  public static final TagKey<Block> ASBESTOS_ORES = createTagKey("asbestos_ores");
  public static final TagKey<Block> SCHRABIDIUM_ORES = createTagKey("schrabidium_ores");
  public static final TagKey<Block> LITHIUM_ORES = createTagKey("lithium_ores");
  public static final TagKey<Block> NIOBIUM_ORES = createTagKey("niobium_ores");
  public static final TagKey<Block> CADMIUM_ORES = createTagKey("cadmium_ores");
  public static final TagKey<Block> PALLADIUM_ORES = createTagKey("palladium_ores");
  public static final TagKey<Block> IODINE_ORES = createTagKey("iodine_ores");
  public static final TagKey<Block> ARSENIC_ORES = createTagKey("arsenic_ores");
  public static final TagKey<Block> SILICON_ORES = createTagKey("silicon_ores");
  public static final TagKey<Block> PHOSPHORUS_ORES = createTagKey("phosphorus_ores");
  public static final TagKey<Block> AUSTRALIAN_ORES = createTagKey("australian_ores");
  public static final TagKey<Block> COBALT_ORES = createTagKey("cobalt_ores");
  public static final TagKey<Block> CINNABAR_ORES = createTagKey("cinnabar_ores");
  public static final TagKey<Block> COLTAN_ORES = createTagKey("coltan_ores");
  public static final TagKey<Block> LANTHANIUM_ORES = createTagKey("lanthanium_ores");
  
  private static TagKey<Block> createTagKey(String name){
    return TagKey.of(RegistryKeys.BLOCK, NTM.id(name));
  }
}
