package net.fawnoculus.ntm.blocks.entities;

import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AlloyFurnaceExtensionBE extends BlockEntity {
    public AlloyFurnaceExtensionBE(BlockPos pos, BlockState state) {
        super(NTMBlockEntities.ALLOY_FURNACE_EXTENSION_BE, pos, state);
    }
}
