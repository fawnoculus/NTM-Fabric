package net.fawnoculus.ntm.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.util.tags.ModBlockTags;
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
        .setReplace(false);
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
        .addTag(BlockTags.IRON_ORES)
        .addTag(BlockTags.GOLD_ORES)
        .addTag(BlockTags.LAPIS_ORES)
        .addTag(BlockTags.EMERALD_ORES)
        .addTag(BlockTags.DIAMOND_ORES)
        .addTag(BlockTags.COPPER_ORES)
        .addTag(ModBlockTags.QUARTZ_ORES)
        .addTag(ModBlockTags.URANIUM_ORES)
        .addTag(ModBlockTags.PLUTONIUM_ORES)
        .addTag(ModBlockTags.THORIUM_ORES)
        .addTag(ModBlockTags.MORKITE_ORES)
        .addTag(ModBlockTags.TITANIUM_ORES)
        .addTag(ModBlockTags.SULFUR_ORES)
        .addTag(ModBlockTags.GLOWSTONE_ORES)
        .addTag(ModBlockTags.NITER_ORES)
        .addTag(ModBlockTags.NICKEL_ORES)
        .addTag(ModBlockTags.ZINC_ORES)
        .addTag(ModBlockTags.TUNGSTEN_ORES)
        .addTag(ModBlockTags.ALUMINIUM_ORES)
        .addTag(ModBlockTags.FLUORITE_ORES)
        .addTag(ModBlockTags.BERYLLIUM_ORES)
        .addTag(ModBlockTags.LEAD_ORES)
        .addTag(ModBlockTags.LIGNITE_ORES)
        .addTag(ModBlockTags.ASBESTOS_ORES)
        .addTag(ModBlockTags.SCHRABIDIUM_ORES)
        .addTag(ModBlockTags.LITHIUM_ORES)
        .addTag(ModBlockTags.NIOBIUM_ORES)
        .addTag(ModBlockTags.CADMIUM_ORES)
        .addTag(ModBlockTags.PALLADIUM_ORES)
        .addTag(ModBlockTags.IODINE_ORES)
        .addTag(ModBlockTags.ARSENIC_ORES)
        .addTag(ModBlockTags.SILICON_ORES)
        .addTag(ModBlockTags.PHOSPHORUS_ORES)
        .addTag(ModBlockTags.AUSTRALIAN_ORES)
        .addTag(ModBlockTags.COBALT_ORES)
        .addTag(ModBlockTags.CINNABAR_ORES)
        .addTag(ModBlockTags.COLTAN_ORES)
        .addTag(ModBlockTags.LANTHANIUM_ORES)
        .setReplace(false);
  }
  
  @Override
  public String getName() {
    return NTM.MOD_ID + " Block-Tag Provider";
  }
}
