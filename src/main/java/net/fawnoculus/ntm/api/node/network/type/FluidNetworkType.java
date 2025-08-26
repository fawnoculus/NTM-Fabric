package net.fawnoculus.ntm.api.node.network.type;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.node.network.NodeNetwork;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FluidNetworkType implements NetworkType {
  private static final HashMap<UUID, NodeNetwork> FLUID_NETWORKS = new HashMap<>();
  private static final FluidNetworkType INSTANCE = new FluidNetworkType();

  private FluidNetworkType() {
  }

  public static FluidNetworkType get() {
    return INSTANCE;
  }

  @Override
  public Identifier getId() {
    return NTM.id("fluid");
  }

  @Override
  public Map<UUID, NodeNetwork> networks() {
    return FLUID_NETWORKS;
  }
}
