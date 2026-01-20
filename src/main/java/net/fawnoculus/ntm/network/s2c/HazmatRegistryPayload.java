package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.radiation.HazmatRegistry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record HazmatRegistryPayload(HazmatRegistry.Serialized serializedRegistry) implements CustomPacketPayload {
    public static final Identifier HAZMAT_REGISTRY_PAYLOAD_ID = NTM.id("hazmat_registry");
    public static final Type<HazmatRegistryPayload> ID = new Type<>(HAZMAT_REGISTRY_PAYLOAD_ID);

    public static final StreamCodec<RegistryFriendlyByteBuf, HazmatRegistryPayload> PACKET_CODEC = StreamCodec.composite(HazmatRegistry.Serialized.PACKET_CODEC, HazmatRegistryPayload::serializedRegistry, HazmatRegistryPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
