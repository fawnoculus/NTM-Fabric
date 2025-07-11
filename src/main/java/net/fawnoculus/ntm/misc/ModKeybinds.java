package net.fawnoculus.ntm.misc;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class ModKeybinds {
  public static final KeyBinding displayExtraInfo = KeyBindingHelper.registerKeyBinding(new KeyBinding(
      "key.ntm.extra_info",
      InputUtil.Type.KEYSYM,
      GLFW.GLFW_KEY_LEFT_SHIFT,
      "key.category.ntm"
  ));
  
  public static void initialize(){}
}
