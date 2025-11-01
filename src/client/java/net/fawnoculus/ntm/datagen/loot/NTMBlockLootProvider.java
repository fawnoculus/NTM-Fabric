package net.fawnoculus.ntm.datagen.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.items.NTMItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.GroupEntry;
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
    addDrop(NTMBlocks.URANIUM_ORE, oreDrops(NTMBlocks.URANIUM_ORE, NTMItems.RAW_URANIUM));
    addDrop(NTMBlocks.DEEPSLATE_URANIUM_ORE, oreDrops(NTMBlocks.DEEPSLATE_URANIUM_ORE, NTMItems.RAW_URANIUM));
    addDrop(NTMBlocks.SCORCHED_URANIUM_ORE, oreDrops(NTMBlocks.SCORCHED_URANIUM_ORE, NTMItems.RAW_SCORCHED_URANIUM));
    addDrop(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE, oreDrops(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE, NTMItems.RAW_SCORCHED_URANIUM));
    addDrop(NTMBlocks.TITANIUM_ORE, oreDrops(NTMBlocks.TITANIUM_ORE, NTMItems.RAW_TITANIUM));
    addDrop(NTMBlocks.DEEPSLATE_TITANIUM_ORE, oreDrops(NTMBlocks.DEEPSLATE_TITANIUM_ORE, NTMItems.RAW_TITANIUM));
    addDrop(NTMBlocks.SULFUR_ORE, oreDrops(NTMBlocks.SULFUR_ORE, NTMItems.SULFUR));
    addDrop(NTMBlocks.DEEPSLATE_SULFUR_ORE, oreDrops(NTMBlocks.DEEPSLATE_SULFUR_ORE, NTMItems.SULFUR));
    addDrop(NTMBlocks.THORIUM_ORE, oreDrops(NTMBlocks.THORIUM_ORE, NTMItems.RAW_THORIUM));
    addDrop(NTMBlocks.DEEPSLATE_THORIUM_ORE, oreDrops(NTMBlocks.DEEPSLATE_THORIUM_ORE, NTMItems.RAW_THORIUM));
    addDrop(NTMBlocks.NITER_ORE, oreDrops(NTMBlocks.NITER_ORE, NTMItems.NITER));
    addDrop(NTMBlocks.DEEPSLATE_NITER_ORE, oreDrops(NTMBlocks.DEEPSLATE_NITER_ORE, NTMItems.NITER));
    addDrop(NTMBlocks.TUNGSTEN_ORE, oreDrops(NTMBlocks.TUNGSTEN_ORE, NTMItems.RAW_TUNGSTEN));
    addDrop(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE, oreDrops(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE, NTMItems.RAW_TUNGSTEN));
    addDrop(NTMBlocks.ALUMINIUM_BEARING_ORE, oreDrops(NTMBlocks.ALUMINIUM_BEARING_ORE, NTMItems.RAW_CRYOLITE));
    addDrop(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE, oreDrops(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE, NTMItems.RAW_CRYOLITE));
    addDrop(NTMBlocks.FLUORITE_ORE, oreDrops(NTMBlocks.FLUORITE_ORE, NTMItems.FLUORITE));
    addDrop(NTMBlocks.DEEPSLATE_FLUORITE_ORE, oreDrops(NTMBlocks.DEEPSLATE_FLUORITE_ORE, NTMItems.FLUORITE));
    addDrop(NTMBlocks.LEAD_ORE, oreDrops(NTMBlocks.LEAD_ORE, NTMItems.RAW_LEAD));
    addDrop(NTMBlocks.DEEPSLATE_LEAD_ORE, oreDrops(NTMBlocks.DEEPSLATE_LEAD_ORE, NTMItems.RAW_LEAD));
    addDrop(NTMBlocks.SCHRABIDIUM_ORE, oreDrops(NTMBlocks.SCHRABIDIUM_ORE, NTMItems.RAW_SCHRABIDIUM));
    addDrop(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE, oreDrops(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE, NTMItems.RAW_SCHRABIDIUM));
    addDrop(NTMBlocks.BERYLLIUM_ORE, oreDrops(NTMBlocks.BERYLLIUM_ORE, NTMItems.RAW_BERYLLIUM));
    addDrop(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE, oreDrops(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE, NTMItems.RAW_BERYLLIUM));
    addDrop(NTMBlocks.AUSTRALIUM_ORE, oreDrops(NTMBlocks.AUSTRALIUM_ORE, NTMItems.RAW_AUSTRALIUM));
    addDrop(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE, oreDrops(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE, NTMItems.RAW_AUSTRALIUM));
    addDrop(NTMBlocks.RARE_EARTH_ORE, oreDrops(NTMBlocks.RARE_EARTH_ORE, NTMItems.RARE_EARTH_ORE_CHUNK));
    addDrop(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE, oreDrops(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE, NTMItems.RARE_EARTH_ORE_CHUNK));
    addDrop(NTMBlocks.COBALT_ORE, multiDrops(NTMBlocks.COBALT_ORE, NTMItems.COBALT_FRAGMENT, 4, 9));
    addDrop(NTMBlocks.DEEPSLATE_COBALT_ORE, multiDrops(NTMBlocks.DEEPSLATE_COBALT_ORE, NTMItems.COBALT_FRAGMENT, 4, 9));
    addDrop(NTMBlocks.CINNEBAR_ORE, oreDrops(NTMBlocks.CINNEBAR_ORE, NTMItems.CINNABAR));
    addDrop(NTMBlocks.DEEPSLATE_CINNEBAR_ORE, oreDrops(NTMBlocks.DEEPSLATE_CINNEBAR_ORE, NTMItems.CINNABAR));
    addDrop(NTMBlocks.COLTAN_ORE, oreDrops(NTMBlocks.COLTAN_ORE, NTMItems.COLTAN));
    addDrop(NTMBlocks.DEEPSLATE_COLTAN_ORE, oreDrops(NTMBlocks.DEEPSLATE_COLTAN_ORE, NTMItems.COLTAN));
    addDrop(NTMBlocks.LIGNITE_ORE, oreDrops(NTMBlocks.LIGNITE_ORE, NTMItems.LIGNITE));
    addDrop(NTMBlocks.DEEPSLATE_LIGNITE_ORE, oreDrops(NTMBlocks.DEEPSLATE_LIGNITE_ORE, NTMItems.LIGNITE));
    addDrop(NTMBlocks.ASBESTOS_ORE, oreDrops(NTMBlocks.ASBESTOS_ORE, NTMItems.ASBESTOS_SHEET));
    addDrop(NTMBlocks.DEEPSLATE_ASBESTOS_ORE, oreDrops(NTMBlocks.DEEPSLATE_ASBESTOS_ORE, NTMItems.ASBESTOS_SHEET));
    addDrop(NTMBlocks.OIL_DEPOSIT);
    addDrop(NTMBlocks.EMPTY_OIL_DEPOSIT);
    addDrop(NTMBlocks.ALUMINIUM_ORE_CLUSTER, oreDrops(NTMBlocks.ALUMINIUM_ORE_CLUSTER, NTMItems.ALUMINIUM_CRYSTALS));
    addDrop(NTMBlocks.DEEPSLATE_ALUMINIUM_ORE_CLUSTER, oreDrops(NTMBlocks.DEEPSLATE_ALUMINIUM_ORE_CLUSTER, NTMItems.ALUMINIUM_CRYSTALS));
    addDrop(NTMBlocks.COPPER_ORE_CLUSTER, oreDrops(NTMBlocks.COPPER_ORE_CLUSTER, NTMItems.COPPER_CRYSTALS));
    addDrop(NTMBlocks.DEEPSLATE_COPPER_ORE_CLUSTER, oreDrops(NTMBlocks.DEEPSLATE_COPPER_ORE_CLUSTER, NTMItems.COPPER_CRYSTALS));
    addDrop(NTMBlocks.IRON_ORE_CLUSTER, oreDrops(NTMBlocks.IRON_ORE_CLUSTER, NTMItems.IRON_CRYSTALS));
    addDrop(NTMBlocks.DEEPSLATE_IRON_ORE_CLUSTER, oreDrops(NTMBlocks.DEEPSLATE_IRON_ORE_CLUSTER, NTMItems.IRON_CRYSTALS));
    addDrop(NTMBlocks.TITANIUM_ORE_CLUSTER, oreDrops(NTMBlocks.TITANIUM_ORE_CLUSTER, NTMItems.TITANIUM_CRYSTALS));
    addDrop(NTMBlocks.DEEPSLATE_TITANIUM_ORE_CLUSTER, oreDrops(NTMBlocks.DEEPSLATE_TITANIUM_ORE_CLUSTER, NTMItems.TITANIUM_CRYSTALS));

    addDrop(NTMBlocks.DEAD_DIRT);
    addDrop(NTMBlocks.OILY_DIRT);
    addDrop(NTMBlocks.OILY_SAND);

    addDrop(NTMBlocks.DEPTH_ROCK);
    addDrop(NTMBlocks.DEPTH_CINNABAR_ORE, oreDrops(NTMBlocks.DEPTH_CINNABAR_ORE, NTMItems.CINNABAR));
    addDrop(NTMBlocks.DEPTH_ZIRCONIUM_ORE, multiDrops(NTMBlocks.DEPTH_CINNABAR_ORE, NTMItems.CINNABAR, 2, 3));
    addDrop(NTMBlocks.DEPTH_BORAX_ORE, oreDrops(NTMBlocks.DEPTH_BORAX_ORE, NTMItems.BORAX_POWDER));
    addDrop(NTMBlocks.DEPTH_IRON_ORE_CLUSTER, oreDrops(NTMBlocks.DEPTH_IRON_ORE_CLUSTER, NTMItems.IRON_CRYSTALS));
    addDrop(NTMBlocks.DEPTH_TITANIUM_ORE_CLUSTER, oreDrops(NTMBlocks.DEPTH_TITANIUM_ORE_CLUSTER, NTMItems.TITANIUM_CRYSTALS));
    addDrop(NTMBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER, oreDrops(NTMBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER, NTMItems.TUNGSTEN_CRYSTALS));
    addDrop(NTMBlocks.ALEXANDRITE_ORE, oreDrops(NTMBlocks.ALEXANDRITE_ORE, NTMItems.ALEXANDRITE));
    addDrop(NTMBlocks.DEEPSLATE_ALEXANDRITE_ORE, oreDrops(NTMBlocks.DEEPSLATE_ALEXANDRITE_ORE, NTMItems.ALEXANDRITE));

    addDrop(NTMBlocks.VOLCANIC_BASALT);
    addDrop(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT, oreDrops(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT, NTMItems.SULFUR));
    addDrop(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT, oreDrops(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT, NTMItems.FLUORITE));
    addDrop(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT, oreDrops(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT, NTMItems.ASBESTOS_SHEET));
    addDrop(NTMBlocks.GEM_RICH_VOLCANIC_BASALT, oreDrops(NTMBlocks.GEM_RICH_VOLCANIC_BASALT, NTMItems.VOLCANIC_GEM));
    addDrop(NTMBlocks.MOLYSITE_RICH_VOLCANIC_BASALT, oreDrops(NTMBlocks.MOLYSITE_RICH_VOLCANIC_BASALT, NTMItems.MOLYSITE));

    addDrop(NTMBlocks.SMOLDERING_NETHERRACK, oreDrops(NTMBlocks.SMOLDERING_NETHERRACK, NTMItems.RED_PHOSPHORUS));
    addDrop(NTMBlocks.NETHER_COAL_ORE, oreDrops(NTMBlocks.NETHER_COAL_ORE, NTMItems.INFERNAL_COAL));
    addDrop(NTMBlocks.NETHER_URANIUM_ORE, oreDrops(NTMBlocks.NETHER_URANIUM_ORE, NTMItems.RAW_URANIUM));
    addDrop(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE, oreDrops(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE, NTMItems.RAW_SCORCHED_URANIUM));
    addDrop(NTMBlocks.NETHER_PLUTONIUM_ORE, oreDrops(NTMBlocks.NETHER_PLUTONIUM_ORE, NTMItems.RAW_PLUTONIUM));
    addDrop(NTMBlocks.NETHER_TUNGSTEN_ORE, oreDrops(NTMBlocks.NETHER_TUNGSTEN_ORE, NTMItems.RAW_TUNGSTEN));
    addDrop(NTMBlocks.NETHER_SULFUR_ORE, multiDrops(NTMBlocks.NETHER_SULFUR_ORE, NTMItems.SULFUR, 2, 4));
    addDrop(NTMBlocks.NETHER_PHOSPHORUS_ORE, chancedDrops(NTMBlocks.NETHER_PHOSPHORUS_ORE, NTMItems.RED_PHOSPHORUS, 4, NTMItems.WHITE_PHOSPHORUS_BAR, 1));
    addDrop(NTMBlocks.NETHER_COBALT_ORE, multiDrops(NTMBlocks.NETHER_COBALT_ORE, NTMItems.COBALT_FRAGMENT, 4, 9));
    addDrop(NTMBlocks.NETHER_SCHRABIDIUM_ORE, oreDrops(NTMBlocks.NETHER_SCHRABIDIUM_ORE, NTMItems.RAW_SCHRABIDIUM));

    addDrop(NTMBlocks.NETHER_DEPTH_ROCK);
    addDrop(NTMBlocks.NETHER_DEPTH_NEODYMIUM_ORE, multiDrops(NTMBlocks.NETHER_DEPTH_NEODYMIUM_ORE, NTMItems.NEODYMIUM_FRAGMENT, 2, 3));

    addDrop(NTMBlocks.METEORITE_BLOCK, NTMItems.NULL);
    addDrop(NTMBlocks.BROKEN_METEORITE_BLOCK, NTMItems.NULL);
    addDrop(NTMBlocks.METEORITE_COBBLESTONE, NTMItems.NULL);
    addDrop(NTMBlocks.METEORITE_TREASURE_BLOCK, NTMItems.NULL); // TODO: this (it is probably really complex)
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
    addDrop(NTMBlocks.SCHIST_ASBESTOS_ORE, oreDrops(NTMBlocks.SCHIST_ASBESTOS_ORE, NTMItems.ASBESTOS_SHEET));
    addDrop(NTMBlocks.SCHIST_LITHIUM_ORE, oreDrops(NTMBlocks.SCHIST_LITHIUM_ORE, NTMItems.NULL)); // TODO: thing of something for this (maybe raw lithium?)
    addDrop(NTMBlocks.SCHIST_SCHRABIDIUM_ORE, oreDrops(NTMBlocks.SCHIST_SCHRABIDIUM_ORE, NTMItems.RAW_METEORIC_COBALT));
    addDrop(NTMBlocks.SCHIST_RARE_EARTH_ORE, oreDrops(NTMBlocks.SCHIST_RARE_EARTH_ORE, NTMItems.RARE_EARTH_ORE_CHUNK));
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


    addDrop(NTMBlocks.ALLOY_FURNACE);
    addDrop(NTMBlocks.ALLOY_FURNACE_EXTENSION);
    addDrop(NTMBlocks.ELECTRIC_FURNACE);

    addDrop(NTMBlocks.POTATO_BATTERY_BLOCK);
    addDrop(NTMBlocks.ENERGY_STORAGE_BLOCK);
    addDrop(NTMBlocks.LITHIUM_ION_ENERGY_STORAGE_BLOCK);
    addDrop(NTMBlocks.SCHRABIDIUM_ENERGY_STORAGE_BLOCK);
    addDrop(NTMBlocks.SPARK_ENERGY_STORAGE_BLOCK);
  }

  public LootTable.Builder multiDrops(Block block, ItemConvertible item, float minDrops, float maxDrops) {
    RegistryWrapper.Impl<Enchantment> impl = registries.getOrThrow(RegistryKeys.ENCHANTMENT);
    return dropsWithSilkTouch(
      block,
      applyExplosionDecay(
        block,
        ItemEntry.builder(item)
          .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
      )
        .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
    );
  }

  public LootTable.Builder chancedDrops(Block block, ItemConvertible item, int chance, ItemConvertible item2, int chance2) {
    RegistryWrapper.Impl<Enchantment> impl = registries.getOrThrow(RegistryKeys.ENCHANTMENT);
    return dropsWithSilkTouch(
      block,
      new GroupEntry.Builder(
        applyExplosionDecay(
          block,
          ItemEntry.builder(item).weight(chance)
        ).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))),
        applyExplosionDecay(
          block,
          ItemEntry.builder(item2).weight(chance2)
        ).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
      )
    );
  }

  @Override
  public String getName() {
    return NTM.MOD_NAME + " Block-Loot Provider";
  }
}
