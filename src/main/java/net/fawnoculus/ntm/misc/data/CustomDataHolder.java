package net.fawnoculus.ntm.misc.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.chunk.LevelChunk;
import org.jetbrains.annotations.NotNull;

public interface CustomDataHolder {
    String KEY = "ntm.custom_data";

    static CustomDataHolder from(LevelChunk chunk) {
        return (CustomDataHolder) chunk;
    }

    static CustomDataHolder from(Entity entity) {
        return (CustomDataHolder) entity;
    }

    @NotNull CompoundTag NTM$getCustomData();

    void NTM$setCustomData(CompoundTag customData);
}
