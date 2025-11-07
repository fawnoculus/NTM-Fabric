package net.fawnoculus.ntm.client.network.custom;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.minecraft.Bootstrap;
import net.minecraft.SharedConstants;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AdvancedMessagePayloadTest {
  @BeforeAll
  static void beforeAll() {
    SharedConstants.createGameVersion();
    Bootstrap.initialize();
  }

  @Test
  void testCodec(){
    AdvancedMessage testMessage = new AdvancedMessage(NTM.id("test"), Text.literal("this is a test"), 1000);
    NbtCompound nbt = AdvancedMessage.encode(testMessage);
    AdvancedMessage decodedMessage = AdvancedMessage.decode(nbt);

    Assertions.assertEquals(testMessage.getID(), decodedMessage.getID());
    Assertions.assertEquals(testMessage.getMillisLeft(), decodedMessage.getMillisLeft());
    Assertions.assertTrue(decodedMessage.getText().contains(testMessage.getText()));
  }
}
