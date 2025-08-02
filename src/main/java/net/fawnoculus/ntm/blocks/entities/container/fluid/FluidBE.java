package net.fawnoculus.ntm.blocks.entities.container.fluid;

import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
import net.fawnoculus.ntm.blocks.node.type.FluidNodeWithValue;
import net.fawnoculus.ntm.util.fluid.FluidStack;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class FluidBE extends BlockEntity implements FluidNodeWithValue {
  private FluidStack fluidStack = new FluidStack().onFinalCommit(this::markDirty);
  private boolean shouldAssignNetwork = true;
  private NodeNetwork network;
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
  public void setFluidStorage(FluidStack fluidStack) {
    this.fluidStack = fluidStack;
  }
  @Override
  public FluidStack getFluidStorage() {
    return this.fluidStack;
  }
  
  @Override
  public void setPriority(long value) {
    this.priority = value;
  }
  
  @Override
  public long getPriority() {
    return this.priority;
  }
  
  @Override
  public void markDirty() {
    super.markDirty();
    if(this.world != null) this.world.updateListeners(this.pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
  }
  
  @Override
  public void markRemoved() {
    super.markRemoved();
    this.onUnload();
  }
  
  @Override
  public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
    return BlockEntityUpdateS2CPacket.create(this);
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
}
