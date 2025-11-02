package net.fawnoculus.ntm;

import net.fabricmc.api.ClientModInitializer;
import net.fawnoculus.ntm.api.NTMClientApi;
import net.fawnoculus.ntm.commands.NTMClientCommands;
import net.fawnoculus.ntm.gui.NTMHandledScreens;
import net.fawnoculus.ntm.gui.NTMScreenHandlerType;
import net.fawnoculus.ntm.misc.NTMKeybinds;
import net.fawnoculus.ntm.network.NTMClientPayloadHandler;
import net.fawnoculus.ntm.render.NTMBlockEntityRender;
import net.fawnoculus.ntm.render.NTMHudRender;
import net.fawnoculus.ntm.render.NTMParticleRender;
import net.fawnoculus.ntm.render.NTMResources;
import net.fawnoculus.ntm.util.ClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NTMClient implements ClientModInitializer {
  public static final Logger LOGGER = LoggerFactory.getLogger(NTM.MOD_NAME + "/Client");

  @Override
  public void onInitializeClient() {
    LOGGER.info("Initializing Client Components ...");

    NTMClientConfig.initialize();
    NTMClientApi.initialize();

    NTMKeybinds.initialize();

    NTMClientCommands.initialize();

    NTMResources.initialize();

    NTMBlockEntityRender.initialize();
    NTMParticleRender.initialize();
    NTMHudRender.initialize();

    NTMScreenHandlerType.initialize();
    NTMHandledScreens.initialize();

    NTMClientPayloadHandler.initialize();
    ClientUtil.initialize();

    LOGGER.info("Finished Client Initialization");
  }
}
