package net.fawnoculus.ntm.util.messages;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Range;

import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class AdvancedMessage {
  private static final float BLEND_TIME = 10f;
  private final Identifier IDENTIFIER;
  private final Text TEXT;
  private float ticksLeft;
  public static final PacketCodec<ByteBuf, AdvancedMessage> PACKET_CODEC = new PacketCodec<>() {
    public AdvancedMessage decode(ByteBuf byteBuf) {
      String string = new String(PacketByteBuf.readByteArray(byteBuf), StandardCharsets.UTF_8);
      Gson gson = new GsonBuilder().disableHtmlEscaping().create();
      JsonReader jsonReader = new JsonReader(new StringReader(string));
      JsonObject jsonObject = gson.fromJson(jsonReader, JsonObject.class);
      return AdvancedMessage.decode(jsonObject);
    }
    
    public void encode(ByteBuf byteBuf, AdvancedMessage message) {
      JsonObject json = AdvancedMessage.encode(message);
      PacketByteBuf.writeByteArray(byteBuf, json.toString().getBytes(StandardCharsets.UTF_8));
    }
  };
  
  private static JsonObject encode(AdvancedMessage message){
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("identifier", new JsonPrimitive(message.IDENTIFIER.toString()));
    jsonObject.add("tick_amount", new JsonPrimitive(message.ticksLeft));
    jsonObject.add("text", new JsonPrimitive(Text.Serialization.toJsonString(message.TEXT, BuiltinRegistries.createWrapperLookup())));
    return jsonObject;
  }
  private static AdvancedMessage decode(JsonObject json){
    Identifier identifier = Identifier.of(json.getAsJsonPrimitive("identifier").getAsString());
    float ticksLeft  = json.getAsJsonPrimitive("tick_amount").getAsFloat();
    Text text = Text.Serialization.fromJson(json.getAsJsonPrimitive("text").getAsString(), BuiltinRegistries.createWrapperLookup());
    return new AdvancedMessage(identifier, text, ticksLeft);
  }
  
  /**
   * @param identifier Identifier of the Message (can override other messages if the Identifier is the same)
   * @param text Text to be displayed
   * @param tick_amount Amount of Ticks the Message should be displayed for;
   */
  public AdvancedMessage(Identifier identifier, Text text, float tick_amount){
    this.IDENTIFIER = identifier;
    this.TEXT = text;
    this.ticksLeft = tick_amount;
  }
  
  public Identifier getID() {
    return IDENTIFIER;
  }
  
  public Text getText() {
    return this.TEXT;
  }
  
  public float getTicksLeft() {
    return this.ticksLeft;
  }
  
  public void setTicksLeft(float ticksLeft) {
    this.ticksLeft = ticksLeft;
  }
  
  /**
   * @return the Opacity of the message as an int (4 - 256)
   */
  @Range(from = 4, to = 256)
  public int getOpacity(){
    if(this.ticksLeft > BLEND_TIME) return 256;
    int min = 4; // for some reason anything with a alpha value bellow 4 will be displayed incorrectly
    return (int) Math.clamp(this.ticksLeft / BLEND_TIME * 256, min, 256);
  }
}
