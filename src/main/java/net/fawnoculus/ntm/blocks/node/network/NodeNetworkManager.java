package net.fawnoculus.ntm.blocks.node.network;

import net.fawnoculus.ntm.blocks.node.EnergyNode;
import net.fawnoculus.ntm.blocks.node.FluidNode;
import net.fawnoculus.ntm.main.NTM;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class NodeNetworkManager {
  private static final HashMap<UUID, NodeNetwork<?>> ALL_NODE_NETWORKS = new HashMap<>();
  private static final HashMap<UUID, NodeNetwork<EnergyNode>> ALL_ENERGY_NETWORKS = new HashMap<>();
  private static final HashMap<UUID, NodeNetwork<FluidNode>> ALL_FLUID_NETWORKS = new HashMap<>();
  
  public static void addNetwork(@NotNull NodeNetwork<?> network){
    if(ALL_NODE_NETWORKS.get(network.ID) != null){
      NTM.LOGGER.warn("Network {} exist twice, this may cause unwanted behaviour!", network.ID);
    }
    ALL_NODE_NETWORKS.put(network.ID, network);
  }
  
  @Nullable
  public static NodeNetwork<?> getNetwork(UUID uuid){
    return  ALL_NODE_NETWORKS.get(uuid);
  }
  
  public static void removeNetwork(@NotNull NodeNetwork<?> network){
    ALL_NODE_NETWORKS.remove(network.ID);
    ALL_FLUID_NETWORKS.remove(network.ID);
    ALL_ENERGY_NETWORKS.remove(network.ID);
  }
  
  @Contract(pure = true)
  public static @NotNull Collection<NodeNetwork<?>> getAllNetworks(){
    return ALL_NODE_NETWORKS.values();
  }
  
  public static void addEnergyNetwork(@NotNull EnergyNetwork network){
    ALL_ENERGY_NETWORKS.put(network.ID, network);
  }
  
  @NotNull
  public static NodeNetwork<EnergyNode> getEnergyNetwork(@NotNull UUID uuid){
    NodeNetwork<EnergyNode> network = ALL_ENERGY_NETWORKS.get(uuid);
    if(network == null){
      network = new EnergyNetwork(uuid);
    }
    return network;
  }
  
  public static void addFluidNetwork(@NotNull FluidNetwork network){
    ALL_FLUID_NETWORKS.put(network.ID, network);
  }
  
  @NotNull
  public static NodeNetwork<FluidNode> getFluidNetwork(@NotNull UUID uuid){
    NodeNetwork<FluidNode> network = ALL_FLUID_NETWORKS.get(uuid);
    if(network == null){
      network = new FluidNetwork(uuid);
    }
    return network;
  }
  
  public static void tickNetworks(){
    Collection<NodeNetwork<?>> networks = List.copyOf(getAllNetworks());
    for(NodeNetwork<?> network : networks){
      if(network.isEmpty()){
        removeNetwork(network);
        continue;
      }
      
      network.tickNetwork();
    }
  }
}
