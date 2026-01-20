package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record AdvancedMessagePayload(AdvancedMessage message) implements CustomPacketPayload {
    public static final Identifier ADVANCED_MESSAGE_PAYLOAD_ID = NTM.id("advanced_message");
    public static final CustomPacketPayload.Type<AdvancedMessagePayload> ID = new CustomPacketPayload.Type<>(ADVANCED_MESSAGE_PAYLOAD_ID);

    public static final StreamCodec<RegistryFriendlyByteBuf, AdvancedMessagePayload> PACKET_CODEC = StreamCodec.composite(AdvancedMessage.PACKET_CODEC, AdvancedMessagePayload::message, AdvancedMessagePayload::new);

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
