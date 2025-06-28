package net.fawnoculus.ntm.blocks.node.network;

import net.fawnoculus.ntm.main.NTM;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class NodeNetworkManager {
  private static final HashMap<UUID, NodeNetwork<?>> ALL_NODE_NETWORKS = new HashMap<>();
  private static final HashMap<UUID, EnergyNetwork> ALL_ENERGY_NETWORKS = new HashMap<>();
  private static final HashMap<UUID, FluidNetwork> ALL_FLUID_NETWORKS = new HashMap<>();
  
  public static void addNetwork(NodeNetwork<?> network){
    if(ALL_NODE_NETWORKS.get(network.ID) != null){
      NTM.LOGGER.warn("Network {} exist twice, this may cause unwanted behaviour!", network.ID);
    }
    ALL_NODE_NETWORKS.put(network.ID, network);
  }
  
  public static NodeNetwork<?> getNetwork(UUID uuid){
    return ALL_NODE_NETWORKS.get(uuid);
  }
  
  public static Collection<NodeNetwork<?>> getAllNetworks(){
    return ALL_NODE_NETWORKS.values();
  }
  
  public static void addEnergyNetwork(EnergyNetwork network){
    ALL_ENERGY_NETWORKS.put(network.ID, network);
  }
  
  public static EnergyNetwork getEnergyNetwork(UUID uuid){
    return ALL_ENERGY_NETWORKS.get(uuid);
  }
  
  public static void addFluidNetwork(FluidNetwork network){
    ALL_FLUID_NETWORKS.put(network.ID, network);
  }
  
  public static FluidNetwork getFluidNetwork(UUID uuid){
    return ALL_FLUID_NETWORKS.get(uuid);
  }
}
