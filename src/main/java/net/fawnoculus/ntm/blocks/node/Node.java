package net.fawnoculus.ntm.blocks.node;

import net.fawnoculus.ntm.blocks.node.network.NetworkType;
import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
import net.fawnoculus.ntm.NTM;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A Node serves as the base Part of a Node-Network.
 * It can be a connector, provider, consumer or storage for a specific integer based value (Energy/Fluid)
 */
public interface Node<T extends NetworkType>  {
  default Node<T> getNode(){
    return this;
  }
  
  void setShouldAssignNetwork(boolean value);
  boolean shouldAssignNetwork();
  
  void setNetwork(NodeNetwork<T> network);
  @Nullable NodeNetwork<T> getNetwork();
  NodeNetwork<T> makeNewNetwork();
  
  default List<Node<T>> getConnectedNodes(){
    World world = this.getWorld();
    assert world != null;
    BlockPos pos = this.getPos();
    List<Node<T>> nodes = new ArrayList<>();
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
      NodeNetwork<T> detectedNetwork = null;
      for (Node<T> connectedNode : this.getConnectedNodes()) {
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
  
  default NodeNetwork<T> findNetwork(Node<T> node, NodeNetwork<T> detectedNetwork){
    NodeNetwork<T> foundNetwork;
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
  
  @SuppressWarnings("unchecked")
  default List<Node<T>> checkForNode(Object object){
    List<Object> toBeChecked = new ArrayList<>();
    toBeChecked.add(object);
    if(object instanceof MultiNode multiNode){
      toBeChecked.addAll(multiNode.getNodes());
    }
    
    List<Node<T>> nodes = new ArrayList<>();
    for(Object o : toBeChecked){
      try{
        Node<T> node = (Node<T>) o;
        Objects.requireNonNull(node);
        nodes.add(node);
      }catch (ClassCastException | NullPointerException ignored){}
    }
    return nodes;
  }
  
  void setNodeProperties(NodeProperties nodeProperties);
  NodeProperties getNodeProperties();
  
  BlockPos getPos();
  World getWorld();
  
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
