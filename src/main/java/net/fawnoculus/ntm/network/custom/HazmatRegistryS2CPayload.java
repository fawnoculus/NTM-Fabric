package net.fawnoculus.ntm.network.custom;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.misc.radiation.HazmatRegistry;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record HazmatRegistryS2CPayload(HazmatRegistry.Serialized serializedRegistry) implements CustomPayload {
  public static final Identifier HAZMAT_REGISTRY_PAYLOAD_ID = NTM.id("hazmat_registry");
  public static final Id<HazmatRegistryS2CPayload> ID = new Id<>(HAZMAT_REGISTRY_PAYLOAD_ID);
  
  public static final PacketCodec<RegistryByteBuf, HazmatRegistryS2CPayload> PACKET_CODEC = PacketCodec.tuple(HazmatRegistry.Serialized.PACKET_CODEC, HazmatRegistryS2CPayload::serializedRegistry, HazmatRegistryS2CPayload::new);
  
  @Override
  public Id<? extends CustomPayload> getId() {
    return ID;
  }
}
