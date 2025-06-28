package net.fawnoculus.ntm.blocks.node;

import net.fawnoculus.ntm.blocks.node.network.EnergyNetwork;
import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
import net.fawnoculus.ntm.blocks.node.network.NodeNetworkManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EnergyNode extends BlockEntity implements Node<EnergyNode> {
  private EnergyNetwork network;
  private NodeProperties nodeProperties;
  
  private EnergyNode(BlockEntityType<?> type, BlockPos pos, BlockState state, NodeProperties properties){
    super(type, pos, state);
    this.setNodeProperties(properties);
    this.assignNetwork();
  }
  
  public static EnergyNode createConnectorNode(BlockEntityType<?> type, BlockPos pos, BlockState state){
    return new EnergyNode(type, pos, state, new NodeProperties.Connector());
  }
  public static EnergyNode createProviderNode(BlockEntityType<?> type, BlockPos pos, BlockState state, long MaxEnergy, long MaxTransfer){
    NodeProperties properties = new NodeProperties.Provider();
    properties.setMaxValue(MaxEnergy);
    properties.setMaxTransfer(MaxTransfer);
    return new EnergyNode(type, pos, state, properties);
  }
  public static EnergyNode createConsumerNode(BlockEntityType<?> type, BlockPos pos, BlockState state, long MaxEnergy, long MaxTransfer){
    NodeProperties properties = new NodeProperties.Consumer();
    properties.setMaxValue(MaxEnergy);
    properties.setMaxTransfer(MaxTransfer);
    return new EnergyNode(type, pos, state, properties);
  }
  public static EnergyNode createStorageNode(BlockEntityType<?> type, BlockPos pos, BlockState state, long MaxEnergy, long MaxTransfer){
    NodeProperties properties = new NodeProperties.Storge();
    properties.setMaxValue(MaxEnergy);
    properties.setMaxTransfer(MaxTransfer);
    return new EnergyNode(type, pos, state, properties);
  }
  
  @Override
  public void onBlockReplaced(BlockPos pos, BlockState oldState) {
    super.onBlockReplaced(pos, oldState);
    this.onBreak();
  }
  
  @Override
  public void setNetwork(NodeNetwork<EnergyNode> network) {
    this.network = (EnergyNetwork) network;
  }
  @Override
  public EnergyNetwork getNetwork() {
    if(this.network == null){
      this.assignNetwork();
    }
    return this.network;
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
    if(!detectedNetwork.containsNode(this)){
      detectedNetwork.addNode(this);
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
  public void setNodeProperties(NodeProperties nodeProperties) {
    this.nodeProperties = nodeProperties;
    if(this.network != null){
      this.network.removeNode(this);
      this.network.addNode(this);
    }
  }
  @Override
  public NodeProperties getNodeType() {
    return nodeProperties;
  }
  
  
  @Override
  public EnergyNode getBE() {
    return this;
  }
  
  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    String s = nbt.getString("network", null);
    if(s == null){
      this.assignNetwork();
      s = this.getNetwork().ID.toString();
    }
    this.setNetwork(NodeNetworkManager.getEnergyNetwork(UUID.fromString(s)));
    this.nodeProperties.readNBT(nbt, registries);
  }
  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    nbt.putString("network", this.getNetwork().ID.toString());
    this.nodeProperties.writeNBT(nbt, registries);
  }
}
