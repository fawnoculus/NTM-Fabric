package net.fawnoculus.ntm.main;

import net.fabricmc.api.ClientModInitializer;
import net.fawnoculus.ntm.commands.ModClientCommands;
import net.fawnoculus.ntm.render.ModBlockEntityRender;
import net.fawnoculus.ntm.gui.ModHandledScreens;
import net.fawnoculus.ntm.gui.ModScreenHandlerType;
import net.fawnoculus.ntm.render.ModHudRender;
import net.fawnoculus.ntm.render.ModParticleRender;
import net.fawnoculus.ntm.render.ModWorldRender;

public class NTMClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    NTM.LOGGER.info("Initializing Client Components");
    
    ModClientCommands.initialize();
    
    ModBlockEntityRender.initialize();
    ModParticleRender.initialize();
    
    ModScreenHandlerType.initialize();
    ModHandledScreens.initialize();
    
    ModHudRender.initialize();
    ModWorldRender.initialize();
    
    NTM.LOGGER.info("Finished Client Initialization");
  }
}
