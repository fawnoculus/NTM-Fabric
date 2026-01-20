package net.fawnoculus.ntm.client.render;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelModifier;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.client.NTMClient;
import net.fawnoculus.ntm.client.api.events.custom.LoadWavefrontModelTexturesEvent;
import net.fawnoculus.ntm.client.api.events.custom.LoadWavefrontModelsEvent;
import net.fawnoculus.ntm.client.render.model.BlockModel3D;
import net.fawnoculus.ntm.client.render.model.ItemModel3D;
import net.minecraft.client.renderer.block.model.BlockStateModel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;
import net.minecraft.util.profiling.Profiler;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
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
        return BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/");
    }

    public static class ModelLoadingOverrides {
        private static final HashMap<Identifier, Function<BlockState, BlockStateModel.UnbakedRoot>> BLOCK_MODEL_OVERRIDES = new HashMap<>();
        private static final HashMap<Identifier, Function<Identifier, ItemModel.Unbaked>> ITEM_MODEL_OVERRIDES = new HashMap<>();

        public static void addBlock(Block block, Function<BlockState, BlockStateModel.UnbakedRoot> model) {
            BLOCK_MODEL_OVERRIDES.put(BuiltInRegistries.BLOCK.getKey(block), model);
        }

        public static void addItem(ItemLike itemConvertible, Function<Identifier, ItemModel.Unbaked> model) {
            ITEM_MODEL_OVERRIDES.put(BuiltInRegistries.ITEM.getKey(itemConvertible.asItem()), model);
        }

        private static BlockStateModel.UnbakedRoot getBlockModel(BlockStateModel.UnbakedRoot original, ModelModifier.BeforeBakeBlock.Context context) {
            Function<BlockState, BlockStateModel.UnbakedRoot> override = BLOCK_MODEL_OVERRIDES.get(BuiltInRegistries.BLOCK.getKey(context.state().getBlock()));
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


            if (!ResourceLoader.registerBuiltinPack(NTM.id("legacy"), NTM.MOD_CONTAINER, PackActivationType.NORMAL)) {
                NTMClient.LOGGER.warn("Failed to load Legacy Resource Pack");
            }

            // Load 3d Models
            ResourceLoader.get(PackType.CLIENT_RESOURCES).registerReloader(
              NTM.id("wavefront_models"),
              (store, prepareExecutor, reloadSynchronizer, applyExecutor) -> CompletableFuture
                .runAsync(() -> {
                      ProfilerFiller profiler = Profiler.get();
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
                .thenCompose(reloadSynchronizer::wait)
                .thenRunAsync(() -> {
                }, applyExecutor)
            );


            ModelLoadingPlugin.register(pluginContext -> {
                pluginContext.modifyBlockModelBeforeBake().register(ModelLoadingOverrides::getBlockModel);
                pluginContext.modifyItemModelBeforeBake().register(ModelLoadingOverrides::getItemModel);
            });
        }
    }
}
