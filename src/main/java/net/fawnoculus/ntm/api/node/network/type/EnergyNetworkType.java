package net.fawnoculus.ntm.api.node.network.type;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.node.network.NodeNetwork;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
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
  public Map<UUID, NodeNetwork> networks() {
    return ENERGY_NETWORKS;
  }
}
