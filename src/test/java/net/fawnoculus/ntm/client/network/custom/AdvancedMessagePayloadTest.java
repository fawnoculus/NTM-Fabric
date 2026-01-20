package net.fawnoculus.ntm.client.network.custom;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.minecraft.SharedConstants;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AdvancedMessagePayloadTest {
    @BeforeAll
    static void beforeAll() {
        SharedConstants.tryDetectVersion();
        Bootstrap.bootStrap();
    }

    @Test
    void testCodec() {
        AdvancedMessage testMessage = new AdvancedMessage(NTM.id("test"), Component.literal("this is a test"), 1000);
        CompoundTag nbt = AdvancedMessage.encode(testMessage);
        AdvancedMessage decodedMessage = AdvancedMessage.decode(nbt);

        Assertions.assertEquals(testMessage.getID(), decodedMessage.getID());
        Assertions.assertEquals(testMessage.getMillisLeft(), decodedMessage.getMillisLeft());
        Assertions.assertTrue(decodedMessage.getText().contains(testMessage.getText()));
    }
}
