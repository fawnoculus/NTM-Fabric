package net.fawnoculus.ntm.blocks.node.type;

import net.fawnoculus.ntm.blocks.node.NodeWithValue;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public interface ConsumerNode extends NodeWithValue {
  @Override
  default MutableText getNodeType(){
    return Text.translatable("generic.ntm.node_type.consumer");
  }
  
  @Override
  default boolean consumes() {
    return true;
  }
  
  @Override
  default boolean provides() {
    return false;
  }
}
