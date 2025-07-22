package net.fawnoculus.ntm.blocks.custom;

import net.minecraft.block.*;
import net.minecraft.util.math.Direction;

public abstract class BlenderModelBlock extends Block {
  public BlenderModelBlock(Settings settings) {
    super(settings
        .nonOpaque()
        .allowsSpawning(Blocks::never)
        .solidBlock(Blocks::never)
        .suffocates(Blocks::never)
        .blockVision(Blocks::never)
    );
  }
  
  @Override
  protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
    return true;
  }
}
