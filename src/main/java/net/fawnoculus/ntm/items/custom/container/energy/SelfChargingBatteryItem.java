package net.fawnoculus.ntm.items.custom.container.energy;

import net.fawnoculus.ntm.util.TextUtil;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class SelfChargingBatteryItem extends Item implements EnergyContainingItem {
  public SelfChargingBatteryItem(Settings settings, long energyPerTick) {
    super(settings.maxCount(1));
    this.ENERGY_PER_TICK = energyPerTick;
  }

  private final long ENERGY_PER_TICK;

  @Override
  public long getEnergy(ItemStack stack) {
    return Long.MAX_VALUE;
  }

  @Override
  public void setEnergy(ItemStack stack, long energy) {
  }

  @Override
  public long getMaxEnergy(ItemStack stack) {
    return Long.MAX_VALUE;
  }

  @Override
  public long getChargeRate(ItemStack stack) {
    return 0;
  }

  @Override
  public long getDischargeRate(ItemStack stack) {
    return this.ENERGY_PER_TICK;
  }

  @Override
  @SuppressWarnings("deprecation")
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    tooltip.accept(TextUtil.unit(this.ENERGY_PER_TICK, "generic.ntm.energy_t").formatted(Formatting.YELLOW));
  }
}
