package net.fawnoculus.ntm.api.node.network.type;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.node.network.NodeNetwork;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class EnergyNetworkType implements NetworkType {
  private static final HashMap<UUID, NodeNetwork> ENERGY_NETWORKS = new HashMap<>();
  private static final EnergyNetworkType INSTANCE = new EnergyNetworkType();

  private EnergyNetworkType() {
  }

  public static EnergyNetworkType get() {
    return INSTANCE;
  }

  @Override
  public Identifier getId() {
    return NTM.id("energy");
  }

  @Override
  public void setNetwork(UUID uuid, NodeNetwork network) {
    ENERGY_NETWORKS.put(uuid, network);
  }

  @Override
  public void removeNetwork(UUID uuid) {
    ENERGY_NETWORKS.remove(uuid);
  }

  @Override
  public NodeNetwork getNetwork(UUID uuid) {
    return ENERGY_NETWORKS.getOrDefault(uuid, this.makeNewNetwork());
  }

  @Override
  public Collection<NodeNetwork> getAllNetworks() {
    return ENERGY_NETWORKS.values();
  }
}
