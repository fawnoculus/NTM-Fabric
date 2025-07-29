package net.fawnoculus.ntm.misc;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ModKeybinds {
  public static final KeyBinding DUCK = KeyBindingHelper.registerKeyBinding(new KeyBinding(
      "key.ntm.duck",
      InputUtil.Type.KEYSYM,
      GLFW.GLFW_KEY_O,
      "key.category.ntm"
  ));
  public static final KeyBinding DISPLAY_EXTRA_INFO = KeyBindingHelper.registerKeyBinding(new KeyBinding(
      "key.ntm.extra_info",
      InputUtil.Type.KEYSYM,
      GLFW.GLFW_KEY_LEFT_SHIFT,
      "key.category.ntm"
  ));
  
  public static void initialize(){}
}
