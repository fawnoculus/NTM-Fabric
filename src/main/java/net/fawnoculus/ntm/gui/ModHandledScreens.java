package net.fawnoculus.ntm.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fawnoculus.ntm.gui.handled_screens.AlloyFurnaceScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class ModHandledScreens {
  public static void initialize() {
    HandledScreens.register(ModScreenHandlerType.ALLOY_FURNACE, AlloyFurnaceScreen::new);
  }
}
