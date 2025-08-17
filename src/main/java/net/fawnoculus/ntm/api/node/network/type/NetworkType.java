package net.fawnoculus.ntm.api.node.network.type;

import net.fawnoculus.ntm.api.node.network.NodeNetwork;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.*;

public interface NetworkType {
  Identifier getId();

  void setNetwork(UUID uuid, NodeNetwork network);

  void removeNetwork(UUID uuid);

  NodeNetwork getNetwork(UUID uuid);

  Collection<NodeNetwork> getAllNetworks();

  default MutableText getName(){
    return Text.translatable("network_type." + this.getId().getNamespace() + "." + this.getId().getPath());
  }

  default NodeNetwork makeNewNetwork() {
    return new NodeNetwork(UUID.randomUUID(), this);
  }
}
