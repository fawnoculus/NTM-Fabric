package net.fawnoculus.ntm.blocks.node.network;

import com.google.common.collect.ImmutableList;
import net.fawnoculus.ntm.blocks.node.Node;
import net.fawnoculus.ntm.blocks.node.NodeProperties;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.main.NTMConfig;
import net.minecraft.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public abstract class NodeNetwork<T extends NetworkType> {
  public final UUID ID;
  public final HashSet<Node<T>> LOADED_CONNECTORS = new HashSet<>();
  public final HashSet<Node<T>> LOADED_CONSUMERS = new HashSet<>();
  public final HashSet<Node<T>> LOADED_PROVIDERS = new HashSet<>();
  public final HashSet<Node<T>> LOADED_STORAGES = new HashSet<>();
  
  public NodeNetwork(){
    this(UUID.randomUUID());
  }
  public NodeNetwork(UUID uuid){
    this.ID = uuid;
    NodeNetworkManager.addNetwork(this);
  }
  
  public abstract NodeNetwork<T> makeNewNetwork();
  
  
  public void addNode(Node<T> node){
    switch (node.getNodeProperties()){
      case NodeProperties.Connector ignored -> LOADED_CONNECTORS.add(node);
      case NodeProperties.Consumer ignored -> LOADED_CONSUMERS.add(node);
      case NodeProperties.Provider ignored -> LOADED_PROVIDERS.add(node);
      case NodeProperties.Storge ignored -> LOADED_STORAGES.add(node);
      default -> NTM.LOGGER.warn("Tired to add Node with Unknown Type ({}) to network {}", node.getNodeProperties().getClass().getName(), this.ID);
    }
  }
  public void removeNode(Node<T> node){
    switch (node.getNodeProperties()){
      case NodeProperties.Connector ignored -> LOADED_CONNECTORS.remove(node);
      case NodeProperties.Consumer ignored -> LOADED_CONSUMERS.remove(node);
      case NodeProperties.Provider ignored -> LOADED_PROVIDERS.remove(node);
      case NodeProperties.Storge ignored -> LOADED_STORAGES.remove(node);
      default -> NTM.LOGGER.warn("Tired to remove Node with Unknown Type ({}) from network {}", node.getNodeProperties().getClass().getName(), this.ID);
    }
  }
  
  /**
   * removes all nodes from a network, this will cause the network to get removed if no nodes are added back to the network before the next tick
   */
  public void clearNetwork(){
    this.LOADED_CONNECTORS.clear();
    this.LOADED_CONSUMERS.clear();
    this.LOADED_PROVIDERS.clear();
    this.LOADED_STORAGES.clear();
  }
  
  /**
   * checks if a network is empty, if this is true the network will be removed in the next tick
   * @return if the network is empty or not
   */
  public boolean isEmpty(){
    return this.LOADED_CONNECTORS.isEmpty()
        && this.LOADED_PROVIDERS.isEmpty()
        && this.LOADED_CONSUMERS.isEmpty()
        && this.LOADED_STORAGES.isEmpty();
  }
  
  /**
   * Checks if the network contains a specific node
   * @param node the node to be checked
   * @return whether the network contains the node
   */
  public boolean containsNode(Node<T> node){
    return LOADED_CONNECTORS.contains(node)
        || LOADED_CONSUMERS.contains(node)
        || LOADED_PROVIDERS.contains(node)
        || LOADED_STORAGES.contains(node);
  }
  /**
   * removes all connections from a node & removes the node from the network
   * @param originNode the Node to me removed
   */
  public void disconnectNode(Node<T> originNode){
    this.clearNetwork();
    
    final ImmutableList<Node<T>> disconnectedNodeList = ImmutableList.copyOf(originNode.getConnectedNodes());
    Stack<Node<T>> disconnectedNodes = new Stack<>();
    for(Node<T> disconectedNode : disconnectedNodeList){
      disconnectedNodes.push(disconectedNode);
    }
    
    HashSet<Node<T>> alreadyScannedNodes = new HashSet<>();
    alreadyScannedNodes.add(originNode);
    
    boolean isFirst = true;
    
    while(!disconnectedNodes.isEmpty()){
      Node<T> disconectedNode = disconnectedNodes.pop();
      
      NodeNetwork<T> assignedNetwork = isFirst ? this : this.makeNewNetwork();
      isFirst = false;
      
      Stack<Node<T>> toBeScannedNodes = new Stack<>();
      toBeScannedNodes.push(disconectedNode);
      
      alreadyScannedNodes.add(disconectedNode);
      disconectedNode.setNetwork(assignedNetwork);
      assignedNetwork.addNode(disconectedNode);
      
      while(!toBeScannedNodes.isEmpty()){
        Node<T> scannedNode = toBeScannedNodes.pop();
        
        for(Node<T> node : scannedNode.getConnectedNodes()){
          if(alreadyScannedNodes.contains(node)) continue;
          if(disconnectedNodeList.contains(node)) {
            disconnectedNodes.remove(node);
          }
          
          alreadyScannedNodes.add(node);
          node.setNetwork(assignedNetwork);
          assignedNetwork.addNode(node);
          
          if(toBeScannedNodes.size() > NTMConfig.MaxNodeScanDepth.getValue() && NTMConfig.MaxNodeScanDepth.getValue() > 0) {
            NTM.LOGGER.warn("Exceeded Max Node Scan Depth of {} at {} in {} while Removing Node at {} from Network {}",
                NTMConfig.MaxNodeScanDepth.getValue(),
                node.getPos().toShortString(),
                node.getWorld().getRegistryKey(),
                originNode.getPos().toShortString(),
                this.ID
            );
            continue;
          }
          toBeScannedNodes.push(node);
        }
      }
    }
  }
  
  /**
   * removes the connection between multiple nodes, will only remove them from the network if necessary
   * @param providedNodes the nodes whose connection with each other will be severed
   */
  public void disconnectNodes(Collection<Node<T>> providedNodes){
    this.clearNetwork();
    
    final ImmutableList<Node<T>> disconnectedNodeList = ImmutableList.copyOf(providedNodes);
    Stack<Node<T>> disconnectedNodes = new Stack<>();
    for(Node<T> disconectedNode : disconnectedNodeList){
      disconnectedNodes.push(disconectedNode);
    }
    
    HashSet<Node<T>> alreadyScannedNodes = new HashSet<>();
    
    boolean isFirst = true;
    
    while(!disconnectedNodes.isEmpty()){
      Node<T> disconectedNode = disconnectedNodes.pop();
      
      NodeNetwork<T> assignedNetwork = isFirst ? this : this.makeNewNetwork();
      isFirst = false;
      
      Stack<Node<T>> toBeScannedNodes = new Stack<>();
      toBeScannedNodes.push(disconectedNode);
      
      alreadyScannedNodes.add(disconectedNode);
      disconectedNode.setNetwork(assignedNetwork);
      assignedNetwork.addNode(disconectedNode);
      
      while(!toBeScannedNodes.isEmpty()){
        Node<T> scannedNode = toBeScannedNodes.pop();
        
        for(Node<T> node : scannedNode.getConnectedNodes()){
          if(alreadyScannedNodes.contains(node)) continue;
          if(disconnectedNodeList.contains(node)) {
            disconnectedNodes.remove(node);
          }
          
          alreadyScannedNodes.add(node);
          node.setNetwork(assignedNetwork);
          assignedNetwork.addNode(node);
          
          if(toBeScannedNodes.size() > NTMConfig.MaxNodeScanDepth.getValue() && NTMConfig.MaxNodeScanDepth.getValue() > 0) {
            NTM.LOGGER.warn("Exceeded Max Node Scan Depth of {} at {} in {} while severing Connections Between {} Nodes in Network {}",
                NTMConfig.MaxNodeScanDepth.getValue(),
                node.getPos().toShortString(),
                node.getWorld().getRegistryKey(),
                providedNodes.size(),
                this.ID
            );
            continue;
          }
          toBeScannedNodes.push(node);
        }
      }
    }
  }
  
  /**
   * Merges Multiple Networks when a Node is added which ends up connecting multiple Networks
   * @param originNode the Node that was added
   */
  public void mergeNetworksAt(@NotNull Node<T> originNode){
    Stack<Node<T>> toBeScanned = new Stack<>();
    Set<Node<T>> scannedNodes = new HashSet<>();
    
    toBeScanned.push(originNode);
    
    while(!toBeScanned.isEmpty()){
      Node<T> scaningNode = toBeScanned.pop();
      
      for(Node<T> connectedNode : scaningNode.getConnectedNodes()){
        if(scannedNodes.contains(connectedNode)) continue;
        if(connectedNode.getNetwork() == null) continue;
        if(connectedNode.getNetwork().equals(this)) continue;
        
        connectedNode.setNetwork(this);
        this.addNode(connectedNode);
        
        if(toBeScanned.size() > NTMConfig.MaxNodeScanDepth.getValue() && NTMConfig.MaxNodeScanDepth.getValue() > 0){
          NTM.LOGGER.warn("Exceeded Max Node Scan Depth of {} while Connecting Network {} from {} to {} in {}",
              NTMConfig.MaxNodeScanDepth.getValue(),
              this.ID,
              connectedNode.getPos().toShortString(),
              originNode.getPos().toShortString(),
              originNode.getWorld().getRegistryKey()
          );
          continue;
        }
        toBeScanned.push(connectedNode);
      }
      
      scannedNodes.add(scaningNode);
    }
  }
  
  public abstract void tickNetwork();
  
  
  @Override
  public boolean equals(Object object) {
    if (object == null || getClass() != object.getClass()) return false;
    NodeNetwork<?> that = (NodeNetwork<?>) object;
    return this.ID.equals(that.ID);
  }
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
