package net.fawnoculus.ntm.blocks.entities.container.fluid;

import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
import net.fawnoculus.ntm.blocks.node.type.ConnectorNode;
import net.fawnoculus.ntm.blocks.node.type.FluidNode;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FluidConnectorBE extends BlockEntity implements FluidNode, ConnectorNode {
  private boolean shouldAssignNetwork = false;
  public NodeNetwork network;
  public Fluid fluidType = null;
  
  public FluidConnectorBE(BlockPos pos, BlockState state) {
    super(NTMBlockEntities.SIMPLE_ENERGY_CONNECTOR_BE, pos, state);
  }
  
  @Override
  public void setShouldAssignNetwork(boolean value) {
    this.shouldAssignNetwork = value;
  }
  
  @Override
  public boolean shouldAssignNetwork() {
    return this.shouldAssignNetwork;
  }
  
  @Override
  public void setNetwork(NodeNetwork network) {
    this.network = network;
  }
  
  @Override
  public @Nullable NodeNetwork getNetwork() {
    return this.network;
  }
  
  @Override
  public void setWorld(World world) {
    super.setWorld(world);
    this.setShouldAssignNetwork(true);
    if(world.isClient){
      return;
    }
    if(this.network == null){
      this.assignNetwork();
    }
  }
  
  @Override
  public void markRemoved() {
    super.markRemoved();
    this.onUnload();
  }
  
  @Override
  public void onBlockReplaced(BlockPos pos, BlockState oldState) {
    super.onBlockReplaced(pos, oldState);
    this.onBreak();
  }
  
  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    super.readNbt(nbt, registries);
    this.readNodeData(nbt, registries);
    this.readFluidNodeData(nbt, registries);
  }
  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    super.writeNbt(nbt, registries);
    this.writeNodeData(nbt, registries);
    this.writeFluidNodeData(nbt, registries);
  }
  
  @Override
  public @Nullable Fluid getFluidType() {
    return fluidType;
  }
  
  @Override
  public void setFluidType(Fluid fluid) {
    this.fluidType = fluid;
  }
}
