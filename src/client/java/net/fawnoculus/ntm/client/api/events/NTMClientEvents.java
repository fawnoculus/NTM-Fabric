package net.fawnoculus.ntm.client.api.events;

import net.fabricmc.fabric.api.client.networking.v1.ClientLoginConnectionEvents;
import net.fawnoculus.ntm.client.api.events.custom.ClientTickEvents;
import net.fawnoculus.ntm.client.api.events.custom.ConnectToServerEvent;
import net.fawnoculus.ntm.client.api.events.custom.LoadWavefrontModelTexturesEvent;
import net.fawnoculus.ntm.client.api.events.custom.LoadWavefrontModelsEvent;
import net.fawnoculus.ntm.client.api.messages.MessageSystem;
import net.fawnoculus.ntm.client.network.ClientReceivedVersionHandler;
import net.fawnoculus.ntm.client.render.WavefrontModels;

public class NTMClientEvents {
	public static void initialize() {
		ClientLoginConnectionEvents.DISCONNECT.register(ClientReceivedVersionHandler::onDisconnect);
		ClientLoginConnectionEvents.DISCONNECT.register((handler, client) ->
		  MessageSystem.removeAllMessages()
		);

		ConnectToServerEvent.EVENT.register(ClientReceivedVersionHandler::onJoin);

		ClientTickEvents.EVENT.register(MessageSystem::onClientTick);

		LoadWavefrontModelsEvent.EVENT.register(WavefrontModels::loadModels);

		LoadWavefrontModelTexturesEvent.EVENT.register(WavefrontModels::loadModelTextures);
	}
}
