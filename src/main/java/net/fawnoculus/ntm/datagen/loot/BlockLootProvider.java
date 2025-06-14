package net.fawnoculus.ntm.datagen.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BlockLootProvider extends FabricBlockLootTableProvider {
  public BlockLootProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
    super(dataOutput, registryLookup);
  }
  
  @Override
  public void generate() {
    addDrop(ModBlocks.ALLOY_FURNACE);
    
    addDrop(ModBlocks.URANIUM_ORE, oreDrops(ModBlocks.URANIUM_ORE, ModItems.RAW_URANIUM));
    addDrop(ModBlocks.SCORCHED_URANIUM_ORE, oreDrops(ModBlocks.SCORCHED_URANIUM_ORE ,ModItems.RAW_SCORCHED_URANIUM));
    addDrop(ModBlocks.TITANIUM_ORE, oreDrops(ModBlocks.TITANIUM_ORE, ModItems.RAW_TITANIUM));
    addDrop(ModBlocks.SULFUR_ORE, ModItems.NULL);
    addDrop(ModBlocks.THORIUM_ORE, oreDrops(ModBlocks.THORIUM_ORE, ModItems.RAW_THORIUM));
    addDrop(ModBlocks.NITER_ORE, ModItems.NULL);
    addDrop(ModBlocks.TUNGSTEN_ORE, oreDrops(ModBlocks.TUNGSTEN_ORE, ModItems.RAW_TUNGSTEN));
    addDrop(ModBlocks.ALUMINIUM_BEARING_ORE, oreDrops(ModBlocks.ALUMINIUM_BEARING_ORE, ModItems.RAW_CRYOLITE));
    addDrop(ModBlocks.FLUORITE_ORE, ModItems.NULL);
    addDrop(ModBlocks.LEAD_ORE, oreDrops(ModBlocks.LEAD_ORE, ModItems.RAW_LEAD));
    addDrop(ModBlocks.SCHRABIDIUM_ORE, oreDrops(ModBlocks.SCHRABIDIUM_ORE, ModItems.RAW_SCHRABIDIUM));
    addDrop(ModBlocks.BERYLLIUM_ORE, oreDrops(ModBlocks.BERYLLIUM_ORE, ModItems.RAW_BERYLLIUM));
    addDrop(ModBlocks.AUSTRALIUM_ORE, oreDrops(ModBlocks.AUSTRALIUM_ORE, ModItems.RAW_AUSTRALIUM));
    addDrop(ModBlocks.RARE_EARTH_ORE, ModItems.NULL);
    addDrop(ModBlocks.COBALT_ORE, ModItems.NULL);
    addDrop(ModBlocks.CINNEBAR_ORE, ModItems.NULL);
    addDrop(ModBlocks.COLTAN_ORE, oreDrops(ModBlocks.COLTAN_ORE, ModItems.RAW_COLTAN));
    addDrop(ModBlocks.LIGNITE_ORE, ModItems.NULL);
    addDrop(ModBlocks.ASBESTOS_ORE, ModItems.NULL);
    addDrop(ModBlocks.OIL_DEPOSIT);
    addDrop(ModBlocks.EMPTY_OIL_DEPOSIT);
    addDrop(ModBlocks.ALUMINIUM_ORE_CLUSTER, ModItems.NULL);
    addDrop(ModBlocks.COPPER_ORE_CLUSTER, ModItems.NULL);
    addDrop(ModBlocks.IRON_ORE_CLUSTER, ModItems.NULL);
    addDrop(ModBlocks.TITANIUM_ORE_CLUSTER, ModItems.NULL);
    
    addDrop(ModBlocks.DEAD_DIRT);
    addDrop(ModBlocks.OILY_DIRT);
    addDrop(ModBlocks.OILY_SAND);
    
    addDrop(ModBlocks.DEPTH_ROCK);
    addDrop(ModBlocks.DEPTH_CINNABAR_ORE, ModItems.NULL);
    addDrop(ModBlocks.DEPTH_ZIRCONIUM_ORE, ModItems.NULL);
    addDrop(ModBlocks.DEPTH_BORAX_ORE, ModItems.NULL);
    addDrop(ModBlocks.DEPTH_IRON_ORE_CLUSTER, ModItems.NULL);
    addDrop(ModBlocks.DEPTH_TITANIUM_ORE_CLUSTER, ModItems.NULL);
    addDrop(ModBlocks.ALEXANDRITE_ORE, ModItems.NULL);
    addDrop(ModBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER, ModItems.NULL);
    
    addDrop(ModBlocks.VOLCANIC_BASALT);
    addDrop(ModBlocks.SULFUR_RICH_VOLCANIC_BASALT, ModItems.NULL);
    addDrop(ModBlocks.FLUORITE_RICH_VOLCANIC_BASALT, ModItems.NULL);
    addDrop(ModBlocks.ASBESTOS_RICH_VOLCANIC_BASALT, ModItems.NULL);
    addDrop(ModBlocks.GEM_RICH_VOLCANIC_BASALT, ModItems.NULL);
    addDrop(ModBlocks.MOLYSITE_RICH_VOLCANIC_BASALT, ModItems.NULL);
    
    addDrop(ModBlocks.SMOLDERING_NETHERRACK, ModItems.NULL);
    addDrop(ModBlocks.NETHER_COAL_ORE, ModItems.NULL);
    addDrop(ModBlocks.NETHER_URANIUM_ORE, oreDrops(ModBlocks.NETHER_URANIUM_ORE, ModItems.RAW_URANIUM));
    addDrop(ModBlocks.SCORCHED_NETHER_URANIUM_ORE, oreDrops(ModBlocks.SCORCHED_NETHER_URANIUM_ORE, ModItems.RAW_SCORCHED_URANIUM));
    addDrop(ModBlocks.NETHER_PLUTONIUM_ORE, oreDrops(ModBlocks.NETHER_PLUTONIUM_ORE, ModItems.RAW_PLUTONIUM));
    addDrop(ModBlocks.NETHER_TUNGSTEN_ORE, oreDrops(ModBlocks.NETHER_TUNGSTEN_ORE, ModItems.RAW_TUNGSTEN));
    addDrop(ModBlocks.NETHER_SULFUR_ORE, ModItems.NULL);
    addDrop(ModBlocks.NETHER_PHOSPHORUS_ORE, ModItems.NULL);
    addDrop(ModBlocks.NETHER_COBALT_ORE, ModItems.NULL);
    addDrop(ModBlocks.NETHER_SCHRABIDIUM_ORE, oreDrops(ModBlocks.NETHER_SCHRABIDIUM_ORE, ModItems.RAW_SCHRABIDIUM));
    
    addDrop(ModBlocks.NETHER_DEPTH_ROCK);
    addDrop(ModBlocks.NETHER_DEPTH_NEODYMIUM_ORE, ModItems.NULL);
    
    addDrop(ModBlocks.METEORITE_BLOCK, ModItems.NULL);
    addDrop(ModBlocks.BROKEN_METEORITE_BLOCK, ModItems.NULL);
    addDrop(ModBlocks.METEORITE_COBBLESTONE, ModItems.NULL);
    addDrop(ModBlocks.METEORITE_TREASURE_BLOCK, ModItems.NULL);
    addDrop(ModBlocks.METEOR_IRON_ORE, oreDrops(ModBlocks.METEOR_IRON_ORE, ModItems.RAW_METEORIC_IRON));
    addDrop(ModBlocks.METEOR_COPPER_ORE, oreDrops(ModBlocks.METEOR_COPPER_ORE, ModItems.RAW_METEORIC_COPPER));
    addDrop(ModBlocks.METEOR_ALUMINIUM_ORE, oreDrops(ModBlocks.METEOR_ALUMINIUM_ORE, ModItems.RAW_METEORIC_ALUMINIUM));
    addDrop(ModBlocks.METEOR_RARE_EARTH_ORE, oreDrops(ModBlocks.METEOR_RARE_EARTH_ORE, ModItems.RAW_METEORIC_RARE_EARTH));
    addDrop(ModBlocks.METEOR_COBALT_ORE, oreDrops(ModBlocks.METEOR_COBALT_ORE, ModItems.RAW_METEORIC_COBALT));
    
    addDrop(ModBlocks.GRAPHITIC_SCHIST);
    addDrop(ModBlocks.SCHIST_IRON_ORE, oreDrops(ModBlocks.SCHIST_IRON_ORE, Items.RAW_IRON));
    addDrop(ModBlocks.SCHIST_GOLD_ORE, oreDrops(ModBlocks.SCHIST_GOLD_ORE, Items.RAW_GOLD));
    addDrop(ModBlocks.SCHIST_URANIUM_ORE, oreDrops(ModBlocks.SCHIST_URANIUM_ORE, ModItems.RAW_URANIUM));
    addDrop(ModBlocks.SCORCHED_SCHIST_URANIUM_ORE, oreDrops(ModBlocks.SCORCHED_SCHIST_URANIUM_ORE, ModItems.RAW_SCORCHED_URANIUM));
    addDrop(ModBlocks.SCHIST_COPPER_ORE, copperOreDrops(ModBlocks.SCHIST_COPPER_ORE));
    addDrop(ModBlocks.SCHIST_ASBESTOS_ORE, ModItems.NULL);
    addDrop(ModBlocks.SCHIST_LITHIUM_ORE, ModItems.NULL);
    addDrop(ModBlocks.SCHIST_SCHRABIDIUM_ORE, oreDrops(ModBlocks.SCHIST_SCHRABIDIUM_ORE, ModItems.RAW_METEORIC_COBALT));
    addDrop(ModBlocks.SCHIST_RARE_EARTH_ORE, ModItems.NULL);
    addDrop(ModBlocks.GAS_SHALE);
    
    addDrop(ModBlocks.BAUXITE);
    addDrop(ModBlocks.CHRYSOTILE);
    addDrop(ModBlocks.HEMATITE);
    addDrop(ModBlocks.LIMESTONE);
    addDrop(ModBlocks.MALACHITE);
    addDrop(ModBlocks.SULFUROUS_STONE);
    
    addDrop(ModBlocks.TEKITE);
    addDrop(ModBlocks.OSMIRIDIUM_INFUSED_TEKITE, oreDrops(ModBlocks.OSMIRIDIUM_INFUSED_TEKITE, ModItems.RAW_OSMIRIDIUM));
    addDrop(ModBlocks.TRIXITE_ORE, oreDrops(ModBlocks.TRIXITE_ORE, ModItems.RAW_TRIXITE));
  }
  
  public LootTable.Builder multiOreDrops(Block block, ItemConvertible item, float minDrops, float maxDrops) {
    RegistryWrapper.Impl<Enchantment> impl = registries.getOrThrow(RegistryKeys.ENCHANTMENT);
    return dropsWithSilkTouch(
        block,
        applyExplosionDecay(
            block,
            ItemEntry.builder(item)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))));
  }
  
  @Override
  public String getName() {
    return NTM.MOD_ID + " Block-Loot Provider";
  }
}
