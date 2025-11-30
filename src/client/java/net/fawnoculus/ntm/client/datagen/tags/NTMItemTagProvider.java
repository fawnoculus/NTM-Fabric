package net.fawnoculus.ntm.client.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.misc.tags.NTMItemTags;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class NTMItemTagProvider extends FabricTagProvider<Item> {
    public NTMItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    private static Identifier id(ItemConvertible itemConvertible) {
        return Registries.ITEM.getId(itemConvertible.asItem());
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Tool Materials
        getTagBuilder(NTMItemTags.STEEL_TOOL_MATERIALS)
          .add(id(NTMItems.STEEL_INGOT));
        getTagBuilder(NTMItemTags.TITANIUM_TOOL_MATERIALS)
          .add(id(NTMItems.TANTALUM_INGOT));
        getTagBuilder(NTMItemTags.ADVANCED_ALLOY_TOOL_MATERIALS)
          .add(id(NTMItems.ADVANCED_ALLOY_INGOT));
        getTagBuilder(NTMItemTags.CMB_STEEL_TOOL_MATERIALS);
        getTagBuilder(NTMItemTags.DESH_TOOL_MATERIALS);
        getTagBuilder(NTMItemTags.COBALT_TOOL_MATERIALS);
        getTagBuilder(NTMItemTags.DECORATED_COBALT_TOOL_MATERIALS);
        getTagBuilder(NTMItemTags.STARMETAL_TOOL_MATERIALS);
        getTagBuilder(NTMItemTags.SCHRABIDIUM_TOOL_MATERIALS);
        getTagBuilder(NTMItemTags.BISMUTH_TOOL_MATERIALS);
        getTagBuilder(NTMItemTags.MOLTEN_TOOL_MATERIALS);
        getTagBuilder(NTMItemTags.CHLOROPHYTE_TOOL_MATERIALS);
        getTagBuilder(NTMItemTags.MESE_TOOL_MATERIALS);

        getTagBuilder(NTMItemTags.URANIUM_ORES)
          .add(id(NTMBlocks.URANIUM_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_URANIUM_ORE.asItem()))
          .add(id(NTMBlocks.SCHIST_URANIUM_ORE.asItem()))
          .add(id(NTMBlocks.NETHER_URANIUM_ORE.asItem()))
          .add(id(NTMItems.RAW_URANIUM));

        getTagBuilder(NTMItemTags.SCORCHED_URANIUM_ORES)
          .add(id(NTMBlocks.SCORCHED_URANIUM_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE.asItem()))
          .add(id(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE.asItem()))
          .add(id(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE.asItem()))
          .add(id(NTMItems.RAW_SCORCHED_URANIUM));

        getTagBuilder(NTMItemTags.THORIUM_ORES)
          .add(id(NTMBlocks.THORIUM_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_THORIUM_ORE.asItem()))
          .add(id(NTMItems.RAW_THORIUM));

        getTagBuilder(NTMItemTags.TITANIUM_ORES)
          .add(id(NTMBlocks.TITANIUM_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_TITANIUM_ORE.asItem()))
          .add(id(NTMItems.RAW_TITANIUM))
        ;
        getTagBuilder(NTMItemTags.NITER_ORES)
          .add(id(NTMBlocks.NITER_ORE.asItem()))
          .add(id(NTMBlocks.NITER_ORE.asItem()));

        getTagBuilder(NTMItemTags.SULFUR_ORES)
          .add(id(NTMBlocks.SULFUR_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_SULFUR_ORE.asItem()))
          .add(id(NTMBlocks.NETHER_SULFUR_ORE.asItem()))
          .add(id(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT.asItem()));

        getTagBuilder(NTMItemTags.TUNGSTEN_ORES)
          .add(id(NTMBlocks.TUNGSTEN_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE.asItem()))
          .add(id(NTMBlocks.NETHER_TUNGSTEN_ORE.asItem()));

        getTagBuilder(NTMItemTags.CRYOLITE_ORES)
          .add(id(NTMBlocks.ALUMINIUM_BEARING_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE.asItem()))
          .add(id(NTMItems.RAW_CRYOLITE));

        getTagBuilder(NTMItemTags.FLUORITE_ORES)
          .add(id(NTMBlocks.FLUORITE_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_FLUORITE_ORE.asItem()))
          .add(id(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT.asItem()));

        getTagBuilder(NTMItemTags.BERYLLIUM_ORES)
          .add(id(NTMBlocks.BERYLLIUM_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE.asItem()))
          .add(id(NTMItems.RAW_BERYLLIUM));

        getTagBuilder(NTMItemTags.LEAD_ORES)
          .add(id(NTMBlocks.LEAD_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_LEAD_ORE.asItem()))
          .add(id(NTMItems.RAW_LEAD));

        getTagBuilder(NTMItemTags.LIGNITE_ORES)
          .add(id(NTMBlocks.LIGNITE_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_LIGNITE_ORE.asItem()));

        getTagBuilder(NTMItemTags.ASBESTOS_ORES)
          .add(id(NTMBlocks.ASBESTOS_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_ASBESTOS_ORE.asItem()))
          .add(id(NTMBlocks.SCHIST_ASBESTOS_ORE.asItem()))
          .add(id(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT.asItem()));

        getTagBuilder(NTMItemTags.SCHRABIDIUM_ORES)
          .add(id(NTMBlocks.SCHRABIDIUM_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE.asItem()))
          .add(id(NTMBlocks.SCHIST_SCHRABIDIUM_ORE.asItem()))
          .add(id(NTMBlocks.NETHER_SCHRABIDIUM_ORE.asItem()))
          .add(id(NTMItems.RAW_SCHRABIDIUM));

        getTagBuilder(NTMItemTags.AUSTRALIUM_ORES)
          .add(id(NTMBlocks.AUSTRALIUM_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE.asItem()));

        getTagBuilder(NTMItemTags.RARE_EARTH_ORES)
          .add(id(NTMBlocks.RARE_EARTH_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE.asItem()))
          .add(id(NTMBlocks.SCHIST_RARE_EARTH_ORE.asItem()));

        getTagBuilder(NTMItemTags.COBALT_ORES)
          .add(id(NTMBlocks.COBALT_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_COBALT_ORE.asItem()));

        getTagBuilder(NTMItemTags.CINNABAR_ORES)
          .add(id(NTMBlocks.CINNEBAR_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_CINNEBAR_ORE.asItem()));

        getTagBuilder(NTMItemTags.COLTAN_ORES)
          .add(id(NTMBlocks.COLTAN_ORE.asItem()))
          .add(id(NTMBlocks.DEEPSLATE_COLTAN_ORE.asItem()));

        getTagBuilder(NTMItemTags.PLUTONIUM_ORES)
          .add(id(NTMBlocks.NETHER_PLUTONIUM_ORE.asItem()))
          .add(id(NTMItems.RAW_PLUTONIUM));

        getTagBuilder(NTMItemTags.PHOSPHORUS_ORES)
          .add(id(NTMBlocks.NETHER_PHOSPHORUS_ORE.asItem()));

        getTagBuilder(NTMItemTags.TRIXITE_ORES)
          .add(id(NTMBlocks.TRIXITE_ORE.asItem()))
          .add(id(NTMItems.RAW_TRIXITE));

        getTagBuilder(NTMItemTags.OSMIRIDIUM_ORES)
          .add(id(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE.asItem()))
          .add(id(NTMItems.RAW_METEORIC_IRON));

        getTagBuilder(NTMItemTags.METEORIC_IRON_ORES)
          .add(id(NTMBlocks.METEOR_IRON_ORE.asItem()))
          .add(id(NTMItems.RAW_METEORIC_IRON));

        getTagBuilder(NTMItemTags.METEORIC_COPPER_ORES)
          .add(id(NTMBlocks.METEOR_COPPER_ORE.asItem()))
          .add(id(NTMItems.RAW_METEORIC_COPPER));

        getTagBuilder(NTMItemTags.METEORIC_ALUMINIUM_ORES)
          .add(id(NTMBlocks.METEOR_ALUMINIUM_ORE.asItem()))
          .add(id(NTMItems.RAW_METEORIC_ALUMINIUM));

        getTagBuilder(NTMItemTags.METEORIC_RARE_EARTH_ORES)
          .add(id(NTMBlocks.METEOR_RARE_EARTH_ORE.asItem()))
          .add(id(NTMItems.RAW_METEORIC_RARE_EARTH));

        getTagBuilder(NTMItemTags.METEORIC_COBALT_ORES)
          .add(id(NTMBlocks.METEOR_COBALT_ORE.asItem()))
          .add(id(NTMItems.RAW_METEORIC_COBALT));

        // Ore Items
    }

    @Override
    public String getName() {
        return NTM.MOD_NAME + " Item-Tag Provider";
    }
}
