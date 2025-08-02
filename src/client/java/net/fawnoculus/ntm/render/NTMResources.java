package net.fawnoculus.ntm.render;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMClient;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.render.model3d.ModelHandler;
import net.fawnoculus.ntm.render.model3d.MultiModel3D;
import net.minecraft.block.Block;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Optional;

public class NTMResources {
  public static void initialize(){
    if(!ResourceManagerHelper.registerBuiltinResourcePack(NTM.id("legacy_names"), NTM.MOD_CONTAINER, Text.translatable("resourcePack.ntm_legacy_names.name"), ResourcePackActivationType.NORMAL)){
      NTMClient.LOGGER.warn("Failed to load Legacy Names Resource Pack");
    }
    if(!ResourceManagerHelper.registerBuiltinResourcePack(NTM.id("legacy_textures"), NTM.MOD_CONTAINER, Text.translatable("resourcePack.ntm_legacy_textures.name"), ResourcePackActivationType.NORMAL)){
      NTMClient.LOGGER.warn("Failed to load Legacy Textures Resource Pack");
    }

    ModelRender.initialize();
    ModelLoadingPlugin.register(new NTMModelLoadingPlugin());
  }


  public static class Textures {
    public static final Identifier ALLOY_FURNACE_EXTENSION_TOP = of("block/alloy_furnace_top");
    public static final Identifier ALLOY_FURNACE_EXTENSION_SIDE = of("block/alloy_furnace_extension");
    public static final Identifier ALLOY_FURNACE_EXTENSION_BOTTOM = of("block/alloy_furnace_bottom");

    public static final Identifier GEIGER_COUNTER_HUD = of("gui/hud/geiger_counter");
    public static final Identifier SHIELD_INFUSION_HUD = of("gui/hud/shield_infusion");
    public static final Identifier ALLOY_FURNACE_GUI = of("gui/machine/alloy_furnace");
    public static final Identifier ELECTRIC_FURNACE_GUI = of("gui/machine/electric_furnace");
    public static final Identifier ENERGY_STORAGE_GUI = of("gui/storage/energy_storage");

    public static final Identifier GENERIC_ENERGY_BAR = of("gui/generic/energy_bar");
    public static final Identifier GENERIC_STORAGE_MODE = of("gui/generic/storage_mode");

    private static Identifier of(String name) {
      return NTM.id("textures/" + name + ".png");
    }
  }

  public static class Model {
    public static final MultiModel3D ALLOY_FURNACE_EXTENSION = of("block/alloy_furnace_extension");


    private static MultiModel3D of(String name){
      return ModelHandler.ofWavefrontObj(NTM.id("models/obj/" + name + ".obj"));
    }
  }

  public static class ModelRender {
    private static final HashMap<String, ItemModel> ITEM_MODELS = new HashMap<>();
    private static final HashMap<String, BlockStateModel> BLOCK_MODELS = new HashMap<>();

    public static Optional<ItemModel> getItemModel(Identifier itemID){
      return Optional.ofNullable(ITEM_MODELS.get(itemID.toString()));
    }
    public static Optional<BlockStateModel> getBlockModel(Block block){
      return Optional.ofNullable(BLOCK_MODELS.get(Registries.BLOCK.getId(block).toString()));
    }

    public static void registerItemModel(Block block, ItemModel model){
      registerItemModel(Registries.ITEM.getId(block.asItem()), model);
    }
    public static void registerItemModel(Item item, ItemModel model){
      registerItemModel(Registries.ITEM.getId(item), model);
    }
    public static void registerItemModel(Identifier itemID, ItemModel model){
      ITEM_MODELS.put(itemID.toString(), model);
    }
    public static void registerBlockModel(Block block, BlockStateModel model){
      registerBlockModel(Registries.BLOCK.getId(block), model);
    }
    public static void registerBlockModel(Identifier itemID, BlockStateModel model){
      BLOCK_MODELS.put(itemID.toString(), model);
    }

    public static void initialize(){
      registerItemModel(NTMBlocks.ALLOY_FURNACE_EXTENSION,
        (state, stack, resolver, displayContext, world, user, seed) -> {}
      );
    }
  }

  public static class NTMModelLoadingPlugin implements ModelLoadingPlugin {
    @Override
    public void initialize(Context pluginContext) {
      pluginContext.modifyBlockModelAfterBake().register((blockStateModel, context) -> ModelRender.getBlockModel(context.state().getBlock()).orElse(blockStateModel));
      pluginContext.modifyItemModelAfterBake().register((itemModel, context) -> NTMResources.ModelRender.getItemModel(context.itemId()).orElse(itemModel));
    }
  }
}
