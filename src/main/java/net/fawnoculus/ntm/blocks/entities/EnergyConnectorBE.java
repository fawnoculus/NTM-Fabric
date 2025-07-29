package net.fawnoculus.ntm.blocks.entities;

import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
import net.fawnoculus.ntm.blocks.node.type.ConnectorNode;
import net.fawnoculus.ntm.blocks.node.type.EnergyNode;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EnergyConnectorBE extends BlockEntity implements EnergyNode, ConnectorNode {
  private boolean shouldAssignNetwork = false;
  public NodeNetwork network;
  
  public EnergyConnectorBE(BlockPos pos, BlockState state) {
    super(ModBlockEntities.SIMPLE_ENERGY_CONNECTOR_BE, pos, state);
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
  public void setNetwork(NodeNetwork network) {
    this.network = network;
  }
  
  @Override
  public @Nullable NodeNetwork getNetwork() {
    return this.network;
  }
  
  @Override
  public void setWorld(World world) {
    super.setWorld(world);
    this.setShouldAssignNetwork(true);
    if(world.isClient){
      return;
    }
    if(this.network == null){
      this.assignNetwork();
    }
  }
  
  @Override
  public void markRemoved() {
    super.markRemoved();
    this.onUnload();
  }
  
  @Override
  public void onBlockReplaced(BlockPos pos, BlockState oldState) {
    super.onBlockReplaced(pos, oldState);
    this.onBreak();
  }
  
  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    super.readNbt(nbt, registries);
    this.readNodeData(nbt, registries);
  }
  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
    super.writeNbt(nbt, registries);
    this.writeNodeData(nbt, registries);
  }
}
