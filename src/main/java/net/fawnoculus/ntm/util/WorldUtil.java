package net.fawnoculus.ntm.util;

import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.mixin.accessor.PersistentStateManagerAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.HashMap;

public class WorldUtil {
  private static final HashMap<Path, NbtCompound> RegionNbtCache = new HashMap<>();

  @Contract(value = "_ -> new", pure = true)
  public static @NotNull ChunkPos getChunkPos(@NotNull Vec3d pos) {
    return new ChunkPos((int) (pos.x / 16), (int) (pos.z / 16));
  }

  @Contract("_ -> new")
  public static @NotNull ChunkPos getChunkPos(@NotNull Vec3i pos) {
    return new ChunkPos(pos.getX() / 16, pos.getZ() / 16);
  }

  @Contract("_ -> new")
  public static @NotNull Vec3d getVec3d(@NotNull Vec3i pos) {
    return new Vec3d(pos.getX(), pos.getY(), pos.getZ());
  }

  public static void flushCachedRegionNBT() {
    for (Path filePath : RegionNbtCache.keySet()) {
      writeRegionNBT(filePath, RegionNbtCache.get(filePath));
    }

    RegionNbtCache.clear();
  }

  public static @NotNull NbtCompound getRegionNBT(Path regionFile) {
    NbtCompound regionNBT = RegionNbtCache.computeIfAbsent(regionFile, longPos -> {
        NbtCompound nbt = null;
        try {
          nbt = NbtIo.read(regionFile);
        } catch (Throwable ignored) {
        }
        return nbt != null ? nbt : new NbtCompound();
      }
    );

    if (RegionNbtCache.size() > NTMConfig.MaxRegionDataCache.getValue()) {
      flushCachedRegionNBT();
    }

    return regionNBT;
  }

  public static void writeRegionNBT(Path regionFile, NbtCompound nbt) {
    try {
      boolean ignored = regionFile.getParent().toFile().mkdirs();
      NbtIo.write(nbt, regionFile);
    } catch (Throwable ignored) {
    }
  }

  public static NbtCompound getChunkNBT(@NotNull ChunkPos pos, @NotNull ServerWorld world) {
    Path regionPath = ((PersistentStateManagerAccessor) world.getChunkManager().getPersistentStateManager())
      .NTM$getDirectory()
      .resolve("ntm/chunk_data")
      .resolve("r." + pos.x / 32 + "." + pos.z / 32 + ".dat");

    return getRegionNBT(regionPath).getCompoundOrEmpty(pos.toString());
  }

  public static void setChunkData(@NotNull ChunkPos pos, @NotNull ServerWorld world, NbtCompound nbt) {
    Path regionPath = ((PersistentStateManagerAccessor) world.getChunkManager().getPersistentStateManager())
      .NTM$getDirectory()
      .resolve("ntm/chunk_data")
      .resolve("r." + pos.x / 32 + "." + pos.z / 32 + ".dat");

    NbtCompound regionNBT = getRegionNBT(regionPath);
    regionNBT.put(pos.toString(), nbt);
    RegionNbtCache.put(regionPath, regionNBT);
  }

  public static void removeBlock(World world, BlockPos pos, PlayerEntity player, boolean doBlockDrops){
    BlockEntity blockEntity = world.getBlockEntity(pos);
    BlockState originalState = world.getBlockState(pos);
    Block block = originalState.getBlock();
    BlockState newState = block.onBreak(world, pos, originalState, player);
    boolean bl = world.removeBlock(pos, false);
    if (bl) {
      block.onBroken(world, pos, newState);
    }

    if(doBlockDrops){
      ItemStack itemStack = player.getMainHandStack();
      ItemStack itemStack2 = itemStack.copy();
      boolean bl2 = player.canHarvest(newState);
      itemStack.postMine(world, newState, pos, player);
      if (bl && bl2) {
        block.afterBreak(world, player, pos, newState, blockEntity, itemStack2);
      }
    }

  }

  public static void dropItemsFromBlock(World world, BlockPos pos, PlayerEntity miner, ItemStack tool){
    BlockState state = world.getBlockState(pos);
    Block.dropStacks(state, world, pos, world.getBlockEntity(pos), miner, tool);
  }
}
