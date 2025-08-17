package net.fawnoculus.ntm.api.node.network;

import net.fawnoculus.ntm.api.node.Node;
import net.fawnoculus.ntm.api.node.NodeValueContainer;
import com.google.common.collect.ImmutableList;
import io.netty.util.collection.LongObjectHashMap;
import io.netty.util.collection.LongObjectMap;
import net.fawnoculus.ntm.api.node.network.type.NetworkType;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class NodeNetwork {
  public final UUID ID;
  public final NetworkType TYPE;
  public final Set<Node> LOADED_NODES = new HashSet<>();
  public final Set<Long> REVERSED_CONSUMER_PRIORITIES = new TreeSet<Long>().reversed();
  public final LongObjectMap<List<NodeValueContainer>> PRIORITISED_CONSUMERS = new LongObjectHashMap<>();
  public final Set<Long> REVERSED_PROVIDER_PRIORITIES = new TreeSet<Long>().reversed();
  public final LongObjectMap<List<NodeValueContainer>> PRIORITISED_PROVIDERS = new LongObjectHashMap<>();

  public NodeNetwork(UUID uuid, NetworkType type){
    this.ID = uuid;
    this.TYPE = type;

    NodeNetworkManager.addNetwork(this);
  }

  public void addNode(@NotNull Node node){
    if(!LOADED_NODES.add(node) && NTMConfig.DevMode.getValue()){
      NTM.LOGGER.warn("Added Node {} twice to Network {}", node, this.ID);
    }

    for(NodeValueContainer container : node.getContainers()){
      this.addToSorted(container, container.getPriority(), container.provides(), container.consumes());
    }
  }

  /**
   * Removes a Node from the Network, if the node is permanently removed & not just unloaded, please use disconnect Node instead!
   * @param node the Node to be removed
   */
  public void removeNode(@NotNull Node node){
    LOADED_NODES.remove(node);

    for(NodeValueContainer container : node.getContainers()){
      this.removeFromSorted(container, container.getPriority(), container.provides(), container.consumes());
    }
  }
  /**
   * Removes all data from a network, this will cause the network to get removed if no containers are added back to the network before the next tick
   */
  public void clearNetwork(){
    this.LOADED_NODES.clear();
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
    return this.LOADED_NODES.isEmpty();
  }

  /**
   * Checks if the network contains a specific node
   * @param node the node to be checked
   * @return whether the network contains the node
   */
  public boolean containsNode(@NotNull Node node){
    return this.LOADED_NODES.contains(node);
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

      NodeNetwork assignedNetwork = isFirst ? this : this.TYPE.makeNewNetwork();
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
   * removes the connection between multiple containers, will only remove them from the network if necessary
   * @param providedNodes the containers whose connection with each other will be severed
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

      NodeNetwork assignedNetwork = isFirst ? this : this.TYPE.makeNewNetwork();
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
   * Merges this network with another Network
   * @param network the Network to be merged with
   */
  public void mergeWith(@NotNull NodeNetwork network){
    if(this.equals(network) || this.TYPE != network.TYPE) return;
    this.LOADED_NODES.addAll(network.LOADED_NODES);

    this.REVERSED_PROVIDER_PRIORITIES.addAll(network.REVERSED_PROVIDER_PRIORITIES);
    for(long priority : network.PRIORITISED_PROVIDERS.keySet()){
      this.PRIORITISED_PROVIDERS.getOrDefault(priority, new ArrayList<>()).addAll(
        network.PRIORITISED_PROVIDERS.get(priority)
      );
    }

    this.REVERSED_CONSUMER_PRIORITIES.addAll(network.REVERSED_CONSUMER_PRIORITIES);
    for(long priority : network.PRIORITISED_CONSUMERS.keySet()){
      this.PRIORITISED_CONSUMERS.getOrDefault(priority, new ArrayList<>()).addAll(
        network.PRIORITISED_CONSUMERS.get(priority)
      );
    }
  }

  public void addToSorted(NodeValueContainer container, long priority, boolean provides, boolean consumes){
    if(provides){
      this.REVERSED_PROVIDER_PRIORITIES.add(priority);
      this.PRIORITISED_PROVIDERS.putIfAbsent(priority, new ArrayList<>());
      this.PRIORITISED_PROVIDERS.get(priority).add(container);
    }
    if(consumes){
      this.REVERSED_CONSUMER_PRIORITIES.add(priority);
      this.PRIORITISED_CONSUMERS.putIfAbsent(priority, new ArrayList<>());
      this.PRIORITISED_CONSUMERS.get(priority).add(container);
    }
  }

  public void removeFromSorted(NodeValueContainer container, long priority, boolean provides, boolean consumes){
    if(provides){
      List<NodeValueContainer> providers = this.PRIORITISED_PROVIDERS.get(priority);
      providers.remove(container);
      if(providers.isEmpty()){
        this.REVERSED_PROVIDER_PRIORITIES.remove(priority);
        this.PRIORITISED_PROVIDERS.remove(priority);
      }
    }
    if(consumes){
      List<NodeValueContainer> providers = this.PRIORITISED_CONSUMERS.get(priority);
      providers.remove(container);
      if(providers.isEmpty()){
        this.REVERSED_CONSUMER_PRIORITIES.remove(priority);
        this.PRIORITISED_CONSUMERS.remove(priority);
      }
    }
  }

  public void tickNetwork(){
    // Get All Available Energy
    long available = 0;
    for(long priority : REVERSED_PROVIDER_PRIORITIES){
      try{
        for(NodeValueContainer node : PRIORITISED_PROVIDERS.getOrDefault(priority, new ArrayList<>())){
          available = Math.addExact(available, node.getValue());
        }
      }catch (ArithmeticException exception){
        // Break the Loop if we overflow
        // This limits the Throughput of a Network to 9,223,372,036,854,775,807 NTE/t (~ 9.2 Exa NTE/t)
        // Technically I could make it capable of transferring infinite amounts of energy with BigInteger, but I didn't feel like it
        available = Long.MAX_VALUE;
        break;
      }
    }

    // Add Available Energy to all Consumers
    long toBeDistributed = available;
    for(long priority : REVERSED_CONSUMER_PRIORITIES){
      List<NodeValueContainer> containers = new ArrayList<>(PRIORITISED_CONSUMERS.getOrDefault(priority, new ArrayList<>()));
      while(toBeDistributed > 0 && !containers.isEmpty()){
        long energyPerNode = toBeDistributed / containers.size();
        toBeDistributed %= containers.size();

        List<NodeValueContainer> fullContainers = new ArrayList<>();
        for(NodeValueContainer container : containers){
          toBeDistributed += container.add(energyPerNode);
          if(container.getValue() == container.getMaxValue()){
            fullContainers.add(container);
          }
        }

        containers.removeAll(fullContainers);
      }
      if(toBeDistributed == 0) break;
    }

    // Remove all energy that was consumed
    long toBeRemoved = available - toBeDistributed;
    for(long priority : REVERSED_PROVIDER_PRIORITIES) {
      List<NodeValueContainer> containers = new ArrayList<>(PRIORITISED_PROVIDERS.getOrDefault(priority, new ArrayList<>()));
      while(toBeRemoved > 0 && !containers.isEmpty()){
        long energyPerNode = toBeDistributed / containers.size();
        toBeRemoved %= containers.size();

        List<NodeValueContainer> emptyContainers = new ArrayList<>();
        for(NodeValueContainer container : containers){
          toBeDistributed += container.add(energyPerNode);
          if(container.getValue() == 0){
            emptyContainers.add(container);
          }
        }

        containers.removeAll(emptyContainers);
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
    return String.format("NodeNetwork{UUID:%1$s, %2$d Loaded Nodes(s)}", this.ID, this.LOADED_NODES.size());
  }
}
