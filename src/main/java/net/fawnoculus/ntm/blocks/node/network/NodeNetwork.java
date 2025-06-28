package net.fawnoculus.ntm.blocks.node.network;

import net.fawnoculus.ntm.blocks.node.Node;
import net.fawnoculus.ntm.blocks.node.NodeProperties;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.main.NTMConfig;
import net.minecraft.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public abstract class NodeNetwork<T extends BlockEntity> {
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
    NodeNetworkManager.addNetwork(this);
  }
  
  public abstract NodeNetwork<T> makeNewNetwork();
  
  public boolean containsNode(Node<T> node){
    return this.getLoadedComponents().contains(node);
  }
  
  public void addNode(Node<T> node){
    switch (node.getNodeType()){
      case NodeProperties.Connector connector -> LOADED_CONNECTORS.add(node);
      case NodeProperties.Consumer consumer -> LOADED_CONSUMERS.add(node);
      case NodeProperties.Provider provider -> LOADED_PROVIDERS.add(node);
      case NodeProperties.Storge connector -> LOADED_STORAGES.add(node);
      default -> NTM.LOGGER.warn("Tired to add Node with Unknown Type ({}) to network {}", node.getNodeType().getClass().getName(), this.ID);
    }
  }
  public void removeNode(Node<T> node){
    switch (node.getNodeType()){
      case NodeProperties.Connector connector -> LOADED_CONNECTORS.remove(node);
      case NodeProperties.Consumer consumer -> LOADED_CONSUMERS.remove(node);
      case NodeProperties.Provider provider -> LOADED_PROVIDERS.remove(node);
      case NodeProperties.Storge connector -> LOADED_STORAGES.remove(node);
      default -> NTM.LOGGER.warn("Tired to remove Node with Unknown Type ({}) from network {}", node.getNodeType().getClass().getName(), this.ID);
    }
  }
  /**
   * removes all connections from a node & removes the node from the network
   * @param node the Node to me removed
   */
  public final void disconnectNode(Node<T> node){
    if(!this.containsNode(node)){
      NTM.LOGGER.warn("Tired to disconnect Node from a network network it isn't a part of (Network: {})", this.ID);
      return;
    }
    List<Node<T>> initialNodes = node.getConnectedNodes();
    Stack<Node<T>> toBeDisconnectedNodes = new Stack<>();
    for(Node<T> n : initialNodes){
      toBeDisconnectedNodes.push(n);
    }
    
    while(!toBeDisconnectedNodes.isEmpty()){
      Node<T> disconectingNode = toBeDisconnectedNodes.pop();
      
      Set<Node<T>> scannedNodes = new HashSet<>();
      Stack<Node<T>> toBeScanned = new Stack<>();
      NodeNetwork<T> network = toBeDisconnectedNodes.size() == initialNodes.size() ? this : this.makeNewNetwork();
      toBeScanned.push(disconectingNode);
      
      while(!toBeScanned.isEmpty()){
        Node<T> scanningNode = toBeScanned.pop();
        List<Node<T>> connectedNodes = scanningNode.getConnectedNodes();
        
        for(Node<T> connectedNode : connectedNodes){
          if(initialNodes.contains(connectedNode)) continue;
          if(scannedNodes.contains(connectedNode)) continue;
          
          scannedNodes.add(connectedNode);
          network.addNode(connectedNode);
          if(toBeScanned.size() > NTMConfig.MaxNodeScanDepth.getValue() && NTMConfig.MaxNodeScanDepth.getValue() > 0){
            NTM.LOGGER.warn("Exceeded Max Node Scan Depth of {} at {} in {} while Removing Node at {} from Network {}",
                NTMConfig.MaxNodeScanDepth.getValue(),
                connectedNode.getPos().toShortString(),
                connectedNode.getWorld().getRegistryKey(),
                node.getPos().toShortString(),
                this.ID
            );
            continue;
          }
          toBeScanned.push(connectedNode);
        }
      }
    }
    
    this.removeNode(node);
    node.setNetwork(null);
  }
  
  /**
   * removes the connection between multiple nodes, will only remove them from the network if necessary
   * @param providedNodes the nodes whose connection with each other will be severed
   */
  public final void disconnectNodes(Collection<Node<T>> providedNodes){
    Stack<Node<T>> toBeDisconnectedNodes = new Stack<>();
    for(Node<T> node : providedNodes){
      if(!this.containsNode(node)){
        NTM.LOGGER.warn("Tired to disconnect {} Node(s) from each other, but they are not part of network {}", providedNodes.size(), this.ID);
        return;
      }
      toBeDisconnectedNodes.push(node);
    }
    
    while(!toBeDisconnectedNodes.isEmpty()){
      Node<T> disconectingNode = toBeDisconnectedNodes.pop();
      
      Set<Node<T>> scannedNodes = new HashSet<>();
      Stack<Node<T>> toBeScanned = new Stack<>();
      NodeNetwork<T> network = toBeDisconnectedNodes.size() == providedNodes.size() ? this : this.makeNewNetwork();
      toBeScanned.push(disconectingNode);
      
      while(!toBeScanned.isEmpty()){
        Node<T> scanningNode = toBeScanned.pop();
        List<Node<T>> connectedNodes = scanningNode.getConnectedNodes();
        
        for(Node<T> connectedNode : connectedNodes){
          if(providedNodes.contains(connectedNode)) continue;
          if(scannedNodes.contains(connectedNode)) continue;
          
          scannedNodes.add(connectedNode);
          network.addNode(connectedNode);
          if(toBeScanned.size() > NTMConfig.MaxNodeScanDepth.getValue() && NTMConfig.MaxNodeScanDepth.getValue() > 0){
            NTM.LOGGER.warn("Exceeded Max Node Scan Depth of {} at {} in {} while Splitting Connections Between {} Nodes",
                NTMConfig.MaxNodeScanDepth.getValue(),
                connectedNode.getPos().toShortString(),
                connectedNode.getWorld().getRegistryKey(),
                providedNodes.size()
            );
            continue;
          }
          toBeScanned.push(connectedNode);
        }
      }
    }
  }
  public void mergeNetworksAt(@NotNull Node<T> addedNode){
    Stack<Node<T>> toBeScanned = new Stack<>();
    Set<Node<T>> scannedNodes = new HashSet<>();
    
    toBeScanned.push(addedNode);
    
    while(!toBeScanned.isEmpty()){
      Node<T> scaningNode = toBeScanned.pop();
      
      for(Node<T> connectedNode : scaningNode.getConnectedNodes()){
        if(scannedNodes.contains(connectedNode)) continue;
        if(connectedNode.getNetwork().equals(this)) continue;
        
        connectedNode.setNetwork(this);
        this.addNode(connectedNode);
        
        if(toBeScanned.size() > NTMConfig.MaxNodeScanDepth.getValue() && NTMConfig.MaxNodeScanDepth.getValue() > 0){
          NTM.LOGGER.warn("Exceeded Max Node Scan Depth of {} while Connecting Network {} from {} to {} in {}",
              NTMConfig.MaxNodeScanDepth.getValue(),
              this.ID,
              connectedNode.getPos().toShortString(),
              addedNode.getPos().toShortString(),
              addedNode.getWorld().getRegistryKey()
          );
          continue;
        }
        toBeScanned.push(connectedNode);
      }
      
      scannedNodes.add(scaningNode);
    }
  }
  
  public List<Node<T>> getLoadedComponents(){
    List<Node<T>> nodes = new ArrayList<>();
    nodes.addAll(this.LOADED_CONNECTORS);
    nodes.addAll(this.LOADED_PROVIDERS);
    nodes.addAll(this.LOADED_CONSUMERS);
    nodes.addAll(this.LOADED_STORAGES);
    return nodes;
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
  
  public abstract void tickNetwork();
  
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
