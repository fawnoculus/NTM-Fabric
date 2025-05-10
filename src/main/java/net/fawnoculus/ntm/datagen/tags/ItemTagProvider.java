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
    
    // Ore Items
    getOrCreateTagBuilder(ModItemTags.QUARTZ_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.URANIUM_ORES)
        .add(ModBlocks.URANIUM_ORE.asItem())
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.PLUTONIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.THORIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.MORKITE_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.TITANIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.SULFUR_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.GLOWSTONE_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.NITER_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.NICKEL_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.ZINC_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.TUNGSTEN_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.ALUMINIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.FLUORITE_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.BERYLLIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.LEAD_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.LIGNITE_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.ASBESTOS_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.SCHRABIDIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.LITHIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.NIOBIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.CADMIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.PALLADIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.IODINE_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.ARSENIC_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.SILICON_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.PHOSPHORUS_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.AUSTRALIAN_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.COBALT_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.CINNABAR_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.COLTAN_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModItemTags.LANTHANIUM_ORES)
        .setReplace(false);
  }
  
  
  @Override
  public String getName() {
    return NTM.MOD_ID + " Item-Tag Provider";
  }
}
