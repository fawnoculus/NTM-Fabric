package net.fawnoculus.ntm.client.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.misc.tags.NTMItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class NTMItemTagProvider extends FabricTagProvider<Item> {
    public NTMItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.ITEM, registriesFuture);
    }

    private static Identifier id(ItemLike itemConvertible) {
        return BuiltInRegistries.ITEM.getKey(itemConvertible.asItem());
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        // Tool Materials
        getOrCreateRawBuilder(NTMItemTags.STEEL_TOOL_MATERIALS)
          .addElement(id(NTMItems.STEEL_INGOT));
        getOrCreateRawBuilder(NTMItemTags.TITANIUM_TOOL_MATERIALS)
          .addElement(id(NTMItems.TANTALUM_INGOT));
        getOrCreateRawBuilder(NTMItemTags.ADVANCED_ALLOY_TOOL_MATERIALS)
          .addElement(id(NTMItems.ADVANCED_ALLOY_INGOT));
        getOrCreateRawBuilder(NTMItemTags.CMB_STEEL_TOOL_MATERIALS);
        getOrCreateRawBuilder(NTMItemTags.DESH_TOOL_MATERIALS);
        getOrCreateRawBuilder(NTMItemTags.COBALT_TOOL_MATERIALS);
        getOrCreateRawBuilder(NTMItemTags.DECORATED_COBALT_TOOL_MATERIALS);
        getOrCreateRawBuilder(NTMItemTags.STARMETAL_TOOL_MATERIALS);
        getOrCreateRawBuilder(NTMItemTags.SCHRABIDIUM_TOOL_MATERIALS);
        getOrCreateRawBuilder(NTMItemTags.BISMUTH_TOOL_MATERIALS);
        getOrCreateRawBuilder(NTMItemTags.MOLTEN_TOOL_MATERIALS);
        getOrCreateRawBuilder(NTMItemTags.CHLOROPHYTE_TOOL_MATERIALS);
        getOrCreateRawBuilder(NTMItemTags.MESE_TOOL_MATERIALS);

        getOrCreateRawBuilder(NTMItemTags.URANIUM_ORES)
          .addElement(id(NTMBlocks.URANIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_URANIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.SCHIST_URANIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.NETHER_URANIUM_ORE.asItem()))
          .addElement(id(NTMItems.RAW_URANIUM));

        getOrCreateRawBuilder(NTMItemTags.SCORCHED_URANIUM_ORES)
          .addElement(id(NTMBlocks.SCORCHED_URANIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE.asItem()))
          .addElement(id(NTMItems.RAW_SCORCHED_URANIUM));

        getOrCreateRawBuilder(NTMItemTags.THORIUM_ORES)
          .addElement(id(NTMBlocks.THORIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_THORIUM_ORE.asItem()))
          .addElement(id(NTMItems.RAW_THORIUM));

        getOrCreateRawBuilder(NTMItemTags.TITANIUM_ORES)
          .addElement(id(NTMBlocks.TITANIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_TITANIUM_ORE.asItem()))
          .addElement(id(NTMItems.RAW_TITANIUM))
        ;
        getOrCreateRawBuilder(NTMItemTags.NITER_ORES)
          .addElement(id(NTMBlocks.NITER_ORE.asItem()))
          .addElement(id(NTMBlocks.NITER_ORE.asItem()));

        getOrCreateRawBuilder(NTMItemTags.SULFUR_ORES)
          .addElement(id(NTMBlocks.SULFUR_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_SULFUR_ORE.asItem()))
          .addElement(id(NTMBlocks.NETHER_SULFUR_ORE.asItem()))
          .addElement(id(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT.asItem()));

        getOrCreateRawBuilder(NTMItemTags.TUNGSTEN_ORES)
          .addElement(id(NTMBlocks.TUNGSTEN_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE.asItem()))
          .addElement(id(NTMBlocks.NETHER_TUNGSTEN_ORE.asItem()));

        getOrCreateRawBuilder(NTMItemTags.CRYOLITE_ORES)
          .addElement(id(NTMBlocks.ALUMINIUM_BEARING_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE.asItem()))
          .addElement(id(NTMItems.RAW_CRYOLITE));

        getOrCreateRawBuilder(NTMItemTags.FLUORITE_ORES)
          .addElement(id(NTMBlocks.FLUORITE_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_FLUORITE_ORE.asItem()))
          .addElement(id(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT.asItem()));

        getOrCreateRawBuilder(NTMItemTags.BERYLLIUM_ORES)
          .addElement(id(NTMBlocks.BERYLLIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE.asItem()))
          .addElement(id(NTMItems.RAW_BERYLLIUM));

        getOrCreateRawBuilder(NTMItemTags.LEAD_ORES)
          .addElement(id(NTMBlocks.LEAD_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_LEAD_ORE.asItem()))
          .addElement(id(NTMItems.RAW_LEAD));

        getOrCreateRawBuilder(NTMItemTags.LIGNITE_ORES)
          .addElement(id(NTMBlocks.LIGNITE_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_LIGNITE_ORE.asItem()));

        getOrCreateRawBuilder(NTMItemTags.ASBESTOS_ORES)
          .addElement(id(NTMBlocks.ASBESTOS_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_ASBESTOS_ORE.asItem()))
          .addElement(id(NTMBlocks.SCHIST_ASBESTOS_ORE.asItem()))
          .addElement(id(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT.asItem()));

        getOrCreateRawBuilder(NTMItemTags.SCHRABIDIUM_ORES)
          .addElement(id(NTMBlocks.SCHRABIDIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.SCHIST_SCHRABIDIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.NETHER_SCHRABIDIUM_ORE.asItem()))
          .addElement(id(NTMItems.RAW_SCHRABIDIUM));

        getOrCreateRawBuilder(NTMItemTags.AUSTRALIUM_ORES)
          .addElement(id(NTMBlocks.AUSTRALIUM_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE.asItem()));

        getOrCreateRawBuilder(NTMItemTags.RARE_EARTH_ORES)
          .addElement(id(NTMBlocks.RARE_EARTH_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE.asItem()))
          .addElement(id(NTMBlocks.SCHIST_RARE_EARTH_ORE.asItem()));

        getOrCreateRawBuilder(NTMItemTags.COBALT_ORES)
          .addElement(id(NTMBlocks.COBALT_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_COBALT_ORE.asItem()));

        getOrCreateRawBuilder(NTMItemTags.CINNABAR_ORES)
          .addElement(id(NTMBlocks.CINNEBAR_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_CINNEBAR_ORE.asItem()));

        getOrCreateRawBuilder(NTMItemTags.COLTAN_ORES)
          .addElement(id(NTMBlocks.COLTAN_ORE.asItem()))
          .addElement(id(NTMBlocks.DEEPSLATE_COLTAN_ORE.asItem()));

        getOrCreateRawBuilder(NTMItemTags.PLUTONIUM_ORES)
          .addElement(id(NTMBlocks.NETHER_PLUTONIUM_ORE.asItem()))
          .addElement(id(NTMItems.RAW_PLUTONIUM));

        getOrCreateRawBuilder(NTMItemTags.PHOSPHORUS_ORES)
          .addElement(id(NTMBlocks.NETHER_PHOSPHORUS_ORE.asItem()));

        getOrCreateRawBuilder(NTMItemTags.TRIXITE_ORES)
          .addElement(id(NTMBlocks.TRIXITE_ORE.asItem()))
          .addElement(id(NTMItems.RAW_TRIXITE));

        getOrCreateRawBuilder(NTMItemTags.OSMIRIDIUM_ORES)
          .addElement(id(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE.asItem()))
          .addElement(id(NTMItems.RAW_METEORIC_IRON));

        getOrCreateRawBuilder(NTMItemTags.METEORIC_IRON_ORES)
          .addElement(id(NTMBlocks.METEOR_IRON_ORE.asItem()))
          .addElement(id(NTMItems.RAW_METEORIC_IRON));

        getOrCreateRawBuilder(NTMItemTags.METEORIC_COPPER_ORES)
          .addElement(id(NTMBlocks.METEOR_COPPER_ORE.asItem()))
          .addElement(id(NTMItems.RAW_METEORIC_COPPER));

        getOrCreateRawBuilder(NTMItemTags.METEORIC_ALUMINIUM_ORES)
          .addElement(id(NTMBlocks.METEOR_ALUMINIUM_ORE.asItem()))
          .addElement(id(NTMItems.RAW_METEORIC_ALUMINIUM));

        getOrCreateRawBuilder(NTMItemTags.METEORIC_RARE_EARTH_ORES)
          .addElement(id(NTMBlocks.METEOR_RARE_EARTH_ORE.asItem()))
          .addElement(id(NTMItems.RAW_METEORIC_RARE_EARTH));

        getOrCreateRawBuilder(NTMItemTags.METEORIC_COBALT_ORES)
          .addElement(id(NTMBlocks.METEOR_COBALT_ORE.asItem()))
          .addElement(id(NTMItems.RAW_METEORIC_COBALT));

        // Ore Items
    }

    @Override
    public String getName() {
        return NTM.MOD_NAME + " Item-Tag Provider";
    }
}
