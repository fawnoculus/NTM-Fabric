package net.fawnoculus.ntm.client;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMProxy;
import net.fawnoculus.ntm.client.util.ClientUtil;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;

public class NTMClientProxy implements NTMProxy {
    public static void initialize() {
        NTM.setProxy(new NTMClientProxy());
    }

    @Override
    public MutableComponent getKeyText(String keybindTranslationKey) {
        KeyMapping keyBinding = KeyMapping.get(keybindTranslationKey);
        if (keyBinding == null) {
            return Component.translatable(keybindTranslationKey);
        }

        return keyBinding.getTranslatedKeyMessage().copy();
    }

    @Override
    public void playSoundToPlayer(Player player, Holder<SoundEvent> sound, SoundSource category, double x, double y, double z, float volume, float pitch, long seed) {
        if (player instanceof LocalPlayer clientPlayer && clientPlayer.equals(ClientUtil.getPlayer())) {
            ClientUtil.playSound(new SimpleSoundInstance(sound.value(), category, volume, pitch, RandomSource.create(seed), x, y, z));
            return;
        }
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.send(new ClientboundSoundPacket(sound, category, x, y, z, volume, pitch, seed));
        }
    }
}
