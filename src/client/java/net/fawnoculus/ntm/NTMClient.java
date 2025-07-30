package net.fawnoculus.ntm;

import net.fabricmc.api.ClientModInitializer;
import net.fawnoculus.ntm.commands.NTMClientCommands;
import net.fawnoculus.ntm.misc.NTMKeybinds;
import net.fawnoculus.ntm.network.NTMClientPayloadHandler;
import net.fawnoculus.ntm.render.*;
import net.fawnoculus.ntm.gui.NTMHandledScreens;
import net.fawnoculus.ntm.gui.NTMScreenHandlerType;
import net.fawnoculus.ntm.misc.radiation.ClientRadiationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NTMClient implements ClientModInitializer {
  public static final Logger LOGGER = LoggerFactory.getLogger(NTM.MOD_NAME + "/Client");
  @Override
  public void onInitializeClient() {
    LOGGER.info("Initializing {} Client Components", NTM.MOD_NAME);
    
    NTMClientConfig.initialize();
    
    NTMKeybinds.initialize();
    
    NTMClientCommands.initialize();
    
    NTMBlockEntityRender.initialize();
    NTMParticleRender.initialize();
    NTMModelLoadingPlugin.initialize();
    
    NTMScreenHandlerType.initialize();
    NTMHandledScreens.initialize();
    
    NTMHudRender.initialize();
    
    ClientRadiationManager.initialize();
    
    NTMClientPayloadHandler.initialize();
    
    LOGGER.info("Finished {} Client Initialization", NTM.MOD_NAME);
  }
}
