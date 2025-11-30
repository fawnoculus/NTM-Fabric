package net.fawnoculus.ntm.blocks.entities.container.fluid;

import net.fawnoculus.ntm.api.node.NodeValueContainer;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.BlockPos;

import java.util.Collection;
import java.util.List;

public class FluidConnectorBE extends FluidTypeBE {
    // TODO: this

    public FluidConnectorBE(BlockPos pos, BlockState state) {
        super(null, pos, state);
    }

    @Override
    public Collection<NodeValueContainer> getContainers(Fluid fluid) {
        return List.of();
    }
}
