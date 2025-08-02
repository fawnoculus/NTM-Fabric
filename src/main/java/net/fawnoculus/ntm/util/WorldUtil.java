package net.fawnoculus.ntm.util;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class WorldUtil {
  @Contract(value = "_ -> new", pure = true)
  public static @NotNull ChunkPos getChunkPos(@NotNull Vec3d pos){
    return new ChunkPos((int) (pos.x / 16), (int) (pos.z / 16));
  }
  @Contract("_ -> new")
  public static @NotNull ChunkPos getChunkPos(@NotNull Vec3i pos){
    return new ChunkPos(pos.getX() / 16, pos.getZ() / 16);
  }
  
  public static Vec3d getVec3d(Vec3i pos){
    return new Vec3d(pos.getX(), pos.getY(), pos.getZ());
  }
}
