package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record AdvancedMessagePayload(AdvancedMessage message) implements CustomPayload {
	public static final Identifier ADVANCED_MESSAGE_PAYLOAD_ID = NTM.id("advanced_message");
	public static final CustomPayload.Id<AdvancedMessagePayload> ID = new CustomPayload.Id<>(ADVANCED_MESSAGE_PAYLOAD_ID);

	public static final PacketCodec<RegistryByteBuf, AdvancedMessagePayload> PACKET_CODEC = PacketCodec.tuple(AdvancedMessage.PACKET_CODEC, AdvancedMessagePayload::message, AdvancedMessagePayload::new);

	@Override
	public CustomPayload.Id<? extends CustomPayload> getId() {
		return ID;
	}
}
