package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.radiation.RadiationRegistry;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record RadiationRegistryPayload(RadiationRegistry.Serialized serializedRegistry) implements CustomPayload {
    public static final Identifier RADIATION_REGISTRY_PAYLOAD_ID = NTM.id("radiation_registry");
    public static final Id<RadiationRegistryPayload> ID = new Id<>(RADIATION_REGISTRY_PAYLOAD_ID);

    public static final PacketCodec<RegistryByteBuf, RadiationRegistryPayload> PACKET_CODEC = PacketCodec.tuple(RadiationRegistry.Serialized.PACKET_CODEC, RadiationRegistryPayload::serializedRegistry, RadiationRegistryPayload::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
