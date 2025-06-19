package net.fawnoculus.ntm.blocks.entities;

import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class RenderTestBE extends BlockEntity {
  public RenderTestBE(BlockPos pos, BlockState state) {
    super(ModBlockEntities.RENDER_TEST_BE, pos, state);
  }
}
