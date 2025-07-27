package net.fawnoculus.ntm.blocks.entities;

import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.blocks.node.EnergyNode;
import net.fawnoculus.ntm.blocks.node.NodeProperties;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class SimpleEnergyStorageBE extends EnergyNode {
  public SimpleEnergyStorageBE(BlockPos pos, BlockState state) {
    super(ModBlockEntities.SIMPLE_ENERGY_STORAGE_BE, pos, state, NodeProperties.Storge::new);
  }
}
