package net.fawnoculus.ntm.client.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.world.ClientWorld;

public class ClientUtil {
    public static MinecraftClient getClient() {
        return MinecraftClient.getInstance();
    }

    public static ClientPlayerEntity getPlayer() {
        return getClient().player;
    }

    public static ClientWorld getWorld() {
        return getClient().world;
    }

    public static TextRenderer getTextRenderer() {
        return getClient().textRenderer;
    }

    public static void playSound(SoundInstance sound) {
        getClient().getSoundManager().play(sound);
    }
}
