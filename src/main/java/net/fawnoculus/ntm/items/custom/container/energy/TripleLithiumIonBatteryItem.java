package net.fawnoculus.ntm.items.custom.container.energy;

import net.fawnoculus.ntm.util.TextUtil;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class TripleLithiumIonBatteryItem extends SimpleBatteryItem {
  public TripleLithiumIonBatteryItem(Settings settings) {
    super(settings, 2_250_000L, 1_000L);
  }

  @Override
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    Text energy = TextUtil.unit(getEnergy(stack));
    Text maxEnergy = TextUtil.unit(getMaxEnergy(stack), "generic.ntm.energy");
    Text chargeRate = unitWithExtraDigit(getChargeRate(stack)).append(Text.translatable("generic.ntm.energy_t"));
    Text dischargeRate = TextUtil.unit(getDischargeRate(stack), "generic.ntm.energy_t");
    tooltip.accept(Text.translatable("tooltip.ntm.energy.stored", energy, maxEnergy).formatted(Formatting.GRAY));
    tooltip.accept(Text.translatable("tooltip.ntm.energy.charge", chargeRate).formatted(Formatting.GRAY));
    tooltip.accept(Text.translatable("tooltip.ntm.energy.discharge", dischargeRate).formatted(Formatting.GRAY));
  }

  // Why couldn't HBM just slightly adjust the Max energy, then this goofy shit would not be necessary
  private static MutableText unitWithExtraDigit(long val) {
    if (val >= 1_000_000_000_000_000_000L) {
      return Text.translatable("generic.ntm.unit.e", String.format("%.2f", val / 1_000_000_000_000_000_000.0));
    }
    if (val >= 1_000_000_000_000_000L) {
      return Text.translatable("generic.ntm.unit.p", String.format("%.2f", val / 1_000_000_000_000_000.0));
    }
    if (val >= 1_000_000_000_000L) {
      return Text.translatable("generic.ntm.unit.t", String.format("%.2f", val / 1_000_000_000_000.0));
    }
    if (val >= 1_000_000_000L) {
      return Text.translatable("generic.ntm.unit.g", String.format("%.2f", val / 1_000_000_000.0));
    }
    if (val >= 1_000_000L) {
      return Text.translatable("generic.ntm.unit.m", String.format("%.2f", val / 1_000_000.0));
    }
    if (val >= 1_000L) {
      return Text.translatable("generic.ntm.unit.k", String.format("%.2f", val / 1_000.0));
    }
    return Text.literal(String.valueOf(val));
  }
}
