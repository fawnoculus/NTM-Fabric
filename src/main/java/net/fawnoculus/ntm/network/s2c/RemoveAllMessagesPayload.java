package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record RemoveAllMessagesPayload() implements CustomPayload {

  public static final Identifier CLEAR_ALL_MESSAGES_PAYLOAD_ID = NTM.id("remove_all_messages");
  public static final Id<RemoveAllMessagesPayload> ID = new Id<>(CLEAR_ALL_MESSAGES_PAYLOAD_ID);

  public static final PacketCodec<RegistryByteBuf, RemoveAllMessagesPayload> PACKET_CODEC = PacketCodec.tuple(
      Identifier.PACKET_CODEC,
      ignored -> Identifier.of("ignored:ignored"),
      ignored -> new RemoveAllMessagesPayload()
  );

  @Override
  public Id<? extends CustomPayload> getId() {
    return ID;
  }
}
