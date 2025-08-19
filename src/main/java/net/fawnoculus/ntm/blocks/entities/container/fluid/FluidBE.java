package net.fawnoculus.ntm.blocks.entities.container.fluid;

import net.fawnoculus.ntm.api.node.Node;
import net.fawnoculus.ntm.api.node.network.type.EnergyNetworkType;
import net.fawnoculus.ntm.api.node.network.type.NetworkType;
import net.fawnoculus.ntm.api.node.network.NodeNetwork;
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

public abstract class FluidBE extends BlockEntity implements Node {
  private boolean shouldAssignNetwork = false;
  private NodeNetwork network;

  public FluidBE(BlockEntityType<?> type, BlockPos pos, BlockState state){
    super(type, pos, state);
  }

  @Override
  public NetworkType getNetworkType() {
    return EnergyNetworkType.get();
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
  public boolean canConnectTo(@Nullable Node node) {
    return Node.super.canConnectTo(node);
  }

  @Override
  public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
    NbtCompound nbt = new NbtCompound();
    this.writeNbt(nbt, registries);
    return nbt;
  }

  @Override
  public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
    return BlockEntityUpdateS2CPacket.create(this);
  }

  @Override
  public void setWorld(World world) {
    super.setWorld(world);
    this.onSetWorld();
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
    this.readNodeData(nbt);
  }

  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    super.writeNbt(nbt, registries);
    this.writeNodeData(nbt);
  }
}
