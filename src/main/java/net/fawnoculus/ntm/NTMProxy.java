package net.fawnoculus.ntm;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.MutableText;

public interface NTMProxy {
    MutableText getKeyText(String keybindTranslationKey);

    default void playSoundToPlayer(PlayerEntity player, SoundEvent sound, SoundCategory category) {
        playSoundToPlayer(player, Registries.SOUND_EVENT.getEntry(sound), category, player.getX(), player.getY(), player.getZ(), 0f, 0f, player.getRandom().nextLong());
    }

    default void playSoundToPlayer(PlayerEntity player, SoundEvent sound, SoundCategory category, float volume, float pitch) {
        playSoundToPlayer(player, Registries.SOUND_EVENT.getEntry(sound), category, player.getX(), player.getY(), player.getZ(), volume, pitch, player.getRandom().nextLong());
    }

    default void playSoundToPlayer(PlayerEntity player, SoundEvent sound, SoundCategory category, double x, double y, double z, float volume, float pitch) {
        playSoundToPlayer(player, Registries.SOUND_EVENT.getEntry(sound), category, x, y, z, volume, pitch, player.getRandom().nextLong());
    }

    default void playSoundToPlayer(PlayerEntity player, SoundEvent sound, SoundCategory category, double x, double y, double z, float volume, float pitch, long seed) {
        playSoundToPlayer(player, Registries.SOUND_EVENT.getEntry(sound), category, x, y, z, volume, pitch, seed);
    }

    default void playSoundToPlayer(PlayerEntity player, RegistryEntry<SoundEvent> sound, SoundCategory category) {
        playSoundToPlayer(player, sound, category, player.getX(), player.getY(), player.getZ(), 0f, 0f, player.getRandom().nextLong());
    }

    default void playSoundToPlayer(PlayerEntity player, RegistryEntry<SoundEvent> sound, SoundCategory category, float volume, float pitch) {
        playSoundToPlayer(player, sound, category, player.getX(), player.getY(), player.getZ(), volume, pitch, player.getRandom().nextLong());
    }

    default void playSoundToPlayer(PlayerEntity player, RegistryEntry<SoundEvent> sound, SoundCategory category, double x, double y, double z, float volume, float pitch) {
        playSoundToPlayer(player, sound, category, x, y, z, volume, pitch, player.getRandom().nextLong());
    }

    void playSoundToPlayer(PlayerEntity player, RegistryEntry<SoundEvent> sound, SoundCategory category, double x, double y, double z, float volume, float pitch, long seed);
}
