package net.fawnoculus.ntm.blocks.entities.container.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public abstract class FluidTypeBE extends FluidBE {
	public FluidTypeBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}

	private RegistryEntry<Fluid> fluidType = Registries.FLUID.getEntry(Fluids.EMPTY);

	@Override
	public @Nullable Fluid getNodeFluid() {
		return fluidType.value();
	}

	@Override
	protected void readData(ReadView view) {
		this.fluidType = view.read("fluidType", Registries.FLUID.getEntryCodec()).orElse(Registries.FLUID.getEntry(Fluids.EMPTY));
		super.readData(view);
	}

	@Override
	protected void writeData(WriteView view) {
		super.writeData(view);
		view.put("fluidType", Registries.FLUID.getEntryCodec(), this.fluidType);
	}
}
