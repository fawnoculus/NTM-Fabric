package net.fawnoculus.ntm.blocks;

import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceBlock;
import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceExtensionBlock;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

public class ModBlocks {
  private static final AbstractBlock.Settings OreSettings = AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).mapColor(MapColor.GRAY);
  
  public static final Block URANIUM_ORE = register("uranium_ore", Block::new, OreSettings.hardness(10f), true);
  public static final Block LEAD_ORE = register("lead_ore", Block::new, OreSettings.hardness(10f), true);
  public static final Block ALLOY_FURNACE = register("alloy_furnace", AlloyFurnaceBlock::new, AbstractBlock.Settings.create()
          .strength(1.5F, 6.0F)
          .sounds(BlockSoundGroup.STONE)
          .mapColor(MapColor.TERRACOTTA_ORANGE)
          .requiresTool()
  , true);
  public static final Block ALLOY_FURNACE_EXTENSION = register("alloy_furnace_extension", AlloyFurnaceExtensionBlock::new, AbstractBlock.Settings.create(), true);
  
  
  
  private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean registerItem){
    RegistryKey<Block> blockKey = keyOfBlock(name);
    Block block = blockFactory.apply(settings.registryKey(blockKey));
    
    if (registerItem) {
      RegistryKey<Item> itemKey = keyOfItem(name);
      BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
      Registry.register(Registries.ITEM, itemKey, blockItem);
    }
    
    return Registry.register(Registries.BLOCK, blockKey, block);
  }
  private static RegistryKey<Block> keyOfBlock(String name){
    return RegistryKey.of(RegistryKeys.BLOCK, NTM.id(name));
  }
  private static RegistryKey<Item> keyOfItem(String name) {
    return RegistryKey.of(RegistryKeys.ITEM, NTM.id(name));
  }
  
  public static void initialize() {}
}
