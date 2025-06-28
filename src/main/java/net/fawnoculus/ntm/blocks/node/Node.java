package net.fawnoculus.ntm.blocks.node;

import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

/**
 * A Node serves as the base Part of a Node-Network.
 * It can be a connector, provider, consumer or storage for a specific integer based value (Energy/Fluid)
 */
public interface Node<T extends BlockEntity>  {
  void setNetwork(NodeNetwork<T> network);
  NodeNetwork<T> getNetwork();
  void assignNetwork();
  List<Node<T>> getConnectedNodes();
  
  void setNodeProperties(NodeProperties nodeProperties);
  NodeProperties getNodeType();
  
  BlockPos getPos();
  World getWorld();
  
  T getBE();
  
  default void onBreak(){
    this.getNetwork().disconnectNode(this);
  }
}
