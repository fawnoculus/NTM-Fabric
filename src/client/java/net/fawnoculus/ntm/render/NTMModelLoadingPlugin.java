package net.fawnoculus.ntm.render;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fawnoculus.ntm.NTMClient;

public class NTMModelLoadingPlugin implements ModelLoadingPlugin {
  public static void initialize(){
    ModelLoadingPlugin.register(new NTMModelLoadingPlugin());
  }
  
  @Override
  public void initialize(Context pluginContext) {
    // TODO: make Model3D use this for basic rendering instead of calling NTMRenderPipelines.render() every time
    //  so that it doesn't absolutely fuck my FPS every time!
    pluginContext.modifyBlockModelAfterBake().register((blockStateModel, context) -> {
      NTMClient.LOGGER.info("Found Block Model for: '{}'",context.state());
      return blockStateModel;
    });
    pluginContext.modifyItemModelAfterBake().register((itemModel, context) -> {
      NTMClient.LOGGER.info("Found Item Model for: '{}'",context.itemId());
      return itemModel;
    });
  }
}
