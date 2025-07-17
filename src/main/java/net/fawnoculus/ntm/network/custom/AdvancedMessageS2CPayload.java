package net.fawnoculus.ntm.network.custom;

import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.misc.messages.AdvancedMessage;
import net.fawnoculus.ntm.util.JsonUtil;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

import java.nio.charset.StandardCharsets;

public record AdvancedMessageS2CPayload(AdvancedMessage message) implements CustomPayload {
  public static final Identifier ADVANCED_MESSAGE_PAYLOAD_ID = NTM.id("advanced_message");
  public static final CustomPayload.Id<AdvancedMessageS2CPayload> ID = new CustomPayload.Id<>(ADVANCED_MESSAGE_PAYLOAD_ID);
  
  public static final PacketCodec<RegistryByteBuf, AdvancedMessageS2CPayload> PACKET_CODEC = PacketCodec.tuple(AdvancedMessage.PACKET_CODEC, AdvancedMessageS2CPayload::message, AdvancedMessageS2CPayload::new);
  
  @Override
  public CustomPayload.Id<? extends CustomPayload> getId() {
    return ID;
  }
}
