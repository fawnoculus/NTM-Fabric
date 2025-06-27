package net.fawnoculus.ntm.blocks.custom.node.network;

import java.util.HashMap;
import java.util.UUID;

public class NodeNetworkManager {
  private static final HashMap<UUID, NodeNetwork<?>> ALL_NODE_NETWORKS = new HashMap<>();
  private static final HashMap<UUID, EnergyNetwork> ALL_ENERGY_NETWORKS = new HashMap<>();
  
  public static void addNetwork(NodeNetwork<?> network){
    ALL_NODE_NETWORKS.put(network.ID, network);
  }
  
  public static NodeNetwork<?> getNetwork(UUID uuid){
    return ALL_NODE_NETWORKS.get(uuid);
  }
  
  public static void addEnergyNetwork(EnergyNetwork network){
    ALL_ENERGY_NETWORKS.put(network.ID, network);
  }
  
  public static EnergyNetwork getEnergyNetwork(UUID uuid){
    return ALL_ENERGY_NETWORKS.get(uuid);
  }
}
