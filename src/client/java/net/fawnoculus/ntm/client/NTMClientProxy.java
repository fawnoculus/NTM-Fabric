package net.fawnoculus.ntm.client;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMProxy;
import net.fawnoculus.ntm.client.util.ClientUtil;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;

public class NTMClientProxy implements NTMProxy {
    public static void initialize() {
        NTM.setProxy(new NTMClientProxy());
    }

    @Override
    public MutableText getKeyText(String keybindTranslationKey) {
        KeyBinding keyBinding = KeyBinding.byId(keybindTranslationKey);
        if (keyBinding == null) {
            return Text.translatable(keybindTranslationKey);
        }

        return keyBinding.getBoundKeyLocalizedText().copy();
    }

    @Override
    public void playSoundToPlayer(PlayerEntity player, RegistryEntry<SoundEvent> sound, SoundCategory category, double x, double y, double z, float volume, float pitch, long seed) {
        if (player instanceof ClientPlayerEntity clientPlayer && clientPlayer.equals(ClientUtil.getPlayer())) {
            ClientUtil.playSound(new PositionedSoundInstance(sound.value(), category, volume, pitch, Random.create(seed), x, y, z));
            return;
        }
        if (player instanceof ServerPlayerEntity serverPlayer) {
            serverPlayer.networkHandler.sendPacket(new PlaySoundS2CPacket(sound, category, x, y, z, volume, pitch, seed));
        }
    }
}
