package net.fawnoculus.ntm.blocks.node;

import net.fawnoculus.ntm.blocks.node.network.EnergyNetwork;
import net.fawnoculus.ntm.blocks.node.network.NetworkType;
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

import java.util.UUID;
import java.util.function.Supplier;

public class EnergyNode extends BlockEntity implements Node<NetworkType.Energy> {
  private boolean shouldAssignNetwork = true;
  private NodeNetwork<NetworkType.Energy> network;
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
  public void setNetwork(NodeNetwork<NetworkType.Energy> network) {
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
  public @Nullable NodeNetwork<NetworkType.Energy> getNetwork() {
    if(this.network == null){
      this.assignNetwork();
    }
    return this.network;
  }
  
  @Override
  public NodeNetwork<NetworkType.Energy> makeNewNetwork() {
    return new EnergyNetwork();
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
      if(!this.network.containsNode(this)){
        this.network.addNode(this);
      }
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
