package net.fawnoculus.ntm.network.c2s;

import net.fawnoculus.ntm.NTM;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record BEInteractionPayload(BlockPos pos, Identifier action,
                                   CompoundTag extraData) implements CustomPacketPayload {
    public static final Identifier BE_INTERACTION_PAYLOAD_ID = NTM.id("be_interaction");
    public static final CustomPacketPayload.Type<BEInteractionPayload> ID = new CustomPacketPayload.Type<>(BE_INTERACTION_PAYLOAD_ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, BEInteractionPayload> PACKET_CODEC = StreamCodec.composite(
      BlockPos.STREAM_CODEC, BEInteractionPayload::pos,
      Identifier.STREAM_CODEC, BEInteractionPayload::action,
      ByteBufCodecs.COMPOUND_TAG, BEInteractionPayload::extraData,
      BEInteractionPayload::new
    );

    public BEInteractionPayload(BlockPos pos, Identifier action) {
        this(pos, action, new CompoundTag());
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
