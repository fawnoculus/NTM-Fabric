package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record BlockPosPayload(BlockPos pos) implements CustomPacketPayload {
    public static final Identifier BLOCK_POS_PAYLOAD_ID = NTM.id("block_pos");
    public static final CustomPacketPayload.Type<BlockPosPayload> ID = new CustomPacketPayload.Type<>(BLOCK_POS_PAYLOAD_ID);

    public static final StreamCodec<RegistryFriendlyByteBuf, BlockPosPayload> PACKET_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, BlockPosPayload::pos, BlockPosPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
