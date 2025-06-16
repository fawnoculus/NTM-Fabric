package net.fawnoculus.ntm.items.custom.consumable;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class BottleOpenerItem extends Item {
  public BottleOpenerItem(Settings settings) {
    super(settings.maxCount(1));
  }
  
  @Override
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    tooltip.accept(Text.translatable("tooltip.ntm.bottle_opener1").formatted(Formatting.GRAY));
    tooltip.accept(Text.translatable("tooltip.ntm.bottle_opener2").formatted(Formatting.GRAY));
  }
}
