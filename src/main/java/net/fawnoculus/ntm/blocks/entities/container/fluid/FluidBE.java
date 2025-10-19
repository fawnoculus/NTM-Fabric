package net.fawnoculus.ntm.blocks.entities.container.fluid;

import net.fawnoculus.ntm.api.node.Node;
import net.fawnoculus.ntm.api.node.NodeValueContainer;
import net.fawnoculus.ntm.api.node.network.NetworkType;
import net.fawnoculus.ntm.api.node.network.NetworkTypes;
import net.fawnoculus.ntm.api.node.network.NodeNetwork;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public abstract class FluidBE extends BlockEntity implements Node {
  private boolean shouldAssignNetwork = false;
  private NodeNetwork network;

  public FluidBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
    super(type, pos, state);
  }

  public static @NotNull Fluid getNetworkFluid(@NotNull NodeNetwork network) {
    for (Node node : network.LOADED_NODES) {
      if (node instanceof FluidBE fluidNode
        && fluidNode.getNodeFluid() != null
      ) {
        return fluidNode.getNodeFluid();
      }
    }

    return Fluids.EMPTY;
  }

  /**
   * May return Null if the Node Contains Multiple Fluid Types
   *
   * @return Which type of Fluid this node transports / Contains
   */
  public abstract @Nullable Fluid getNodeFluid();

  /**
   * Get the containers in this Node based on the type of Fluid it is trying to get
   *
   * @param fluid the type of fluid
   * @return the containers in this node based on the fluid
   */
  public abstract Collection<NodeValueContainer> getContainers(Fluid fluid);


  @Override
  public Collection<NodeValueContainer> getContainers() {
    if (this.getNetwork() == null) {
      return List.of();
    }

    return this.getContainers(getNetworkFluid(this.getNetwork()));
  }

  @Override
  public NetworkType getNetworkType() {
    return NetworkTypes.FLUID;
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
    this.readNodeData(view);
    super.readData(view);
  }

  @Override
  protected void writeData(WriteView view) {
    super.writeData(view);
    this.writeNodeData(view);
  }
}
