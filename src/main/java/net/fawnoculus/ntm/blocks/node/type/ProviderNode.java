package net.fawnoculus.ntm.blocks.node.type;

import net.fawnoculus.ntm.blocks.node.NodeWithValue;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public interface ProviderNode extends NodeWithValue {
  @Override
  default MutableText getNodeType(){
    return Text.translatable("generic.ntm.node_type.provider");
  }
  
  @Override
  default boolean consumes() {
    return false;
  }
  
  @Override
  default boolean provides() {
    return true;
  }
}
