package net.fawnoculus.ntm.network.c2s;

import net.fawnoculus.ntm.NTM;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record ItemInteractionPayload(Identifier action, CompoundTag extraData) implements CustomPacketPayload {
    public static final Identifier ITEM_INTERACTION_PAYLOAD_ID = NTM.id("item_interaction");
    public static final Type<ItemInteractionPayload> ID = new Type<>(ITEM_INTERACTION_PAYLOAD_ID);

    public static final StreamCodec<RegistryFriendlyByteBuf, ItemInteractionPayload> PACKET_CODEC = StreamCodec.composite(
      Identifier.STREAM_CODEC, ItemInteractionPayload::action,
      ByteBufCodecs.COMPOUND_TAG, ItemInteractionPayload::extraData,
      ItemInteractionPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
