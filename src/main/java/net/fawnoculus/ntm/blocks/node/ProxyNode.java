package net.fawnoculus.ntm.blocks.node;

import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * This serves as a Proxy for another Node.
 * It will be useful for Multiblock Structures
 */
public interface ProxyNode<T extends BlockEntity> extends Node<T>{
  Node<T> getNode();
  
  default T getBE(){
    return this.getNode().getBE();
  }
  
  default void setShouldAssignNetwork(boolean value){
    this.getNode().setShouldAssignNetwork(value);
  }
  default boolean shouldAssignNetwork(){
    return this.getNode().shouldAssignNetwork();
  }
  
  @Override
  default void setNetwork(NodeNetwork<T> network){
    this.getNode().setNetwork(network);
  }
  @Override
  default @Nullable NodeNetwork<T> getNetwork(){
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
  default NodeProperties getNodeProperties(){
    return this.getNode().getNodeProperties();
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
