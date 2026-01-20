package net.fawnoculus.ntm.client.gui;

import net.fawnoculus.ntm.client.gui.handled.AlloyFurnaceScreen;
import net.fawnoculus.ntm.client.gui.handled.ElectricFurnaceScreen;
import net.fawnoculus.ntm.client.gui.handled.EnergyStorageScreen;
import net.fawnoculus.ntm.gui.NTMScreenHandlerType;
import net.minecraft.client.gui.screens.MenuScreens;

public class NTMHandledScreens {
    public static void initialize() {
        MenuScreens.register(NTMScreenHandlerType.ALLOY_FURNACE, AlloyFurnaceScreen::new);
        MenuScreens.register(NTMScreenHandlerType.ELECTRIC_FURNACE, ElectricFurnaceScreen::new);
        MenuScreens.register(NTMScreenHandlerType.ENERGY_STORAGE, EnergyStorageScreen::new);
    }
}
