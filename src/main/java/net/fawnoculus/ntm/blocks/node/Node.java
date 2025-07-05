package net.fawnoculus.ntm.blocks.node;

import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * A Node serves as the base Part of a Node-Network.
 * It can be a connector, provider, consumer or storage for a specific integer based value (Energy/Fluid)
 */
public interface Node<T extends BlockEntity>  {
  void setShouldAssignNetwork(boolean value);
  boolean shouldAssignNetwork();
  
  void setNetwork(NodeNetwork<T> network);
  @Nullable NodeNetwork<T> getNetwork();
  void assignNetwork();
  List<Node<T>> getConnectedNodes();
  
  void setNodeProperties(NodeProperties nodeProperties);
  NodeProperties getNodeProperties();
  
  BlockPos getPos();
  World getWorld();
  
  T getBE();
  
  default void onBreak(){
    if(this.getConnectedNodes().size() > 1 && this.getNetwork() != null){
      this.getNetwork().disconnectNode(this);
    }
    // the Node is unloaded after being broken, so there is no need to unset the Network
  }
  default void onUnload(){
    if(this.getNetwork() != null){
      this.getNetwork().removeNode(this);
    }
    setShouldAssignNetwork(false);
    this.setNetwork(null);
  }
}
