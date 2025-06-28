package net.fawnoculus.ntm.blocks.custom;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class AdvancedModelBlock extends Block {
  public AdvancedModelBlock(Settings settings) {
    super(settings
        .nonOpaque()
        .allowsSpawning(Blocks::never)
        .solidBlock(Blocks::never)
        .suffocates(Blocks::never)
        .blockVision(Blocks::never)
    );
  }
  
  @Override
  protected VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return VoxelShapes.empty();
  }
  
  @Override
  protected float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
    return 1.0F;
  }
  
  @Override
  protected BlockRenderType getRenderType(BlockState state) {
    return BlockRenderType.INVISIBLE;
  }
}
