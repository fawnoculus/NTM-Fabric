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
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

public class EnergyNode extends BlockEntity implements Node<EnergyNode> {
  private boolean shouldAssignNetwork = true;
  private NodeNetwork<EnergyNode> network;
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
  public void setShouldAssignNetwork(boolean value) {
    this.shouldAssignNetwork = value;
  }
  
  @Override
  public boolean shouldAssignNetwork() {
    return this.shouldAssignNetwork;
  }
  
  @Override
  public void setNetwork(NodeNetwork<EnergyNode> network) {
    this.network = network;
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
  public @Nullable NodeNetwork<EnergyNode> getNetwork() {
    if(this.network == null){
      this.assignNetwork();
    }
    return this.network;
  }
  
  @Override
  public NodeNetwork<EnergyNode> makeNewNetwork() {
    return new EnergyNetwork();
  }
  
  @Override @SuppressWarnings("unchecked")
  public List<Node<EnergyNode>> getConnectedNodes() {
    World world = this.getWorld();
    assert world != null;
    BlockPos pos = this.getPos();
    List<Node<EnergyNode>> nodes = new ArrayList<>();
    try {
      Node<EnergyNode> node = (Node<EnergyNode>) world.getBlockEntity(pos.up());
      Objects.requireNonNull(node);
      nodes.add(node);
    } catch (Exception ignored) {}
    try {
      Node<EnergyNode> node = (Node<EnergyNode>) world.getBlockEntity(pos.down());
      Objects.requireNonNull(node);
      nodes.add(node);
    } catch (Exception ignored) {}
    try {
      Node<EnergyNode> node = (Node<EnergyNode>) world.getBlockEntity(pos.north());
      Objects.requireNonNull(node);
      nodes.add(node);
    } catch (Exception ignored) {}
    try {
      Node<EnergyNode> node = (Node<EnergyNode>) world.getBlockEntity(pos.east());
      Objects.requireNonNull(node);
      nodes.add(node);
    } catch (Exception ignored) {}
    try {
      Node<EnergyNode> node = (Node<EnergyNode>) world.getBlockEntity(pos.south());
      Objects.requireNonNull(node);
      nodes.add(node);
    } catch (Exception ignored) {}
    try {
      Node<EnergyNode> node = (Node<EnergyNode>) world.getBlockEntity(pos.west());
      Objects.requireNonNull(node);
      nodes.add(node);
    } catch (Exception ignored) {}
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
    if(this.getNetwork() != null){
      nbt.putString("network", this.getNetwork().ID.toString());
    }
    this.nodeProperties.writeNBT(nbt, registries);
  }
}
