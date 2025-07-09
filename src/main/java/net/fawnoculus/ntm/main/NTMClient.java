package net.fawnoculus.ntm.main;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fawnoculus.ntm.commands.ModClientCommands;
import net.fawnoculus.ntm.network.ModClientPayloadHandler;
import net.fawnoculus.ntm.render.ModBlockEntityRender;
import net.fawnoculus.ntm.gui.ModHandledScreens;
import net.fawnoculus.ntm.gui.ModScreenHandlerType;
import net.fawnoculus.ntm.render.ModHudRender;
import net.fawnoculus.ntm.render.ModParticleRender;
import net.fawnoculus.ntm.render.ModWorldRender;
import net.fawnoculus.ntm.world.radiation.client.ClientRadiationManager;

@Environment(EnvType.CLIENT)
public class NTMClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    NTM.LOGGER.info("Initializing {} Client Components", NTM.MOD_NAME);
    
    NTMClientConfig.initialize();
    
    ModClientCommands.initialize();
    
    ModBlockEntityRender.initialize();
    ModParticleRender.initialize();
    
    ModScreenHandlerType.initialize();
    ModHandledScreens.initialize();
    
    ModHudRender.initialize();
    ModWorldRender.initialize();
    
    ClientRadiationManager.initialize();
    
    ModClientPayloadHandler.initialize();
    
    NTM.LOGGER.info("Finished {} Client Initialization", NTM.MOD_NAME);
  }
}
