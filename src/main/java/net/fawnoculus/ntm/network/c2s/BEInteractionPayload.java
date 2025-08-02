package net.fawnoculus.ntm.network.c2s;

import net.fawnoculus.ntm.NTM;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record BEInteractionPayload(BlockPos pos, Identifier action) implements CustomPayload {
  public static final Identifier BE_INTERACTION_PAYLOAD_ID = NTM.id("be_interaction");
  public static final CustomPayload.Id<BEInteractionPayload> ID = new CustomPayload.Id<>(BE_INTERACTION_PAYLOAD_ID);

  public static final PacketCodec<RegistryByteBuf, BEInteractionPayload> PACKET_CODEC = PacketCodec.tuple(
      BlockPos.PACKET_CODEC, BEInteractionPayload::pos,
      Identifier.PACKET_CODEC, BEInteractionPayload::action,
      BEInteractionPayload::new
  );

  @Override
  public Id<? extends CustomPayload> getId() {
    return ID;
  }
}
