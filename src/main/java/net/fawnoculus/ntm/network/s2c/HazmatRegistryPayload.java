package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.radiation.HazmatRegistry;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record HazmatRegistryPayload(HazmatRegistry.Serialized serializedRegistry) implements CustomPayload {
    public static final Identifier HAZMAT_REGISTRY_PAYLOAD_ID = NTM.id("hazmat_registry");
    public static final Id<HazmatRegistryPayload> ID = new Id<>(HAZMAT_REGISTRY_PAYLOAD_ID);

    public static final PacketCodec<RegistryByteBuf, HazmatRegistryPayload> PACKET_CODEC = PacketCodec.tuple(HazmatRegistry.Serialized.PACKET_CODEC, HazmatRegistryPayload::serializedRegistry, HazmatRegistryPayload::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
