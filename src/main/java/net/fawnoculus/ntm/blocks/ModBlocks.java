package net.fawnoculus.ntm.blocks;

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
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
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
    return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(NTM.MOD_ID, name));
  }
  private static RegistryKey<Item> keyOfItem(String name) {
    return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NTM.MOD_ID, name));
  }
  public static void initialize() {};
  
  private static final AbstractBlock.Settings OreSettings = AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).mapColor(MapColor.GRAY);
  
  public static final Block URANIUM_ORE = register("uranium_ore", Block::new, OreSettings.hardness(10f), true);
  public static final Block LEAD_ORE = register("lead_ore", Block::new, OreSettings.hardness(10f), true);
}
