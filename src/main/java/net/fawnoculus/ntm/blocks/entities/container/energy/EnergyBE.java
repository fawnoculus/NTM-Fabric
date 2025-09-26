package net.fawnoculus.ntm.blocks.entities.container.energy;

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
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class EnergyBE extends BlockEntity implements Node {
  private boolean shouldAssignNetwork = false;
  private NodeNetwork network;

  public EnergyBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
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
  public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
    return this.createNbt(registries);
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
  protected void readData(ReadView view) {
    super.readData(view);
    this.readNodeData(view);
  }

  @Override
  protected void writeData(WriteView view) {
    super.writeData(view);
    this.writeNodeData(view);
  }
}
