package net.fawnoculus.ntm.gui;

import net.fawnoculus.ntm.gui.handled.AlloyFurnaceScreen;
import net.fawnoculus.ntm.gui.handled.ElectricFurnaceScreen;
import net.fawnoculus.ntm.gui.handled.EnergyStorageScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class NTMHandledScreens {
  public static void initialize() {
    HandledScreens.register(NTMScreenHandlerType.ALLOY_FURNACE, AlloyFurnaceScreen::new);
    HandledScreens.register(NTMScreenHandlerType.ELECTRIC_FURNACE, ElectricFurnaceScreen::new);
    HandledScreens.register(NTMScreenHandlerType.ENERGY_STORAGE, EnergyStorageScreen::new);
  }
}
