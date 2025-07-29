package net.fawnoculus.ntm.items.custom;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Collection;

public interface ExtraInfo {
  Collection<Text> getInfo();
  
  default Text getHelpText(Text extraInfoKeybind){
    return Text.translatable("tooltip.ntm.hold_for_info", extraInfoKeybind).formatted(Formatting.DARK_GRAY);
  }
}
