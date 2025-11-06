package net.fawnoculus.ntm.misc.data;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.chunk.WorldChunk;
import org.jetbrains.annotations.NotNull;

public interface CustomDataHolder {
	String KEY = "ntm.custom_data";

	@NotNull NbtCompound NTM$getCustomData();

	void NTM$setCustomData(NbtCompound customData);

	static CustomDataHolder from(WorldChunk chunk) {
		return (CustomDataHolder) chunk;
	}

	static CustomDataHolder from(Entity entity) {
		return (CustomDataHolder) entity;
	}
}
