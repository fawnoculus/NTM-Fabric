package net.fawnoculus.ntm.api.node.network.type;

import net.fawnoculus.ntm.api.node.network.NodeNetwork;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface NetworkType {
  Identifier getId();

  Map<UUID, NodeNetwork> networks();

  default void setNetwork(UUID uuid, NodeNetwork network){
    this.networks().put(uuid, network);
  }

  default void removeNetwork(UUID uuid){
    this.networks().remove(uuid);
  }

  default NodeNetwork getNetwork(UUID uuid){
    NodeNetwork network = this.networks().get(uuid);
    if(network == null){
      network = this.makeNewNetwork(uuid);
    }
    return network;
  }

  default Collection<NodeNetwork> getAllNetworks(){
    return this.networks().values();
  }

  default MutableText getName() {
    return Text.translatable("network_type." + this.getId().getNamespace() + "." + this.getId().getPath());
  }

  default NodeNetwork makeNewNetwork() {
    return new NodeNetwork(UUID.randomUUID(), this);
  }

  default NodeNetwork makeNewNetwork(UUID uuid) {
    return new NodeNetwork(uuid, this);
  }
}
