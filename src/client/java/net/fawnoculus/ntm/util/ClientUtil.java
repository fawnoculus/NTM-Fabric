package net.fawnoculus.ntm.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

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

  public static void initialize(){
    ClientTransferUtil.setClientDataGetter(new ClientTransferUtil.ClientDataGetter() {
      @Override
      public MutableText getBoundKey(String keybindTranslationKey) {
        KeyBinding keyBinding = KeyBinding.byId(keybindTranslationKey);
        if(keyBinding == null) {
          return Text.translatable(keybindTranslationKey);
        }

        return keyBinding.getBoundKeyLocalizedText().copy();
      }
    });
  }
}
