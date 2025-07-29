package net.fawnoculus.ntm.blocks.entities.container.fluid;

import net.fawnoculus.ntm.blocks.node.NodeWithValue;
import net.fawnoculus.ntm.blocks.node.network.FluidNetwork;
import net.fawnoculus.ntm.blocks.node.network.NetworkType;
import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
import net.fawnoculus.ntm.blocks.node.type.FluidNode;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public abstract class FluidBE extends BlockEntity implements FluidNode, NodeWithValue {
  private boolean shouldAssignNetwork = true;
  private NodeNetwork network;
  private Fluid fluidType = null;
  private long value = 0;
  private long maxValue = 0;
  private long priority = 0;
  
  public FluidBE(BlockEntityType<?> type, BlockPos pos, BlockState state){
    super(type, pos, state);
  }
  
  @Override
  public void onBlockReplaced(BlockPos pos, BlockState oldState) {
    super.onBlockReplaced(pos, oldState);
    this.onBreak();
  }
  
  @Override
  public @Nullable Fluid getFluidType() {
    return fluidType;
  }
  
  @Override
  public void setFluidType(Fluid fluid) {
    this.fluidType = fluid;
  }
  
  @Override
  public NetworkType getNetworkType() {
    return new NetworkType.Fluid();
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
  public void setWorld(World world) {
    super.setWorld(world);
    if(world.isClient){
      return;
    }
    if(this.network == null){
      this.assignNetwork();
    }
  }
  
  @Override
  public @Nullable NodeNetwork getNetwork() {
    if(this.network == null){
      this.assignNetwork();
    }
    return this.network;
  }
  
  @Override
  public NodeNetwork makeNewNetwork() {
    return new FluidNetwork();
  }
  
  @Override
  public void markRemoved() {
    super.markRemoved();
    this.onUnload();
  }
  
  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    super.readNbt(nbt, registries);
    this.readNodeData(nbt, registries);
  }
  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    super.writeNbt(nbt, registries);
    this.writeNodeData(nbt, registries);
  }
  
  @Override
  public void setValue(@Range(from = 0, to = Long.MAX_VALUE) long value) {
    this.value = value;
  }
  
  @Override
  public long getValue() {
    return this.value;
  }
  
  @Override
  public void setMaxValue(@Range(from = 0, to = Long.MAX_VALUE) long value) {
    this.maxValue = value;
  }
  
  @Override
  public long getMaxValue() {
    return this.maxValue;
  }
  
  @Override
  public void setPriority(long value) {
    this.priority = value;
  }
  
  @Override
  public long getPriority() {
    return this.priority;
  }
}
