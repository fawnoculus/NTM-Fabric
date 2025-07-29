package net.fawnoculus.ntm.blocks.node.network;

import net.fawnoculus.ntm.NTM;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class NodeNetworkManager {
  private static final HashMap<UUID, NodeNetwork> ALL_NODE_NETWORKS = new HashMap<>();
  private static final HashMap<UUID, EnergyNetwork> ENERGY_NETWORKS = new HashMap<>();
  private static final HashMap<UUID, FluidNetwork> FLUID_NETWORKS = new HashMap<>();
  
  public static void addNetwork(@NotNull NodeNetwork network){
    if(ALL_NODE_NETWORKS.get(network.ID) != null){
      // Technically since a node Network is generated with a random UUID there is a chance that this could occur by pure chance
      // However that chance is a 1 in 5,316,911,983,139,663,491,615,228,241,121,378,304 (122 random bits in a UUID so 2^122) so the Universe will have exploded before that happens
      NTM.LOGGER.warn("Network {} exist twice, this may cause unwanted behaviour!", network.ID);
    }
    ALL_NODE_NETWORKS.put(network.ID, network);
  }
  
  @Nullable
  public static NodeNetwork getNetwork(UUID uuid){
    return  ALL_NODE_NETWORKS.get(uuid);
  }
  
  public static void removeNetwork(@NotNull NodeNetwork network){
    ALL_NODE_NETWORKS.remove(network.ID);
    FLUID_NETWORKS.remove(network.ID);
    ENERGY_NETWORKS.remove(network.ID);
  }
  
  @Contract(pure = true)
  public static @NotNull Collection<NodeNetwork> getAllNetworks(){
    return ALL_NODE_NETWORKS.values();
  }
  
  public static void addEnergyNetwork(@NotNull EnergyNetwork network) {
    ENERGY_NETWORKS.put(network.ID, network);
  }
  
  @NotNull
  public static EnergyNetwork getEnergyNetwork(@NotNull UUID uuid){
    EnergyNetwork network = ENERGY_NETWORKS.get(uuid);
    if(network == null){
      network = new EnergyNetwork(uuid);
    }
    return network;
  }
  
  public static void addFluidNetwork(@NotNull FluidNetwork network){
    FLUID_NETWORKS.put(network.ID, network);
  }
  
  @NotNull
  public static FluidNetwork getFluidNetwork(@NotNull UUID uuid){
    FluidNetwork network = FLUID_NETWORKS.get(uuid);
    if(network == null){
      network = new FluidNetwork(uuid);
    }
    return network;
  }
  
  public static void tickNetworks(){
    Collection<NodeNetwork> networks = List.copyOf(getAllNetworks());
    for(NodeNetwork network : networks){
      if(network.isEmpty()){
        removeNetwork(network);
        continue;
      }
      
      network.tickNetwork();
    }
  }
}
