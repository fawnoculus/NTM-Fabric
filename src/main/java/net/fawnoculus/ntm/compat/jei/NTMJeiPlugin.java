package net.fawnoculus.ntm.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class NTMJeiPlugin implements IModPlugin {
  @Override
  public @NotNull Identifier getPluginUid() {
    return NTM.id("jei_plugin");
  }
}
