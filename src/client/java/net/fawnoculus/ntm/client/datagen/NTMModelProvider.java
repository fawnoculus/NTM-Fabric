package net.fawnoculus.ntm.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceBlock;
import net.fawnoculus.ntm.blocks.custom.ElectricFurnaceBlock;
import net.fawnoculus.ntm.items.NTMItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;


public class NTMModelProvider extends FabricModelProvider {
    public static final TextureSlot BARREL_TEXTURE_KEY = TextureSlot.create("barrel");
    public static final TexturedModel.Provider SIMPLE_BARREL = TexturedModel.createDefault(
      block -> new TextureMapping().put(BARREL_TEXTURE_KEY, TextureMapping.getBlockTexture(block)),
      new ModelTemplate(Optional.empty(), Optional.empty(), BARREL_TEXTURE_KEY)
    );
    public static final TextureMapping EMPTY_BLOCK_TEXTURE = new TextureMapping();
    public static final TexturedModel.Provider EMPTY_BLOCK_MODEL = TexturedModel.createDefault(block -> EMPTY_BLOCK_TEXTURE, new ModelTemplate(Optional.of(Identifier.withDefaultNamespace("block/block")), Optional.empty()));
    public static final ModelTemplate HANDHELD_LARGE = item("handheld_large", TextureSlot.LAYER0);


    public NTMModelProvider(FabricDataOutput output) {
        super(output);
    }

    private static void registerSimpleHorizontalOrientable(@NotNull BlockModelGenerators blockStateModelGenerator, Block block) {
        MultiVariant weightedVariant = BlockModelGenerators.plainVariant(TexturedModel.ORIENTABLE_ONLY_TOP.create(block, blockStateModelGenerator.modelOutput));
        blockStateModelGenerator.blockStateOutput
          .accept(
            MultiVariantGenerator.dispatch(block)
              .with(
                PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                  .select(Direction.NORTH, weightedVariant)
                  .select(Direction.EAST, weightedVariant.with(BlockModelGenerators.Y_ROT_90))
                  .select(Direction.SOUTH, weightedVariant.with(BlockModelGenerators.Y_ROT_180))
                  .select(Direction.WEST, weightedVariant.with(BlockModelGenerators.Y_ROT_270))
              )
          );
    }

    private static ModelTemplate item(String parent, TextureSlot... requiredTextureKeys) {
        return new ModelTemplate(Optional.of(NTM.id("item/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialCube(NTMBlocks.URANIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_URANIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCORCHED_URANIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_SCORCHED_URANIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.TITANIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_TITANIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SULFUR_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_SULFUR_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.THORIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_THORIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NITER_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_NITER_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.TUNGSTEN_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_TUNGSTEN_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.ALUMINIUM_BEARING_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_ALUMINIUM_BEARING_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.FLUORITE_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_FLUORITE_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.LEAD_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_LEAD_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCHRABIDIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_SCHRABIDIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.BERYLLIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_BERYLLIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.AUSTRALIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_AUSTRALIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.RARE_EARTH_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_RARE_EARTH_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.COBALT_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_COBALT_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.CINNEBAR_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_CINNEBAR_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.COLTAN_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_COLTAN_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.LIGNITE_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_LIGNITE_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.ASBESTOS_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_ASBESTOS_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.OIL_DEPOSIT);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_OIL_DEPOSIT);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.EMPTY_OIL_DEPOSIT);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_EMPTY_OIL_DEPOSIT);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.ALUMINIUM_ORE_CLUSTER);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_ALUMINIUM_ORE_CLUSTER);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.COPPER_ORE_CLUSTER);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_COPPER_ORE_CLUSTER);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.IRON_ORE_CLUSTER);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_IRON_ORE_CLUSTER);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.TITANIUM_ORE_CLUSTER);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_TITANIUM_ORE_CLUSTER);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEAD_DIRT);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.OILY_DIRT);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.OILY_SAND);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEPTH_ROCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEPTH_CINNABAR_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEPTH_ZIRCONIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEPTH_BORAX_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEPTH_IRON_ORE_CLUSTER);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEPTH_TITANIUM_ORE_CLUSTER);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEPTH_TUNGSTEN_ORE_CLUSTER);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.ALEXANDRITE_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        blockStateModelGenerator.createTrivialBlock(NTMBlocks.VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
        blockStateModelGenerator.createTrivialBlock(NTMBlocks.SULFUR_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
        blockStateModelGenerator.createTrivialBlock(NTMBlocks.FLUORITE_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
        blockStateModelGenerator.createTrivialBlock(NTMBlocks.ASBESTOS_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
        blockStateModelGenerator.createTrivialBlock(NTMBlocks.GEM_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
        blockStateModelGenerator.createTrivialBlock(NTMBlocks.MOLYSITE_RICH_VOLCANIC_BASALT, TexturedModel.CUBE_TOP);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SMOLDERING_NETHERRACK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NETHER_COAL_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NETHER_URANIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCORCHED_NETHER_URANIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NETHER_PLUTONIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NETHER_TUNGSTEN_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NETHER_SULFUR_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NETHER_PHOSPHORUS_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NETHER_COBALT_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NETHER_SCHRABIDIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NETHER_DEPTH_ROCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NETHER_DEPTH_NEODYMIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.METEORITE_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.BROKEN_METEORITE_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.METEORITE_COBBLESTONE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.HOT_METEORITE_COBBLESTONE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.METEORITE_TREASURE_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.METEOR_IRON_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.METEOR_COPPER_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.METEOR_ALUMINIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.METEOR_RARE_EARTH_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.METEOR_COBALT_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.GRAPHITIC_SCHIST);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCHIST_IRON_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCHIST_GOLD_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCHIST_URANIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCORCHED_SCHIST_URANIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCHIST_COPPER_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCHIST_ASBESTOS_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCHIST_LITHIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCHIST_SCHRABIDIUM_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCHIST_RARE_EARTH_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.GAS_SHALE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.BAUXITE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.CHRYSOTILE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.HEMATITE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.LIMESTONE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.MALACHITE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SULFUROUS_STONE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.TEKTITE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.OSMIRIDIUM_INFUSED_TEKTITE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.TRIXITE_ORE);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.GEOTHERMAL_VENT);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.BEDROCK_OIL_DEPOSIT);

        blockStateModelGenerator.createTrivialCube(NTMBlocks.ACTINIUM_227_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.ADVANCED_ALLOY_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.ALUMINIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.ASBESTOS_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.AUSTRALIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.BAKELITE_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.BERYLLIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.BISMUTH_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.BORON_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.CADMIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.CADMIUM_STEEL_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.CMB_STEEL_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.COAL_COKE_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.COBALT_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.COLTAN_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DESH_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.DINEUTRONIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.EUPHEMIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.FERRIC_SCHRABIDATE_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.FLUORITE_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.GRAPHITE_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.HIGH_SPEED_STEEL_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.LIGNITE_COKE_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.LEAD_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.LITHIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.MAGNETIZED_TUNGSTEN_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.MOX_FUEL_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NEPTUNIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NIOBIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.NITER_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.PETROLEUM_COKE_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.PLUTONIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.PLUTONIUM_FUEL_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.REACTOR_GRADE_PLUTONIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.PLUTONIUM_238_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.PLUTONIUM_239_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.PLUTONIUM_240_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.PLUTONIUM_241_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.POLONIUM_210_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.POLYMER_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.RADIUM_226_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.RED_COPPER_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.RED_PHOSPHORUS_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.RUBBER_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCHRABIDIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCHRABIDIUM_FUEL_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SCHRARANIUM_BLOCK);
        blockStateModelGenerator.createTrivialBlock(NTMBlocks.SEMTEX_BLOCK, TexturedModel.CUBE_TOP);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SOLINIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.STARMETAL_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.STEEL_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.SULFUR_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.TANTALUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.TECHNETIUM_STEEL_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.THORIUM_232_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.THORIUM_FUEL_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.TITANIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.TUNGSTEN_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.URANIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.URANIUM_FUEL_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.URANIUM_233_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.URANIUM_235_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.URANIUM_238_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.WHITE_PHOSPHORUS_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.YELLOWCAKE_BLOCK);
        blockStateModelGenerator.createTrivialCube(NTMBlocks.ZIRCONIUM_BLOCK);

        blockStateModelGenerator.createTrivialBlock(NTMBlocks.ALLOY_FURNACE_EXTENSION, EMPTY_BLOCK_MODEL);

    /* FIXME
    blockStateModelGenerator.registerSingleton(NTMBlocks.EXPLOSIVE_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.IMP_RESIDUE_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.KEROSENE_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.LOX_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.RADIOACTIVE_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.VITRIFIED_NUCLEAR_WASTE_DRUM, SIMPLE_BARREL);
    */

    /* FIXME
    blockStateModelGenerator.registerSingleton(NTMBlocks.CORRODED_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.SAFE_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.IRON_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.STEEL_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.TECHNETIUM_STEEL_BARREL, SIMPLE_BARREL);
    blockStateModelGenerator.registerSingleton(NTMBlocks.MAGNETIC_BARREL, SIMPLE_BARREL);
   */

        registerSimpleHorizontalOrientable(blockStateModelGenerator, NTMBlocks.POTATO_BATTERY_BLOCK);
        registerSimpleHorizontalOrientable(blockStateModelGenerator, NTMBlocks.ENERGY_STORAGE_BLOCK);
        registerSimpleHorizontalOrientable(blockStateModelGenerator, NTMBlocks.LITHIUM_ION_ENERGY_STORAGE_BLOCK);
        registerSimpleHorizontalOrientable(blockStateModelGenerator, NTMBlocks.SCHRABIDIUM_ENERGY_STORAGE_BLOCK);
        registerSimpleHorizontalOrientable(blockStateModelGenerator, NTMBlocks.SPARK_ENERGY_STORAGE_BLOCK);


        TextureMapping alloyFurnaceTextureMap = new TextureMapping()
          .put(TextureSlot.TOP, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_top"))
          .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_side"))
          .put(TextureSlot.FRONT, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_front"))
          .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_bottom"));
        TextureMapping litAlloyFurnaceTextureMap = new TextureMapping()
          .put(TextureSlot.TOP, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_top_lit"))
          .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_side"))
          .put(TextureSlot.FRONT, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_front_lit"))
          .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_bottom"));
        TextureMapping tallAlloyFurnaceTextureMap = new TextureMapping()
          .put(TextureSlot.TOP, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_top"))
          .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_side_tall"))
          .put(TextureSlot.FRONT, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_front_tall"))
          .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_bottom"));
        TextureMapping litTallAlloyFurnaceTextureMap = new TextureMapping()
          .put(TextureSlot.TOP, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_top_lit"))
          .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_side_tall"))
          .put(TextureSlot.FRONT, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_front_lit_tall"))
          .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(NTMBlocks.ALLOY_FURNACE, "_bottom"));

        MultiVariant alloyFurnaceweightedVariant = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_ORIENTABLE_TOP_BOTTOM.createWithSuffix(NTMBlocks.ALLOY_FURNACE, "", alloyFurnaceTextureMap, blockStateModelGenerator.modelOutput));
        MultiVariant litAlloyFurnaceweightedVariant = BlockModelGenerators.plainVariant(blockStateModelGenerator.createSuffixedVariant(NTMBlocks.ALLOY_FURNACE, "_lit", ModelTemplates.CUBE_ORIENTABLE_TOP_BOTTOM, a -> litAlloyFurnaceTextureMap));
        MultiVariant tallAlloyFurnaceweightedVariant = BlockModelGenerators.plainVariant(blockStateModelGenerator.createSuffixedVariant(NTMBlocks.ALLOY_FURNACE, "_tall", ModelTemplates.CUBE_ORIENTABLE_TOP_BOTTOM, a -> tallAlloyFurnaceTextureMap));
        MultiVariant litTallAlloyFurnaceweightedVariant = BlockModelGenerators.plainVariant(blockStateModelGenerator.createSuffixedVariant(NTMBlocks.ALLOY_FURNACE, "_lit_tall", ModelTemplates.CUBE_ORIENTABLE_TOP_BOTTOM, a -> litTallAlloyFurnaceTextureMap));
        blockStateModelGenerator.blockStateOutput
          .accept(
            MultiVariantGenerator.dispatch(NTMBlocks.ALLOY_FURNACE)
              .with(
                PropertyDispatch.initial(AlloyFurnaceBlock.FACING, AlloyFurnaceBlock.LIT, AlloyFurnaceBlock.EXTENSION)
                  .select(Direction.NORTH, false, false, alloyFurnaceweightedVariant)
                  .select(Direction.EAST, false, false, alloyFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_90))
                  .select(Direction.SOUTH, false, false, alloyFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_180))
                  .select(Direction.WEST, false, false, alloyFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_270))
                  .select(Direction.NORTH, true, false, litAlloyFurnaceweightedVariant)
                  .select(Direction.EAST, true, false, litAlloyFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_90))
                  .select(Direction.SOUTH, true, false, litAlloyFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_180))
                  .select(Direction.WEST, true, false, litAlloyFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_270))
                  .select(Direction.NORTH, false, true, tallAlloyFurnaceweightedVariant)
                  .select(Direction.EAST, false, true, tallAlloyFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_90))
                  .select(Direction.SOUTH, false, true, tallAlloyFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_180))
                  .select(Direction.WEST, false, true, tallAlloyFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_270))
                  .select(Direction.NORTH, true, true, litTallAlloyFurnaceweightedVariant)
                  .select(Direction.EAST, true, true, litTallAlloyFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_90))
                  .select(Direction.SOUTH, true, true, litTallAlloyFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_180))
                  .select(Direction.WEST, true, true, litTallAlloyFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_270))
              )
          );

        TextureMapping electricFurnaceTextureMap = new TextureMapping()
          .put(TextureSlot.TOP, TextureMapping.getBlockTexture(NTMBlocks.ELECTRIC_FURNACE, "_top"))
          .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(NTMBlocks.ELECTRIC_FURNACE, "_side"))
          .put(TextureSlot.FRONT, TextureMapping.getBlockTexture(NTMBlocks.ELECTRIC_FURNACE, "_front"))
          .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(NTMBlocks.ELECTRIC_FURNACE, "_bottom"));
        TextureMapping litElectricFurnaceTextureMap = new TextureMapping()
          .put(TextureSlot.TOP, TextureMapping.getBlockTexture(NTMBlocks.ELECTRIC_FURNACE, "_top"))
          .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(NTMBlocks.ELECTRIC_FURNACE, "_side"))
          .put(TextureSlot.FRONT, TextureMapping.getBlockTexture(NTMBlocks.ELECTRIC_FURNACE, "_front_lit"))
          .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(NTMBlocks.ELECTRIC_FURNACE, "_bottom"));
        MultiVariant electricFurnaceweightedVariant = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_ORIENTABLE_TOP_BOTTOM.createWithSuffix(NTMBlocks.ELECTRIC_FURNACE, "", electricFurnaceTextureMap, blockStateModelGenerator.modelOutput));
        MultiVariant litElectricFurnaceweightedVariant = BlockModelGenerators.plainVariant(blockStateModelGenerator.createSuffixedVariant(NTMBlocks.ELECTRIC_FURNACE, "_lit", ModelTemplates.CUBE_ORIENTABLE_TOP_BOTTOM, a -> litElectricFurnaceTextureMap));
        blockStateModelGenerator.blockStateOutput
          .accept(
            MultiVariantGenerator.dispatch(NTMBlocks.ELECTRIC_FURNACE)
              .with(
                PropertyDispatch.initial(ElectricFurnaceBlock.FACING, ElectricFurnaceBlock.LIT)
                  .select(Direction.NORTH, false, electricFurnaceweightedVariant)
                  .select(Direction.EAST, false, electricFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_90))
                  .select(Direction.SOUTH, false, electricFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_180))
                  .select(Direction.WEST, false, electricFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_270))
                  .select(Direction.NORTH, true, litElectricFurnaceweightedVariant)
                  .select(Direction.EAST, true, litElectricFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_90))
                  .select(Direction.SOUTH, true, litElectricFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_180))
                  .select(Direction.WEST, true, litElectricFurnaceweightedVariant.with(BlockModelGenerators.Y_ROT_270))
              )
          );
        registerSimpleHorizontalOrientable(blockStateModelGenerator, NTMBlocks.PWR_CONTROLLER);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        // Basic Items
        itemModelGenerator.generateFlatItem(NTMItems.NULL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_238_RTG_PELLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TUNGSTEN_REACHER, ModelTemplates.FLAT_ITEM);

        // Raw Resources
        itemModelGenerator.generateFlatItem(NTMItems.ACTINIUM_227_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ACTINIUM_227_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ACTINIUM_227_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_ACTINIUM_227_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ACTINIUM_227_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ACTINIUM_227_FRAGMENT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.ADVANCED_ALLOY_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ADVANCED_ALLOY_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ADVANCED_ALLOY_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_ADVANCED_ALLOY_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ADVANCED_ALLOY_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_ADVANCED_ALLOY_WIRE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.ALEXANDRITE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_METEORIC_ALUMINIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ALUMINIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ALUMINIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ALUMINIUM_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_ALUMINIUM_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WELDED_ALUMINIUM_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ALUMINIUM_SHELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ALUMINIUM_PIPE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ALUMINIUM_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ALUMINIUM_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.AMERICIUM_241_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AMERICIUM_241_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AMERICIUM_241_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AMERICIUM_242_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AMERICIUM_242_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AMERICIUM_242_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AMERICIUM_FUEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AMERICIUM_FUEL_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AMERICIUM_FUEL_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.REACTOR_GRADE_AMERICIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.REACTOR_GRADE_AMERICIUM_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.REACTOR_GRADE_AMERICIUM_ZFB_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.REACTOR_GRADE_AMERICIUM_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.ARSENIC_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ARSENIC_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ARSENIC_BRONZE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_ARSENIC_BRONZE_PLATE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.ASBESTOS_SHEET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ASBESTOS_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.ASTATINE_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ASTATINE_209_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.ASH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WOOD_ASH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COAL_ASH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.FLY_ASH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.FINE_SOOT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_AUSTRALIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AUSTRALIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AUSTRALIUM_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AUSTRALIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LESSER_AUSTRALIUM_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LESSER_AUSTRALIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GREATER_AUSTRALIUM_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GREATER_AUSTRALIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AUSTRALIUM_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.BAKELITE_BAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BAKELITE_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.BALEFIRE_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BALEFIRE_SHARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.THERMONUCLEAR_ASHES, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_BERYLLIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BERYLLIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BERYLLIUM_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BERYLLIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BERYLLIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BERYLLIUM_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.BISMUTH_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BISMUTH_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BISMUTH_ZFB_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BISMUTH_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BISMUTH_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BISMUTH_BRONZE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_BISMUTH_BRONZE_PLATE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.BORAX_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.BORON_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BORON_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_BORON_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BORON_FRAGMENT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.BROMINE_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.BSCCO_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_BSCCO_WIRE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.CADMIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CADMIUM_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.CAESIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAESIUM_137_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_CAESIUM_137_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.CALCIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CALCIUM_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.CADMIUM_STEEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_CADMIUM_STEEL_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WELDED_CADMIUM_STEEL_PLATE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.CEMENT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.CERIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_CERIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CERIUM_FRAGMENT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.CHLOROCALCITE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.CHLOROPHYTE_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.CINNABAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CINNABAR_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.CMB_STEEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CMB_STEEL_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_CMB_STEEL_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WELDED_CMB_STEEL_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CMB_STEEL_PLATE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.COAL_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_COAL_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CARBON_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COAL_BRIQUETTE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COAL_COKE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.COBALT_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_COBALT_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_60_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_60_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_60_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_60_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_FRAGMENT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_CRYSTALS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RAW_METEORIC_COBALT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.COLTAN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CRUSHED_COLTAN, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.COPPER_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COPPER_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_COPPER_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WELDED_COPPER_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COPPER_PIPE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COPPER_SHELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COPPER_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_COPPER_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COPPER_CRYSTALS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RAW_METEORIC_COPPER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.CRYO_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_CRYOLITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CRYOLITE_CHUNK, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.DESH_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DESH_BLEND, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DESHREADY_BLEND, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DESH_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DESH_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_DESH_PLATE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.DIAMOND_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DIAMOND_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.DINEUTRONIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DINEUTRONIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DINEUTRONIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_DINEUTRONIUM_WIRE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.ELECTRONIUM_INGOT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.EMERALD_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.ENERGY_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.EUPHEMIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.EUPHEMIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.EUPHEMIUM_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.FERRIC_SCHARBIDATE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.FERRIC_SCHARBIDATE_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_FERRIC_SCHARBIDATE_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_FERRIC_SCHARBIDATE_WIRE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.FERROURANIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_FERROURANIUM_PLATE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.FLASH_GOLD, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.FLASH_LEAD, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.FLUORITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.FLUORITE_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.FLUX, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.FULLERENE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CRYSTALLINE_FULLERENE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.GHIORSIUM_336_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GHIORSIUM_336_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GHIORSIUM_336_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.GOLD_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GOLD_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_GOLD_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GOLD_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_GOLD_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GOLD_CRYSTALS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GOLD_198_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GOLD_198_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GOLD_198_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GOLD_198_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.GRAPHITE_INGOT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.GUNMETAL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GUNMETAL_PLATE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.HARD_PLASTIC_BAR, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.HIGH_SPEED_STEEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.HIGH_SPEED_STEEL_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_HIGH_SPEED_STEEL_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.HIGH_SPEED_STEEL_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.HIGH_SPEED_STEEL_BOLT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.HIGH_SPEED_STEEL_PIPE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.IODINE_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.IODINE_131_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_IODINE_131_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.IRON_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.IRON_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_IRON_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WELDED_IRON_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.IRON_PIPE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.IRON_CRYSTALS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RAW_METEORIC_IRON, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.INDUSTRIAL_FERTILIZER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.INFERNAL_COAL, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.SEMI_STABLE_LANTHANUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LANTHANUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_LANTHANUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LANTHANUM_FRAGMENT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.LAPIS_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LAPIS_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.LATEX, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LATEX_BAR, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_LEAD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LEAD_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LEAD_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LEAD_209_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LEAD_209_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LEAD_209_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LEAD_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LEAD_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_LEAD_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LEAD_PIPE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LEAD_BOLT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LEAD_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LEAD_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.LIGNITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LIGNITE_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LIGNITE_COKE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LIGNITE_BRIQUETTE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.LIMESTONE_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.LITHIUM_CUBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LITHIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_LITHIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LITHIUM_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.MAGNETIZED_TUNGSTEN_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.MAGNETIZED_TUNGSTEN_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.MAGNETIZED_TUNGSTEN_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_MAGNETIZED_TUNGSTEN_WIRE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.METEORITE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.METEORITE_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_METEORITE_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.METEORITE_FRAGMENT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.MOLYSITE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.MOX_FUEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.MOX_FUEL_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.MOX_FUEL_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.NEODYMIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_NEODYMIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_NEODYMIUM_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NEODYMIUM_FRAGMENT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.NEPTUNIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NEPTUNIUM_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NEPTUNIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NEPTUNIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NEPTUNIUM_FUEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NEPTUNIUM_FUEL_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NEPTUNIUM_FUEL_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.NIOBIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NIOBIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_NIOBIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NIOBIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_NIOBIUM_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NIOBIUM_FRAGMENT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.NITAN_BLEND, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.NITER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NITER_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.NITRA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SMALL_PILE_OF_NITRA, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_OSMIRIDIUM_INFUSED_TEKTITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.OSMIRIDIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.OSMIRIDIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.IMPURE_OSMIRIDIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_OSMIRIDIUM_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WELDED_OSMIRIDIUM_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.OSMIRIDIUM_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.PALEOGENITE_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_PALEOGENITE_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RED_PHOSPHORUS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WHITE_PHOSPHORUS_BAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PHOSPHORUS_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.PETROLEUM_COKE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_PLUTONIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_FUEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_FUEL_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_FUEL_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.REACTOR_GRADE_PLUTONIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.REACTOR_GRADE_PLUTONIUM_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.REACTOR_GRADE_PLUTONIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_238_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_238_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_238_BE_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_238_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_239_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_239_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_239_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_240_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_240_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_240_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_241_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_241_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_241_ZFB_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_241_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PLUTONIUM_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.POISON_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.POLONIUM_210_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.POLONIUM_210_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.POLONIUM_210_BE_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.POLONIUM_210_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.POLONIUM_210_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.POLYMER_BAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.POLYMER_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.PULVERIZED_ENCHANTMENT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.PVC_BAR, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.QUARTZ_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RADIUM_226_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RADIUM_226_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RADIUM_226_BE_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RADIUM_226_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RADIUM_226_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RARE_EARTH_ORE_CHUNK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RARE_EARTH_CRYSTALS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RAW_METEORIC_RARE_EARTH, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RED_COPPER_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RED_COPPER_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RED_COPPER_WIRE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.REDSTONE_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RUBBER_BAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RUBBER_PIPE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.SATURNITE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SATURNITE_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_SATURNITE_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SATURNITE_SHELL, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.SAWDUST_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SAWDUST_BRIQUETTE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_SCHRABIDIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_FUEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_FUEL_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_FUEL_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LOW_ENRICHED_SCHRABIDIUM_FUEL_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.HIGHLY_ENRICHED_SCHRABIDIUM_FUEL_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_SCHRABIDIUM_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_SCHRABIDIUM_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.SCHRARANIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRARANIUM_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.SEMTEX_BLEND, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SEMTEX_BAR, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.SILICON_BOULE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SILICON_WAFER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PRINTED_SILICON_WAFER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SILICON_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.SODIUM_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.SOLINIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SOLINIUM_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SOLINIUM_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.SPARK_BLEND, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.STARMETAL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_STARMETAL_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STARMETAL_RING, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STARMETAL_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.STRONTIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STRONTIUM_90_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STRONTIUM_90_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STRONTIUM_90_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_STRONTIUM_90_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STRONTIUM_90_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.STEEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STEEL_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_STEEL_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STEEL_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_STEEL_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WELDED_STEEL_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STEEL_BOLT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STEEL_PIPE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STEEL_SHELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STEEL_WIRE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.SULFUR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SULFUR_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.PURIFIED_TANTALITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TANTALUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TANTALUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TANTALUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TANTALUM_POLYCRYSTAL, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.TECHNETIUM_99_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TECHNETIUM_99_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TECHNETIUM_99_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.TECHNETIUM_STEEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TECHNETIUM_STEEL_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_TECHNETIUM_STEEL_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WELDED_TECHNETIUM_STEEL_PLATE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.TEKTITE_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.TENNESSINE_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.THERMITE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_THORIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.THORIUM_232_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.THORIUM_FUEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.THORIUM_232_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.THORIUM_FUEL_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.THORIUM_232_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.THORIUM_FUEL_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.THORIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.THORIUM_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_TITANIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TITANIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TITANIUM_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_TITANIUM_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WELDED_TITANIUM_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TITANIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TITANIUM_SHELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_TITANIUM_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TITANIUM_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_TRIXITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TRIXITE_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_TUNGSTEN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TUNGSTEN_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TUNGSTEN_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TUNGSTEN_BOLT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TUNGSTEN_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DENSE_TUNGSTEN_WIRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TUNGSTEN_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.RAW_URANIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RAW_SCORCHED_URANIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_FUEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_FUEL_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_FUEL_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_233_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_233_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_233_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_235_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_235_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_235_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_238_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_238_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_238_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.URANIUM_CRYSTALS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.VOLCANIC_GEM, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.WEAPON_STEEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WEAPON_STEEL_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_WEAPON_STEEL_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WEAPON_STEEL_SHELL, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.XENON_135_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TINY_PILE_OF_XENON_135_POWDER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.YHARONITE_BILLET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.YELLOWCAKE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.ZIRCONIUM_SPLINTER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ZIRCONIUM_CUBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ZIRCONIUM_BILLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ZIRCONIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CAST_ZIRCONIUM_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WELDED_ZIRCONIUM_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ZIRCONIUM_WIRE, ModelTemplates.FLAT_ITEM);

        // Usable Items
        itemModelGenerator.generateFlatItem(NTMItems.DEBUG_WAND, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CONSTRUCTION_WAND, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NETWORK_DEBUG_TOOL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GEIGER_COUNTER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DOSIMETER, ModelTemplates.FLAT_ITEM);

        // Batteries
        itemModelGenerator.generateFlatItem(NTMItems.BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.REDSTONE_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SIXFOLD_REDSTONE_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TWENTY_FOUR_FOLD_REDSTONE_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ADVANCED_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ADVANCED_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.QUADRUPLE_ADVANCED_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TWELVEFOLD_ADVANCED_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LITHIUM_ION_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LITHIUM_ION_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TRIPLE_LITHIUM_ION_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SIXFOLD_LITHIUM_ION_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DOUBLE_SCHRABIDIUM_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.QUADRUPLE_SCHRABIDIUM_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SPARK_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.OFF_BRAND_SPARK_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SPARK_POWER_CELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SPARK_ARCANE_CAR_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SPARK_ARCANE_ENERGY_STORAGE_ARRAY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SPARK_ARCANE_MASS_ENERGY_VOID, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SPARK_ARCANE_DIRAC_SEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SPARK_SOLID_SPACE_TIME_CRYSTAL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SPARK_LUDICROUS_ENERGY_STORAGE_UNIT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ELECTRONIUM_CUBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.INFINITE_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.POTATO_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.POTATOS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SELF_CHARGING_URANIUM_238_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SELF_CHARGING_TECHNETIUM_99_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SELF_CHARGING_PLUTONIUM_238_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SELF_CHARGING_POLONIUM_210_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SELF_CHARGING_GOLD_198_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SELF_CHARGING_LEAD_209_BATTERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SELF_CHARGING_AMERICIUM_241_BATTERY, ModelTemplates.FLAT_ITEM);

        // Consumables
        itemModelGenerator.generateFlatItem(NTMItems.EMPTY_SYRINGE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.POISONOUS_INJECTION, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ANTIDOTE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.AWESOME, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.METAL_SYRINGE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STIMPAK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.MED_X, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PSYCHO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SUPER_STIMPAK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.WATERY_TAINT_INJECTION, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.FIRST_AID_KIT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.IV_BAG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BLOOD_BAG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.EMPTY_EXPERIENCE_BAG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.EXPERIENCE_BAG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RAD_AWAY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STRONG_RAD_AWAY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ELITE_RAD_AWAY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RAD_X, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.IODINE_PILL, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.PLAN_C, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.WAFFLE_OF_MASS_DESTRUCTION, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.VEGAN_SCHNITZEL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RADIOACTIVE_COTTON_CANDY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BASIC_LEAD_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GOOD_LEAD_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.EPIC_LEAD_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BASIC_SCHRABIDIUM_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GOOD_SCHRABIDIUM_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.EPIC_SCHRABIDIUM_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.EUPHEMIUM_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CHEAP_TEM_FLAKES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TEM_FLAKES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.EXPENSIVE_TEM_FLAKES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GLOWING_MUSHROOM_STEW, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCRAMBLED_BALEFIRE_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCRAMBLED_BALEFIRE_EGG_AND_HAM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LEMON, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.MRE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.LOOPS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.IT_BREAKFAST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SPONGEBOB_MACARONI, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.FOOD_ITEM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TWINKIE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TV_STATIC_SANDWICH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PUDDING, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCRAP_PANCAKE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CHICKEN_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PEAS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.MARSHMALLOW_ON_A_STICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ROASTED_MARSHMALLOW_ON_A_STICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CHEESE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CHEESE_QUESADILLA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GLYPHID_MEAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GRILLED_GLYPHID_MEAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.GLYPHID_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.IPECAC_SYRUP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.PTSD_MEDICATION, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STYLISH_FLASK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ARIZONA_MUCHO_MANGO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RADIUM_CHOCOLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.EMPTY_CAN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RING_PULL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SMART_ENERGY_DRINK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CREATURE_ENERGY_DRINK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RED_BOMB_ENERGY_DRINK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DR_SUGAR_SOFT_DRINK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.OVERCHARGE_DELIRIUM_XT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BLACK_MESA_LUNA_DARK_COLA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BEPIS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DR_BREENS_PRIVATE_RESERVE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.MUG_ROOT_BEER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COFFEE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.RADIUM_COFFEE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BOTTLE_OPENER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.EMPTY_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.EMPTY_BOMB_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NUKA_COLA_BOTTLE_CAP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.NUKA_COLA_QUANTUM_BOTTLE_CAP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.S_COLA_BOTTLE_CAP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.S_COLA_RAD_BOTTLE_CAP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.KAROL_BOTTLE_CAP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.FRITZ_COLA_BOTTLE_CAP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BOTTLE_OF_NUKA_COLA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BOTTLE_OF_NUKA_CHERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BOTTLE_OF_NUKA_COLA_QUANTUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BOTTLE_OF_S_COLA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BOTTLE_OF_S_COLA_RAD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BOTTLE_OF_KAROL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.FIRST_BOTTLE_OF_KAROL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.BOTTLE_OF_FRITZ_COLA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.FIRST_BOTTLE_OF_FRITZ_COLA, ModelTemplates.FLAT_ITEM);

        // Tools
        itemModelGenerator.generateFlatItem(NTMItems.STEEL_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STEEL_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STEEL_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STEEL_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STEEL_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.TITANIUM_SWORD, HANDHELD_LARGE);
        itemModelGenerator.generateFlatItem(NTMItems.TITANIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TITANIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TITANIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.TITANIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.ADVANCED_ALLOY_SWORD, HANDHELD_LARGE);
        itemModelGenerator.generateFlatItem(NTMItems.ADVANCED_ALLOY_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ADVANCED_ALLOY_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ADVANCED_ALLOY_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.ADVANCED_ALLOY_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.CMB_STEEL_SWORD, HANDHELD_LARGE);
        itemModelGenerator.generateFlatItem(NTMItems.CMB_STEEL_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CMB_STEEL_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CMB_STEEL_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.CMB_STEEL_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.DESH_SWORD, HANDHELD_LARGE);
        itemModelGenerator.generateFlatItem(NTMItems.DESH_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DESH_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DESH_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DESH_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.COBALT_SWORD, HANDHELD_LARGE);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.COBALT_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.DECORATED_COBALT_SWORD, HANDHELD_LARGE);
        itemModelGenerator.generateFlatItem(NTMItems.DECORATED_COBALT_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DECORATED_COBALT_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DECORATED_COBALT_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.DECORATED_COBALT_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.STARMETAL_SWORD, HANDHELD_LARGE);
        itemModelGenerator.generateFlatItem(NTMItems.STARMETAL_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STARMETAL_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STARMETAL_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.STARMETAL_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_SWORD, HANDHELD_LARGE);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(NTMItems.SCHRABIDIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(NTMItems.BISMUTH_PICKAXE, HANDHELD_LARGE);
        itemModelGenerator.generateFlatItem(NTMItems.BISMUTH_AXE, HANDHELD_LARGE);

        itemModelGenerator.generateFlatItem(NTMItems.MOLTEN_PICKAXE, HANDHELD_LARGE);
        itemModelGenerator.generateFlatItem(NTMItems.MOLTEN_AXE, HANDHELD_LARGE);

        itemModelGenerator.generateFlatItem(NTMItems.CHLOROPHYTE_PICKAXE, HANDHELD_LARGE);
        itemModelGenerator.generateFlatItem(NTMItems.CHLOROPHYTE_AXE, HANDHELD_LARGE);

        itemModelGenerator.generateFlatItem(NTMItems.MESE_PICKAXE, HANDHELD_LARGE);
        itemModelGenerator.generateFlatItem(NTMItems.MESE_AXE, HANDHELD_LARGE);
    }

    @Override
    public String getName() {
        return NTM.MOD_NAME + " Model Provider";
    }
}
