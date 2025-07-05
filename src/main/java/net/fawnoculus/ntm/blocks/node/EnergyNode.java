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
import java.util.function.Supplier;

public abstract class EnergyNode extends BlockEntity implements Node<EnergyNode> {
  private EnergyNetwork network;
  private NodeProperties nodeProperties;
  
  public EnergyNode(BlockEntityType<?> type, Supplier<NodeProperties> properties, BlockPos pos, BlockState state){
    super(type, pos, state);
    this.setNodeProperties(properties.get());
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
  public void setWorld(World world) {
    super.setWorld(world);
    if(world.isClient){
      return;
    }
    if(this.network == null){
      this.assignNetwork();
    }
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
  public NodeProperties getNodeProperties() {
    return nodeProperties;
  }
  
  
  @Override
  public EnergyNode getBE() {
    return this;
  }
  
  @Override
  public void markRemoved() {
    super.markRemoved();
    this.onUnload();
  }
  
  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    UUID uuid = null;
    try{
      uuid = UUID.fromString(nbt.getString("network", null));
    } catch (IllegalArgumentException ignored){}
    if(uuid != null){
      this.setNetwork(NodeNetworkManager.getEnergyNetwork(uuid));
      this.network.addNode(this);
    }
    this.nodeProperties.readNBT(nbt, registries);
  }
  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    nbt.putString("network", this.getNetwork().ID.toString());
    this.nodeProperties.writeNBT(nbt, registries);
  }
}
