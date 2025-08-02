package net.fawnoculus.ntm.network.s2c;

import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;
import net.fabricmc.loader.impl.util.version.VersionParser;
import net.fawnoculus.ntm.NTM;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

import java.nio.charset.StandardCharsets;

public record NTMVersionPayload(Version version) implements CustomPayload {
  public static final Identifier NTM_VERSION_PAYLOAD_ID = NTM.id("version");
  public static final CustomPayload.Id<NTMVersionPayload> ID = new CustomPayload.Id<>(NTM_VERSION_PAYLOAD_ID);

  private static final PacketCodec<RegistryByteBuf, Version> VERSION_PACKET_CODEC = new PacketCodec<>() {
    @Override
    public Version decode(RegistryByteBuf byteBuf) {
      String string = new String(byteBuf.readByteArray(), StandardCharsets.UTF_8);
      try {
        return VersionParser.parse(string, false);
      } catch (VersionParsingException e) {
        NTM.LOGGER.warn("Exception Occurred while trying to parse Version Packet");
        return null;
      }
    }

    @Override
    public void encode(RegistryByteBuf byteBuf, Version version) {
      byteBuf.writeByteArray(version.getFriendlyString().getBytes(StandardCharsets.UTF_8));
    }
  };

  public static final PacketCodec<RegistryByteBuf, NTMVersionPayload> PACKET_CODEC = PacketCodec.tuple(VERSION_PACKET_CODEC, NTMVersionPayload::version, NTMVersionPayload::new);

  @Override
  public Id<? extends CustomPayload> getId() {
    return ID;
  }
}
