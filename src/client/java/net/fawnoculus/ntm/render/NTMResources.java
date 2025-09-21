package net.fawnoculus.ntm.render;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelModifier;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMClient;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.render.model.BlockModel3D;
import net.fawnoculus.ntm.render.model.ItemModel3D;
import net.fawnoculus.ntm.render.wavefront.ModelHandler;
import net.fawnoculus.ntm.render.wavefront.model.MultiMultiModel3d;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.profiler.Profilers;
import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

public class NTMResources {
  public static void initialize() {
    // Builtin Resource Pack
    if (!ResourceManagerHelper.registerBuiltinResourcePack(NTM.id("legacy"), NTM.MOD_CONTAINER, Text.translatable("resourcePack.ntm_legacy.name"), ResourcePackActivationType.NORMAL)) {
      NTMClient.LOGGER.warn("Failed to load Legacy Resource Pack");
    }

    // Load 3d Models
    ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new IdentifiableResourceReloadListener() {
      @Override
      public Identifier getFabricId() {
        return NTM.id("on_reload");
      }

      @Override
      public CompletableFuture<Void> reload(Synchronizer synchronizer, ResourceManager manager, Executor prepareExecutor, Executor applyExecutor) {
        Models.loadModels();

        return CompletableFuture
          .runAsync(NTMResources::prepareReload, prepareExecutor)
          .thenCompose(synchronizer::whenPrepared)
          .thenRunAsync(NTMResources::applyReload, applyExecutor);
      }
    });

    ModelLoadingPlugin.register(pluginContext -> {
      pluginContext.modifyBlockModelBeforeBake().register(ModelLoadingOverrides::getBlockModel);
      pluginContext.modifyItemModelBeforeBake().register(ModelLoadingOverrides::getItemModel);
    });

    ModelLoadingOverrides.addItem(NTMBlocks.ALLOY_FURNACE_EXTENSION, id -> new ItemModel3D.Unbaked(id, Models.ALLOY_FURNACE_EXTENSION));
    ModelLoadingOverrides.addBlock(NTMBlocks.ALLOY_FURNACE_EXTENSION, state -> new BlockModel3D.MultipartUnbaked(Models.ALLOY_FURNACE_EXTENSION, NTM.id("block/alloy_furnace_extension")));
  }

  private static void prepareReload(){}

  private static void applyReload(){
    Profiler profiler = Profilers.get();
    profiler.push("[NTM] loading 3d Models");
    Models.loadModels();
    profiler.pop();
  }


  public static class Models {
    public static MultiMultiModel3d ALLOY_FURNACE_EXTENSION;
    public static MultiMultiModel3d ZIRNOX;
    public static MultiMultiModel3d ZIRNOX_DESTROYED;

    private static void loadModels() {
      ALLOY_FURNACE_EXTENSION = of("alloy_furnace_extension");
      ALLOY_FURNACE_EXTENSION.getOrThrow("Top", "").setTexture(NTM.id("block/alloy_furnace_top"));
      ALLOY_FURNACE_EXTENSION.getOrThrow("Side", "").setTexture(NTM.id("block/alloy_furnace_extension"));
      ALLOY_FURNACE_EXTENSION.getOrThrow("Bottom", "").setTexture(NTM.id("block/alloy_furnace_bottom"));
      ZIRNOX = of("zirnox");
      ZIRNOX_DESTROYED = of("zirnox_destroyed");
    }

    @Contract("_ -> new")
    private static MultiMultiModel3d of(String name) {
      return ModelHandler.ofWavefrontObj(NTM.id("models/obj/" + name + ".obj"));
    }
  }

  public static class ModelLoadingOverrides {
    private static final HashMap<Identifier, Function<BlockState, BlockStateModel.UnbakedGrouped>> BLOCK_MODEL_OVERRIDES = new HashMap<>();
    private static final HashMap<Identifier, Function<Identifier, ItemModel.Unbaked>> ITEM_MODEL_OVERRIDES = new HashMap<>();

    private static BlockStateModel.UnbakedGrouped getBlockModel(BlockStateModel.UnbakedGrouped original, ModelModifier.BeforeBakeBlock.Context context){
      Function<BlockState, BlockStateModel.UnbakedGrouped> override = BLOCK_MODEL_OVERRIDES.get(Registries.BLOCK.getId(context.state().getBlock()));
      if(override == null) return original;
      return override.apply(context.state());
    }

    private static ItemModel.Unbaked getItemModel(ItemModel.Unbaked original, ModelModifier.BeforeBakeItem.Context context){
      Function<Identifier, ItemModel.Unbaked> override = ITEM_MODEL_OVERRIDES.get(context.itemId());
      if(override == null) return original;
      return override.apply(context.itemId());
    }

    public static void addBlock(Block block, Function<BlockState, BlockStateModel.UnbakedGrouped> model){
      BLOCK_MODEL_OVERRIDES.put(Registries.BLOCK.getId(block), model);
    }

    public static void addItem(ItemConvertible itemConvertible, Function<Identifier, ItemModel.Unbaked> model){
      ITEM_MODEL_OVERRIDES.put(Registries.ITEM.getId(itemConvertible.asItem()), model);
    }
  }
}
