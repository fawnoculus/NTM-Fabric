package net.fawnoculus.ntm;

import net.fabricmc.api.ClientModInitializer;
import net.fawnoculus.ntm.commands.ModClientCommands;
import net.fawnoculus.ntm.misc.ModKeybinds;
import net.fawnoculus.ntm.network.ModClientPayloadHandler;
import net.fawnoculus.ntm.render.ModBlockEntityRender;
import net.fawnoculus.ntm.gui.ModHandledScreens;
import net.fawnoculus.ntm.gui.ModScreenHandlerType;
import net.fawnoculus.ntm.render.ModHudRender;
import net.fawnoculus.ntm.render.ModParticleRender;
import net.fawnoculus.ntm.render.ModWorldRender;
import net.fawnoculus.ntm.misc.radiation.ClientRadiationManager;

public class NTMClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    NTM.LOGGER.info("Initializing {} Client Components", NTM.MOD_NAME);
    
    NTMClientConfig.initialize();
    
    ModKeybinds.initialize();
    
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
