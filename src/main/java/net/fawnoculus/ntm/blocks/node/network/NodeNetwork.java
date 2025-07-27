package net.fawnoculus.ntm.blocks.node.network;

import com.google.common.collect.ImmutableList;
import io.netty.util.collection.LongObjectHashMap;
import io.netty.util.collection.LongObjectMap;
import net.fawnoculus.ntm.blocks.node.Node;
import net.fawnoculus.ntm.blocks.node.NodeProperties;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public abstract class NodeNetwork<T extends NetworkType> {
  public final UUID ID;
  public final HashSet<Node<T>> LOADED_CONNECTORS = new HashSet<>();
  public final HashSet<Node<T>> LOADED_CONSUMERS = new HashSet<>();
  public final HashSet<Node<T>> LOADED_PROVIDERS = new HashSet<>();
  public final HashSet<Node<T>> LOADED_STORAGES = new HashSet<>();
  public final Set<Long> REVERSED_CONSUMER_PRIORITIES = new TreeSet<Long>().reversed();
  public final LongObjectMap<List<Node<T>>> PRIORITISED_CONSUMERS = new LongObjectHashMap<>();
  public final Set<Long> REVERSED_PROVIDER_PRIORITIES = new TreeSet<Long>().reversed();
  public final LongObjectMap<List<Node<T>>> PRIORITISED_PROVIDERS = new LongObjectHashMap<>();
  
  public NodeNetwork(){
    this(UUID.randomUUID());
  }
  public NodeNetwork(UUID uuid){
    this.ID = uuid;
    NodeNetworkManager.addNetwork(this);
  }
  
  public abstract NodeNetwork<T> makeNewNetwork();
  public abstract T getType();
  
  
  public void addNode(@NotNull Node<T> node){
    if(this.containsNode(node)){
      NTM.LOGGER.warn("Added Node {} twice to Network {}", node, this.ID);
    }
    switch (node.getNodeProperties()){
      case NodeProperties.Connector ignored -> LOADED_CONNECTORS.add(node);
      case NodeProperties.Consumer ignored -> LOADED_CONSUMERS.add(node);
      case NodeProperties.Provider ignored -> LOADED_PROVIDERS.add(node);
      case NodeProperties.Storge ignored -> LOADED_STORAGES.add(node);
      default -> NTM.LOGGER.warn("Tired to add Node with Unknown Type ({}) to network {}", node.getNodeProperties().getClass().getName(), this.ID);
    }
    addNodeToSorted(node, node.getNodeProperties());
  }
  
  /**
   * Removes a Node from the Network, if the node is permanently removed & not just unloaded, please use disconnect Node instead!
   * @param node the Node to be removed
   */
  public void removeNode(@NotNull Node<T> node){
    switch (node.getNodeProperties()){
      case NodeProperties.Connector ignored -> LOADED_CONNECTORS.remove(node);
      case NodeProperties.Consumer ignored -> LOADED_CONSUMERS.remove(node);
      case NodeProperties.Provider ignored -> LOADED_PROVIDERS.remove(node);
      case NodeProperties.Storge ignored -> LOADED_STORAGES.remove(node);
      default -> NTM.LOGGER.warn("Tired to remove Node with Unknown Type ({}) from network {}", node.getNodeProperties().getClass().getName(), this.ID);
    }
    removeNodeFromSorted(node, node.getNodeProperties());
  }
  /**
   * removes all nodes from a network, this will cause the network to get removed if no nodes are added back to the network before the next tick
   */
  public void clearNetwork(){
    this.LOADED_CONNECTORS.clear();
    this.LOADED_CONSUMERS.clear();
    this.LOADED_PROVIDERS.clear();
    this.LOADED_STORAGES.clear();
    this.PRIORITISED_CONSUMERS.clear();
    this.PRIORITISED_PROVIDERS.clear();
    this.REVERSED_PROVIDER_PRIORITIES.clear();
    this.REVERSED_CONSUMER_PRIORITIES.clear();
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
  public void disconnectNode(@NotNull Node<T> originNode){
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
  
  /**
   * Called before a Node Changes it's Properties
   */
  public void onNodePropertiesChanged(@NotNull Node<T> node, @Nullable NodeProperties newProperties){
    NodeProperties oldProperties = node.getNodeProperties();
    if(newProperties == null){
      removeNodeFromSorted(node, node.getNodeProperties());
      return;
    }
    if(oldProperties.getClass() != newProperties.getClass()){
      this.removeNode(node);
      switch (newProperties){
        case NodeProperties.Connector ignored -> LOADED_CONNECTORS.add(node);
        case NodeProperties.Consumer ignored -> LOADED_CONSUMERS.add(node);
        case NodeProperties.Provider ignored -> LOADED_PROVIDERS.add(node);
        case NodeProperties.Storge ignored -> LOADED_STORAGES.add(node);
        default -> NTM.LOGGER.warn("Tired to update Node to Unknown Type ({}) could not re-add it to network {}", node.getNodeProperties().getClass().getName(), this.ID);
      }
      addNodeToSorted(node, newProperties);
    }else if(oldProperties.getPriority() != newProperties.getPriority()
        || oldProperties.getStorageMode() != newProperties.getStorageMode()
    ){
      removeNodeFromSorted(node, node.getNodeProperties());
      addNodeToSorted(node, newProperties);
    }
  }
  
  public void addNodeToSorted(Node<T> node, NodeProperties properties){
    boolean isProvider = properties instanceof NodeProperties.Provider
        || (properties instanceof NodeProperties.Storge storge
        && (storge.getStorageMode() == NodeProperties.StorageMode.Provide || storge.getStorageMode() == NodeProperties.StorageMode.Share));
    boolean isConsumer = properties instanceof NodeProperties.Consumer
        || (properties instanceof NodeProperties.Storge storge
        && (storge.getStorageMode() == NodeProperties.StorageMode.Consume || storge.getStorageMode() == NodeProperties.StorageMode.Share));
    if(isConsumer) addNodeToSortedConsumers(node, properties.getPriority());
    if(isProvider) addNodeToSortedProviders(node, properties.getPriority());
  }
  public void addNodeToSortedConsumers(Node<T> node, long priority){
    this.REVERSED_CONSUMER_PRIORITIES.add(priority);
    if(!this.PRIORITISED_CONSUMERS.containsKey(priority)){
      this.PRIORITISED_CONSUMERS.put(priority, new ArrayList<>());
    }
    this.PRIORITISED_CONSUMERS.get(priority).add(node);
  }
  public void addNodeToSortedProviders(Node<T> node, long priority){
    this.REVERSED_PROVIDER_PRIORITIES.add(priority);
    if(!this.PRIORITISED_PROVIDERS.containsKey(priority)){
      this.PRIORITISED_PROVIDERS.put(priority, new ArrayList<>());
    }
    this.PRIORITISED_PROVIDERS.get(priority).add(node);
  }
  
  public void removeNodeFromSorted(Node<T> node, NodeProperties properties){
    boolean isProvider = properties instanceof NodeProperties.Provider
        || (properties instanceof NodeProperties.Storge storge
        && (storge.getStorageMode() == NodeProperties.StorageMode.Provide || storge.getStorageMode() == NodeProperties.StorageMode.Share));
    boolean isConsumer = properties instanceof NodeProperties.Consumer
        || (properties instanceof NodeProperties.Storge storge
        && (storge.getStorageMode() == NodeProperties.StorageMode.Consume || storge.getStorageMode() == NodeProperties.StorageMode.Share));
    if(isConsumer) removeNodeFromSortedConsumers(node, properties.getPriority());
    if(isProvider) removeNodeFromSortedProviders(node, properties.getPriority());
  }
  public void removeNodeFromSortedConsumers(Node<T> node, long priority){
    this.REVERSED_CONSUMER_PRIORITIES.remove(priority);
    List<Node<T>> nodes = this.PRIORITISED_CONSUMERS.get(priority);
    nodes.remove(node);
    if(nodes.isEmpty()) this.PRIORITISED_CONSUMERS.remove(priority);
  }
  public void removeNodeFromSortedProviders(Node<T> node, long priority){
    this.REVERSED_PROVIDER_PRIORITIES.remove(priority);
    List<Node<T>> nodes = this.PRIORITISED_PROVIDERS.get(priority);
    nodes.remove(node);
    if(nodes.isEmpty()) this.PRIORITISED_PROVIDERS.remove(priority);
  }
  
  public void tickNetwork(){
    // Get All Available Energy
    long available = 0;
    for(long priority : REVERSED_PROVIDER_PRIORITIES){
      try{
        for(Node<T> node : PRIORITISED_PROVIDERS.get(priority)){
          available = Math.addExact(available, node.getNodeProperties().getValue());
        }
      }catch (ArithmeticException exception){
        // Break the Loop if we overflow
        // This limits the Throughput of a Network to 9,223,372,036,854,775,807 NTE/t
        // So a Network can at most Transport approximately 9.2 Exa NTE per Tick
        // Technically I could make it capable of transferring infinite amounts of energy with BigInteger, but I didn't feel like it
        available = Long.MAX_VALUE;
        break;
      }
    }
    
    // Add Available Energy to all Consumers
    long toBeDistributed = available;
    for(long priority : REVERSED_CONSUMER_PRIORITIES){
      List<Node<T>> nodes = new ArrayList<>(PRIORITISED_CONSUMERS.get(priority));
      while(toBeDistributed > 0 && !nodes.isEmpty()){
        long energyPerNode = toBeDistributed / nodes.size();
        toBeDistributed %= nodes.size();
        
        List<Node<T>> removedNodes = new ArrayList<>();
        for(Node<T> node : nodes){
          toBeDistributed += node.getNodeProperties().add(energyPerNode);
          if(node.getNodeProperties().getValue() == node.getNodeProperties().getMaxValue()){
            removedNodes.add(node);
          }
        }
        
        nodes.removeAll(removedNodes);
      }
      if(toBeDistributed == 0) break;
    }
    
    // Remove all energy that was consumed
    long toBeRemoved = available - toBeDistributed;
    for(long priority : REVERSED_PROVIDER_PRIORITIES) {
      List<Node<T>> nodes = new ArrayList<>(PRIORITISED_PROVIDERS.get(priority));
      while(toBeRemoved > 0 && !nodes.isEmpty()){
        long energyPerNode = toBeDistributed / nodes.size();
        toBeRemoved %= nodes.size();
        
        List<Node<T>> removedNodes = new ArrayList<>();
        for(Node<T> node : nodes){
          toBeDistributed += node.getNodeProperties().add(energyPerNode);
          if(node.getNodeProperties().getValue() == 0){
            removedNodes.add(node);
          }
        }
        
        nodes.removeAll(removedNodes);
      }
      if(toBeRemoved == 0) break;
    }
  }
  
  
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
