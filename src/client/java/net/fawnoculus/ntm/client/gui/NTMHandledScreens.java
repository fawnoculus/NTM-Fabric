package net.fawnoculus.ntm.client.gui;

import net.fawnoculus.ntm.client.gui.handled.AlloyFurnaceScreen;
import net.fawnoculus.ntm.client.gui.handled.ElectricFurnaceScreen;
import net.fawnoculus.ntm.client.gui.handled.EnergyStorageScreen;
import net.fawnoculus.ntm.gui.NTMScreenHandlerType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class NTMHandledScreens {
    public static void initialize() {
        HandledScreens.register(NTMScreenHandlerType.ALLOY_FURNACE, AlloyFurnaceScreen::new);
        HandledScreens.register(NTMScreenHandlerType.ELECTRIC_FURNACE, ElectricFurnaceScreen::new);
        HandledScreens.register(NTMScreenHandlerType.ENERGY_STORAGE, EnergyStorageScreen::new);
    }
}
