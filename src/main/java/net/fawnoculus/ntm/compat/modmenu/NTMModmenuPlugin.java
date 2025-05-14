package net.fawnoculus.ntm.compat.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;


public class NTMModmenuPlugin implements ModMenuApi {
  @Override
  public ConfigScreenFactory<?> getModConfigScreenFactory() {
    // TODO: make a config Screen (or at least make a Config File)
    return ModMenuApi.super.getModConfigScreenFactory();
  }
}
