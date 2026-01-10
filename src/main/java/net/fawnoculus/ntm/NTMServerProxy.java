package net.fawnoculus.ntm;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class NTMServerProxy implements NTMProxy {
    @Override
    public MutableText getKeyText(String keybindTranslationKey) {
        return Text.translatable(keybindTranslationKey);
    }

    @Override
    public void playSoundToPlayer(PlayerEntity player, RegistryEntry<SoundEvent> sound, SoundCategory category, double x, double y, double z, float volume, float pitch, long seed) {
        if (player instanceof ServerPlayerEntity serverPlayer) {
            serverPlayer.networkHandler.sendPacket(new PlaySoundS2CPacket(sound, category, x, y, z, volume, pitch, seed));
        }
    }
}
