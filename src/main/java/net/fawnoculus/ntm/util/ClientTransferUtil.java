package net.fawnoculus.ntm.util;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

/**
 * Utility for getting data that only ever exists on the client while providing a default if it's ran on the server
 */
public class ClientTransferUtil {
    private static ClientDataGetter CLIENT_DATA_GETTER = ClientDataGetter.EMPTY;

    public static void setClientDataGetter(ClientDataGetter clientDataGetter) {
        CLIENT_DATA_GETTER = clientDataGetter;
    }

    public static MutableText getBoundKey(String keybindTranslationKey) {
        return CLIENT_DATA_GETTER.getBoundKey(keybindTranslationKey);
    }


    public interface ClientDataGetter {
        ClientDataGetter EMPTY = new ClientDataGetter() {
            @Override
            public MutableText getBoundKey(String keybindTranslationKey) {
                return Text.translatable(keybindTranslationKey);
            }
        };

        MutableText getBoundKey(String keybindTranslationKey);
    }
}
