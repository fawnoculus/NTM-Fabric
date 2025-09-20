package net.fawnoculus.ntm.render.resources;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMClient;
import net.fawnoculus.ntm.render.model.ItemModel3D;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class NTMModelLoadingPlugin implements ModelLoadingPlugin {
  public static void initialize() {
    ModelLoadingPlugin.register(new NTMModelLoadingPlugin());
  }

  @Override
  public void initialize(@NotNull Context pluginContext) {
    //pluginContext.modifyBlockModelAfterBake().register((blockStateModel, context) -> NTMResources.ModelRender.getBlockModel(context.state().getBlock()).orElse(blockStateModel));
    pluginContext.modifyItemModelBeforeBake().register((itemModel, context) -> {
      if (Objects.equals(context.itemId(), NTM.id("alloy_furnace_extension"))) {
        NTMClient.LOGGER.warn("holy smokes!");
        return new ItemModel3D.Unbaked(context.itemId(), NTMModels.ALLOY_FURNACE_EXTENSION);
      }

      return itemModel;
    });
    // TODO: copy todo from ItemModel3D over here
  }
}
