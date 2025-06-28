package net.fawnoculus.ntm.blocks.node;

import net.fawnoculus.ntm.blocks.node.network.FluidNetwork;
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

public class FluidNode extends BlockEntity implements Node<FluidNode> {
  private FluidNetwork network;
  private NodeProperties nodeProperties;
  
  private FluidNode(BlockEntityType<?> type, BlockPos pos, BlockState state, NodeProperties properties){
    super(type, pos, state);
    this.setNodeProperties(properties);
    this.assignNetwork();
  }
  
  public static FluidNode createConnectorNode(BlockEntityType<?> type, BlockPos pos, BlockState state){
    return new FluidNode(type, pos, state, new NodeProperties.Connector());
  }
  public static FluidNode createProviderNode(BlockEntityType<?> type, BlockPos pos, BlockState state, long MaxEnergy, long MaxTransfer){
    NodeProperties properties = new NodeProperties.Provider();
    properties.setMaxValue(MaxEnergy);
    properties.setMaxTransfer(MaxTransfer);
    return new FluidNode(type, pos, state, properties);
  }
  public static FluidNode createConsumerNode(BlockEntityType<?> type, BlockPos pos, BlockState state, long MaxEnergy, long MaxTransfer){
    NodeProperties properties = new NodeProperties.Consumer();
    properties.setMaxValue(MaxEnergy);
    properties.setMaxTransfer(MaxTransfer);
    return new FluidNode(type, pos, state, properties);
  }
  public static FluidNode createStorageNode(BlockEntityType<?> type, BlockPos pos, BlockState state, long MaxEnergy, long MaxTransfer){
    NodeProperties properties = new NodeProperties.Storge();
    properties.setMaxValue(MaxEnergy);
    properties.setMaxTransfer(MaxTransfer);
    return new FluidNode(type, pos, state, properties);
  }
  
  @Override
  public void onBlockReplaced(BlockPos pos, BlockState oldState) {
    super.onBlockReplaced(pos, oldState);
    this.onBreak();
  }
  
  @Override
  public void setNetwork(NodeNetwork<FluidNode> network) {
    this.network = (FluidNetwork) network;
  }
  @Override
  public FluidNetwork getNetwork() {
    if(this.network == null){
      this.assignNetwork();
    }
    return this.network;
  }
  @Override
  public void assignNetwork() {
    FluidNetwork detectedNetwork = this.findNetwork(this.getPos().up(), null);
    detectedNetwork = this.findNetwork(this.getPos().down(), detectedNetwork);
    detectedNetwork = this.findNetwork(this.getPos().north(), detectedNetwork);
    detectedNetwork = this.findNetwork(this.getPos().east(), detectedNetwork);
    detectedNetwork = this.findNetwork(this.getPos().south(), detectedNetwork);
    detectedNetwork = this.findNetwork(this.getPos().west(), detectedNetwork);
    if(detectedNetwork == null){
      detectedNetwork = new FluidNetwork();
    }
    if(!detectedNetwork.containsNode(this)){
      detectedNetwork.addNode(this);
    }
    
    this.setNetwork(detectedNetwork);
  }
  
  private FluidNetwork findNetwork(BlockPos blockPos, FluidNetwork detectedNetwork) {
    assert this.world != null;
    BlockEntity bl = this.world.getBlockEntity(blockPos);
    if (!(bl instanceof FluidNode node) || node.network == null) {
      return detectedNetwork;
    }
    FluidNetwork foundNetwork = node.getNetwork();
    if (detectedNetwork != null && !foundNetwork.equals(detectedNetwork)) {
      detectedNetwork.mergeNetworksAt(this);
      return detectedNetwork;
    }
    return foundNetwork;
  }
  @Override
  public List<Node<FluidNode>> getConnectedNodes() {
    World world = this.getWorld();
    assert world != null;
    BlockPos pos = this.getPos();
    List<Node<FluidNode>> nodes = new ArrayList<>();
    if(world.getBlockEntity(pos.up()) instanceof FluidNode FluidNode){
      nodes.add(FluidNode);
    }
    if(world.getBlockEntity(pos.down()) instanceof FluidNode FluidNode){
      nodes.add(FluidNode);
    }
    if(world.getBlockEntity(pos.north()) instanceof FluidNode FluidNode){
      nodes.add(FluidNode);
    }
    if(world.getBlockEntity(pos.east()) instanceof FluidNode FluidNode){
      nodes.add(FluidNode);
    }
    if(world.getBlockEntity(pos.south()) instanceof FluidNode FluidNode){
      nodes.add(FluidNode);
    }
    if(world.getBlockEntity(pos.west()) instanceof FluidNode FluidNode){
      nodes.add(FluidNode);
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
  public FluidNode getBE() {
    return this;
  }
  
  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    String s = nbt.getString("network", null);
    if(s == null){
      this.assignNetwork();
      s = this.getNetwork().ID.toString();
    }
    this.setNetwork(NodeNetworkManager.getFluidNetwork(UUID.fromString(s)));
    this.nodeProperties.readNBT(nbt, registries);
  }
  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    nbt.putString("network", this.getNetwork().ID.toString());
    this.nodeProperties.writeNBT(nbt, registries);
  }
}
