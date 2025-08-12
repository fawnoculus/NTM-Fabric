package net.fawnoculus.ntm.blocks.entities.container.fluid;

import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.blocks.node.type.StorageNode;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class FluidBarrelBE extends FluidInventoryBE implements StorageNode {
  private StorageNode.StorageMode storageMode = StorageMode.Consume;

  public FluidBarrelBE(BlockPos pos, BlockState state) {
    super(NTMBlockEntities.SIMPLE_FLUID_STORAGE_BE, pos, state, 2);
  }

  public static void tick(World world, BlockPos pos, BlockState state, FluidBarrelBE entity) {
    entity.markDirty();
  }

  private void processFluidStoringItems(){
    // TODO: this
  }

  @Override
  public void setStorageMode(@NotNull StorageMode mode) {
    this.storageMode = mode;
  }

  @Override
  public StorageMode getStorageMode() {
    return this.storageMode;
  }

  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    super.writeNbt(nbt, registryLookup);
    this.writeStorageMode(nbt, registryLookup);
  }

  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    super.readNbt(nbt, registryLookup);
    this.readStorageMode(nbt, registryLookup);
  }
}
