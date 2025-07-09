package net.fawnoculus.ntm.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class WorldUtil {
  public static ChunkPos getChunkPos(Vec3d pos){
    return new ChunkPos((int) (pos.x / 16), (int) (pos.z / 16));
  }
  public static ChunkPos getChunkPos(Vec3i pos){
    return new ChunkPos(pos.getX() / 16, pos.getZ() / 16);
  }
  public static ChunkPos getChunkPos(BlockPos pos){
    return new ChunkPos(pos.getX() / 16, pos.getZ() / 16);
  }
}
