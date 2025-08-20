package net.fawnoculus.ntm.blocks.entities.container.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
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
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    super.readNbt(nbt, registries);
    this.fluidType = nbt.get("fluidType", Registries.FLUID.getEntryCodec()).orElse(Registries.FLUID.getEntry(Fluids.EMPTY));
  }

  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    super.writeNbt(nbt, registries);
    nbt.put("fluidType", Registries.FLUID.getEntryCodec(), this.fluidType);
  }
}
