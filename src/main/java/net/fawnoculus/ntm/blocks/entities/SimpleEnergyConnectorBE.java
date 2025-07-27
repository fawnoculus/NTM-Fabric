package net.fawnoculus.ntm.blocks.entities;

import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.blocks.node.NodeProperties;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class SimpleEnergyConnectorBE extends AbstractEnergyInventoryBE {
  public SimpleEnergyConnectorBE(BlockPos pos, BlockState state) {
    super(ModBlockEntities.SIMPLE_ENERGY_CONNECTOR_BE, pos, state, NodeProperties.Connector::new, 2);
  }
}
