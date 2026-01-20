package net.fawnoculus.ntm;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;

public interface NTMProxy {
    MutableComponent getKeyText(String keybindTranslationKey);

    default void playSoundToPlayer(Player player, SoundEvent sound, SoundSource category) {
        playSoundToPlayer(player, BuiltInRegistries.SOUND_EVENT.wrapAsHolder(sound), category, player.getX(), player.getY(), player.getZ(), 0f, 0f, player.getRandom().nextLong());
    }

    default void playSoundToPlayer(Player player, SoundEvent sound, SoundSource category, float volume, float pitch) {
        playSoundToPlayer(player, BuiltInRegistries.SOUND_EVENT.wrapAsHolder(sound), category, player.getX(), player.getY(), player.getZ(), volume, pitch, player.getRandom().nextLong());
    }

    default void playSoundToPlayer(Player player, SoundEvent sound, SoundSource category, double x, double y, double z, float volume, float pitch) {
        playSoundToPlayer(player, BuiltInRegistries.SOUND_EVENT.wrapAsHolder(sound), category, x, y, z, volume, pitch, player.getRandom().nextLong());
    }

    default void playSoundToPlayer(Player player, SoundEvent sound, SoundSource category, double x, double y, double z, float volume, float pitch, long seed) {
        playSoundToPlayer(player, BuiltInRegistries.SOUND_EVENT.wrapAsHolder(sound), category, x, y, z, volume, pitch, seed);
    }

    default void playSoundToPlayer(Player player, Holder<SoundEvent> sound, SoundSource category) {
        playSoundToPlayer(player, sound, category, player.getX(), player.getY(), player.getZ(), 0f, 0f, player.getRandom().nextLong());
    }

    default void playSoundToPlayer(Player player, Holder<SoundEvent> sound, SoundSource category, float volume, float pitch) {
        playSoundToPlayer(player, sound, category, player.getX(), player.getY(), player.getZ(), volume, pitch, player.getRandom().nextLong());
    }

    default void playSoundToPlayer(Player player, Holder<SoundEvent> sound, SoundSource category, double x, double y, double z, float volume, float pitch) {
        playSoundToPlayer(player, sound, category, x, y, z, volume, pitch, player.getRandom().nextLong());
    }

    void playSoundToPlayer(Player player, Holder<SoundEvent> sound, SoundSource category, double x, double y, double z, float volume, float pitch, long seed);
}
