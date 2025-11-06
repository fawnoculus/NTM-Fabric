package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record FluidDataRegistryPayload(NbtCompound registryNBT) implements CustomPayload {
	public static final Identifier FLUID_DATA_REGISTRY_PAYLOAD_ID = NTM.id("fluid_data_registry");
	public static final Id<FluidDataRegistryPayload> ID = new Id<>(FLUID_DATA_REGISTRY_PAYLOAD_ID);

	public static final PacketCodec<RegistryByteBuf, FluidDataRegistryPayload> PACKET_CODEC = PacketCodec.tuple(PacketCodecs.NBT_COMPOUND, FluidDataRegistryPayload::registryNBT, FluidDataRegistryPayload::new);

	@Override
	public Id<? extends CustomPayload> getId() {
		return ID;
	}
}
