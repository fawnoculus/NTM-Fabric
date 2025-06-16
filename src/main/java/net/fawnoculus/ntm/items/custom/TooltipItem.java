package net.fawnoculus.ntm.items.custom;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class TooltipItem extends Item {
  public TooltipItem(Settings settings) {
    super(settings);
  }
  
  @Override
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    tooltip.accept(Text.translatable("tooltip." + this.getTranslationKey().substring(5)).formatted(Formatting.GRAY));
  }
}
