package net.fawnoculus.ntm.api.node.network;

import net.fawnoculus.ntm.api.node.network.type.NetworkType;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class NodeNetworkManager {
  private static final Set<NodeNetwork> NODE_NETWORKS = new HashSet<>();
  private static final HashMap<Identifier, NetworkType> TYPES = new HashMap<>();

  public static void registerType(NetworkType type){
    registerType(type.getId(), type);
  }

  public static void registerType(Identifier identifier, NetworkType type){
    TYPES.put(identifier, type);
  }

  public static NetworkType getType(Identifier identifier){
    return TYPES.get(identifier);
  }

  public static Collection<NetworkType> getAllTypes(){
    return TYPES.values();
  }

  public static void addNetwork(@NotNull NodeNetwork network){
    NODE_NETWORKS.add(network);
    network.TYPE.setNetwork(network.ID, network);
  }

  public static void removeNetwork(@NotNull NodeNetwork network){
    NODE_NETWORKS.remove(network);
    network.TYPE.removeNetwork(network.ID);
  }

  @Contract(pure = true)
  public static @NotNull Collection<NodeNetwork> getAllNetworks(){
    return NODE_NETWORKS;
  }

  public static void tickNetworks(){
    List<NodeNetwork> toBeRemoved = new ArrayList<>();

    for(NodeNetwork network : getAllNetworks()){
      if(network.isEmpty()){
        toBeRemoved.add(network);
        continue;
      }

      network.tickNetwork();
    }

    toBeRemoved.forEach(NODE_NETWORKS::remove);
  }
}
