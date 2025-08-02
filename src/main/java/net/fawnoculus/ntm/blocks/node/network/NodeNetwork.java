package net.fawnoculus.ntm.blocks.node.network;

import com.google.common.collect.ImmutableList;
import io.netty.util.collection.LongObjectHashMap;
import io.netty.util.collection.LongObjectMap;
import net.fawnoculus.ntm.blocks.node.*;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.blocks.node.type.ConnectorNode;
import net.fawnoculus.ntm.blocks.node.type.ConsumerNode;
import net.fawnoculus.ntm.blocks.node.type.ProviderNode;
import net.fawnoculus.ntm.blocks.node.type.StorageNode;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public abstract class NodeNetwork {
  public final UUID ID;
  public final HashSet<ConnectorNode> LOADED_CONNECTORS = new HashSet<>();
  public final HashSet<ConsumerNode> LOADED_CONSUMERS = new HashSet<>();
  public final HashSet<ProviderNode> LOADED_PROVIDERS = new HashSet<>();
  public final HashSet<StorageNode> LOADED_STORAGES = new HashSet<>();
  public final Set<Long> REVERSED_CONSUMER_PRIORITIES = new TreeSet<Long>().reversed();
  public final LongObjectMap<List<NodeWithValue>> PRIORITISED_CONSUMERS = new LongObjectHashMap<>();
  public final Set<Long> REVERSED_PROVIDER_PRIORITIES = new TreeSet<Long>().reversed();
  public final LongObjectMap<List<NodeWithValue>> PRIORITISED_PROVIDERS = new LongObjectHashMap<>();
  
  public NodeNetwork(){
    this(UUID.randomUUID());
  }
  public NodeNetwork(UUID uuid){
    this.ID = uuid;
    NodeNetworkManager.addNetwork(this);
  }
  
  public abstract NodeNetwork makeNewNetwork();
  public abstract NetworkType getType();
  
  
  public void addNode(@NotNull Node node){
    if(this.containsNode(node)){
      NTM.LOGGER.warn("Added Node {} twice to Network {}", node, this.ID);
    }
    switch (node){
      case ConnectorNode connectorNode -> LOADED_CONNECTORS.add(connectorNode);
      case ConsumerNode consumerNode -> LOADED_CONSUMERS.add(consumerNode);
      case ProviderNode providerNode -> LOADED_PROVIDERS.add(providerNode);
      case StorageNode storageNode -> LOADED_STORAGES.add(storageNode);
      default -> NTM.LOGGER.warn("Tired to add Node with Unknown Type ({}) to network {}", node.getClass().getName(), this.ID);
    }
    if(node instanceof NodeWithValue nodeWithValue){
      addNodeToSorted(nodeWithValue);
    }
  }
  
  /**
   * Removes a Node from the Network, if the node is permanently removed & not just unloaded, please use disconnect Node instead!
   * @param node the Node to be removed
   */
  public void removeNode(@NotNull Node node){
    switch (node){
      case ConnectorNode connectorNode -> LOADED_CONNECTORS.remove(connectorNode);
      case ConsumerNode consumerNode -> LOADED_CONSUMERS.remove(consumerNode);
      case ProviderNode providerNode -> LOADED_PROVIDERS.remove(providerNode);
      case StorageNode storageNode -> LOADED_STORAGES.remove(storageNode);
      default -> NTM.LOGGER.warn("Tired to remove Node of Unknown Type ({}) from network {}", node.getClass().getName(), this.ID);
    }
    if(node instanceof NodeWithValue nodeWithValue){
      removeNodeFromSorted(nodeWithValue);
    }
  }
  /**
   * Removes all data from a network, this will cause the network to get removed if no nodes are added back to the network before the next tick
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
  public boolean containsNode(@NotNull Node node){
    return switch (node){
      case ConnectorNode connectorNode -> LOADED_CONNECTORS.contains(connectorNode);
      case ConsumerNode consumerNode -> LOADED_CONSUMERS.contains(consumerNode);
      case ProviderNode providerNode -> LOADED_PROVIDERS.contains(providerNode);
      case StorageNode storageNode -> LOADED_STORAGES.contains(storageNode);
      default -> false;
    };
  }
  /**
   * removes all connections from a node & removes the node from the network
   * @param originNode the Node to me removed
   */
  public void disconnectNode(@NotNull Node originNode){
    this.clearNetwork();
    
    final ImmutableList<Node> disconnectedNodeList = ImmutableList.copyOf(originNode.getConnectedNodes());
    Stack<Node> disconnectedNodes = new Stack<>();
    for(Node disconectedNode : disconnectedNodeList){
      disconnectedNodes.push(disconectedNode);
    }
    
    HashSet<Node> alreadyScannedNodes = new HashSet<>();
    alreadyScannedNodes.add(originNode);
    
    boolean isFirst = true;
    
    while(!disconnectedNodes.isEmpty()){
      Node disconectedNode = disconnectedNodes.pop();
      
      NodeNetwork assignedNetwork = isFirst ? this : this.makeNewNetwork();
      isFirst = false;
      
      Stack<Node> toBeScannedNodes = new Stack<>();
      toBeScannedNodes.push(disconectedNode);
      
      alreadyScannedNodes.add(disconectedNode);
      disconectedNode.setNetwork(assignedNetwork);
      assignedNetwork.addNode(disconectedNode);
      
      while(!toBeScannedNodes.isEmpty()){
        Node scannedNode = toBeScannedNodes.pop();
        
        for(Node node : scannedNode.getConnectedNodes()){
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
  public void disconnectNodes(Collection<Node> providedNodes){
    this.clearNetwork();
    
    final ImmutableList<Node> disconnectedNodeList = ImmutableList.copyOf(providedNodes);
    Stack<Node> disconnectedNodes = new Stack<>();
    for(Node disconectedNode : disconnectedNodeList){
      disconnectedNodes.push(disconectedNode);
    }
    
    HashSet<Node> alreadyScannedNodes = new HashSet<>();
    
    boolean isFirst = true;
    
    while(!disconnectedNodes.isEmpty()){
      Node disconectedNode = disconnectedNodes.pop();
      
      NodeNetwork assignedNetwork = isFirst ? this : this.makeNewNetwork();
      isFirst = false;
      
      Stack<Node> toBeScannedNodes = new Stack<>();
      toBeScannedNodes.push(disconectedNode);
      
      alreadyScannedNodes.add(disconectedNode);
      disconectedNode.setNetwork(assignedNetwork);
      assignedNetwork.addNode(disconectedNode);
      
      while(!toBeScannedNodes.isEmpty()){
        Node scannedNode = toBeScannedNodes.pop();
        
        for(Node node : scannedNode.getConnectedNodes()){
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
  public void mergeNetworksAt(@NotNull Node originNode){
    Stack<Node> toBeScanned = new Stack<>();
    Set<Node> scannedNodes = new HashSet<>();
    
    toBeScanned.push(originNode);
    
    while(!toBeScanned.isEmpty()){
      Node scaningNode = toBeScanned.pop();
      
      for(Node connectedNode : scaningNode.getConnectedNodes()){
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
   * Called before a Storage Node changes it Priority
   */
  public void onPriorityChange(@NotNull NodeWithValue node, long newPriority){
    long oldPriority = node.getPriority();
    if(oldPriority == newPriority) return;
    if(node.provides()) removeNodeFromSortedProviders(node, node.getPriority());
    if(node.consumes()) removeNodeFromSortedConsumers(node, node.getPriority());
    if(node.provides()) addNodeToSortedProviders(node, newPriority);
    if(node.consumes()) addNodeToSortedConsumers(node, newPriority);
  }
  /**
   * Called before a Storage Node changes it Mode
   */
  public void onStorageModeChange(@NotNull StorageNode node, StorageNode.StorageMode newMode){
    StorageNode.StorageMode oldMode = node.getStorageMode();
    if(oldMode == newMode) return;
    if(oldMode.provides) removeNodeFromSortedProviders(node, node.getPriority());
    if(oldMode.consumes) removeNodeFromSortedConsumers(node, node.getPriority());
    if(newMode.provides) addNodeToSortedProviders(node, node.getPriority());
    if(newMode.consumes) addNodeToSortedConsumers(node, node.getPriority());
  }
  
  public @NotNull List<NodeWithValue> getProviders(long priority){
    List<NodeWithValue> nodes = PRIORITISED_PROVIDERS.get(priority);
    if(nodes == null){
      nodes = new ArrayList<>();
      PRIORITISED_PROVIDERS.put(priority, nodes);
      REVERSED_PROVIDER_PRIORITIES.add(priority);
    }
    return nodes;
  }
  public @NotNull List<NodeWithValue> getConsumers(long priority){
    List<NodeWithValue> nodes = PRIORITISED_CONSUMERS.get(priority);
    if(nodes == null){
      nodes = new ArrayList<>();
      PRIORITISED_CONSUMERS.put(priority, nodes);
      REVERSED_CONSUMER_PRIORITIES.add(priority);
    }
    return nodes;
  }
  
  public void addNodeToSorted(NodeWithValue node){
    if(node.provides()){
      addNodeToSortedProviders(node, node.getPriority());
    }
    if(node.consumes()){
      addNodeToSortedConsumers(node, node.getPriority());
    }
  }
  public void addNodeToSortedConsumers(NodeWithValue node, long priority){
    this.getConsumers(priority).add(node);
  }
  public void addNodeToSortedProviders(NodeWithValue node, long priority){
    this.getProviders(priority).add(node);
  }
  
  public void removeNodeFromSorted(NodeWithValue node){
    if(node.provides()){
      removeNodeFromSortedProviders(node, node.getPriority());
    }
    if(node.consumes()){
      removeNodeFromSortedConsumers(node, node.getPriority());
    }
  }
  public void removeNodeFromSortedConsumers(NodeWithValue node, long priority){
    List<NodeWithValue> nodes = this.getConsumers(priority);
    nodes.remove(node);
    if(nodes.isEmpty()) {
      this.PRIORITISED_CONSUMERS.remove(priority);
      this.REVERSED_CONSUMER_PRIORITIES.remove(priority);
    }
  }
  public void removeNodeFromSortedProviders(NodeWithValue node, long priority){
    List<NodeWithValue> nodes = this.getProviders(priority);
    nodes.remove(node);
    if(nodes.isEmpty()) {
      this.PRIORITISED_PROVIDERS.remove(priority);
      this.REVERSED_PROVIDER_PRIORITIES.remove(priority);
    }
  }
  
  public void tickNetwork(){
    // Get All Available Energy
    long available = 0;
    for(long priority : REVERSED_PROVIDER_PRIORITIES){
      try{
        for(NodeWithValue node : PRIORITISED_PROVIDERS.get(priority)){
          available = Math.addExact(available, node.getValue());
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
      List<NodeWithValue> nodes = new ArrayList<>(PRIORITISED_CONSUMERS.get(priority));
      while(toBeDistributed > 0 && !nodes.isEmpty()){
        long energyPerNode = toBeDistributed / nodes.size();
        toBeDistributed %= nodes.size();
        
        List<NodeWithValue> removedNodes = new ArrayList<>();
        for(NodeWithValue node : nodes){
          toBeDistributed += node.add(energyPerNode);
          if(node.getValue() == node.getMaxValue()){
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
      List<NodeWithValue> nodes = new ArrayList<>(PRIORITISED_PROVIDERS.get(priority));
      while(toBeRemoved > 0 && !nodes.isEmpty()){
        long energyPerNode = toBeDistributed / nodes.size();
        toBeRemoved %= nodes.size();
        
        List<NodeWithValue> removedNodes = new ArrayList<>();
        for(NodeWithValue node : nodes){
          toBeDistributed += node.add(energyPerNode);
          if(node.getValue() == 0){
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
    if (object == null || this.getClass() != object.getClass()) return false;
    NodeNetwork that = (NodeNetwork) object;
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
