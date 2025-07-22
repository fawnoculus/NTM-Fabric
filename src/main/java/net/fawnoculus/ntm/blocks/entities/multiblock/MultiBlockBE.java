package net.fawnoculus.ntm.blocks.entities.multiblock;

import net.minecraft.util.math.BlockPos;

public interface MultiBlockBE {
  void setOrigin(BlockPos pos);
  void getOrigin(BlockPos pos);
}
