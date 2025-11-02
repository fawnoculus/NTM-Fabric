package net.fawnoculus.ntm.render;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelModifier;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMClient;
import net.fawnoculus.ntm.api.events.custom.LoadWavefrontModelTexturesEvent;
import net.fawnoculus.ntm.api.events.custom.LoadWavefrontModelsEvent;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.render.model.BlockModel3D;
import net.fawnoculus.ntm.render.model.ItemModel3D;
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

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

public class NTMResources {
  public static void initialize() {
    ModelLoadingOverrides.initialize();
    ModelLoadingOverrides.addItem(NTMBlocks.ALLOY_FURNACE_EXTENSION,
      id -> new ItemModel3D.Unbaked(WavefrontModels.ALLOY_FURNACE_EXTENSION, blockID(NTMBlocks.ALLOY_FURNACE_EXTENSION))
    );
    ModelLoadingOverrides.addBlock(NTMBlocks.ALLOY_FURNACE_EXTENSION,
      state -> new BlockModel3D.MultipartUnbaked(WavefrontModels.ALLOY_FURNACE_EXTENSION, blockID(NTMBlocks.ALLOY_FURNACE_EXTENSION))
    );
  }

  private static Identifier blockID(Block block) {
    return Registries.BLOCK.getId(block).withPrefixedPath("block/");
  }

  public static class ModelLoadingOverrides {
    private static final HashMap<Identifier, Function<BlockState, BlockStateModel.UnbakedGrouped>> BLOCK_MODEL_OVERRIDES = new HashMap<>();
    private static final HashMap<Identifier, Function<Identifier, ItemModel.Unbaked>> ITEM_MODEL_OVERRIDES = new HashMap<>();

    public static void addBlock(Block block, Function<BlockState, BlockStateModel.UnbakedGrouped> model) {
      BLOCK_MODEL_OVERRIDES.put(Registries.BLOCK.getId(block), model);
    }

    public static void addItem(ItemConvertible itemConvertible, Function<Identifier, ItemModel.Unbaked> model) {
      ITEM_MODEL_OVERRIDES.put(Registries.ITEM.getId(itemConvertible.asItem()), model);
    }

    private static BlockStateModel.UnbakedGrouped getBlockModel(BlockStateModel.UnbakedGrouped original, ModelModifier.BeforeBakeBlock.Context context) {
      Function<BlockState, BlockStateModel.UnbakedGrouped> override = BLOCK_MODEL_OVERRIDES.get(Registries.BLOCK.getId(context.state().getBlock()));
      if (override == null) return original;
      return override.apply(context.state());
    }

    private static ItemModel.Unbaked getItemModel(ItemModel.Unbaked original, ModelModifier.BeforeBakeItem.Context context) {
      Function<Identifier, ItemModel.Unbaked> override = ITEM_MODEL_OVERRIDES.get(context.itemId());
      if (override == null) return original;
      return override.apply(context.itemId());
    }

    private static void initialize() {
      // Builtin Resource Pack
      if (!ResourceManagerHelper.registerBuiltinResourcePack(NTM.id("legacy"), NTM.MOD_CONTAINER, Text.translatable("resourcePack.ntm_legacy.name"), ResourcePackActivationType.NORMAL)) {
        NTMClient.LOGGER.warn("Failed to load Legacy Resource Pack");
      }

      // Load 3d Models
      ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new IdentifiableResourceReloadListener() {
        @Override
        public Identifier getFabricId() {
          return NTM.id("wavefront_models");
        }

        @Override
        public CompletableFuture<Void> reload(Synchronizer synchronizer, ResourceManager manager, Executor prepareExecutor, Executor applyExecutor) {
          return CompletableFuture
            .runAsync(() -> {
                Profiler profiler = Profilers.get();
                profiler.push("[NTM] Loading Wavefront Models");
                NTMClient.LOGGER.info("Loading Wavefront Models");
                LoadWavefrontModelsEvent.EVENT.invoker().loadModels();
                profiler.pop();
                profiler.push("[NTM] Loading Wavefront Model Textures");
                NTMClient.LOGGER.info("Loading Wavefront Model Textures");
                LoadWavefrontModelTexturesEvent.EVENT.invoker().loadModelTextures();
                profiler.pop();
              }, prepareExecutor
            )
            .thenCompose(synchronizer::whenPrepared)
            .thenRunAsync(() -> {
            }, applyExecutor);
        }
      });

      ModelLoadingPlugin.register(pluginContext -> {
        pluginContext.modifyBlockModelBeforeBake().register(ModelLoadingOverrides::getBlockModel);
        pluginContext.modifyItemModelBeforeBake().register(ModelLoadingOverrides::getItemModel);
      });
    }
  }
}
