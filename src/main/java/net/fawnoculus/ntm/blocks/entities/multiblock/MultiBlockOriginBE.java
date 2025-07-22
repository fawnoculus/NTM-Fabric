package net.fawnoculus.ntm.blocks.entities.multiblock;

import net.minecraft.util.math.BlockPos;

public interface MultiBlockOriginBE extends MultiBlockBE {
  default void setOrigin(BlockPos pos){}
  default BlockPos getOrigin(){
    return this.getPos();
  }
  BlockPos getPos();
}
