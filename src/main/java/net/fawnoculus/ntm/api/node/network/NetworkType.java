package net.fawnoculus.ntm.api.node.network;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NetworkType {
  public NetworkType(Identifier id){
    this.ID = id;
  }

  private final HashMap<UUID, NodeNetwork> NETWORKS = new HashMap<>();
  private final Identifier ID;

  public Identifier getId(){
    return this.ID;
  }

  public Map<UUID, NodeNetwork> networks(){
    return NETWORKS;
  }

  public void setNetwork(UUID uuid, NodeNetwork network){
    this.networks().put(uuid, network);
  }

  public void removeNetwork(UUID uuid){
    this.networks().remove(uuid);
  }

  public NodeNetwork getNetwork(UUID uuid){
    NodeNetwork network = this.networks().get(uuid);
    if(network == null){
      network = this.makeNewNetwork(uuid);
    }
    return network;
  }

  public Collection<NodeNetwork> getAllNetworks(){
    return this.networks().values();
  }

  public MutableText getName() {
    return Text.translatable("network_type." + this.getId().getNamespace() + "." + this.getId().getPath());
  }

  public NodeNetwork makeNewNetwork() {
    return new NodeNetwork(UUID.randomUUID(), this);
  }

  public NodeNetwork makeNewNetwork(UUID uuid) {
    return new NodeNetwork(uuid, this);
  }
}
