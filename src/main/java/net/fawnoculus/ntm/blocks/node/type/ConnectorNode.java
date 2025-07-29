package net.fawnoculus.ntm.blocks.node.type;

import net.fawnoculus.ntm.blocks.node.Node;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public interface ConnectorNode extends Node {
  @Override
  default MutableText getNodeType(){
    return Text.translatable("generic.ntm.node_type.connector");
  }
}
