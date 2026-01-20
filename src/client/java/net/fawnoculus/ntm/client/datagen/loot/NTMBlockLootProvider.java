package net.fawnoculus.ntm.client.datagen.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.items.NTMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class NTMBlockLootProvider extends FabricBlockLootTableProvider {
    public NTMBlockLootProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        add(NTMBlocks.URANIUM_ORE, createOreDrop(NTMBlocks.URANIUM_ORE, NTMItems.RAW_URANIUM));
        add(NTMBlocks.DEEPSLATE_URANIUM_ORE, createOreDrop(NTMBlocks.DEEPSLATE_URANIUM_ORE, NTMItems.RAW_URANIUM));
        add(NTMBlocks.SCORCHED_URANIUM_ORE, createOreDrop(NTMBlocks.SCORCHED_URANIUM_ORE, NTMItems.RAW_SCORCHED_URANIUM));
        add(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE, createOreDrop(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE, NTMItems.RAW_SCORCHED_URANIUM));
        add(NTMBlocks.TITANIUM_ORE, createOreDrop(NTMBlocks.TITANIUM_ORE, NTMItems.RAW_TITANIUM));
        add(NTMBlocks.DEEPSLATE_TITANIUM_ORE, createOreDrop(NTMBlocks.DEEPSLATE_TITANIUM_ORE, NTMItems.RAW_TITANIUM));
        add(NTMBlocks.SULFUR_ORE, createOreDrop(NTMBlocks.SULFUR_ORE, NTMItems.SULFUR));
        add(NTMBlocks.DEEPSLATE_SULFUR_ORE, createOreDrop(NTMBlocks.DEEPSLATE_SULFUR_ORE, NTMItems.SULFUR));
        add(NTMBlocks.THORIUM_ORE, createOreDrop(NTMBlocks.THORIUM_ORE, NTMItems.RAW_THORIUM));
        add(NTMBlocks.DEEPSLATE_THORIUM_ORE, createOreDrop(NTMBlocks.DEEPSLATE_THORIUM_ORE, NTMItems.RAW_THORIUM));
        add(NTMBlocks.NITER_ORE, createOreDrop(NTMBlocks.NITER_ORE, NTMItems.NITER));
        add(NTMBlocks.DEEPSLATE_NITER_ORE, createOreDrop(NTMBlocks.DEEPSLATE_NITER_ORE, NTMItems.NITER));
        add(NTMBlocks.TUNGSTEN_ORE, createOreDrop(NTMBlocks.TUNGSTEN_ORE, NTMItems.RAW_TUNGSTEN));
        add(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE, createOreDrop(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE, NTMItems.RAW_TUNGSTEN));
        add(NTMBlocks.ALUMINIUM_BEARING_ORE, createOreDrop(NTMBlocks.ALUMINIUM_BEARING_ORE, NTMItems.RAW_CRYOLITE));
        add(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE, createOreDrop(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE, NTMItems.RAW_CRYOLITE));
        add(NTMBlocks.FLUORITE_ORE, createOreDrop(NTMBlocks.FLUORITE_ORE, NTMItems.FLUORITE));
        add(NTMBlocks.DEEPSLATE_FLUORITE_ORE, createOreDrop(NTMBlocks.DEEPSLATE_FLUORITE_ORE, NTMItems.FLUORITE));
        add(NTMBlocks.LEAD_ORE, createOreDrop(NTMBlocks.LEAD_ORE, NTMItems.RAW_LEAD));
        add(NTMBlocks.DEEPSLATE_LEAD_ORE, createOreDrop(NTMBlocks.DEEPSLATE_LEAD_ORE, NTMItems.RAW_LEAD));
        add(NTMBlocks.SCHRABIDIUM_ORE, createOreDrop(NTMBlocks.SCHRABIDIUM_ORE, NTMItems.RAW_SCHRABIDIUM));
        add(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE, createOreDrop(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE, NTMItems.RAW_SCHRABIDIUM));
        add(NTMBlocks.BERYLLIUM_ORE, createOreDrop(NTMBlocks.BERYLLIUM_ORE, NTMItems.RAW_BERYLLIUM));
        add(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE, createOreDrop(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE, NTMItems.RAW_BERYLLIUM));
        add(NTMBlocks.AUSTRALIUM_ORE, createOreDrop(NTMBlocks.AUSTRALIUM_ORE, NTMItems.RAW_AUSTRALIUM));
        add(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE, createOreDrop(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE, NTMItems.RAW_AUSTRALIUM));
        add(NTMBlocks.RARE_EARTH_ORE, createOreDrop(NTMBlocks.RARE_EARTH_ORE, NTMItems.RARE_EARTH_ORE_CHUNK));
        add(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE, createOreDrop(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE, NTMItems.RARE_EARTH_ORE_CHUNK));
        add(NTMBlocks.COBALT_ORE, multiDrops(NTMBlocks.COBALT_ORE, NTMItems.COBALT_FRAGMENT, 4, 9));
        add(NTMBlocks.DEEPSLATE_COBALT_ORE, multiDrops(NTMBlocks.DEEPSLATE_COBALT_ORE, NTMItems.COBALT_FRAGMENT, 4, 9));
        add(NTMBlocks.CINNEBAR_ORE, createOreDrop(NTMBlocks.CINNEBAR_ORE, NTMItems.CINNABAR));
        add(NTMBlocks.DEEPSLATE_CINNEBAR_ORE, createOreDrop(NTMBlocks.DEEPSLATE_CINNEBAR_ORE, NTMItems.CINNABAR));
        add(NTMBlocks.COLTAN_ORE, createOreDrop(NTMBlocks.COLTAN_ORE, NTMItems.COLTAN));
        add(NTMBlocks.DEEPSLATE_COLTAN_ORE, createOreDrop(NTMBlocks.DEEPSLATE_COLTAN_ORE, NTMItems.COLTAN));
        add(NTMBlocks.LIGNITE_ORE, createOreDrop(NTMBlocks.LIGNITE_ORE, NTMItems.LIGNITE));
        add(NTMBlocks.DEEPSLATE_LIGNITE_ORE, createOreDrop(NTMBlocks.DEEPSLATE_LIGNITE_ORE, NTMItems.LIGNITE));
        add(NTMBlocks.ASBESTOS_ORE, createOreDrop(NTMBlocks.ASBESTOS_ORE, NTMItems.ASBESTOS_SHEET));
        add(NTMBlocks.DEEPSLATE_ASBESTOS_ORE, createOreDrop(NTMBlocks.DEEPSLATE_ASBESTOS_ORE, NTMItems.ASBESTOS_SHEET));
        dropSelf(NTMBlocks.OIL_DEPOSIT);
        dropSelf(NTMBlocks.EMPTY_OIL_DEPOSIT);
        add(NTMBlocks.ALUMINIUM_ORE_CLUSTER, createOreDrop(NTMBlocks.ALUMINIUM_ORE_CLUSTER, NTMItems.ALUMINIUM_CRYSTALS));
        add(NTMBlocks.DEEPSLATE_ALUMINIUM_ORE_CLUSTER, createOreDrop(NTMBlocks.DEEPSLATE_ALUMINIUM_ORE_CLUSTER, NTMItems.ALUMINIUM_CRYSTALS));
        add(NTMBlocks.COPPER_ORE_CLUSTER, createOreDrop(NTMBlocks.COPPER_ORE_CLUSTER, NTMItems.COPPER_CRYSTALS));
        add(NTMBlocks.DEEPSLATE_COPPER_ORE_CLUSTER, createOreDrop(NTMBlocks.DEEPSLATE_COPPER_ORE_CLUSTER, NTMItems.COPPER_CRYSTALS));
        add(NTMBlocks.IRON_ORE_CLUSTER, createOreDrop(NTMBlocks.IRON_ORE_CLUSTER, NTMItems.IRON_CRYSTALS));
        add(NTMBlocks.DEEPSLATE_IRON_ORE_CLUSTER, createOreDrop(NTMBlocks.DEEPSLATE_IRON_ORE_CLUSTER, NTMItems.IRON_CRYSTALS));
        add(NTMBlocks.TITANIUM_ORE_CLUSTER, createOreDrop(NTMBlocks.TITANIUM_ORE_CLUSTER, NTMItems.TITANIUM_CRYSTALS));
        add(NTMBlocks.DEEPSLATE_TITANIUM_ORE_CLUSTER, createOreDrop(NTMBlocks.DEEPSLATE_TITANIUM_ORE_CLUSTER, NTMItems.TITANIUM_CRYSTALS));

        dropSelf(NTMBlocks.DEAD_DIRT);
        dropSelf(NTMBlocks.OILY_DIRT);
        dropSelf(NTMBlocks.OILY_SAND);

        dropSelf(NTMBlocks.DEPTH_ROCK);
        add(NTMBlocks.DEPTH_CINNABAR_ORE, createOreDrop(NTMBlocks.DEPTH_CINNABAR_ORE, NTMItems.CINNABAR));
        add(NTMBlocks.DEPTH_ZIRCONIUM_ORE, multiDrops(NTMBlocks.DEPTH_CINNABAR_ORE, NTMItems.CINNABAR, 2, 3));
        add(NTMBlocks.DEPTH_BORAX_ORE, createOreDrop(NTMBlocks.DEPTH_BORAX_ORE, NTMItems.BORAX_POWDER));
        add(NTMBlocks.DEPTH_IRON_ORE_CLUSTER, createOreDrop(NTMBlocks.DEPTH_IRON_ORE_CLUSTER, NTMItems.IRON_CRYSTALS));
        add(NTMBlocks.DEPTH_TITANIUM_ORE_CLUSTER, createOreDrop(NTMBlocks.DEPTH_TITANIUM_ORE_CLUSTER, NTMItems.TITANIUM_CRYSTALS));
        add(NTMBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER, createOreDrop(NTMBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER, NTMItems.TUNGSTEN_CRYSTALS));
        add(NTMBlocks.ALEXANDRITE_ORE, createOreDrop(NTMBlocks.ALEXANDRITE_ORE, NTMItems.ALEXANDRITE));
        add(NTMBlocks.DEEPSLATE_ALEXANDRITE_ORE, createOreDrop(NTMBlocks.DEEPSLATE_ALEXANDRITE_ORE, NTMItems.ALEXANDRITE));

        dropSelf(NTMBlocks.VOLCANIC_BASALT);
        add(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT, createOreDrop(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT, NTMItems.SULFUR));
        add(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT, createOreDrop(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT, NTMItems.FLUORITE));
        add(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT, createOreDrop(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT, NTMItems.ASBESTOS_SHEET));
        add(NTMBlocks.GEM_RICH_VOLCANIC_BASALT, createOreDrop(NTMBlocks.GEM_RICH_VOLCANIC_BASALT, NTMItems.VOLCANIC_GEM));
        add(NTMBlocks.MOLYSITE_RICH_VOLCANIC_BASALT, createOreDrop(NTMBlocks.MOLYSITE_RICH_VOLCANIC_BASALT, NTMItems.MOLYSITE));

        add(NTMBlocks.SMOLDERING_NETHERRACK, createOreDrop(NTMBlocks.SMOLDERING_NETHERRACK, NTMItems.RED_PHOSPHORUS));
        add(NTMBlocks.NETHER_COAL_ORE, createOreDrop(NTMBlocks.NETHER_COAL_ORE, NTMItems.INFERNAL_COAL));
        add(NTMBlocks.NETHER_URANIUM_ORE, createOreDrop(NTMBlocks.NETHER_URANIUM_ORE, NTMItems.RAW_URANIUM));
        add(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE, createOreDrop(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE, NTMItems.RAW_SCORCHED_URANIUM));
        add(NTMBlocks.NETHER_PLUTONIUM_ORE, createOreDrop(NTMBlocks.NETHER_PLUTONIUM_ORE, NTMItems.RAW_PLUTONIUM));
        add(NTMBlocks.NETHER_TUNGSTEN_ORE, createOreDrop(NTMBlocks.NETHER_TUNGSTEN_ORE, NTMItems.RAW_TUNGSTEN));
        add(NTMBlocks.NETHER_SULFUR_ORE, multiDrops(NTMBlocks.NETHER_SULFUR_ORE, NTMItems.SULFUR, 2, 4));
        add(NTMBlocks.NETHER_PHOSPHORUS_ORE, chancedDrops(NTMBlocks.NETHER_PHOSPHORUS_ORE, NTMItems.RED_PHOSPHORUS, 4, NTMItems.WHITE_PHOSPHORUS_BAR, 1));
        add(NTMBlocks.NETHER_COBALT_ORE, multiDrops(NTMBlocks.NETHER_COBALT_ORE, NTMItems.COBALT_FRAGMENT, 4, 9));
        add(NTMBlocks.NETHER_SCHRABIDIUM_ORE, createOreDrop(NTMBlocks.NETHER_SCHRABIDIUM_ORE, NTMItems.RAW_SCHRABIDIUM));

        dropSelf(NTMBlocks.NETHER_DEPTH_ROCK);
        add(NTMBlocks.NETHER_DEPTH_NEODYMIUM_ORE, multiDrops(NTMBlocks.NETHER_DEPTH_NEODYMIUM_ORE, NTMItems.NEODYMIUM_FRAGMENT, 2, 3));

        dropOther(NTMBlocks.METEORITE_BLOCK, NTMItems.NULL);
        dropOther(NTMBlocks.BROKEN_METEORITE_BLOCK, NTMItems.NULL);
        dropOther(NTMBlocks.METEORITE_COBBLESTONE, NTMItems.NULL);
        dropOther(NTMBlocks.METEORITE_TREASURE_BLOCK, NTMItems.NULL); // TODO: this (it is probably really complex)
        add(NTMBlocks.METEOR_IRON_ORE, createOreDrop(NTMBlocks.METEOR_IRON_ORE, NTMItems.RAW_METEORIC_IRON));
        add(NTMBlocks.METEOR_COPPER_ORE, createOreDrop(NTMBlocks.METEOR_COPPER_ORE, NTMItems.RAW_METEORIC_COPPER));
        add(NTMBlocks.METEOR_ALUMINIUM_ORE, createOreDrop(NTMBlocks.METEOR_ALUMINIUM_ORE, NTMItems.RAW_METEORIC_ALUMINIUM));
        add(NTMBlocks.METEOR_RARE_EARTH_ORE, createOreDrop(NTMBlocks.METEOR_RARE_EARTH_ORE, NTMItems.RAW_METEORIC_RARE_EARTH));
        add(NTMBlocks.METEOR_COBALT_ORE, createOreDrop(NTMBlocks.METEOR_COBALT_ORE, NTMItems.RAW_METEORIC_COBALT));

        dropSelf(NTMBlocks.GRAPHITIC_SCHIST);
        add(NTMBlocks.SCHIST_IRON_ORE, createOreDrop(NTMBlocks.SCHIST_IRON_ORE, Items.RAW_IRON));
        add(NTMBlocks.SCHIST_GOLD_ORE, createOreDrop(NTMBlocks.SCHIST_GOLD_ORE, Items.RAW_GOLD));
        add(NTMBlocks.SCHIST_URANIUM_ORE, createOreDrop(NTMBlocks.SCHIST_URANIUM_ORE, NTMItems.RAW_URANIUM));
        add(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE, createOreDrop(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE, NTMItems.RAW_SCORCHED_URANIUM));
        add(NTMBlocks.SCHIST_COPPER_ORE, createCopperOreDrops(NTMBlocks.SCHIST_COPPER_ORE));
        add(NTMBlocks.SCHIST_ASBESTOS_ORE, createOreDrop(NTMBlocks.SCHIST_ASBESTOS_ORE, NTMItems.ASBESTOS_SHEET));
        add(NTMBlocks.SCHIST_LITHIUM_ORE, createOreDrop(NTMBlocks.SCHIST_LITHIUM_ORE, NTMItems.NULL)); // TODO: thing of something for this (maybe raw lithium?)
        add(NTMBlocks.SCHIST_SCHRABIDIUM_ORE, createOreDrop(NTMBlocks.SCHIST_SCHRABIDIUM_ORE, NTMItems.RAW_METEORIC_COBALT));
        add(NTMBlocks.SCHIST_RARE_EARTH_ORE, createOreDrop(NTMBlocks.SCHIST_RARE_EARTH_ORE, NTMItems.RARE_EARTH_ORE_CHUNK));
        dropSelf(NTMBlocks.GAS_SHALE);

        dropSelf(NTMBlocks.BAUXITE);
        dropSelf(NTMBlocks.CHRYSOTILE);
        dropSelf(NTMBlocks.HEMATITE);
        dropSelf(NTMBlocks.LIMESTONE);
        dropSelf(NTMBlocks.MALACHITE);
        dropSelf(NTMBlocks.SULFUROUS_STONE);

        dropSelf(NTMBlocks.TEKTITE);
        add(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE, createOreDrop(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE, NTMItems.RAW_OSMIRIDIUM_INFUSED_TEKTITE));
        add(NTMBlocks.TRIXITE_ORE, createOreDrop(NTMBlocks.TRIXITE_ORE, NTMItems.RAW_TRIXITE));


        dropSelf(NTMBlocks.ALLOY_FURNACE);
        dropSelf(NTMBlocks.ALLOY_FURNACE_EXTENSION);
        dropSelf(NTMBlocks.ELECTRIC_FURNACE);

        dropSelf(NTMBlocks.POTATO_BATTERY_BLOCK);
        dropSelf(NTMBlocks.ENERGY_STORAGE_BLOCK);
        dropSelf(NTMBlocks.LITHIUM_ION_ENERGY_STORAGE_BLOCK);
        dropSelf(NTMBlocks.SCHRABIDIUM_ENERGY_STORAGE_BLOCK);
        dropSelf(NTMBlocks.SPARK_ENERGY_STORAGE_BLOCK);
    }

    public LootTable.Builder multiDrops(Block block, ItemLike item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> impl = registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(
          block,
          applyExplosionDecay(
            block,
            LootItem.lootTableItem(item)
              .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
          )
            .apply(ApplyBonusCount.addOreBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
        );
    }

    public LootTable.Builder chancedDrops(Block block, ItemLike item, int chance, ItemLike item2, int chance2) {
        HolderLookup.RegistryLookup<Enchantment> impl = registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(
          block,
          new net.minecraft.world.level.storage.loot.entries.EntryGroup.Builder(
            applyExplosionDecay(
              block,
              LootItem.lootTableItem(item).setWeight(chance)
            ).apply(ApplyBonusCount.addOreBonusCount(impl.getOrThrow(Enchantments.FORTUNE))),
            applyExplosionDecay(
              block,
              LootItem.lootTableItem(item2).setWeight(chance2)
            ).apply(ApplyBonusCount.addOreBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
          )
        );
    }

    @Override
    public String getName() {
        return NTM.MOD_NAME + " Block-Loot Provider";
    }
}
