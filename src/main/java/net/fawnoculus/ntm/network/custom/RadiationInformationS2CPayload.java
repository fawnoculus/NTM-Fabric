package net.fawnoculus.ntm.network.custom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import io.netty.buffer.ByteBuf;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Range;

import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public record RadiationInformationS2CPayload(RadiationInfo info) implements CustomPayload {
  public static final Identifier RADIATION_INFORMATION_PAYLOAD_ID = NTM.id("radiation_information");
  public static final Id<RadiationInformationS2CPayload> ID = new Id<>(RADIATION_INFORMATION_PAYLOAD_ID);
  
  public static final PacketCodec<RegistryByteBuf, RadiationInformationS2CPayload> PACKET_CODEC = PacketCodec.tuple(RadiationInfo.PACKET_CODEC, RadiationInformationS2CPayload::info, RadiationInformationS2CPayload::new);
  
  public record RadiationInfo(
      @Range(from = 0, to = 1_000_000) double radiationExposure,
      double inventoryRadiation,
      double passiveChunkRadiation,
      double activeChunkRadiation
      ) {
    public static final PacketCodec<ByteBuf, RadiationInfo> PACKET_CODEC = new PacketCodec<>() {
      public RadiationInfo decode(ByteBuf byteBuf) {
        String string = new String(PacketByteBuf.readByteArray(byteBuf), StandardCharsets.UTF_8);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        JsonReader jsonReader = new JsonReader(new StringReader(string));
        JsonObject jsonObject = gson.fromJson(jsonReader, JsonObject.class);
        return RadiationInfo.decode(jsonObject);
      }
      
      public void encode(ByteBuf byteBuf, RadiationInfo message) {
        JsonObject json = RadiationInfo.encode(message);
        PacketByteBuf.writeByteArray(byteBuf, json.toString().getBytes(StandardCharsets.UTF_8));
      }
    };
    
    private static JsonObject encode(RadiationInfo info) {
      JsonObject jsonObject = new JsonObject();
      jsonObject.add("radiationExposure", new JsonPrimitive(info.radiationExposure));
      jsonObject.add("inventoryRadiation", new JsonPrimitive(info.inventoryRadiation));
      jsonObject.add("passiveChunkRadiation", new JsonPrimitive(info.passiveChunkRadiation));
      jsonObject.add("activeChunkRadiation", new JsonPrimitive(info.activeChunkRadiation));
      return jsonObject;
      
    }
    
    private static RadiationInfo decode(JsonObject json) {
      double radiationExposure = json.get("radiationExposure").getAsJsonPrimitive().getAsDouble();
      double inventoryRadiation = json.get("inventoryRadiation").getAsJsonPrimitive().getAsDouble();
      double passiveChunkRadiation = json.get("passiveChunkRadiation").getAsJsonPrimitive().getAsDouble();
      double activeChunkRadiation = json.get("activeChunkRadiation").getAsJsonPrimitive().getAsDouble();
      return new RadiationInfo(radiationExposure, inventoryRadiation, passiveChunkRadiation, activeChunkRadiation);
    }
    
    
  }
  
  @Override
  public Id<? extends CustomPayload> getId() {
    return ID;
  }
}
