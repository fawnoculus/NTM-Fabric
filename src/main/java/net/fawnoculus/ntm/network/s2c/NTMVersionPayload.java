package net.fawnoculus.ntm.network.s2c;

import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;
import net.fabricmc.loader.impl.util.version.VersionParser;
import net.fawnoculus.ntm.NTM;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

import java.nio.charset.StandardCharsets;

public record NTMVersionPayload(Version version) implements CustomPacketPayload {
    public static final Identifier NTM_VERSION_PAYLOAD_ID = NTM.id("version");
    public static final CustomPacketPayload.Type<NTMVersionPayload> ID = new CustomPacketPayload.Type<>(NTM_VERSION_PAYLOAD_ID);

    private static final StreamCodec<RegistryFriendlyByteBuf, Version> VERSION_PACKET_CODEC = new StreamCodec<>() {
        @Override
        public Version decode(RegistryFriendlyByteBuf byteBuf) {
            String string = new String(byteBuf.readByteArray(), StandardCharsets.UTF_8);
            try {
                return VersionParser.parse(string, false);
            } catch (VersionParsingException e) {
                NTM.LOGGER.warn("Exception Occurred while trying to parse Version Packet");
                return null;
            }
        }

        @Override
        public void encode(RegistryFriendlyByteBuf byteBuf, Version version) {
            byteBuf.writeByteArray(version.getFriendlyString().getBytes(StandardCharsets.UTF_8));
        }
    };

    public static final StreamCodec<RegistryFriendlyByteBuf, NTMVersionPayload> PACKET_CODEC = StreamCodec.composite(VERSION_PACKET_CODEC, NTMVersionPayload::version, NTMVersionPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
