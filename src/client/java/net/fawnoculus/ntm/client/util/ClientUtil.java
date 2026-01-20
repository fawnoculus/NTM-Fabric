package net.fawnoculus.ntm.client.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SoundInstance;

public class ClientUtil {
    public static Minecraft getClient() {
        return Minecraft.getInstance();
    }

    public static LocalPlayer getPlayer() {
        return getClient().player;
    }

    public static ClientLevel getWorld() {
        return getClient().level;
    }

    public static Font getTextRenderer() {
        return getClient().font;
    }

    public static void playSound(SoundInstance sound) {
        getClient().getSoundManager().play(sound);
    }
}
