package net.fawnoculus.ntm.api.node;

import net.fawnoculus.ntm.api.node.network.type.NetworkType;
import net.fawnoculus.ntm.api.node.network.NodeNetwork;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.util.ExceptionUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * A Node serves as the base Part of a Node-Network.
 */
public interface Node {
  NetworkType getNetworkType();

  void setShouldAssignNetwork(boolean value);

  boolean shouldAssignNetwork();

  Collection<NodeValueContainer> getContainers();

  void setNetwork(NodeNetwork network);

  @Nullable NodeNetwork getNetwork();

  BlockPos getPos();

  World getWorld();

  /**
   * this can be overwritten to allow a node to connect to things that are not directly next to itself
   *
   * @return a List of all Nodes this Node is connected to
   */
  default List<Node> getConnectedNodes() {
    World world = this.getWorld();
    assert world != null;
    BlockPos pos = this.getPos();
    List<Node> nodes = new ArrayList<>();
    nodes.addAll(this.checkForNode(world.getBlockEntity(pos.up())));
    nodes.addAll(this.checkForNode(world.getBlockEntity(pos.down())));
    nodes.addAll(this.checkForNode(world.getBlockEntity(pos.north())));
    nodes.addAll(this.checkForNode(world.getBlockEntity(pos.east())));
    nodes.addAll(this.checkForNode(world.getBlockEntity(pos.south())));
    nodes.addAll(this.checkForNode(world.getBlockEntity(pos.west())));
    return nodes;
  }

  default void assignNetwork() {
    if (!this.shouldAssignNetwork()) return;
    try {
      NodeNetwork detectedNetwork = null;
      for (Node connectedNode : this.getConnectedNodes()) {
        detectedNetwork = this.findNetwork(connectedNode, detectedNetwork);
      }
      if (detectedNetwork == null) {
        detectedNetwork = this.getNetworkType().makeNewNetwork();
      }
      if (!detectedNetwork.LOADED_NODES.contains(this)) {
        detectedNetwork.addNode(this);
      }

      this.setNetwork(detectedNetwork);
    } catch (Throwable throwable) {
      NTM.LOGGER.error("Failed assigning Network to Node at {}\nException: {}", this.getPos().toShortString(), ExceptionUtil.makePretty(throwable));
    }
  }

  default NodeNetwork findNetwork(Node node, NodeNetwork detectedNetwork) {
    try {
      NodeNetwork foundNetwork = Objects.requireNonNull(node.getNetwork());

      if (detectedNetwork != null && !foundNetwork.equals(detectedNetwork)) {
        detectedNetwork.mergeWith(foundNetwork);
        return detectedNetwork;
      }

      return foundNetwork;
    } catch (Exception ignored) {
      return detectedNetwork;
    }
  }

  default List<Node> checkForNode(Object object) {
    List<Object> toBeChecked = new ArrayList<>();
    toBeChecked.add(object);
    if (object instanceof MultiNode multiNode) {
      toBeChecked.addAll(multiNode.getNodes());
    }

    List<Node> nodes = new ArrayList<>();
    for (Object o : toBeChecked) {
      try {
        Node node = (Node) o;
        if (this.canConnectTo(node)) {
          nodes.add(node);
        }
      } catch (ClassCastException ignored) {
      }
    }
    return nodes;
  }

  default boolean canConnectTo(@Nullable Node node) {
    if (node == null) return false;
    return node.getNetworkType() == this.getNetworkType();
  }

  default void readNodeData(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    try {
      UUID uuid = UUID.fromString(nbt.getString("network", null));
      NodeNetwork network = this.getNetworkType().getNetwork(uuid);
      this.setNetwork(network);
      if (!network.containsNode(this)) {
        network.addNode(this);
      }
    } catch (IllegalArgumentException | NullPointerException ignored) {
    }
  }

  default void writeNodeData(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    if (this.getNetwork() != null) {
      nbt.putString("network", this.getNetwork().ID.toString());
    }
  }

  default void onSetWorld() {
    this.setShouldAssignNetwork(true);
    if(this.getWorld().isClient){
      return;
    }
    if(this.getNetwork() == null){
      this.assignNetwork();
    }
  }

  default void onBreak() {
    if (this.getConnectedNodes().size() > 1 && this.getNetwork() != null) {
      this.getNetwork().disconnectNode(this);
    }
  }

  default void onUnload() {
    setShouldAssignNetwork(false);

    if (this.getNetwork() != null) {
      this.getNetwork().removeNode(this);
    }

    this.setNetwork(null);
  }
}
