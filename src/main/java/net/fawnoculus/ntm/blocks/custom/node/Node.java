package net.fawnoculus.ntm.blocks.custom.node;

import net.fawnoculus.ntm.blocks.custom.node.network.NodeNetwork;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface Node<T>  {
  NodeNetwork<T> getNetwork();
  void setNetwork(NodeNetwork<T> network);
  NodeType getNodeType();
  void setNodeType(NodeType nodeType);
  BlockPos getPos();
  World getWorld();
  void assignNetwork();
  
  default void onBreak(){
    this.getNetwork().removeNode(this);
  }
  
}
