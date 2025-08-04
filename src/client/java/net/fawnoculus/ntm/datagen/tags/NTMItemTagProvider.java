package net.fawnoculus.ntm.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.misc.tags.NTMItemTags;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class NTMItemTagProvider extends FabricTagProvider<Item> {
  public NTMItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, RegistryKeys.ITEM, registriesFuture);
  }

  @Override
  protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
    // Tool Materials
    getOrCreateTagBuilder(NTMItemTags.STEEL_TOOL_MATERIALS)
      .add(NTMItems.STEEL_INGOT)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.TITANIUM_TOOL_MATERIALS)
      .add(NTMItems.TANTALUM_INGOT)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.ADVANCED_ALLOY_TOOL_MATERIALS)
      .add(NTMItems.ADVANCED_ALLOY_INGOT)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.CMB_STEEL_TOOL_MATERIALS)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.DESH_TOOL_MATERIALS)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.COBALT_TOOL_MATERIALS)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.DECORATED_COBALT_TOOL_MATERIALS)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.STARMETAL_TOOL_MATERIALS)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.SCHRABIDIUM_TOOL_MATERIALS)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.BISMUTH_TOOL_MATERIALS)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.MOLTEN_TOOL_MATERIALS)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.CHLOROPHYTE_TOOL_MATERIALS)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.MESE_TOOL_MATERIALS)
      .setReplace(false);

    getOrCreateTagBuilder(NTMItemTags.URANIUM_ORES)
      .add(NTMBlocks.URANIUM_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_URANIUM_ORE.asItem())
      .add(NTMBlocks.SCHIST_URANIUM_ORE.asItem())
      .add(NTMBlocks.NETHER_URANIUM_ORE.asItem())
      .add(NTMItems.RAW_URANIUM)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.SCORCHED_URANIUM_ORES)
      .add(NTMBlocks.SCORCHED_URANIUM_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE.asItem())
      .add(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE.asItem())
      .add(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE.asItem())
      .add(NTMItems.RAW_SCORCHED_URANIUM)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.THORIUM_ORES)
      .add(NTMBlocks.THORIUM_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_THORIUM_ORE.asItem())
      .add(NTMItems.RAW_THORIUM)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.TITANIUM_ORES)
      .add(NTMBlocks.TITANIUM_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_TITANIUM_ORE.asItem())
      .add(NTMItems.RAW_TITANIUM)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.NITER_ORES)
      .add(NTMBlocks.NITER_ORE.asItem())
      .add(NTMBlocks.NITER_ORE.asItem())
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.SULFUR_ORES)
      .add(NTMBlocks.SULFUR_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_SULFUR_ORE.asItem())
      .add(NTMBlocks.NETHER_SULFUR_ORE.asItem())
      .add(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT.asItem())
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.TUNGSTEN_ORES)
      .add(NTMBlocks.TUNGSTEN_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE.asItem())
      .add(NTMBlocks.NETHER_TUNGSTEN_ORE.asItem())
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.CRYOLITE_ORES)
      .add(NTMBlocks.ALUMINIUM_BEARING_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE.asItem())
      .add(NTMItems.RAW_CRYOLITE)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.FLUORITE_ORES)
      .add(NTMBlocks.FLUORITE_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_FLUORITE_ORE.asItem())
      .add(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT.asItem())
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.BERYLLIUM_ORES)
      .add(NTMBlocks.BERYLLIUM_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE.asItem())
      .add(NTMItems.RAW_BERYLLIUM)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.LEAD_ORES)
      .add(NTMBlocks.LEAD_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_LEAD_ORE.asItem())
      .add(NTMItems.RAW_LEAD)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.LIGNITE_ORES)
      .add(NTMBlocks.LIGNITE_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_LIGNITE_ORE.asItem())
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.ASBESTOS_ORES)
      .add(NTMBlocks.ASBESTOS_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_ASBESTOS_ORE.asItem())
      .add(NTMBlocks.SCHIST_ASBESTOS_ORE.asItem())
      .add(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT.asItem())
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.SCHRABIDIUM_ORES)
      .add(NTMBlocks.SCHRABIDIUM_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE.asItem())
      .add(NTMBlocks.SCHIST_SCHRABIDIUM_ORE.asItem())
      .add(NTMBlocks.NETHER_SCHRABIDIUM_ORE.asItem())
      .add(NTMItems.RAW_SCHRABIDIUM)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.AUSTRALIUM_ORES)
      .add(NTMBlocks.AUSTRALIUM_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE.asItem())
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.RARE_EARTH_ORES)
      .add(NTMBlocks.RARE_EARTH_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE.asItem())
      .add(NTMBlocks.SCHIST_RARE_EARTH_ORE.asItem())
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.COBALT_ORES)
      .add(NTMBlocks.COBALT_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_COBALT_ORE.asItem())
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.CINNABAR_ORES)
      .add(NTMBlocks.CINNEBAR_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_CINNEBAR_ORE.asItem())
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.COLTAN_ORES)
      .add(NTMBlocks.COLTAN_ORE.asItem())
      .add(NTMBlocks.DEEPSLATE_COLTAN_ORE.asItem())
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.PLUTONIUM_ORES)
      .add(NTMBlocks.NETHER_PLUTONIUM_ORE.asItem())
      .add(NTMItems.RAW_PLUTONIUM)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.PHOSPHORUS_ORES)
      .add(NTMBlocks.NETHER_PHOSPHORUS_ORE.asItem())
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.TRIXITE_ORES)
      .add(NTMBlocks.TRIXITE_ORE.asItem())
      .add(NTMItems.RAW_TRIXITE)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.OSMIRIDIUM_ORES)
      .add(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE.asItem())
      .add(NTMItems.RAW_METEORIC_IRON)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.METEORIC_IRON_ORES)
      .add(NTMBlocks.METEOR_IRON_ORE.asItem())
      .add(NTMItems.RAW_METEORIC_IRON)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.METEORIC_COPPER_ORES)
      .add(NTMBlocks.METEOR_COPPER_ORE.asItem())
      .add(NTMItems.RAW_METEORIC_COPPER)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.METEORIC_ALUMINIUM_ORES)
      .add(NTMBlocks.METEOR_ALUMINIUM_ORE.asItem())
      .add(NTMItems.RAW_METEORIC_ALUMINIUM)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.METEORIC_RARE_EARTH_ORES)
      .add(NTMBlocks.METEOR_RARE_EARTH_ORE.asItem())
      .add(NTMItems.RAW_METEORIC_RARE_EARTH)
      .setReplace(false);
    getOrCreateTagBuilder(NTMItemTags.METEORIC_COBALT_ORES)
      .add(NTMBlocks.METEOR_COBALT_ORE.asItem())
      .add(NTMItems.RAW_METEORIC_COBALT)
      .setReplace(false);

    // Ore Items
  }


  @Override
  public String getName() {
    return NTM.MOD_NAME + " Item-Tag Provider";
  }
}
