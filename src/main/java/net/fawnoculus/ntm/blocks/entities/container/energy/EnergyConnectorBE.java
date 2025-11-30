package net.fawnoculus.ntm.blocks.entities.container.energy;

import net.fawnoculus.ntm.api.node.NodeValueContainer;
import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

import java.util.Collection;
import java.util.List;

public class EnergyConnectorBE extends EnergyBE {
    public EnergyConnectorBE(BlockPos pos, BlockState state) {
        super(NTMBlockEntities.SIMPLE_ENERGY_CONNECTOR_BE, pos, state);
    }

    @Override
    public Collection<NodeValueContainer> getContainers() {
        return List.of();
    }
}
