package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record RemoveMessagePayload(Identifier identifier) implements CustomPacketPayload {
    public static final Identifier CLEAR_ALL_MESSAGES_PAYLOAD_ID = NTM.id("remove_message");
    public static final CustomPacketPayload.Type<RemoveMessagePayload> ID = new CustomPacketPayload.Type<>(CLEAR_ALL_MESSAGES_PAYLOAD_ID);

    public static final StreamCodec<RegistryFriendlyByteBuf, RemoveMessagePayload> PACKET_CODEC = StreamCodec.composite(Identifier.STREAM_CODEC, RemoveMessagePayload::identifier, RemoveMessagePayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
