package net.fawnoculus.ntm.network.custom;

import com.google.gson.JsonObject;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.minecraft.Bootstrap;
import net.minecraft.SharedConstants;
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
    JsonObject jsonObject = AdvancedMessage.encode(testMessage);
    AdvancedMessage decodedMessage = AdvancedMessage.decode(jsonObject);

    Assertions.assertEquals(testMessage.getID(), decodedMessage.getID());
    Assertions.assertEquals(testMessage.getMillisLeft(), decodedMessage.getMillisLeft());
    Assertions.assertTrue(decodedMessage.getText().contains(testMessage.getText()));
  }
}
