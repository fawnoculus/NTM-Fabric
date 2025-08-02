package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record RemoveMessagePayload(Identifier identifier) implements CustomPayload {
  public static final Identifier CLEAR_ALL_MESSAGES_PAYLOAD_ID = NTM.id("remove_message");
  public static final CustomPayload.Id<RemoveMessagePayload> ID = new CustomPayload.Id<>(CLEAR_ALL_MESSAGES_PAYLOAD_ID);

  public static final PacketCodec<RegistryByteBuf, RemoveMessagePayload> PACKET_CODEC = PacketCodec.tuple(Identifier.PACKET_CODEC, RemoveMessagePayload::identifier, RemoveMessagePayload::new);

  @Override
  public Id<? extends CustomPayload> getId() {
    return ID;
  }
}
