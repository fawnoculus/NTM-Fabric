package net.fawnoculus.ntm.items.custom.container.energy;

import net.fawnoculus.ntm.blocks.node.NodeProperties;
import net.fawnoculus.ntm.util.TextUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Range;

import java.util.function.Consumer;

public interface EnergyContainingItem {
  
  long getEnergy(ItemStack stack);
  void setEnergy(ItemStack stack, long energy);
  long getMaxEnergy(ItemStack stack);
  long getChargeRate(ItemStack stack);
  long getDischargeRate(ItemStack stack);
  
  default boolean hasEnergy(ItemStack stack, long energy){
    return this.getEnergy(stack) >= energy;
  }
  default void decreaseEnergy(ItemStack stack, long energy){
    this.setEnergy(stack, this.getMaxEnergy(stack) - energy);
  }
  default void increaseEnergy(ItemStack stack, long energy){
    this.setEnergy(stack, this.getMaxEnergy(stack) + energy);
  }
  
  /**
   * @param stack the Stack to be Charged
   * @param energy the amount of energy to be inserted
   * @return the remaining energy that the item could not hold
   */
  default @Range(from = 0, to = Long.MAX_VALUE) long charge(ItemStack stack, long energy){
    long possibleCharge = this.getMaxEnergy(stack) - this.getEnergy(stack);
    if(possibleCharge > this.getChargeRate(stack)){
      possibleCharge = this.getChargeRate(stack);
    }
    if(energy > possibleCharge){
      this.setEnergy(stack, this.getEnergy(stack) + possibleCharge);
      return energy - possibleCharge;
    }
    this.setEnergy(stack, this.getEnergy(stack) + energy);
    return 0;
  }
  default void charge(ItemStack stack, NodeProperties nodeProperties){
    long energy = nodeProperties.getValue();
    energy = this.charge(stack, energy);
    nodeProperties.setValue(energy);
  }
  /**
   * @param stack the Stack to be Discharged
   * @param energy the amount of energy to be removed
   * @return the remaining energy that could not be removed
   */
  default @Range(from = 0, to = Long.MAX_VALUE) long discharge(ItemStack stack, long energy){
    long possibleDischarge = this.getEnergy(stack);
    if(possibleDischarge > this.getDischargeRate(stack)){
      possibleDischarge = this.getDischargeRate(stack);
    }
    if(energy > possibleDischarge){
      this.setEnergy(stack, this.getEnergy(stack) - possibleDischarge);
      return energy - possibleDischarge;
    }
    this.setEnergy(stack, this.getEnergy(stack) - energy);
    return 0;
  }
  default void discharge(ItemStack stack, NodeProperties nodeProperties){
    long missingEnergy = nodeProperties.getMaxValue() - nodeProperties.getValue();
    missingEnergy = this.discharge(stack, missingEnergy);
    nodeProperties.setValue(nodeProperties.getMaxValue() - missingEnergy);
  }
  
  default double getEnergyPercentage(ItemStack stack){
    return (double) this.getEnergy(stack) / (double) this.getMaxEnergy(stack) * 100;
  }
  
  default int energyBarColor(ItemStack stack){
    float f = Math.max(0.0F, (float) this.getEnergyPercentage(stack) / 100);
    return MathHelper.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
  }
  default int energyBarStep(ItemStack stack){
    return Math.clamp(this.getEnergy(stack) * 13 / this.getMaxEnergy(stack) , 0, 13);
  }
  
  default void energyTooltip(ItemStack stack, Consumer<Text> tooltip){
    Text energy = TextUtil.unit(getEnergy(stack));
    Text maxEnergy = TextUtil.unit(getMaxEnergy(stack), "generic.ntm.energy");
    Text chargeRate = TextUtil.unit(getChargeRate(stack), "generic.ntm.energy_t");
    Text dischargeRate = TextUtil.unit(getDischargeRate(stack), "generic.ntm.energy_t");
    tooltip.accept(Text.translatable("tooltip.ntm.energy.stored", energy, maxEnergy));
    tooltip.accept(Text.translatable("tooltip.ntm.energy.charge", chargeRate));
    tooltip.accept(Text.translatable("tooltip.ntm.energy.discharge", dischargeRate));
  }
}
