package net.fawnoculus.ntm.blocks.custom.node;

import net.fawnoculus.ntm.blocks.custom.node.network.NodeNetwork;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public interface Node<T>  {
  NodeNetwork<T> getNetwork();
  void setNetwork(NodeNetwork<T> network);
  NodeType getNodeType();
  void setNodeType(NodeType nodeType);
  BlockPos getPos();
  World getWorld();
  void assignNetwork();
  List<Node<T>> getConnectedNodes();
  T getNode();
  
  default void onBreak(){
    this.getNetwork().disconnectNode(this);
  }
}
