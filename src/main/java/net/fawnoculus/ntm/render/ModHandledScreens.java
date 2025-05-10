package net.fawnoculus.ntm.render;

import net.fawnoculus.ntm.render.screen.AlloyFurnaceScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ModHandledScreens {
  public static void initialize() {
    HandledScreens.register(ModScreenHandlerType.ALLOY_FURNACE, AlloyFurnaceScreen::new);
  }
}
