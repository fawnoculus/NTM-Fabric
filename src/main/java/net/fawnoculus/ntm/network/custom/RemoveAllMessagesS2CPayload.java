package net.fawnoculus.ntm.network.custom;

import net.fawnoculus.ntm.NTM;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record RemoveAllMessagesS2CPayload() implements CustomPayload {
  
  public static final Identifier CLEAR_ALL_MESSAGES_PAYLOAD_ID = NTM.id("remove_all_messages");
  public static final Id<RemoveAllMessagesS2CPayload> ID = new Id<>(CLEAR_ALL_MESSAGES_PAYLOAD_ID);
  
  public static final PacketCodec<RegistryByteBuf, RemoveAllMessagesS2CPayload> PACKET_CODEC = PacketCodec.tuple(
      Identifier.PACKET_CODEC,
      ignored -> Identifier.of("ignored:ignored"),
      ignored -> new RemoveAllMessagesS2CPayload()
  );
  
  @Override
  public Id<? extends CustomPayload> getId() {
    return ID;
  }
}
