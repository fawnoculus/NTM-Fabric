package net.fawnoculus.ntm.client;

import net.fabricmc.api.ClientModInitializer;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.client.api.NTMClientApi;
import net.fawnoculus.ntm.client.commands.NTMClientCommands;
import net.fawnoculus.ntm.client.gui.NTMHandledScreens;
import net.fawnoculus.ntm.client.misc.NTMKeybinds;
import net.fawnoculus.ntm.client.network.NTMClientPayloadHandler;
import net.fawnoculus.ntm.client.render.NTMBlockEntityRender;
import net.fawnoculus.ntm.client.render.NTMHudRender;
import net.fawnoculus.ntm.client.render.NTMParticleRender;
import net.fawnoculus.ntm.client.render.NTMResources;
import net.fawnoculus.ntm.client.util.ClientUtil;
import net.fawnoculus.ntm.gui.NTMScreenHandlerType;
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
