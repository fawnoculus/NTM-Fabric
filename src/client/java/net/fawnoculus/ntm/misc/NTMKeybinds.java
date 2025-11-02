package net.fawnoculus.ntm.misc;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fawnoculus.ntm.api.events.custom.ClientTickEvents;
import net.fawnoculus.ntm.api.tool.SpecialTool;
import net.fawnoculus.ntm.gui.screen.ToolAbilityCustomizationScreen;
import net.fawnoculus.ntm.util.ClientUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemStack;
import org.lwjgl.glfw.GLFW;

import java.util.function.Consumer;

public class NTMKeybinds {
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
  public static final KeyBinding OPEN_QMAW_PAGE = KeyBindingHelper.registerKeyBinding(new KeyBinding(
    "key.ntm.qmaw",
    InputUtil.Type.KEYSYM,
    GLFW.GLFW_KEY_F1,
    "key.category.ntm"
  ));
  public static final KeyBinding OPEN_TOOL_ABILITY_GUI = KeyBindingHelper.registerKeyBinding(new KeyBinding(
    "key.ntm.open_tool_ability_gui",
    InputUtil.Type.KEYSYM,
    GLFW.GLFW_KEY_LEFT_ALT,
    "key.category.ntm"
  ));

  // TODO: make key conflicts of keys that can only be used in certain situations (only in Guis or smth.) not be shown as regular key conflicts as to not be "That annoying mod who's default keybinds always have conflicts"

  public static void initialize() {
    onKeyPressed(OPEN_TOOL_ABILITY_GUI, client -> {
      ItemStack stack = ClientUtil.getPlayer().getMainHandStack();

      if(client.currentScreen == null
        && stack.getItem() instanceof SpecialTool specialTool
        && !specialTool.abilityHandler().ABILITIES().isEmpty()
      ){
        client.setScreen(new ToolAbilityCustomizationScreen(specialTool, stack));
      }
    });
  }

  private static void onKeyPressed(KeyBinding key, Consumer<MinecraftClient> onPressed) {
    ClientTickEvents.EVENT.register(client -> {
      while (key.wasPressed()){
        onPressed.accept(client);
      }
    });
  }
}
