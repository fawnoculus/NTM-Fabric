package net.fawnoculus.ntm.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.util.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider<Block> {
  public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, RegistryKeys.BLOCK, registriesFuture);
  }
  
  
  @Override
  protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
    getOrCreateTagBuilder(BlockTags.COPPER_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(BlockTags.IRON_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(BlockTags.GOLD_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(BlockTags.LAPIS_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(BlockTags.LAPIS_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(BlockTags.EMERALD_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(BlockTags.DIAMOND_ORES)
        .setReplace(false);
    
    getOrCreateTagBuilder(ModBlockTags.QUARTZ_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.URANIUM_ORES)
        .add(ModBlocks.URANIUM_ORE)
        .setReplace(true);
    getOrCreateTagBuilder(ModBlockTags.PLUTONIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.THORIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.MORKITE_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.TITANIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.SULFUR_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.GLOWSTONE_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.NITER_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.NICKEL_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.ZINC_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.TUNGSTEN_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.ALUMINIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.FLUORITE_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.BERYLLIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.LEAD_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.LIGNITE_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.ASBESTOS_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.SCHRABIDIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.LITHIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.NIOBIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.CADMIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.PALLADIUM_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.IODINE_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.ARSENIC_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.SILICON_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.PHOSPHORUS_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.AUSTRALIAN_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.COBALT_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.CINNABAR_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.COLTAN_ORES)
        .setReplace(false);
    getOrCreateTagBuilder(ModBlockTags.LANTHANIUM_ORES)
        .setReplace(false);
    
    getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
        .forceAddTag(BlockTags.IRON_ORES)
        .forceAddTag(BlockTags.GOLD_ORES)
        .forceAddTag(BlockTags.LAPIS_ORES)
        .forceAddTag(BlockTags.EMERALD_ORES)
        .forceAddTag(BlockTags.DIAMOND_ORES)
        .forceAddTag(BlockTags.COPPER_ORES)
        .forceAddTag(ModBlockTags.QUARTZ_ORES)
        .forceAddTag(ModBlockTags.URANIUM_ORES)
        .forceAddTag(ModBlockTags.PLUTONIUM_ORES)
        .forceAddTag(ModBlockTags.THORIUM_ORES)
        .forceAddTag(ModBlockTags.MORKITE_ORES)
        .forceAddTag(ModBlockTags.TITANIUM_ORES)
        .forceAddTag(ModBlockTags.SULFUR_ORES)
        .forceAddTag(ModBlockTags.GLOWSTONE_ORES)
        .forceAddTag(ModBlockTags.NITER_ORES)
        .forceAddTag(ModBlockTags.NICKEL_ORES)
        .forceAddTag(ModBlockTags.ZINC_ORES)
        .forceAddTag(ModBlockTags.TUNGSTEN_ORES)
        .forceAddTag(ModBlockTags.ALUMINIUM_ORES)
        .forceAddTag(ModBlockTags.FLUORITE_ORES)
        .forceAddTag(ModBlockTags.BERYLLIUM_ORES)
        .forceAddTag(ModBlockTags.LEAD_ORES)
        .forceAddTag(ModBlockTags.LIGNITE_ORES)
        .forceAddTag(ModBlockTags.ASBESTOS_ORES)
        .forceAddTag(ModBlockTags.SCHRABIDIUM_ORES)
        .forceAddTag(ModBlockTags.LITHIUM_ORES)
        .forceAddTag(ModBlockTags.NIOBIUM_ORES)
        .forceAddTag(ModBlockTags.CADMIUM_ORES)
        .forceAddTag(ModBlockTags.PALLADIUM_ORES)
        .forceAddTag(ModBlockTags.IODINE_ORES)
        .forceAddTag(ModBlockTags.ARSENIC_ORES)
        .forceAddTag(ModBlockTags.SILICON_ORES)
        .forceAddTag(ModBlockTags.PHOSPHORUS_ORES)
        .forceAddTag(ModBlockTags.AUSTRALIAN_ORES)
        .forceAddTag(ModBlockTags.COBALT_ORES)
        .forceAddTag(ModBlockTags.CINNABAR_ORES)
        .forceAddTag(ModBlockTags.COLTAN_ORES)
        .forceAddTag(ModBlockTags.LANTHANIUM_ORES)
        .setReplace(false);
  }
}
