package net.fawnoculus.ntm.network.custom;

import net.fawnoculus.ntm.NTM;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record BlockPosS2CPayload(BlockPos pos) implements CustomPayload {
  public static final Identifier BLOCK_POS_PAYLOAD_ID = NTM.id("block_pos");
  public static final CustomPayload.Id<BlockPosS2CPayload> ID = new CustomPayload.Id<>(BLOCK_POS_PAYLOAD_ID);
  
  public static final PacketCodec<RegistryByteBuf, BlockPosS2CPayload> PACKET_CODEC = PacketCodec.tuple(BlockPos.PACKET_CODEC, BlockPosS2CPayload::pos, BlockPosS2CPayload::new);
  
  @Override
  public Id<? extends CustomPayload> getId() {
    return ID;
  }
}
