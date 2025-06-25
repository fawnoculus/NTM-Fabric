package net.fawnoculus.ntm.blocks.custom.node.network;

import net.fawnoculus.ntm.blocks.custom.node.Node;
import net.fawnoculus.ntm.blocks.custom.node.NodeType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class NodeNetwork<T> {
  public final UUID ID;
  public final List<Node<T>> LOADED_CONNECTORS = new ArrayList<>();
  public final List<Node<T>> LOADED_CONSUMERS = new ArrayList<>();
  public final List<Node<T>> LOADED_PROVIDERS = new ArrayList<>();
  public final List<Node<T>> LOADED_STORAGES = new ArrayList<>();
  
  public NodeNetwork(){
    this(UUID.randomUUID());
  }
  public NodeNetwork(UUID uuid){
    this.ID = uuid;
  }
  public void addNode(Node<T> node){
    switch (node.getNodeType()){
      case NodeType.Consumer consumer -> LOADED_CONSUMERS.add(node);
      case NodeType.Provider provider -> LOADED_PROVIDERS.add(node);
      case NodeType.Connector connector -> LOADED_CONNECTORS.add(node);
      case NodeType.Storge connector -> LOADED_STORAGES.add(node);
      default -> throw new IllegalArgumentException("Provided node does not have valid type!");
    }
  }
  public void removeNode(Node<T> node){
  }
  public UUID getUUID() {
    return ID;
  }
  public void mergeWithNetwork(@NotNull NodeNetwork<T> network){
    if(network.getUUID() == this.getUUID()) return;
  }
  public void splitNetwork(Node<T> removedNode){
    //TODO: this
  }
  
  @Override
  public boolean equals(Object object) {
    if (object == null || getClass() != object.getClass()) return false;
    NodeNetwork<?> that = (NodeNetwork<?>) object;
    return this.ID.equals(that.ID);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(ID);
  }
  
  abstract void tickNetwork();
  
  @Override
  public String toString() {
    return "NodeNetwork{" +
        "UUID:" + ID + ", " +
        LOADED_CONNECTORS.size() + " Loaded Connectors(s), " +
        LOADED_CONSUMERS.size() + " Loaded Consumer(s), " +
        LOADED_PROVIDERS.size() + " Loaded Providers(s), " +
        LOADED_STORAGES.size() + " Loaded Storages(s)" +
        '}';
  }
}
