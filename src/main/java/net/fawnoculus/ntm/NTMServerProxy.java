package net.fawnoculus.ntm;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;

public class NTMServerProxy implements NTMProxy {
    @Override
    public MutableComponent getKeyText(String keybindTranslationKey) {
        return Component.translatable(keybindTranslationKey);
    }

    @Override
    public void playSoundToPlayer(Player player, Holder<SoundEvent> sound, SoundSource category, double x, double y, double z, float volume, float pitch, long seed) {
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.send(new ClientboundSoundPacket(sound, category, x, y, z, volume, pitch, seed));
        }
    }
}
