package net.fawnoculus.ntm.blocks.node;

import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

/**
 * This serves as a Proxy for another Node.
 * It will be useful for Multiblock Structures
 */
public interface ProxyNode<T extends BlockEntity> extends Node<T>{
  Node<T> getNode();
  
  @Override
  default void setNetwork(NodeNetwork<T> network){
    this.getNode().setNetwork(network);
  }
  @Override
  default NodeNetwork<T> getNetwork(){
    return this.getNode().getNetwork();
  }
  @Override
  default void assignNetwork(){
    this.getNode().assignNetwork();
  }
  
  @Override
  default void setNodeProperties(NodeProperties nodeProperties){
    this.getNode().setNodeProperties(nodeProperties);
  }
  @Override
  default NodeProperties getNodeType(){
    return this.getNode().getNodeType();
  }
  
  @Override
  default BlockPos getPos(){
    return this.getNode().getPos();
  }
  @Override
  default World getWorld(){
    return this.getNode().getWorld();
  }
  @Override
  default List<Node<T>> getConnectedNodes(){
    return this.getNode().getConnectedNodes();
  }
}
