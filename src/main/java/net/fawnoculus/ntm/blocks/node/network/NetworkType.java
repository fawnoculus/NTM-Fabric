package net.fawnoculus.ntm.blocks.node.network;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public interface NetworkType {
  default MutableText getName(){
    return Text.translatable(getTranslationKey());
  }
  String getTranslationKey();
  
  class Energy implements NetworkType{
    @Override
    public String getTranslationKey() {
      return "generic.ntm.network_type.energy";
    }
  }
  class Fluid implements NetworkType{
    @Override
    public String getTranslationKey() {
      return "generic.ntm.network_type.fluid";
    }
  }
}
