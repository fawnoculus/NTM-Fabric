package net.fawnoculus.ntm.network.c2s;

import net.fawnoculus.ntm.NTM;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record ItemInteractionPayload(Identifier action, NbtCompound extraData) implements CustomPayload {
    public static final Identifier ITEM_INTERACTION_PAYLOAD_ID = NTM.id("item_interaction");
    public static final Id<ItemInteractionPayload> ID = new Id<>(ITEM_INTERACTION_PAYLOAD_ID);

    public static final PacketCodec<RegistryByteBuf, ItemInteractionPayload> PACKET_CODEC = PacketCodec.tuple(
      Identifier.PACKET_CODEC, ItemInteractionPayload::action,
      PacketCodecs.NBT_COMPOUND, ItemInteractionPayload::extraData,
      ItemInteractionPayload::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
