package net.fawnoculus.ntm.blocks.custom;

import net.fawnoculus.ntm.blocks.entities.AdvancedModelBE;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public abstract class BlenderModelBlock extends BlockWithEntity {
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
  public abstract @Nullable AdvancedModelBE createBlockEntity(BlockPos pos, BlockState state);
  
  @Override
  protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
    return true;
  }
}
