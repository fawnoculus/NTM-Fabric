package net.fawnoculus.ntm.gui;

import net.fawnoculus.ntm.gui.handled_screens.AlloyFurnaceScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ModHandledScreens {
  public static void initialize() {
    HandledScreens.register(ModScreenHandlerType.ALLOY_FURNACE, AlloyFurnaceScreen::new);
  }
}
