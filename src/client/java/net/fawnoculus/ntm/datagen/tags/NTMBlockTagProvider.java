package net.fawnoculus.ntm.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.misc.tags.NTMBlockTags;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class NTMBlockTagProvider extends FabricTagProvider<Block> {
  public NTMBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, RegistryKeys.BLOCK, registriesFuture);
  }


  @Override
  protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
    getTagBuilder(BlockTags.NEEDS_IRON_TOOL)
      .add(id(NTMBlocks.URANIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_URANIUM_ORE))
      .add(id(NTMBlocks.SCORCHED_URANIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE))
      .add(id(NTMBlocks.TITANIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_TITANIUM_ORE))
      .add(id(NTMBlocks.SULFUR_ORE))
      .add(id(NTMBlocks.DEEPSLATE_SULFUR_ORE))
      .add(id(NTMBlocks.THORIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_THORIUM_ORE))
      .add(id(NTMBlocks.NITER_ORE))
      .add(id(NTMBlocks.DEEPSLATE_NITER_ORE))
      .add(id(NTMBlocks.TUNGSTEN_ORE))
      .add(id(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE))
      .add(id(NTMBlocks.ALUMINIUM_BEARING_ORE))
      .add(id(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE))
      .add(id(NTMBlocks.FLUORITE_ORE))
      .add(id(NTMBlocks.DEEPSLATE_FLUORITE_ORE))
      .add(id(NTMBlocks.LEAD_ORE))
      .add(id(NTMBlocks.DEEPSLATE_LEAD_ORE))
      .add(id(NTMBlocks.SCHRABIDIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE))
      .add(id(NTMBlocks.BERYLLIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE))
      .add(id(NTMBlocks.AUSTRALIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE))
      .add(id(NTMBlocks.RARE_EARTH_ORE))
      .add(id(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE))
      .add(id(NTMBlocks.COBALT_ORE))
      .add(id(NTMBlocks.DEEPSLATE_COBALT_ORE))
      .add(id(NTMBlocks.CINNEBAR_ORE))
      .add(id(NTMBlocks.DEEPSLATE_CINNEBAR_ORE))
      .add(id(NTMBlocks.COLTAN_ORE))
      .add(id(NTMBlocks.DEEPSLATE_COLTAN_ORE))
      .add(id(NTMBlocks.LIGNITE_ORE))
      .add(id(NTMBlocks.DEEPSLATE_LIGNITE_ORE))
      .add(id(NTMBlocks.ASBESTOS_ORE))
      .add(id(NTMBlocks.DEEPSLATE_ASBESTOS_ORE))
      .add(id(NTMBlocks.OIL_DEPOSIT))
      .add(id(NTMBlocks.DEEPSLATE_OIL_DEPOSIT))
      .add(id(NTMBlocks.EMPTY_OIL_DEPOSIT))
      .add(id(NTMBlocks.DEEPSLATE_EMPTY_OIL_DEPOSIT))
      .add(id(NTMBlocks.ALUMINIUM_ORE_CLUSTER))
      .add(id(NTMBlocks.DEEPSLATE_ALUMINIUM_ORE_CLUSTER))
      .add(id(NTMBlocks.COPPER_ORE_CLUSTER))
      .add(id(NTMBlocks.DEEPSLATE_COPPER_ORE_CLUSTER))
      .add(id(NTMBlocks.IRON_ORE_CLUSTER))
      .add(id(NTMBlocks.DEEPSLATE_IRON_ORE_CLUSTER))
      .add(id(NTMBlocks.TITANIUM_ORE_CLUSTER))
      .add(id(NTMBlocks.DEEPSLATE_TITANIUM_ORE_CLUSTER))
      .add(id(NTMBlocks.ALEXANDRITE_ORE))
      .add(id(NTMBlocks.VOLCANIC_BASALT))
      .add(id(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT))
      .add(id(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT))
      .add(id(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT))
      .add(id(NTMBlocks.GEM_RICH_VOLCANIC_BASALT))
      .add(id(NTMBlocks.MOLYSITE_RICH_VOLCANIC_BASALT))
      .add(id(NTMBlocks.SMOLDERING_NETHERRACK))
      .add(id(NTMBlocks.NETHER_COAL_ORE))
      .add(id(NTMBlocks.NETHER_URANIUM_ORE))
      .add(id(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE))
      .add(id(NTMBlocks.NETHER_PLUTONIUM_ORE))
      .add(id(NTMBlocks.NETHER_TUNGSTEN_ORE))
      .add(id(NTMBlocks.NETHER_SULFUR_ORE))
      .add(id(NTMBlocks.NETHER_PHOSPHORUS_ORE))
      .add(id(NTMBlocks.NETHER_COBALT_ORE))
      .add(id(NTMBlocks.NETHER_SCHRABIDIUM_ORE))
      .add(id(NTMBlocks.SCHIST_IRON_ORE))
      .add(id(NTMBlocks.SCHIST_GOLD_ORE))
      .add(id(NTMBlocks.SCHIST_URANIUM_ORE))
      .add(id(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE))
      .add(id(NTMBlocks.SCHIST_COPPER_ORE))
      .add(id(NTMBlocks.SCHIST_ASBESTOS_ORE))
      .add(id(NTMBlocks.SCHIST_LITHIUM_ORE))
      .add(id(NTMBlocks.SCHIST_SCHRABIDIUM_ORE))
      .add(id(NTMBlocks.SCHIST_RARE_EARTH_ORE))
      .add(id(NTMBlocks.GAS_SHALE))
      .add(id(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE))
      .add(id(NTMBlocks.TRIXITE_ORE));

    getTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
      .add(id(NTMBlocks.ALEXANDRITE_ORE))
      .add(id(NTMBlocks.DEEPSLATE_ALEXANDRITE_ORE));

    getTagBuilder(NTMBlockTags.NEEDS_NETHERRITE_TOOL);
    getTagBuilder(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL);
    getTagBuilder(NTMBlockTags.NEEDS_BISMUTH_TOOL);
    getTagBuilder(NTMBlockTags.NEEDS_MESE_TOOL);

    getTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
      .addTag(NTMBlockTags.NEEDS_NETHERRITE_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
      .addTag(NTMBlockTags.NEEDS_NETHERRITE_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
      .addTag(NTMBlockTags.NEEDS_NETHERRITE_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
      .addTag(NTMBlockTags.NEEDS_NETHERRITE_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
      .addTag(NTMBlockTags.NEEDS_NETHERRITE_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_STEEL_TOOL)
      .addTag(NTMBlockTags.NEEDS_NETHERRITE_TOOL.id())
      .addTag(BlockTags.NEEDS_DIAMOND_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_TITANIUM_TOOL)
      .addTag(NTMBlockTags.NEEDS_NETHERRITE_TOOL.id())
      .addTag(BlockTags.NEEDS_DIAMOND_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_ADVANCED_ALLOY_TOOL)
      .addTag(NTMBlockTags.NEEDS_NETHERRITE_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_CMB_STEEL_TOOL)
      .addTag(NTMBlockTags.NEEDS_NETHERRITE_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_DESH_TOOL)
      .addTag(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_COBALT_TOOL)
      .addTag(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_DECORATED_COBALT_TOOL)
      .addTag(NTMBlockTags.NEEDS_SCHRABIDIUM_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_STARMETAL_TOOL)
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_SCHRABIDIUM_TOOL)
      .addTag(NTMBlockTags.NEEDS_BISMUTH_TOOL.id())
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_BISMUTH_TOOL)
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_MOLTEN_TOOL)
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_CHLOROPHYTE_TOOL)
      .addTag(NTMBlockTags.NEEDS_MESE_TOOL.id());
    getTagBuilder(NTMBlockTags.INCORRECT_FOR_MESE_TOOL);

    getTagBuilder(NTMBlockTags.DEPTH_ROCK)
      .add(id(NTMBlocks.DEPTH_ROCK))
      .add(id(NTMBlocks.DEPTH_CINNABAR_ORE))
      .add(id(NTMBlocks.DEPTH_ZIRCONIUM_ORE))
      .add(id(NTMBlocks.DEPTH_BORAX_ORE))
      .add(id(NTMBlocks.DEPTH_IRON_ORE_CLUSTER))
      .add(id(NTMBlocks.DEPTH_TITANIUM_ORE_CLUSTER))
      .add(id(NTMBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER))
      .add(id(NTMBlocks.NETHER_DEPTH_ROCK))
      .add(id(NTMBlocks.NETHER_DEPTH_NEODYMIUM_ORE));

    getTagBuilder(BlockTags.PICKAXE_MINEABLE)
      .add(id(NTMBlocks.URANIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_URANIUM_ORE))
      .add(id(NTMBlocks.SCORCHED_URANIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE))
      .add(id(NTMBlocks.TITANIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_TITANIUM_ORE))
      .add(id(NTMBlocks.SULFUR_ORE))
      .add(id(NTMBlocks.DEEPSLATE_SULFUR_ORE))
      .add(id(NTMBlocks.THORIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_THORIUM_ORE))
      .add(id(NTMBlocks.NITER_ORE))
      .add(id(NTMBlocks.DEEPSLATE_NITER_ORE))
      .add(id(NTMBlocks.TUNGSTEN_ORE))
      .add(id(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE))
      .add(id(NTMBlocks.ALUMINIUM_BEARING_ORE))
      .add(id(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE))
      .add(id(NTMBlocks.FLUORITE_ORE))
      .add(id(NTMBlocks.DEEPSLATE_FLUORITE_ORE))
      .add(id(NTMBlocks.LEAD_ORE))
      .add(id(NTMBlocks.DEEPSLATE_LEAD_ORE))
      .add(id(NTMBlocks.SCHRABIDIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE))
      .add(id(NTMBlocks.BERYLLIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE))
      .add(id(NTMBlocks.AUSTRALIUM_ORE))
      .add(id(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE))
      .add(id(NTMBlocks.RARE_EARTH_ORE))
      .add(id(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE))
      .add(id(NTMBlocks.COBALT_ORE))
      .add(id(NTMBlocks.DEEPSLATE_COBALT_ORE))
      .add(id(NTMBlocks.CINNEBAR_ORE))
      .add(id(NTMBlocks.DEEPSLATE_CINNEBAR_ORE))
      .add(id(NTMBlocks.COLTAN_ORE))
      .add(id(NTMBlocks.DEEPSLATE_COLTAN_ORE))
      .add(id(NTMBlocks.LIGNITE_ORE))
      .add(id(NTMBlocks.DEEPSLATE_LIGNITE_ORE))
      .add(id(NTMBlocks.ASBESTOS_ORE))
      .add(id(NTMBlocks.DEEPSLATE_ASBESTOS_ORE))
      .add(id(NTMBlocks.OIL_DEPOSIT))
      .add(id(NTMBlocks.DEEPSLATE_OIL_DEPOSIT))
      .add(id(NTMBlocks.EMPTY_OIL_DEPOSIT))
      .add(id(NTMBlocks.DEEPSLATE_EMPTY_OIL_DEPOSIT))
      .add(id(NTMBlocks.ALUMINIUM_ORE_CLUSTER))
      .add(id(NTMBlocks.DEEPSLATE_ALUMINIUM_ORE_CLUSTER))
      .add(id(NTMBlocks.COPPER_ORE_CLUSTER))
      .add(id(NTMBlocks.DEEPSLATE_COPPER_ORE_CLUSTER))
      .add(id(NTMBlocks.IRON_ORE_CLUSTER))
      .add(id(NTMBlocks.DEEPSLATE_IRON_ORE_CLUSTER))
      .add(id(NTMBlocks.TITANIUM_ORE_CLUSTER))
      .add(id(NTMBlocks.DEEPSLATE_TITANIUM_ORE_CLUSTER))
      .add(id(NTMBlocks.DEPTH_ROCK))
      .add(id(NTMBlocks.DEPTH_CINNABAR_ORE))
      .add(id(NTMBlocks.DEPTH_ZIRCONIUM_ORE))
      .add(id(NTMBlocks.DEPTH_BORAX_ORE))
      .add(id(NTMBlocks.DEPTH_IRON_ORE_CLUSTER))
      .add(id(NTMBlocks.DEPTH_TITANIUM_ORE_CLUSTER))
      .add(id(NTMBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER))
      .add(id(NTMBlocks.ALEXANDRITE_ORE))
      .add(id(NTMBlocks.DEEPSLATE_ALEXANDRITE_ORE))
      .add(id(NTMBlocks.VOLCANIC_BASALT))
      .add(id(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT))
      .add(id(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT))
      .add(id(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT))
      .add(id(NTMBlocks.GEM_RICH_VOLCANIC_BASALT))
      .add(id(NTMBlocks.MOLYSITE_RICH_VOLCANIC_BASALT))
      .add(id(NTMBlocks.SMOLDERING_NETHERRACK))
      .add(id(NTMBlocks.NETHER_COAL_ORE))
      .add(id(NTMBlocks.NETHER_URANIUM_ORE))
      .add(id(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE))
      .add(id(NTMBlocks.NETHER_PLUTONIUM_ORE))
      .add(id(NTMBlocks.NETHER_TUNGSTEN_ORE))
      .add(id(NTMBlocks.NETHER_SULFUR_ORE))
      .add(id(NTMBlocks.NETHER_PHOSPHORUS_ORE))
      .add(id(NTMBlocks.NETHER_COBALT_ORE))
      .add(id(NTMBlocks.NETHER_SCHRABIDIUM_ORE))
      .add(id(NTMBlocks.NETHER_DEPTH_ROCK))
      .add(id(NTMBlocks.NETHER_DEPTH_NEODYMIUM_ORE))
      .add(id(NTMBlocks.METEORITE_BLOCK))
      .add(id(NTMBlocks.BROKEN_METEORITE_BLOCK))
      .add(id(NTMBlocks.METEORITE_COBBLESTONE))
      .add(id(NTMBlocks.HOT_METEORITE_COBBLESTONE))
      .add(id(NTMBlocks.METEORITE_TREASURE_BLOCK))
      .add(id(NTMBlocks.METEOR_IRON_ORE))
      .add(id(NTMBlocks.METEOR_COPPER_ORE))
      .add(id(NTMBlocks.METEOR_ALUMINIUM_ORE))
      .add(id(NTMBlocks.METEOR_RARE_EARTH_ORE))
      .add(id(NTMBlocks.METEOR_COBALT_ORE))
      .add(id(NTMBlocks.GRAPHITIC_SCHIST))
      .add(id(NTMBlocks.SCHIST_IRON_ORE))
      .add(id(NTMBlocks.SCHIST_GOLD_ORE))
      .add(id(NTMBlocks.SCHIST_URANIUM_ORE))
      .add(id(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE))
      .add(id(NTMBlocks.SCHIST_COPPER_ORE))
      .add(id(NTMBlocks.SCHIST_ASBESTOS_ORE))
      .add(id(NTMBlocks.SCHIST_LITHIUM_ORE))
      .add(id(NTMBlocks.SCHIST_SCHRABIDIUM_ORE))
      .add(id(NTMBlocks.SCHIST_RARE_EARTH_ORE))
      .add(id(NTMBlocks.GAS_SHALE))
      .add(id(NTMBlocks.BAUXITE))
      .add(id(NTMBlocks.CHRYSOTILE))
      .add(id(NTMBlocks.HEMATITE))
      .add(id(NTMBlocks.LIMESTONE))
      .add(id(NTMBlocks.MALACHITE))
      .add(id(NTMBlocks.SULFUROUS_STONE))
      .add(id(NTMBlocks.TEKTITE))
      .add(id(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE))
      .add(id(NTMBlocks.TRIXITE_ORE));

    getTagBuilder(NTMBlockTags.BIG_AXE_MINEABLE)
      .addOptionalTag(BlockTags.AXE_MINEABLE.id())
      .addOptionalTag(BlockTags.HOE_MINEABLE.id());

    getTagBuilder(NTMBlockTags.BIG_PICKAXE_MINEABLE)
      .addOptionalTag(BlockTags.PICKAXE_MINEABLE.id())
      .addOptionalTag(BlockTags.SHOVEL_MINEABLE.id());
  }

  private static Identifier id(Block block){
    return Registries.BLOCK.getId(block);
  }

  @Override
  public String getName() {
    return NTM.MOD_NAME + " Block-Tag Provider";
  }
}
