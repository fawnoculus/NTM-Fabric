package net.fawnoculus.ntm;

import net.fabricmc.api.ClientModInitializer;
import net.fawnoculus.ntm.commands.ModClientCommands;
import net.fawnoculus.ntm.misc.ModKeybinds;
import net.fawnoculus.ntm.network.ModClientPayloadHandler;
import net.fawnoculus.ntm.render.*;
import net.fawnoculus.ntm.gui.ModHandledScreens;
import net.fawnoculus.ntm.gui.ModScreenHandlerType;
import net.fawnoculus.ntm.misc.radiation.ClientRadiationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NTMClient implements ClientModInitializer {
  public static final Logger LOGGER = LoggerFactory.getLogger(NTM.MOD_NAME + "/Client");
  @Override
  public void onInitializeClient() {
    LOGGER.info("Initializing {} Client Components", NTM.MOD_NAME);
    
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
    
    LOGGER.info("Finished {} Client Initialization", NTM.MOD_NAME);
  }
}
