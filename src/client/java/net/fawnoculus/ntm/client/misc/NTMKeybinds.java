package net.fawnoculus.ntm.client.misc;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.tool.SpecialTool;
import net.fawnoculus.ntm.client.NTMClient;
import net.fawnoculus.ntm.client.api.events.custom.ClientTickEvents;
import net.fawnoculus.ntm.client.api.events.custom.OnKeyPressedEvent;
import net.fawnoculus.ntm.client.api.events.custom.OnMouseClickEvent;
import net.fawnoculus.ntm.client.api.qmaw.QmawManager;
import net.fawnoculus.ntm.client.gui.screen.ToolAbilityCustomizationScreen;
import net.fawnoculus.ntm.client.mixin.accessor.HandledScreenInvoker;
import net.fawnoculus.ntm.client.util.ClientUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import org.lwjgl.glfw.GLFW;

import java.util.function.Consumer;
import java.util.function.Function;

public class NTMKeybinds {
    public static final KeyBinding.Category NTM_CATEGORY = KeyBinding.Category.create(NTM.id("keys"));

    public static final KeyBinding DUCK = KeyBindingHelper.registerKeyBinding(new KeyBinding(
      "key.ntm.duck",
      InputUtil.Type.KEYSYM,
      GLFW.GLFW_KEY_O,
      NTM_CATEGORY
    ));
    public static final KeyBinding DISPLAY_EXTRA_INFO = KeyBindingHelper.registerKeyBinding(new KeyBinding(
      "key.ntm.extra_info",
      InputUtil.Type.KEYSYM,
      GLFW.GLFW_KEY_LEFT_SHIFT,
      NTM_CATEGORY
    ));
    public static final KeyBinding OPEN_QMAW_PAGE = KeyBindingHelper.registerKeyBinding(new KeyBinding(
      "key.ntm.qmaw",
      InputUtil.Type.KEYSYM,
      GLFW.GLFW_KEY_F1,
      NTM_CATEGORY
    ));
    public static final KeyBinding OPEN_TOOL_ABILITY_GUI = KeyBindingHelper.registerKeyBinding(new KeyBinding(
      "key.ntm.open_tool_ability_gui",
      InputUtil.Type.KEYSYM,
      GLFW.GLFW_KEY_LEFT_ALT,
      NTM_CATEGORY
    ));

    // TODO: make key conflicts of keys that can only be used in certain situations (only in Guis or smth.) not be shown as regular key conflicts as to not be "That annoying mod who's default keybinds always have conflicts"

    public static void initialize() {
        onKeyPressedTick(OPEN_TOOL_ABILITY_GUI, client -> {
            ItemStack stack = ClientUtil.getPlayer().getMainHandStack();

            if (client.currentScreen == null
              && stack.getItem() instanceof SpecialTool specialTool
              && !specialTool.abilityHandler().ABILITIES().isEmpty()
            ) {
                client.setScreen(new ToolAbilityCustomizationScreen(specialTool, stack));
            }
        });

        // FIXME This shit is fucked up
        // And i have no idea whats wrong with it
        onKeyPressedEvery(OPEN_QMAW_PAGE, client -> {
            NTMClient.LOGGER.info("AAA");
            if (client.currentScreen instanceof HandledScreen<?> handledScreen) {
                Slot hoveredSlot = ((HandledScreenInvoker) handledScreen).NTM$getSlotAt(client.mouse.getX(), client.mouse.getY());
                return QmawManager.openQmawPage(client, hoveredSlot);
            }
            return false;
        });
    }

    public static void onKeyPressedTick(KeyBinding key, Consumer<MinecraftClient> onPressed) {
        ClientTickEvents.EVENT.register(client -> {
            while (key.wasPressed()) {
                onPressed.accept(client);
            }
        });
    }

    public static void onKeyPressedEvery(KeyBinding keyBinding, Function<MinecraftClient, Boolean> onPressed) {
        onKeyboardPressed(keyBinding, (client, ignored) -> onPressed.apply(client));
        onMousePressed(keyBinding, (client, ignored) -> onPressed.apply(client));
    }

    public static void onKeyboardPressed(KeyBinding keyBinding, OnKeyPressedEvent onPressed) {
        OnKeyPressedEvent.EVENT.register((client, keyInput) -> {
            if (keyBinding.matchesKey(keyInput)) {
                return onPressed.onKeyPressed(client, keyInput);
            }
            return false;
        });
    }

    public static void onMousePressed(KeyBinding keyBinding, OnMouseClickEvent onPressed) {
        OnMouseClickEvent.EVENT.register((client, click) -> {
            if (keyBinding.matchesMouse(click)) {
                return onPressed.onClick(client, click);
            }
            return false;
        });
    }
}
