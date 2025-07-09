package net.fawnoculus.ntm.network.custom;

import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.world.radiation.RadiationRegistry;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record RadiationRegistryS2CPayload(RadiationRegistry.Serialized serializedRegistry) implements CustomPayload {
  public static final Identifier RADIATION_REGISTRY_PAYLOAD_ID = NTM.id("radiation_registry");
  public static final Id<RadiationRegistryS2CPayload> ID = new Id<>(RADIATION_REGISTRY_PAYLOAD_ID);
  
  public static final PacketCodec<RegistryByteBuf, RadiationRegistryS2CPayload> PACKET_CODEC = PacketCodec.tuple(RadiationRegistry.Serialized.PACKET_CODEC, RadiationRegistryS2CPayload::serializedRegistry, RadiationRegistryS2CPayload::new);
  
  @Override
  public Id<? extends CustomPayload> getId() {
    return ID;
  }
}
