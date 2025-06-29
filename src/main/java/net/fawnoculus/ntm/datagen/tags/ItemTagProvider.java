package net.fawnoculus.ntm.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.util.tags.ModItemTags;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider<Item> {
  public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, RegistryKeys.ITEM, registriesFuture);
  }
  
  @Override
  protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
    // Tool Materials
    getOrCreateTagBuilder(ModItemTags.STEEL_TOOL_MATERIALS)
        .add(ModItems.STEEL_INGOT)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.TITANIUM_TOOL_MATERIALS)
        .add(ModItems.TANTALUM_INGOT)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.ADVANCED_ALLOY_TOOL_MATERIALS)
        .add(ModItems.ADVANCED_ALLOY_INGOT)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.CMB_STEEL_TOOL_MATERIALS)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.DESH_TOOL_MATERIALS)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.COBALT_TOOL_MATERIALS)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.DECORATED_COBALT_TOOL_MATERIALS)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.STARMETAL_TOOL_MATERIALS)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.SCHRABIDIUM_TOOL_MATERIALS)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.BISMUTH_TOOL_MATERIALS)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.MOLTEN_TOOL_MATERIALS)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.CHLOROPHYTE_TOOL_MATERIALS)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.MESE_TOOL_MATERIALS)
        .setReplace(false);
    
    getOrCreateTagBuilder(ModItemTags.URANIUM_ORES)
        .add(ModBlocks.URANIUM_ORE.asItem())
        .add(ModBlocks.NETHER_URANIUM_ORE.asItem())
        .add(ModBlocks.SCHIST_URANIUM_ORE.asItem())
        .add(ModItems.RAW_URANIUM)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.SCORCHED_URANIUM_ORES)
        .add(ModBlocks.SCORCHED_URANIUM_ORE.asItem())
        .add(ModBlocks.SCORCHED_NETHER_URANIUM_ORE.asItem())
        .add(ModBlocks.SCORCHED_SCHIST_URANIUM_ORE.asItem())
        .add(ModItems.RAW_SCORCHED_URANIUM)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.THORIUM_ORES)
        .add(ModBlocks.THORIUM_ORE.asItem())
        .add(ModItems.RAW_THORIUM)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.TITANIUM_ORES)
        .add(ModBlocks.TITANIUM_ORE.asItem())
        .add(ModItems.RAW_TITANIUM)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.NITER_ORES)
        .add(ModBlocks.NITER_ORE.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.SULFUR_ORES)
        .add(ModBlocks.SULFUR_ORE.asItem())
        .add(ModBlocks.NETHER_SULFUR_ORE.asItem())
        .add(ModBlocks.SULFUR_RICH_VOLCANIC_BASALT.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.TUNGSTEN_ORES)
        .add(ModBlocks.TUNGSTEN_ORE.asItem())
        .add(ModBlocks.NETHER_TUNGSTEN_ORE.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.CRYOLITE_ORES)
        .add(ModBlocks.ALUMINIUM_BEARING_ORE.asItem())
        .add(ModItems.RAW_CRYOLITE)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.FLUORITE_ORES)
        .add(ModBlocks.FLUORITE_ORE.asItem())
        .add(ModBlocks.FLUORITE_RICH_VOLCANIC_BASALT.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.BERYLLIUM_ORES)
        .add(ModBlocks.BERYLLIUM_ORE.asItem())
        .add(ModItems.RAW_BERYLLIUM)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.LEAD_ORES)
        .add(ModBlocks.LEAD_ORE.asItem())
        .add(ModItems.RAW_LEAD)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.LIGNITE_ORES)
        .add(ModBlocks.LIGNITE_ORE.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.ASBESTOS_ORES)
        .add(ModBlocks.ASBESTOS_ORE.asItem())
        .add(ModBlocks.SCHIST_ASBESTOS_ORE.asItem())
        .add(ModBlocks.ASBESTOS_RICH_VOLCANIC_BASALT.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.SCHRABIDIUM_ORES)
        .add(ModBlocks.SCHRABIDIUM_ORE.asItem())
        .add(ModBlocks.SCHIST_SCHRABIDIUM_ORE.asItem())
        .add(ModBlocks.NETHER_SCHRABIDIUM_ORE.asItem())
        .add(ModItems.RAW_SCHRABIDIUM)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.AUSTRALIUM_ORES)
        .add(ModBlocks.AUSTRALIUM_ORE.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.RARE_EARTH_ORES)
        .add(ModBlocks.RARE_EARTH_ORE.asItem())
        .add(ModBlocks.SCHIST_RARE_EARTH_ORE.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.COBALT_ORES)
        .add(ModBlocks.COBALT_ORE.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.CINNABAR_ORES)
        .add(ModBlocks.CINNEBAR_ORE.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.COLTAN_ORES)
        .add(ModBlocks.COLTAN_ORE.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.PLUTONIUM_ORES)
        .add(ModBlocks.NETHER_PLUTONIUM_ORE.asItem())
        .add(ModItems.RAW_PLUTONIUM)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.PHOSPHORUS_ORES)
        .add(ModBlocks.NETHER_PHOSPHORUS_ORE.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.TRIXITE_ORES)
        .add(ModBlocks.TRIXITE_ORE.asItem())
        .add(ModItems.RAW_TRIXITE)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.OSMIRIDIUM_ORES)
        .add(ModBlocks.OSMIRIDIUM_INFUSED_TEKTITE.asItem())
        .add(ModItems.RAW_METEORIC_IRON)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.METEORIC_IRON_ORES)
        .add(ModBlocks.METEOR_IRON_ORE.asItem())
        .add(ModItems.RAW_METEORIC_IRON)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.METEORIC_COPPER_ORES)
        .add(ModBlocks.METEOR_COPPER_ORE.asItem())
        .add(ModItems.RAW_METEORIC_COPPER)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.METEORIC_ALUMINIUM_ORES)
        .add(ModBlocks.METEOR_ALUMINIUM_ORE.asItem())
        .add(ModItems.RAW_METEORIC_ALUMINIUM)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.METEORIC_RARE_EARTH_ORES)
        .add(ModBlocks.METEOR_RARE_EARTH_ORE.asItem())
        .add(ModItems.RAW_METEORIC_RARE_EARTH)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.METEORIC_COBALT_ORES)
        .add(ModBlocks.METEOR_COBALT_ORE.asItem())
        .add(ModItems.RAW_METEORIC_COBALT)
        .setReplace(false);
    
    // Ore Items
  }
  
  
  @Override
  public String getName() {
    return NTM.MOD_ID + " ItemOption-Tag Provider";
  }
}
