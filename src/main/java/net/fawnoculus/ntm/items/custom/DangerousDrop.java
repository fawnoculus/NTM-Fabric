package net.fawnoculus.ntm.items.custom;

import net.minecraft.entity.ItemEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public interface DangerousDrop {
  void onDropped(ServerWorld world, Vec3d pos, ItemEntity entity);

  void onTouchBlock(ServerWorld world, Vec3d pos, ItemEntity entity);
}
