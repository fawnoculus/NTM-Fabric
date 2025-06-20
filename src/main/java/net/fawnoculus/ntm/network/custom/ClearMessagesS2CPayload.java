package net.fawnoculus.ntm.network.custom;

import net.fawnoculus.ntm.main.NTM;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record ClearMessagesS2CPayload(Identifier identifier) implements CustomPayload {
  public static final Identifier CLEAR_ALL_MESSAGES_PAYLOAD_ID = NTM.id("clear_all_messages");
  public static final CustomPayload.Id<ClearMessagesS2CPayload> ID = new CustomPayload.Id<>(CLEAR_ALL_MESSAGES_PAYLOAD_ID);
  
  public static final PacketCodec<RegistryByteBuf, ClearMessagesS2CPayload> PACKET_CODEC = PacketCodec.tuple(Identifier.PACKET_CODEC, ClearMessagesS2CPayload::identifier, ClearMessagesS2CPayload::new);
  
  @Override
  public Id<? extends CustomPayload> getId() {
    return ID;
  }
}
