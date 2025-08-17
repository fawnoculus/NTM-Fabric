package net.fawnoculus.ntm.api.node.network.type;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.node.network.NodeNetwork;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class FluidNetworkType implements NetworkType {
  private static final HashMap<UUID, NodeNetwork> FLUID_NETWORKS = new HashMap<>();
  private static final FluidNetworkType INSTANCE = new FluidNetworkType();

  private FluidNetworkType() {
  }

  public static FluidNetworkType get(){
    return INSTANCE;
  }

  @Override
  public Identifier getId() {
    return NTM.id("fluid");
  }

  @Override
  public void setNetwork(UUID uuid, NodeNetwork network) {
    FLUID_NETWORKS.put(uuid, network);
  }

  @Override
  public void removeNetwork(UUID uuid) {
    FLUID_NETWORKS.remove(uuid);
  }

  @Override
  public NodeNetwork getNetwork(UUID uuid) {
    return FLUID_NETWORKS.getOrDefault(uuid, this.makeNewNetwork());
  }

  @Override
  public Collection<NodeNetwork> getAllNetworks() {
    return FLUID_NETWORKS.values();
  }
}
