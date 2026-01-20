package net.fawnoculus.ntm.blocks.entities.container.energy;

import net.fawnoculus.ntm.api.node.NodeValueContainer;
import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

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
