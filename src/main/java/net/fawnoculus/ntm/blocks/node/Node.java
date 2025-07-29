package net.fawnoculus.ntm.blocks.node;

import net.fawnoculus.ntm.blocks.node.network.NetworkType;
import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
import net.fawnoculus.ntm.NTM;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.MutableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * A Node serves as the base Part of a Node-Network.
 */
public interface Node {
  MutableText getNodeType();
  NetworkType getNetworkType();
  
  void setShouldAssignNetwork(boolean value);
  boolean shouldAssignNetwork();
  
  void setNetwork(NodeNetwork network);
  @Nullable NodeNetwork getNetwork();
  
  BlockPos getPos();
  World getWorld();
  
  default Node getNode(){
    return this;
  }
  
  default NodeNetwork makeNewNetwork(){
    return this.getNetworkType().makeNewNetwork();
  }
  
  /**
   * this can be overwritten to allow a node to connect to things that are not directly next to itself
   * @return a List of all Nodes this Node is connected to
   */
  default List<Node> getConnectedNodes(){
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
        detectedNetwork = this.makeNewNetwork();
      }
      if (!detectedNetwork.containsNode(this)) {
        detectedNetwork.addNode(this);
      }
      
      this.setNetwork(detectedNetwork);
    } catch (Throwable e) {
      StringBuilder Exception = new StringBuilder(e.toString());
      for (StackTraceElement element : e.getStackTrace()) {
        Exception.append("\n\t").append(element.toString());
      }
      NTM.LOGGER.error("Failed assigning Network to Node at {}\nException: {}", this.getPos().toShortString(), Exception);
    }
  }
  
  default NodeNetwork findNetwork(Node node, NodeNetwork detectedNetwork){
    NodeNetwork foundNetwork;
    try{
      foundNetwork = Objects.requireNonNull(
          Objects.requireNonNull(node).getNetwork()
      );
    }catch (Exception ignored){
      return detectedNetwork;
    }
    
    if(detectedNetwork != null && !foundNetwork.equals(detectedNetwork)) {
      detectedNetwork.mergeNetworksAt(this);
      return detectedNetwork;
    }
    
    return foundNetwork;
  }
  
  default List<Node> checkForNode(Object object){
    List<Object> toBeChecked = new ArrayList<>();
    toBeChecked.add(object);
    if(object instanceof MultiNode multiNode){
      toBeChecked.addAll(multiNode.getNodes());
    }
    
    List<Node> nodes = new ArrayList<>();
    for(Object o : toBeChecked){
      try{
        Node node = (Node) o;
        if(this.canConnectTo(node)){
          nodes.add(node);
        }
      }catch (ClassCastException ignored){}
    }
    return nodes;
  }
  
  default boolean canConnectTo(@Nullable Node node){
    if(node == null) return false;
    return node.getNetworkType().sameAs(this.getNetworkType());
  }
  
  default void readNodeData(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    UUID uuid = null;
    try {
      uuid = UUID.fromString(nbt.getString("network", null));
    } catch (IllegalArgumentException | NullPointerException ignored) {}
    if (uuid != null) {
      NodeNetwork network = this.getNetworkType().getNetwork(uuid);
      this.setNetwork(network);
      if (!network.containsNode(this)) {
        network.addNode(this);
      }
    }
  }
  default void writeNodeData(NbtCompound nbt, RegistryWrapper.WrapperLookup registries){
    if(this.getNetwork() != null){
      nbt.putString("network", this.getNetwork().ID.toString());
    }
  }
  
  default void onBreak(){
    if(this.getConnectedNodes().size() > 1 && this.getNetwork() != null){
      this.getNetwork().disconnectNode(this);
    }
    // the Node is unloaded after being broken, so there is no need to unset the Network here
  }
  default void onUnload(){
    setShouldAssignNetwork(false);
    
    if(this.getNetwork() != null){
      this.getNetwork().removeNode(this);
    }
    
    this.setNetwork(null);
  }
}
