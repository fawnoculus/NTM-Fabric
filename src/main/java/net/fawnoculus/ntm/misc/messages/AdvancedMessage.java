package net.fawnoculus.ntm.misc.messages;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import io.netty.buffer.ByteBuf;
import net.fawnoculus.ntm.util.JsonUtil;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Range;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class AdvancedMessage {
  private static final float BLEND_TIME = 500.0f;
  private final Identifier IDENTIFIER;
  private final Text TEXT;
  private float millisLeft;
  public static final PacketCodec<ByteBuf, AdvancedMessage> PACKET_CODEC = new PacketCodec<>() {
    @Override
    public AdvancedMessage decode(ByteBuf byteBuf) {
      String string = new String(PacketByteBuf.readByteArray(byteBuf), StandardCharsets.UTF_8);
      return AdvancedMessage.decode(JsonUtil.jsonFromString(string));
    }
    
    @Override
    public void encode(ByteBuf byteBuf, AdvancedMessage message) {
      JsonObject json = AdvancedMessage.encode(message);
      PacketByteBuf.writeByteArray(byteBuf, json.toString().getBytes(StandardCharsets.UTF_8));
    }
  };
  
  public static JsonObject encode(AdvancedMessage message){
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("identifier", new JsonPrimitive(message.IDENTIFIER.toString()));
    jsonObject.add("millis_left", new JsonPrimitive(message.millisLeft));
    jsonObject.add("text", new JsonPrimitive(Text.Serialization.toJsonString(message.TEXT, BuiltinRegistries.createWrapperLookup())));
    return jsonObject;
  }
  public static AdvancedMessage decode(JsonObject json){
    Identifier identifier = Identifier.of(json.getAsJsonPrimitive("identifier").getAsString());
    float millisLeft  = json.getAsJsonPrimitive("millis_left").getAsFloat();
    Text text = Objects.requireNonNull(Text.Serialization.fromJson(json.getAsJsonPrimitive("text").getAsString(), BuiltinRegistries.createWrapperLookup()));
    return new AdvancedMessage(identifier, text, millisLeft);
  }
  
  /**
   * @param identifier Identifier of the Message (can override other messages if the Identifier is the same)
   * @param text Text to be displayed
   * @param millisSeconds Amount of Milliseconds the Message should be displayed for;
   */
  public AdvancedMessage(Identifier identifier, Text text, float millisSeconds){
    if(text.getStyle().getColor() == null) {
      text = text.copy().formatted(Formatting.WHITE);
    }
    this.IDENTIFIER = identifier;
    this.TEXT = text;
    this.millisLeft = millisSeconds;
  }
  
  public Identifier getID() {
    return IDENTIFIER;
  }
  
  public Text getText() {
    return this.TEXT;
  }
  
  public float getMillisLeft() {
    return this.millisLeft;
  }
  
  public void setMillisLeft(float millisLeft) {
    this.millisLeft = millisLeft;
  }
  
  /**
   * @return the Opacity of the message as an int (4 - 256)
   */
  @Range(from = 4, to = 256)
  public int getOpacity(){
    if(this.millisLeft > BLEND_TIME) return 256;
    int min = 4; // for some reason (probably float inaccuracy) anything with an alpha value bellow 4 will be displayed incorrectly
    return (int) Math.clamp(this.millisLeft / BLEND_TIME * 256, min, 256);
  }
}
