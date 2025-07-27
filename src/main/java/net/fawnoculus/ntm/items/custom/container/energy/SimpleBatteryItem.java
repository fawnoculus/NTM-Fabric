package net.fawnoculus.ntm.items.custom.container.energy;

import net.fawnoculus.ntm.items.ModDataComponentTypes;
import net.fawnoculus.ntm.util.TextUtil;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

import java.util.function.Consumer;

public class SimpleBatteryItem extends Item implements EnergyContainingItem {
  public SimpleBatteryItem(Settings settings, long maxEnergy, long chargeRate, long dischargeRate) {
    super(settings);
    this.MAX_ENERGY = maxEnergy;
    this.CHARGE = chargeRate;
    this.DISCHARGE = dischargeRate;
  }
  
  private final long MAX_ENERGY;
  private final long CHARGE;
  private final long DISCHARGE;
  
  @Override
  public long getEnergy(ItemStack stack) {
    return stack.getOrDefault(ModDataComponentTypes.ENERGY_COMPONENT_TYPE, 0L);
  }
  
  @Override
  public void setEnergy(ItemStack stack, long energy) {
    stack.set(ModDataComponentTypes.ENERGY_COMPONENT_TYPE, energy);
  }
  
  @Override
  public long getMaxEnergy(ItemStack stack) {
    return this.MAX_ENERGY;
  }
  
  @Override
  public long getChargeRate(ItemStack stack) {
    return this.CHARGE;
  }
  
  @Override
  public long getDischargeRate(ItemStack stack) {
    return this.DISCHARGE;
  }
  
  @Override
  public boolean isItemBarVisible(ItemStack stack) {
    return true;
  }
  
  @Override
  public int getItemBarColor(ItemStack stack) {
    float f = Math.max(0.0F, (float) this.getEnergyPercentage(stack) / 100);
    return MathHelper.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
  }
  
  @Override
  public int getItemBarStep(ItemStack stack) {
    return Math.clamp(this.getEnergy(stack) * 13 / this.getMaxEnergy(stack) , 0, 13);
  }
  
  @Override @SuppressWarnings("deprecation")
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    Text energy = TextUtil.unit(getEnergy(stack));
    Text maxEnergy = TextUtil.unit(getMaxEnergy(stack), "generic.ntm.energy");
    Text chargeRate = TextUtil.unit(getChargeRate(stack), "generic.ntm.energy_t");
    Text dischargeRate = TextUtil.unit(getDischargeRate(stack), "generic.ntm.energy_t");
    tooltip.accept(Text.translatable("tooltip.ntm.energy.stored", energy, maxEnergy));
    tooltip.accept(Text.translatable("tooltip.ntm.energy.charge", chargeRate));
    tooltip.accept(Text.translatable("tooltip.ntm.energy.discharge", dischargeRate));
  }
}
