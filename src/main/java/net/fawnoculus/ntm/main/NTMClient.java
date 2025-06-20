package net.fawnoculus.ntm.main;

import net.fabricmc.api.ClientModInitializer;
import net.fawnoculus.ntm.commands.ModClientCommands;
import net.fawnoculus.ntm.render.ModBlockEntityRenderer;
import net.fawnoculus.ntm.gui.ModHandledScreens;
import net.fawnoculus.ntm.gui.ModScreenHandlerType;
import net.fawnoculus.ntm.render.ModHudRender;
import net.fawnoculus.ntm.render.ModParticleRender;

public class NTMClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    NTM.LOGGER.info("Initializing Client Components");
    
    ModClientCommands.initialize();
    
    ModBlockEntityRenderer.initialize();
    ModParticleRender.initialize();
    
    ModScreenHandlerType.initialize();
    ModHandledScreens.initialize();
    
    ModHudRender.initialize();
    
    NTM.LOGGER.info("Finished Client Initialization");
  }
}
