package net.fawnoculus.ntm.screen;

import net.fawnoculus.ntm.screen.screens.AlloyFurnaceScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ModHandledScreens {
  public static void initialize() {
    HandledScreens.register(ModScreenHandlerType.ALLOY_FURNACE, AlloyFurnaceScreen::new);
  }
}
