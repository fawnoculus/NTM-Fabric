package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record BlockPosPayload(BlockPos pos) implements CustomPayload {
	public static final Identifier BLOCK_POS_PAYLOAD_ID = NTM.id("block_pos");
	public static final CustomPayload.Id<BlockPosPayload> ID = new CustomPayload.Id<>(BLOCK_POS_PAYLOAD_ID);

	public static final PacketCodec<RegistryByteBuf, BlockPosPayload> PACKET_CODEC = PacketCodec.tuple(BlockPos.PACKET_CODEC, BlockPosPayload::pos, BlockPosPayload::new);

	@Override
	public Id<? extends CustomPayload> getId() {
		return ID;
	}
}
