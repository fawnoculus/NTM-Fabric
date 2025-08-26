package net.fawnoculus.ntm.render.resources;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import org.jetbrains.annotations.NotNull;

public class NTMModelLoadingPlugin implements ModelLoadingPlugin {
  public static void initialize() {
    ModelLoadingPlugin.register(new NTMModelLoadingPlugin());
  }

  @Override
  public void initialize(@NotNull Context pluginContext) {
    /*
    pluginContext.modifyBlockModelAfterBake().register((blockStateModel, context) -> NTMResources.ModelRender.getBlockModel(context.state().getBlock()).orElse(blockStateModel));
    pluginContext.modifyItemModelAfterBake().register((itemModel, context) -> NTMResources.ModelRender.getItemModel(context.itemId()).orElse(itemModel));
     */
    // TODO: copy todo from ItemModel3D over here
  }
}
