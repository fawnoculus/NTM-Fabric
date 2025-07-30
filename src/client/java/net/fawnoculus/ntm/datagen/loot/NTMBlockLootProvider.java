package net.fawnoculus.ntm.datagen.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.NTM;
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

public class NTMBlockLootProvider extends FabricBlockLootTableProvider {
  public NTMBlockLootProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
    super(dataOutput, registryLookup);
  }
  
  @Override
  public void generate() {
    addDrop(NTMBlocks.ALLOY_FURNACE);
    
    addDrop(NTMBlocks.URANIUM_ORE, oreDrops(NTMBlocks.URANIUM_ORE, NTMItems.RAW_URANIUM));
    addDrop(NTMBlocks.SCORCHED_URANIUM_ORE, oreDrops(NTMBlocks.SCORCHED_URANIUM_ORE , NTMItems.RAW_SCORCHED_URANIUM));
    addDrop(NTMBlocks.TITANIUM_ORE, oreDrops(NTMBlocks.TITANIUM_ORE, NTMItems.RAW_TITANIUM));
    addDrop(NTMBlocks.SULFUR_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.THORIUM_ORE, oreDrops(NTMBlocks.THORIUM_ORE, NTMItems.RAW_THORIUM));
    addDrop(NTMBlocks.NITER_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.TUNGSTEN_ORE, oreDrops(NTMBlocks.TUNGSTEN_ORE, NTMItems.RAW_TUNGSTEN));
    addDrop(NTMBlocks.ALUMINIUM_BEARING_ORE, oreDrops(NTMBlocks.ALUMINIUM_BEARING_ORE, NTMItems.RAW_CRYOLITE));
    addDrop(NTMBlocks.FLUORITE_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.LEAD_ORE, oreDrops(NTMBlocks.LEAD_ORE, NTMItems.RAW_LEAD));
    addDrop(NTMBlocks.SCHRABIDIUM_ORE, oreDrops(NTMBlocks.SCHRABIDIUM_ORE, NTMItems.RAW_SCHRABIDIUM));
    addDrop(NTMBlocks.BERYLLIUM_ORE, oreDrops(NTMBlocks.BERYLLIUM_ORE, NTMItems.RAW_BERYLLIUM));
    addDrop(NTMBlocks.AUSTRALIUM_ORE, oreDrops(NTMBlocks.AUSTRALIUM_ORE, NTMItems.RAW_AUSTRALIUM));
    addDrop(NTMBlocks.RARE_EARTH_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.COBALT_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.CINNEBAR_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.COLTAN_ORE, oreDrops(NTMBlocks.COLTAN_ORE, NTMItems.COLTAN));
    addDrop(NTMBlocks.LIGNITE_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.ASBESTOS_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.OIL_DEPOSIT);
    addDrop(NTMBlocks.EMPTY_OIL_DEPOSIT);
    addDrop(NTMBlocks.ALUMINIUM_ORE_CLUSTER, NTMItems.NULL);
    addDrop(NTMBlocks.COPPER_ORE_CLUSTER, NTMItems.NULL);
    addDrop(NTMBlocks.IRON_ORE_CLUSTER, NTMItems.NULL);
    addDrop(NTMBlocks.TITANIUM_ORE_CLUSTER, NTMItems.NULL);
    
    addDrop(NTMBlocks.DEAD_DIRT);
    addDrop(NTMBlocks.OILY_DIRT);
    addDrop(NTMBlocks.OILY_SAND);
    
    addDrop(NTMBlocks.DEPTH_ROCK);
    addDrop(NTMBlocks.DEPTH_CINNABAR_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.DEPTH_ZIRCONIUM_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.DEPTH_BORAX_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.DEPTH_IRON_ORE_CLUSTER, NTMItems.NULL);
    addDrop(NTMBlocks.DEPTH_TITANIUM_ORE_CLUSTER, NTMItems.NULL);
    addDrop(NTMBlocks.ALEXANDRITE_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER, NTMItems.NULL);
    
    addDrop(NTMBlocks.VOLCANIC_BASALT);
    addDrop(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT, NTMItems.NULL);
    addDrop(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT, NTMItems.NULL);
    addDrop(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT, NTMItems.NULL);
    addDrop(NTMBlocks.GEM_RICH_VOLCANIC_BASALT, NTMItems.NULL);
    addDrop(NTMBlocks.MOLYSITE_RICH_VOLCANIC_BASALT, NTMItems.NULL);
    
    addDrop(NTMBlocks.SMOLDERING_NETHERRACK, NTMItems.NULL);
    addDrop(NTMBlocks.NETHER_COAL_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.NETHER_URANIUM_ORE, oreDrops(NTMBlocks.NETHER_URANIUM_ORE, NTMItems.RAW_URANIUM));
    addDrop(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE, oreDrops(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE, NTMItems.RAW_SCORCHED_URANIUM));
    addDrop(NTMBlocks.NETHER_PLUTONIUM_ORE, oreDrops(NTMBlocks.NETHER_PLUTONIUM_ORE, NTMItems.RAW_PLUTONIUM));
    addDrop(NTMBlocks.NETHER_TUNGSTEN_ORE, oreDrops(NTMBlocks.NETHER_TUNGSTEN_ORE, NTMItems.RAW_TUNGSTEN));
    addDrop(NTMBlocks.NETHER_SULFUR_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.NETHER_PHOSPHORUS_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.NETHER_COBALT_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.NETHER_SCHRABIDIUM_ORE, oreDrops(NTMBlocks.NETHER_SCHRABIDIUM_ORE, NTMItems.RAW_SCHRABIDIUM));
    
    addDrop(NTMBlocks.NETHER_DEPTH_ROCK);
    addDrop(NTMBlocks.NETHER_DEPTH_NEODYMIUM_ORE, NTMItems.NULL);
    
    addDrop(NTMBlocks.METEORITE_BLOCK, NTMItems.NULL);
    addDrop(NTMBlocks.BROKEN_METEORITE_BLOCK, NTMItems.NULL);
    addDrop(NTMBlocks.METEORITE_COBBLESTONE, NTMItems.NULL);
    addDrop(NTMBlocks.METEORITE_TREASURE_BLOCK, NTMItems.NULL);
    addDrop(NTMBlocks.METEOR_IRON_ORE, oreDrops(NTMBlocks.METEOR_IRON_ORE, NTMItems.RAW_METEORIC_IRON));
    addDrop(NTMBlocks.METEOR_COPPER_ORE, oreDrops(NTMBlocks.METEOR_COPPER_ORE, NTMItems.RAW_METEORIC_COPPER));
    addDrop(NTMBlocks.METEOR_ALUMINIUM_ORE, oreDrops(NTMBlocks.METEOR_ALUMINIUM_ORE, NTMItems.RAW_METEORIC_ALUMINIUM));
    addDrop(NTMBlocks.METEOR_RARE_EARTH_ORE, oreDrops(NTMBlocks.METEOR_RARE_EARTH_ORE, NTMItems.RAW_METEORIC_RARE_EARTH));
    addDrop(NTMBlocks.METEOR_COBALT_ORE, oreDrops(NTMBlocks.METEOR_COBALT_ORE, NTMItems.RAW_METEORIC_COBALT));
    
    addDrop(NTMBlocks.GRAPHITIC_SCHIST);
    addDrop(NTMBlocks.SCHIST_IRON_ORE, oreDrops(NTMBlocks.SCHIST_IRON_ORE, Items.RAW_IRON));
    addDrop(NTMBlocks.SCHIST_GOLD_ORE, oreDrops(NTMBlocks.SCHIST_GOLD_ORE, Items.RAW_GOLD));
    addDrop(NTMBlocks.SCHIST_URANIUM_ORE, oreDrops(NTMBlocks.SCHIST_URANIUM_ORE, NTMItems.RAW_URANIUM));
    addDrop(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE, oreDrops(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE, NTMItems.RAW_SCORCHED_URANIUM));
    addDrop(NTMBlocks.SCHIST_COPPER_ORE, copperOreDrops(NTMBlocks.SCHIST_COPPER_ORE));
    addDrop(NTMBlocks.SCHIST_ASBESTOS_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.SCHIST_LITHIUM_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.SCHIST_SCHRABIDIUM_ORE, oreDrops(NTMBlocks.SCHIST_SCHRABIDIUM_ORE, NTMItems.RAW_METEORIC_COBALT));
    addDrop(NTMBlocks.SCHIST_RARE_EARTH_ORE, NTMItems.NULL);
    addDrop(NTMBlocks.GAS_SHALE);
    
    addDrop(NTMBlocks.BAUXITE);
    addDrop(NTMBlocks.CHRYSOTILE);
    addDrop(NTMBlocks.HEMATITE);
    addDrop(NTMBlocks.LIMESTONE);
    addDrop(NTMBlocks.MALACHITE);
    addDrop(NTMBlocks.SULFUROUS_STONE);
    
    addDrop(NTMBlocks.TEKTITE);
    addDrop(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE, oreDrops(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE, NTMItems.RAW_OSMIRIDIUM_INFUSED_TEKTITE));
    addDrop(NTMBlocks.TRIXITE_ORE, oreDrops(NTMBlocks.TRIXITE_ORE, NTMItems.RAW_TRIXITE));
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
    return NTM.MOD_NAME + " Block-Loot Provider";
  }
}
