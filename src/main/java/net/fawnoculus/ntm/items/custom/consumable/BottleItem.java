package net.fawnoculus.ntm.items.custom.consumable;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;
import java.util.function.Consumer;

public class BottleItem extends Item {
  public final List<StatusEffectInstance> EFFECTS;
  public final List<Item> RETURN_ITEMS;
  
  
  public BottleItem(Settings settings, List<StatusEffectInstance> effects, List<Item> returnItems) {
    super(settings);
    
    this.EFFECTS = effects;
    this.RETURN_ITEMS = returnItems;
  }
  
  @Override
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    tooltip.accept(Text.translatable("tooltip." + this.getTranslationKey().substring(5)));
    tooltip.accept(Text.translatable("tooltip.ntm.needs_bottle_opener"));
  }
}
