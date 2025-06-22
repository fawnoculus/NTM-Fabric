package net.fawnoculus.ntm.items.custom;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class TooltipItem extends Item {
  private final int TOOLTIP_COUNT;
  
  public TooltipItem(Settings settings) {
    this(settings, 1);
  }
  public TooltipItem(Settings settings, int tooltipCount) {
    super(settings);
    
    this.TOOLTIP_COUNT = tooltipCount;
  }
  
  @Override
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    if(this.TOOLTIP_COUNT == 1){
      tooltip.accept(Text.translatable("tooltip." + this.getTranslationKey().substring(5)).formatted(Formatting.GRAY));
      return;
    }
    for (int i = 1; i <= this.TOOLTIP_COUNT; i++) {
      tooltip.accept(Text.translatable("tooltip." + this.getTranslationKey().substring(5) + i).formatted(Formatting.GRAY));
    }
  }
}
