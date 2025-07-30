package net.fawnoculus.ntm.blocks.entities;

import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class AlloyFurnaceExtensionBE extends BlockEntity {
  public AlloyFurnaceExtensionBE(BlockPos pos, BlockState state) {
    super(NTMBlockEntities.ALLOY_FURNACE_EXTENSION_BE, pos, state);
  }
}
