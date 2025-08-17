package net.fawnoculus.ntm.blocks.entities.container.fluid;

import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.api.node.NodeValueContainer;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

import java.util.Collection;
import java.util.List;

public class FluidConnectorBE extends FluidBE {
  public FluidConnectorBE(BlockPos pos, BlockState state) {
    super(NTMBlockEntities.SIMPLE_ENERGY_CONNECTOR_BE, pos, state);
  }

  @Override
  public Collection<NodeValueContainer> getContainers() {
    return List.of();
  }
}
