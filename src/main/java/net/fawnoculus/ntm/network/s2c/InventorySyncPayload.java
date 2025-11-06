package net.fawnoculus.ntm.network.s2c;

import net.fawnoculus.ntm.NTM;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record InventorySyncPayload(BlockPos pos, SimpleInventory inventory) implements CustomPayload {
	public static final Identifier GENERIC_INVENTORY_PAYLOAD_ID = NTM.id("inventory_sync");
	public static final Id<InventorySyncPayload> ID = new Id<>(GENERIC_INVENTORY_PAYLOAD_ID);

	public static final PacketCodec<RegistryByteBuf, SimpleInventory> INVENTORY_CODEC = new PacketCodec<>() {
		@Override
		public SimpleInventory decode(RegistryByteBuf buf) {
			int size = buf.readVarInt();

			SimpleInventory inventory = new SimpleInventory(size);
			for (int i = 0; i < size; i++) {
				inventory.setStack(i, ItemStack.OPTIONAL_PACKET_CODEC.decode(buf));
			}

			return inventory;
		}

		@Override
		public void encode(RegistryByteBuf buf, SimpleInventory inventory) {
			buf.writeVarInt(inventory.size());

			for (ItemStack stack : inventory) {
				ItemStack.OPTIONAL_PACKET_CODEC.encode(buf, stack);
			}
		}
	};

	public static final PacketCodec<RegistryByteBuf, InventorySyncPayload> PACKET_CODEC = PacketCodec.tuple(
	  BlockPos.PACKET_CODEC, InventorySyncPayload::pos,
	  INVENTORY_CODEC, InventorySyncPayload::inventory,
	  InventorySyncPayload::new
	);

	@Override
	public Id<? extends CustomPayload> getId() {
		return ID;
	}
}
