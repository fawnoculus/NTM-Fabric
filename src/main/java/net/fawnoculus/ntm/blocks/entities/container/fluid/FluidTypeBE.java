package net.fawnoculus.ntm.blocks.entities.container.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;

public abstract class FluidTypeBE extends FluidBE {
    private Holder<Fluid> fluidType = BuiltInRegistries.FLUID.wrapAsHolder(Fluids.EMPTY);

    public FluidTypeBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public @Nullable Fluid getNodeFluid() {
        return fluidType.value();
    }

    @Override
    protected void loadAdditional(ValueInput view) {
        this.fluidType = view.read("fluidType", BuiltInRegistries.FLUID.holderByNameCodec()).orElse(BuiltInRegistries.FLUID.wrapAsHolder(Fluids.EMPTY));
        super.loadAdditional(view);
    }

    @Override
    protected void saveAdditional(ValueOutput view) {
        super.saveAdditional(view);
        view.store("fluidType", BuiltInRegistries.FLUID.holderByNameCodec(), this.fluidType);
    }
}
