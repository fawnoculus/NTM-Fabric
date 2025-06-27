package net.fawnoculus.ntm.blocks.custom.node;

import net.fawnoculus.ntm.blocks.custom.node.network.EnergyNetwork;
import net.fawnoculus.ntm.blocks.custom.node.network.NodeNetwork;
import net.fawnoculus.ntm.blocks.custom.node.network.NodeNetworkManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EnergyNode extends BlockEntity implements Node<EnergyNode> {
  public EnergyNode(BlockEntityType<?> type, BlockPos pos, BlockState state) {
    super(type, pos, state);
  }
  
  @Override
  public void onBlockReplaced(BlockPos pos, BlockState oldState) {
    super.onBlockReplaced(pos, oldState);
    this.onBreak();
  }
  
  private EnergyNetwork network;
  private NodeType nodeType = new NodeType.Connector();
  
  @Override @NotNull
  public EnergyNetwork getNetwork() {
    if(this.network == null){
      this.assignNetwork();
    }
    return this.network;
  }
  
  @Override
  public void setNetwork(NodeNetwork<EnergyNode> network) {
    this.network = (EnergyNetwork) network;
  }
  
  @Override
  public NodeType getNodeType() {
    return nodeType;
  }
  
  public void setNodeType(NodeType nodeType) {
    this.nodeType = nodeType;
  }
  
  @Override
  public void assignNetwork() {
    EnergyNetwork detectedNetwork = this.findNetwork(this.getPos().up(), null);
    detectedNetwork = this.findNetwork(this.getPos().down(), detectedNetwork);
    detectedNetwork = this.findNetwork(this.getPos().north(), detectedNetwork);
    detectedNetwork = this.findNetwork(this.getPos().east(), detectedNetwork);
    detectedNetwork = this.findNetwork(this.getPos().south(), detectedNetwork);
    detectedNetwork = this.findNetwork(this.getPos().west(), detectedNetwork);
    if(detectedNetwork == null){
      detectedNetwork = new EnergyNetwork();
    }
    
    this.setNetwork(detectedNetwork);
  }
  
  private EnergyNetwork findNetwork(BlockPos blockPos, EnergyNetwork detectedNetwork) {
    assert this.world != null;
    BlockEntity bl = this.world.getBlockEntity(blockPos);
    if (!(bl instanceof EnergyNode node) || node.network == null) {
      return detectedNetwork;
    }
    EnergyNetwork foundNetwork = node.getNetwork();
    if (detectedNetwork != null && !foundNetwork.equals(detectedNetwork)) {
      detectedNetwork.mergeNetworksAt(this);
      return detectedNetwork;
    }
    return foundNetwork;
  }
  
  @Override
  public List<Node<EnergyNode>> getConnectedNodes() {
    World world = this.getWorld();
    assert world != null;
    BlockPos pos = this.getPos();
    List<Node<EnergyNode>> nodes = new ArrayList<>();
    if(world.getBlockEntity(pos.up()) instanceof EnergyNode energyNode){
      nodes.add(energyNode);
    }
    if(world.getBlockEntity(pos.down()) instanceof EnergyNode energyNode){
      nodes.add(energyNode);
    }
    if(world.getBlockEntity(pos.north()) instanceof EnergyNode energyNode){
      nodes.add(energyNode);
    }
    if(world.getBlockEntity(pos.east()) instanceof EnergyNode energyNode){
      nodes.add(energyNode);
    }
    if(world.getBlockEntity(pos.south()) instanceof EnergyNode energyNode){
      nodes.add(energyNode);
    }
    if(world.getBlockEntity(pos.west()) instanceof EnergyNode energyNode){
      nodes.add(energyNode);
    }
    return nodes;
  }
  
  @Override
  public EnergyNode getNode() {
    return this;
  }
  
  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    nbt.putString("network_uuid", this.getNetwork().ID.toString());
  }
  
  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    String s = nbt.getString("network_uuid", null);
    if(s == null){
      this.assignNetwork();
      s = this.getNetwork().ID.toString();
    }
    
    this.setNetwork(NodeNetworkManager.getEnergyNetwork(UUID.fromString(s)));
  }
}
