package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.explosion.NTMExplosionType;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.NbtSizeTracker;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record NTMExplosionPayload<T>(NTMExplosionType<T> explosionType, BlockPos pos,
                                     T extraData) implements CustomPayload {
    public static final Identifier EXPLOSION_PAYLOAD_ID = NTM.id("explosion");
    public static final CustomPayload.Id<NTMExplosionPayload<?>> ID = new CustomPayload.Id<>(EXPLOSION_PAYLOAD_ID);
    public static final PacketCodec<RegistryByteBuf, NTMExplosionPayload<?>> PACKET_CODEC = new PacketCodec<>() {
        private static <T> void handleEncoding(RegistryByteBuf buf, NTMExplosionPayload<T> value) {
            NTMExplosionType.PACKET_CODEC.encode(buf, value.explosionType);
            BlockPos.PACKET_CODEC.encode(buf, value.pos);
            buf.writeNbt(value.explosionType.getExtraDataCodec().encodeStart(NbtOps.INSTANCE, value.extraData).getOrThrow());
        }

        private static <T> NTMExplosionPayload<T> handleDecoding(RegistryByteBuf buf, NTMExplosionType<T> type) {
            BlockPos pos = BlockPos.PACKET_CODEC.decode(buf);
            T extraData = type.getExtraDataCodec().decode(NbtOps.INSTANCE, buf.readNbt(NbtSizeTracker.ofUnlimitedBytes())).getOrThrow().getFirst();
            return new NTMExplosionPayload<>(type, pos, extraData);
        }

        @Override
        public NTMExplosionPayload<?> decode(RegistryByteBuf buf) {
            return handleDecoding(buf, NTMExplosionType.PACKET_CODEC.decode(buf));
        }

        @Override
        public void encode(RegistryByteBuf buf, NTMExplosionPayload<?> value) {
            handleEncoding(buf, value);
        }
    };

    @Override
    public CustomPayload.Id<? extends CustomPayload> getId() {
        return ID;
    }
}
